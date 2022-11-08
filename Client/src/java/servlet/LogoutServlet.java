/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Utils.AccessControlHeader;
import Utils.HandleErrorResponse;
import Utils.HandleJWTsCookie;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thom
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/api-logout"})
public class LogoutServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final HandleErrorResponse err = new HandleErrorResponse();
    private final AccessControlHeader setACH = new AccessControlHeader();
    private final HandleJWTsCookie jwtCoo = new HandleJWTsCookie();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Request-Headers", "X-Requested-With, accept, content-type");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        setACH.setAccessControlHeaders(response);
        try (PrintWriter out = response.getWriter()) {
                  
                Cookie[] arr_cookie = request.getCookies();
                if (arr_cookie != null && arr_cookie.length > 0) {
                    for (Cookie cookie : arr_cookie) {
                        if(cookie.getName().equals("_cfduid")){
                            boolean exp = isTokenExpired(cookie.getValue());
                            if(exp){
                                out.write(this.gson.toJson(err.handleResponse(0, "Đăng xuất thành công!", null, null)));
                                cookie = new Cookie("_cfduid", "");
                                cookie.setMaxAge(0);
                                response.addCookie(cookie);
                                break;
                            }else{
                                out.write(this.gson.toJson(err.handleResponse(-201, "Cookie đã hết hạn", null, null)));
                                cookie = new Cookie("_cfduid", "");
                                cookie.setMaxAge(0);
                                response.addCookie(cookie);
                                break;
                            }
                        }
                    }
                }else{
                    out.write(this.gson.toJson(err.handleResponse(-201, "Không có cookie", null, null)));
                }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
//    
    private Boolean isTokenExpired(String token) {
        try {
            Jws<Claims> jws = jwtCoo.parseJwt(token);
            Claims claims = jws.getBody();
            
            Date expiration = claims.getExpiration();
            
            return expiration.after(new Date());


        } catch (Exception e) {
            return false;
        }
    }
}
