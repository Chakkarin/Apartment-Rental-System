/*
เก็บข้อมูลค่าใช้จ่าย
 */
package database.Entity;

public class Charges {
    private String charges_id;
    private String chargesName;
    private String perUse;

    public Charges() {
    }

    public Charges(String charges_id, String chargesName, String perUse) {
        this.charges_id = charges_id;
        this.chargesName = chargesName;
        this.perUse = perUse;
    }

    public String getCharges_id() {
        return charges_id;
    }

    public void setCharges_id(String charges_id) {
        this.charges_id = charges_id;
    }

    public String getChargesName() {
        return chargesName;
    }

    public void setChargesName(String chargesName) {
        this.chargesName = chargesName;
    }

    public String getPerUse() {
        return perUse;
    }

    public void setPerUse(String perUse) {
        this.perUse = perUse;
    }
    
    
    
}
