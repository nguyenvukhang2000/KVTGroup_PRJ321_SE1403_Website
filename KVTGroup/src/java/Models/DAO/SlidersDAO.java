/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.Sliders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KhangNVCE140224
 */
public class SlidersDAO {
    private Connection conn;
    private ResultSet rs = null;

    public SlidersDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getConnect();
    }
    
    public ArrayList<Sliders> getAllSliders() {
        ArrayList<Sliders> listSliders = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * From slides");
            rs = pst.executeQuery();
            while(rs.next()) {
                listSliders.add(new Sliders(rs.getInt("sId"), rs.getString(5), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(6)));
            }
            return listSliders;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
