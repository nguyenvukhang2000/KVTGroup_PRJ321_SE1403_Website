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
public class Advertisement {
    private int aId;
    private String aImage;
    private String aURL;

    public Advertisement() {
    }

    public Advertisement(int aId, String aImage, String aURL) {
        this.aId = aId;
        this.aImage = aImage;
        this.aURL = aURL;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaImage() {
        return aImage;
    }

    public void setaImage(String aImage) {
        this.aImage = aImage;
    }

    public String getaURL() {
        return aURL;
    }

    public void setaURL(String aURL) {
        this.aURL = aURL;
    }
    
}
