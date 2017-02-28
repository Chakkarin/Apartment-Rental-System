
package database.Entity;

public class ManagerRender {
    private String id;
    private String name;
    private String idRoom;
    private String categoryRoom;
    private String datein;
    private String dateout;
    private String money;

    public ManagerRender(String id, String name, String idRoom, String categoryRoom, String datein, String dateout, String money) {
        this.id = id;
        this.name = name;
        this.idRoom = idRoom;
        this.categoryRoom = categoryRoom;
        this.datein = datein;
        this.dateout = dateout;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getCategoryRoom() {
        return categoryRoom;
    }

    public void setCategoryRoom(String categoryRoom) {
        this.categoryRoom = categoryRoom;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    
}
