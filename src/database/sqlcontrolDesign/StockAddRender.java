package database.sqlcontrolDesign;

import database.Entity.AddRenteral;
import database.Entity.AddressRender;
import database.Entity.RenTer;
import database.sqlcontrol.DbStore;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockAddRender {

    public static Vector v = new Vector();

    public StockAddRender() {
        getRenderDB();
    }

    public static void getRenderDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select r.IDCARD,r.FNAME,r.LNAME,r.SEX,t.TELNUMBER,a.ADDRESS\n"
                    + "from RENTER r,ADDRESSRENDER a,TELRENTER t\n"
                    + "where r.IDCARD=a.IDCARD and\n"
                    + "r.IDCARD=t.IDCARD";
            System.out.println("" + sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            AddRenteral pre;
            while (rs.next()) {
                pre = new AddRenteral();
                pre.setId(rs.getString(1));
                pre.setName(rs.getString(2));
                pre.setlName(rs.getString(3));
                pre.setSex(rs.getString(4));
                pre.setTel(rs.getString(5));
                pre.setAddress(rs.getString(6));
                v.add(pre);//เก็บ
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }

    public static int insertDB(AddRenteral ren) {
        String sql = "insert into RENTER values('" + ren.getId() + "','" + ren.getName() + "','" + ren.getlName() + "','" + ren.getSex() + "')";
        int r = DbStore.doExcecuteUpdate(sql);
        return r;
    }

    public static int insertTelAddess(AddRenteral ren) {
        String sql = "insert into ADDRESSRENDER values('" + ren.getId() + "','" + ren.getAddress() + "')";
        int r = DbStore.doExcecuteUpdate(sql);
        return r;
    }

    public static int insertTelDB(AddRenteral ren) {
        String sql = "insert into TELRENTER values('" + ren.getId() + "','" + ren.getTel() + "')";
        int r = DbStore.doExcecuteUpdate(sql);
        return r;
    }

    public static int deleteDB(AddRenteral ren) {
        String sql = "delete from RENTER where IDCARD='" + ren.getId() + "'";
        System.out.println(sql);
        int r = DbStore.doExcecuteUpdate(sql);
        return r;
    }

    public static int deleteAdressDB(AddRenteral ren) {
        String sql = "delete from ADDRESSRENDER where IDCARD='" + ren.getId() + "'";
        System.out.println(sql);
        int r = DbStore.doExcecuteUpdate(sql);
        return r;
    }

    public static int deleteTelDB(AddRenteral ren) {
        String sql = "delete from TELRENTER where IDCARD='" + ren.getId() + "'";
        System.out.println(sql);
        int r = DbStore.doExcecuteUpdate(sql);
        return r;
    }

    public static int updateDB(AddRenteral ren, String before) {
        String sql = "update RENTER set IDCARD = "
                + "'" + ren.getId() + "',FNAME ='" + ren.getName() + "',LNAME = '" + ren.getlName() + "'"
                + ",SEX = '" + ren.getSex() + "' where IDCARD = '" + before + "' ";
        System.out.println("ค่าเก่าที่เก็บ:" + before);
        System.out.println(sql);
        int r = DbStore.doExcecuteUpdate(sql);
        return r;
    }

    public static int updateAdressDB(AddRenteral ren, String before) {
        String sql = "update ADDRESSRENDER set IDCARD = "
                + "'" + ren.getId() + "',ADDRESS ='" + ren.getAddress() + "' where IDCARD = '" + before + "' ";
        System.out.println("ค่าเก่าที่เก็บ:" + before);
        System.out.println(sql);
        int r = DbStore.doExcecuteUpdate(sql);
        return r;
    }

    public static int updateTelDB(AddRenteral ren, String before) {
        String sql = "update TELRENTER set IDCARD = "
                + "'" + ren.getId() + "',TELNUMBER ='" + ren.getTel() + "' where IDCARD ='" + before + "' ";
        System.out.println("ค่าเก่าที่เก็บ:" + before);
        System.out.println(sql);
        int r = DbStore.doExcecuteUpdate(sql);
        return 1;
    }
}
