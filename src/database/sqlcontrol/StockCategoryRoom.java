package database.sqlcontrol;
import database.Entity.CategoryRoom;
import database.Entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockCategoryRoom {
public static Vector v = new Vector();
    public StockCategoryRoom() {
        getCategoryDB();
    }
    public static void getCategoryDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select * from CATEGORYROOM";
            System.out.println(""+sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            CategoryRoom croom;
            while (rs.next()) {
                croom = new CategoryRoom();//สร้าง object เก็บค่า
                croom.setCategory_id(rs.getString(1));
                croom.setCategoryName(rs.getString(2));
                croom.setPrice(rs.getString(3));
                v.add(croom);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }
    public static int insertDB(CategoryRoom croom){
        String sql="insert into CATEGORYROOM values('"+croom.getCategory_id()+"','"+croom.getCategoryName()+"','"+croom.getPrice()+"')";
        int r=DbStore.doExcecuteUpdate(sql);
        System.out.println(sql);
        return r;
    }
    public static int deleteDB(CategoryRoom croom){
        String sql="delete from CATEGORYROOM where CATEGORY_ID='"+croom.getCategory_id()+"'";
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
    public static int updateDB(CategoryRoom croom,String before){
        String sql="update CATEGORYROOM set CATEGORYNAME ='"+croom.getCategoryName()+"',CATEGORYPRICE='"+croom.getPrice()+"' where CATEGORY_ID = '"+before+"' ";
        System.out.println("ค่าเก่าที่เก็บ:"+before);
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }    
}
