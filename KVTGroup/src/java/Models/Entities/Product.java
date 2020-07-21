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
public class Product {
    private int pId;
    private int cId;
    private String pName;
    private String pImage;
    private double pPrice;
    private int pWeight;
    private String pDescription;
    private int pQuantity;
    private String pCreateDate;

    public Product() {
    }

    public Product(int pId) {
        this.pId = pId;
    }

    public Product(int pId, int cId, String pName, String pImage, double pPrice, int pWeight, String pDescription, int pQuantity, String pCreateDate) {
        this.pId = pId;
        this.cId = cId;
        this.pName = pName;
        this.pImage = pImage;
        this.pPrice = pPrice;
        this.pWeight = pWeight;
        this.pDescription = pDescription;
        this.pQuantity = pQuantity;
        this.pCreateDate = pCreateDate;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getpWeight() {
        return pWeight;
    }

    public void setpWeight(int pWeight) {
        this.pWeight = pWeight;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public String getpCreateDate() {
        return pCreateDate;
    }

    public void setpCreateDate(String pCreateDate) {
        this.pCreateDate = pCreateDate;
    }

    

    
}
