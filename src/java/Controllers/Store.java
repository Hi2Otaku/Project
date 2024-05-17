/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.*;
import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;

/**
 *
 * @author hi2ot
 */
public class Store extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tp = request.getParameter("ToProfile");
        String type = request.getParameter("type");
        HttpSession ses = request.getSession();
        DAO.INS.loadAll();

        if (tp != null) {
            response.sendRedirect(request.getContextPath() + "/Profile");
        } else {
            if (type != null) {
                int t = Integer.parseInt(type);
                Users us = (Users) ses.getAttribute("us");
                DAO.INS.addBought(us.getUserName(), t);
            }
            Vector<Integer> li = new Vector<Integer>();
            Vector<Category> ftl = new Vector<Category>();
            for (Category ct : DAO.INS.getCl()) {
                if (request.getParameter("chk" + ct.getId()) != null) {
                    li.add(ct.getId());
                    ftl.add(ct);
                }
            }
            List<Items> it = DAO.INS.getGItem(li);
            request.setAttribute("us", ses.getAttribute("us"));
            request.setAttribute("dao", DAO.INS);
            if (it.size() == 0) {
                request.setAttribute("il", DAO.INS.getli());
            } else {
                request.setAttribute("il", it);
            }
            request.setAttribute("cl", DAO.INS.getCl());

            request.setAttribute("ftl", ftl);

            request.getRequestDispatcher("Views/Store.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
