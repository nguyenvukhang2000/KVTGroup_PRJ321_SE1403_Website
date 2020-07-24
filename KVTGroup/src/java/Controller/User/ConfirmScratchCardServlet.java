/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.User;

import Models.DAO.ScratchCardDAO;
import Models.DAO.UserDAO;
import Models.Entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * check card number to get cash
 * @author KhangNVCE140224
 */
@WebServlet(name = "ConfirmScratchCardServlet", urlPatterns = {"/ConfirmScratchCardServlet"})
public class ConfirmScratchCardServlet extends HttpServlet {

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
            out.println("<title>Servlet ConfirmScratchCardServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmScratchCardServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        User user = (User) request.getSession().getAttribute("LoginUser"); //get user after login success
        int userId = user.getuId(); //get id of user
        double cash = user.getuCash(); //get cash current of user 

        String cartStr = request.getParameter("CardStr");

        ScratchCardDAO scratchCardDAO = new ScratchCardDAO(); //creates a new object ScratchCard
        boolean exist = scratchCardDAO.checkCardExistForUser(cartStr); //check card has exist for user
        //if card exist 
        if (exist) {
            try {
                int value = scratchCardDAO.getValueFromNumber(cartStr); //gets card value select by user
                scratchCardDAO.setCardUsed(cartStr); //after user already get card then convert scratch card to used
                cash += value; //cash increase by card value of user select
                UserDAO userDAO = new UserDAO(); //create a new object UsersDAO
                user.setuCash(cash); //set cash after recharge scratch card
                boolean cashAdded = userDAO.updateUserBalance(user);  //update user to add cash
                if (cashAdded) { //if cash already add
                    request.setAttribute("message", "The Cash added to your balance successfully"); //show message
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp"); //move to Success.jsp
                    dispatcher.forward(request, response);
                } else { //if cash not add
                    request.setAttribute("message", "Error , cash is not added please check your balance and try again "); //show message
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Failed.jsp"); //move to Failed.jsp
                    dispatcher.forward(request, response);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else { //if card is not exist
            request.setAttribute("message", "Error , This Card is invalid please try again later "); //show message
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Failed.jsp"); //move to Failed.jsp
            dispatcher.forward(request, response);
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
