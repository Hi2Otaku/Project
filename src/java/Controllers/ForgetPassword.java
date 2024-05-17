/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hi2ot
 */
public class ForgetPassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO.INS.loadAll();
        req.setAttribute("sl", DAO.INS.getSl());
        req.getRequestDispatcher("/Views/ForgetPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO.INS.loadAll();
        String u = req.getParameter("u");
        String sq = req.getParameter("sq");
        String sa = req.getParameter("sa");
        Users rep = null;        
        for (Users us : DAO.INS.getUl()) {
            if (us.getUserName().equals(u)) {
                rep = us;
            }
        }
        String p = req.getParameter("p");
        String rp = req.getParameter("rp");
        if (p != null) {
            if (p.equals(rp) == true) {
                DAO.INS.updPass(u, p);
                resp.sendRedirect(req.getContextPath() + "/Login");
            }
            else {
                req.setAttribute("err", "Two password are not the same!");
                req.setAttribute("u", u);
                req.setAttribute("infocheck", 1);
                doGet(req, resp);
            }                 
        } else if (rep != null) {
            if (rep.getSQ_Id() == Integer.parseInt(sq) && rep.getSAnswer().equals(sa)) {
                req.setAttribute("u", u);
                req.setAttribute("infocheck", 1);
            } else {
                req.setAttribute("err", "Infomation is not valid!");
            }
            doGet(req, resp);
        } else {            
            req.setAttribute("err", "Infomation is not valid!");
            doGet(req, resp);
        }
    }

}
