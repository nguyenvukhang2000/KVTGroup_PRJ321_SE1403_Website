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
public class CartProduct {
    private int cartId;
    private int uId;
    private int cartQuantity;
    private int pId;
    private String pName;
    private String pImage;
    private double pPrice;
    private int pWeight;
    private String pDescription;
    private int pQuantity;
    private String pCreateDate;
   

    public CartProduct() {
    }

    public CartProduct(int cartId, int uId, int cartQuantity, int pId, String pName, String pImage, double pPrice, int pWeight, String pDescription, int pQuantity, String pCreateDate) {
        this.cartId = cartId;
        this.uId = uId;
        this.cartQuantity = cartQuantity;
        this.pId = pId;
        this.pName = pName;
        this.pImage = pImage;
        this.pPrice = pPrice;
        this.pWeight = pWeight;
        this.pDescription = pDescription;
        this.pQuantity = pQuantity;
        this.pCreateDate = pCreateDate;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
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
