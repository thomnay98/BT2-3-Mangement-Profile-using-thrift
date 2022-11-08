/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Utils.AccessControlHeader;
import Utils.HandleErrorResponse;
import Utils.PWSecurity;
import client.Client;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thrift.User;

/**
 *
 * @author thom
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/api-register"})
public class RegisterServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final PWSecurity pw = new PWSecurity();
    private final HandleErrorResponse err = new HandleErrorResponse();
    private final AccessControlHeader setACH = new AccessControlHeader();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        setACH.setAccessControlHeaders(response);
        
        try (PrintWriter out = response.getWriter()) {
            JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
            
            if(data.get("name").getAsString().isEmpty() || data.get("email").getAsString().isEmpty() 
                    || data.get("password").getAsString().isEmpty()){
  
                out.write(this.gson.toJson(err.handleResponse(-201, "Lỗi! Tên, email, mk không đc để trống.", null, null)));
                out.flush();

            }else{
                User user = new User();
                user.setName(data.get("name").getAsString());
                user.setEmail(data.get("email").getAsString());
                user.setPassword(pw.securedPassword(data.get("password").getAsString()));
                user.setAddress(data.get("address").getAsString());
                user.setPhone(data.get("phone").getAsString());

                Client tClient = new Client();
                boolean isSuccess = tClient.registerUser(user);

                if(isSuccess){
                    out.write(this.gson.toJson(err.handleResponse(0, "Đăng kí thành công!", null, user)));
                    out.flush();
                }else{
                    out.write(this.gson.toJson(err.handleResponse(-201, "Email đã tồn tại!", null, null)));
                    out.flush();
                }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
