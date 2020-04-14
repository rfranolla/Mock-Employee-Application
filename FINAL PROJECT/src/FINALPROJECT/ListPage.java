/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FINALPROJECT;

import java.util.Arrays;

/**
 *
 * @author rammy
 */
public class ListPage extends javax.swing.JFrame {
    
    private static String[][] EmployeeData = new String [10000][16];
    private static String[] sSortArray;
    private static String[] data;
    private static int iMaxSize = 0;

    /**
     * Creates new form ListPage
     */
    public ListPage() {
        initComponents();
    }
    
    public ListPage (String [][] sGetData){
        initComponents();
        EmployeeData = sGetData;
        for (int i = 1; i <= 10000; i++)
        {
            if(EmployeeData [i][1] != null)
                iMaxSize++;
            else
                break;
        }
        sSortArray = new String [iMaxSize];
    }
    
    public static String padRight(String s, int n) {
	String sReturn = String.format("%1$-" + n + "s", s);
        return sReturn.substring(0,19);
    }
    
    public boolean ShowAll(){
        boolean bCheck = false;
        if (jcShowAll.isSelected())
            bCheck = true;
        
        return bCheck;
    }
    
    public static void PutData(){
        
        for (int i = 1; i <= 10000; i++)
        {            
            if(EmployeeData [i][1] != null)
            {
                String sBirthDate = "";
                String sHireDate = "";
            
                data = EmployeeData [i][3].split("-");
                sBirthDate = data[2]+data[1]+data[0];
            
                data = EmployeeData [i][13].split("-");
                sHireDate = data[2]+data[1]+data[0];
                
                sSortArray [i-1] = padRight(EmployeeData [i][12], 20) + padRight (EmployeeData [i][2], 20) + padRight (EmployeeData [i][1], 20) + padRight(sBirthDate,20) + padRight(sHireDate,20) + padRight(Integer.toString(i),20);
            }
            else
                break;
        }
    }
    
    public void DisplayData (int iValue){
    	for (int i = 0; i < sSortArray.length; i++)
        {
            sSortArray [i] = sSortArray[i].substring(iValue,114);
        }
        Arrays.sort(sSortArray);
        
        boolean bCheck = ShowAll();
        
        if (bCheck == true)
        {    	
            jtDisplayArea.setText("");
            jtDisplayArea.append(padRight("Last Name",20) + " ");
            jtDisplayArea.append(padRight("First Name",20) + " ");  
            jtDisplayArea.append(padRight("Date Of Birth",20) + " "); 
            jtDisplayArea.append(padRight("Age",20) + " "); 
            if (jcDisplayAddress.isSelected())jtDisplayArea.append(padRight("Address",20) + " "); 
            if (jcDisplayCity.isSelected())jtDisplayArea.append(padRight("City",20) + " "); 
            if (jcDisplayProvince.isSelected())jtDisplayArea.append(padRight("Province",20) + " "); 
            if (jcDisplayPostalCode.isSelected())jtDisplayArea.append(padRight("Postal Code",20) + " "); 
            if (jcDisplaySIN.isSelected())jtDisplayArea.append(padRight("Sin Number",20) + " "); 
            if (jcDisplayHomeNumber.isSelected())jtDisplayArea.append(padRight("Home Phone",20) + " ");
            if (jcDisplayCellNumber.isSelected())jtDisplayArea.append(padRight("Cell Phone",20) + " "); 
            jtDisplayArea.append(padRight("Department Number",20) + " ");
            jtDisplayArea.append(padRight("Hire Date",20) + " "); 
            jtDisplayArea.append(padRight("Termination Date",20) + " "); 
            jtDisplayArea.append(padRight("Years Worked",20) + "\n");
            
            jtDisplayArea.append(padRight("---------",20) + " ");
            jtDisplayArea.append(padRight("----------",20) + " ");  
            jtDisplayArea.append(padRight("-------------",20) + " "); 
            jtDisplayArea.append(padRight("---",20) + " "); 
            if (jcDisplayAddress.isSelected())jtDisplayArea.append(padRight("-------",20) + " ");
            if (jcDisplayCity.isSelected())jtDisplayArea.append(padRight("----",20) + " "); 
            if (jcDisplayProvince.isSelected())jtDisplayArea.append(padRight("--------",20) + " "); 
            if (jcDisplayPostalCode.isSelected())jtDisplayArea.append(padRight("-----------",20) + " "); 
            if (jcDisplaySIN.isSelected())jtDisplayArea.append(padRight("----------",20) + " "); 
            if (jcDisplayHomeNumber.isSelected())jtDisplayArea.append(padRight("----------",20) + " "); 
            if (jcDisplayCellNumber.isSelected())jtDisplayArea.append(padRight("----------",20) + " "); 
            jtDisplayArea.append(padRight("-----------------",20) + " "); 
            jtDisplayArea.append(padRight("---------",20) + " "); 
            jtDisplayArea.append(padRight("----------------",20) + " ");
            jtDisplayArea.append(padRight("------------",20) + "\n");
            for (int i = 1; i <= sSortArray.length; i++)
            {
                String sRecordNumber = sSortArray[i-1].substring(95-iValue,114-iValue).replaceAll("\\s+","");

                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][2]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][1]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][3]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][4]), 20)+ " ");
                if (jcDisplayAddress.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][5]), 20)+ " ");
                if (jcDisplayCity.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][6]), 20)+ " ");
                if (jcDisplayProvince.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][7]), 20)+ " ");
                if (jcDisplayPostalCode.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][8]), 20)+ " ");
                if (jcDisplaySIN.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][9]), 20)+ " ");
                if (jcDisplayHomeNumber.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][10]), 20)+ " ");
                if (jcDisplayCellNumber.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][11]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][12]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][13]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][14]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][15]), 20) + " \n");
            }
        }
        
        if (bCheck == false)
        {
            jtDisplayArea.setText("");
            jtDisplayArea.append(padRight("Last Name",20) + " ");
            jtDisplayArea.append(padRight("First Name",20) + " ");  
            jtDisplayArea.append(padRight("Date Of Birth",20) + " "); 
            jtDisplayArea.append(padRight("Age",20) + " "); 
            if (jcDisplayAddress.isSelected())jtDisplayArea.append(padRight("Address",20) + " "); 
            if (jcDisplayCity.isSelected())jtDisplayArea.append(padRight("City",20) + " "); 
            if (jcDisplayProvince.isSelected())jtDisplayArea.append(padRight("Province",20) + " "); 
            if (jcDisplayPostalCode.isSelected())jtDisplayArea.append(padRight("Postal Code",20) + " "); 
            if (jcDisplaySIN.isSelected())jtDisplayArea.append(padRight("Sin Number",20) + " "); 
            if (jcDisplayHomeNumber.isSelected())jtDisplayArea.append(padRight("Home Phone",20) + " ");
            if (jcDisplayCellNumber.isSelected())jtDisplayArea.append(padRight("Cell Phone",20) + " "); 
            jtDisplayArea.append(padRight("Department Number",20) + " ");
            jtDisplayArea.append(padRight("Hire Date",20) + " "); 
            jtDisplayArea.append(padRight("Years Worked",20) + "\n");
            
            jtDisplayArea.append(padRight("---------",20) + " ");
            jtDisplayArea.append(padRight("----------",20) + " ");  
            jtDisplayArea.append(padRight("-------------",20) + " "); 
            jtDisplayArea.append(padRight("---",20) + " "); 
            if (jcDisplayAddress.isSelected())jtDisplayArea.append(padRight("-------",20) + " ");
            if (jcDisplayCity.isSelected())jtDisplayArea.append(padRight("----",20) + " "); 
            if (jcDisplayProvince.isSelected())jtDisplayArea.append(padRight("--------",20) + " "); 
            if (jcDisplayPostalCode.isSelected())jtDisplayArea.append(padRight("-----------",20) + " "); 
            if (jcDisplaySIN.isSelected())jtDisplayArea.append(padRight("----------",20) + " "); 
            if (jcDisplayHomeNumber.isSelected())jtDisplayArea.append(padRight("----------",20) + " "); 
            if (jcDisplayCellNumber.isSelected())jtDisplayArea.append(padRight("----------",20) + " "); 
            jtDisplayArea.append(padRight("-----------------",20) + " "); 
            jtDisplayArea.append(padRight("---------",20) + " "); 
            jtDisplayArea.append(padRight("------------",20) + "\n");
            
            for (int i = 1; i <= sSortArray.length; i++)
            {
                String sRecordNumber = sSortArray[i-1].substring(95-iValue,114-iValue).replaceAll("\\s+","");

                if (EmployeeData [Integer.parseInt(sRecordNumber)][14].length() == 0)
                {
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][2]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][1]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][3]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][4]), 20)+ " ");
                if (jcDisplayAddress.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][5]), 20)+ " ");
                if (jcDisplayCity.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][6]), 20)+ " ");
                if (jcDisplayProvince.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][7]), 20)+ " ");
                if (jcDisplayPostalCode.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][8]), 20)+ " ");
                if (jcDisplaySIN.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][9]), 20)+ " ");
                if (jcDisplayHomeNumber.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][10]), 20)+ " ");
                if (jcDisplayCellNumber.isSelected())jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][11]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][12]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][13]), 20)+ " ");
                jtDisplayArea.append(padRight((EmployeeData [Integer.parseInt(sRecordNumber)][15]), 20) + " \n");
                }
            } 
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtDisplayArea = new javax.swing.JTextArea();
        jbMainMenu = new javax.swing.JButton();
        jbAlpha = new javax.swing.JButton();
        jbAlphaDep = new javax.swing.JButton();
        jbSenior = new javax.swing.JButton();
        jbAge = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcShowAll = new javax.swing.JCheckBox();
        jcDisplaySIN = new javax.swing.JCheckBox();
        jcDisplayAddress = new javax.swing.JCheckBox();
        jcDisplayCity = new javax.swing.JCheckBox();
        jcDisplayProvince = new javax.swing.JCheckBox();
        jcDisplayPostalCode = new javax.swing.JCheckBox();
        jcDisplayHomeNumber = new javax.swing.JCheckBox();
        jcDisplayCellNumber = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtDisplayArea.setEditable(false);
        jtDisplayArea.setColumns(20);
        jtDisplayArea.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jtDisplayArea.setRows(5);
        jScrollPane1.setViewportView(jtDisplayArea);

        jbMainMenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbMainMenu.setText("Main Menu");
        jbMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMainMenuActionPerformed(evt);
            }
        });

        jbAlpha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAlpha.setText("Alphabetical ");
        jbAlpha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlphaActionPerformed(evt);
            }
        });

        jbAlphaDep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAlphaDep.setText("Alphabetical in Departments ");
        jbAlphaDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlphaDepActionPerformed(evt);
            }
        });

        jbSenior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbSenior.setText("Seniority");
        jbSenior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeniorActionPerformed(evt);
            }
        });

        jbAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAge.setText("Age");
        jbAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Please Select How You Want To Sort The Employee Data");

        jcShowAll.setText("Show The Terminated Employees");

        jcDisplaySIN.setText("Display SIN Number");

        jcDisplayAddress.setText("Display Address");

        jcDisplayCity.setText("Display City");

        jcDisplayProvince.setText("Display Province");

        jcDisplayPostalCode.setText("Display Postal Code ");

        jcDisplayHomeNumber.setText("Display Home Number");

        jcDisplayCellNumber.setText("Display Cell Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcDisplaySIN)
                        .addGap(18, 18, 18)
                        .addComponent(jcDisplayAddress)
                        .addGap(18, 18, 18)
                        .addComponent(jcDisplayCity)
                        .addGap(18, 18, 18)
                        .addComponent(jcDisplayProvince)
                        .addGap(18, 18, 18)
                        .addComponent(jcDisplayPostalCode)
                        .addGap(18, 18, 18)
                        .addComponent(jcDisplayHomeNumber)
                        .addGap(18, 18, 18)
                        .addComponent(jcDisplayCellNumber)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbMainMenu)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcShowAll)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbAlpha, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jbAlphaDep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jbSenior, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jbAge, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMainMenu)
                    .addComponent(jLabel1)
                    .addComponent(jcShowAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAlphaDep)
                    .addComponent(jbAlpha)
                    .addComponent(jbSenior)
                    .addComponent(jbAge))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcDisplaySIN)
                    .addComponent(jcDisplayAddress)
                    .addComponent(jcDisplayCity)
                    .addComponent(jcDisplayProvince)
                    .addComponent(jcDisplayPostalCode)
                    .addComponent(jcDisplayHomeNumber)
                    .addComponent(jcDisplayCellNumber))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMainMenuActionPerformed
        // TODO add your handling code here:
        new StartScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbMainMenuActionPerformed

    private void jbAlphaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlphaActionPerformed
        // TODO add your handling code here:
        PutData();
        DisplayData (19);
    }//GEN-LAST:event_jbAlphaActionPerformed

    private void jbAlphaDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlphaDepActionPerformed
        // TODO add your handling code here:
        PutData();
        DisplayData (0);
    }//GEN-LAST:event_jbAlphaDepActionPerformed

    private void jbSeniorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeniorActionPerformed
        // TODO add your handling code here:
        PutData();
        DisplayData (76);
    }//GEN-LAST:event_jbSeniorActionPerformed

    private void jbAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgeActionPerformed
        // TODO add your handling code here:
        PutData();
        DisplayData (57);
    }//GEN-LAST:event_jbAgeActionPerformed

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
            java.util.logging.Logger.getLogger(ListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAge;
    private javax.swing.JButton jbAlpha;
    private javax.swing.JButton jbAlphaDep;
    private javax.swing.JButton jbMainMenu;
    private javax.swing.JButton jbSenior;
    private javax.swing.JCheckBox jcDisplayAddress;
    private javax.swing.JCheckBox jcDisplayCellNumber;
    private javax.swing.JCheckBox jcDisplayCity;
    private javax.swing.JCheckBox jcDisplayHomeNumber;
    private javax.swing.JCheckBox jcDisplayPostalCode;
    private javax.swing.JCheckBox jcDisplayProvince;
    private javax.swing.JCheckBox jcDisplaySIN;
    private javax.swing.JCheckBox jcShowAll;
    private javax.swing.JTextArea jtDisplayArea;
    // End of variables declaration//GEN-END:variables
}
