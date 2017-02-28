package database.design;

import database.Entity.CategoryRoom;
import database.Entity.Charges;
import database.Entity.Rent;
import database.Entity.Room;
import database.Entity.Spending;
import database.Entity.Utility;
import database.Form.Window;
import database.sqlcontrol.StockCategoryRoom;
import database.sqlcontrol.StockCharges;
import database.sqlcontrol.StockReceipt;
import database.sqlcontrol.StockRent;
import database.sqlcontrol.StockRoom;
import database.sqlcontrol.StockSpending;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Index extends JFrame implements Runnable, Printable {

    private TableModel model1, model2, model3, model4, model5, model6;
    DefaultTableModel model7;

    private String monthInSp[] = {"มกราคม", "กุมภาพันธ์", "มีนาคม",
        "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"};
    private String columnName1[] = {"หมายเลขห้อง", "ชั้น", "รหัสประเภทห้อง"};
    private String columnName2[] = {"รหัสประเภทห้อง", "ชื่อประเภทห้อง", "ราคา"};
    private String columnName3[] = {"รหัสค่าใช้จ่าย", "ชื่อค่าใช้จ่าย", "อัตราต่อหน่วย"};
    private String columnName4[] = {"เดือน", "ปี", "เลขห้อง", "หน่วย", "ประเภท"};
    private String columnName5[] = {"หมายเลขห้อง", "ประเภทห้อง", "ชั้น"};
    private String columnName6[] = {"รหัสประชาชน", "ชื่อผู้เช่า", "หมายเลขห้อง", "วันที่เข้าอยู่", "วันที่ย้าย", "ค่าประกัน", "รหัสใบเสร็จ", "ใบสัญญา"};
    private Object rowdata1[][], rowdata2[][],
            rowdata3[][], rowdata4[][], rowdata5[][], rowdata6[][];
    StockRoom st;
    StockCategoryRoom st2;
    StockCharges st3;
    StockSpending st4;
    StockRent st5;
    StockSpending st6;
    int select1, select2, select3, selectRoom, selectFinal, selectPrice, selected;

    DecimalFormat df;
    //จัดการเวลา
    Thread runner;
    GregorianCalendar g;
    String now = "";
    JTextField txtReceipt;
    //จัดการการเลือกห้องให้ผู้เช่า
    String name, idroom;

    //สุ่มเลขที่ใบสัญญา;
    long m, n;
    //ประเภทห้องพัก
    int count = 1;

    //การเลือกข้อมูลส่วนของตารางการเช่า
    int choice;
    Font f;

    public Index() {
        //สุ่มใบสัญญา
        m = new Random().nextInt(20000000);
        //สุ่มใบเสร็จ
        f = new Font("Tahoma", Font.PLAIN, 50);
        n = new Random().nextInt(30000000);
        System.out.println("เลขใบสัญญา = " + m);
        System.out.println("ใบเสร็จ =" + n);
        initComponents();
        model7 = (DefaultTableModel) tbPrice.getModel();
        df = new DecimalFormat("#,###");
        st = new StockRoom();
        st2 = new StockCategoryRoom();
        st3 = new StockCharges();
        st4 = new StockSpending();
        st6 = new StockSpending();
        st5 = new StockRent();
        txtReceipt = new JTextField();
        
        sp.setModel(new SpinnerListModel(monthInSp));
        txtRenter.setText(AddRender.nameSelect);
        new Utility().selectCaterory(catagoryCombo);
        new Utility().selectIDRent(jidlist);
 
       updateTable1();
        System.out.println("ของใน StockRoom = " + StockRoom.v.size());
        runner = new Thread(this);
        runner.start();
        System.out.println("ออกมาเป็น" + AddRender.idlicense + ":" + AddRender.idreceipt);

    }

    public Index(int number) {
        txtRenter.setText(AddRender.nameSelect);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tab = new javax.swing.JTabbedPane();
        pl2 = new javax.swing.JPanel();
        pa5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbIn = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        pa6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbDate = new javax.swing.JTable();
        jyear = new com.toedter.calendar.JYearChooser();
        jLabel14 = new javax.swing.JLabel();
        sp = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtUnit1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jidlist = new javax.swing.JComboBox();
        boxcroom = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addder = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbSelect = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtRen1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtRenter = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        txtDatein = new com.toedter.calendar.JDateChooser();
        txtDateout = new com.toedter.calendar.JDateChooser();
        confirm1 = new javax.swing.JButton();
        pl3 = new javax.swing.JPanel();
        bn99 = new javax.swing.JButton();
        bn100 = new javax.swing.JButton();
        plrender = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPrice = new javax.swing.JTable();
        pl1 = new javax.swing.JPanel();
        pa2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPer = new javax.swing.JTable();
        addData = new javax.swing.JButton();
        editData = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pa3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        roomid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        catagoryCombo = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbRoom = new javax.swing.JTable();
        addData1 = new javax.swing.JButton();
        editData1 = new javax.swing.JButton();
        layer = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        pa4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtP = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCategory = new javax.swing.JTable();
        bnsave = new javax.swing.JButton();
        bndelete = new javax.swing.JButton();
        Admin = new javax.swing.JButton();
        lb1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("โปรแกรมบริหารงานหอพัก");
        setResizable(false);

        tab.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        pa5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "จัดการเข้าอยู่", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AngsanaUPC", 1, 24))); // NOI18N
        pa5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tbIn.setModel(new javax.swing.table.DefaultTableModel(
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
        tbIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbIn);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/Ok-icon.png"))); // NOI18N
        jButton3.setToolTipText("เลือกห้องพัก");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pa5Layout = new javax.swing.GroupLayout(pa5);
        pa5.setLayout(pa5Layout);
        pa5Layout.setHorizontalGroup(
            pa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa5Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3))
        );
        pa5Layout.setVerticalGroup(
            pa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa5Layout.createSequentialGroup()
                .addGroup(pa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pa6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "บันทึกอัตราการใช้", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AngsanaUPC", 1, 24))); // NOI18N
        pa6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("ห้อง");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("หน่วยไฟที่ใช้");

        tbDate.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDateMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbDate);

        jyear.setYear(2558);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("ปี");

        sp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("เดือน");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/Alarm-Plus-icon.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("หน่วยน้ำที่ใช้");

        txtUnit1.setEditable(false);
        txtUnit1.setText("1");
        txtUnit1.setEnabled(false);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/Alarm-Plus-icon.png"))); // NOI18N
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        boxcroom.setEditable(false);
        boxcroom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/print-icon.png"))); // NOI18N
        jButton4.setText("รายงาน");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pa6Layout = new javax.swing.GroupLayout(pa6);
        pa6.setLayout(pa6Layout);
        pa6Layout.setHorizontalGroup(
            pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pa6Layout.createSequentialGroup()
                        .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(boxcroom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jyear, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jidlist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54))
                    .addGroup(pa6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pa6Layout.createSequentialGroup()
                .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pa6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtUnit1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pa6Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton4)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pa6Layout.setVerticalGroup(
            pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jyear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(sp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jidlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxcroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtUnit1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "จัดการผู้เช่า", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Angsana New", 1, 24))); // NOI18N

        addder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/print-scan-icon.png"))); // NOI18N
        addder.setToolTipText("บันทึกอัตราการใช้ของแต่ละห้อง");
        addder.setEnabled(false);
        addder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addderActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/add-icon.png"))); // NOI18N
        add.setToolTipText("เพิ่ม/เลือกผู้เช่า");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ผู้เช่า");

        tbSelect.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSelectMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbSelect);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("เงินค่าประกัน");

        txtRen1.setEditable(false);
        txtRen1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRen1.setText("1500");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("เข้าพักจริง");

        txtRenter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("ย้ายออก");

        confirm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/add-contact-icon.png"))); // NOI18N
        confirm.setToolTipText("บันทึกข้อมูล");
        confirm.setEnabled(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        txtDatein.setDateFormatString("dd/MM/yyyy");
        txtDatein.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        txtDatein.setMaxSelectableDate(new java.util.Date(253370743297000L));
        txtDatein.setMaximumSize(new java.awt.Dimension(21473648, 21473648));
        txtDatein.setMinSelectableDate(new java.util.Date(-62135791128000L));

        txtDateout.setDateFormatString("dd/MM/yyyy");
        txtDateout.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        txtDateout.setMaxSelectableDate(new java.util.Date(253370743297000L));
        txtDateout.setMaximumSize(new java.awt.Dimension(21473648, 21473648));
        txtDateout.setMinSelectableDate(new java.util.Date(-62135791128000L));

        confirm1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/User-Group-icon.png"))); // NOI18N
        confirm1.setToolTipText("แสดงข้อมูลผู้เช่าหอ");
        confirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtRenter, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtRen1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDatein, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDateout, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(addder, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirm1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtRen1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(txtRenter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(confirm1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addder))
                    .addComponent(txtDateout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16)
                        .addComponent(txtDatein, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout pl2Layout = new javax.swing.GroupLayout(pl2);
        pl2.setLayout(pl2Layout);
        pl2Layout.setHorizontalGroup(
            pl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pa6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl2Layout.createSequentialGroup()
                        .addComponent(pa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pl2Layout.setVerticalGroup(
            pl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl2Layout.createSequentialGroup()
                .addComponent(pa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pa6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab.addTab("ห้องพัก", pl2);

        bn99.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bn99.setText("พิมพ์ใบแจ้งหนี้");
        bn99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn99ActionPerformed(evt);
            }
        });

        bn100.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bn100.setText("ยืนยันการจ่าย");
        bn100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn100ActionPerformed(evt);
            }
        });

        plrender.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ข้อมูลผู้ค้างชำระ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AngsanaUPC", 1, 24))); // NOI18N

        tbPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbPrice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "หมายเลขห้อง", "ค่าน้ำ", "ค่าไฟ", "จำนวนเงิน(บาท)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPriceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPrice);
        if (tbPrice.getColumnModel().getColumnCount() > 0) {
            tbPrice.getColumnModel().getColumn(0).setResizable(false);
            tbPrice.getColumnModel().getColumn(1).setResizable(false);
            tbPrice.getColumnModel().getColumn(2).setResizable(false);
            tbPrice.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout plrenderLayout = new javax.swing.GroupLayout(plrender);
        plrender.setLayout(plrenderLayout);
        plrenderLayout.setHorizontalGroup(
            plrenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrenderLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );
        plrenderLayout.setVerticalGroup(
            plrenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plrenderLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pl3Layout = new javax.swing.GroupLayout(pl3);
        pl3.setLayout(pl3Layout);
        pl3Layout.setHorizontalGroup(
            pl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl3Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(plrender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl3Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(bn99)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bn100, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pl3Layout.setVerticalGroup(
            pl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plrender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bn100, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bn99, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("รายงาน", pl3);

        pa2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เพิ่ม/ลบอัตรา", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AngsanaUPC", 1, 24))); // NOI18N
        pa2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ชื่อค่าใช้จ่าย");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("ราคาต่อหน่วย");

        tbPer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัสค่าใช้จ่าย", "ชื่อค่าใช้จ่าย", "อัตราต่อหน่วย"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPer);
        if (tbPer.getColumnModel().getColumnCount() > 0) {
            tbPer.getColumnModel().getColumn(0).setResizable(false);
            tbPer.getColumnModel().getColumn(1).setResizable(false);
            tbPer.getColumnModel().getColumn(2).setResizable(false);
        }

        addData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/icon2.png"))); // NOI18N
        addData.setText("เพิ่ม");
        addData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataActionPerformed(evt);
            }
        });

        editData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/Windows-Close-Program-icon.png"))); // NOI18N
        editData.setText("ลบ");
        editData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDataActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("รหัสค่าใช้จ่าย");

        javax.swing.GroupLayout pa2Layout = new javax.swing.GroupLayout(pa2);
        pa2.setLayout(pa2Layout);
        pa2Layout.setHorizontalGroup(
            pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pa2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pa2Layout.createSequentialGroup()
                            .addComponent(addData)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(editData)
                            .addGap(128, 128, 128)))
                    .addGroup(pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pa2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtid))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pa2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        pa2Layout.setVerticalGroup(
            pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa2Layout.createSequentialGroup()
                .addGroup(pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addData)
                    .addComponent(editData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pa3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "จัดการห้องพัก", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AngsanaUPC", 1, 24))); // NOI18N
        pa3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("หมายเลขห้อง");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("ชั้น");

        tbRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "อิอิ", "อิอิ2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRoomMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbRoom);
        if (tbRoom.getColumnModel().getColumnCount() > 0) {
            tbRoom.getColumnModel().getColumn(0).setResizable(false);
            tbRoom.getColumnModel().getColumn(1).setResizable(false);
        }

        addData1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/icon5.png"))); // NOI18N
        addData1.setText("เพิ่ม");
        addData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addData1ActionPerformed(evt);
            }
        });

        editData1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/Windows-Close-Program-icon.png"))); // NOI18N
        editData1.setText("ลบ");
        editData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editData1ActionPerformed(evt);
            }
        });

        layer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("รหัสประเภทห้อง");

        javax.swing.GroupLayout pa3Layout = new javax.swing.GroupLayout(pa3);
        pa3.setLayout(pa3Layout);
        pa3Layout.setHorizontalGroup(
            pa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa3Layout.createSequentialGroup()
                .addGroup(pa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pa3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addGroup(pa3Layout.createSequentialGroup()
                                .addComponent(addData1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editData1))))
                    .addGroup(pa3Layout.createSequentialGroup()
                        .addGroup(pa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pa3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(roomid, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pa3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(catagoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pa3Layout.setVerticalGroup(
            pa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catagoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(pa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addData1)
                    .addComponent(editData1))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pa4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "จัดการประเภทห้อง", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AngsanaUPC", 1, 24))); // NOI18N
        pa4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("ชื่อประเภทห้อง");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("ราคา");

        tbCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "อิอิ", "อิอิ", "อิอิ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoryMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbCategory);
        if (tbCategory.getColumnModel().getColumnCount() > 0) {
            tbCategory.getColumnModel().getColumn(0).setResizable(false);
            tbCategory.getColumnModel().getColumn(1).setResizable(false);
            tbCategory.getColumnModel().getColumn(2).setResizable(false);
        }

        bnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/icon2.png"))); // NOI18N
        bnsave.setToolTipText("บันทึก/แก้ไข");
        bnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnsaveActionPerformed(evt);
            }
        });

        bndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/icon3.png"))); // NOI18N
        bndelete.setToolTipText("ลบ");
        bndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pa4Layout = new javax.swing.GroupLayout(pa4);
        pa4.setLayout(pa4Layout);
        pa4Layout.setHorizontalGroup(
            pa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(pa4Layout.createSequentialGroup()
                        .addGroup(pa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCategory)
                            .addComponent(txtP, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addComponent(bnsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pa4Layout.setVerticalGroup(
            pa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pa4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pa4Layout.createSequentialGroup()
                        .addGroup(pa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bnsave)
                    .addComponent(bndelete))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pl1Layout = new javax.swing.GroupLayout(pl1);
        pl1.setLayout(pl1Layout);
        pl1Layout.setHorizontalGroup(
            pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl1Layout.createSequentialGroup()
                .addComponent(pa2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pl1Layout.setVerticalGroup(
            pl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab.addTab("ตั้งค่าเริ่มต้น", pl1);

        Admin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/Male-Face-D2-icon.png"))); // NOI18N
        Admin.setToolTipText("Admin");
        Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminActionPerformed(evt);
            }
        });

        lb1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("Title");

        menuBar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuBar.add(jMenu1);

        jMenu2.setText("Help");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/res/Actions-view-refresh-icon.png"))); // NOI18N
        jMenuItem1.setText("Refresh");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 1216, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Admin)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        new AddRender().show();
        this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void addderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addderActionPerformed
        String tbString = tbSelect.getValueAt(choice, 1).toString();
        if (tbSelect.isRowSelected(choice)) {
            int i = JOptionPane.showConfirmDialog(this, "ปริ้นข้อมูล :" + tbString, "ยืนยันรายการ", JOptionPane.OK_CANCEL_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                PrinterJob pj = PrinterJob.getPrinterJob();
                pj.setPrintable((Printable) this);
                if (pj.printDialog()) {
                    try {
//                        pj.print();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (i == JOptionPane.NO_OPTION) {
                return;
            }
        }
    }//GEN-LAST:event_addderActionPerformed

    private void addDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataActionPerformed
        if (tbPer.isRowSelected(select1)) {
            Charges charges = new Charges();
            String before = tbPer.getValueAt(select1, 0).toString();
            charges.setCharges_id(txtid.getText());
            charges.setChargesName(txtName.getText());
            charges.setPerUse(txtPrice.getText());
            int result = StockCharges.updateDB(charges, before);
            if (result == 1) {
                JOptionPane.showMessageDialog(this, "อัพเดทข้อมูลเรียบร้อย");
                StockCharges.v.remove(select1);
                StockCharges.v.add(select1, charges);
                updateTable1();
                clearTable1();
            }
        } else {
            Charges charges = new Charges();
            charges.setCharges_id(txtid.getText());
            charges.setChargesName(txtName.getText());
            charges.setPerUse(txtPrice.getText());
            int result = StockCharges.insertDB(charges);
            if (result == 1) {
                showMessage("บันทึกข้อมูลเรียบร้อย");
                //เพิ่ม Object และอัพเดทตาราง
                StockCharges.v.add(charges);
                updateTable1();
                clearTable1();
            }
        }
    }//GEN-LAST:event_addDataActionPerformed

    private void tbPerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPerMouseClicked
        select1 = tbPer.getSelectedRow();
        Charges charges = (Charges) StockCharges.v.elementAt(select1);
        txtid.setText(charges.getCharges_id());
        txtName.setText(charges.getChargesName());
        txtPrice.setText(charges.getPerUse());
        System.out.println("ค่าใช้จ่ายทำการเลือกแถว:" + select1);
    }//GEN-LAST:event_tbPerMouseClicked

    private void addData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addData1ActionPerformed
        if (tbRoom.isRowSelected(select2)) {
            Room room = new Room();
            String before = tbRoom.getValueAt(select2, 0).toString();
            room.setRoom_id(roomid.getText());
            room.setLayer(layer.getSelectedItem().toString());
            room.setIdCatygory(catagoryCombo.getSelectedItem().toString());
            int result = StockRoom.updateDB(room, before);
            if (result == 1) {
                JOptionPane.showMessageDialog(this, "อัพเดทข้อมูลเรียบร้อย");
                StockRoom.v.remove(select2);
                StockRoom.v.add(select2, room);
                updateTable2();
                clearTable2();
            }
        } else {
            Room room = new Room();
            room.setRoom_id(roomid.getText());
            room.setLayer(layer.getSelectedItem().toString());
            room.setIdCatygory(catagoryCombo.getSelectedItem().toString());
            int result = StockRoom.insertDB(room);
            if (result == 1) {
                showMessage("บันทึกข้อมูลเรียบร้อย");
                //เพิ่ม Object และอัพเดทตาราง
                StockRoom.v.add(room);
                updateTable2();
                clearTable2();
            }
        }
        String s = catagoryCombo.getSelectedItem().toString();
        System.out.println(s);
    }//GEN-LAST:event_addData1ActionPerformed

    private void tbRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRoomMouseClicked
        select2 = tbRoom.getSelectedRow();
        Room room = (Room) StockRoom.v.elementAt(select2);
        roomid.setText(room.getRoom_id());
        for (int i = 0; i < layer.getItemCount(); i++) {
            String m = room.getLayer();
            if (m.equals(layer.getItemAt(i))) {
                layer.setSelectedIndex(i);
            }
        }
        System.out.println("เลือกแถว:" + select2);
    }//GEN-LAST:event_tbRoomMouseClicked

    private void AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminActionPerformed
        new Window().show();
    }//GEN-LAST:event_AdminActionPerformed

    private void editData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editData1ActionPerformed
        select2 = tbRoom.getSelectedRow();
        Room room = (Room) StockRoom.v.elementAt(select2);
        System.out.println("primary key:" + room.getRoom_id());
        int result = StockRoom.deleteDB(room);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "ลบ" + room.getRoom_id() + "เรียบร้อย");
            StockRoom.v.remove(select2);//ลบตำแหน่งที่เลือก
            updateTable2();//ฟื้นฟูตาราง
            clearTable2();
        } else {
            System.out.println("เกิดข้อผิดพลาดจากการลบ");
        }

    }//GEN-LAST:event_editData1ActionPerformed

    private void editDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDataActionPerformed
        select3 = tbPer.getSelectedRow();
        Charges charges = (Charges) StockCharges.v.elementAt(select3);
        System.out.println("primary key:" + charges.getCharges_id());
        int result = StockCharges.deleteDB(charges);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "ลบ" + charges.getCharges_id() + "เรียบร้อย");
            StockCharges.v.remove(select3);//ลบตำแหน่งที่เลือก
            updateTable1();//ฟื้นฟูตาราง
            clearTable1();
        } else {
            System.out.println("เกิดข้อผิดพลาดจากการลบ");
        }
    }//GEN-LAST:event_editDataActionPerformed

    private void bnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnsaveActionPerformed
        if (tbCategory.isRowSelected(select3)) {
            CategoryRoom croom = new CategoryRoom();
            String before = tbCategory.getValueAt(select3, 0).toString();
            System.out.println("Before=" + before);
            croom.setCategory_id(before);
            croom.setCategoryName(txtCategory.getText());
            croom.setPrice(txtP.getText());
            int result = StockCategoryRoom.updateDB(croom, before);
            if (result == 1) {
                JOptionPane.showMessageDialog(this, "อัพเดทข้อมูลเรียบร้อย");
                StockCategoryRoom.v.remove(select3);
                StockCategoryRoom.v.add(select3, croom);
                updateTable3();
                clearTable3();
            }
        } else {
            CategoryRoom croom = new CategoryRoom();
            croom.setCategory_id("" + (count));
            croom.setCategoryName(txtCategory.getText());
            croom.setPrice(txtP.getText());
            int result = StockCategoryRoom.insertDB(croom);
            if (result == 1) {
                showMessage("บันทึกข้อมูลเรียบร้อย");
                //เพิ่ม Object และอัพเดทตาราง
                StockCategoryRoom.v.add(croom);
                updateTable3();
                clearTable3();
            }
            count++;
        }
    }//GEN-LAST:event_bnsaveActionPerformed

    private void bndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bndeleteActionPerformed
        select3 = tbCategory.getSelectedRow();
        CategoryRoom croom = (CategoryRoom) StockCategoryRoom.v.elementAt(select3);
        System.out.println("primary key:" + croom.getCategory_id());
        int result = StockCategoryRoom.deleteDB(croom);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "ลบ" + croom.getCategory_id() + "เรียบร้อย");
            StockCategoryRoom.v.remove(select3);//ลบตำแหน่งที่เลือก
            updateTable3();//ฟื้นฟูตาราง
            clearTable3();
        } else {
            System.out.println("เกิดข้อผิดพลาดจากการลบ");
        }
    }//GEN-LAST:event_bndeleteActionPerformed

    private void tbCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoryMouseClicked
        select3 = tbCategory.getSelectedRow();
        CategoryRoom croom = (CategoryRoom) StockCategoryRoom.v.elementAt(select3);
        txtCategory.setText(croom.getCategoryName());
        txtP.setText(croom.getPrice());
        System.out.println("เลือกแถว:" + select3);
    }//GEN-LAST:event_tbCategoryMouseClicked

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        //วันที่ทำสัญญา
        String datelicense = g.get(g.DAY_OF_MONTH) + "/" + (g.get(g.MONTH) + 1) + "/"
                + (g.get(g.YEAR) + 543);
        String in = ((JTextField) txtDatein.getDateEditor().getUiComponent()).getText();
        String out = ((JTextField) txtDateout.getDateEditor().getUiComponent()).getText();

        //บันทึกการเช่า
        Rent r = new Rent();
        r.setIdlicence("" + m);//รหัสใบสัญญา
        r.setMoney(txtRen1.getText());//เงินค่าประกัน
        r.setDatein(in);//วันที่เข้าพักจริง
        r.setDateout(out);//วันที่ย้ายออก
        r.setDatelicence(datelicense);//วันที่ทำสัญญา
        r.setIdrender(AddRender.idSelect);//รหัสประชาชน
        r.setIdroom(idroom);//เลขที่ห้อง
        r.setIdreceipt("" + n);//เลขที่ใบเสร็จ
        int result = StockRent.insertDB(r);
        int result2 = StockReceipt.insertDB(r);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "บันทึกข้อมูลเรียบร้อย");
            //เพิ่ม Object และอัพเดทตาราง
            StockRent.v.add(r);
            updateTable6();
            confirm.setEnabled(false);
            this.dispose();
            new Index().show();
        }

        System.out.println("ข้อมูลใบสัญญษ" + r.getIdlicence());
        System.out.println("ข้อมูลเงิน" + r.getMoney());
        System.out.println("ข้อมูลวันเข้า" + r.getDatein());
        System.out.println("ข้อมูลวันออก" + r.getDateout());
        System.out.println("ข้อมูลวันที่ทำสัญญษ" + r.getDatelicence());
        System.out.println("ข้อมูลรหัสผู้เช่า" + r.getIdrender());
        System.out.println("ข้อมูลห้อง" + r.getIdroom());
        System.out.println("ข้อมูลใบเสด" + r.getIdreceipt());
    }//GEN-LAST:event_confirmActionPerformed

    private void tbInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInMouseClicked
        selectRoom = tbIn.getSelectedRow();
        name = tbIn.getValueAt(selectRoom, 1).toString();
        idroom = tbIn.getValueAt(selectRoom, 0).toString();
        System.out.println("name=" + name + "id=" + idroom);
    }//GEN-LAST:event_tbInMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "หมายเลขห้อง=" + idroom + "ประเภทห้อง=" + name, "ยืนยันรายการ", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            StockRoom.v.remove(selectRoom);
            updateTable5();
            confirm.setEnabled(true);
        } else {
            System.out.println("ได้ไหม");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void confirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm1ActionPerformed
        new DisplayRenter().show();

    }//GEN-LAST:event_confirm1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String k = "";
        String n = jidlist.getSelectedItem().toString();
        if (n.equals("ค่าไฟ")) {
            k = "1";
        }
        if (n.equals("ค่าน้ำ")) {
            k = "2";
        }
        if (txtUnit.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ป้อนค่าไฟ");
        } else {
            Spending spend = new Spending();
            spend.setMonth("" + sp.getValue());
            spend.setYear("" + jyear.getValue());
            spend.setUnit(txtUnit.getText());
            spend.setDatereal("" + g.get(g.DAY_OF_MONTH));
            spend.setIdcharge("" + k);
            spend.setIdrent("" + tbSelect.getValueAt(choice, 7));//รหัสใบสัญญา
            spend.setRoomid(boxcroom.getText());
            spend.setIdrender("" + tbSelect.getValueAt(choice, 0));
            spend.setIdreceipt("" + tbSelect.getValueAt(choice, 6));//รหัสใบเสร็จ
            int r1 = StockSpending.insertDB(spend);
            if (r1 == 1) {
                JOptionPane.showMessageDialog(this, "บันทึกข้อมูลเรียบร้อย");
                jButton5.setEnabled(false);
                jButton6.setEnabled(true);
                txtUnit.setEnabled(false);
                jidlist.setSelectedIndex(1);
                StockSpending.v.add(spend);
                updateTable4();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String k = "";
        String n = jidlist.getSelectedItem().toString();
        if (n.equals("ค่าไฟ")) {
            k = "2";
        }
        if (n.equals("ค่าน้ำ")) {
            k = "1";
        }
        Spending spend = new Spending();
        spend.setMonth("" + sp.getValue());
        spend.setYear("" + jyear.getValue());
        spend.setUnit(txtUnit1.getText());
        spend.setDatereal("" + g.get(g.DAY_OF_MONTH));
        spend.setIdcharge(k);
        spend.setIdrent("" + tbSelect.getValueAt(choice, 7));
        spend.setRoomid(boxcroom.getText());
        spend.setIdrender("" + tbSelect.getValueAt(choice, 0));
        spend.setIdreceipt("" + tbSelect.getValueAt(choice, 6));
        int r1 = StockSpending.insertDB2(spend);
        if (r1 == 1) {
            JOptionPane.showMessageDialog(this, "บันทึกข้อมูลเรียบร้อย");
            jButton5.setEnabled(true);
            jButton6.setEnabled(false);
            txtUnit.setEnabled(true);
            jidlist.setSelectedIndex(0);
            StockSpending.v.add(spend);
            updateTable4();
            this.dispose();
            new Index().show();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        new Index().show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tbSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSelectMouseClicked
        choice = tbSelect.getSelectedRow();
        boxcroom.setText(tbSelect.getValueAt(choice, 2).toString());
        addder.setEnabled(true);
    }//GEN-LAST:event_tbSelectMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (tbDate.isRowSelected(selectFinal)) {
            int i = JOptionPane.showConfirmDialog(this, "รายงานใบแจ้งหนี้ห้อง " + tbDate.getValueAt(selectFinal, 2), "ยืนยันรายการ", JOptionPane.OK_CANCEL_OPTION);

            Vector vstu = new Vector();
            vstu.add(tbDate.getValueAt(selectFinal, 2));//เลขห้อง
            Double water = 80.0;
            vstu.add(water);//ค่าน้ำ
            Double money = Double.valueOf(tbDate.getValueAt(selectFinal, 3).toString()) * 7;//ค่าไฟ
            vstu.add(money);
            vstu.add(money + water);
            model7.addRow(vstu);
        } else {
            JOptionPane.showMessageDialog(this, "กรุณาเลือกข้อมูลในตาราง");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDateMouseClicked
        selectFinal = tbDate.getSelectedRow();
    }//GEN-LAST:event_tbDateMouseClicked

    private void bn99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn99ActionPerformed
        if (tbPrice.isRowSelected(selectPrice)) {
            int i = JOptionPane.showConfirmDialog(this, "พิมพ์ใบแจ้งหนี้ของห้อง" + tbPrice.getValueAt(selectPrice, 0), "ยืนยันรายการ", JOptionPane.OK_CANCEL_OPTION);
            if (i == JOptionPane.OK_OPTION) {
                StringBuilder st = new StringBuilder();
                st.append("ใบเสร็จการชำระเงิน\n");
                st.append("หมายเลขห้อง:" + tbPrice.getValueAt(selectPrice, 0) + "\n");
                st.append("ค่าน้ำที่ใช้:" + tbPrice.getValueAt(selectPrice, 1) + "\n");
                st.append("ค่าไฟที่ใช้:" + tbPrice.getValueAt(selectPrice, 2) + "\n");
                st.append("จำนวนเงิน:" + tbPrice.getValueAt(selectPrice, 3) + "บาท\n");
                txtReceipt.setFont(f);
                txtReceipt.setText(st.toString());
                int j = JOptionPane.showConfirmDialog(this, st, "ใบเสร็จ", JOptionPane.OK_CANCEL_OPTION);
                if (j == JOptionPane.OK_OPTION) {
                    PrinterJob pj = PrinterJob.getPrinterJob();
                    pj.setPrintable(this);
                    if (pj.printDialog()) {

                    }
                }
            }
            if (i == JOptionPane.CANCEL_OPTION) {
                return;
            }
        } else {
        }
    }//GEN-LAST:event_bn99ActionPerformed

    private void tbPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPriceMouseClicked
        selectPrice = tbPrice.getSelectedRow();
        System.out.println("เลือกแถวที่เท่าไหร่ = " + selectPrice);
//        bn99.setEnabled(true);
        System.out.println("se" + selected);
    }//GEN-LAST:event_tbPriceMouseClicked

    private void bn100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn100ActionPerformed
        if (tbPrice.isRowSelected(selectPrice)) {
            int i = JOptionPane.showConfirmDialog(this, "ยืนยันการชำระเงินของคุณ " + tbPrice.getValueAt(selectPrice, 0), "ยืนยันรายการ", JOptionPane.OK_CANCEL_OPTION);
            if (i == JOptionPane.OK_OPTION) {
                model7.removeRow(selectPrice);
            }
            if (i == JOptionPane.CANCEL_OPTION) {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "กรุณาเลือกข้อมูลในตาราง");
        }
    }//GEN-LAST:event_bn100ActionPerformed
    public void clearTable3() {
        txtCategory.setText("");
        txtP.setText("");
    }

    public void clearTable2() {
        roomid.setText("");
        catagoryCombo.setSelectedIndex(0);
    }

    public void clearTable1() {
        txtid.setText("");
        txtName.setText("");
        txtPrice.setText("");
    }

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    public void updateTable3() {
        rowdata2 = new Object[StockCategoryRoom.v.size()][columnName2.length];
        CategoryRoom croom;
        for (int i = 0; i < StockCategoryRoom.v.size(); i++) {
            croom = (CategoryRoom) StockCategoryRoom.v.elementAt(i);
            Double k = Double.valueOf(croom.getPrice());
            rowdata2[i][0] = croom.getCategory_id();
            rowdata2[i][1] = croom.getCategoryName();
            rowdata2[i][2] = df.format(k);
        }
        model2 = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return rowdata2.length;
            }

            @Override
            public int getColumnCount() {
                return columnName2.length;
            }

            public String getColumnName(int column) {
                return columnName2[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowdata2[rowIndex][columnIndex];
            }
        };
        tbCategory.setModel(model2);

    }

    public void updateTable1() {
        rowdata3 = new Object[StockCharges.v.size()][columnName3.length];
        Charges charges;
        for (int i = 0; i < StockCharges.v.size(); i++) {
            charges = (Charges) StockCharges.v.elementAt(i);
            rowdata3[i][0] = charges.getCharges_id();
            rowdata3[i][1] = charges.getChargesName();
            rowdata3[i][2] = charges.getPerUse();
        }
        model3 = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return rowdata3.length;
            }

            @Override
            public int getColumnCount() {
                return columnName3.length;
            }

            public String getColumnName(int column) {
                return columnName3[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowdata3[rowIndex][columnIndex];
            }
        };
        tbPer.setModel(model3);
        updateTable2();
        updateTable3();
        updateTable4();
        updateTable5();
        updateTable6();
    }

    public void updateTable2() {
        rowdata1 = new Object[StockRoom.v.size()][columnName1.length];
        Room room;
        for (int i = 0; i < StockRoom.v.size(); i++) {
            room = (Room) StockRoom.v.elementAt(i);
            rowdata1[i][0] = room.getRoom_id();
            rowdata1[i][1] = room.getLayer();
            rowdata1[i][2] = room.getIdCatygory();
        }
        model1 = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return rowdata1.length;
            }

            @Override
            public int getColumnCount() {
                return columnName1.length;
            }

            public String getColumnName(int column) {
                return columnName1[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowdata1[rowIndex][columnIndex];
            }
        };
        tbRoom.setModel(model1);
    }

    public void updateTable4() {
        rowdata4 = new Object[StockSpending.v.size()][columnName4.length];
        Spending sp;
        for (int i = 0; i < StockSpending.v.size(); i++) {
            sp = (Spending) StockSpending.v.elementAt(i);
            rowdata4[i][0] = sp.getMonth();
            rowdata4[i][1] = sp.getYear();
            rowdata4[i][2] = sp.getRoomid();
            rowdata4[i][3] = sp.getUnit();
            rowdata4[i][4] = sp.getCatagory();
        }
        model4 = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return rowdata4.length;
            }

            @Override
            public int getColumnCount() {
                return columnName4.length;
            }

            public String getColumnName(int column) {
                return columnName4[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowdata4[rowIndex][columnIndex];
            }
        };
        tbDate.setModel(model4);
    }

    public void updateTable5() {
        rowdata5 = new Object[StockRoom.v.size()][columnName5.length];
        Room room;
        for (int i = 0; i < StockRoom.v.size(); i++) {
            room = (Room) StockRoom.v.elementAt(i);
            rowdata5[i][0] = room.getRoom_id();
            rowdata5[i][1] = room.getNameCatygory();
            rowdata5[i][2] = room.getLayer();
        }
        model5 = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return rowdata5.length;
            }

            @Override
            public int getColumnCount() {
                return columnName5.length;
            }

            public String getColumnName(int column) {
                return columnName5[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowdata5[rowIndex][columnIndex];
            }
        };
        tbIn.setModel(model5);
    }

    public void updateTable6() {
        rowdata6 = new Object[StockRent.v.size()][columnName6.length];
        Rent rent;
        for (int i = 0; i < StockRent.v.size(); i++) {
            rent = (Rent) StockRent.v.elementAt(i);
            rowdata6[i][0] = rent.getIdrender();
            rowdata6[i][1] = rent.getNameRen();
            rowdata6[i][2] = rent.getIdroom();
            rowdata6[i][3] = rent.getDatein();
            rowdata6[i][4] = rent.getDateout();
            rowdata6[i][5] = rent.getMoney();
            rowdata6[i][6] = rent.getIdreceipt();
            rowdata6[i][7] = rent.getIdlicence();
        }
        model6 = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return rowdata6.length;
            }

            @Override
            public int getColumnCount() {
                return columnName6.length;
            }

            public String getColumnName(int column) {
                return columnName6[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowdata6[rowIndex][columnIndex];
            }
        };
        tbSelect.setModel(model6);
    }

    public void showMessage(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Admin;
    private javax.swing.JButton add;
    private javax.swing.JButton addData;
    private javax.swing.JButton addData1;
    private javax.swing.JButton addder;
    private javax.swing.JButton bn100;
    private javax.swing.JButton bn99;
    private javax.swing.JButton bndelete;
    private javax.swing.JButton bnsave;
    private javax.swing.JTextField boxcroom;
    private javax.swing.JComboBox catagoryCombo;
    private javax.swing.JButton confirm;
    private javax.swing.JButton confirm1;
    private javax.swing.JButton editData;
    private javax.swing.JButton editData1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox jidlist;
    private com.toedter.calendar.JYearChooser jyear;
    private javax.swing.JComboBox layer;
    private javax.swing.JLabel lb1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel pa2;
    private javax.swing.JPanel pa3;
    private javax.swing.JPanel pa4;
    private javax.swing.JPanel pa5;
    private javax.swing.JPanel pa6;
    private javax.swing.JPanel pl1;
    private javax.swing.JPanel pl2;
    private javax.swing.JPanel pl3;
    private javax.swing.JPanel plrender;
    private javax.swing.JTextField roomid;
    private javax.swing.JSpinner sp;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tbCategory;
    private javax.swing.JTable tbDate;
    private javax.swing.JTable tbIn;
    private javax.swing.JTable tbPer;
    private javax.swing.JTable tbPrice;
    private javax.swing.JTable tbRoom;
    private javax.swing.JTable tbSelect;
    private javax.swing.JTextField txtCategory;
    private com.toedter.calendar.JDateChooser txtDatein;
    private com.toedter.calendar.JDateChooser txtDateout;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtP;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtRen1;
    private javax.swing.JTextField txtRenter;
    private javax.swing.JTextField txtUnit;
    private javax.swing.JTextField txtUnit1;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

    private void clearData() {
        txtUnit.setText("");
    }

    public void run() {
        while (true) {
            try {
                g = new GregorianCalendar();
                now = "วันที่ :" + g.get(g.DAY_OF_MONTH) + "/" + (g.get(g.MONTH) + 1) + "/"
                        + (g.get(g.YEAR) + 543);
                String hour = "" + g.get(g.HOUR_OF_DAY);
                if (hour.length() == 1) {
                    hour = "0" + hour;
                }
                String minute = "" + g.get(g.MINUTE);
                if (minute.length() == 1) {
                    minute = "0" + minute;
                }
                String second = "" + g.get(g.SECOND);
                if (second.length() == 1) {
                    second = "0" + second;
                }
                now = now + " เวลา:" + hour + ":" + minute + ":" + second;
                lb1.setText(now);
                runner.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("เทรดผิดพลาด");
            }
        }

    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        } else {
            Graphics2D g2 = (Graphics2D) graphics;
            g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            pa6.print(g2);
            return PAGE_EXISTS;
        }
    }

}
