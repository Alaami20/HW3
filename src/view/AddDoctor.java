package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import control.Hospital;
import enums.Specialization;
import model.Doctor;
import model.IntensiveCareDoctor;
import model.IntensiveCareNurse;
import model.Nurse;

import javax.swing.JRadioButton;

public class AddDoctor extends JInternalFrame {

    private static final long serialVersionUID = 17L;
    private JTextField id;
    private JTextField firstName;
    private JTextField lastName;
    private JSpinner birthDate;
    private JSpinner workStartDate;
    private JTextField address;
    private JTextField phoneNumber;
    private JTextField email;
    private JTextField salary;
    private JTextField licenseNumber;
    private JComboBox specialization;
    private JTextField password;
    private JRadioButton male, female, yes, no, intensiveCareNurse;
    private ButtonGroup genderGroup, internshipGroup;
    private JLabel lblSpecialization, lblHasFinishedInternship, lblPassword;
    private JLabel lblTitle;

    private JButton addDoctor;
    private JButton addNurse;
    private JLabel lblNewLabel_11;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddDoctor frame = new AddDoctor();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public AddDoctor() {
        setTitle("Add StaffMember");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(36, 120, 32, 29);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("First Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(36, 160, 74, 23);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Last Name:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(36, 200, 72, 23);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Date Birth:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(36, 240, 65, 22);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Adress:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(36, 280, 49, 23);
        getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Phone Number:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(36, 320, 92, 23);
        getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Email:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(36, 360, 42, 22);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Gender:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_7.setBounds(36, 400, 49, 22);
        getContentPane().add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Work Start Date:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_8.setBounds(36, 440, 101, 22);
        getContentPane().add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Salary:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_9.setBounds(263, 120, 49, 29);
        getContentPane().add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("License Number:");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_10.setBounds(263, 160, 101, 23);
        getContentPane().add(lblNewLabel_10);
        
        lblHasFinishedInternship = new JLabel("Has Finished Intership:");
        lblHasFinishedInternship.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblHasFinishedInternship.setBounds(263, 200, 143, 22);
        getContentPane().add(lblHasFinishedInternship);
        
        lblSpecialization = new JLabel("Specialization:");
        lblSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSpecialization.setBounds(263, 240, 92, 22);
        getContentPane().add(lblSpecialization);
        
        lblTitle = new JLabel("Here you can add doctor...");
        lblTitle.setForeground(new Color(0, 64, 64));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(162, 35, 231, 35);
        getContentPane().add(lblTitle);
        
        addDoctor = new JButton("");
        addDoctor.setIcon(new ImageIcon(AddDoctor.class.getResource("/pics/icons8-doctor-64.png")));
        addDoctor.setBounds(313, 339, 80, 105);
        getContentPane().add(addDoctor);
        
        id = new JTextField();
        id.setBounds(61, 125, 96, 20);
        getContentPane().add(id);
        id.setColumns(10);
        
        firstName = new JTextField();
        firstName.setBounds(107, 162, 96, 20);
        getContentPane().add(firstName);
        firstName.setColumns(10);
        
        lastName = new JTextField();
        lastName.setBounds(107, 202, 96, 20);
        getContentPane().add(lastName);
        lastName.setColumns(10);
        
        SpinnerDateModel birthDateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        birthDate = new JSpinner(birthDateModel);
        birthDate.setBounds(111, 241, 92, 22);
        JSpinner.DateEditor de_birthDate = new JSpinner.DateEditor(birthDate, "dd/MM/yyyy");
        birthDate.setEditor(de_birthDate);
        getContentPane().add(birthDate);

        // Adding JSpinner for Work Start Date
        SpinnerDateModel workStartDateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        workStartDate = new JSpinner(workStartDateModel);
        workStartDate.setBounds(149, 441, 80, 22);
        JSpinner.DateEditor de_workStartDate = new JSpinner.DateEditor(workStartDate, "dd/MM/yyyy");
        workStartDate.setEditor(de_workStartDate);
        getContentPane().add(workStartDate);
        
        address = new JTextField();
        address.setBounds(88, 282, 96, 20);
        getContentPane().add(address);
        address.setColumns(10);
        
        phoneNumber = new JTextField();
        phoneNumber.setBounds(133, 322, 96, 20);
        getContentPane().add(phoneNumber);
        phoneNumber.setColumns(10);
        
        email = new JTextField();
        email.setBounds(81, 362, 96, 20);
        getContentPane().add(email);
        email.setColumns(10);
        
        salary = new JTextField();
        salary.setBounds(310, 125, 96, 20);
        getContentPane().add(salary);
        salary.setColumns(10);
        
        licenseNumber = new JTextField();
        licenseNumber.setBounds(369, 162, 96, 20);
        getContentPane().add(licenseNumber);
        licenseNumber.setColumns(10);
        
        specialization = new JComboBox<String>();
        specialization.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	String[] specializations = {"Neurology", "Other", "Cardiology", "Otolaryngology",
    			"Orthopedics", "Surgery", "Ophthalmology", 
    			"Pulmonology", "IntensiveCare"};
    	for (String specializationn : specializations) {
    		specialization.addItem(specializationn);
    	}
    	specialization.setBounds(356, 242, 96, 20);
    	getContentPane().add(specialization);
    	
    	lblPassword = new JLabel("Password:");
    	lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
    	lblPassword.setBounds(263, 280, 74, 19);
    	getContentPane().add(lblPassword);
    	
    	password = new JTextField();
    	password.setBounds(330, 282, 96, 20);
    	getContentPane().add(password);
    	password.setColumns(10);
    	
    	male = new JRadioButton("Male");
    	male.setFont(new Font("Tahoma", Font.PLAIN, 13));
    	male.setBounds(88, 400, 58, 23);
    	getContentPane().add(male);
    	
    	female = new JRadioButton("Female");
    	female.setFont(new Font("Tahoma", Font.PLAIN, 13));
    	female.setBounds(143, 400, 72, 23);
    	getContentPane().add(female);
    	
    	genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
    	
    	yes = new JRadioButton("Yes");
    	yes.setFont(new Font("Tahoma", Font.PLAIN, 13));
    	yes.setBounds(405, 200, 49, 23);
    	getContentPane().add(yes);
    	
    	no = new JRadioButton("No");
    	no.setFont(new Font("Tahoma", Font.PLAIN, 13));
    	no.setBounds(453, 200, 42, 23);
    	getContentPane().add(no);
    	
    	internshipGroup = new ButtonGroup();
        internshipGroup.add(yes);
        internshipGroup.add(no);
        
        addNurse = new JButton("");
        addNurse.setIcon(new ImageIcon(AddDoctor.class.getResource("/pics/icons8-nurse-64.png")));
        addNurse.setBounds(313, 291, 80, 105);
        getContentPane().add(addNurse);
        
        addNurse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Check that one gender option is selected
                    if (genderGroup.getSelection() == null) {
                        JOptionPane.showMessageDialog(null, "Please select a gender.");
                        return; // Stop further processing
                    }

                    // Collecting data from the form
                    int nurseId = Integer.parseInt(id.getText());
                    String nurseFirstName = firstName.getText();
                    String nurseLastName = lastName.getText();
                    Date nurseBirthDate = (Date) birthDate.getValue();
                    String nurseAddress = address.getText();
                    String nursePhoneNumber = phoneNumber.getText();
                    String nurseEmail = email.getText();
                    String nurseGender = male.isSelected() ? "Male" : "Female";
                    Date nurseWorkStartDate = (Date) workStartDate.getValue();
                    double nurseSalary = Double.parseDouble(salary.getText());
                    String nursePassword = password.getText();
                    int nurseLicenseNumber = Integer.parseInt(licenseNumber.getText());

                    // Reference to Hospital instance
                    Hospital hospital = Hospital.getInstance();

                    if (intensiveCareNurse.isSelected()) {
                        // Create an IntensiveCareNurse object
                        IntensiveCareNurse newNurse = new IntensiveCareNurse(nurseId, nurseFirstName, nurseLastName, nurseBirthDate, nurseAddress, nursePhoneNumber,
                                nurseEmail, nurseGender, nurseWorkStartDate, nurseSalary, nursePassword, nurseLicenseNumber);

                        // Add the IntensiveCareNurse to the Hospital
                        if (hospital.addIntensiveCareNurse(newNurse)) {
                            JOptionPane.showMessageDialog(null, "Intensive Care Nurse added successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add Intensive Care Nurse.");
                        }
                    } else {
                        // Create a general Nurse object
                        Nurse newNurse = new Nurse(nurseId, nurseFirstName, nurseLastName, nurseBirthDate, nurseAddress, nursePhoneNumber,
                                nurseEmail, nurseGender, nurseWorkStartDate, nurseSalary, nursePassword, nurseLicenseNumber);

                        // Add the Nurse to the Hospital
                        if (hospital.addNurse(newNurse)) {
                            JOptionPane.showMessageDialog(null, "Nurse added successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add Nurse.");
                        }
                    }

                    // Save the Hospital state after adding a nurse
                    Main.save();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error adding nurse: " + ex.getMessage());
                }
            }
        });

        
        intensiveCareNurse = new JRadioButton("Intensive Care Nurse");
        intensiveCareNurse.setFont(new Font("Tahoma", Font.PLAIN, 13));
        intensiveCareNurse.setBounds(263, 200, 157, 23);
        getContentPane().add(intensiveCareNurse);
        
        lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setIcon(new ImageIcon(AddDoctor.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel_11.setBounds(0, 0, 593, 541);
        getContentPane().add(lblNewLabel_11);
        
        addDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Check that one gender option is selected
                    if (genderGroup.getSelection() == null) {
                        JOptionPane.showMessageDialog(null, "Please select a gender.");
                        return; // Stop further processing
                    }

                    // Check that one internship status option is selected
                    if (internshipGroup.getSelection() == null) {
                        JOptionPane.showMessageDialog(null, "Please select if the doctor has finished the internship.");
                        return; // Stop further processing
                    }

                    // Collecting data from the form
                    int doctorId = Integer.parseInt(id.getText());
                    String doctorFirstName = firstName.getText();
                    String doctorLastName = lastName.getText();
                    Date doctorBirthDate = (Date) birthDate.getValue();
                    String doctorAddress = address.getText();
                    String doctorPhoneNumber = phoneNumber.getText();
                    String doctorEmail = email.getText();
                    String doctorGender = male.isSelected() ? "Male" : "Female";
                    Date doctorWorkStartDate = (Date) workStartDate.getValue();
                    double doctorSalary = Double.parseDouble(salary.getText());
                    String doctorPassword = password.getText();
                    int doctorLicenseNumber = Integer.parseInt(licenseNumber.getText());
                    boolean doctorIsFinishInternship = yes.isSelected();
                    String doctorSpecialization = (String) specialization.getSelectedItem();

                    // Reference to Hospital instance
                    Hospital hospital = Hospital.getInstance();

                    // Check if specialization is "IntensiveCare"
                    if (doctorSpecialization.equals("IntensiveCare")) {
                        // Create an IntensiveCareDoctor object
                        IntensiveCareDoctor newDoctor = new IntensiveCareDoctor(doctorId, doctorFirstName, doctorLastName, doctorBirthDate, doctorAddress, doctorPhoneNumber,
                                doctorEmail, doctorGender, doctorWorkStartDate, doctorSalary, doctorPassword, doctorLicenseNumber, doctorIsFinishInternship);

                        // Add the IntensiveCareDoctor to the Hospital
                        if (hospital.addIntensiveCareDoctor(newDoctor)) {
                            JOptionPane.showMessageDialog(null, "Intensive Care Doctor added successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add Intensive Care Doctor.");
                        }

                    } else {
                        // Create a general Doctor object for other specializations
                        Specialization specEnum = Specialization.valueOf(doctorSpecialization);
                        Doctor newDoctor = new Doctor(doctorId, doctorFirstName, doctorLastName, doctorBirthDate, doctorAddress, doctorPhoneNumber,
                                doctorEmail, doctorGender, doctorWorkStartDate, doctorSalary, doctorPassword, doctorLicenseNumber, doctorIsFinishInternship, specEnum);

                        // Add the Doctor to the Hospital
                        if (hospital.addDoctor(newDoctor)) {
                            JOptionPane.showMessageDialog(null, "Doctor added successfully!");
                            hospital.printAllStaffMembers();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add Doctor.");
                        }
                    }

                    // Save the Hospital state after adding a doctor
                    Main.save();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error adding doctor: " + ex.getMessage());
                }
            }
        });

        
    }
    
    public void updateTitle(String role) {
        lblTitle.setText("Here you can add " + role + "...");
    }
    
    public void showDoctorFields() {
        lblHasFinishedInternship.setVisible(true);
        lblSpecialization.setVisible(true);
        yes.setVisible(true);
        no.setVisible(true);
        specialization.setVisible(true);
        addNurse.setVisible(false);
        addDoctor.setVisible(true);
        intensiveCareNurse.setVisible(false);

        // Move password field back to its original position
        lblPassword.setBounds(263, 280, 74, 19);
        password.setBounds(330, 280, 96, 20);
        
        updateTitle("doctor");
    }

    public void showNurseFields() {
        lblHasFinishedInternship.setVisible(false);
        lblSpecialization.setVisible(false);
        yes.setVisible(false);
        no.setVisible(false);
        specialization.setVisible(false);
        addDoctor.setVisible(false);
        addNurse.setVisible(true);
        intensiveCareNurse.setVisible(true);


        // Move password field to the location of "Has Finished Internship"
        lblPassword.setBounds(263, 240, 74, 19);
        password.setBounds(330, 240, 96, 20);
        
        updateTitle("nurse");
    }
}

    
