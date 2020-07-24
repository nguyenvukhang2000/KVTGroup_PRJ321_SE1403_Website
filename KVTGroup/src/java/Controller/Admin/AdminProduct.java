/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Models.DAO.ProductsDAO;
import Models.Entities.Product;
import Models.utilize.FileUpload;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
@WebServlet(name = "AdminProduct", urlPatterns = {"/admin/AdminProduct"})
@MultipartConfig
public class AdminProduct extends HttpServlet {

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
            out.println("<title>Servlet AdminProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminProduct at " + request.getContextPath() + "</h1>");
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
        //get id by request scope
        int id = Integer.parseInt(request.getParameter("pId"));
        //get product by id
        Product productobject = new ProductsDAO().getProduct(id);
        //if can not find product
        if (productobject == null) {
            request.getSession().setAttribute("message", "Product not found");
            response.sendRedirect("../Failed.jsp");
            //if find product
        } else {
            request.setAttribute("product", productobject);
            request.setAttribute("type", "Edit");
            request.getRequestDispatcher("/admin/AddProduct.jsp").forward(request, response);
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
        //get data from jsp
        String name = request.getParameter("ProductName");
        double price = Double.parseDouble(request.getParameter("ProductPrice"));
        String date = LocalDate.now().toString();
        String discription = request.getParameter("ProductDescription");
        int quantity = Integer.parseInt(request.getParameter("ProductQuantity"));
        int weight = Integer.parseInt(request.getParameter("ProductWeight"));
        int category = Integer.parseInt(request.getParameter("category"));
        String image = "";
        
//        --upload img--
        Part filePart = request.getPart("image");
        if(filePart.getSize() != 0){
            String path = request.getServletContext().getRealPath("");
            
            try {
                image = FileUpload.uploadImage(filePart, path);
                
            } catch (Exception e) {
               e.printStackTrace();
               request.getSession().setAttribute("AlertMessage", "Please choose image only");
               request.getSession().setAttribute("AlertType", "Danger");
               response.sendRedirect("AdminProductServlet");
               return;
            }
        }else{
            image = request.getParameter("pImage");
        }
        
//        update product
        if(request.getParameter("id") != null && !request.getParameter("id").trim().equals("")){
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("id"));
            if(new ProductsDAO().editProduct(id, category, name, price, quantity, weight, image, date, discription)){
                out.print("<script>alert('Update successful')</script>");
                out.print("<script>window.location.href='AdminProductServlet'</script>");
                return;
            }else{
                out.print("<script>alert('Update fail')</script>");
                out.print("<script>window.location.href='AdminProductServlet'</script>");
                return;
            }
        }
//        upload product        
        else{
            PrintWriter out = response.getWriter();
            if(new ProductsDAO().addProduct(category, name, price, quantity, weight, image, date, discription)){
                out.print("<script>alert('Add successful')</script>");
                out.print("<script>window.location.href='AdminProductServlet'</script>");
                return;
            }else{
                out.print("<script>alert('Add fail')</script>");
                out.print("<script>window.location.href='AdminProductServlet'</script>");
                return;
            }
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
