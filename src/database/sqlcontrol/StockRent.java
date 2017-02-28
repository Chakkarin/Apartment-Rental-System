package database.sqlcontrol;

import database.Entity.RenTer;
import database.Entity.Rent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockRent {

    public static Vector v = new Vector();

    public StockRent() {
        getRenderDB();
    }

    public static void getRenderDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select r.IDCARD,rent.FNAME,ro.ROOM_ID,c.CATEGORYNAME,DATELICENSE,DATEIN,DATEOUT,MONEY,re.RECEIPTID\n"
                    + ",r.IDLICENSE\n"
                    + "from ROOM ro,RENT r,RECEIPT re,RENTER rent,CATEGORYROOM c\n"
                    + "where ro.ROOM_ID=r.ROOM_ID and\n"
                    + "re.RECEIPTID=r.RECEIPTID and\n"
                    + "rent.IDCARD=r.IDCARD and\n"
                    + "ro.CATEGORY_ID=c.CATEGORY_ID";
            System.out.println("" + sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            Rent pre;
            while (rs.next()) {
                pre = new Rent();//สร้าง object เก็บค่า
                pre.setIdrender(rs.getString(1));
                pre.setNameRen(rs.getString(2));
                pre.setIdroom(rs.getString(3));
                pre.setCateRoom(rs.getString(4));
                pre.setDatelicence(rs.getString(5));
                pre.setDatein(rs.getString(6));
                pre.setDateout(rs.getString(7));
                pre.setMoney(rs.getString(8));
                pre.setIdreceipt(rs.getString(9));
                pre.setIdlicence(rs.getString(10));
                v.add(pre);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }

    public static int insertDB(Rent r) {
        String sql = "insert into RENT values('" + r.getIdlicence()
                + "','" + r.getMoney() + "','" + r.getDatein() + "',"
                + "'" + r.getDateout() + "','"
                + r.getDatelicence() + "','" + r.getIdrender() + "','" + r.getIdroom() + "','" + r.getIdreceipt() + "')";
        System.out.println("ตรงนี้ผิด");
        int e = DbStore.doExcecuteUpdate(sql);
        return e;
    }
}
