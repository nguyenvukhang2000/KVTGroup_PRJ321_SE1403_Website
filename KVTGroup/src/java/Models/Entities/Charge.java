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
public class Charge {
    private String  chargecardNumber;
    private int chargeValue;
    private  int chargeUsed ;
    private int chargeTaken;

    public Charge() {
    }

    public Charge(String chargecardNumber, int chargeValue, int chargeUsed, int chargeTaken) {
        this.chargecardNumber = chargecardNumber;
        this.chargeValue = chargeValue;
        this.chargeUsed = chargeUsed;
        this.chargeTaken = chargeTaken;
    }

    public String getChargecardNumber() {
        return chargecardNumber;
    }

    public void setChargecardNumber(String chargecardNumber) {
        this.chargecardNumber = chargecardNumber;
    }

    public int getChargeValue() {
        return chargeValue;
    }

    public void setChargeValue(int chargeValue) {
        this.chargeValue = chargeValue;
    }

    public int getChargeUsed() {
        return chargeUsed;
    }

    public void setChargeUsed(int chargeUsed) {
        this.chargeUsed = chargeUsed;
    }

    public int getChargeTaken() {
        return chargeTaken;
    }

    public void setChargeTaken(int chargeTaken) {
        this.chargeTaken = chargeTaken;
    }
    
}
