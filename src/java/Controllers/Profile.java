/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAL.*;
import Models.*;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hi2ot
 */
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        Users us = (Users) ses.getAttribute("us");
        String log = request.getParameter("Logout");
        String cha = request.getParameter("cha");
        if (log != null) {
            ses.setAttribute("us", null);
            response.sendRedirect(request.getContextPath() + "/MainPage");
        } else if (cha != null) {
            response.sendRedirect(request.getContextPath() + "/ChangePassword");
        } else {
            DAO.INS.loadAll();
            if (us.getRole() == 2) {
                request.setAttribute("role", "User");
                request.setAttribute("bl", DAO.INS.getBItem(us.getUserName()));
            } else {               
                request.setAttribute("role", "Publisher");
                request.setAttribute("bl", DAO.INS.getPItem(us.getUserName()));
            }
            request.setAttribute("us", us);
            request.getRequestDispatcher("/Views/Profile.jsp").forward(request, response);
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
        doGet(request, response);
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
