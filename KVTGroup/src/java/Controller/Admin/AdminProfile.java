/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

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
 * @author vinhhqce14014
 */
@WebServlet(name = "AdminProfile", urlPatterns = {"/admin/AdminProfile"})
@MultipartConfig
public class AdminProfile extends HttpServlet {

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
            out.println("<title>Servlet AdminProfile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminProfile at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
        User user = new UserDAO().getUser(id);

        if (user == null) {
            request.getSession().setAttribute("message", "User not found");
            response.sendRedirect("../Failed.jsp");
        } else {
            request.setAttribute("userInfo", user);
            request.getRequestDispatcher("/admin/profile.jsp").forward(request, response);
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
        User user = new User();
        String path = request.getServletContext().getRealPath("");
        user.setuName(request.getParameter("name"));
        user.setuId(Integer.parseInt(request.getParameter("id")));
        user.setuEmail(request.getParameter("email"));
        user.setuPassword(request.getParameter("password"));
        user.setuAddress(request.getParameter("address"));
        user.setuJob(request.getParameter("job"));
        user.setuCreditCard(request.getParameter("creditcard"));
        user.setuCash(Double.parseDouble(request.getParameter("cash")));
        user.setuRole(request.getParameter("role"));

//        --upload img--
        Part filePart = request.getPart("image");
        if (filePart.getSize() != 0) {      //if photo uploaded

            try {
                String uploadedpath = FileUpload.uploadImage(filePart, path);
                user.setuPhoto(uploadedpath);
            } catch (Exception ex) {
                ex.printStackTrace();
                request.getSession().setAttribute("AlertMessage", "please choose image only");
                request.getSession().setAttribute("AlertType", "danger");
                response.sendRedirect("AdminUserServlet");

                return;
            }

        } else {                          //no photo uploaded
            user.setuPhoto(request.getParameter("photo"));
        }

//        --Update user--
        PrintWriter out = response.getWriter();
        if (new UserDAO().updateUser(user, path)) {
            out.print("<script>alert('Update successful')</script>");
            out.print("<script>window.location.href='AdminUserServlet'</script>");
        } else {
            out.print("<script>alert('Update fail')</script>");
            out.print("<script>window.location.href='AdminUserServlet'</script>");

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
