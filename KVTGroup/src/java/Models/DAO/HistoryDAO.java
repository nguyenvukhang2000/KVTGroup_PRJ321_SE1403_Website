/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.History;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author KhangNVCE140224
 */
public class HistoryDAO {
    private Connection conn;

    public HistoryDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getConnect();
    }
    
    public boolean addUserHistory(History h) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO `history`(`uId`, `pId`, `hDate`, `hQuantity`) VALUES (?, ?, ?, ?)");
        pst.setInt(1, h.getuId());
        pst.setInt(2, h.getpId());
        pst.setDate(3, h.gethDate());
        pst.setInt(4, h.gethQuantity());
        
        int executeUpdate = pst.executeUpdate();
        if(executeUpdate > 0) {
            return true;
        }
        return false;
    }
}
