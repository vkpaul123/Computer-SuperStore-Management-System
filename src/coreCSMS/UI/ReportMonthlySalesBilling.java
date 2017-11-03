/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreCSMS.UI;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp-pc
 */
public class ReportMonthlySalesBilling extends javax.swing.JFrame {

    
    public NewMDIApplication mdiObj = null;
            
    /**
     * Creates new form ReportSalesBilling
     */
    public ReportMonthlySalesBilling() { initComponents();}
    public ReportMonthlySalesBilling(NewMDIApplication mdiObj) {
        initComponents();
        this.mdiObj = mdiObj;
    }
    
    public void fillFromSalesBillingTable()    {
        try {
            int i,j;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from Sales_Billing where sales_date like '%" + selectMonth() + "%' order by sales_id");
            ResultSetMetaData rsMeta = rs.getMetaData();
            rs.setFetchDirection(ResultSet.FETCH_FORWARD);
            int columnCount = rsMeta.getColumnCount();
            DefaultTableModel tableModel = (DefaultTableModel) jTableProducts.getModel();
                    
            tableModel.setRowCount(0);
            while(rs.next())    {
                String[] conList = new String[columnCount];
                for(i = 1, j = 0; i <= columnCount-1; i++, j++)   {
                    conList[j] = rs.getString(i);
                }                
                conList[j] = rs.getString(columnCount).substring(0, 10);
                tableModel.addRow(conList);
            }
            rs.close();
            st.close();
            con.close();
                    
            }
            catch(ClassNotFoundException cnfe) {}
            catch(SQLException sqle)    {}
        totalMonthlySales();
    }
    
    public void printSalesBillingTable()  {
        MessageFormat header = new MessageFormat("MONTHLY SALES BILLING REPORT");    
        MessageFormat footer = new MessageFormat("TOTAL MONTHLY SALES (RS.): " + totalMonthlySales() + " /-.        PAGE {0}");    
        
        try {
            boolean complete = jTableProducts.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, null, true, null);
            
            if(complete)    {
                JOptionPane.showMessageDialog(rootPane, "Printing Complete.", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(rootPane, "Printing Cancelled.", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        catch(PrinterException e)   {
            JOptionPane.showMessageDialog(rootPane, "Printing Failed! " + e.getMessage(), "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void initializeForm()    {
        genRpt = false;
        jComboBoxMonth.setEditable(true);
        jComboBoxMonth.setSelectedIndex(0);
        jComboBoxMonth.setEditable(false);
        
        jComboBoxYear.setEditable(true);
        jComboBoxYear.setSelectedIndex(0);
        jComboBoxYear.setEditable(false);
    }
    
    public String selectMonth() {
        String month = null;
        if(jComboBoxMonth.getSelectedIndex()!=0 && jComboBoxYear.getSelectedIndex()!=0) {            

            switch(jComboBoxMonth.getSelectedIndex())   {
                case 1:
                    month = "01";
                    break;
                case 2:
                    month = "02";
                    break;
                case 3:
                    month = "03";
                    break;
                case 4:
                    month = "04";
                    break;
                case 5:
                    month = "05";
                    break;
                case 6:
                    month = "06";
                    break;
                case 7:
                    month = "07";
                    break;
                case 8:
                    month = "08";
                    break;
                case 9:
                    month = "09";
                    break;
                case 10:
                    month = "10";
                    break;
                case 11:
                    month = "11";
                    break;
                case 12:
                    month = "12";
                    break;
            }
            switch(jComboBoxYear.getSelectedIndex())    {
                case 1:
                    month = month + "-2015";
                    break;
                case 2:   
                    month = month + "-2016";
                    break;
            }
        }
        return month;
    }
    
    public String totalMonthlySales()   {
        int total=0, i=0;
        for(i=0; i<jTableProducts.getModel().getRowCount(); i++)  {
            total = total + Integer.parseInt(jTableProducts.getValueAt(i, 2).toString());
        }
        jLabel6.setText(new Integer(total).toString());
        return new Integer(total).toString();
    }
    
    private boolean genRpt = false;
    public boolean isReportGenrated()   {
        return genRpt;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        imagePanelLogo = new coreCSMS.UI.ImagePanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxMonth = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxYear = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CSMS - Sales Billing Report");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel2.setBackground(java.awt.SystemColor.controlShadow);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.SystemColor.activeCaptionText));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/Transactions.png"))); // NOI18N

        jSeparator2.setBackground(java.awt.SystemColor.desktop);
        jSeparator2.setForeground(java.awt.SystemColor.controlLtHighlight);
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout imagePanelLogoLayout = new javax.swing.GroupLayout(imagePanelLogo);
        imagePanelLogo.setLayout(imagePanelLogoLayout);
        imagePanelLogoLayout.setHorizontalGroup(
            imagePanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        imagePanelLogoLayout.setVerticalGroup(
            imagePanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("SALES BILLING REPORT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(imagePanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SALES ID", "CUSTOMER ID", "SALES TOTAL AMOUNT", "SALES DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProducts.setEnabled(false);
        jTableProducts.setFillsViewportHeight(true);
        jTableProducts.setFocusable(false);
        jTableProducts.setGridColor(new java.awt.Color(255, 255, 255));
        jTableProducts.setIntercellSpacing(new java.awt.Dimension(20, 20));
        jTableProducts.setName(""); // NOI18N
        jTableProducts.setRequestFocusEnabled(false);
        jTableProducts.setRowHeight(30);
        jTableProducts.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTableProducts);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458186841_print_printer.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.setToolTipText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Month:");

        jComboBoxMonth.setMaximumRowCount(12);
        jComboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Select Month)", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jLabel4.setText("Year:");

        jComboBoxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Select Year)", "2015", "2016" }));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458270327_Form.png"))); // NOI18N
        jButton2.setText("Generate Report");
        jButton2.setToolTipText("Generate Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Total Monthly Sales (Rs.):");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(94, 94, 94)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel3)
                        .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jComboBoxMonth.getSelectedIndex()!=0 && jComboBoxYear.getSelectedIndex()!=0 && isReportGenrated() && jTableProducts.getRowCount()!=0)
            printSalesBillingTable();
        else
            JOptionPane.showMessageDialog(rootPane, "Please Select a Valid Month and Year!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        imagePanelLogo.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\CSMS\\CSMS2 final logo Small.jpg")).getImage());
        repaint();
        
        initializeForm();
        
    }//GEN-LAST:event_formFocusGained

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        mdiObj.setEnabled(true);
        mdiObj.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jComboBoxMonth.getSelectedIndex()!=0 && jComboBoxYear.getSelectedIndex()!=0)   {     
            fillFromSalesBillingTable();
            genRpt = true;
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Please Select a Valid Month and Year!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);    
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ReportMonthlySalesBilling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportMonthlySalesBilling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportMonthlySalesBilling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportMonthlySalesBilling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportMonthlySalesBilling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private coreCSMS.UI.ImagePanel imagePanelLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxMonth;
    private javax.swing.JComboBox<String> jComboBoxYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableProducts;
    // End of variables declaration//GEN-END:variables
}
