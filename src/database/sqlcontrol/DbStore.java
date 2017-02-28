
package database.sqlcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbStore {
    //ทำการ Connect database
        public static Connection doConnect(){
        Connection con=null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl1";
            con = DriverManager.getConnection(url, "manager", "oracle");
            System.out.println("ต่อดาบ้าเบสได้แล้ว");
        } catch (Exception ex) {
            System.out.println("เกิดข้อผิดพลาดในการเชื่อมต่อฐานข้อมูล");
        }
        return con;
    }
    //สร้างเมธอดสำหรับการประมวลผลคำสั่ง SQL ในการ Query ข้อมูล
    public static ResultSet doExcecuteQuery(String sql){
        ResultSet rs=null;
        Statement stm;
        Connection con=doConnect();//ทำการ Connect ฐานข้อมูลก่อน
        try {
            stm=con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("เกิดข้อผิดพลาดบริเวณการส่งคำสั่ง Query ไปทำงาน");
        }
        
        return rs;
    }
    //สร้างเมธอดสำหรับการประมวลผล SQL Non - Query
    public static int doExcecuteUpdate(String sql){
        int result=0;
        Statement stm;
        Connection con=doConnect();//ทำการ Connect ฐานข้อมูลก่อน
        try {
            stm=con.createStatement();
            result = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("ผิดพลาดบริเวณการส่งคำสั่ง Non Query ไปทำงาน");
            ex.printStackTrace();
        }
        
        return result;
    }
    
}
