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

/**
 *
 * @author hp-pc
 */
public class ViewAllProducts extends javax.swing.JInternalFrame {

    public NewMDIApplication mdiObj = null;
    
    /**
     * Creates new form ViewAllProducts
     */
    public ViewAllProducts(NewMDIApplication mdiObj) {
        this.mdiObj = mdiObj;
        
        initComponents();
        
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
        jTabbedPaneAllProducts = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDefault = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableByBrand = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableByModel = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableByPrice = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableQtyInStock = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("View All Products");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel2.setBackground(java.awt.SystemColor.controlShadow);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.SystemColor.activeCaptionText));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/ViewProducts.png"))); // NOI18N

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
        jLabel2.setText("VIEW ALL PRODUCTS");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 853, Short.MAX_VALUE)
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

        jTableDefault.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "PRODUCT BRAND", "PRODUCT MODEL", "PRODUCT DESCRIPTION", "PRODUCT PRICE", "PRODUCT QUANTITY IN STOCK", "PRODUCT PHOTO PATH", "PRODUCT CATEGORY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableDefault);

        jTabbedPaneAllProducts.addTab("Default Ordered", jScrollPane2);

        jTableByBrand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "PRODUCT BRAND", "PRODUCT MODEL", "PRODUCT DESCRIPTION", "PRODUCT PRICE", "PRODUCT QUANTITY IN STOCK", "PRODUCT PHOTO PATH", "PRODUCT CATEGORY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableByBrand);

        jTabbedPaneAllProducts.addTab("Ordered By Brand", jScrollPane3);

        jTableByModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "PRODUCT BRAND", "PRODUCT MODEL", "PRODUCT DESCRIPTION", "PRODUCT PRICE", "PRODUCT QUANTITY IN STOCK", "PRODUCT PHOTO PATH", "PRODUCT CATEGORY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableByModel);

        jTabbedPaneAllProducts.addTab("Ordered By Model", jScrollPane4);

        jTableByPrice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "PRODUCT BRAND", "PRODUCT MODEL", "PRODUCT DESCRIPTION", "PRODUCT PRICE", "PRODUCT QUANTITY IN STOCK", "PRODUCT PHOTO PATH", "PRODUCT CATEGORY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableByPrice);

        jTabbedPaneAllProducts.addTab("Ordered By Price", jScrollPane5);

        jTableQtyInStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "PRODUCT BRAND", "PRODUCT MODEL", "PRODUCT DESCRIPTION", "PRODUCT PRICE", "PRODUCT QUANTITY IN STOCK", "PRODUCT PHOTO PATH", "PRODUCT CATEGORY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTableQtyInStock);

        jTabbedPaneAllProducts.addTab("Ordered By Quantity In Stock", jScrollPane6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneAllProducts)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPaneAllProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
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
        
    }//GEN-LAST:event_formFocusGained

    public void refreshViewAllTable(int tabIndex)   {
        jTabbedPaneAllProducts.setSelectedIndex(tabIndex);
        
        for(int x=0; x<5; x++)  {
        
        switch(x)    {
            case 0:
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * from Products order by product_id");
                    ResultSetMetaData rsMeta = rs.getMetaData();
                    rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                    int columnCount = rsMeta.getColumnCount();
                    DefaultTableModel tableModel = (DefaultTableModel) jTableDefault.getModel();
                    
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
                
                break;
            case 1:
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * from Products order by product_brand");
                    ResultSetMetaData rsMeta = rs.getMetaData();
                    rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                    int columnCount = rsMeta.getColumnCount();
                    DefaultTableModel tableModel = (DefaultTableModel) jTableByBrand.getModel();
                    
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
                
                break;
            case 2:
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * from Products order by product_model");
                    ResultSetMetaData rsMeta = rs.getMetaData();
                    rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                    int columnCount = rsMeta.getColumnCount();
                    DefaultTableModel tableModel = (DefaultTableModel) jTableByModel.getModel();
                    
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
                
                break;
            case 3:
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * from Products order by product_price");
                    ResultSetMetaData rsMeta = rs.getMetaData();
                    rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                    int columnCount = rsMeta.getColumnCount();
                    DefaultTableModel tableModel = (DefaultTableModel) jTableByPrice.getModel();
                    
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
                
                break;
            case 4:
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * from Products order by product_quantity_in_stock");
                    ResultSetMetaData rsMeta = rs.getMetaData();
                    rs.setFetchDirection(ResultSet.FETCH_FORWARD);
                    int columnCount = rsMeta.getColumnCount();
                    DefaultTableModel tableModel = (DefaultTableModel) jTableQtyInStock.getModel();
                    
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
                
                break;
        }
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private coreCSMS.UI.ImagePanel imagePanelLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPaneAllProducts;
    private javax.swing.JTable jTableByBrand;
    private javax.swing.JTable jTableByModel;
    private javax.swing.JTable jTableByPrice;
    private javax.swing.JTable jTableDefault;
    private javax.swing.JTable jTableQtyInStock;
    // End of variables declaration//GEN-END:variables
}
