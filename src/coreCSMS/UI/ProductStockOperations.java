/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreCSMS.UI;

import javax.swing.*;
import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author hp-pc
 */
public class ProductStockOperations extends javax.swing.JInternalFrame {
    
    public NewMDIApplication mdiObj = null;
    public JFileChooser jFileChooser1 = null;
    /**
     * Creates new form ProductStockOperations
     */
    public ProductStockOperations(NewMDIApplication mdiObj) {
        initComponents();
        this.mdiObj = mdiObj;
        
        
    }
    
    public void initializeThisForm()    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("Select distinct product_brand from Products");
            while(rs.next())    {
                comboProductBrand.addItem(rs.getString(1));
                comboProductBrand1.addItem(rs.getString(1));
            }
            
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = st.executeQuery("select product_id from Products");
            if(rs.next())   {
                while(rs.next())    {}
                rs.previous();
                txtProductID.setText(new Integer(rs.getInt(1) + 1).toString());
            }
            else
                txtProductID.setText("1");
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                    
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = st.executeQuery("select category from Product_Categories");
            while(rs.next())    {
                comboProductCategory.addItem(rs.getString(1));
                comboProductCategory1.addItem(rs.getString(1));
            }
            
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
        
        imagePanel1.setImage(new ImageIcon(this.getClass().getResource("PhotoNotSelected.jpg")).getImage());
        repaint();
    }
    
    boolean flagDeletePhoto = false;
    public void setDeleteFlag(boolean flag)  {
        this.flagDeletePhoto = flag;
    }
    public boolean getDeleteFlag()  {
        return this.flagDeletePhoto;
    }
    
    public void basicFormCleanUp(int selectTab)  {
        if(selectTab == 1)  {
            try {
                boolean flg = getDeleteFlag();
                
                if((txtProductPhotoPath.getText() != null && !txtProductPhotoPath.getText().equals("")) && flg == true)   {
                    String s = txtProductPhotoPath.getText();
                    String pathToDelte = outputFileDefaultPath + s.substring(14);
                    
                    File deleteFile = new File(pathToDelte);
                    if(deleteFile.exists())
                        deleteFile.delete();
                    
                    setDeleteFlag(false);
                }
            }
            catch(SecurityException e)  {}
            finally {    
                imagePanel1.setImage(new ImageIcon(this.getClass().getResource("PhotoNotSelected.jpg")).getImage());
                repaint();                
                txtProductBrand.setText("");
                comboProductBrand.setSelectedIndex(0);
                txtProductModel.setText("");
                txtProductDescription.setText("");
                txtProductPrice.setText("");
                txtProductQuantityInStock.setText("");                
                txtProductCategory.setText("");
                comboProductCategory.setSelectedIndex(0);
                txtProductPhotoPath.setText("");
                photopath = null;
            }
        }
        else    {
            try {
                boolean flg = getDeleteFlag();
                if((txtProductPhotoPath1.getText() != null && !txtProductPhotoPath1.getText().equals("")) && flg == true)   {
                    String s = txtProductPhotoPath1.getText();
                    String pathToDelte = outputFileDefaultPath + s.substring(14);
                    
                    File deleteFile = new File(pathToDelte);
                    if(deleteFile.exists())
                        deleteFile.delete();
                    
                    setDeleteFlag(false); 
                }
            }
            catch(SecurityException e)  {}
            finally {    
                imagePanel2.setImage(new ImageIcon(this.getClass().getResource("PhotoNotSelected.jpg")).getImage());
                repaint();                
                txtProductBrand1.setText("");
                comboProductBrand1.setSelectedIndex(0);
                txtProductModel1.setText("");
                txtProductDescription1.setText("");
                txtProductPrice1.setText("");
                txtProductQuantityInStock1.setText("");                
                txtProductCategory1.setText("");
                comboProductCategory1.setSelectedIndex(0);
                txtProductPhotoPath1.setText("");
                photopath = null;
            }
        }
    }
    
    public void addProduct()    {
        try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                
                Statement st = con.createStatement();
                String sqlIn = "insert into Products values(" + Integer.parseInt(txtProductID.getText()) + ", '" + txtProductBrand.getText() + "', '" + txtProductModel.getText() + "', '" + txtProductDescription.getText() + "', " + Integer.parseInt(txtProductPrice.getText()) + ", " + Integer.parseInt(txtProductQuantityInStock.getText()) + ", '" + txtProductPhotoPath.getText() + "', '" + txtProductCategory.getText() + "')";
                
                int rs = st.executeUpdate(sqlIn);
                
                JOptionPane.showMessageDialog(rootPane, "New Product Added. " + rs + " Row(s) added Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                
                st.close();
                con.close();                                                               
                operationCompleteShowResult(txtProductCategory.getText());
            }
            catch(ClassNotFoundException e) {}
            catch(SQLException e)   {}                
    }
    
    public void operationCompleteShowResult(String strProductCategory)   {

        switch(strProductCategory) {
            case "Chassis":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(9);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Desktops":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(18);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Graphic Cards":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(4);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Hard Disk Drives":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(6);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Headphones":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(13);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Keyboards":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(11);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;                        
            case "Laptops":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(17);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Mice":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(12);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Monitors":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(10);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Motherboards":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(0);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Optical Drives":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(7);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Other Accessories":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(16);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Power Supply Units":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(8);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Printers and Inks":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(15);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Processor Heat Sinks":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(2);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Processors":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(1);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "RAMs":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(3);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Sound Cards":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(5);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
            case "Speakers":
                this.mdiObj.viewProductByCategoriesObj.selectProductCategoryTab(14);
                this.mdiObj.viewProductByCategoriesObj.setVisible(false);
                this.mdiObj.viewProductByCategoriesObj.setVisible(true);
                break;
        }
        
        imagePanel1.setImage(new ImageIcon(this.getClass().getResource("PhotoNotSelected.jpg")).getImage());
        repaint();
        imagePanel2.setImage(new ImageIcon(this.getClass().getResource("PhotoNotSelected.jpg")).getImage());
        repaint();                
        txtProductBrand.setText("");
        txtProductBrand1.setText("");
        comboProductBrand.setSelectedIndex(0);
        comboProductBrand1.setSelectedIndex(0);
        txtProductModel.setText("");
        txtProductModel1.setText("");
        txtProductDescription.setText("");
        txtProductDescription1.setText("");
        txtProductPrice.setText("");
        txtProductPrice1.setText("");
        txtProductQuantityInStock.setText("");                
        txtProductQuantityInStock1.setText("");                
        txtProductCategory.setText("");
        txtProductCategory1.setText("");
        comboProductCategory.setSelectedIndex(0);
        comboProductCategory1.setSelectedIndex(0);
        txtProductPhotoPath.setText("");
        txtProductPhotoPath1.setText("");        
        photopath = null;
        
    }
    
    String updateExistingPhoto = null;
    public void setUpdateExistingPhoto(String photo)    {
        this.updateExistingPhoto = photo;
    }
    public String getUpdateExistingPhoto()  {
        return this.updateExistingPhoto;
    }
            
    public void updateProduct() {
        String str = getUpdateExistingPhoto();
        if(str != null && !str.equals("")) {
            String s = str;
            String pathToDelte = outputFileDefaultPath + s.substring(14);
                    
            File deleteFile = new File(pathToDelte);
            if(deleteFile.exists())
                deleteFile.delete();      
            setUpdateExistingPhoto(null);
        }
        if(!(txtProductBrand1.getText().length()==0 && txtProductCategory1.getText().length()==0 && txtProductID1.getText().length()==0 && txtProductModel1.getText().length()==0 && txtProductPhotoPath1.getText().length()==0 && txtProductPrice1.getText().length()==0 && txtProductQuantityInStock1.getText().length()==0))   {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                
                Statement st = con.createStatement();
                String sqlUp = "update Products set product_brand='" + txtProductBrand1.getText() + "', product_model='" + txtProductModel1.getText() + "', product_description='" + txtProductDescription1.getText() + "', product_price=" + Integer.parseInt(txtProductPrice1.getText()) + ", product_quantity_in_stock=" + Integer.parseInt(txtProductQuantityInStock1.getText()) + ", product_photo_path='" + txtProductPhotoPath1.getText() + "', product_category='" + txtProductCategory1.getText() + "' where product_id=" + Integer.parseInt(txtProductID1.getText()) + "";
                
                int rs = st.executeUpdate(sqlUp);
                
                JOptionPane.showMessageDialog(rootPane, "Existing Product updated. " + rs + " Row(s) updated Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                
                st.close();
                con.close();
                operationCompleteShowResult(txtProductCategory1.getText());
            }
            catch(ClassNotFoundException e) {}
            catch(SQLException e)   {}
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Please Enter Complete and Valid Values!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }
    
    public void deleteProduct() {
        try {
                if(txtProductPhotoPath1.getText() != null)   {
                    String s = txtProductPhotoPath1.getText();
                    String pathToDelte = outputFileDefaultPath + s.substring(14);
                    
                    File deleteFile = new File(pathToDelte);
                    if(deleteFile.exists())
                        deleteFile.delete();                    
                }
                
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
                
                Statement st = con.createStatement();
                String sqlUp = "delete from Products where product_id=" + Integer.parseInt(txtProductID1.getText()) + "";
                
                int rs = st.executeUpdate(sqlUp);
                
                JOptionPane.showMessageDialog(rootPane, "Existing Product Deleted. " + rs + " Row(s) deleted Successfully!", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                
                st.close();
                con.close();
                operationCompleteShowResult(txtProductCategory1.getText());
            }
            catch(SecurityException e)  {}
            catch(ClassNotFoundException e) {}
            catch(SQLException e)   {}
            finally {    
                imagePanel2.setImage(new ImageIcon(this.getClass().getResource("PhotoNotSelected.jpg")).getImage());
                repaint();                
                txtProductBrand1.setText("");
                comboProductBrand1.setSelectedIndex(0);
                txtProductModel1.setText("");
                txtProductDescription1.setText("");
                txtProductPrice1.setText("");
                txtProductQuantityInStock1.setText("");                
                txtProductCategory1.setText("");
                comboProductCategory1.setSelectedIndex(0);
                txtProductPhotoPath1.setText("");
                photopath = null;
            }
    }
    
    public void addPhotoFileChooser(int selectTab)   {
        if(selectTab == 1 && comboProductCategory.getSelectedIndex()!=0)  {
            setDeleteFlag(true);
            
            jFileChooser1 = new JFileChooser();

            FileFilter jpegFilter = new ExtensionFileFilter(null, new String[] { "JPG", "JPEG" });
            jFileChooser1.addChoosableFileFilter(jpegFilter);
            jFileChooser1.setFileFilter(jpegFilter);

            int v = jFileChooser1.showOpenDialog(rootPane);
            String choice = new String();
            File inputFile = null;
            switch(v) {
                case JFileChooser.APPROVE_OPTION:
                if (jFileChooser1.getSelectedFile() != null) {
                    choice = jFileChooser1.getSelectedFile().getPath();
                    inputFile = jFileChooser1.getSelectedFile();
                }
                break;
                case JFileChooser.CANCEL_OPTION:
                case JFileChooser.ERROR_OPTION:
            }
            jFileChooser1.removeAll();
            jFileChooser1 = null;
            
            if(inputFile != null)   {
                File outputFile = null;
                try {
                    switch(comboProductCategory.getSelectedIndex()) {
                        case 1:
                            outputFilePath = ("Products\\Chassis\\" + inputFile.getName());
                            break;
                        case 2:
                            outputFilePath = ("Products\\Laptops and Desktops\\Desktops\\" + inputFile.getName());
                            break;
                        case 3:
                            outputFilePath = ("Products\\Graphics Cards\\" + inputFile.getName());
                            break;
                        case 4:
                            outputFilePath = ("Products\\Hard Disks\\" + inputFile.getName());
                            break;
                        case 5:
                            outputFilePath = ("Products\\Headphones\\" + inputFile.getName());
                            break;
                        case 6:
                            outputFilePath = ("Products\\Keyboards\\" + inputFile.getName());
                            break;
                        case 7:
                            outputFilePath = ("Products\\Laptops and Desktops\\Laptops\\" + inputFile.getName());
                            break;
                        case 8:
                            outputFilePath = ("Products\\Mice\\" + inputFile.getName());
                            break;
                        case 9:
                            outputFilePath = ("Products\\Monitors\\" + inputFile.getName());
                            break;
                        case 10:
                            outputFilePath = ("Products\\Motherboards\\" + inputFile.getName());
                            break;
                        case 11:
                            outputFilePath = ("Products\\Optical Drives\\" + inputFile.getName());
                            break;
                        case 12:
                            outputFilePath = ("Products\\Other Accessories\\" + inputFile.getName());
                            break;
                        case 13:
                            outputFilePath = ("Products\\PSUs\\" + inputFile.getName());
                            break;
                        case 14:
                            outputFilePath = ("Products\\Printers and Inks\\" + inputFile.getName());
                            break;
                        case 15:
                            outputFilePath = ("Products\\Processor Heat Sinks\\" + inputFile.getName());
                            break;
                        case 16:
                            outputFilePath = ("Products\\Processors\\" + inputFile.getName());
                            break;
                        case 17:    
                            outputFilePath = ("Products\\RAMs\\" + inputFile.getName());
                            break;
                        case 18:
                            outputFilePath = ("Products\\Sound Cards\\" + inputFile.getName());
                            break;
                        case 19:
                            outputFilePath = ("Products\\Speakers\\" + inputFile.getName());
                            break;                        
                    }

                    if(outputFilePath != null)  {     
                        if(outputFilePath.endsWith(".JPEG") || outputFilePath.endsWith(".JPG") || outputFilePath.endsWith(".jpeg") || outputFilePath.endsWith(".jpg"))  {
                            photopath = outputFileDefaultPath + outputFilePath;
                            outputFile = new File(photopath);
                            Files.copy(inputFile.toPath(), outputFile.toPath());

                            txtProductPhotoPath.setText("\\..\\..\\Images\\" + outputFilePath);
                            repaint();
                            JOptionPane.showMessageDialog(rootPane, "Please wait while the Photo is being Loaded. Please 'Refresh' after a few Seconds.", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(rootPane, "Please Select a Photo File of '.JPG/.JPEG' format only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                    }                
                }
                catch(IOException e)    {
                    JOptionPane.showMessageDialog(rootPane, "Error in Loading Product Photo! Product Photo Already Exists!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    inputFile = null;
                    outputFile = null;
                }            
            
                try {
                    imagePanel1.setImage(new ImageIcon(this.getClass().getResource(txtProductPhotoPath.getText())).getImage());
                    repaint();                
                }
                catch(NullPointerException e)   {}
            }
        }
        else if (selectTab != 1 && comboProductCategory1.getSelectedIndex()!=0)    {
            setUpdateExistingPhoto(txtProductPhotoPath1.getText());
            setDeleteFlag(true);
            
            jFileChooser1 = new JFileChooser();

            FileFilter jpegFilter = new ExtensionFileFilter(null, new String[] { "JPG", "JPEG" });
            jFileChooser1.addChoosableFileFilter(jpegFilter);
            jFileChooser1.setFileFilter(jpegFilter);

            int v = jFileChooser1.showOpenDialog(rootPane);
            String choice = new String();
            File inputFile = null;
            switch(v) {
                case JFileChooser.APPROVE_OPTION:
                if (jFileChooser1.getSelectedFile() != null) {
                    choice = jFileChooser1.getSelectedFile().getPath();
                    inputFile = jFileChooser1.getSelectedFile();
                }
                break;
                case JFileChooser.CANCEL_OPTION:
                case JFileChooser.ERROR_OPTION:
            }
            jFileChooser1.removeAll();
            jFileChooser1 = null;
       
            if(inputFile != null)   {
                File outputFile = null;
                try {
                    switch(comboProductCategory1.getSelectedIndex()) {
                        case 1:
                            outputFilePath = ("Products\\Chassis\\" + inputFile.getName());
                            break;
                        case 2:
                            outputFilePath = ("Products\\Laptops and Desktops\\Desktops\\" + inputFile.getName());
                            break;
                        case 3:
                            outputFilePath = ("Products\\Graphics Cards\\" + inputFile.getName());
                            break;
                        case 4:
                            outputFilePath = ("Products\\Hard Disks\\" + inputFile.getName());
                            break;
                        case 5:
                            outputFilePath = ("Products\\Headphones\\" + inputFile.getName());
                            break;
                        case 6:
                            outputFilePath = ("Products\\Keyboards\\" + inputFile.getName());
                            break;
                        case 7:
                            outputFilePath = ("Products\\Laptops and Desktops\\Laptops\\" + inputFile.getName());
                            break;
                        case 8:
                            outputFilePath = ("Products\\Mice\\" + inputFile.getName());
                            break;
                        case 9:
                            outputFilePath = ("Products\\Monitors\\" + inputFile.getName());
                            break;
                        case 10:
                            outputFilePath = ("Products\\Motherboards\\" + inputFile.getName());
                            break;
                        case 11:
                            outputFilePath = ("Products\\Optical Drives\\" + inputFile.getName());
                            break;
                        case 12:
                            outputFilePath = ("Products\\Other Accessories\\" + inputFile.getName());
                            break;
                        case 13:
                            outputFilePath = ("Products\\PSUs\\" + inputFile.getName());
                            break;
                        case 14:
                            outputFilePath = ("Products\\Printers and Inks\\" + inputFile.getName());
                            break;
                        case 15:
                            outputFilePath = ("Products\\Processor Heat Sinks\\" + inputFile.getName());
                            break;
                        case 16:
                            outputFilePath = ("Products\\Processors\\" + inputFile.getName());
                            break;
                        case 17:    
                            outputFilePath = ("Products\\RAMs\\" + inputFile.getName());
                            break;
                        case 18:
                            outputFilePath = ("Products\\Sound Cards\\" + inputFile.getName());
                            break;
                        case 19:
                            outputFilePath = ("Products\\Speakers\\" + inputFile.getName());
                            break;                        
                    }   

                    if(outputFilePath != null)  {     
                        if(outputFilePath.endsWith(".JPEG") || outputFilePath.endsWith(".JPG") || outputFilePath.endsWith(".jpeg") || outputFilePath.endsWith(".jpg"))  {
                            photopath = outputFileDefaultPath + outputFilePath;
                            outputFile = new File(photopath);
                            Files.copy(inputFile.toPath(), outputFile.toPath());
                            
                            txtProductPhotoPath1.setText("\\..\\..\\Images\\" + outputFilePath);
                            
                            repaint();
                            JOptionPane.showMessageDialog(rootPane, "Please wait while the Photo is being Loaded. Please 'Refresh' after a few Seconds.", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(rootPane, "Please Select a Photo File of '.JPG/.JPEG' format only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                    }                
                }
                catch(IOException e)    {
                    JOptionPane.showMessageDialog(rootPane, "Error in Loading Product Photo! Product Photo Already Exists!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
                }   
                finally {
                    inputFile = null;
                    outputFile = null;
                }            
            
                try {
                    imagePanel2.setImage(new ImageIcon(this.getClass().getResource(txtProductPhotoPath1.getText())).getImage());
                    repaint();                
                }
                catch(NullPointerException e)   {}
            }
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Please Select a Product Category First!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }
    
    public void selectProductFromTable(int paramProduct_id)    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN_256");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Products where product_id = " + paramProduct_id);
            while(rs.next())    {
                txtProductID1.setText(new Integer(rs.getInt(1)).toString());
                txtProductBrand1.setText(rs.getString(2));
                comboProductBrand1.setEditable(true);
                comboProductBrand1.setSelectedItem(txtProductBrand1.getText());
                comboProductBrand1.setEditable(false);
                txtProductModel1.setText(rs.getString(3));
                txtProductDescription1.setText(rs.getString(4));
                txtProductPrice1.setText(new Integer(rs.getInt(5)).toString());
                txtProductQuantityInStock1.setText(new Integer(rs.getInt(6)).toString());
                txtProductPhotoPath1.setText(rs.getString(7));
                txtProductCategory1.setText(rs.getString(8));
                comboProductCategory1.setEditable(true);
                comboProductCategory1.setSelectedItem(txtProductCategory1.getText());
                comboProductCategory1.setEditable(false);                
                imagePanel2.setImage(new ImageIcon(this.getClass().getResource(txtProductPhotoPath1.getText())).getImage());
                repaint();                
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(ClassNotFoundException e) {}
        catch(SQLException e)   {}
        catch(NullPointerException e)   {}
    }
    
    public void selectOperationsTab(int paramProduct_id)    {
        this.jTabbedPanelStockOperations.setSelectedIndex(1);
        this.selectProductFromTable(paramProduct_id);
    }
    
    public void selectAddNewOperation()    {
        this.jTabbedPanelStockOperations.setSelectedIndex(0);
    }
    
    String outputFilePath = null;
    String photopath = null;
    String outputFileDefaultPath = "C:\\Users\\hp-pc\\Documents\\NetBeansProjects\\CSMS\\src\\Images\\";
    
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
        jTabbedPanelStockOperations = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        txtProductQuantityInStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtProductDescription = new javax.swing.JTextArea();
        txtProductCategory = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProductPhotoPath = new javax.swing.JTextArea();
        txtProductModel = new javax.swing.JTextField();
        txtProductBrand = new javax.swing.JTextField();
        txtProductID = new javax.swing.JTextField();
        comboProductBrand = new javax.swing.JComboBox<>();
        comboProductCategory = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        imagePanel1 = new coreCSMS.UI.ImagePanel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtProductPrice1 = new javax.swing.JTextField();
        txtProductQuantityInStock1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtProductDescription1 = new javax.swing.JTextArea();
        txtProductCategory1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtProductPhotoPath1 = new javax.swing.JTextArea();
        txtProductModel1 = new javax.swing.JTextField();
        txtProductBrand1 = new javax.swing.JTextField();
        txtProductID1 = new javax.swing.JTextField();
        comboProductBrand1 = new javax.swing.JComboBox<>();
        comboProductCategory1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        imagePanel2 = new coreCSMS.UI.ImagePanel();
        jPanel9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Product Stock Operations");
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
                formInternalFrameOpened(evt);
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/ProductsStock.png"))); // NOI18N

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
        jLabel2.setText("PRODUCT STOCK OPERATIONS");

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Details"));

        jLabel3.setText("Product ID:");

        jLabel4.setText("Product Brand:");

        jLabel5.setText("Product Model:");

        jLabel6.setText("Product Description:");

        jLabel7.setText("Product Price (Rs.):");

        jLabel8.setText("Product Quantity in Stock:");

        jLabel9.setText("Product Category:");

        jLabel10.setText("Product Photo Path:");

        txtProductPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductPriceActionPerformed(evt);
            }
        });
        txtProductPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductPriceKeyTyped(evt);
            }
        });

        txtProductQuantityInStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductQuantityInStockActionPerformed(evt);
            }
        });
        txtProductQuantityInStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductQuantityInStockKeyTyped(evt);
            }
        });

        txtProductDescription.setColumns(20);
        txtProductDescription.setRows(5);
        jScrollPane1.setViewportView(txtProductDescription);

        txtProductCategory.setEditable(false);

        txtProductPhotoPath.setEditable(false);
        txtProductPhotoPath.setColumns(20);
        txtProductPhotoPath.setRows(5);
        jScrollPane2.setViewportView(txtProductPhotoPath);

        txtProductBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductBrandActionPerformed(evt);
            }
        });

        txtProductID.setEditable(false);

        comboProductBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Select Product Brand...)" }));
        comboProductBrand.setToolTipText("Select Product Brand");
        comboProductBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductBrandActionPerformed(evt);
            }
        });

        comboProductCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Select Product Category...)" }));
        comboProductCategory.setToolTipText("Select Product Category");
        comboProductCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductCategoryActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686007_photo-add.png"))); // NOI18N
        jButton1.setText("Add Photo...");
        jButton1.setToolTipText("Add Photo...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProductBrand)
                            .addComponent(txtProductModel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtProductCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductQuantityInStock, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProductModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductQuantityInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(comboProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Photo"));

        imagePanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout imagePanel1Layout = new javax.swing.GroupLayout(imagePanel1);
        imagePanel1.setLayout(imagePanel1Layout);
        imagePanel1Layout.setHorizontalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
        imagePanel1Layout.setVerticalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686460_arrow-refresh.png"))); // NOI18N
        jButton2.setText("Refresh");
        jButton2.setToolTipText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686465_save_accept.png"))); // NOI18N
        jButton4.setText("Save Product");
        jButton4.setToolTipText("Save Product");
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
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPanelStockOperations.addTab("Add New Product", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Details"));

        jLabel11.setText("Product ID:");

        jLabel12.setText("Product Brand:");

        jLabel13.setText("Product Model:");

        jLabel14.setText("Product Description:");

        jLabel15.setText("Product Price (Rs.):");

        jLabel16.setText("Product Quantity in Stock:");

        jLabel17.setText("Product Category:");

        jLabel18.setText("Product Photo Path:");

        txtProductPrice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductPrice1ActionPerformed(evt);
            }
        });
        txtProductPrice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductPrice1KeyTyped(evt);
            }
        });

        txtProductQuantityInStock1.setEditable(false);
        txtProductQuantityInStock1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductQuantityInStock1KeyTyped(evt);
            }
        });

        txtProductDescription1.setColumns(20);
        txtProductDescription1.setRows(5);
        jScrollPane3.setViewportView(txtProductDescription1);

        txtProductCategory1.setEditable(false);

        txtProductPhotoPath1.setEditable(false);
        txtProductPhotoPath1.setColumns(20);
        txtProductPhotoPath1.setRows(5);
        jScrollPane4.setViewportView(txtProductPhotoPath1);

        txtProductBrand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductBrand1ActionPerformed(evt);
            }
        });

        txtProductID1.setEditable(false);

        comboProductBrand1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Select Product Brand...)" }));
        comboProductBrand1.setToolTipText("Select Product Brand");
        comboProductBrand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductBrand1ActionPerformed(evt);
            }
        });

        comboProductCategory1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Select Product Category...)" }));
        comboProductCategory1.setToolTipText("Select Product Category");
        comboProductCategory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductCategory1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1457686007_photo-add.png"))); // NOI18N
        jButton3.setText("Add Photo...");
        jButton3.setToolTipText("Add Photo...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16))
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProductBrand1)
                            .addComponent(txtProductModel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboProductBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtProductCategory1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboProductCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductID1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductQuantityInStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtProductID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtProductBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProductBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtProductModel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductQuantityInStock1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(comboProductCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Photo"));

        imagePanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout imagePanel2Layout = new javax.swing.GroupLayout(imagePanel2);
        imagePanel2.setLayout(imagePanel2Layout);
        imagePanel2Layout.setHorizontalGroup(
            imagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
        imagePanel2Layout.setVerticalGroup(
            imagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        jButton8.setText("Save Product");
        jButton8.setToolTipText("Save Product");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458001953_trash.png"))); // NOI18N
        jButton9.setText("Delete Product");
        jButton9.setToolTipText("Delete Product");
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

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1458099976_Upload.png"))); // NOI18N
        jButton13.setText("Sales Transaction");
        jButton13.setToolTipText("Sales Transaction");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
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
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPanelStockOperations.addTab("View Product", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanelStockOperations)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPanelStockOperations)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductBrandActionPerformed

    private void comboProductBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductBrandActionPerformed
        // TODO add your handling code here:
        if(comboProductBrand.getSelectedIndex() != 0)
            txtProductBrand.setText(comboProductBrand.getSelectedItem().toString());
        else
            txtProductBrand.setText("");
    }//GEN-LAST:event_comboProductBrandActionPerformed

    private void txtProductPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductPriceKeyTyped
        // TODO add your handling code here:
        int ch = evt.getKeyChar();
        if((!(ch>=48 && ch<=57)) && ch!=8 && ch!=10 && ch!=127 && !(ch>=96 && ch<=105)) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtProductPriceKeyTyped

    private void txtProductQuantityInStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductQuantityInStockKeyTyped
        // TODO add your handling code here:
        int ch = evt.getKeyChar();
        if((!(ch>=48 && ch<=57)) && ch!=8 && ch!=10 && ch!=127 && !(ch>=96 && ch<=105)) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtProductQuantityInStockKeyTyped

    private void comboProductCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductCategoryActionPerformed
        // TODO add your handling code here:
        if(comboProductCategory.getSelectedIndex() != 0)
            txtProductCategory.setText(comboProductCategory.getSelectedItem().toString());
        else
            txtProductCategory.setText("");
    }//GEN-LAST:event_comboProductCategoryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addPhotoFileChooser(1);
        jButton2.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if(txtProductPhotoPath.getText().length() != 0 && !txtProductPhotoPath.getText().equals("\\..\\..\\Images\\null")) {
                imagePanel1.setImage(new ImageIcon(this.getClass().getResource(txtProductPhotoPath.getText())).getImage());
                repaint();
            }
            else    {
                imagePanel1.setImage(new ImageIcon(this.getClass().getResource("PhotoNotSelected.jpg")).getImage());
                repaint();
            }
        }
        catch(NullPointerException e)   {
            JOptionPane.showMessageDialog(rootPane, "Please wait while the Photo is being Loaded. Please 'Refresh' after a few Seconds.", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formInternalFrameOpened

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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Cancel?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            basicFormCleanUp(1);
            
            this.setVisible(false);
            mdiObj.homePageObj.setVisible(true);
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Clear All?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            basicFormCleanUp(1);
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(!txtProductBrand.getText().equals("") && !txtProductCategory.getText().equals("") && !txtProductModel.getText().equals("") && !txtProductPhotoPath.getText().equals("") && !txtProductPrice.getText().equals("") && !txtProductQuantityInStock.getText().equals(""))   {           
            int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Add this Product?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION)
                addProduct();
            else if(res == JOptionPane.NO_OPTION)
                this.setVisible(true);    
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Please Enter Complete and Valid Values!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtProductPrice1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductPrice1KeyTyped
        // TODO add your handling code here:
        int ch = evt.getKeyChar();
        if((!(ch>=48 && ch<=57)) && ch!=8 && ch!=10 && ch!=127 && !(ch>=96 && ch<=105)) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtProductPrice1KeyTyped

    private void txtProductQuantityInStock1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductQuantityInStock1KeyTyped
        // TODO add your handling code here:
        int ch = evt.getKeyChar();
        if((!(ch>=48 && ch<=57)) && ch!=8 && ch!=10 && ch!=127 && !(ch>=96 && ch<=105)) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Numbers only!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtProductQuantityInStock1KeyTyped

    private void txtProductBrand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductBrand1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductBrand1ActionPerformed

    private void comboProductBrand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductBrand1ActionPerformed
        // TODO add your handling code here:
        if(comboProductBrand1.getSelectedIndex() != 0)
            txtProductBrand1.setText(comboProductBrand1.getSelectedItem().toString());
        else
            txtProductBrand1.setText("");
    }//GEN-LAST:event_comboProductBrand1ActionPerformed

    private void comboProductCategory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductCategory1ActionPerformed
        // TODO add your handling code here:
        if(comboProductCategory1.getSelectedIndex() != 0)
            txtProductCategory1.setText(comboProductCategory1.getSelectedItem().toString());
        else
            txtProductCategory1.setText("");
    }//GEN-LAST:event_comboProductCategory1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        addPhotoFileChooser(2);
        jButton7.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            if(txtProductPhotoPath1.getText().length() != 0 && !txtProductPhotoPath1.getText().equals("\\..\\..\\Images\\null")) {
                imagePanel2.setImage(new ImageIcon(this.getClass().getResource(txtProductPhotoPath1.getText())).getImage());
                repaint();
            }
            else    {
                imagePanel2.setImage(new ImageIcon(this.getClass().getResource("PhotoNotSelected.jpg")).getImage());
                repaint();
            }
        }
        catch(NullPointerException e)   {
            JOptionPane.showMessageDialog(rootPane, "Please wait while the Photo is being Loaded. Please 'Refresh' after a few Seconds.", "CSMS - Message" , JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Update Product Details?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            updateProduct();
            flagDeletePhoto = false;
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);    
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Delete this Product?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            deleteProduct();            
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);    
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(mdiObj.transactionsSalesObj.isSalesTxnOpen())    {
            int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Cancel?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION)   {
                mdiObj.transactionsSalesObj.setVisible(false);
                mdiObj.transactionsSalesObj.setVisible(true);
            }
            else if(res == JOptionPane.NO_OPTION)
                this.setVisible(true);    
        }
        else if(mdiObj.transactionsPurchasesObj.isSalesTxnOpen())    {
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
                basicFormCleanUp(2);
            
                this.setVisible(false);
                mdiObj.viewProductByCategoriesObj.setVisible(false);
                mdiObj.viewProductByCategoriesObj.setVisible(true);
                mdiObj.viewProductByCategoriesObj.requestFocus();
            }
            else if(res == JOptionPane.NO_OPTION)
                this.setVisible(true);    
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtProductPrice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductPrice1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductPrice1ActionPerformed

    private void txtProductPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductPriceActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Clear All?", "CSMS - Question", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION)   {
            basicFormCleanUp(2);
        }
        else if(res == JOptionPane.NO_OPTION)
            this.setVisible(true);    
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtProductQuantityInStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductQuantityInStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductQuantityInStockActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        basicFormCleanUp(1);
        basicFormCleanUp(2);
    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(mdiObj.transactionsPurchasesObj.isSalesTxnOpen())    {            
            mdiObj.transactionsPurchasesObj.addProductToPurchaseOrder(txtProductID1.getText(), txtProductBrand1.getText(), txtProductModel1.getText(), txtProductPrice1.getText(), txtProductQuantityInStock1.getText());
            mdiObj.transactionsPurchasesObj.setVisible(false);
            mdiObj.transactionsPurchasesObj.setVisible(true);            
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Purchases Transaction is Not Open! Cannot Add Product to Sales Transaction", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(mdiObj.transactionsSalesObj.isSalesTxnOpen())    {
            if(Integer.parseInt(txtProductQuantityInStock1.getText()) > 0)  {
                mdiObj.transactionsSalesObj.addProductToSalesOrder(txtProductID1.getText(), txtProductBrand1.getText(), txtProductModel1.getText(), txtProductPrice1.getText(), txtProductQuantityInStock1.getText());
                mdiObj.transactionsSalesObj.setVisible(false);
                mdiObj.transactionsSalesObj.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(rootPane, "This Product is Out of Stock!", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Sales Transaction is Not Open! Cannot Add Product to Sales Transaction", "CSMS - Error" , JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboProductBrand;
    private javax.swing.JComboBox<String> comboProductBrand1;
    private javax.swing.JComboBox<String> comboProductCategory;
    private javax.swing.JComboBox<String> comboProductCategory1;
    private coreCSMS.UI.ImagePanel imagePanel1;
    private coreCSMS.UI.ImagePanel imagePanel2;
    private coreCSMS.UI.ImagePanel imagePanelLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPanelStockOperations;
    private javax.swing.JTextField txtProductBrand;
    private javax.swing.JTextField txtProductBrand1;
    private javax.swing.JTextField txtProductCategory;
    private javax.swing.JTextField txtProductCategory1;
    private javax.swing.JTextArea txtProductDescription;
    private javax.swing.JTextArea txtProductDescription1;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductID1;
    private javax.swing.JTextField txtProductModel;
    private javax.swing.JTextField txtProductModel1;
    private javax.swing.JTextArea txtProductPhotoPath;
    private javax.swing.JTextArea txtProductPhotoPath1;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductPrice1;
    private javax.swing.JTextField txtProductQuantityInStock;
    private javax.swing.JTextField txtProductQuantityInStock1;
    // End of variables declaration//GEN-END:variables
}


class ExtensionFileFilter extends FileFilter {
    String description;

    String extensions[];

    public ExtensionFileFilter(String description, String extension) {
        this(description, new String[] { extension });
    }

    public ExtensionFileFilter(String description, String extensions[]) {
        if (description == null) {
            this.description = extensions[0] /*+ "{ " + extensions.length + "} "*/;
        }
        else {
            this.description = description;
        }
        this.extensions = (String[]) extensions.clone();
        toLower(this.extensions);
    }

    private void toLower(String array[]) {
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] = array[i].toLowerCase();
        }
    }

    public String getDescription() {
        return description;
    }

    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        else {
            String path = file.getAbsolutePath().toLowerCase();
            for (int i = 0, n = extensions.length; i < n; i++) {
                String extension = extensions[i];
                if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                    return true;
                }
            }
        }
        return false;
    }
}
