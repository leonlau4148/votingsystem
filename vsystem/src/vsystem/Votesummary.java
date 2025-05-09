/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsystem;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static vsystem.userDashboard.assistantsecretarycombobox;
import static vsystem.userDashboard.auditorcombobox;
import static vsystem.userDashboard.piocombobox;
import static vsystem.userDashboard.secretarycombobox;
import static vsystem.userDashboard.treasurercombobox;
import static vsystem.userDashboard.vgexternalcombobox;
import static vsystem.userDashboard.vginternalcombobox;

/**
 *
 * @author Raven
 */
public class Votesummary extends javax.swing.JFrame {

    
    public Votesummary() {
        initComponents();
     try{
        addvote();}
    catch (FileNotFoundException ex) {
            Logger.getLogger(Votesummary.class.getName()).log(Level.SEVERE, null, ex);
        }
    catch (IOException ex) {
            Logger.getLogger(Votesummary.class.getName()).log(Level.SEVERE, null, ex);
        }
     setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        poss1 = new javax.swing.JLabel();
        poss2 = new javax.swing.JLabel();
        poss3 = new javax.swing.JLabel();
        poss8 = new javax.swing.JLabel();
        poss7 = new javax.swing.JLabel();
        poss6 = new javax.swing.JLabel();
        poss5 = new javax.swing.JLabel();
        poss4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Governor:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 71, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vice-Governor(INTERNAL):");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 96, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vice-Governor(EXTERNAL):");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 121, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Secretary:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 146, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Public Information Officer:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 246, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Auditor:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 221, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Treasurer:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 196, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Assistant Secretary:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 171, -1, -1));

        poss1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        poss1.setForeground(new java.awt.Color(255, 255, 255));
        poss1.setText("           ");
        jPanel1.add(poss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 71, -1, -1));

        poss2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        poss2.setForeground(new java.awt.Color(255, 255, 255));
        poss2.setText("      ");
        jPanel1.add(poss2, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 96, -1, -1));

        poss3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        poss3.setForeground(new java.awt.Color(255, 255, 255));
        poss3.setText("            ");
        jPanel1.add(poss3, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 121, -1, -1));

        poss8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        poss8.setForeground(new java.awt.Color(255, 255, 255));
        poss8.setText("           ");
        jPanel1.add(poss8, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 246, -1, -1));

        poss7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        poss7.setForeground(new java.awt.Color(255, 255, 255));
        poss7.setText("         ");
        jPanel1.add(poss7, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 221, -1, -1));

        poss6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        poss6.setForeground(new java.awt.Color(255, 255, 255));
        poss6.setText("       ");
        jPanel1.add(poss6, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 196, -1, -1));

        poss5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        poss5.setForeground(new java.awt.Color(255, 255, 255));
        poss5.setText("             ");
        jPanel1.add(poss5, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 171, -1, -1));

        poss4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        poss4.setForeground(new java.awt.Color(255, 255, 255));
        poss4.setText("         ");
        jPanel1.add(poss4, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 146, -1, -1));

        jButton1.setBackground(new java.awt.Color(36, 47, 65));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 324, 147, 45));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 830));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 530, 400));

        jPanel2.setBackground(new java.awt.Color(23, 35, 51));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("VOTE SUMMARY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
        new login().setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

   public void addvote() throws FileNotFoundException, IOException{
       
       //textlabel 
       String num1,num2,num3,num4,num5,num6,num7,num8;
       num1=poss1.getText();
       num2=poss2.getText();
       num3=poss3.getText();
       num4=poss4.getText();
       num5=poss5.getText();
       num6=poss6.getText();
       num7=poss7.getText();
       num8=poss8.getText();
       //geting values in userdashboard combobox 
       //by using design> clicking combobox>right click and customize code to public and checking static
           String x1 = userDashboard.governorcombobox.getSelectedItem().toString();
               String x2 = userDashboard.vginternalcombobox.getSelectedItem().toString();
                   String x3 = userDashboard.vgexternalcombobox.getSelectedItem().toString();
                       String x4 = userDashboard.secretarycombobox.getSelectedItem().toString();
                           String x5 = userDashboard.assistantsecretarycombobox.getSelectedItem().toString();
                               String x6 = userDashboard.treasurercombobox.getSelectedItem().toString();
                                   String x7 = userDashboard.auditorcombobox.getSelectedItem().toString();
                                       String x8 = userDashboard.piocombobox.getSelectedItem().toString();
           //adding vote                            
        String fline,content="";
        Scanner in =new Scanner(new FileReader("src\\textFile\\votes"));
        while(in.hasNextLine()){
        fline = in.nextLine();
        if(fline.equals("")){
            continue;
        }
        else{
            Scanner sc1 = new Scanner (fline);
            String fname=sc1.next();
            String lname=sc1.next();
            String wholeline=fname+" "+lname;
           if(wholeline.equals(x1)||wholeline.equals(x2)||wholeline.equals(x3)||wholeline.equals(x4)||
                   wholeline.equals(x5)||wholeline.equals(x6)||wholeline.equals(x7)||wholeline.equals(x8)){
                 String stock = sc1.next();
                 int addvote = 1;
                 if(Integer.parseInt(stock) == 0){
                     fline=fname+" "+lname+" "+ "1";   
                 }
                 if(Integer.parseInt(stock) != 0){
                     addvote = addvote + Integer.parseInt(stock);
                     fline=fname+" "+lname+" "+ addvote;   
                 }
           }
            
            content=content+fline+"\n";
        }
    } 
        
         BufferedWriter bw= new BufferedWriter(new  FileWriter("src\\textFile\\votes")) ;
        bw.append(content);
        bw.close();                        
                     
                       }
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
            java.util.logging.Logger.getLogger(Votesummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Votesummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Votesummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Votesummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Votesummary().setVisible(true);
                   
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel poss1;
    public static javax.swing.JLabel poss2;
    public static javax.swing.JLabel poss3;
    public static javax.swing.JLabel poss4;
    public static javax.swing.JLabel poss5;
    public static javax.swing.JLabel poss6;
    public static javax.swing.JLabel poss7;
    public static javax.swing.JLabel poss8;
    // End of variables declaration//GEN-END:variables
}
