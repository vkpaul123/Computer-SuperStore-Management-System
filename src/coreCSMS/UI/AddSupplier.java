/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreCSMS.UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hp-pc
 */
public class AddSupplier extends javax.swing.JInternalFrame {

    public NewMDIApplication mdiObj = null;
    
    /**
     * Creates new form AddSupplier
     */
    public AddSupplier(NewMDIApplication mdiObj) {
        initComponents();
        
        this.mdiObj = mdiObj;
    }
    
        public void initializeThisForm()    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = st.executeQuery("select supplier_id from Suppliers");
            if(rs.next())   {
                while(rs.next())    {}
                rs.previous();
                txtSupplierID.setText(new Integer(rs.getInt(1) + 1).toString());
            }
            else
                txtSupplierID.setText("1");
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
    }
    
    
    public void selectOperationsTab(int tabVal) {
        jTabbedPaneOperation.setSelectedIndex(tabVal);
    }
    
    public void selectOperationsTab2(int paramProduct_id)    {
        this.jTabbedPaneOperation.setSelectedIndex(1);
        this.selectSupplierFromTable(paramProduct_id);
    }
    
    public void selectSupplierFromTable(int paramSupplierID)    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Suppliers where supplier_id = " + paramSupplierID);
            
            while(rs.next())    {
                txtSupplierID1.setText(new Integer(rs.getInt(1)).toString());
                txtSupplierName1.setText(rs.getString(2));
                txtSupplierAddress1.setText(rs.getString(3));
                txtSupplierPhNo1.setText(rs.getString(4));
            }
        }
        catch(ClassNotFoundException e){}
        catch(SQLException e)   {}
    }
    
    public void refreshSupplierDetails()    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = st.executeQuery("select supplier_name, supplier_address, supplier_phno from Suppliers where supplier_id=" + Integer.parseInt(txtSupplierID1.getText()) + "");
            while(rs.next())    {
                txtSupplierName1.setText(rs.getString(1));
                txtSupplierAddress1.setText(rs.getString(2));
                txtSupplierPhNo1.setText(rs.getString(3));
            }
            
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
    }
    
    public void addNewSupplier()    {
        if(!(txtSupplierName.getText().length()==0 && txtSupplierAddress.getText().length()==0 && txtSupplierPhNo.getText().length()==0) && txtSupplierPhNo.getText().length()==10)   {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                
                Statement st = con.createStatement();
                String sqlIn = "insert into Suppliers values(" + Integer.parseInt(txtSupplierID.getText()) + ", '" + txtSupplierName.getText() + "', '" + txtSupplierAddress.getText() + "', '" + txtSupplierPhNo.getText() + "')";
                
                int rs = st.executeUpdate(sqlIn);
                
                JOptionPane.showMessageDialog(rootPane, "New Supplier Added. " + rs + " Row(s) added Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                
                st.close();
                con.close();
                
                mdiObj.viewPeopleObj.setVisible(false);
                mdiObj.viewPeopleObj.setVisible(true);
                mdiObj.viewPeopleObj.requestFocus();
                mdiObj.viewPeopleObj.refreshViewAllTable(2);
            }
            catch(ClassNotFoundException e) {}
            catch(SQLException e)   {}
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Please Enter Complete and Valid Values!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }
    
    public void updateExistingSupplier()    {
        if(!(txtSupplierName1.getText().length()==0 && txtSupplierAddress1.getText().length()==0 && txtSupplierPhNo1.getText().length()==0) && txtSupplierPhNo1.getText().length()==10)   {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                
                Statement st = con.createStatement();
                String sqlUp = "update Suppliers set supplier_name='" + txtSupplierName1.getText() + "', supplier_address='" + txtSupplierAddress1.getText() + "', supplier_phno='" + txtSupplierPhNo1.getText() + "' where supplier_id=" + Integer.parseInt(txtSupplierID1.getText()) + "";
                
                int rs = st.executeUpdate(sqlUp);
                
                JOptionPane.showMessageDialog(rootPane, "Existing Supplier updated. " + rs + " Row(s) updated Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                
                st.close();
                con.close();
                
                mdiObj.viewPeopleObj.setVisible(false);
                mdiObj.viewPeopleObj.setVisible(true);  
                mdiObj.viewPeopleObj.requestFocus();
                mdiObj.viewPeopleObj.refreshViewAllTable(2);
            }
            catch(ClassNotFoundException e) {}
            catch(SQLException e)   {}
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Please Enter Complete and Valid Values!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }
    
    public void deleteExistingSupplier()    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                
            Statement st = con.createStatement();
            String sqlUp = "delete from Suppliers where supplier_id=" + Integer.parseInt(txtSupplierID1.getText()) + "";
                
            int rs = st.executeUpdate(sqlUp);
                
            JOptionPane.showMessageDialog(rootPane, "Existing Supplier Deleted. " + rs + " Row(s) deleted Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                
            st.close();
            con.close();
            
            mdiObj.viewPeopleObj.setVisible(false);
            mdiObj.viewPeopleObj.setVisible(true);  
            mdiObj.viewPeopleObj.requestFocus();
            mdiObj.viewPeopleObj.refreshViewAllTable(2);
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
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
        jTabbedPaneOperation = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSupplierID = new javax.swing.JTextField();
        txtSupplierName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSupplierAddress = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtSupplierPhNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtSupplierPhNo1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSupplierAddress1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtSupplierName1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSupplierID1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add Supplier");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel2.setBackground(java.awt.SystemColor.controlShadow);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.SystemColor.activeCaptionText));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458101912_provider.png"))); // NOI18N

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
        jLabel2.setText("SUPPLIERS");

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("New Supplier Details"));

        jLabel3.setText("Supplier ID:");

        txtSupplierID.setEditable(false);

        jLabel4.setText("Supplier Name:");

        txtSupplierAddress.setColumns(20);
        txtSupplierAddress.setRows(5);
        jScrollPane1.setViewportView(txtSupplierAddress);

        jLabel5.setText("Supplier Address:");

        txtSupplierPhNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSupplierPhNoKeyTyped(evt);
            }
        });

        jLabel6.setText("Supplier Phone Number:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(85, 85, 85)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSupplierPhNo)
                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierName)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap(656, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));
        jPanel5.setPreferredSize(new java.awt.Dimension(209, 395));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686460_arrow-refresh.png"))); // NOI18N
        jButton2.setText("Refresh");
        jButton2.setToolTipText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686465_save_accept.png"))); // NOI18N
        jButton4.setText("Save Supplier");
        jButton4.setToolTipText("Save Supplier");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686462_clear_left.png"))); // NOI18N
        jButton5.setText("Clear All");
        jButton5.setToolTipText("Clear All");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457689449_Delete.png"))); // NOI18N
        jButton6.setText("Cancel");
        jButton6.setToolTipText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneOperation.addTab("Add New Supplier", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Supplier Details"));

        txtSupplierPhNo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSupplierPhNo1KeyTyped(evt);
            }
        });

        jLabel7.setText("Supplier Phone Number:");

        txtSupplierAddress1.setColumns(20);
        txtSupplierAddress1.setRows(5);
        jScrollPane2.setViewportView(txtSupplierAddress1);

        jLabel8.setText("Supplier Address:");

        jLabel9.setText("Supplier Name:");

        jLabel10.setText("Supplier ID:");

        txtSupplierID1.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(85, 85, 85)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSupplierPhNo1)
                    .addComponent(txtSupplierID1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierName1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap(656, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSupplierID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierPhNo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686460_arrow-refresh.png"))); // NOI18N
        jButton7.setText("Refresh");
        jButton7.setToolTipText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686465_save_accept.png"))); // NOI18N
        jButton8.setText("Save Supplier");
        jButton8.setToolTipText("Save Supplier");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458001953_trash.png"))); // NOI18N
        jButton9.setText("Delete Supplier");
        jButton9.setToolTipText("Delete Supplier");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457689449_Delete.png"))); // NOI18N
        jButton10.setText("Cancel");
        jButton10.setToolTipText("Cancel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686462_clear_left.png"))); // NOI18N
        jButton11.setText("Clear All");
        jButton11.setToolTipText("Clear All");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458099966_Download.png"))); // NOI18N
        jButton12.setText("Purchases Transaction");
        jButton12.setToolTipText("Purchases Transaction");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneOperation.addTab("View Supplier", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneOperation)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPaneOperation)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        imagePanelLogo.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\CSMS\\CSMS2 final logo Small.jpg")).getImage());
        repaint();
        
        try {
            this.setMaximum(true);
        }
        catch(java.beans.PropertyVetoException e)  {}
        
        initializeThisForm();
    }//GEN-LAST:event_formFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        refreshSupplierDetails();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Add the Supplier?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            addNewSupplier();            
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Cancel?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            txtSupplierName.setText("");
            txtSupplierAddress.setText("");
            txtSupplierPhNo.setText("");
            this.setVisible(false);
            mdiObj.homePageObj.setVisible(true);
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        refreshSupplierDetails();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to update the Supplier?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            updateExistingSupplier();            
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete the Supplier?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            deleteExistingSupplier();
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(mdiObj.transactionsPurchasesObj.isSalesTxnOpen())    {
            int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Cancel?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION)   {
                mdiObj.transactionsPurchasesObj.setVisible(false);
                mdiObj.transactionsPurchasesObj.setVisible(true);
            }
            else if(res == JOptionPane.NO_OPTION)
                this.setVisible(true);   
        }
        else    {
            int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Cancel?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION)   {
                txtSupplierName1.setText("");
                txtSupplierAddress1.setText("");
                txtSupplierPhNo1.setText("");
                this.setVisible(false);
                mdiObj.viewPeopleObj.setVisible(false);
                mdiObj.viewPeopleObj.setVisible(true);  
                mdiObj.viewPeopleObj.requestFocus();
                mdiObj.viewPeopleObj.refreshViewAllTable(2);
            }
            else if(res == JOptionPane.NO_OPTION)
                this.setVisible(true);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        txtSupplierName1.setText("");
        txtSupplierAddress1.setText("");
        txtSupplierPhNo1.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(mdiObj.transactionsPurchasesObj.isSalesTxnOpen())    {
            mdiObj.transactionsPurchasesObj.addExistingSupplierToTxn(txtSupplierID1.getText(), txtSupplierName1.getText(), txtSupplierAddress1.getText(), txtSupplierPhNo1.getText());
            mdiObj.transactionsPurchasesObj.setVisible(false);
            mdiObj.transactionsPurchasesObj.setVisible(true);        
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Sales Transaction is Not Open! Cannot Add Customer to Sales Transaction", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void txtSupplierPhNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierPhNoKeyTyped
        // TODO add your handling code here:
        int ch = evt.getKeyChar();
        if((!(ch>=48 && ch<=57)) && ch!=8 && ch!=10 && ch!=127 && !(ch>=96 && ch<=105)) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        if(txtSupplierPhNo.getText().length() >= 10)
            evt.consume();
    }//GEN-LAST:event_txtSupplierPhNoKeyTyped

    private void txtSupplierPhNo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierPhNo1KeyTyped
        // TODO add your handling code here:
        int ch = evt.getKeyChar();
        if((!(ch>=48 && ch<=57)) && ch!=8 && ch!=10 && ch!=127 && !(ch>=96 && ch<=105)) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
        if(txtSupplierPhNo1.getText().length() >= 10)
            evt.consume();
    }//GEN-LAST:event_txtSupplierPhNo1KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private coreCSMS.UI.ImagePanel imagePanelLogo;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPaneOperation;
    private javax.swing.JTextArea txtSupplierAddress;
    private javax.swing.JTextArea txtSupplierAddress1;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierID1;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierName1;
    private javax.swing.JTextField txtSupplierPhNo;
    private javax.swing.JTextField txtSupplierPhNo1;
    // End of variables declaration//GEN-END:variables
}
