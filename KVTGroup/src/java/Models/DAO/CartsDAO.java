/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.Cart;
import Models.Entities.CartProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    private int search(int pId, int userId) {
        int quantity = 0;
        
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * from cart where (pId=?) and (uId=?)");
            pst.setInt(1, pId);
            pst.setInt(2, userId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                quantity = rs.getInt("cartQuantity");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quantity;
    }
    
    private boolean editQuantity(int quantity, int uId, int pId) {
        try {
            PreparedStatement pst = conn.prepareStatement("update cart set cartQuantity=? where uId=? and pId=? ");
            pst.setInt(1, quantity);
            pst.setInt(2, uId);
            pst.setInt(3, pId);
            
            int x = pst.executeUpdate();
            if(x > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  false;
    }
    
    public boolean addCart(Cart cart) {
        try {
            int search = search(cart.getpId(), cart.getuId());
            
            if(search != 0) {
                return editQuantity(search + cart.getCartQuantity(), cart.getuId(), cart.getpId());
            }
            
            PreparedStatement pst = conn.prepareStatement("INSERT INTO `cart`(`cartId`, `uId`, `pId`, `cartQuantity`) VALUES (?, ?, ?, ?)");
            pst.setInt(1, cart.getCartId());
            pst.setInt(2, cart.getuId());
            pst.setInt(3, cart.getpId());
            pst.setInt(4, cart.getCartQuantity());
            int executeUpdate = pst.executeUpdate();
            if(executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Cart> getUserCart(int userId) {
        try {
            ArrayList<Cart> carts = new ArrayList<>();
            PreparedStatement pst = conn.prepareStatement("select * From cart where uId=?");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("cartId"));
                cart.setuId(rs.getInt(2));
                cart.setpId(rs.getInt(3));
                cart.setCartQuantity(rs.getInt(4));
                carts.add(cart);
            }
            return carts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int getNumberOfCartsForUser(int userID) {
        int count = 0;
        ArrayList<Cart> userCarts = getUserCart(userID);
        for(int i = 0; i < userCarts.size(); i++) {
            count += userCarts.get(i).getCartQuantity();
            
        }
        return count;
    }
    
    private Cart getCart(int cartId) {
        Cart cart = null;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * from cart where cartId=?");
            pst.setInt(1, cartId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
               cart = new Cart();
               cart.setCartQuantity(rs.getInt("cartQuantity"));
               cart.setCartId(rs.getInt("cartId"));
               cart.setpId(rs.getInt("pId"));
               cart.setuId(rs.getInt("uId"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cart;
    }
    
    public boolean reduceQuantity(int cartId) {
        Cart cart = getCart(cartId);
        if(cart != null) {
            int quantity = cart.getCartQuantity();
            if(quantity < 2) {
                return deleteCart(cartId);
            } else {
                try {
                    PreparedStatement pst = conn.prepareStatement("UPDATE cart SET cartQuantity=? WHERE cartId=? ");
                    pst.setInt(1, cart.getCartQuantity() - 1);
                    pst.setInt(2, cartId);
                    int executeUpdate = pst.executeUpdate();
                    if(executeUpdate > 0) {
                        return true;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }
    
    public boolean increaseQuantity(int cartId) {
        Cart cart = getCart(cartId);
        if(cart != null) {
            int quantity = cart.getCartQuantity();
            
            try {
                PreparedStatement pst = conn.prepareStatement("UPDATE cart SET cartQuantity=? WHERE cartId=? ");
                pst.setInt(1, cart.getCartQuantity() + 1);
                    pst.setInt(2, cartId);
                    int executeUpdate = pst.executeUpdate();
                    if(executeUpdate > 0) {
                        return true;
                    }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
}
