
package database.sqlcontrol;

import database.Entity.Receipt;
import database.Entity.Rent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockReceipt {
    public static Vector v = new Vector();

    public StockReceipt() {
       getReceiptDB();
    }
    
    public static void getReceiptDB() {
        v.clear();//ล้าง vector ก่อน
        try {
            DbStore.doConnect();
            String sql = "select * from RECEIPT";
            System.out.println(""+sql);
            ResultSet rs = DbStore.doExcecuteQuery(sql);
            int count = 0;
            Receipt receipt;
            while (rs.next()) {
                receipt = new Receipt();//สร้าง object เก็บค่า
                receipt.setReceipt_id(rs.getString(1));
                receipt.setDateofReceipt(rs.getString(2));
                v.add(receipt);//เก็บ 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("หาไม่เจอ");
        }
    }
    public static int insertDB(Rent r){
        String sql="insert into RECEIPT values('"+r.getIdreceipt()+"','"+r.getDatelicence()+"')";
        int e=DbStore.doExcecuteUpdate(sql);
        System.out.println(sql);
        return e;
    }
    public static int deleteDB(Receipt receipt){
        String sql="delete from RECEIPT where RECEIPTID='"+receipt.getReceipt_id()+"'";
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
    public static int updateDB(Receipt receipt,String before){
        String sql="update RECEIPT set RECEIPTID = "+
                "'"+receipt.getReceipt_id()+"',DATEOFRECEIPT ='"+receipt.getDateofReceipt()+"' where RECEIPTID = '"+before+"' ";
        System.out.println("ค่าเก่าที่เก็บ:"+before);
        System.out.println(sql);
        int r=DbStore.doExcecuteUpdate(sql);
        return r;
    }
}
