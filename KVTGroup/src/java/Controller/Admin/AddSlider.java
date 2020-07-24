/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Models.DAO.ProductsDAO;
import Models.DAO.SlidersDAO;
import Models.Entities.Product;
import Models.Entities.Sliders;
import Models.utilize.FileUpload;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.Slider;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author vinhhqce140143
 */
@WebServlet(name = "AddSlider", urlPatterns = {"/admin/AddSlider"})
@MultipartConfig
public class AddSlider extends HttpServlet {
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
            out.println("<title>Servlet AddSlider</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSlider at " + request.getContextPath() + "</h1>");
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
        //get id from request
        int pId = Integer.parseInt(request.getParameter("pId"));
        //get product by id
        Product product = new ProductsDAO().getProduct(pId);
        //if can not find product
        if(product == null){
            request.getSession().setAttribute("message", "Product not found");
            response.sendRedirect("../Failed.jsp");
            //if file product
        }else{
            //set product by attribute request scope
            request.setAttribute("product", product);
            //forword to addslider.jsp
            request.getRequestDispatcher("/admin/AddSlider.jsp").forward(request, response);
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
        SlidersDAO sliderDAO = new SlidersDAO();
        //get info from jsp
        String title = request.getParameter("tittle");
        String subtitle = request.getParameter("subTittle");
        String desc = request.getParameter("ProductDescription");
        int pId = Integer.parseInt(request.getParameter("id"));
        
        
        Sliders slider = new Sliders();
        slider.setsDescription(desc);
        slider.setsTitle(title);
        slider.setsSubtitle(subtitle);
        slider.setpId(pId);
        
//        --upload img--
        //get file part
        Part filePart = request.getPart("image");
        if (filePart.getSize() != 0) {      //if photo uploaded
            String path = request.getServletContext().getRealPath("");

            try {
                //get image from jsp
                String uploadedpath = FileUpload.uploadImage(filePart, path);
                slider.setsImage(uploadedpath);
            } catch (Exception ex) {
                ex.printStackTrace();
                request.getSession().setAttribute("AlertMessage", "please choose image only");
                request.getSession().setAttribute("AlertType", "Danger");
                response.sendRedirect("SlidersShow");
                return;
            }

        } else {                          //no photo uploaded
            slider.setsImage(request.getParameter("pImage"));
        }
        
//        --add slider-- 
        PrintWriter out = response.getWriter();
        //add to db if true will print successful
        if(new SlidersDAO().addSlider(slider)){
            out.print("<script>alert('Add successful')</script>");
            out.print("<script>window.location.href='SlidersShow'</script>");
            //if not print fail
        }else{
            out.print("<script>alert('Add fail')</script>");
            out.print("<script>window.location.href='SlidersShow'</script>");
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
