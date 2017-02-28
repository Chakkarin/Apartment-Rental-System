package database.sqlcontrol;

import database.Entity.TelRender;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockTelRender {

    public static Vector v = new Vector();

    public StockTelRender() {
        getDB();
    }

    public static void getDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select t.idcard,p.TELNUMBER\n" +
                "from  TELRENTER p,RENTER t\n" +
                 "where p.IDCARD = t.IDCARD";
            System.out.println("" + sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            TelRender tr;
            while (rs.next()) {
                tr = new TelRender();//สร้าง object เก็บค่า
                tr.setPersonal_id(rs.getString(1));
                tr.setPhone_number(rs.getString(2));
                v.add(tr);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }
}
