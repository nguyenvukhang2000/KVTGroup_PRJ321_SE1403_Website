/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.CartProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KhangNVCE140224
 */
public class CartsDAO {
    private Connection conn;

    public CartsDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getConnect();
    }
    
    public ArrayList<CartProduct> getProductFromCart(int userId) {
        ArrayList<CartProduct> carts = new ArrayList<CartProduct>();
        
        String sql = "select c.cartId,c.cartQuantity,p.pName,p.pPrice,p.pImage,p.pDescription,p.pId ,p.pQuantity from cart as c, products as p where c.pId=p.pId AND c.uId=? ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                CartProduct cartProduct = new CartProduct();
                cartProduct.setCartId(rs.getInt("c.cartId"));
                cartProduct.setCartQuantity(rs.getInt("c.cartQuantity"));
                cartProduct.setpName(rs.getString("p.pName"));
                cartProduct.setpPrice(rs.getInt("p.pPrice"));
                cartProduct.setpImage(rs.getString("p.pImage"));
                cartProduct.setpDescription(rs.getString("p.pDescription"));
                cartProduct.setpId(rs.getInt("p.pId"));
                cartProduct.setpQuantity(rs.getInt("p.pQuantity"));
                carts.add(cartProduct);
            }
            return carts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean deleteCart(int cartID) {
        try {
            PreparedStatement pst = conn.prepareStatement("delete From cart where cartId=?");
            pst.setInt(1, cartID);
            int executeUpdate = pst.executeUpdate();
            if(executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteUserCart(int userID) {
        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM `cart` WHERE uId=?");
            pst.setInt(1, userID);
            int executeUpdate = pst.executeUpdate();
            if(executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
