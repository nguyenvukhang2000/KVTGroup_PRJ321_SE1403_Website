/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entities;

/**
 *
 * @author KhangNVCE140224
 */
public class User {
    private String uName;
    private String uEmail;
    private int uId;
    private String uJob;
    private String uPassword;
    private String uRole;
    private String uPhoto;
    private String uAddress;
    private String uCreditCard;
    private double uCash;

    public User() {
    }

    public User(String uName, String uEmail, int uId, String uJob, String uPassword, String uRole, String uPhoto, String uAddress, String uCreditCard, double uCash) {
        this.uName = uName;
        this.uEmail = uEmail;
        this.uId = uId;
        this.uJob = uJob;
        this.uPassword = uPassword;
        this.uRole = uRole;
        this.uPhoto = uPhoto;
        this.uAddress = uAddress;
        this.uCreditCard = uCreditCard;
        this.uCash = uCash;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuJob() {
        return uJob;
    }

    public void setuJob(String uJob) {
        this.uJob = uJob;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }

    public String getuPhoto() {
        return uPhoto;
    }

    public void setuPhoto(String uPhoto) {
        this.uPhoto = uPhoto;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuCreditCard() {
        return uCreditCard;
    }

    public void setuCreditCard(String uCreditCard) {
        this.uCreditCard = uCreditCard;
    }

    public double getuCash() {
        return uCash;
    }

    public void setuCash(double uCash) {
        this.uCash = uCash;
    }

    @Override
    public String toString() {
        return "name: " + uName + "\n role" +uRole;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
