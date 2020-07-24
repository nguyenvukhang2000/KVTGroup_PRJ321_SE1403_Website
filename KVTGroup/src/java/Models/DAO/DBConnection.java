/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KhangNVCE140224
 */
public class DBConnection {

    /**
     *
     */
    public Connection conn; //stores connection

    /**
     * Creates new connection to Database server
     */
    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //use com.mysql.jdbc.Driver to connect to MySQL Server
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kvt", "root", ""); //Connects to MySQL Server base on URL, UID, PWD
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gets current connection
     * @return
     */
    public Connection getConnect() {
        return conn;
    }
}
