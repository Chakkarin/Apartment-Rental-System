
package database.sqlcontrol;

import database.Entity.Charges;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockCharges {
    public static Vector v = new Vector();

    public StockCharges() {
       getChargesDB();
    }
    
    public static void getChargesDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select * from CHARGES";
            System.out.println(""+sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            Charges charges;
            while (rs.next()) {
                charges = new Charges();//สร้าง object เก็บค่า
                charges.setCharges_id(rs.getString(1));
                charges.setChargesName(rs.getString(2));
                charges.setPerUse(rs.getString(3));
                v.add(charges);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }
    public static int insertDB(Charges charges){
        String sql="insert into CHARGES values('"+charges.getCharges_id()+"','"+charges.getChargesName()+"','"+charges.getPerUse()+"')";
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
    public static int deleteDB(Charges charges){
        String sql="delete from CHARGES where CHARGES_ID='"+charges.getCharges_id()+"'";
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
    public static int updateDB(Charges charges,String before){
        String sql="update CHARGES set CHARGES_ID = "+
                "'"+charges.getCharges_id()+"',CHARGESNAME ="
                + "'"+charges.getChargesName()+"',CHARGESPER ='"+charges.getPerUse()+
                "' where CHARGES_ID = '"+before+"' ";
        System.out.println("ค่าเก่าที่เก็บ:"+before);
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    } 
}
