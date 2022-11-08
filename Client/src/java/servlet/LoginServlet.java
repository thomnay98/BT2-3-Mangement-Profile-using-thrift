/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Utils.AccessControlHeader;
import Utils.HandleErrorResponse;
import Utils.HandleJWTsCookie;
import Utils.PWSecurity;
import client.Client;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.jsonwebtoken.Claims;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.spy.memcached.MemcachedClient;
import thrift.User;

/**
 *
 * @author thom
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/api-login"})
public class LoginServlet extends HttpServlet{
    private final Gson gson = new Gson();
    private final PWSecurity pw = new PWSecurity();
    private final HandleErrorResponse err = new HandleErrorResponse();
    private final AccessControlHeader setACH = new AccessControlHeader();
    private final HandleJWTsCookie jwtCoo = new HandleJWTsCookie();
    
    protected MemcachedClient mcc = null;

    private static final long serialVersionUID = 1L;  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        //response.setHeader("Set-Cookie", "key=value; HttpOnly; SameSite=none");
        setACH.setAccessControlHeaders(response);
        try (PrintWriter out = response.getWriter()) {
            
                JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
                User user = new User();

                String lgEmail = data.get("email").getAsString();
                String lgPw = data.get("password").getAsString();       

                if(lgEmail.isEmpty() || lgPw.isEmpty()){
                    out.write(this.gson.toJson(err.handleResponse(-201, "Email, mật khẩu không được để trống.", null, null)));
                    out.flush();
                }else{
                    
                    Client tClient = new Client();
                    user = tClient.loginUser(lgEmail, pw.securedPassword(lgPw));

                    if(user.getId() != 0){

                        String jwt = jwtCoo.encryptCookie(lgEmail, pw.securedPassword(lgPw));
                        Claims claims = jwtCoo.parseJwt(jwt).getBody();
                        
                        claims.getExpiration();

                        Cookie ckEmail = new Cookie ("_cfduid", jwt);
                        ckEmail.setHttpOnly(true);
                        
                        Date date = new Date();
                        int exp = (int) claims.get("exp") - (int) (date.getTime()/1000);
                        ckEmail.setMaxAge(exp);
                        response.addCookie(ckEmail);
//                        response.setHeader("Set-Cookie", "_cfduid="+jwt+"; Expires="+claims.getExpiration()+"; HttpOnly");
                        out.write(this.gson.toJson(err.handleResponse(0, "Đăng nhập thành công!", null, user)));
                        out.flush();
                    }else{
                        out.write(this.gson.toJson(err.handleResponse(-201, "Sai Email hoặc mật khẩu!", null, null)));
                        out.flush();
                    }
                }

        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }
    
}
