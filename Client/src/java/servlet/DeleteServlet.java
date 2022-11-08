/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Utils.AccessControlHeader;
import Utils.HandleErrorResponse;
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

/**
 *
 * @author thom
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/api-delete"})
public class DeleteServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final HandleErrorResponse err = new HandleErrorResponse();
    private final AccessControlHeader setACH = new AccessControlHeader();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        setACH.setAccessControlHeaders(response);
        
        try (PrintWriter out = response.getWriter()) {
            
            JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
            
            String lgEmail = data.get("email").getAsString();
            
            Client tClient = new Client();
            boolean isDeleteSuccess = tClient.deleteUser(lgEmail);
            
            if(lgEmail.isEmpty()){
                out.write(this.gson.toJson(err.handleResponse(-201, "Email không được để trống!", null, null)));
                out.flush();
            }else if(isDeleteSuccess){
                out.write(this.gson.toJson(err.handleResponse(0, "Xóa thành công!", null, null)));
                out.flush();
            }else{
                out.write(this.gson.toJson(err.handleResponse(-201, "Email không tồn tại!", null, null)));
                out.flush();
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
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
