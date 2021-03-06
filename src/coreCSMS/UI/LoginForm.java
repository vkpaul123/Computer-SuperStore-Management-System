/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreCSMS.UI;

/**
 *
 * @author hp-pc
 */

import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.Timer;

public class LoginForm extends javax.swing.JFrame {

    public NewMDIApplication newMDIApplicationObj = null;
    public WelcomeForm welcomeFormObj = null;
        
    /**
     * Creates new form LoginForm
     */
    public LoginForm() {  
        newMDIApplicationObj = new NewMDIApplication(this);
        newMDIApplicationObj.setVisible(false);
        newMDIApplicationObj.setEnabled(false);
        
        welcomeFormObj = new WelcomeForm(this);
        welcomeFormObj.setVisible(false);
        welcomeFormObj.setEnabled(false);
        initComponents();
    }

    int loginAttempts=5;
    static String uname = new String();
    
    TimerTask tasknew = new TimerTask() {       
        public void run()  {
            if(jProgressBar1.getValue() == 100) {
                cancel();
                dispose();
                JOptionPane.showMessageDialog(rootPane, "Log In Successfull!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);    
                welcomeFormObj.setVisible(true);
                welcomeFormObj.setEnabled(true);
                welcomeFormObj.startTimer();
            }
            else    {
                jProgressBar1.setValue(jProgressBar1.getValue() + 2);
            }
        }    
    };
    
    
    public static String getUsername() {
        return uname;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CSMS - Login");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456801846_key_go.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setToolTipText("Login...");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456623218_f-cross_256.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setToolTipText("Cancel and Close");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel3.setText("(Number of Login Attempts Remaining...5 of 5)");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logos/CSMS/Vertical CSMS2 final logo Smaller.jpg"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456622100_eye.png"))); // NOI18N
        jButton1.setToolTipText("See Typed Password");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setToolTipText("");
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(jTextField1)))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnLogin)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void loginExecute()  {
        if(txtUsername.getText().toString().equals("") || txtPassword.getText().toString().equals(""))  {
            txtUsername.setText("");
            txtPassword.setText("");
            JOptionPane.showMessageDialog(rootPane, "Please enter Complete Values!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
        }
        else    {
            Timer timer =new Timer();
            if(loginAttempts != 0) {
                try {
                    /*
                
                    Class.forName("com.mysql.jdbc.Driver");
                    String conString = "jdbc:mysql//localhost:3306/csms_db";
                    Connection con = DriverManager.getConnection(conString, "root", "vkpaul123");
                    */
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");   
                    
                    Statement st = con.createStatement();
                    String sqlq = "select * from admins where username = '" + txtUsername.getText() + "' and password = '" + txtPassword.getText() + "'";
            
                    ResultSet rs = st.executeQuery(sqlq);
                    if(rs.next())   {
                        uname = txtUsername.getText();
                        txtPassword.setText("");
                        txtUsername.setText("");
                        st.close();
                        con.close();
                        timer.schedule(tasknew, 0,1);
                    }
                    else    {
                        txtPassword.setText("");
                        txtUsername.setText("");
                        loginAttempts--;
                        jLabel3.setText("(Number of Login Attempts Remaining..." + loginAttempts +  " of 5)");
                        JOptionPane.showMessageDialog(rootPane, "Error. Username/Passworrd Incorrect!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                        txtUsername.requestFocus();
                    }
                    st.close();
                    con.close();
                }
                catch(ClassNotFoundException cnfe)  {
                    txtUsername.setText("");
                    txtPassword.setText("");
                    JOptionPane.showMessageDialog(rootPane, cnfe, "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                }
                catch(SQLException sqle)  {
                    txtUsername.setText("");
                    txtPassword.setText("");
                    JOptionPane.showMessageDialog(rootPane, sqle, "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                }
            }
            else    {
                JOptionPane.showMessageDialog(rootPane, "No more Login Attempts Remainig!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        loginExecute();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.askToClose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        jTextField1.setText(txtPassword.getText());
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
        jTextField1.setText("");
    }//GEN-LAST:event_jButton1MouseReleased

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        int ch = evt.getExtendedKeyCode();
        if(ch == KeyEvent.VK_ENTER)
            loginExecute();
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        int ch = evt.getExtendedKeyCode();
        if(ch == KeyEvent.VK_ENTER)
            loginExecute();
    }//GEN-LAST:event_txtUsernameKeyPressed

    public int askToClose()    {
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to exit?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)
            System.exit(0);
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);        
        return 0;
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
