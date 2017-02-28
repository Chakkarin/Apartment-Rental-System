
package database.Entity;

public class AddRenteral {
    private String id;
    private String name;
    private String lName;
    private String sex;
    private String tel;
    private String address;

    public AddRenteral() {
    }

    public AddRenteral(String id, String name, String lName, String sex, String tel, String address) {
        this.id = id;
        this.name = name;
        this.lName = lName;
        this.sex = sex;
        this.tel = tel;
        this.address = address;
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

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
