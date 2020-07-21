/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinhhqce140143
 */
public class ChargeDAO {
    private DBConnection db;
    private ResultSet rs;
    private PreparedStatement pst;
    
    public ChargeDAO(){
        db = new DBConnection();
        rs = null;
        pst = null;
    }
    
    public int getProfit(){
        int profit = 0;
        try {
            pst = db.getConnect().prepareStatement("Select SUM(chargeValue) AS profit from charge where chargeTaken=1");
            rs = pst.executeQuery();
            
            if(rs.next()){
                profit = rs.getInt("profit");
                db.getConnect().close();
            }
        } catch (Exception e) {
            try {
                db.getConnect().close();
            } catch (SQLException ex) {
                Logger.getLogger(ChargeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return profit;
    }
    
    public int getSumCardNumber(int value){
        int coutOfCard = 0;
        try {
            pst = db.getConnect().prepareStatement("select count(chargeCardNumber) as count from charge where chargeValue=? and chargeUsed=0 and chargeTaken= 0 ");
            pst.setInt(1, value);
            rs = pst.executeQuery();
            if (rs.next()) {
                coutOfCard = Integer.parseInt(rs.getString("count"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coutOfCard;
    }
}
