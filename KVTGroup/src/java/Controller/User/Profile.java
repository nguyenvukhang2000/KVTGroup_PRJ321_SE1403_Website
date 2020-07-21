/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.User;

import Models.DAO.UserDAO;
import Models.Entities.User;
import Models.utilize.FileUpload;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author KhangNVCE140224
 */
@MultipartConfig
@WebServlet(name = "Profile", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {

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
            out.println("<title>Servlet Profile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Profile at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
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
        try {
            //get id from session
            User user = (User)request.getSession().getAttribute("LoginUser");
            
            User newUser = (User)user.clone();
            String path = request.getServletContext().getRealPath("");
            //get request paramater & update object user
            newUser.setuName(request.getParameter("username"));
            newUser.setuEmail(request.getParameter("email"));
            newUser.setuPassword(request.getParameter("password"));
            newUser.setuAddress(request.getParameter("address"));
            newUser.setuJob(request.getParameter("job"));
            newUser.setuCreditCard(request.getParameter("creditcard"));
            
            //-------------- upload photo ------------------
            Part filePart = request.getPart("image");
            if(filePart.getSize() != 0) { //if photo uploaded
                try {
                    String uploadedPath = FileUpload.uploadImage(filePart, path);
                    newUser.setuPhoto(uploadedPath);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", "please choose image only");
                    request.getRequestDispatcher("/Failed.jsp").forward(request, response);
                    return;
                }
                
            }
            if(new UserDAO().updateUser(newUser, path)) {
                //upload user successfully
                newUser.setuPassword("");
                request.getSession().setAttribute("LoginUser", newUser); //update session user
                
                //redirect to profile
                request.setAttribute("mesageInfo", "Update user info successfully!");
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
            } else {
                //can't update user
                request.setAttribute("message", "Can't update user now... <br/>"
                        + "email or credit card used before");
                request.getRequestDispatcher("/Failed.jsp").forward(request, response);
            }
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
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
