/*
ส่งคำสั่ง sql เข้าไปในรูปแบบ String 
การค้นหาข้อมูล
การบันทึกข้อมูล
การลบข้อมูล
ของฐานข้อมูลไหน
 */
package database.sqlcontrol;
import database.Entity.RenTer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockRender{
    public static Vector v = new Vector();
    public StockRender() {
        getRenderDB();
    }
    public static void getRenderDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select * from RENTER";
            System.out.println(""+sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            RenTer pre;
            while (rs.next()) {
                pre = new RenTer();//สร้าง object เก็บค่า
                pre.setPersonal_id(rs.getString(1));
                pre.setfName(rs.getString(2));
                pre.setlName(rs.getString(3));//เพิ่มมาใหม่
                pre.setSex(rs.getString(4));
                v.add(pre);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }
    public static int insertDB(RenTer ren){
        String sql="insert into RENTER values('"+ren.getPersonal_id()+"','"+ren.getfName()+"','"+ren.getlName()+"','"+ren.getSex()+"')";
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
    public static int deleteDB(RenTer ren){
        String sql="delete from RENTER where IDCARD='"+ren.getPersonal_id()+"'";
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
    public static int updateDB(RenTer ren,String before){
        String sql="update RENTER set IDCARD = "+
                "'"+ren.getPersonal_id()+"',FNAME =' "+ren.getfName()+"  ',LNAME = '"+ren.getlName()+"'"
                + ",SEX = '"+ren.getSex()+ "' where IDCARD= '"+before+"' ";
        System.out.println("ค่าเก่าที่เก็บ:"+before);
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
}
