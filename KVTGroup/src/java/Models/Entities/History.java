/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entities;

import java.sql.Date;

/**
 *
 * @author KhangNVCE140224
 */
public class History {
    private int hId;
    private Date hDate;
    private int hQuantity;
    private int pId;
    private int uId;

    public History() {
    }

    public History(int hId, Date hDate, int hQuantity, int pId, int uId) {
        this.hId = hId;
        this.hDate = hDate;
        this.hQuantity = hQuantity;
        this.pId = pId;
        this.uId = uId;
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public Date gethDate() {
        return hDate;
    }

    public void sethDate(Date hDate) {
        this.hDate = hDate;
    }

    public int gethQuantity() {
        return hQuantity;
    }

    public void sethQuantity(int hQuantity) {
        this.hQuantity = hQuantity;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    
}
