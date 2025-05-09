/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsystem;

import javax.swing.ImageIcon;



/**
 *
 * @author Raven
 */
public  class userpromt extends javax.swing.JFrame {
public ImageIcon back,homebg;
    

  
    public userpromt() {
        initComponents();    
        jTextArea1.setEditable(false);
        setLocationRelativeTo(null);
        back = new ImageIcon("src\\icons\\back.jpg");
        homebg=new ImageIcon("src\\icons\\uic-logolowopacdako_1.png");
        backg3.setIcon(back);
        logo2.setIcon(homebg);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        startvote = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        backg3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 35, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(995, 100));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ELECTION RULES & REGULATIONS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(419, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 898, 89));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(36, 47, 65));

        jScrollPane1.setHorizontalScrollBar(null);

        jTextArea1.setBackground(new java.awt.Color(23, 35, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("\t\tVoting Day Rules\n\nThe General Local Election is regulated by the Community Charter, the Local\nGovernment Act and the Village of Pemberton General Local Government Election &\nOther Voting Procedures Bylaw No. 831, 2018. Some key rules to follow on voting days:\n\n*Voting is by a secret ballot. Displaying your ballot or discussing your vote\n  or another person's votes is prohibited.\n*Only one person is permitted in a voting booth at a time. \n*Campaigning is prohibited within 100 metres of the Community Centre.\n  Signs, buttons, flyers, and any attempt to influence voters is a violation of the rules. \n*Only eligible electors are permitted in the voting place and they must leave\n  immediately after voting. \n*Vote buying and intimidation are prohibited.\n*Signing a false statement is an offense.\n*Radio and newspaper campaign ads are prohibited on general voting day.\n\n            Election offences can result in a $10,000 fine and up to two years in prison.");
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 800, 400));

        startvote.setBackground(new java.awt.Color(36, 47, 65));
        startvote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startvoteMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("START VOTING");

        javax.swing.GroupLayout startvoteLayout = new javax.swing.GroupLayout(startvote);
        startvote.setLayout(startvoteLayout);
        startvoteLayout.setHorizontalGroup(
            startvoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startvoteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        startvoteLayout.setVerticalGroup(
            startvoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startvoteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(startvote, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 147, 60));
        jPanel2.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 600, 590));

        backg3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        backg3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(backg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 1030, 590));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, 898, 585));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startvoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startvoteMouseClicked
    
        userDashboard x = new userDashboard();
        x.setVisible(true);
      dispose();
      
    }//GEN-LAST:event_startvoteMouseClicked

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
            java.util.logging.Logger.getLogger(userpromt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userpromt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userpromt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userpromt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userpromt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backg3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel logo2;
    private javax.swing.JPanel startvote;
    // End of variables declaration//GEN-END:variables

    
}
