/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsystem;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Raven
 */
public class register extends javax.swing.JFrame {

        public ImageIcon back;
    public register() {
       
        initComponents();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);
            fn.setEnabled(false);
            ln.setEnabled(false);
            combo1.setEnabled(false);
            pass1.setEnabled(false);
            pass2.setEnabled(false);
            r1.setEnabled(false);
            r2.setEnabled(false);
            jButtonRegister.setEnabled(false);
             setLocationRelativeTo(null);
                 back = new ImageIcon("src\\icons\\back.jpg");
     backg.setIcon(back);
    }

    public void checkpass() {
        if (pass1.getText().trim().isEmpty()) {
            idchecker.setText("Fill Password");
            idchecker.setForeground(Color.RED);
        } else if (!(Arrays.equals(pass1.getPassword(),
                pass2.getPassword()))) {
            idchecker.setText("Password Not Matched");
            idchecker.setForeground(Color.RED);
            jButtonRegister.setEnabled(false);
        } else {
            idchecker.setText("Password Matched");
            idchecker.setForeground(Color.GREEN);
            jButtonRegister.setEnabled(true);
        }
    }

    public void idchecker() throws IOException {

        if (id.getText().trim().isEmpty()) {
            checkerrrr1.setText("Please Fill");
            checkerrrr1.setForeground(Color.RED);
            fn.setEnabled(false);
            ln.setEnabled(false);
            combo1.setEnabled(false);
            pass1.setEnabled(false);
            pass2.setEnabled(false);
            r1.setEnabled(false);
            r2.setEnabled(false);
            jButtonRegister.setEnabled(false);
        } else {

            try {
                Long i = Long.parseLong(id.getText());
                checkerrrr1.setText(" ");

                String line, idnum;
                idnum = id.getText();   
                int unamechecker = 0;
                String idno;
                Scanner sc = new Scanner(new FileReader("src\\textFile\\logintxt"));
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    if (line.equals("")) {
                        continue;
                    }
                    Scanner lineinput = new Scanner(line);
                    idno = lineinput.next();

                    if (idnum.equals(idno)) {
                        unamechecker = 1;
                        checkerrrr1.setText("ID Number is Not Available");
                        checkerrrr1.setForeground(Color.RED);
                        fn.setEnabled(false);
                        ln.setEnabled(false);
                        combo1.setEnabled(false);
                        pass1.setEnabled(false);
                        pass2.setEnabled(false);
                        r1.setEnabled(false);
                        r2.setEnabled(false);
                        jButtonRegister.setEnabled(false);
                    } else {
                        continue;

                    }
                }
                if (unamechecker == 0) {
                    checkerrrr1.setText("ID Number is Available");
                    checkerrrr1.setForeground(Color.GREEN);
                    fn.setEnabled(true);
                    ln.setEnabled(true);
                    combo1.setEnabled(true);
                    pass1.setEnabled(true);
                    pass2.setEnabled(true);
                    r1.setEnabled(true);
                    r2.setEnabled(true);
                    jButtonRegister.setEnabled(true);
                }
            } catch (NumberFormatException e) {
                checkerrrr1.setText("Please Fill Numbers Only");
                checkerrrr1.setForeground(Color.RED);
                fn.setEnabled(false);
                ln.setEnabled(false);
                combo1.setEnabled(false);
                pass1.setEnabled(false);
                pass2.setEnabled(false);
                r1.setEnabled(false);
                r2.setEnabled(false);
                jButtonRegister.setEnabled(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     public void checkfln() throws FileNotFoundException{
      String fname =fn.getText();
      String lname =ln.getText();
        Scanner checkfnln=new Scanner(new FileReader("src\\textFile\\users"));  
         while (checkfnln.hasNextLine()) {
                String sf = checkfnln.nextLine();
                if (sf.equals("")) {
                    continue;
                }
                Scanner sz = new Scanner(sf);
                String id=sz.next();
                String first=sz.next();
                String last=sz.next();
                if (fname.equals(first)&& lname.equals(last)){
                    JOptionPane.showMessageDialog(null,"Account Existed");
                }
                else{
                    try {
                saveidpass();
                break;
            } catch (IOException ex) {
                Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
         }        
    }
    
    public void saveidpass() throws IOException {
        String ids, passdd, line, line2, fnss, lnss, combo,gender1,gender2;
        ids = id.getText().trim();
        passdd = pass2.getText().trim();
        fnss = fn.getText().toUpperCase().trim();
        lnss = ln.getText().toUpperCase().trim();
        combo = combo1.getSelectedItem().toString().trim();
        if(r1.isSelected()){
            line = ids + "\t" + passdd + "\t" + "user"+ "\t" + "NotVerified";
        line2 = ids + " " + fnss + " " + lnss + " " + combo + " " + "MALE"+ " " + "NOTYETVOTED";
        save(line, "src\\textFile\\logintxt");
        save(line2, "src\\textFile\\users");
          JOptionPane.showMessageDialog(null, "Account created.");
        }
         if(r2.isSelected()){
            line = ids + "\t" + passdd + "\t" + "user"+ "\t" + "NotVerified";
        line2 = ids + " " + fnss + " " + lnss + " " + combo + " " + "FEMALE"+ " " + "NOTYETVOTED";
        save(line, "src\\textFile\\logintxt");
        save(line2, "src\\textFile\\users");
          JOptionPane.showMessageDialog(null, "Account Created.");
        }
        
    }

    public void save(String a, String path) throws IOException {
        BufferedWriter br;
        br = new BufferedWriter(new FileWriter(path, true));
        br.append(a + "\n");
        br.close();
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        id = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        combo1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButtonRegister = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();
        checkerrrr1 = new javax.swing.JLabel();
        idchecker = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        pass2 = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        backg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        jLabel3.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 640));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Number:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Retype Pass:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 90, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gender:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        r1.setBackground(new java.awt.Color(36, 47, 65));
        r1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        r1.setForeground(new java.awt.Color(255, 255, 255));
        r1.setText("Male");
        jPanel1.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 100, 38));

        r2.setBackground(new java.awt.Color(36, 47, 65));
        r2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        r2.setForeground(new java.awt.Color(255, 255, 255));
        r2.setText("Female");
        jPanel1.add(r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 100, 38));

        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 0));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKeyReleased(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 220, -1));

        fn.setBackground(new java.awt.Color(255, 255, 255));
        fn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        fn.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 220, -1));

        ln.setBackground(new java.awt.Color(255, 255, 255));
        ln.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ln.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 220, -1));

        combo1.setBackground(new java.awt.Color(255, 255, 255));
        combo1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        combo1.setForeground(new java.awt.Color(0, 0, 0));
        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course", "CABE", "CEA", "CTE", "CCS", "CAH", "CMBS", "MUSIC", "NURSING", "CHEFS", "CPC", "" }));
        combo1.setBorder(null);
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });
        jPanel1.add(combo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 220, -1));

        jButton2.setBackground(new java.awt.Color(36, 47, 65));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear");
        jButton2.setBorder(null);
        jButton2.setPreferredSize(new java.awt.Dimension(36, 19));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 391, 147, 45));

        jButtonRegister.setBackground(new java.awt.Color(36, 47, 65));
        jButtonRegister.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButtonRegister.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegister.setText("Register");
        jButtonRegister.setBorder(null);
        jButtonRegister.setPreferredSize(new java.awt.Dimension(36, 19));
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 391, 147, 45));

        jLabelRegister.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabelRegister.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegister.setText("click here to login");
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        checkerrrr1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        checkerrrr1.setText(" ");
        jPanel1.add(checkerrrr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 220, 20));

        idchecker.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        idchecker.setText(" ");
        jPanel1.add(idchecker, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 220, 20));

        pass1.setBackground(new java.awt.Color(255, 255, 255));
        pass1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pass1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 220, -1));

        pass2.setBackground(new java.awt.Color(255, 255, 255));
        pass2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pass2.setForeground(new java.awt.Color(0, 0, 0));
        pass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pass2KeyReleased(evt);
            }
        });
        jPanel1.add(pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 220, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("_____________________");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, -1, -1));
        jPanel1.add(backg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -540, 620, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 525));

        jPanel2.setBackground(new java.awt.Color(23, 35, 51));
        jPanel2.setForeground(new java.awt.Color(36, 47, 65));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 90));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("REGISTRATION FORM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegisterMouseClicked
        login lgf = new login();
        lgf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelRegisterMouseClicked

    private void pass2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyReleased
        checkpass();
    }//GEN-LAST:event_pass2KeyReleased
   
    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
       String a =combo1.getSelectedItem().toString();
      
           if (fn.getText().trim().isEmpty() 
                && ln.getText().trim().isEmpty() 
                && id.getText().trim().isEmpty() 
                && pass1.getText().trim().isEmpty() 
                && pass2.getText().trim().isEmpty() 
                && combo1.equals("Select Course") 
                && r1.isSelected() == false 
                && r2.isSelected() == false)
        {
            JOptionPane.showMessageDialog(null, "Enter All Fields");
        } else if (id.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID Field");
        } else if (fn.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter First Name Field");
        } else if (ln.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Last Name Field");
        } else if (a.equals("Select Course")) {
            JOptionPane.showMessageDialog(null, "Choose Department");
        } else if (pass1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Password Field");
        } else if (pass2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Field");
        } else if (r1.isSelected() == false && r2.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Select Gender");
        } else {
           try {
               checkfln();
           } catch (FileNotFoundException ex) {
               Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
      
    }//GEN-LAST:event_combo1ActionPerformed

    private void idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyReleased

        try {
            idchecker();
        } catch (IOException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_idKeyReleased

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     id.setText("");
      fn.setText("");
       ln.setText("");
        pass1.setText("");
         pass2.setText("");
        combo1.setSelectedIndex(0);
        try {
            idchecker();
        } catch (IOException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel checkerrrr1;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JTextField fn;
    private javax.swing.JTextField id;
    private javax.swing.JLabel idchecker;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField ln;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    // End of variables declaration//GEN-END:variables
}
