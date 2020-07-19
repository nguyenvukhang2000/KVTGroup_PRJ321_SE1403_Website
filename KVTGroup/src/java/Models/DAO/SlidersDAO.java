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
    DBConnection db = new DBConnection();
    private Connection conn;
    private ResultSet rs = null;

    public SlidersDAO() {
        
        this.conn = db.getConnect();
    }
    
    public ArrayList<Sliders> getAllSliders() {
        ArrayList<Sliders> listSliders = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM `slides`");
            rs = pst.executeQuery();
            while(rs.next()) {
                Sliders slide = new Sliders(rs.getInt("sId"), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(2));
                listSliders.add(slide);
            }
            return listSliders;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addSlider(Sliders sliders){
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO `slides`(`pId`, `sTitle`, `sSubtitle`, `sDescription`, `sImage`) VALUES (?,?,?,?,?)");
            pst.setInt(1, sliders.getpId());
            pst.setString(2, sliders.getsTitle());
            pst.setString(3, sliders.getsSubtitle());
            pst.setString(4, sliders.getsDescription());
            pst.setString(5, sliders.getsImage());
            
            int i = pst.executeUpdate();
            db.conn.close();
            if(i > 0 ){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
