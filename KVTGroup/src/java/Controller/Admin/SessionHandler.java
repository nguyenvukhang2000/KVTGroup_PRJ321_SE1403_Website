/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author vinhhqce140143
 */
@WebListener
public class SessionHandler implements HttpSessionListener {

    private static int  onlineUsers = 0;

    /**
     * method to increate onlineuser when session is start and add new online user
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        onlineUsers++;
    }

    /**
     *method to descreate onlineuser when session is end
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
       onlineUsers--;
    }
    
    /**
     *method to get online user
     * @return
     */
    public static int getOnlineUsers(){
        return onlineUsers;
    }
}
