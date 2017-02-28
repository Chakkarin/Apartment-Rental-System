package database.Entity;

public class Rent {

    private String idlicence;
    private String money;
    private String datein;
    private String dateout;
    private String datelicence;
    private String idrender;
    private String idroom;
    private String idreceipt;
    private String nameRen;
    private String cateRoom;

    public Rent() {

    }

    public String getNameRen() {
        return nameRen;
    }

    public void setNameRen(String nameRen) {
        this.nameRen = nameRen;
    }

    public String getCateRoom() {
        return cateRoom;
    }

    public void setCateRoom(String cateRoom) {
        this.cateRoom = cateRoom;
    }

    public Rent(String idlicence, String money, String datein, String dateout, String datelicence, String idrender, String idroom, String idreceipt) {
        this.idlicence = idlicence;
        this.money = money;
        this.datein = datein;
        this.dateout = dateout;
        this.datelicence = datelicence;
        this.idrender = idrender;
        this.idroom = idroom;
        this.idreceipt = idreceipt;
    }

    public String getIdlicence() {
        return idlicence;
    }

    public void setIdlicence(String idlicence) {
        this.idlicence = idlicence;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDatein() {
        return datein;
    }

    public void setDatein(String datein) {
        this.datein = datein;
    }

    public String getDateout() {
        return dateout;
    }

    public void setDateout(String dateout) {
        this.dateout = dateout;
    }

    public String getDatelicence() {
        return datelicence;
    }

    public void setDatelicence(String datelicence) {
        this.datelicence = datelicence;
    }

    public String getIdrender() {
        return idrender;
    }

    public void setIdrender(String idrender) {
        this.idrender = idrender;
    }

    public String getIdroom() {
        return idroom;
    }

    public void setIdroom(String idroom) {
        this.idroom = idroom;
    }

    public String getIdreceipt() {
        return idreceipt;
    }

    public void setIdreceipt(String idreceipt) {
        this.idreceipt = idreceipt;
    }

}
