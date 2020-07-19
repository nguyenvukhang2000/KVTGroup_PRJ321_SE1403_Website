/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KhangNVCE140224
 */
public class ScratchCardDAO {
    private Connection conn;

    public ScratchCardDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getConnect();
    }
    
    public int getSumCardNumber(int value) {
        int countOfCart = 0;
        
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(chargeCardNumber) AS COUNT FROM charge WHERE chargeValue=? AND chargeUsed=0 AND chargeTaken= 0");
            pst.setInt(1, value);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                countOfCart = Integer.parseInt(rs.getString("count"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return countOfCart;
    }
    
    public String getCard(int value) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT chargeCardNumber FROM charge WHERE  chargeValue=? AND chargeUsed=0");
            pst.setInt(1, value);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                return  rs.getString("chargeCardNumber");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean setCardTaken(String number) {
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE charge set chargeTaken=1 WHERE  chargeCardNumber=?");
            pst.setString(1, number);
            int executeUpdate = pst.executeUpdate();
            if(executeUpdate == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}