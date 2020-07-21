/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Customtag;

import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import Models.Entities.Category;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.DAO.CategoryDAO;

/**
 *
 * @author KhangNVCE140224
 */
public class CartCategoryTagHandler extends SimpleTagSupport {


    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        ArrayList<Category> AllCategoriess = new CategoryDAO().allCategoriess();
        for (Category category : AllCategoriess) {
            try {
                out.print("<div class='panel panel-default'>\n" +
                        "                            <div class='panel-heading'>\n" +
                        "                                <h4 class='panel-title'><a href='ShopController?page=1&cate="+category.getcId()+"'>"+category.getcName()+"</a></h4>\n" +
                                "                            </div>\n" +
                                "                        </div>");
            } catch (IOException ex) {
                Logger.getLogger(CartCategoryTagHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
