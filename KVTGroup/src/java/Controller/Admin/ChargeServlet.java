/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Models.DAO.ChargeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinhhqec140143
 */
@WebServlet(name = "ChargeServlet", urlPatterns = {"/admin/ChargeServlet"})
public class ChargeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChargeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChargeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        ChargeDAO chargeDAO = new ChargeDAO();
        PrintWriter out = response.getWriter();
        //increate card with 50
        int SumCard50 = chargeDAO.getSumCardNumber(50000);
        //set attribute is new card 50
        request.setAttribute("SumCard50", SumCard50);
        //incraete card with 100
        int SumCard100 = chargeDAO.getSumCardNumber(100000);
        //set attrubute is new card 100
        request.setAttribute("SumCard100", SumCard100);
        //increate card with 200
        int SumCard200 = chargeDAO.getSumCardNumber(200000);
        //set attribute is new card 200
        request.setAttribute("SumCard200", SumCard200);
        //increate card with 500
        int SumCard500 = chargeDAO.getSumCardNumber(500000);
        //set attribute with new card 500
        request.setAttribute("SumCard500", SumCard500);
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
        processRequest(request, response);
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
