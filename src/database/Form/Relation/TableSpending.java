
package database.Form.Relation;

import database.Entity.Spending;
import database.Form.TableCategoryRoom;
import database.Form.TableCharges;
import database.Form.TableReceipt;
import database.Form.TableRender;
import database.sqlcontrol.StockSpending;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TableSpending extends javax.swing.JFrame {
    private Vector vstu = new Vector();
    private TableModel model;
    private String columnName[] = {"เดือน","ปี","หน่วย","วันที่จ่ายจริง","รหัสค่าใช้จ่าย",
        "รหัสใบสัญญา","เลขที่ห้อง","รหัสประชาชน","เลขที่ใบเสร็จ"};
    private Object rowdata[][];
    private int selectIndex;
    StockSpending st;
    public TableSpending() {
        initComponents();
        this.setLocationRelativeTo(null);
        st = new StockSpending(1);
        updateTable();
        this.setLocationRelativeTo(null);
        System.out.println("ของใน stock" + StockSpending.v.size() + "รายการ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRening = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbRening.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbRening);

        jButton1.setText("ปิด");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(444, 444, 444))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TableSpending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableSpending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableSpending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableSpending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableSpending().setVisible(true);
            }
        });
    }
    public void updateTable() {
        rowdata = new Object[StockSpending.v.size()][columnName.length];
        Spending rening;
        for (int i = 0; i < StockSpending.v.size(); i++) {
            rening = (Spending) StockSpending.v.elementAt(i);
            rowdata[i][0]=rening.getMonth();
            rowdata[i][1]=rening.getYear();
            rowdata[i][2]=rening.getUnit();
            rowdata[i][3]=rening.getDatereal();
            rowdata[i][4]=rening.getIdcharge();
            rowdata[i][5]=rening.getIdrent();
            rowdata[i][6]=rening.getRoomid();
            rowdata[i][7]=rening.getIdrender();
            rowdata[i][8]=rening.getIdreceipt();
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
        tbRening.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRening;
    // End of variables declaration//GEN-END:variables
}
