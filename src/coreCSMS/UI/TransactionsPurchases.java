/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreCSMS.UI;

import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp-pc
 */
public class TransactionsPurchases extends javax.swing.JInternalFrame {

    public NewMDIApplication mdiObj = null;
    
    /**
     * Creates new form TransactionsPurchases
     */
    public TransactionsPurchases(NewMDIApplication mdiObj) {
        initComponents();
        this.mdiObj = mdiObj;
    }
    
    private boolean txnOpenValue = false;
    
    public boolean isSalesTxnOpen() {
        return txnOpenValue;
    }
    
    public void initializeThisForm()    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = st.executeQuery("select purchase_id from Purchases_Billing");
            if(rs.next())   {
                while(rs.next())    {}
                rs.previous();
                txtPurchaseID.setText(new Integer(rs.getInt(1) + 1).toString());
            }
            else
                txtPurchaseID.setText("1");
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
        
        txtPurchaseDate.setText(mdiObj.sendDate());
        txnOpenValue = false;
        
        jRadioButtonAddNew.setSelected(true);
        jCheckBoxCreateNewTxn.setSelected(false);
        txtSupplierName.setText("");
        txtSupplierAddress.setText("");
        txtSupplierPhNo.setText("");
        txtGrandTotal.setText("0");
        
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        jButton10.setEnabled(true);
        jButton11.setEnabled(true);
        
        fetchSupplierIDFromSuppliersTable();
        refreshPurchaseOrder();
    }  
    
    public void fetchSupplierIDFromSuppliersTable()   {
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
    
    public void addExistingSupplierToTxn(String supplierID, String supplierName, String supplierAddress, String supplierPhNo)  {
        txtSupplierID.setText(supplierID);
        txtSupplierName.setText(supplierName);
        txtSupplierAddress.setText(supplierAddress);
        txtSupplierPhNo.setText(supplierPhNo);
    }
    
    public void addProductToPurchaseOrder(String productID, String productBrand, String productModel, String productPrice, String checkInputQty)    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = st.executeQuery("select * from Purchase_Orders where purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + " and product_id=" + Integer.parseInt(productID) + "");
            if(rs.next())   {
                JOptionPane.showMessageDialog(rootPane, "Product Already Exists in Products List (Purchase Order)! Product Not Added!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            }
            else    {
                int salesQty=0;
                try {
                    salesQty = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Enter the Quantity to be bought for this Product...", "CSMS - Input", JOptionPane.INFORMATION_MESSAGE));
                }
                catch(NumberFormatException e)  {
                    JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                    salesQty = 0;
                }
                if(salesQty > 0)    {
                    if(Integer.parseInt(checkInputQty) - salesQty >= 0)  {
                        try {
                            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                            Connection con1 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                            
                            Statement st1 = con1.createStatement();
                            int res = st1.executeUpdate("insert into Purchase_Orders values(" + Integer.parseInt(txtPurchaseID.getText()) + ", " + Integer.parseInt(productID) + ", '" + productBrand + "', '" + productModel + "', " + Integer.parseInt(productPrice) + ", " + salesQty + ")");
                            JOptionPane.showMessageDialog(rootPane, "Product Added into Product List (Purchase Order). " + res + " Row(s) added Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                            st1.close();
                            con1.close();
                        }
                        catch(ClassNotFoundException e) {}
                        catch(SQLException e)   {}
                        
                        try {
                            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                            Connection con2 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                            Statement st2 = con2.createStatement();
                            int res1 = st2.executeUpdate("update Products set product_quantity_in_stock=" + ((Integer.parseInt(checkInputQty) + salesQty)) + " where product_id=" + Integer.parseInt(productID) + "");
                            st2.close();
                            con2.close();
                        }
                        catch(ClassNotFoundException e) {}
                        catch(SQLException e)   {}
                    }
                }
                else
                    JOptionPane.showMessageDialog(rootPane, "Product Not Added to Purchases Transaction! Please Enter a Valid Number!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
        
        refreshPurchaseOrder();
    }
    
    public void refreshPurchaseOrder() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select product_id, product_brand, product_model, purchased_quantity, product_price from Purchase_Orders where purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + "");
            ResultSetMetaData rsMeta = rs.getMetaData();
            rs.setFetchDirection(ResultSet.FETCH_FORWARD);
            int columnCount = rsMeta.getColumnCount();
            DefaultTableModel tableModel = (DefaultTableModel) jTablePurchaseOrder.getModel();
                    
            tableModel.setRowCount(0);
            while(rs.next())    {
                String[] conList = new String[columnCount];
                for(int i = 1, j = 0; i <= columnCount; i++, j++)   {
                    conList[j] = rs.getString(i);
                }
                tableModel.addRow(conList);
            }
            rs.close();
            st.close();
            con.close();
                    
            }
            catch(ClassNotFoundException cnfe) {}
            catch(SQLException sqle)    {}
        
        calculateGrandTotal();
    }
    
    public void createNewTransaction()  {
        if(!txtSupplierName.getText().equals("") && !txtSupplierPhNo.getText().equals("") && !txtSupplierAddress.getText().equals(""))  {
            if(jRadioButtonAddNew.isSelected()) {
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                    Statement st = con.createStatement();
                    
                    int res = st.executeUpdate("insert into Suppliers values(" + Integer.parseInt(txtSupplierID.getText()) + ", '" + txtSupplierName.getText() + "', '" + txtSupplierAddress.getText() + "' ,'" + txtSupplierPhNo.getText() +"')");
                    JOptionPane.showMessageDialog(rootPane, "New Supplier Added. " + res + " Row(s) added Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                    st.close();
                    con.close();
                }
                catch(ClassNotFoundException e) {}
                catch(SQLException e)   {}
            }
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                Statement st = con.createStatement();
                
                int res = st.executeUpdate("insert into Purchases_Billing(purchase_id, supplier_id, purchases_date) values(" + Integer.parseInt(txtPurchaseID.getText()) + ", " + Integer.parseInt(txtSupplierID.getText()) + ", '" + txtPurchaseDate.getText() +"')");
                JOptionPane.showMessageDialog(rootPane, "New Purchases Transaction Added. " + res + " Row(s) added Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                st.close();
                con.close();
            }
            catch(ClassNotFoundException e) {}
            catch(SQLException e)   {}
            
            txnOpenValue = true;
        } 
        else    {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Complete and Valid Values!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            jCheckBoxCreateNewTxn.setSelected(false);
        }
    }
    
    public void updateQuantityPurchaseOrders(String productID) {
        String checkInputQty, checkExistingQty;
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con3 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            Statement st3 = con3.createStatement();
            ResultSet rs3 = st3.executeQuery("Select product_quantity_in_stock from Products where product_id=" + Integer.parseInt(productID) + "");
            if(rs3.next())  {
                checkInputQty = rs3.getString(1);
            }
            else
                checkInputQty = rs3.getString(1);
        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con4 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            Statement st4 = con4.createStatement();
            ResultSet rs4 = st4.executeQuery("Select purchased_quantity from Purchase_Orders where product_id=" + Integer.parseInt(productID) + " and purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + "");
            if(rs4.next())  {
                checkExistingQty = rs4.getString(1);
            }
            else
                checkExistingQty = rs4.getString(1);
            
            int salesQty=0;
            try {
                salesQty = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Enter the Quantity to be bought for this Product...", "CSMS - Input", JOptionPane.INFORMATION_MESSAGE));
            }
            catch(NumberFormatException e)  {
                JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                salesQty = 0;
            }
            if(salesQty > 0)    {
                if(Integer.parseInt(checkInputQty) >= 0)  {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con1 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                            
                    Statement st1 = con1.createStatement();
                    int res = st1.executeUpdate("update Purchase_Orders set purchased_quantity=" + salesQty + " where product_id =" + Integer.parseInt(productID) + " and purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + "");
                    JOptionPane.showMessageDialog(rootPane, "Product Purchases Quantity Updated in Product List (Purchase Order). New Sales Quantity = " + salesQty + ". " + res + " Row(s) added Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                    st1.close();
                    con1.close();
                    
                        
                    try {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        Connection con2 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                        Statement st2 = con2.createStatement();
                        int res1 = st2.executeUpdate("update Products set product_quantity_in_stock=" + ((Integer.parseInt(checkInputQty) + (Integer.parseInt(checkExistingQty) - salesQty))) + " where product_id=" + Integer.parseInt(productID) + "");
                        st2.close();
                        con2.close();
                    }
                    catch(ClassNotFoundException e) {}
                    catch(SQLException e)   {}
                }
            }
            else
                JOptionPane.showMessageDialog(rootPane, "Product Not Added to Purchases Transaction! Please Enter a Valid Number!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
        
            rs4.close();
            st4.close();
            con4.close();
            
            rs3.close();
            st3.close();
            con3.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
        
        refreshPurchaseOrder();
    }
    
    public void deleteProductPurchaseOrders(String productID)  {
        String checkInputQty, checkExistingQty;
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con3 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            Statement st3 = con3.createStatement();
            ResultSet rs3 = st3.executeQuery("Select product_quantity_in_stock from Products where product_id=" + Integer.parseInt(productID) + "");
            if(rs3.next())  {
                checkInputQty = rs3.getString(1);
            }
            else
                checkInputQty = rs3.getString(1);
        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con4 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            Statement st4 = con4.createStatement();
            ResultSet rs4 = st4.executeQuery("Select purchased_quantity from Purchase_Orders where product_id=" + Integer.parseInt(productID) + " and purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + "");
            if(rs4.next())  {
                checkExistingQty = rs4.getString(1);
            }
            else
                checkExistingQty = rs4.getString(1);
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con1 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                            
            Statement st1 = con1.createStatement();
            int res = st1.executeUpdate("delete from Purchase_Orders where product_id=" + Integer.parseInt(productID) + "");            
            st1.close();
            con1.close();
                    
                        
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con2 = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                Statement st2 = con2.createStatement();
                int res1 = st2.executeUpdate("update Products set product_quantity_in_stock=" + ((Integer.parseInt(checkInputQty) - Integer.parseInt(checkExistingQty))) + " where product_id=" + Integer.parseInt(productID) + "");
                st2.close();
                con2.close();
            }
            catch(ClassNotFoundException e) {}
            catch(SQLException e)   {}
            
            rs4.close();
            st4.close();
            con4.close();
            
            rs3.close();
            st3.close();
            con3.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
        
        refreshPurchaseOrder();
    }

    public void deleteAllProductsFromPurchaseOrder()   {
        refreshPurchaseOrder();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select product_id from Purchase_Orders where purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + "");
            while(rs.next())  {
                deleteProductPurchaseOrders(rs.getString(1));
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
    }
    
    public void deletePurchasesTransaction()    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            
            Statement st = con.createStatement();
            int rs = st.executeUpdate("delete from Purchases_Billing where purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + "");
            
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
    }
    
    public void calculateGrandTotal()   {
        int gTotal=0;
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select product_price, purchased_quantity from Purchase_Orders where purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + "");
            while(rs.next())    {
                gTotal = gTotal + (rs.getInt(1) * rs.getInt(2));
            }
            rs.close();
            st.close();
            con.close();
            
            txtGrandTotal.setText(new Integer(gTotal).toString());
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
    }
    
    public void completePurchasesTransaction()  {
        calculateGrandTotal();
        
        if((Integer.parseInt(txtGrandTotal.getText())) > 0) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            
                Statement st = con.createStatement();
                int res = st.executeUpdate("update Purchases_Billing set purchases_total_amount=" + Integer.parseInt(txtGrandTotal.getText()) + " where purchase_id=" + Integer.parseInt(txtPurchaseID.getText()) + "");
                st.close();
                con.close();
            }
            catch(ClassNotFoundException e) {}
            catch(SQLException e)   {}
            
            JOptionPane.showMessageDialog(rootPane, "Transaction is Complete. Total Amount: " + (Integer.parseInt(txtGrandTotal.getText())) + ". Please Genereate Invoice for the Supplier.", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
            
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jButton10.setEnabled(false);
            jButton11.setEnabled(false);
            txnOpenValue = false;
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Products List (Purchase Order) is Empty! Please add Some Products in the Products List (Purchase Order)!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        imagePanelLogo = new coreCSMS.UI.ImagePanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPurchaseID = new javax.swing.JTextField();
        txtPurchaseDate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtSupplierPhNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSupplierID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonAddNew = new javax.swing.JRadioButton();
        jRadioButtonAddExisting = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSupplierAddress = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jCheckBoxCreateNewTxn = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtGrandTotal = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePurchaseOrder = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Purchases Transaction");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458263018_08.png"))); // NOI18N

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
        jLabel2.setText("PURCHASES TRANSACTION");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Purchases Transaction"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Purchase Details"));

        jLabel3.setText("Purchase ID:");

        txtPurchaseID.setEditable(false);

        txtPurchaseDate.setEditable(false);
        txtPurchaseDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel4.setText("Purcahse Date:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPurchaseDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPurchaseID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Supplier Detials"));

        txtSupplierPhNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSupplierPhNoKeyTyped(evt);
            }
        });

        jLabel8.setText("Supplier Phone Number:");

        jLabel7.setText("Supplier Name:");

        txtSupplierID.setEditable(false);

        jLabel6.setText("Supplier ID:");

        buttonGroup1.add(jRadioButtonAddNew);
        jRadioButtonAddNew.setText("Add New Supplier");
        jRadioButtonAddNew.setToolTipText("Add New Supplier");
        jRadioButtonAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAddNewActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonAddExisting);
        jRadioButtonAddExisting.setText("Add Existing Supplier");
        jRadioButtonAddExisting.setToolTipText("Add Existing Supplier");
        jRadioButtonAddExisting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAddExistingActionPerformed(evt);
            }
        });

        txtSupplierAddress.setColumns(20);
        txtSupplierAddress.setRows(5);
        jScrollPane2.setViewportView(txtSupplierAddress);

        jLabel9.setText("Supplier Address:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSupplierName)
                        .addComponent(txtSupplierPhNo)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jRadioButtonAddNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAddExisting)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSupplierPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonAddExisting)
                    .addComponent(jRadioButtonAddNew)))
        );

        jCheckBoxCreateNewTxn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxCreateNewTxn.setText("Create New Transaction");
        jCheckBoxCreateNewTxn.setToolTipText("Create New Transaction");
        jCheckBoxCreateNewTxn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCreateNewTxnActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Grand Total"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Total Amount:");

        txtGrandTotal.setEditable(false);
        txtGrandTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGrandTotal.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Products List"));

        jTablePurchaseOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT ID", "PRODUCT BRAND", "PRODUCT MODEL", "PRODUCT QTY.", "PRODUCT PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePurchaseOrder.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(jTablePurchaseOrder);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686460_arrow-refresh.png"))); // NOI18N
        jButton2.setText("Refresh");
        jButton2.setToolTipText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458270074_shopping_cart_add.png"))); // NOI18N
        jButton3.setText("Add Product");
        jButton3.setToolTipText("Add Product");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458270329_kwikdisk.png"))); // NOI18N
        jButton4.setText("Update Quantity");
        jButton4.setToolTipText("Update Quantity");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458270067_shopping_cart_delete.png"))); // NOI18N
        jButton5.setText("Remove Product");
        jButton5.setToolTipText("Remove Product");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458270468_Check_boxes.png"))); // NOI18N
        jButton7.setText("Complete Transaction");
        jButton7.setToolTipText("Complete Transaction");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458270327_Form.png"))); // NOI18N
        jButton8.setText("Generate Invoice");
        jButton8.setToolTipText("Generate Invoice");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458270464_Apply.png"))); // NOI18N
        jButton9.setText("OK");
        jButton9.setToolTipText("OK");
        jButton9.setEnabled(false);
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jCheckBoxCreateNewTxn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxCreateNewTxn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
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

    private void jRadioButtonAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAddNewActionPerformed
        // TODO add your handling code here:
        fetchSupplierIDFromSuppliersTable();
        txtSupplierName.setText("");
        txtSupplierAddress.setText("");
        txtSupplierPhNo.setText("");
        txtSupplierName.requestFocus();
    }//GEN-LAST:event_jRadioButtonAddNewActionPerformed

    private void jRadioButtonAddExistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAddExistingActionPerformed
        // TODO add your handling code here:
        txnOpenValue = true;
        mdiObj.viewPeopleObj.setVisible(false);
        mdiObj.viewPeopleObj.setVisible(true);
        mdiObj.viewPeopleObj.refreshViewAllTable(2);
        mdiObj.viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jRadioButtonAddExistingActionPerformed

    private void jCheckBoxCreateNewTxnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCreateNewTxnActionPerformed
        // TODO add your handling code here:
        createNewTransaction();
    }//GEN-LAST:event_jCheckBoxCreateNewTxnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        refreshPurchaseOrder();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxCreateNewTxn.isSelected() && !txtSupplierName.getText().equals("") && !txtSupplierPhNo.getText().equals("") && !txtSupplierAddress.getText().equals(""))  {
            mdiObj.viewProductByCategoriesObj.setVisible(false);
            mdiObj.viewProductByCategoriesObj.setVisible(true);
            mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(0);
            mdiObj.viewProductByCategoriesObj.requestFocus();
            mdiObj.viewProductByCategoriesObj.requestFocusOfTxtSearchBrand();
        }
        else
        JOptionPane.showMessageDialog(rootPane, "Please Check 'Create New Transaction' first!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTablePurchaseOrder.getSelectedRow();

        if(selectedRowIndex != -1)  {
            updateQuantityPurchaseOrders((jTablePurchaseOrder.getModel().getValueAt(selectedRowIndex, 0)).toString());
        }
        else
        JOptionPane.showMessageDialog(rootPane, "Please Select a Product first!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTablePurchaseOrder.getSelectedRow();

        if(selectedRowIndex != -1)  {
            deleteProductPurchaseOrders((jTablePurchaseOrder.getModel().getValueAt(selectedRowIndex, 0)).toString());
            JOptionPane.showMessageDialog(rootPane, "Product Removed from Products List (Purchase Order). 1 Row(s) deleted Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else
        JOptionPane.showMessageDialog(rootPane, "Please Select a Product first!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Complete this Transaction?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            completePurchasesTransaction();
        }
        else if(res == JOptionPane.NO_OPTION)
        this.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        mdiObj.transactionPurchasesInvoiceObj.setInvoiceValues(txtPurchaseID.getText(), txtPurchaseDate.getText(), txtSupplierName.getText(), txtSupplierPhNo.getText(), txtGrandTotal.getText());
        mdiObj.transactionPurchasesInvoiceObj.setVisible(false);
        mdiObj.transactionPurchasesInvoiceObj.setVisible(true);
        mdiObj.transactionPurchasesInvoiceObj.setOriginalInvoice(true);
        mdiObj.transactionPurchasesInvoiceObj.requestFocus();
        this.mdiObj.setEnabled(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        mdiObj.transactionsObj.setVisible(false);
        mdiObj.transactionsObj.setVisible(true);
        mdiObj.transactionsObj.requestFocus();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Cancel?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            deleteAllProductsFromPurchaseOrder();
            deletePurchasesTransaction();
            txnOpenValue = false;

            this.setVisible(false);
            mdiObj.transactionsObj.setVisible(false);
            mdiObj.transactionsObj.setVisible(true);
            mdiObj.transactionsObj.requestFocus();
        }
        else if(res == JOptionPane.NO_OPTION)
        this.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Clear All?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            deleteAllProductsFromPurchaseOrder();
            deletePurchasesTransaction();

            initializeThisForm();
        }
        else if(res == JOptionPane.NO_OPTION)
        this.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        if(isSalesTxnOpen())    {
            deleteAllProductsFromPurchaseOrder();
            deletePurchasesTransaction();
            txnOpenValue = false;
        }
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private coreCSMS.UI.ImagePanel imagePanelLogo;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBoxCreateNewTxn;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButtonAddExisting;
    private javax.swing.JRadioButton jRadioButtonAddNew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTablePurchaseOrder;
    private javax.swing.JTextField txtGrandTotal;
    private javax.swing.JFormattedTextField txtPurchaseDate;
    private javax.swing.JTextField txtPurchaseID;
    private javax.swing.JTextArea txtSupplierAddress;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierPhNo;
    // End of variables declaration//GEN-END:variables
}
