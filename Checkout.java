
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Checkout extends javax.swing.JFrame {
     Connection con=null;
     Statement st=null;
     PreparedStatement pst=null;
     ResultSet rs=null;
 
    public Checkout() {
        initComponents();
        
        SimpleDateFormat obj=new SimpleDateFormat("yyyy/MM/dd");
        Date date=new Date();
        txtoutdate.setText(obj.format(date));
        try {
                 Class.forName("com.mysql.jdbc.Driver");
                 con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
             } catch (ClassNotFoundException | SQLException ex) {
                 Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
             }
           showDataInTOTab();
       
         }
       public void showDataInTOTab(){
           
            
         try {
             pst=con.prepareStatement("select * from customer where status=?");
             pst.setString(1, "NULL");
             ResultSet rs=pst.executeQuery();
             ResultSetMetaData ob=rs.getMetaData();
             int n=ob.getColumnCount();
             DefaultTableModel df=(DefaultTableModel) jTable1.getModel();
             df.setRowCount(0);
             while(rs.next()){
                 Vector v=new Vector();
                 for(int i=1;i<=n;i++){
                     v.add(rs.getString("name"));
                     v.add(rs.getString("mobile"));
                     v.add(rs.getString("id"));
                     v.add(rs.getString("roomnumber"));
                     v.add(rs.getString("bed"));
                     v.add(rs.getString("roomtype"));
                     v.add(rs.getString("date"));
                     v.add(rs.getString("price"));
                     v.add(rs.getString("nationality"));
                   
                 }
                 df.addRow(v);
             
             }
             
             
         } catch (SQLException ex) {
             Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
         }
           
            
       
       
       }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtroomnumber = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtindate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtoutdate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtdays = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtamount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 19, 21));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/out.jpg"))); // NOI18N
        jLabel1.setText("Coustomer Check Out");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 30, 266, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Room Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 123, -1, -1));

        txtroomnumber.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        getContentPane().add(txtroomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 117, 119, 31));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 119, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Customer Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 230, 135, -1));

        txtname.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 256, 165, 33));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Mobile Number");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 230, -1, -1));

        txtmobile.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobileActionPerformed(evt);
            }
        });
        getContentPane().add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 255, 165, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("NID Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 230, -1, -1));

        txtnid.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtnid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnidActionPerformed(evt);
            }
        });
        getContentPane().add(txtnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 255, 155, 35));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Price Per Day");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 315, -1, -1));

        txtprice.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 341, 165, 36));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Check in Date");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 415, -1, -1));

        txtindate.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        getContentPane().add(txtindate, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 440, 165, 35));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Check out Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 414, -1, -1));

        txtoutdate.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        getContentPane().add(txtoutdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 439, 165, 36));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer Name", "Mobile Number", "NID Number", "Room Number", "Bed Type", "Rome Type", "Check in Date", "Price Per Day", "Nationality"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 514, 921, 240));

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Check Out New");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 444, -1, -1));

        jButton4.setBackground(new java.awt.Color(204, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 444, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Number of Days");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 315, -1, -1));

        txtdays.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        getContentPane().add(txtdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 341, 165, 36));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setText("Total Amount");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 315, -1, -1));

        txtamount.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        getContentPane().add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 153, 36));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/123.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobileActionPerformed

    private void txtnidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnidActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
         try {
             pst=con.prepareStatement("select * from customer where roomnumber=? and status=?");
             pst.setString(1, txtroomnumber.getText());
             pst.setString(2, "NULL");
             rs=pst.executeQuery();
             if(rs.next()){
                 
                 txtname.setText(rs.getString("name"));
                 txtmobile.setText(rs.getString("mobile"));
                 txtnid.setText(rs.getString("id"));
                 txtprice.setText(rs.getString("price"));
                 txtindate.setText(rs.getString("date"));
                 
             
             }
             
             String s1,s2;
             s1=txtoutdate.getText();
             s2=rs.getString("date");
             SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
             
             Date d1=format.parse(s2);
             Date d2=format.parse(s2);
             long diff=d1.getTime()-d2.getTime();
             int days=(int)diff/(24*60*60*1000);
             if(days==0)
                 days=1;
             txtdays.setText(String.valueOf(days));
             double price=Double.parseDouble(rs.getString("price"))*days;
             txtamount.setText(String.valueOf(price));
             
             
         } catch (SQLException ex) {
             Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ParseException ex) {
             Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         txtname.setText("");
         txtmobile.setText("");
         txtnid.setText("");
         txtprice.setText("");
         txtdays.setText("");
         txtindate.setText("");
         //txtoutdate.setText("");
         txtamount.setText("");
        
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
         try {
             pst=con.prepareStatement("update customer1 set status=? where roomnumber=? and date=?");
             pst.setString(1, "check-out");
             pst.setString(2, txtroomnumber.getText());
             pst.setString(3, txtindate.getText());
             pst.executeUpdate();
             pst=con.prepareStatement("update room set status=? where roomnumber=?");
             pst.setString(1, "NOT-BOOKED");
             pst.setString(2, txtroomnumber.getText());
             pst.executeUpdate();
             JOptionPane.showMessageDialog(this, "Check Out Successfully");
             showDataInTOTab();
             
             txtname.setText("");
         txtmobile.setText("");
         txtnid.setText("");
         txtprice.setText("");
         txtdays.setText("");
         txtindate.setText("");
         //txtoutdate.setText("");
         txtamount.setText("");
              
             
         } catch (SQLException ex) {
             Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtdays;
    private javax.swing.JTextField txtindate;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnid;
    private javax.swing.JTextField txtoutdate;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtroomnumber;
    // End of variables declaration//GEN-END:variables

}
