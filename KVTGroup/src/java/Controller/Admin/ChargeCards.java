/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Models.DAO.ChargeDAO;
import Models.Entities.Charge;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinhhqce140143
 */
@WebServlet(name = "ChargeCards", urlPatterns = {"/admin/ChargeCards"})
@MultipartConfig
public class ChargeCards extends HttpServlet {

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
            out.println("<title>Servlet ChargeCards</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChargeCards at " + request.getContextPath() + "</h1>");
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
        int selectedItem = 0;
        String randomNumberOfCards;
        int i = 0;
        boolean found = false;
        PrintWriter out = response.getWriter();

        // get  data from jsp 
        int numberOfCards = Integer.parseInt(request.getParameter("numberofcard"));
        if (request.getParameter("cards") != null) {
            //get selectedItem from jsp
            selectedItem = Integer.parseInt(request.getParameter("cards"));

        }
        ChargeDAO chargeDAO = new ChargeDAO();
        do {
            //create random number
            randomNumberOfCards = getCardNumber(16);
            //check if number is found will continute
            if (chargeDAO.numberOfCardIsFound(randomNumberOfCards)) {
                continue;
            } else {
                //create new card
                Charge obj = new Charge();
                //set new number
                obj.setChargecardNumber(randomNumberOfCards);
                obj.setChargeTaken(0);
                obj.setChargeUsed(0);
                obj.setChargeValue(selectedItem);
                chargeDAO.addCard(obj);
                //set found flag is true 
                found = true;
            }
            //increate i to get next numberofcard
            i++;
        } while (i < numberOfCards);
        //if found is true will alert Add successful
        if (found) {
            out.print("<script>alert('Add successful')</script>");
            out.print("<script>window.location.href='Charge.jsp'</script>");
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
    /**
     * method get random number
     * @param numSize
     * @return 
     */
    private String getCardNumber(int numSize) {
        Random rand = new Random();
        StringBuffer number = new StringBuffer();
        //get number < numbersize
        //ex 16 number
        while (number.length() < numSize) {
            // Generates a random number between 0x10 and 0x99
            int myRandomNumber = rand.nextInt(0x99) + 0x10;
            number.append(Integer.toHexString(myRandomNumber));
        }

        return number.toString();
    }
}
