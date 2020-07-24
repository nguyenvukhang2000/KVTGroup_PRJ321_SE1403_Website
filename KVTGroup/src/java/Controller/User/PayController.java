/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.User;

import Models.DAO.CartsDAO;
import Models.DAO.PaysDAO;
import Models.Entities.CartProduct;
import Models.Entities.User;
import Models.utilize.MailModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * To process pay operation
 * @author KhangNVCE140224
 */
@WebServlet(name = "PayController", urlPatterns = {"/PayController"})
public class PayController extends HttpServlet {

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
            out.println("<title>Servlet PayController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PayController at " + request.getContextPath() + "</h1>");
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
        CartsDAO cartsDAO = new CartsDAO(); //create a new object of CartsDAO
        double total  = 0;
        String message = "";
        
        //get user from session
        User user = (User)request.getSession().getAttribute("LoginUser");
        
        //get product of user
        ArrayList<CartProduct> productCart = cartsDAO.getProductFromCart(user.getuId());
        
        
        //check quantity
        for (CartProduct cart : productCart) {
            total = cart.getpPrice() * cart.getCartQuantity();
            
            //number of order greater than available
            if(cart.getCartQuantity() > cart.getpQuantity()) {
                message += "* you order" + cart.getCartQuantity() + " of product" + cart.getpId()
                        + " which we have only " + cart.getpQuantity() + " pice <br/>";
            }
        }
        
        //check money
        if(total > user.getuCash()) {
            message += " * Your cash less than total require please charge your cash<br/>";
             request.getSession().setAttribute("message", message);
            response.sendRedirect("Failed.jsp");
            return;
        }
        
        //an error occure
        if(!message.trim().equals("")) {
            request.getSession().setAttribute("message", message);
            response.sendRedirect("Failed.jsp");
            return;
        }
        
        //-------------- Payment proccess ------------------
        
        //reduce balance in user
        user.setuCash(user.getuCash() - total);
        
        //call transaction
        if(new PaysDAO().startPayment(user, productCart)) {
            //send mail of success
            message = "Thanks for buying from KVT Shop ^_^ <br/>"
                    + "your product will delivered in two days ..";
            
            new MailModel(user.getuEmail(), "Successfull Payment", message).sendMail();
            HttpSession session =  request.getSession();
            session.setAttribute("message", message);
            response.sendRedirect("Success.jsp");
        } else { //if have error in process then show message and move to Failed.jsp
            request.getSession().setAttribute("message", "Error in proccess please try agine later :( "); 
            response.sendRedirect("Failed.jsp");
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

}
