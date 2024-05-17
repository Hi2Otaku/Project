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
import java.util.*;

/**
 *
 * @author hi2ot
 */
public class MainPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String o1 = request.getParameter("type");
        Object o2 = request.getParameter("logged");
        HttpSession ses = request.getSession();
        if (o2 == null) {
            request.setAttribute("logged", true);
        }
        if (o1 != null) {
            int type = Integer.parseInt(o1);
            if (type == 1) {
                response.sendRedirect(request.getContextPath() + "/Login");
            } else if (type == 0) {
                ses.setAttribute("us", null);
                request.setAttribute("logged", true);
                request.setAttribute("role", null);
                DAO.INS.loadAll();
                List<Items> ss = DAO.INS.gettop3();
                request.setAttribute("t1", (Items) ss.get(0));
                request.setAttribute("t2", (Items) ss.get(1));
                request.setAttribute("t3", (Items) ss.get(2));
                request.setAttribute("t4", (Items) ss.get(3));
                request.setAttribute("dao", DAO.INS);
                request.getRequestDispatcher("Views/MainPage.jsp").forward(request, response);
            } else if (type == 3) {
                response.sendRedirect(request.getContextPath() + "/Profile");
            } else if (type == 2) {
                response.sendRedirect(request.getContextPath() + "/AddItems");
            } else if (type == 4) {
                response.sendRedirect(request.getContextPath() + "/Store");
            }
        } else {
            if (ses.getAttribute("us") != null) {
                Users u = (Users) ses.getAttribute("us");
                request.setAttribute("role", u.getRole());
                request.setAttribute("logged", false);
            }
            DAO.INS.loadAll();
            List<Items> ss = DAO.INS.gettop3();
            request.setAttribute("t1", (Items) ss.get(0));
            request.setAttribute("t2", (Items) ss.get(1));
            request.setAttribute("t3", (Items) ss.get(2));
            request.setAttribute("t4", (Items) ss.get(3));
            request.setAttribute("dao", DAO.INS);
            request.getRequestDispatcher("Views/MainPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
