package database.Form.Relation;

import database.Form.*;
import database.Entity.RenTer;
import database.Entity.Rent;
import database.Form.Relation.TableAddressRender;
import database.Form.Relation.TableSpending;
import database.Form.Relation.TableTelRender;
import database.sqlcontrol.StockRender;
import database.sqlcontrol.StockRent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TableRent extends javax.swing.JFrame {

    private Vector vstu = new Vector();
    private TableModel model;
    private String columnName[] = {"รหัสใบสัญญา", "เงินค่าประกัน", "วันที่เข้าพักจริง", "วันที่ย้ายออก",
        "วันที่ทำสัญญา", "รหัสบัตรประชาชน", "เลขที่ห้อง", "เลขที่ใบเสร็จ"};
    private Object rowdata[][];
    private int selectIndex;
    StockRent st;

    public TableRent() {
        initComponents();
        st = new StockRent();
        updateTable();
        this.setLocationRelativeTo(null);
        lbCount.setText("จำนวนผู้เช่า :" + StockRent.v.size());
        System.out.println("ของใน stock" + StockRent.v.size() + "รายการ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        lbCount = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb);

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("ปิดหน้าต่าง");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbCount, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableRent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableRent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableRent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableRent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableRent().setVisible(true);
            }
        });
    }

    public void updateTable() {
        rowdata = new Object[StockRent.v.size()][columnName.length];
        Rent rent;
        for (int i = 0; i < StockRent.v.size(); i++) {
            rent = (Rent) StockRent.v.elementAt(i);
            rowdata[i][0] = rent.getIdlicence();
            rowdata[i][1] = rent.getMoney();
            rowdata[i][2] = rent.getDatein();
            rowdata[i][3] = rent.getDateout();
            rowdata[i][4] = rent.getDatelicence();
            rowdata[i][5] = rent.getIdrender();
            rowdata[i][6] = rent.getIdroom();
            rowdata[i][7] = rent.getIdreceipt();
        }
        model = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return rowdata.length;
            }

            @Override
            public int getColumnCount() {
                return columnName.length;
            }

            public String getColumnName(int column) {
                return columnName[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowdata[rowIndex][columnIndex];
            }
        };
        tb.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCount;
    private javax.swing.JTable tb;
    // End of variables declaration//GEN-END:variables
}
