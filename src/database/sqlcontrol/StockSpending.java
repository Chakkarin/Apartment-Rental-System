package database.sqlcontrol;

import database.Entity.Spending;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockSpending {

    public static Vector v = new Vector();

    public StockSpending() {
        getDataDB();
    }

    public StockSpending(int i) {
        getDataDB1();
    }

    public static void getDataDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select MONTHS,YEARS,UNIT,DATEREAL,c.CHARGESNAME,\n"
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
                rening.setUnit(rs.getString(3));
                rening.setDatereal(rs.getString(4));
                rening.setCatagory(rs.getString(5));
                rening.setIdrent(rs.getString(6));
                rening.setRoomid(rs.getString(7));
                rening.setIdrender(rs.getString(8));
                rening.setIdreceipt(rs.getString(9));
                v.add(rening);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }

    public static void getDataDB1() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select MONTHS,YEARS,UNIT,DATEREAL,c.CHARGES_ID,\n"
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
                rening.setUnit(rs.getString(3));
                rening.setDatereal(rs.getString(4));
                rening.setIdcharge(rs.getString(5));
                rening.setIdrent(rs.getString(6));
                rening.setRoomid(rs.getString(7));
                rening.setIdrender(rs.getString(8));
                rening.setIdreceipt(rs.getString(9));
                v.add(rening);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }

    public static int insertDB(Spending sp) {
        String sql = "insert into SPENDING values('" + sp.getMonth()
                + "','" + sp.getYear() + "','" + sp.getUnit() + "',"
                + "'" + sp.getDatereal() + "','" + sp.getIdcharge() + "','" + sp.getIdrent()
                + "','" + sp.getRoomid() + "','" + sp.getIdrender() + "','" + sp.getIdreceipt() + "')";
        System.out.println(sql);
        int e = DbStore.doExcecuteUpdate(sql);
        System.out.println(sql);
        return e;
    }
    public static int insertDB2(Spending sp) {
        String sql = "insert into SPENDING values('" + sp.getMonth()
                + "','" + sp.getYear() + "','" + sp.getUnit() + "',"
                + "'" + sp.getDatereal() + "','" + sp.getIdcharge() + "','" + sp.getIdrent()
                + "','" + sp.getRoomid() + "','" + sp.getIdrender() + "','" + sp.getIdreceipt() + "')";
        System.out.println(sql);
        int e = DbStore.doExcecuteUpdate(sql);
        System.out.println(sql);
        return e;
    }
}
