/*
เก็บข้อมูลใบเสร็จ
 */
package database.Entity;



public class Receipt {
    private String receipt_id;
    private String dateofReceipt;
    private double amount;

    public Receipt() {
    }

    public Receipt(String receipt_id, double amount,String dateofReceipt) {
        this.receipt_id = receipt_id;
        this.dateofReceipt = dateofReceipt;
        this.amount = amount;
    }

    public String getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(String receipt_id) {
        this.receipt_id = receipt_id;
    }

    public String getDateofReceipt() {
        return dateofReceipt;
    }

    public void setDateofReceipt(String dateofReceipt) {
        this.dateofReceipt = dateofReceipt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
