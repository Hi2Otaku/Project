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
import Models.*;
import DAL.*;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hi2ot
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String o1 = request.getParameter("Registor");
        String o2 = request.getParameter("Back");
        String o3 = request.getParameter("Forget");
        if (o1 != null) {            
                response.sendRedirect(request.getContextPath() + "/Registor");            
        } else if (o2 != null) {            
                response.sendRedirect(request.getContextPath() + "/MainPage");            
        } else if (o3 != null) {
                response.sendRedirect(request.getContextPath() + "/ForgetPassword");
        } else {
            request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
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
        String u = request.getParameter("u");
        String p = request.getParameter("p");        
        if (LoginCheck(u, p)) {
            DAO.INS.loadAll();
            Users us = new Users();
            for (Users var : DAO.INS.getUl()) {
                if (var.getUserName().equals(u) && var.getPass().equals(p)) {
                    us = var;
                }
            }
            HttpSession ses = request.getSession();            
            ses.setAttribute("us", us);
            response.sendRedirect(request.getContextPath() + "/MainPage");
        } else {
            request.setAttribute("err", "Login Failed: Wrong UserName or Password");
            doGet(request, response);
        }
    }

    public boolean LoginCheck(String name, String pass) {
        DAO.INS.loadAll();
        for (Users u : DAO.INS.getUl()) {
            if (u.getUserName().equals(name) && u.getPass().equals(pass)) {
                return true;
            }
        }
        return false;
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
