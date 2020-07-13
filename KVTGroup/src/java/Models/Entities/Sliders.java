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
public class Sliders {
    private int sId;
    private String sImage;
    private String sTitle;
    private String sSubtitle;
    private String sDescription;
    private int pId;

    public Sliders() {
    }

    public Sliders(int sId, String sImage, String sTitle, String sSubtitle, String sDescription, int pId) {
        this.sId = sId;
        this.sImage = sImage;
        this.sTitle = sTitle;
        this.sSubtitle = sSubtitle;
        this.sDescription = sDescription;
        this.pId = pId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getsSubtitle() {
        return sSubtitle;
    }

    public void setsSubtitle(String sSubtitle) {
        this.sSubtitle = sSubtitle;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
    
}
