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
public class Cart {
    private int cartId;
    private int uId;
    private int pId;
    private int cartQuantity;

    public Cart() {
    }

    public Cart(int cartId) {
        this.cartId = cartId;
    }

    public Cart(int cartId, int uId, int pId, int cartQuantity) {
        this.cartId = cartId;
        this.uId = uId;
        this.pId = pId;
        this.cartQuantity = cartQuantity;
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

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
    
    
}
