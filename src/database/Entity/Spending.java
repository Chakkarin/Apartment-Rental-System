/*
จัดการความสัมพันธ์ 
เก็บข้อมุลการใช้จ่าย
*/
package database.Entity;

public class Spending {
    private String month;
    private String year;
    private String unit;
    private String datereal;
    private String idcharge;
    private String idrent;
    private String roomid;
    private String idrender;
    private String idreceipt;
    private String catagory;
    public Spending() {
        
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
    
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDatereal() {
        return datereal;
    }

    public void setDatereal(String datereal) {
        this.datereal = datereal;
    }

    public String getIdcharge() {
        return idcharge;
    }

    public void setIdcharge(String idcharge) {
        this.idcharge = idcharge;
    }

    public String getIdrent() {
        return idrent;
    }

    public void setIdrent(String idrent) {
        this.idrent = idrent;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getIdrender() {
        return idrender;
    }

    public void setIdrender(String idrender) {
        this.idrender = idrender;
    }

    public String getIdreceipt() {
        return idreceipt;
    }

    public void setIdreceipt(String idreceipt) {
        this.idreceipt = idreceipt;
    }
    
   
    
    
}
  
