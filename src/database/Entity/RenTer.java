
package database.Entity;

public class RenTer {
    private String Personal_id;
    private String fName;
    private String lName;
    private String Sex;

    public RenTer() {
    }
    
    public RenTer(String Personal_id, String fName, String lName, String Sex) {
        this.Personal_id = Personal_id;
        this.fName = fName;
        this.lName = lName;
        this.Sex = Sex;
    }

    public String getPersonal_id() {
        return Personal_id;
    }

    public void setPersonal_id(String Personal_id) {
        this.Personal_id = Personal_id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }
    
    
}
