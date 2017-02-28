
package database.sqlcontrol;

import database.Entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class StockRoom{
    public static Vector v = new Vector();
    public StockRoom() {
        getRoomDB();
    }
    public static void getRoomDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select ROOM_ID,LAYER,c.CATEGORY_ID,CATEGORYNAME\n" +
            "from ROOM r,CATEGORYROOM c\n" +
            "where c.CATEGORY_ID=r.CATEGORY_ID";
            System.out.println(""+sql);
            System.out.println("ของใน StockRoom = "+v.size());
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            Room room;
            while (rs.next()) {
                room = new Room();//สร้าง object เก็บค่า
                room.setRoom_id(rs.getString(1));
                room.setLayer(rs.getString(2));
                room.setIdCatygory(rs.getString(3));
                room.setNameCatygory(rs.getString(4));
                v.add(room);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }
    public static int insertDB(Room room){
        String sql="insert into ROOM values('"+room.getRoom_id()+"','"+room.getLayer()+"','"+room.getIdCatygory()+"')";
        int r=DbStore.doExcecuteUpdate(sql);
        System.out.println(sql);
        return r;
    }
    public static int deleteDB(Room room){
        String sql="delete from ROOM where ROOM_ID='"+room.getRoom_id()+"'";
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
    public static int updateDB(Room room,String before){
        String sql="update ROOM set ROOM_ID = "+
                "'"+room.getRoom_id()+"',LAYER ='"+room.getLayer()+"',CATEGORY_ID = '"+room.getIdCatygory() +"' where ROOM_ID = '"+before+"' ";
        System.out.println("ค่าเก่าที่เก็บ:"+before);
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
}

