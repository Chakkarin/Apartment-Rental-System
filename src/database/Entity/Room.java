/*
จัดการข้อมูลของห้อง
 */
package database.Entity;

public class Room {
    private String room_id;
    private String layer;
    private String idCatygory;
    private String nameCatygory;

    public Room() {
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getIdCatygory() {
        return idCatygory;
    }

    public void setIdCatygory(String idCatygory) {
        this.idCatygory = idCatygory;
    }

    public String getNameCatygory() {
        return nameCatygory;
    }

    public void setNameCatygory(String nameCatygory) {
        this.nameCatygory = nameCatygory;
    }
    
    

    
    
   
    
}
