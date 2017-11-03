/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreCSMS.UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 *
 * @author hp-pc
 */
public class InvoiceRecords extends javax.swing.JInternalFrame {

    public NewMDIApplication mdiObj = null;
    
    /**
     * Creates new form InvoiceRecords
     */
    public InvoiceRecords(NewMDIApplication mdiObj) {
        initComponents();
        this.mdiObj = mdiObj;
    }
    
    public void refreshViewAllTable()  {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from Sales_Billing order by sales_id");
            ResultSetMetaData rsMeta = rs.getMetaData();
            rs.setFetchDirection(ResultSet.FETCH_FORWARD);
            int columnCount = rsMeta.getColumnCount();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                    
            tableModel.setRowCount(0);
            int i,j;
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
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from Purchases_Billing order by purchase_id");
            ResultSetMetaData rsMeta = rs.getMetaData();
            rs.setFetchDirection(ResultSet.FETCH_FORWARD);
            int columnCount = rsMeta.getColumnCount();
            DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
                    
            tableModel.setRowCount(0);
            while(rs.next())    {
                int i,j;
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
    }
    
    public void searchInvoice() {
        refreshViewAllTable();
        
        switch(jTabbedPaneBilling.getSelectedIndex())    {
            case 0:
                if(txtSearchKey.getText().length()!=0)   {
                    try {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("Select * from Sales_Billing where sales_id=" + txtSearchKey.getText() + " order by sales_id");
                        ResultSetMetaData rsMeta = rs.getMetaData();
                        rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                        int columnCount = rsMeta.getColumnCount();
                        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                    
                        tableModel.setRowCount(0);
                        if(!rs.next())  {
                            JOptionPane.showMessageDialog(rootPane, "Record Not Found!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                            refreshViewAllTable();
                            rs.close();
                        }
                        else    {
                            int i,j;
                            rs = st.executeQuery("Select * from Sales_Billing where sales_id=" + txtSearchKey.getText() + " order by sales_id");
                            rsMeta = rs.getMetaData();
                            rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                            columnCount = rsMeta.getColumnCount();
                            tableModel = (DefaultTableModel) jTable1.getModel();
                    
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
                        }
                        
                        st.close();
                        con.close();                    
                    }
                    catch(ClassNotFoundException cnfe) {}
                    catch(SQLException sqle)    {}
                }
                else
                    JOptionPane.showMessageDialog(rootPane, "Please Enter Complete and Valid Values!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                break;
                
            case 1:
                if(txtSearchKey.getText().length()!=0)   {
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * from Purchases_Billing where purchase_id=" + txtSearchKey.getText() + " order by purchase_id");
                    ResultSetMetaData rsMeta = rs.getMetaData();
                    rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                    int columnCount = rsMeta.getColumnCount();
                    DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
                    
                    tableModel.setRowCount(0);
                    if(!rs.next())  {
                        JOptionPane.showMessageDialog(rootPane, "Customer Not Found!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                        refreshViewAllTable();
                            rs.close();
                    }
                    else    {
                        int i,j;
                        rs = st.executeQuery("Select * from Purchases_Billing where purchase_id=" + txtSearchKey.getText() + " order by purchase_id");
                        rsMeta = rs.getMetaData();
                        rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                        columnCount = rsMeta.getColumnCount();
                        tableModel = (DefaultTableModel) jTable2.getModel();
                    
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
                    }
                     
                    st.close();
                    con.close();
                    
                }
                catch(ClassNotFoundException cnfe) {}
                catch(SQLException sqle)    {}
                }
                else
                    JOptionPane.showMessageDialog(rootPane, "Please Enter Complete and Valid Values!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                break;
        }
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
        jTabbedPaneBilling = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSearchKey = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("View Invoice Records");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel2.setBackground(java.awt.SystemColor.controlShadow);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.SystemColor.activeCaptionText));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458260993_document.png"))); // NOI18N

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
        jLabel2.setText("VIEW INVOICE RECORDS");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 806, Short.MAX_VALUE)
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTabbedPaneBilling.addTab("Sales Billing Invoices", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PURCHASE ID", "SUPPLIER ID", "PURCHASE TOTAL AMOUNT", "PURCHASE DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTabbedPaneBilling.addTab("Purchases Billing Invoices", jScrollPane2);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686460_arrow-refresh.png"))); // NOI18N
        jButton2.setText("Refresh");
        jButton2.setToolTipText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Search Sales ID/Purchase ID:");

        txtSearchKey.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtSearchKey.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchKeyFocusGained(evt);
            }
        });
        txtSearchKey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyKeyTyped(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458091263_xmag.png"))); // NOI18N
        jButton3.setText("Search");
        jButton3.setToolTipText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458270327_Form.png"))); // NOI18N
        jButton1.setText("Generate Invoice");
        jButton1.setToolTipText("Generate Invoice");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneBilling)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPaneBilling, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtSearchKey.setText("");
        refreshViewAllTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtSearchKeyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchKeyFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchKeyFocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        searchInvoice();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex;
        txtSearchKey.setText("");

        switch(jTabbedPaneBilling.getSelectedIndex())  {
            case 0:
            selectedRowIndex = jTable1.getSelectedRow();
            if(selectedRowIndex != -1)  {
                mdiObj.transactionSalesInvoiceObj.generateExistingInvoice((jTable1.getModel().getValueAt(selectedRowIndex, 0)).toString());
                mdiObj.transactionSalesInvoiceObj.setVisible(false);
                mdiObj.transactionSalesInvoiceObj.setVisible(true);
                mdiObj.transactionSalesInvoiceObj.setOriginalInvoice(false);
                mdiObj.transactionSalesInvoiceObj.requestFocus();
                this.mdiObj.setEnabled(false);
            }
            else    {
                JOptionPane.showMessageDialog(rootPane, "Please Select a Record first!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            }
            break;

            case 1:
            selectedRowIndex = jTable2.getSelectedRow();
            if(selectedRowIndex != -1)  {
                mdiObj.transactionPurchasesInvoiceObj.generateExistingInvoice((jTable2.getModel().getValueAt(selectedRowIndex, 0)).toString());
                mdiObj.transactionPurchasesInvoiceObj.setVisible(false);
                mdiObj.transactionPurchasesInvoiceObj.setVisible(true);
                mdiObj.transactionPurchasesInvoiceObj.setOriginalInvoice(false);
                mdiObj.transactionPurchasesInvoiceObj.requestFocus();
                this.mdiObj.setEnabled(false);
            }
            else    {
                JOptionPane.showMessageDialog(rootPane, "Please Select a Record first!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            }
            break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSearchKeyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyKeyTyped
        // TODO add your handling code here:
        int ch = evt.getKeyChar();
        if((!(ch>=48 && ch<=57)) && ch!=8 && ch!=10 && ch!=127 && !(ch>=96 && ch<=105)) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtSearchKeyKeyTyped

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        imagePanelLogo.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\CSMS\\CSMS2 final logo Small.jpg")).getImage());
        repaint();
        
        try {
            this.setMaximum(true);
        }
        catch(java.beans.PropertyVetoException e)  {}
        refreshViewAllTable();
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private coreCSMS.UI.ImagePanel imagePanelLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPaneBilling;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtSearchKey;
    // End of variables declaration//GEN-END:variables
}
