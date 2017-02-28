package database.sqlcontrol;

import database.Entity.AddressRender;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockAdressRender {

    public static Vector v = new Vector();

    public StockAdressRender() {
        getDB();
    }

    public static void getDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select r.IDCARD,r.ADDRESS\n" +
                        "from ADDRESSRENDER r,RENTER t\n" +
                        "where r.IDCARD = t.IDCARD";
            System.out.println("" + sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            AddressRender ar;
            while (rs.next()) {
                ar = new AddressRender();//สร้าง object เก็บค่า
                ar.setPersonal_id(rs.getString(1));
                ar.setAddress(rs.getString(2));
                v.add(ar);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }
}
