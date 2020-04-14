package FINALPROJECT;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rammy
 */
public class EditPage extends javax.swing.JFrame {
    
    private static String[][] EmployeeData = new String [10000][16];
    private static int iRecordNumber = 0;
    private static PrintWriter out = null;
    private static int iYearsWorked = 0;
    private static int iAge = 0;
    private static String[] data;
    private static String[] hire;
    private static String[] termination;
    private static boolean bTest = false;
    private static boolean bCheckInfo;

    /**
     * Creates new form EditPage
     */
    public EditPage() {
        initComponents();
        jbYES.setVisible(false);
        jbNO.setVisible(false);
        jlAreYouSure.setVisible(false);
        MySettings(false);
    }
    
    public EditPage (String [][] sGetData){
        initComponents();
        jbYES.setVisible(false);
        jbNO.setVisible(false);
        jlAreYouSure.setVisible(false);
        EmployeeData = sGetData;
        MySettings(false);
    }
    
     public void MySettings (boolean bValue)
    {
        jfFirstName.setVisible(bValue); 
        jfLastName.setVisible(bValue); 
        jfDateOfBirth.setVisible(bValue); 
        jfStreetAddress.setVisible(bValue); 
        jfCity.setVisible(bValue); 
        jcProvince.setVisible(bValue);
        jfPostalCode.setVisible(bValue); 
        jfSIN.setVisible(bValue); 
        jfHomePhone.setVisible(bValue); 
        jfCellPhone.setVisible(bValue); 
        jsDepartmentNumber.setVisible(bValue); 
        jfHireDate.setVisible(bValue); 
        jfTerminationDate.setVisible(bValue); 
        
        jlFirstName.setVisible(bValue); 
        jlLastName.setVisible(bValue); 
        jlDateOfBirth.setVisible(bValue); 
        jlStreetAddress.setVisible(bValue); 
        jlCity.setVisible(bValue); 
        jlProvince.setVisible(bValue); 
        jlPostalCode.setVisible(bValue); 
        jlSIN.setVisible(bValue); 
        jlHomePhone.setVisible(bValue); 
        jlCellPhone.setVisible(bValue); 
        jlDepartmentNumber.setVisible(bValue); 
        jlHireDate.setVisible(bValue); 
        jlTerminationDate.setVisible(bValue); 
        
        jbSave.setVisible(bValue);
        jbRemove.setVisible(bValue);
        jbPrevious.setVisible(bValue);
        jbNext.setVisible(bValue);
    }
     
     public static int Calculate (String sValue)
    {
        int iNumber = 0;
        if (sValue.length() == 0)
            JOptionPane.showMessageDialog(null,"There was a problem with one of the dates. Please enter again.");
        else
        {
        int iYear = 0, iMonth = 0, iDay = 0;
	String sYear = "", sMonth = "", sDay = "";
        data = sValue.split("-");
	sYear = data[2];
	iYear = Integer.parseInt (sYear);      

	sMonth = data[1];
	iMonth = Integer.parseInt (sMonth);
            
	sDay = data[0];
	iDay = Integer.parseInt (sDay);
					
	int iYear2 = iYear % 100;
            
	Calendar now = Calendar.getInstance();
	Calendar dob = Calendar.getInstance();
	Date date = new Date(iYear2, iMonth, iDay);
	dob.setTime(date);
	if (iYear >= now.get(Calendar.YEAR)) 
	{
            if (iMonth >= now.get(Calendar.MONTH))
            {
		if (iDay > now.get(Calendar.DAY_OF_MONTH))
		{
                    JOptionPane.showMessageDialog(null,"There was a problem with one of the dates. Please enter again.");
		}
                else if (iDay == now.get(Calendar.DAY_OF_MONTH))
                {
                    JOptionPane.showMessageDialog(null,"There was a problem with one of the dates. Please enter again.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"There was a problem with one of the dates. Please enter again");
                }
            }
            else
            {
		JOptionPane.showMessageDialog(null,"There was a problem with one of the dates. Please enter again.");
            }
	}
	else
        {
            int year1 = now.get(Calendar.YEAR);
            int year2 = dob.get(Calendar.YEAR);
            iNumber = year1 - year2;
            int month1 = now.get(Calendar.MONTH);
            int month2 = dob.get(Calendar.MONTH);
            if (month2 > month1) 
            {
		iNumber--;
            } 
            else if (month1 == month2) 
            {
		int day1 = now.get(Calendar.DAY_OF_MONTH);
		int day2 = dob.get(Calendar.DAY_OF_MONTH);
		if (day2 > day1) 
                {
                    iNumber--;
		}
            }
            if (iYear>=2000)
            {
		iNumber -= 100;
            }  
	}
         
        }
        return iNumber;
    }
     
     public boolean CheckSin()
    {
        boolean bCheck;
        int theSIN = Integer.parseInt(jfSIN.getText());

            boolean evenDigit = false; //alternates between true and false
            int sum = 0; //accumulates the sum of the digits (as modified)

            while (theSIN > 0) {
                int nextDigit = theSIN % 10; //grab the last digit
                theSIN = theSIN / 10; //discard that digit
                if(evenDigit) {
                    //double it, then add the two digits of the result
                    nextDigit = 2*nextDigit;
                    nextDigit = (nextDigit/10)+(nextDigit%10);
                    } // if(evenDigit)
                sum = sum + nextDigit;
                evenDigit = !evenDigit; //toggle the flag each time
            } // end while

            if (0 == sum % 10)
                bCheck = true;
            else
                bCheck = false;
            
            return bCheck;
    }
    
    public String normalizeZipCode(String incoming) 
    {
        return incoming.replaceAll("\\s+","");
    }
    
    public boolean CheckPostalCode()
    {
        boolean bCheck;
        String line = normalizeZipCode(jfPostalCode.getText());
	String pattern = "[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]";

	// Create a Pattern object
	Pattern r = Pattern.compile(pattern);

	// Now create matcher object.
	Matcher m = r.matcher(line);
	if (m.find( )) {
	    bCheck = true;
	}else {
	    bCheck = false;
	}
        return bCheck;        
    }
    
    public boolean CheckPhoneNumbers(String sNumber)
    {
        boolean bCheck;
        String line = normalizeZipCode(sNumber);
	String pattern = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$" ;

	// Create a Pattern object
	Pattern r = Pattern.compile(pattern);

	// Now create matcher object.
	Matcher m = r.matcher(line);
	if (m.find( )) {
	    bCheck = true;
	}else {
	    bCheck = false;
	}
        return bCheck;        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfFirstName = new javax.swing.JTextField();
        jfLastName = new javax.swing.JTextField();
        jfStreetAddress = new javax.swing.JTextField();
        jfCity = new javax.swing.JTextField();
        jfPostalCode = new javax.swing.JTextField();
        jfSIN = new javax.swing.JTextField();
        jfHomePhone = new javax.swing.JTextField();
        jfCellPhone = new javax.swing.JTextField();
        jfDateOfBirth = new javax.swing.JTextField();
        jlStreetAddress = new javax.swing.JLabel();
        jfHireDate = new javax.swing.JTextField();
        jlCity = new javax.swing.JLabel();
        jfTerminationDate = new javax.swing.JTextField();
        jlProvince = new javax.swing.JLabel();
        jsDepartmentNumber = new javax.swing.JSpinner();
        jlPostalCode = new javax.swing.JLabel();
        jbSave = new javax.swing.JButton();
        jlSIN = new javax.swing.JLabel();
        jlHomePhone = new javax.swing.JLabel();
        jlCellPhone = new javax.swing.JLabel();
        jlDateOfBirth = new javax.swing.JLabel();
        jlHireDate = new javax.swing.JLabel();
        jlTerminationDate = new javax.swing.JLabel();
        jbMainMenu = new javax.swing.JButton();
        jlFirstName = new javax.swing.JLabel();
        jlLastName = new javax.swing.JLabel();
        jlDepartmentNumber = new javax.swing.JLabel();
        jlPleaseEnter = new javax.swing.JLabel();
        jfSearch = new javax.swing.JTextField();
        jbPrevious = new javax.swing.JButton();
        jbNext = new javax.swing.JButton();
        jbSearch = new javax.swing.JButton();
        jcProvince = new javax.swing.JComboBox<>();
        jbRemove = new javax.swing.JButton();
        jlAreYouSure = new javax.swing.JLabel();
        jbYES = new javax.swing.JButton();
        jbNO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jfFirstName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jfLastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jfStreetAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jfCity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jfPostalCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jfSIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jfHomePhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jfCellPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jfDateOfBirth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlStreetAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlStreetAddress.setText("Street Address: ");

        jfHireDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlCity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlCity.setText("City: ");

        jfTerminationDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlProvince.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlProvince.setText("Province: ");

        jsDepartmentNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jsDepartmentNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        jsDepartmentNumber.setToolTipText("");

        jlPostalCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlPostalCode.setText("Postal Code: ");

        jbSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbSave.setText("Save");
        jbSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveActionPerformed(evt);
            }
        });

        jlSIN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlSIN.setText("Social Insurance Number: ");

        jlHomePhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlHomePhone.setText("Home Phone Number: ");

        jlCellPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlCellPhone.setText("Cell Phone Number: ");

        jlDateOfBirth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlDateOfBirth.setText("Date Of Birth (dd-mm-yyyy): ");

        jlHireDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlHireDate.setText("Hire Date (dd-mm-yyyy): ");

        jlTerminationDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlTerminationDate.setText("Termination Date (dd-mm-yyyy): ");

        jbMainMenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbMainMenu.setText("Main Menu");
        jbMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMainMenuActionPerformed(evt);
            }
        });

        jlFirstName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlFirstName.setText("First Name: ");

        jlLastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlLastName.setText("Last Name: ");

        jlDepartmentNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlDepartmentNumber.setText("Department Number: ");

        jlPleaseEnter.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlPleaseEnter.setText("Please Enter Employees Last Name or SIN Number: ");

        jfSearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfSearchActionPerformed(evt);
            }
        });

        jbPrevious.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbPrevious.setText("Previous");
        jbPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPreviousActionPerformed(evt);
            }
        });

        jbNext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbNext.setText("Next");
        jbNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNextActionPerformed(evt);
            }
        });

        jbSearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbSearch.setText("Search");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jcProvince.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon" }));

        jbRemove.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbRemove.setText("Remove Employee");
        jbRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveActionPerformed(evt);
            }
        });

        jlAreYouSure.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlAreYouSure.setText("Are You Sure You Wish To Remove this Employee?");

        jbYES.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbYES.setText("YES");
        jbYES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbYESActionPerformed(evt);
            }
        });

        jbNO.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbNO.setText("NO");
        jbNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jbMainMenu)
                        .addGap(176, 176, 176)
                        .addComponent(jbPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jbNext, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlPleaseEnter)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlLastName)
                                .addComponent(jlFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jlAreYouSure)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlStreetAddress))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jbYES, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jbNO, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlCity))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlProvince)
                                            .addComponent(jlSIN)
                                            .addComponent(jlHomePhone)
                                            .addComponent(jlCellPhone)
                                            .addComponent(jlDateOfBirth)
                                            .addComponent(jlHireDate)
                                            .addComponent(jlTerminationDate)
                                            .addComponent(jlDepartmentNumber)
                                            .addComponent(jbSave)
                                            .addComponent(jlPostalCode))))
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jsDepartmentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jfLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfStreetAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfPostalCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfSIN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfHomePhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfCellPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfDateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfHireDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfTerminationDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jcProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbRemove))))))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMainMenu)
                    .addComponent(jbPrevious)
                    .addComponent(jbNext)
                    .addComponent(jbSearch))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPleaseEnter)
                    .addComponent(jfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFirstName)
                    .addComponent(jfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLastName)
                    .addComponent(jfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlStreetAddress)
                    .addComponent(jfStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlAreYouSure))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCity)
                    .addComponent(jfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbYES)
                    .addComponent(jbNO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlProvince)
                    .addComponent(jcProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPostalCode)
                    .addComponent(jfPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSIN)
                    .addComponent(jfSIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHomePhone)
                    .addComponent(jfHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCellPhone)
                    .addComponent(jfCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDateOfBirth)
                    .addComponent(jfDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHireDate)
                    .addComponent(jfHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTerminationDate)
                    .addComponent(jfTerminationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDepartmentNumber)
                    .addComponent(jsDepartmentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSave)
                    .addComponent(jbRemove))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
        // TODO add your handling code here:
        
        //Calculate Age
        iAge = Calculate(jfDateOfBirth.getText());
        
        //Calculate Years Worked
        if (jfHireDate.getText().length() != 0 && jfTerminationDate.getText().length() != 0)
        {
            //Hire Date
            int iHireYear = 0, iHireMonth = 0, iHireDay = 0;
            String sHireYear = "", sHireMonth = "", sHireDay = "";
            hire = jfHireDate.getText().split("-");
            sHireYear = hire[2];
            iHireYear = Integer.parseInt (sHireYear);      

            sHireMonth = hire[1];
            iHireMonth = Integer.parseInt (sHireMonth);
            
            sHireDay = hire[0];
            iHireDay = Integer.parseInt (sHireDay);
					
            int iHireYear2 = iHireYear % 100;
            
            //Termination date
            int iTermYear = 0, iTermMonth = 0, iTermDay = 0;
            String sTermYear = "", sTermMonth = "", sTermDay = "";
            termination = jfTerminationDate.getText().split("-");
            sTermYear = termination[2];
            iTermYear = Integer.parseInt (sTermYear);      

            sTermMonth = termination[1];
            iTermMonth = Integer.parseInt (sTermMonth);
            
            sTermDay = termination[0];
            iTermDay = Integer.parseInt (sTermDay);
					
            int iTermYear2 = iTermYear % 100;
            
            //Calcualtions
            Calendar terminationdate = Calendar.getInstance();
            Calendar hiredate = Calendar.getInstance();
            Date dateofhire = new Date(iHireYear2, iHireMonth, iHireDay);
            Date dateoftermination = new Date(iTermYear2, iTermMonth, iTermDay);
            hiredate.setTime(dateofhire);
            terminationdate.setTime(dateoftermination);
            if (iHireYear >= iTermYear) 
            {
                if (iHireMonth >= iTermMonth)
                {
                    if (iHireDay > iTermDay)
                    {
                        JOptionPane.showMessageDialog(null,"Employee can't be fired before being hired.");
                    }
                    else if (iHireDay == iTermDay)
                    {
                        JOptionPane.showMessageDialog(null,"Employee can't be hired and fired on the same day.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Employee can't be fired before being hired.");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Employee can't be fired before being hired.");
                }
            }   
            else
            {
                int year1 = iTermYear;
                int year2 = iHireYear;
                iYearsWorked = year1 - year2;
                int month1 = iTermMonth;
                int month2 = iHireMonth;
                if (month2 > month1) 
                {
                    iYearsWorked--;
                } 
                else if (month1 == month2) 
                {
                    int day1 = iTermDay;
                    int day2 = iHireDay;
                    if (day2 > day1) 
                    {
                        iYearsWorked--;
                    }
                }
                
                if (iYearsWorked<0)
                    iYearsWorked *= -1;
            }
        }
        
        if (jfTerminationDate.getText().length() == 0)
            iYearsWorked = Calculate(jfHireDate.getText());
        
        //See if information is missing
        if (jfCellPhone.getText().length() == 0 || jfCity.getText().length() == 0 || jfDateOfBirth.getText().length() == 0 || jfFirstName.getText().length() == 0 || jfHireDate.getText().length() == 0 || jfHomePhone.getText().length() == 0 || jfLastName.getText().length() == 0 || jfPostalCode.getText().length() == 0 || jfSIN.getText().length() == 0 || jfStreetAddress.getText().length() == 0 )
        {
            JOptionPane.showMessageDialog(null,"Missing Information. Please Make Sure All Entries Have Been Filled");
        }
        
        //Check SIN number
        if ((bCheckInfo=CheckSin()) == false)
            JOptionPane.showMessageDialog(null,"Invalid SIN number. Please enter again");
        
        //Check Postal Code
        if ((bCheckInfo=CheckPostalCode()) == false)
            JOptionPane.showMessageDialog(null,"Invalid Postal Code. Please enter again");
        
        //Check Home Phone
        if ((bCheckInfo=CheckPhoneNumbers(jfHomePhone.getText())) == false)
            JOptionPane.showMessageDialog(null,"Invalid Home Phone Number. Please enter again");
        
        //Check Cell Phone
        if ((bCheckInfo=CheckPhoneNumbers(jfCellPhone.getText())) == false)
            JOptionPane.showMessageDialog(null,"Invalid Cell Phone Number. Please enter again");
        
        //If all information has been met, print into file
        else
        {            
            File file = new File("D:\\School\\High School\\Grade 12\\Employee\\Mock-Employee-Database\\FINAL PROJECT\\src\\FINALPROJECT\\EmployeeData.txt");
            try 
            {
                    out = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(file)), true);
            }
            catch (IOException e)
            {
		JOptionPane.showMessageDialog(null,"The file cannot be created!  Error Number - " + e);
            }
            
            EmployeeData [iRecordNumber][1] = jfFirstName.getText();
            EmployeeData [iRecordNumber][2] = jfLastName.getText();
            EmployeeData [iRecordNumber][3] = jfDateOfBirth.getText();
            EmployeeData [iRecordNumber][4] = Integer.toString(iAge);
            EmployeeData [iRecordNumber][5] = jfStreetAddress.getText();
            EmployeeData [iRecordNumber][6] = jfCity.getText();
            EmployeeData [iRecordNumber][7] = (String) jcProvince.getSelectedItem();
            EmployeeData [iRecordNumber][8] = jfPostalCode.getText();
            EmployeeData [iRecordNumber][9] = jfSIN.getText();
            EmployeeData [iRecordNumber][10] = jfHomePhone.getText();
            EmployeeData [iRecordNumber][11] = jfCellPhone.getText();
            EmployeeData [iRecordNumber][12] = Integer.toString((int) jsDepartmentNumber.getValue());
            EmployeeData [iRecordNumber][13] = jfHireDate.getText();
            EmployeeData [iRecordNumber][14] = jfTerminationDate.getText();
            EmployeeData [iRecordNumber][15] = Integer.toString(iYearsWorked);
   
            for (int i = 1; i <= 10000; i++)
            {
                if (EmployeeData[i][1] == null)
                    break;
                else
                {
                    out.print(EmployeeData[i][1]);
                    for (int j = 2; j <= 15; j++)
                    {
                        out.print(","+EmployeeData[i][j]);
                    }
                    out.println();
                }
            }
        }
        
    }//GEN-LAST:event_jbSaveActionPerformed

    private void jfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfSearchActionPerformed

    }//GEN-LAST:event_jfSearchActionPerformed

    private void jbMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMainMenuActionPerformed
        // TODO add your handling code here:
        new StartScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbMainMenuActionPerformed

    private void jbPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPreviousActionPerformed
        // TODO add your handling code here:
        
        if (iRecordNumber == 1)
            JOptionPane.showMessageDialog(null,"You are already at the beginning of the file.");
        else
        {
            iRecordNumber --;
        
            if (iRecordNumber >= 1)
            {
                jfFirstName.setText(EmployeeData [iRecordNumber][1]);
                jfLastName.setText(EmployeeData [iRecordNumber][2]);
                jfDateOfBirth.setText(EmployeeData [iRecordNumber][3]);
                jfStreetAddress.setText(EmployeeData [iRecordNumber][5]);
                jfCity.setText(EmployeeData [iRecordNumber][6]);
                jcProvince.setSelectedItem(EmployeeData [iRecordNumber][7]);
                jfPostalCode.setText(EmployeeData [iRecordNumber][8]);
                jfSIN.setText(EmployeeData [iRecordNumber][9]);
                jfHomePhone.setText(EmployeeData [iRecordNumber][10]);
                jfCellPhone.setText(EmployeeData [iRecordNumber][11]);
                jsDepartmentNumber.setValue(Integer.parseInt(EmployeeData [iRecordNumber][12]));
                jfHireDate.setText(EmployeeData [iRecordNumber][13]);
                jfTerminationDate.setText(EmployeeData [iRecordNumber][14]);
            }
        
            if (iRecordNumber == 1)
                JOptionPane.showMessageDialog(null,"You are at the beginning of the file.");
        }
    }//GEN-LAST:event_jbPreviousActionPerformed

    private void jbNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNextActionPerformed
        // TODO add your handling code here:
        
        if(EmployeeData [iRecordNumber][1] == null)
        {
            if(iRecordNumber==0)
                iRecordNumber = 2;
            else
                JOptionPane.showMessageDialog(null,"You are already at the end of the file.");
        }
        
        if(EmployeeData [iRecordNumber+1][1] == null)
            JOptionPane.showMessageDialog(null,"You at the end of the file.");
        
        else
        {
            iRecordNumber ++;
            if (EmployeeData [iRecordNumber][1] != null)
            {
                jfFirstName.setText(EmployeeData [iRecordNumber][1]);
                jfLastName.setText(EmployeeData [iRecordNumber][2]);
                jfDateOfBirth.setText(EmployeeData [iRecordNumber][3]);
                jfStreetAddress.setText(EmployeeData [iRecordNumber][5]);
                jfCity.setText(EmployeeData [iRecordNumber][6]);
                jcProvince.setSelectedItem(EmployeeData [iRecordNumber][7]);
                jfPostalCode.setText(EmployeeData [iRecordNumber][8]);
                jfSIN.setText(EmployeeData [iRecordNumber][9]);
                jfHomePhone.setText(EmployeeData [iRecordNumber][10]);
                jfCellPhone.setText(EmployeeData [iRecordNumber][11]);
                jsDepartmentNumber.setValue(Integer.parseInt(EmployeeData [iRecordNumber][12]));
                jfHireDate.setText(EmployeeData [iRecordNumber][13]);
                jfTerminationDate.setText(EmployeeData [iRecordNumber][14]);
            }
            else
                JOptionPane.showMessageDialog(null,"You are already at the end of the file.");
        }
    }//GEN-LAST:event_jbNextActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        // TODO add your handling code here:
        if (jfSearch.getText().length() == 0)
            JOptionPane.showMessageDialog(null,"Please enter either a last name or a SIN number.");
        
        else
        {
            if (EmployeeData [1][1].length() > 0)
            {
                find:
                for (int i = 1; i < 100000; i++)
                {
                    if (EmployeeData[i][1] == null)
                    {
                        JOptionPane.showMessageDialog(null,"Could not find employee. Please try again");
                        break find;
                    }
                    else
                    {
                        for (int j = 1; j <= 2; j++)
                        {
                            if (jfSearch.getText().equalsIgnoreCase(EmployeeData[i][2]) || jfSearch.getText().equalsIgnoreCase(EmployeeData[i][9]))
                            {
                                iRecordNumber = i;
                                bTest = true;
                                break find;
                            }
                        }
                    }
                }
            
                if (bTest)
                {
                    MySettings (true);
            
                    jfFirstName.setText(EmployeeData [iRecordNumber][1]);
                    jfLastName.setText(EmployeeData [iRecordNumber][2]);
                    jfDateOfBirth.setText(EmployeeData [iRecordNumber][3]);
                    jfStreetAddress.setText(EmployeeData [iRecordNumber][5]);
                    jfCity.setText(EmployeeData [iRecordNumber][6]);
                    jcProvince.setSelectedItem(EmployeeData [iRecordNumber][7]);
                    jfPostalCode.setText(EmployeeData [iRecordNumber][8]);
                    jfSIN.setText(EmployeeData [iRecordNumber][9]);
                    jfHomePhone.setText(EmployeeData [iRecordNumber][10]);
                    jfCellPhone.setText(EmployeeData [iRecordNumber][11]);
                    jsDepartmentNumber.setValue(Integer.parseInt(EmployeeData [iRecordNumber][12]));
                    jfHireDate.setText(EmployeeData [iRecordNumber][13]);
                    jfTerminationDate.setText(EmployeeData [iRecordNumber][14]);
                    jfSearch.setText("");
                }
            }
            else
                JOptionPane.showMessageDialog(null,"Please add employees before searching.");
            
        }
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveActionPerformed
        // TODO add your handling code here:
        jbYES.setVisible(true);
        jbNO.setVisible(true);
        jlAreYouSure.setVisible(true);
        jbSearch.setVisible(false);
        jlPleaseEnter.setVisible(false);
        jfSearch.setVisible(false);
        jbMainMenu.setVisible(false);
        MySettings(false);
    }//GEN-LAST:event_jbRemoveActionPerformed

    private void jbYESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbYESActionPerformed
        // TODO add your handling code here:
        List<String[]> l = new ArrayList<String[]>(Arrays.asList(EmployeeData));

	l.remove(iRecordNumber);
	EmployeeData = l.toArray(new String[][]{});
        
            File file = new File("D:\\School\\High School\\Grade 12\\Employee\\Mock-Employee-Database\\FINAL PROJECT\\src\\FINALPROJECT\\EmployeeData.txt");
            try 
            {
                    out = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(file)), true);
            }
            catch (IOException e)
            {
		JOptionPane.showMessageDialog(null,"The file cannot be created!  Error Number - " + e);
            }
   
            for (int i = 1; i <= 10000; i++)
            {
                if (EmployeeData[i][1] == null)
                    break;
                else
                {
                    out.print(EmployeeData[i][1]);
                    for (int j = 2; j <= 15; j++)
                    {
                        out.print(","+EmployeeData[i][j]);
                    }
                    out.println();
                }
            }
        
        
        jbYES.setVisible(false);
        jbNO.setVisible(false);
        jlAreYouSure.setVisible(false);
        jbSearch.setVisible(true);
        jlPleaseEnter.setVisible(true);
        jfSearch.setVisible(true);
        jbMainMenu.setVisible(true);
        MySettings(true);
        
        if (EmployeeData [iRecordNumber][1] == null)
            iRecordNumber--;
        jfFirstName.setText(EmployeeData [iRecordNumber][1]);
        jfLastName.setText(EmployeeData [iRecordNumber][2]);
        jfDateOfBirth.setText(EmployeeData [iRecordNumber][3]);
        jfStreetAddress.setText(EmployeeData [iRecordNumber][5]);
         jfCity.setText(EmployeeData [iRecordNumber][6]);
        jcProvince.setSelectedItem(EmployeeData [iRecordNumber][7]);
        jfPostalCode.setText(EmployeeData [iRecordNumber][8]);
        jfSIN.setText(EmployeeData [iRecordNumber][9]);
        jfHomePhone.setText(EmployeeData [iRecordNumber][10]);
        jfCellPhone.setText(EmployeeData [iRecordNumber][11]);
        jsDepartmentNumber.setValue(Integer.parseInt(EmployeeData [iRecordNumber][12]));
        jfHireDate.setText(EmployeeData [iRecordNumber][13]);
        jfTerminationDate.setText(EmployeeData [iRecordNumber][14]);
        
    }//GEN-LAST:event_jbYESActionPerformed

    private void jbNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNOActionPerformed
        // TODO add your handling code here:
        jbYES.setVisible(false);
        jbNO.setVisible(false);
        jlAreYouSure.setVisible(false);
        jbSearch.setVisible(true);
        jlPleaseEnter.setVisible(true);
        jfSearch.setVisible(true);
        jbMainMenu.setVisible(true);
        MySettings(true);
    }//GEN-LAST:event_jbNOActionPerformed

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
            java.util.logging.Logger.getLogger(EditPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbMainMenu;
    private javax.swing.JButton jbNO;
    private javax.swing.JButton jbNext;
    private javax.swing.JButton jbPrevious;
    private javax.swing.JButton jbRemove;
    private javax.swing.JButton jbSave;
    private javax.swing.JButton jbSearch;
    private javax.swing.JButton jbYES;
    private javax.swing.JComboBox<String> jcProvince;
    private javax.swing.JTextField jfCellPhone;
    private javax.swing.JTextField jfCity;
    private javax.swing.JTextField jfDateOfBirth;
    private javax.swing.JTextField jfFirstName;
    private javax.swing.JTextField jfHireDate;
    private javax.swing.JTextField jfHomePhone;
    private javax.swing.JTextField jfLastName;
    private javax.swing.JTextField jfPostalCode;
    private javax.swing.JTextField jfSIN;
    private javax.swing.JTextField jfSearch;
    private javax.swing.JTextField jfStreetAddress;
    private javax.swing.JTextField jfTerminationDate;
    private javax.swing.JLabel jlAreYouSure;
    private javax.swing.JLabel jlCellPhone;
    private javax.swing.JLabel jlCity;
    private javax.swing.JLabel jlDateOfBirth;
    private javax.swing.JLabel jlDepartmentNumber;
    private javax.swing.JLabel jlFirstName;
    private javax.swing.JLabel jlHireDate;
    private javax.swing.JLabel jlHomePhone;
    private javax.swing.JLabel jlLastName;
    private javax.swing.JLabel jlPleaseEnter;
    private javax.swing.JLabel jlPostalCode;
    private javax.swing.JLabel jlProvince;
    private javax.swing.JLabel jlSIN;
    private javax.swing.JLabel jlStreetAddress;
    private javax.swing.JLabel jlTerminationDate;
    private javax.swing.JSpinner jsDepartmentNumber;
    // End of variables declaration//GEN-END:variables
}
