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
import jakarta.servlet.http.HttpSession;
import Models.*;
import DAL.*;

/**
 *
 * @author hi2ot
 */
public class ChangePassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/ChangePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        String p = request.getParameter("p");
        String rp = request.getParameter("rp");
        HttpSession ses = request.getSession();
        Users us = (Users) ses.getAttribute("us");
        if (us.getPass().equals(op) == false) {
            request.setAttribute("err", "Old Password is not valid!");
            doGet(request, response);
        } else if (p.equals(rp) == false) {
            request.setAttribute("err", "Re-Enter Password doesn't match!");
            doGet(request, response);
        } else {
            DAO.INS.updPass(us.getUserName(), p);
            us.setPass(p);
            ses.setAttribute("us", us);
            response.sendRedirect(request.getContextPath() + "/MainPage");
        }
    }
}
