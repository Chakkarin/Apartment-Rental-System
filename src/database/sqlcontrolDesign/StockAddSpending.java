
package database.sqlcontrolDesign;

import database.Entity.Spending;
import database.sqlcontrol.DbStore;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockAddSpending {
        public static Vector v = new Vector();

    public StockAddSpending() {
        getDataDB();
    }

    public static void getDataDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select MONTH,YEARS,UNIT,DATEREAL,c.CHARGES_ID,\n"
                    + "r.IDLICENSE,ro.ROOM_ID,re.IDCARD,rec.RECEIPTID\n"
                    + "from SPENDING s,CHARGES c,RENT r,ROOM ro,RENTER re,RECEIPT rec\n"
                    + "where s.CHARGES_ID=c.CHARGES_ID and\n"
                    + "r.IDLICENSE=s.IDLICENSE and\n"
                    + "ro.ROOM_ID=s.ROOM_ID and\n"
                    + "re.IDCARD=s.IDCARD and\n"
                    + "rec.RECEIPTID=s.RECEIPTID";
            System.out.println("" + sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            Spending rening;
            while (rs.next()) {
                rening = new Spending();//สร้าง object เก็บค่า
                rening.setMonth(rs.getString(1));
                rening.setYear(rs.getString(2));
                rening.setUnit(rs.getString(4));
                rening.setDatereal(rs.getString(5));
                rening.setIdcharge(rs.getString(6));
                rening.setIdrent(rs.getString(7));
                rening.setRoomid(rs.getString(8));
                rening.setIdrender(rs.getString(9));
                rening.setIdreceipt(rs.getString(10));
                v.add(rening);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }
}
