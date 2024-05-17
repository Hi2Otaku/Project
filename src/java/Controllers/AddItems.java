/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Category;
import Models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

/**
 *
 * @author hi2ot
 */
public class AddItems extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO.INS.loadAll();
        request.setAttribute("cl", DAO.INS.getCl());
        request.getRequestDispatcher("/Views/AddItems.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String img = request.getParameter("img");
        String da = request.getParameter("date");
        HttpSession ses = request.getSession();
        Users us = (Users) ses.getAttribute("us");
        DAO.INS.loadAll();
        Vector<Integer> li = new Vector<Integer>();
        for (Category ct : DAO.INS.getCl()) {
            if (request.getParameter("chk" + ct.getId()) != null) {
                li.add(ct.getId());
            }
        }
        DAO.INS.addItems(name, Float.parseFloat(price), img, da, us.getUserName(), li);
        doGet(request, response);
    }
}
