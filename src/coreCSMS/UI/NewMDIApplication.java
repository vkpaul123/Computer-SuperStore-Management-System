/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreCSMS.UI;

import javax.swing.JFrame;
import java.util.*;
import java.text.*;
import javax.swing.JOptionPane;


/**
 *
 * @author hp-pc
 */
public class NewMDIApplication extends javax.swing.JFrame {
    
    public LoginForm loginFormObj = null;

    public Transactions transactionsObj = null;
    public TransactionsSales transactionsSalesObj = null;
    public TransactionsPurchases transactionsPurchasesObj = null;
    public HomePage homePageObj = null;
    public ViewProductCategories viewProductCategoriesObj = null;
    public ViewProductByCategories viewProductByCategoriesObj = null;
    public ViewAllProducts viewAllProductsObj = null;
    public ViewPeople viewPeopleObj = null;
    public AboutPage aboutPageObj = null;
    public ProductStockOperations productStockOperationsObj = null;
    public AddAdministrator addAdministratorObj = null;
    public AddCustomer addCustomerObj = null;
    public AddSupplier addSupplierObj = null;
    public ShowSearch showSearchObj = null;
    public ShowOtherUtilities showOtherUtilitiesObj = null;
    public ReportAdminsTable reportAdminsTableObj = null;
    public ReportCustomers reportCustomersObj = null;
    public ReportSuppliers reportSuppliersObj = null;
    public ReportProducts reportProductsObj = null;
    public ReportSalesBilling reportSalesBillingObj = null;
    public ReportSalesOrder reportSalesOrderObj = null;
    public ReportPurchaseOrders reportPurchaseOrdersObj = null;
    public ReportPurchaseBilling reportPurchaseBillingObj = null;
    public ShowReports showReportsObj = null;
    public TransactionSalesInvoice transactionSalesInvoiceObj = null;
    public TransactionPurchasesInvoice transactionPurchasesInvoiceObj = null;
    public InvoiceRecords invoiceRecordsObj = null;
    public ReportMonthlyPurchaseBilling reportMonthlyPurchaseBillingObj = null;
    public ReportMonthlySalesBilling reportMonthlySalesBillingObj = null;
    
    
    /**
     * Creates new form NewMDIApplication
     */  
    public NewMDIApplication()  {
        initComponents();
        timerAndLoadHomePage();
    }
    public NewMDIApplication(LoginForm lf) {
        initComponents();
        
        this.loginFormObj = lf;
        
        timerAndLoadHomePage();        
    }
    
    public void timerAndLoadHomePage()  {
        createInsatanceOfInternalFrames();
                
        //Date and Time Timer
        Timer timer = new Timer();
        timer.schedule(tasknew, 0,500);
        
        
        homePageObj.setVisible(true);
        homePageObj.requestFocus();
        try {
            homePageObj.setMaximum(true);
        }
        catch(java.beans.PropertyVetoException e)  {}
        
        jLabelUsername.setText(" " + LoginForm.getUsername() + " ");
    }
    
    public String uname = new String("");
    
    
    
    TimerTask tasknew = new TimerTask() {
        public void run()   {
            Date dNow = new Date();
            SimpleDateFormat dateFt = new SimpleDateFormat("E dd-MM-yyyy");
            jLabelDate.setText(" " + dateFt.format(dNow).toString() + " ");
            jLabel3.setToolTipText(dateFt.format(dNow).toString());
            jLabelDate.setToolTipText(dateFt.format(dNow).toString());
            SimpleDateFormat timeFt = new SimpleDateFormat("hh:mm:ss a");
            jLabelTime.setText(" "+ timeFt.format(dNow).toString() + " ");
            jLabel5.setToolTipText(timeFt.format(dNow).toString());
            jLabelTime.setToolTipText(timeFt.format(dNow).toString());
            
            if(jLabel5.getText().toString().equals("Time: "))
                jLabel5.setText("Time  ");
            else
                jLabel5.setText("Time: ");
        }
    };
    
    public String sendDate()  {
        Date dNow = new Date();
        SimpleDateFormat dateFt = new SimpleDateFormat("yyyy-MM-dd");
        return dateFt.format(dNow);
    }
    
    //Create one instance of all the internal frames of MDI
    public void createInsatanceOfInternalFrames()   {
        transactionsObj = new Transactions(this);
        this.desktopPane.add(transactionsObj);
        
        transactionsSalesObj = new TransactionsSales(this);
        this.desktopPane.add(transactionsSalesObj);
        
        transactionsPurchasesObj = new TransactionsPurchases(this);
        this.desktopPane.add(transactionsPurchasesObj);
        
        homePageObj = new HomePage(this);
        this.desktopPane.add(homePageObj);
        
        viewProductCategoriesObj = new ViewProductCategories(this);
        this.desktopPane.add(viewProductCategoriesObj);
        
        viewProductByCategoriesObj = new ViewProductByCategories(this);
        this.desktopPane.add(viewProductByCategoriesObj);
        
        viewAllProductsObj = new ViewAllProducts(this);
        this.desktopPane.add(viewAllProductsObj);
        
        viewPeopleObj = new ViewPeople(this);
        this.desktopPane.add(viewPeopleObj);
        
        aboutPageObj = new AboutPage(this);
        
        productStockOperationsObj = new ProductStockOperations(this);
        this.desktopPane.add(productStockOperationsObj);
        
        addAdministratorObj = new AddAdministrator(this);
        this.desktopPane.add(addAdministratorObj);
        
        addCustomerObj = new AddCustomer(this);
        this.desktopPane.add(addCustomerObj);
        
        addSupplierObj = new AddSupplier(this);
        this.desktopPane.add(addSupplierObj);
        
        showSearchObj = new ShowSearch(this);
        this.desktopPane.add(showSearchObj);
        
        showOtherUtilitiesObj = new ShowOtherUtilities(this);
        this.desktopPane.add(showOtherUtilitiesObj);
        
        reportAdminsTableObj = new ReportAdminsTable(this);
        
        reportCustomersObj = new ReportCustomers(this);
        
        reportSuppliersObj = new ReportSuppliers(this);
        
        reportProductsObj = new ReportProducts(this);
        
        reportSalesBillingObj = new ReportSalesBilling(this);
        
        reportSalesOrderObj = new ReportSalesOrder(this);
        
        reportPurchaseOrdersObj = new ReportPurchaseOrders(this);
        
        reportPurchaseBillingObj = new ReportPurchaseBilling(this);
        
        showReportsObj = new ShowReports(this);
        this.desktopPane.add(showReportsObj);
        
        transactionSalesInvoiceObj = new TransactionSalesInvoice(this);
        
        transactionPurchasesInvoiceObj = new TransactionPurchasesInvoice(this);
        
        invoiceRecordsObj = new InvoiceRecords(this);
        this.desktopPane.add(invoiceRecordsObj);
        
        reportMonthlyPurchaseBillingObj = new ReportMonthlyPurchaseBilling(this);
        
        reportMonthlySalesBillingObj = new ReportMonthlySalesBilling(this);
    }
    
    public String sendUsername()    {        
        return LoginForm.getUsername();
    }
    
    public void setGotoComboBoxSelectedValue(int val)   {
        jComboBoxGoTo.setSelectedIndex(val);
    }
    
    public void gotoComboBoxOperations(int index)    {
        switch(index)   {
            case 0:
                homePageObj.setVisible(false);
                homePageObj.setVisible(true);
                homePageObj.requestFocus();
                break;
            case 1:
                productStockOperationsObj.setVisible(false);
                productStockOperationsObj.setVisible(true);
                productStockOperationsObj.selectAddNewOperation();
                productStockOperationsObj.requestFocus();
                break;
            case 2:
                viewProductByCategoriesObj.setVisible(false);
                viewProductByCategoriesObj.setVisible(true);
                viewProductByCategoriesObj.selectProductCategoryTab(0);
                viewProductByCategoriesObj.requestFocus();
                break;
            case 3:
                addAdministratorObj.setVisible(false);
                addAdministratorObj.setVisible(true);
                addAdministratorObj.selectOperationsTab(0);
                addAdministratorObj.requestFocus();
                break;
            case 4:
                addCustomerObj.setVisible(false);
                addCustomerObj.setVisible(true);
                addCustomerObj.selectOperationsTab(0);
                addCustomerObj.requestFocus();
                break;
            case 5:
                addSupplierObj.setVisible(false);
                addSupplierObj.setVisible(true);
                addSupplierObj.selectOperationsTab(0);
                addSupplierObj.requestFocus();
                break;
            case 6:
                viewPeopleObj.setVisible(false);
                viewPeopleObj.setVisible(true);
                viewPeopleObj.refreshViewAllTable(0);
                viewPeopleObj.requestFocus();
                break;
            case 7:
                showSearchObj.setVisible(false);
                showSearchObj.setVisible(true);
                showSearchObj.requestFocus();
                break;
            case 8:
                transactionsObj.setVisible(false);
                transactionsObj.setVisible(true);
                transactionsObj.requestFocus();
                break;
            case 9:
                invoiceRecordsObj.setVisible(false);
                invoiceRecordsObj.setVisible(true);
                invoiceRecordsObj.requestFocus();
                break;
            case 10:
                showReportsObj.setVisible(false);
                showReportsObj.setVisible(true);
                showReportsObj.requestFocus();
                break;
            case 11:
                showOtherUtilitiesObj.setVisible(false);
                showOtherUtilitiesObj.setVisible(true);
                showOtherUtilitiesObj.requestFocus();
                break;
            case 12:
                aboutPageObj.setVisible(false);
                aboutPageObj.setVisible(true);
                this.setEnabled(false);
                break;
            case 13:
                this.askToLogout();
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

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        jButtonHome = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonProductsStock = new javax.swing.JButton();
        jButtonViewProducts = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonViewPeople = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButtonSearch = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButtonTransactions = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButtonReports = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButtonOtherUtilities = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButtonAbout = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jButtonLogOut = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxGoTo = new javax.swing.JComboBox<>();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jLabel9 = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        menuBar = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        jMenuItem34 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator32 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        jMenuItem23 = new javax.swing.JMenuItem();
        jSeparator29 = new javax.swing.JPopupMenu.Separator();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jSeparator30 = new javax.swing.JPopupMenu.Separator();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator31 = new javax.swing.JPopupMenu.Separator();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("jMenu4");

        jMenuItem6.setText("jMenuItem6");

        jMenuItem32.setText("jMenuItem32");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Computer SuperStore Management System");
        setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.shadow"));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToolBar1.add(jSeparator11);

        jButtonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/Home.png"))); // NOI18N
        jButtonHome.setText("HOME");
        jButtonHome.setToolTipText("HOME");
        jButtonHome.setFocusable(false);
        jButtonHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonHome);
        jToolBar1.add(jSeparator1);

        jButtonProductsStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/ProductsStock.png"))); // NOI18N
        jButtonProductsStock.setText("Add New Product");
        jButtonProductsStock.setToolTipText("Add New Product");
        jButtonProductsStock.setFocusable(false);
        jButtonProductsStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProductsStock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProductsStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductsStockActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonProductsStock);

        jButtonViewProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/ViewProducts.png"))); // NOI18N
        jButtonViewProducts.setText("View Products");
        jButtonViewProducts.setToolTipText("View Products");
        jButtonViewProducts.setFocusable(false);
        jButtonViewProducts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonViewProducts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonViewProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewProductsActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonViewProducts);
        jToolBar1.add(jSeparator2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458101913_administrator.png"))); // NOI18N
        jButton1.setText("Add Administrator");
        jButton1.setToolTipText("Add Administrator");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458176516_Customer_Female_Dark.png"))); // NOI18N
        jButton2.setText("Add Customer");
        jButton2.setToolTipText("Add Customer");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458101912_provider.png"))); // NOI18N
        jButton3.setText("Add Supplier");
        jButton3.setToolTipText("Add Supplier");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButtonViewPeople.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/ViewPeople.png"))); // NOI18N
        jButtonViewPeople.setText("View People");
        jButtonViewPeople.setToolTipText("View People");
        jButtonViewPeople.setFocusable(false);
        jButtonViewPeople.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonViewPeople.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonViewPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewPeopleActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonViewPeople);
        jToolBar1.add(jSeparator4);

        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/Search.png"))); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.setToolTipText("Search");
        jButtonSearch.setFocusable(false);
        jButtonSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonSearch);
        jToolBar1.add(jSeparator3);

        jButtonTransactions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/Transactions.png"))); // NOI18N
        jButtonTransactions.setText("Transactions");
        jButtonTransactions.setToolTipText("Transactions");
        jButtonTransactions.setFocusable(false);
        jButtonTransactions.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonTransactions.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransactionsActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonTransactions);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458260993_document.png"))); // NOI18N
        jButton4.setText("View Invoice Records");
        jButton4.setToolTipText("Invoice Records");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator5);

        jButtonReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/Reports.png"))); // NOI18N
        jButtonReports.setText("Reports");
        jButtonReports.setToolTipText("Reports");
        jButtonReports.setFocusable(false);
        jButtonReports.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonReports.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportsActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonReports);
        jToolBar1.add(jSeparator6);

        jButtonOtherUtilities.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/OtherUtilities.png"))); // NOI18N
        jButtonOtherUtilities.setText("Other Utilities");
        jButtonOtherUtilities.setToolTipText("Other Utilities");
        jButtonOtherUtilities.setFocusable(false);
        jButtonOtherUtilities.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonOtherUtilities.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonOtherUtilities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtherUtilitiesActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonOtherUtilities);
        jToolBar1.add(jSeparator7);

        jButtonAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/About.png"))); // NOI18N
        jButtonAbout.setText("About");
        jButtonAbout.setToolTipText("About");
        jButtonAbout.setFocusable(false);
        jButtonAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAbout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAboutActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAbout);
        jToolBar1.add(jSeparator8);

        jButtonLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/LogOut.png"))); // NOI18N
        jButtonLogOut.setText("Log Out");
        jButtonLogOut.setToolTipText("Log Out");
        jButtonLogOut.setFocusable(false);
        jButtonLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLogOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonLogOut);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.add(jSeparator12);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/GoTo.png"))); // NOI18N
        jLabel1.setText("Go To...");
        jLabel1.setToolTipText("Go To...");
        jToolBar2.add(jLabel1);

        jComboBoxGoTo.setMaximumRowCount(14);
        jComboBoxGoTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOME", "Add New Product", "View Products", "Add Administrator", "Add Customer", "Add Supplier", "View Poeple", "Search", "Transactions", "View Invoice Records", "Reports", "Other Utilities", "About", "Log out" }));
        jComboBoxGoTo.setToolTipText("Go To...");
        jComboBoxGoTo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxGoToItemStateChanged(evt);
            }
        });
        jComboBoxGoTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGoToActionPerformed(evt);
            }
        });
        jToolBar2.add(jComboBoxGoTo);
        jToolBar2.add(jSeparator10);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456613830_gnome-dev-computer.png"))); // NOI18N
        jLabel2.setText("Computer SuperStore Management System ");
        jLabel2.setToolTipText("Computer SuperStore Management System ");
        jToolBar2.add(jLabel2);

        jLabel6.setText(" version 1.0");
        jLabel6.setToolTipText("v1.0");
        jToolBar2.add(jLabel6);
        jToolBar2.add(jSeparator13);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456613878_stock_insert-fields-author.png"))); // NOI18N
        jLabel4.setText("Author: ");
        jLabel4.setToolTipText("Vikramsinh Dantkale");
        jToolBar2.add(jLabel4);

        jLabel7.setText(" Vikramsinh Dantkale ");
        jLabel7.setToolTipText("Vikramsinh Dantkale");
        jToolBar2.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setText(" 13-14-B.C.A.-256 ");
        jLabel8.setToolTipText("13-14-B.C.A.-256");
        jToolBar2.add(jLabel8);
        jToolBar2.add(jSeparator15);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456617358_key.png"))); // NOI18N
        jLabel9.setText("Logged In as: ");
        jToolBar2.add(jLabel9);

        jLabelUsername.setText(" Username ");
        jToolBar2.add(jLabelUsername);
        jToolBar2.add(jSeparator17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456613860_calendar-day.png"))); // NOI18N
        jLabel3.setText("Date: ");
        jToolBar2.add(jLabel3);

        jLabelDate.setText(" Date ");
        jToolBar2.add(jLabelDate);
        jToolBar2.add(jSeparator14);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456613862_clock.png"))); // NOI18N
        jLabel5.setText("Time: ");
        jToolBar2.add(jLabel5);

        jLabelTime.setText(" Time ");
        jToolBar2.add(jLabelTime);
        jToolBar2.add(jSeparator9);

        jMenuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/HomeSmall.png"))); // NOI18N
        jMenuHome.setMnemonic('h');
        jMenuHome.setText("HOME");
        jMenuHome.setPreferredSize(new java.awt.Dimension(150, 19));

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/HomeSmall.png"))); // NOI18N
        jMenuItem1.setText("Home");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuHome.add(jMenuItem1);

        menuBar.add(jMenuHome);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184413_box-close-3d.png"))); // NOI18N
        fileMenu.setMnemonic('p');
        fileMenu.setText("Product Stock Operations");
        fileMenu.setPreferredSize(new java.awt.Dimension(173, 19));

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Add New Product");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);
        fileMenu.add(jSeparator18);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Update Existing Product");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Remove Existing Product");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184419_shopping-cart.png"))); // NOI18N
        editMenu.setMnemonic('t');
        editMenu.setText("Transactions");
        editMenu.setPreferredSize(new java.awt.Dimension(105, 19));

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Sales");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Purchases");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(deleteMenuItem);
        editMenu.add(jSeparator19);

        jMenuItem34.setText("Invoice Records");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem34);

        menuBar.add(editMenu);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184424_25.png"))); // NOI18N
        helpMenu.setMnemonic('d');
        helpMenu.setText("View Products");
        helpMenu.setPreferredSize(new java.awt.Dimension(113, 19));

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("All Products");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);
        helpMenu.add(jSeparator20);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("All Categories");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);
        helpMenu.add(jSeparator21);

        jMenuItem4.setText("Separated In Categories");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem4);
        helpMenu.add(jSeparator32);

        jMenuItem3.setText("Ordered By Brands");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem3);

        jMenuItem37.setText("Ordered By Model");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem37);

        jMenuItem38.setText("Ordered By Price");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem38);

        jMenuItem39.setText("Ordered By Quantity In Stock");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem39);

        menuBar.add(helpMenu);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184421_88.png"))); // NOI18N
        jMenu5.setMnemonic('o');
        jMenu5.setText("View People");
        jMenu5.setPreferredSize(new java.awt.Dimension(103, 19));

        jMenu11.setText("Administrators");

        jMenuItem7.setText("View Administrator");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem7);
        jMenu11.add(jSeparator22);

        jMenuItem8.setText("Add Administrator");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem8);

        jMenuItem9.setText("Update Administrator");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem9);

        jMenuItem10.setText("Remove Administrator");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem10);

        jMenu5.add(jMenu11);
        jMenu5.add(jSeparator23);

        jMenu12.setText("Customers");

        jMenuItem11.setText("View Customer");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem11);
        jMenu12.add(jSeparator24);

        jMenuItem12.setText("Add Customer");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem12);

        jMenuItem13.setText("Update Customer");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem13);

        jMenu5.add(jMenu12);

        jMenu13.setText("Suppliers");

        jMenuItem5.setText("View Supplier");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem5);
        jMenu13.add(jSeparator25);

        jMenuItem14.setText("Add Supplier");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem14);

        jMenuItem15.setText("Update Supplier");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem15);

        jMenuItem16.setText("Remove Supplier");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem16);

        jMenu5.add(jMenu13);

        menuBar.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184422_Find01.png"))); // NOI18N
        jMenu6.setMnemonic('s');
        jMenu6.setText("Search");
        jMenu6.setPreferredSize(new java.awt.Dimension(73, 19));

        jMenuItem17.setText("Products");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);
        jMenu6.add(jSeparator26);

        jMenu14.setText("People");

        jMenuItem18.setText("Administrators");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem18);
        jMenu14.add(jSeparator16);

        jMenuItem19.setText("Customers");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem19);

        jMenuItem33.setText("Suppliers");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem33);

        jMenu6.add(jMenu14);

        menuBar.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184425_Untitled-2-40.png"))); // NOI18N
        jMenu7.setMnemonic('r');
        jMenu7.setText("Reports");
        jMenu7.setPreferredSize(new java.awt.Dimension(79, 19));

        jMenuItem20.setText("Administrators Report");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem20);
        jMenu7.add(jSeparator27);

        jMenuItem21.setText("Customers Report");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem21);

        jMenuItem22.setText("Suppliers Report");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem22);
        jMenu7.add(jSeparator28);

        jMenuItem23.setText("Products Stock Report");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem23);
        jMenu7.add(jSeparator29);

        jMenuItem24.setText("Sales Order Report");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem24);

        jMenuItem25.setText("Sales Billing Report");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem25);

        jMenuItem35.setText("Monthly Sales Billing Report");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem35);
        jMenu7.add(jSeparator30);

        jMenuItem26.setText("Purchase Order Report");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem26);

        jMenuItem27.setText("Purchase Billing Report");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem27);

        jMenuItem36.setText("Monthly Purchases Billing Report");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem36);

        menuBar.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184795_settings.png"))); // NOI18N
        jMenu8.setMnemonic('u');
        jMenu8.setText("Other Utilities");
        jMenu8.setPreferredSize(new java.awt.Dimension(111, 19));

        jMenuItem29.setText("Calculator");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem29);
        jMenu8.add(jSeparator31);

        jMenuItem30.setText("Notepad");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem30);

        jMenuItem28.setText("WordPad");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem28);

        menuBar.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184429_164_QuestionMark.png"))); // NOI18N
        jMenu9.setMnemonic('h');
        jMenu9.setText("Help");
        jMenu9.setPreferredSize(new java.awt.Dimension(150, 19));

        jMenuItem31.setText("About");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem31);

        menuBar.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458184427_060_Off.png"))); // NOI18N
        jMenu10.setMnemonic('l');
        jMenu10.setText("Log Out");

        jMenuItem2.setText("Log Out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem2);

        menuBar.add(jMenu10);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jLabelUsername.setText(" " + LoginForm.getUsername() + " ");
    }//GEN-LAST:event_formWindowGainedFocus

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        viewProductByCategoriesObj.setVisible(false);
        viewProductByCategoriesObj.setVisible(true);
        viewProductByCategoriesObj.selectProductCategoryTab(0);
        viewProductByCategoriesObj.requestFocus();
        viewProductByCategoriesObj.requestFocusOfTxtSearchBrand();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        // TODO add your handling code here:
        this.askToLogout();
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.askToLogout();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        // TODO add your handling code here:
        this.homePageObj.setVisible(false);
        this.homePageObj.setVisible(true);
        this.homePageObj.requestFocus();
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jComboBoxGoToItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxGoToItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBoxGoToItemStateChanged

    private void jComboBoxGoToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGoToActionPerformed
        // TODO add your handling code here:
        gotoComboBoxOperations(jComboBoxGoTo.getSelectedIndex());
    }//GEN-LAST:event_jComboBoxGoToActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.askToLogout();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.homePageObj.setVisible(false);
        this.homePageObj.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransactionsActionPerformed
        // TODO add your handling code here:
        transactionsObj.setVisible(false);
        transactionsObj.setVisible(true);
        transactionsObj.requestFocus();
    }//GEN-LAST:event_jButtonTransactionsActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(1);
        viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(0);
        viewPeopleObj.requestFocus();
        viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
        viewAllProductsObj.setVisible(false);
        viewAllProductsObj.setVisible(true);
        viewAllProductsObj.refreshViewAllTable(0);
        viewAllProductsObj.requestFocus();
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void jButtonViewProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewProductsActionPerformed
        // TODO add your handling code here:
        viewProductByCategoriesObj.setVisible(false);
        viewProductByCategoriesObj.setVisible(true);
        viewProductByCategoriesObj.selectProductCategoryTab(0);
        viewProductByCategoriesObj.requestFocus();
    }//GEN-LAST:event_jButtonViewProductsActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        viewAllProductsObj.refreshViewAllTable(1);
        viewAllProductsObj.setVisible(false);
        viewAllProductsObj.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("calc.exe");
        }
        catch(Exception e)  {}
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("notepad.exe");
        }
        catch(Exception e)  {}
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("write.exe");
        }
        catch(Exception e)  {}
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jButtonViewPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewPeopleActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(0);
        viewPeopleObj.requestFocus();
    }//GEN-LAST:event_jButtonViewPeopleActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        viewProductByCategoriesObj.setVisible(false);
        viewProductByCategoriesObj.setVisible(true);
        viewProductByCategoriesObj.selectProductCategoryTab(0);
        viewProductByCategoriesObj.requestFocus();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        viewProductCategoriesObj.setVisible(false);
        viewProductCategoriesObj.setVisible(true);
        viewProductCategoriesObj.requestFocus();
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(0);
        viewPeopleObj.requestFocus();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(1);
        viewPeopleObj.requestFocus();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(2);
        viewPeopleObj.requestFocus();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        // TODO add your handling code here:
        aboutPageObj.setVisible(false);
        aboutPageObj.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jButtonProductsStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductsStockActionPerformed
        // TODO add your handling code here:
        productStockOperationsObj.setVisible(false);
        productStockOperationsObj.setVisible(true);
        productStockOperationsObj.selectAddNewOperation();
        productStockOperationsObj.requestFocus();
    }//GEN-LAST:event_jButtonProductsStockActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
        productStockOperationsObj.setVisible(false);
        productStockOperationsObj.setVisible(true);
        productStockOperationsObj.selectAddNewOperation();
        productStockOperationsObj.requestFocus();
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void jButtonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAboutActionPerformed
        // TODO add your handling code here:
        aboutPageObj.setVisible(false);
        aboutPageObj.setVisible(true);
        this.setEnabled(false);
        
    }//GEN-LAST:event_jButtonAboutActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        viewProductByCategoriesObj.setVisible(false);
        viewProductByCategoriesObj.setVisible(true);
        viewProductByCategoriesObj.selectProductCategoryTab(0);
        viewProductByCategoriesObj.requestFocus();
        viewProductByCategoriesObj.requestFocusOfTxtSearchBrand();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        // TODO add your handling code here:
        viewProductByCategoriesObj.setVisible(false);
        viewProductByCategoriesObj.setVisible(true);
        viewProductByCategoriesObj.selectProductCategoryTab(0);
        viewProductByCategoriesObj.requestFocus();
        viewProductByCategoriesObj.requestFocusOfTxtSearchBrand();
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addAdministratorObj.setVisible(false);
        addAdministratorObj.setVisible(true);
        addAdministratorObj.selectOperationsTab(0);
        addAdministratorObj.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        addCustomerObj.setVisible(false);
        addCustomerObj.setVisible(true);
        addCustomerObj.selectOperationsTab(0);
        addCustomerObj.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        addSupplierObj.setVisible(false);
        addSupplierObj.setVisible(true);
        addSupplierObj.selectOperationsTab(0);
        addSupplierObj.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        addAdministratorObj.setVisible(false);
        addAdministratorObj.setVisible(true);
        addAdministratorObj.selectOperationsTab(0);
        addAdministratorObj.requestFocus();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        addCustomerObj.setVisible(false);
        addCustomerObj.setVisible(true);
        addCustomerObj.selectOperationsTab(0);
        addCustomerObj.requestFocus();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        addSupplierObj.setVisible(false);
        addSupplierObj.setVisible(true);
        addSupplierObj.selectOperationsTab(0);
        addSupplierObj.requestFocus();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(0);
        viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(1);
        viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(2);
        viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(0);
        viewPeopleObj.requestFocus();
        viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(2);
        viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        viewPeopleObj.setVisible(false);
        viewPeopleObj.setVisible(true);
        viewPeopleObj.refreshViewAllTable(2);
        viewPeopleObj.requestFocusOfTxtSearchKey();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        showSearchObj.setVisible(false);
        showSearchObj.setVisible(true);
        showSearchObj.requestFocus();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonOtherUtilitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtherUtilitiesActionPerformed
        // TODO add your handling code here:
        showOtherUtilitiesObj.setVisible(false);
        showOtherUtilitiesObj.setVisible(true);
        showOtherUtilitiesObj.requestFocus();
    }//GEN-LAST:event_jButtonOtherUtilitiesActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        reportAdminsTableObj.setVisible(false);
        reportAdminsTableObj.setVisible(true);
        reportAdminsTableObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        reportCustomersObj.setVisible(false);
        reportCustomersObj.setVisible(true);
        reportCustomersObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
        reportSuppliersObj.setVisible(false);
        reportSuppliersObj.setVisible(true);
        reportSuppliersObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        reportProductsObj.setVisible(false);
        reportProductsObj.setVisible(true);
        reportProductsObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
        reportSalesBillingObj.setVisible(false);
        reportSalesBillingObj.setVisible(true);
        reportSalesBillingObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        reportSalesOrderObj.setVisible(false);
        reportSalesOrderObj.setVisible(true);
        reportSalesOrderObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        reportPurchaseOrdersObj.setVisible(false);
        reportPurchaseOrdersObj.setVisible(true);
        reportPurchaseOrdersObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        // TODO add your handling code here:
        reportPurchaseBillingObj.setVisible(false);
        reportPurchaseBillingObj.setVisible(true);
        reportPurchaseBillingObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jButtonReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportsActionPerformed
        // TODO add your handling code here:
        showReportsObj.setVisible(false);
        showReportsObj.setVisible(true);
        showReportsObj.requestFocus();
    }//GEN-LAST:event_jButtonReportsActionPerformed

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
        // TODO add your handling code here:
        transactionsSalesObj.setVisible(false);
        transactionsSalesObj.setVisible(true);
        transactionsSalesObj.requestFocus();
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
        transactionsPurchasesObj.setVisible(false);
        transactionsPurchasesObj.setVisible(true);
        transactionsPurchasesObj.requestFocus();
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        invoiceRecordsObj.setVisible(false);
        invoiceRecordsObj.setVisible(true);
        invoiceRecordsObj.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        // TODO add your handling code here:
        invoiceRecordsObj.setVisible(false);
        invoiceRecordsObj.setVisible(true);
        invoiceRecordsObj.requestFocus();
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        // TODO add your handling code here:
        reportMonthlySalesBillingObj.setVisible(false);
        reportMonthlySalesBillingObj.setVisible(true);
        reportMonthlySalesBillingObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        // TODO add your handling code here:
        reportMonthlyPurchaseBillingObj.setVisible(false);
        reportMonthlyPurchaseBillingObj.setVisible(true);
        reportMonthlyPurchaseBillingObj.requestFocus();
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        // TODO add your handling code here:
        viewAllProductsObj.refreshViewAllTable(2);
        viewAllProductsObj.setVisible(false);
        viewAllProductsObj.setVisible(true);
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        // TODO add your handling code here:
        viewAllProductsObj.refreshViewAllTable(3);
        viewAllProductsObj.setVisible(false);
        viewAllProductsObj.setVisible(true);
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
        viewAllProductsObj.refreshViewAllTable(4);
        viewAllProductsObj.setVisible(false);
        viewAllProductsObj.setVisible(true);
    }//GEN-LAST:event_jMenuItem39ActionPerformed

     
        
    public int askToLogout()    {
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Logout?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            this.setVisible(false);
            this.setEnabled(false);
                        
            LoginForm lf = new LoginForm();
            lf.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(NewMDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewMDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewMDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewMDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMDIApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAbout;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonOtherUtilities;
    private javax.swing.JButton jButtonProductsStock;
    private javax.swing.JButton jButtonReports;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonTransactions;
    private javax.swing.JButton jButtonViewPeople;
    private javax.swing.JButton jButtonViewProducts;
    private javax.swing.JComboBox<String> jComboBoxGoTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JPopupMenu.Separator jSeparator29;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator30;
    private javax.swing.JPopupMenu.Separator jSeparator31;
    private javax.swing.JPopupMenu.Separator jSeparator32;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    // End of variables declaration//GEN-END:variables

}
