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
import java.util.*;

/**
 *
 * @author hi2ot
 */
public class Registor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO.INS.loadAll();
        request.setAttribute("sl", DAO.INS.getSl());
        String o1 = request.getParameter("Login");
        if (o1 != null) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } else {
            request.getRequestDispatcher("/Views/Registor.jsp").forward(request, response);
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
        String rp = request.getParameter("rp");
        if (p != null && p.equals(rp) == false) {
            request.setAttribute("err", "Two password are not the same!");
            doGet(request, response);
        } else {
            String otp = request.getParameter("otp");
            if (otp == null) {
                Random rd = new Random();
                String num = new String();
                for (int i = 1; i <= 6; i++) {
                    int n = rd.nextInt() % 100;
                    num += String.valueOf((n * n) % 10);
                }
                String dob = request.getParameter("dob");
                String mail = request.getParameter("mail");
                int sq = Integer.parseInt(request.getParameter("sq"));
                String sa = request.getParameter("sa");
                DAO.INS.addUser(u, p, dob, -1, mail, sq, sa);   
                request.setAttribute("otp", num);                
                request.setAttribute("u", u);
                doGet(request, response);
            } else {
                String otp2 = request.getParameter("otp2");
                if (otp.equals(otp2) == false) {
                    DAO.INS.delUser(request.getParameter("u"));
                    response.sendRedirect(request.getContextPath() + "/MainPage");
                } else {
                    DAO.INS.updUser(request.getParameter("u"));
                    response.sendRedirect(request.getContextPath() + "/Login");
                }
            }
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
