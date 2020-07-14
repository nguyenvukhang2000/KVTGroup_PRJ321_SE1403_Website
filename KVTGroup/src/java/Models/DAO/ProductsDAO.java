/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KhangNVCE140224
 */
public class ProductsDAO {

    ResultSet rs;
    PreparedStatement pst = null;
    DBConnection db = new DBConnection();
    private int noOfRecords;

    Connection conn;

    public ProductsDAO() {
        this.conn = db.getConnect();
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> listProducts = new ArrayList();
        String sql = "SELECT * FROM products ORDER BY pId DESC";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                listProducts.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getDate("pCreateDate"), rs.getString("pStatus")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProducts;
    }

    public ArrayList<Product> getAllProducts(int start, int limit) {
        ArrayList<Product> listProducts = new ArrayList();
        String sql = "select * from products ORDER BY pId DESC LIMIT ? , ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, start);
            pst.setInt(2, limit);
            rs = pst.executeQuery();
            while (rs.next()) {
                listProducts.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getDate("pCreateDate"), rs.getString("pStatus")));
            }

            //get number of record in DB
            rs = conn.prepareStatement("SELECT count(*) FROM product").executeQuery();
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProducts;
    }

    public List<Product> getAllProductByCategoryId(int categoryId, int start, int limit) {
        ArrayList<Product> listProducts = new ArrayList();
        try {
            pst = conn.prepareStatement("select * from products where cId=? ORDER BY pId DESC LIMIT ? , ?");
            pst.setInt(1, categoryId);
            pst.setInt(2, start);
            pst.setInt(3, limit);

            rs = pst.executeQuery();
            while (rs.next()) {
                listProducts.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getDate("pCreateDate"), rs.getString("pStatus")));
            }
            pst = conn.prepareStatement("SELECT count(*) FROM products where cId=?");
            pst.setInt(1, categoryId);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProducts;

    }

    public int getNoOfRecords() {
        return noOfRecords;
    }

    public Product getProduct(int pId) {
        Product product = new Product(); //to return value of select
        try {
            pst = conn.prepareStatement("select * from products  where pId=?");
            pst.setInt(1, pId);
            rs = pst.executeQuery();
            if (rs.next()) {
                product.setpId(rs.getInt("pId"));
                product.setcId(rs.getInt(rs.getInt("cId")));
                product.setpName(rs.getString("pName"));
                product.setpImage(rs.getString("pImage"));
                product.setpPrice(rs.getDouble("pPrice"));
                product.setpWeight(rs.getInt("pWeight"));
                product.setpDescription(rs.getString("pDescription"));
                product.setpQuantity(rs.getInt(rs.getInt("pQuantity")));
                product.setpCreateDate(rs.getDate("pCreateDate"));
                product.setpStatus(rs.getString("pStatus"));
                return product;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Product> getRecommendedItem(int categoryId, int productId) {
        ArrayList<Product> getItem = new ArrayList();
        try {
            pst = conn.prepareStatement("SELECT * from products where pId <> ? and cId= ? ORDER BY pId ASC limit 6");
            pst.setInt(1, productId);
            pst.setInt(2, categoryId);
            rs = pst.executeQuery();
            while (rs.next()) {
                getItem.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getDate("pCreateDate"), rs.getString("pStatus")));
            }
            return getItem;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Product> getLastProducts() {
        ArrayList<Product> selectLastProduct = new ArrayList();

        try {
            pst = conn.prepareStatement("select * from products ORDER BY pId DESC LIMIT 6 ");
            rs = pst.executeQuery();
            while (rs.next()) {
                selectLastProduct.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getDate("pCreateDate"), rs.getString("pStatus")));
            }
            return selectLastProduct;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public double getMaxProductByPrice() {
        double highestprice = 0;

        try {
            pst = conn.prepareStatement("SELECT MAX(pPrice) AS HighestPrice FROM products");
            rs = pst.executeQuery();
            if (rs.next()) {
                highestprice = rs.getDouble("HighestPrice");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return highestprice;
    }
}
