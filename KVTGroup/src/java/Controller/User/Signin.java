package Controller.User;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Models.Entities.User;
import Models.DAO.UserDAO;

/**
 * handle signin
 * @author tú
 */
@WebServlet(name = "Signin", urlPatterns = {"/Signin"})
public class Signin extends HttpServlet {

    


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
        
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("SigninName");
        String password = request.getParameter("SigninPassword");
        UserDAO us = new UserDAO();
        User user = new User();
        user = us.signIn(username, password);
           if(user == null ){
               //TODO : MAKE forget password
               request.setAttribute("message", "Cant't Login <br/> Wrong username or password .. ");
               getServletContext().getRequestDispatcher("/Failed.jsp").forward(request, response);
           } else {
            
            //set session for login user
            HttpSession session = request.getSession(true);
            session.setAttribute("LoginUser", user);
            session.setMaxInactiveInterval(60*15);
            
               if(user.getuRole().equalsIgnoreCase("admin")){
                   System.out.println("ADMIN");
                   response.sendRedirect("admin/Index.jsp");   //admin
               }
                   
               else {
                   System.out.println("NOT");
                   response.sendRedirect("index.jsp");
               }                  //user
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
