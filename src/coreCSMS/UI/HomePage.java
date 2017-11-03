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

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import coreCSMS.UI.NewMDIApplication;

public class HomePage extends javax.swing.JInternalFrame {

    public NewMDIApplication mdiObj = null;
    
    /**
     * Creates new form HomePage
     */
    public HomePage(NewMDIApplication mdiObj) {
        this.mdiObj = mdiObj;
        initComponents();
        
        timer.schedule(tasknew, 0, 250);
    }
    Timer timer = new Timer();
    static int i=1, j=1, k=1, l=1;
    
    TimerTask tasknew = new TimerTask() {
        public void run()  {
            //Products Flash 
            try {
            if(i <= 83) {
                if(j <=10) {
                    switch(j)   {
                        case 1:
                            imagePanelProduct1.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 2:
                            imagePanelProduct2.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 3:
                            imagePanelProduct3.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 4:
                            imagePanelProduct4.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 5:
                            imagePanelProduct5.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 6:
                            imagePanelProduct6.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 7:
                            imagePanelProduct7.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 8:
                            imagePanelProduct8.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 9:
                            imagePanelProduct9.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                        case 10:
                            imagePanelProduct10.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\" + i + ".jpeg")).getImage());
                            repaint();
                            break;
                    }
                    j++;
                }
                else
                    j = 1;
                i++;
            }
            else
                i = 1;
            
            //Brand Flash for-loop
            if(k <= 60) {
                if(l <= 14) {
                    switch(l)   {
                        case 1:
                            imagePanelBrand1.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 2:
                            imagePanelBrand2.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 3:
                            imagePanelBrand3.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 4:
                            imagePanelBrand4.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 5:
                            imagePanelBrand5.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 6:
                            imagePanelBrand6.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 7:
                            imagePanelBrand7.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 8:
                            imagePanelBrand8.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 9:
                            imagePanelBrand9.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 10:
                            imagePanelBrand10.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 11:
                            imagePanelBrand11.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 12:
                            imagePanelBrand12.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 13:
                            imagePanelBrand13.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                        case 14:
                            imagePanelBrand14.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\" + k + ".jpg")).getImage());
                            repaint();
                            break;
                    }
                    l++;
                }
                else
                    l = 1;
                k++;
            }
            else
                k = 1;
            
            if(jButton1.getText().equals("CONTINUE >>>"))
                jButton1.setText("CONTINUE    ");
            else if(jButton1.getText().equals("CONTINUE    "))
                jButton1.setText("CONTINUE >  ");
            else if(jButton1.getText().equals("CONTINUE >  "))
                jButton1.setText("CONTINUE >> ");
            else if(jButton1.getText().equals("CONTINUE >> "))
                jButton1.setText("CONTINUE >>>");
        }catch(Exception e) {}
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        imagePanelLogo = new coreCSMS.UI.ImagePanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        imagePanelBrand1 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand2 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand3 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand4 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand5 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand6 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand7 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand8 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand9 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand10 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand11 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand12 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand13 = new coreCSMS.UI.ImagePanel();
        imagePanelBrand14 = new coreCSMS.UI.ImagePanel();
        jPanel4 = new javax.swing.JPanel();
        imagePanelProduct1 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct4 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct2 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct3 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct5 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct6 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct7 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct8 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct9 = new coreCSMS.UI.ImagePanel();
        imagePanelProduct10 = new coreCSMS.UI.ImagePanel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Home Page");
        setVisible(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.SystemColor.activeCaptionText));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Welcome User! Computer SuperStore Management System is an application that is used to manage the shopping/selling of various Computer Components. This Application is used to keep a record of various items that are to be sold to the Store's customers. The Computer Components are available in various categories such as, Motherboards, Processors, Graphics Cards, RAMs, Hard Disk Drives, Power Supply Units, etc.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );

        jPanel2.setBackground(java.awt.SystemColor.controlShadow);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.SystemColor.activeCaptionText));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/Home.png"))); // NOI18N

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
        jLabel2.setText("HOME PAGE");

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Brands"));

        javax.swing.GroupLayout imagePanelBrand1Layout = new javax.swing.GroupLayout(imagePanelBrand1);
        imagePanelBrand1.setLayout(imagePanelBrand1Layout);
        imagePanelBrand1Layout.setHorizontalGroup(
            imagePanelBrand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand1Layout.setVerticalGroup(
            imagePanelBrand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand2Layout = new javax.swing.GroupLayout(imagePanelBrand2);
        imagePanelBrand2.setLayout(imagePanelBrand2Layout);
        imagePanelBrand2Layout.setHorizontalGroup(
            imagePanelBrand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand2Layout.setVerticalGroup(
            imagePanelBrand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand3Layout = new javax.swing.GroupLayout(imagePanelBrand3);
        imagePanelBrand3.setLayout(imagePanelBrand3Layout);
        imagePanelBrand3Layout.setHorizontalGroup(
            imagePanelBrand3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand3Layout.setVerticalGroup(
            imagePanelBrand3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand4Layout = new javax.swing.GroupLayout(imagePanelBrand4);
        imagePanelBrand4.setLayout(imagePanelBrand4Layout);
        imagePanelBrand4Layout.setHorizontalGroup(
            imagePanelBrand4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand4Layout.setVerticalGroup(
            imagePanelBrand4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand5Layout = new javax.swing.GroupLayout(imagePanelBrand5);
        imagePanelBrand5.setLayout(imagePanelBrand5Layout);
        imagePanelBrand5Layout.setHorizontalGroup(
            imagePanelBrand5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand5Layout.setVerticalGroup(
            imagePanelBrand5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand6Layout = new javax.swing.GroupLayout(imagePanelBrand6);
        imagePanelBrand6.setLayout(imagePanelBrand6Layout);
        imagePanelBrand6Layout.setHorizontalGroup(
            imagePanelBrand6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand6Layout.setVerticalGroup(
            imagePanelBrand6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand7Layout = new javax.swing.GroupLayout(imagePanelBrand7);
        imagePanelBrand7.setLayout(imagePanelBrand7Layout);
        imagePanelBrand7Layout.setHorizontalGroup(
            imagePanelBrand7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand7Layout.setVerticalGroup(
            imagePanelBrand7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand8Layout = new javax.swing.GroupLayout(imagePanelBrand8);
        imagePanelBrand8.setLayout(imagePanelBrand8Layout);
        imagePanelBrand8Layout.setHorizontalGroup(
            imagePanelBrand8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand8Layout.setVerticalGroup(
            imagePanelBrand8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand9Layout = new javax.swing.GroupLayout(imagePanelBrand9);
        imagePanelBrand9.setLayout(imagePanelBrand9Layout);
        imagePanelBrand9Layout.setHorizontalGroup(
            imagePanelBrand9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand9Layout.setVerticalGroup(
            imagePanelBrand9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelBrand10Layout = new javax.swing.GroupLayout(imagePanelBrand10);
        imagePanelBrand10.setLayout(imagePanelBrand10Layout);
        imagePanelBrand10Layout.setHorizontalGroup(
            imagePanelBrand10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand10Layout.setVerticalGroup(
            imagePanelBrand10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        imagePanelBrand11.setPreferredSize(new java.awt.Dimension(92, 60));

        javax.swing.GroupLayout imagePanelBrand11Layout = new javax.swing.GroupLayout(imagePanelBrand11);
        imagePanelBrand11.setLayout(imagePanelBrand11Layout);
        imagePanelBrand11Layout.setHorizontalGroup(
            imagePanelBrand11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand11Layout.setVerticalGroup(
            imagePanelBrand11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        imagePanelBrand12.setPreferredSize(new java.awt.Dimension(92, 60));

        javax.swing.GroupLayout imagePanelBrand12Layout = new javax.swing.GroupLayout(imagePanelBrand12);
        imagePanelBrand12.setLayout(imagePanelBrand12Layout);
        imagePanelBrand12Layout.setHorizontalGroup(
            imagePanelBrand12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand12Layout.setVerticalGroup(
            imagePanelBrand12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        imagePanelBrand13.setPreferredSize(new java.awt.Dimension(92, 60));

        javax.swing.GroupLayout imagePanelBrand13Layout = new javax.swing.GroupLayout(imagePanelBrand13);
        imagePanelBrand13.setLayout(imagePanelBrand13Layout);
        imagePanelBrand13Layout.setHorizontalGroup(
            imagePanelBrand13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        imagePanelBrand13Layout.setVerticalGroup(
            imagePanelBrand13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        imagePanelBrand14.setPreferredSize(new java.awt.Dimension(84, 60));

        javax.swing.GroupLayout imagePanelBrand14Layout = new javax.swing.GroupLayout(imagePanelBrand14);
        imagePanelBrand14.setLayout(imagePanelBrand14Layout);
        imagePanelBrand14Layout.setHorizontalGroup(
            imagePanelBrand14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );
        imagePanelBrand14Layout.setVerticalGroup(
            imagePanelBrand14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(imagePanelBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(imagePanelBrand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanelBrand14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(imagePanelBrand1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePanelBrand11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(imagePanelBrand12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagePanelBrand13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagePanelBrand14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Products"));

        imagePanelProduct1.setBackground(new java.awt.Color(51, 204, 255));
        imagePanelProduct1.setPreferredSize(new java.awt.Dimension(215, 215));

        javax.swing.GroupLayout imagePanelProduct1Layout = new javax.swing.GroupLayout(imagePanelProduct1);
        imagePanelProduct1.setLayout(imagePanelProduct1Layout);
        imagePanelProduct1Layout.setHorizontalGroup(
            imagePanelProduct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        imagePanelProduct1Layout.setVerticalGroup(
            imagePanelProduct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelProduct4Layout = new javax.swing.GroupLayout(imagePanelProduct4);
        imagePanelProduct4.setLayout(imagePanelProduct4Layout);
        imagePanelProduct4Layout.setHorizontalGroup(
            imagePanelProduct4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        imagePanelProduct4Layout.setVerticalGroup(
            imagePanelProduct4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelProduct2Layout = new javax.swing.GroupLayout(imagePanelProduct2);
        imagePanelProduct2.setLayout(imagePanelProduct2Layout);
        imagePanelProduct2Layout.setHorizontalGroup(
            imagePanelProduct2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        imagePanelProduct2Layout.setVerticalGroup(
            imagePanelProduct2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        imagePanelProduct3.setPreferredSize(new java.awt.Dimension(124, 109));

        javax.swing.GroupLayout imagePanelProduct3Layout = new javax.swing.GroupLayout(imagePanelProduct3);
        imagePanelProduct3.setLayout(imagePanelProduct3Layout);
        imagePanelProduct3Layout.setHorizontalGroup(
            imagePanelProduct3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        imagePanelProduct3Layout.setVerticalGroup(
            imagePanelProduct3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        imagePanelProduct5.setPreferredSize(new java.awt.Dimension(124, 106));

        javax.swing.GroupLayout imagePanelProduct5Layout = new javax.swing.GroupLayout(imagePanelProduct5);
        imagePanelProduct5.setLayout(imagePanelProduct5Layout);
        imagePanelProduct5Layout.setHorizontalGroup(
            imagePanelProduct5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        imagePanelProduct5Layout.setVerticalGroup(
            imagePanelProduct5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout imagePanelProduct6Layout = new javax.swing.GroupLayout(imagePanelProduct6);
        imagePanelProduct6.setLayout(imagePanelProduct6Layout);
        imagePanelProduct6Layout.setHorizontalGroup(
            imagePanelProduct6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );
        imagePanelProduct6Layout.setVerticalGroup(
            imagePanelProduct6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        imagePanelProduct7.setPreferredSize(new java.awt.Dimension(124, 109));

        javax.swing.GroupLayout imagePanelProduct7Layout = new javax.swing.GroupLayout(imagePanelProduct7);
        imagePanelProduct7.setLayout(imagePanelProduct7Layout);
        imagePanelProduct7Layout.setHorizontalGroup(
            imagePanelProduct7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        imagePanelProduct7Layout.setVerticalGroup(
            imagePanelProduct7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        imagePanelProduct8.setPreferredSize(new java.awt.Dimension(124, 109));

        javax.swing.GroupLayout imagePanelProduct8Layout = new javax.swing.GroupLayout(imagePanelProduct8);
        imagePanelProduct8.setLayout(imagePanelProduct8Layout);
        imagePanelProduct8Layout.setHorizontalGroup(
            imagePanelProduct8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        imagePanelProduct8Layout.setVerticalGroup(
            imagePanelProduct8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        imagePanelProduct9.setPreferredSize(new java.awt.Dimension(124, 106));

        javax.swing.GroupLayout imagePanelProduct9Layout = new javax.swing.GroupLayout(imagePanelProduct9);
        imagePanelProduct9.setLayout(imagePanelProduct9Layout);
        imagePanelProduct9Layout.setHorizontalGroup(
            imagePanelProduct9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        imagePanelProduct9Layout.setVerticalGroup(
            imagePanelProduct9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );

        imagePanelProduct10.setPreferredSize(new java.awt.Dimension(124, 106));

        javax.swing.GroupLayout imagePanelProduct10Layout = new javax.swing.GroupLayout(imagePanelProduct10);
        imagePanelProduct10.setLayout(imagePanelProduct10Layout);
        imagePanelProduct10Layout.setHorizontalGroup(
            imagePanelProduct10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        imagePanelProduct10Layout.setVerticalGroup(
            imagePanelProduct10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(imagePanelProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(imagePanelProduct4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imagePanelProduct5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(imagePanelProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imagePanelProduct3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(imagePanelProduct6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(imagePanelProduct7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imagePanelProduct8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(imagePanelProduct9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imagePanelProduct10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imagePanelProduct2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imagePanelProduct3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagePanelProduct4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imagePanelProduct5, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                    .addComponent(imagePanelProduct1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imagePanelProduct7, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(imagePanelProduct8, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imagePanelProduct9, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(imagePanelProduct10, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imagePanelProduct6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/New Icons/IconsPNG/1456671165_desktop_go.png"))); // NOI18N
        jButton1.setText("CONTINUE >>>");
        jButton1.setToolTipText("Continue...");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.setPreferredSize(new java.awt.Dimension(117, 41));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(366, 366, 366)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        imagePanelLogo.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\CSMS\\CSMS2 final logo Small.jpg")).getImage());
                
        imagePanelProduct1.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\74.jpeg")).getImage());
        imagePanelProduct2.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\75.jpeg")).getImage());
        imagePanelProduct3.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\76.jpeg")).getImage());
        imagePanelProduct4.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\77.jpeg")).getImage());
        imagePanelProduct5.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\78.jpeg")).getImage());
        imagePanelProduct6.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\79.jpeg")).getImage());
        imagePanelProduct7.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\80.jpeg")).getImage());
        imagePanelProduct8.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\81.jpeg")).getImage());
        imagePanelProduct9.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\82.jpeg")).getImage());
        imagePanelProduct10.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Product Flash\\83.jpeg")).getImage());
        
        imagePanelBrand1.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\47.jpg")).getImage());
        imagePanelBrand2.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\48.jpg")).getImage());
        imagePanelBrand3.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\49.jpg")).getImage());
        imagePanelBrand4.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\50.jpg")).getImage());
        imagePanelBrand5.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\51.jpg")).getImage());
        imagePanelBrand6.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\52.jpg")).getImage());
        imagePanelBrand7.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\53.jpg")).getImage());
        imagePanelBrand8.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\54.jpg")).getImage());
        imagePanelBrand9.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\55.jpg")).getImage());
        imagePanelBrand10.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\56.jpg")).getImage());
        imagePanelBrand11.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\57.jpg")).getImage());
        imagePanelBrand12.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\58.jpg")).getImage());
        imagePanelBrand13.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\59.jpg")).getImage());
        imagePanelBrand14.setImage(new ImageIcon(this.getClass().getResource("\\..\\..\\Images\\Logos\\Brand Logos Flashing\\60.jpg")).getImage());

        
    }//GEN-LAST:event_formFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.mdiObj.viewProductCategoriesObj.setVisible(true);
        this.mdiObj.viewProductCategoriesObj.requestFocus();
        try {
            this.mdiObj.viewProductCategoriesObj.setMaximum(true);
        }
        catch(java.beans.PropertyVetoException e)  {}
        
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private coreCSMS.UI.ImagePanel imagePanelBrand1;
    private coreCSMS.UI.ImagePanel imagePanelBrand10;
    private coreCSMS.UI.ImagePanel imagePanelBrand11;
    private coreCSMS.UI.ImagePanel imagePanelBrand12;
    private coreCSMS.UI.ImagePanel imagePanelBrand13;
    private coreCSMS.UI.ImagePanel imagePanelBrand14;
    private coreCSMS.UI.ImagePanel imagePanelBrand2;
    private coreCSMS.UI.ImagePanel imagePanelBrand3;
    private coreCSMS.UI.ImagePanel imagePanelBrand4;
    private coreCSMS.UI.ImagePanel imagePanelBrand5;
    private coreCSMS.UI.ImagePanel imagePanelBrand6;
    private coreCSMS.UI.ImagePanel imagePanelBrand7;
    private coreCSMS.UI.ImagePanel imagePanelBrand8;
    private coreCSMS.UI.ImagePanel imagePanelBrand9;
    private coreCSMS.UI.ImagePanel imagePanelLogo;
    private coreCSMS.UI.ImagePanel imagePanelProduct1;
    private coreCSMS.UI.ImagePanel imagePanelProduct10;
    private coreCSMS.UI.ImagePanel imagePanelProduct2;
    private coreCSMS.UI.ImagePanel imagePanelProduct3;
    private coreCSMS.UI.ImagePanel imagePanelProduct4;
    private coreCSMS.UI.ImagePanel imagePanelProduct5;
    private coreCSMS.UI.ImagePanel imagePanelProduct6;
    private coreCSMS.UI.ImagePanel imagePanelProduct7;
    private coreCSMS.UI.ImagePanel imagePanelProduct8;
    private coreCSMS.UI.ImagePanel imagePanelProduct9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
