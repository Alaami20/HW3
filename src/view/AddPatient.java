package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import control.Hospital;
import enums.BiologicalSex;
import enums.HealthFund;
import model.Patient;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class AddPatient extends JInternalFrame {

	private static final long serialVersionUID = 20L;
	private JTextField id;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField adress;
	private JTextField phoneNumber;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient frame = new AddPatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPatient() {
        
        setTitle("Add Patient");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        
        JLabel lblTitle = new JLabel("Here you can add Patient...");
        lblTitle.setForeground(new Color(0, 64, 64));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(162, 35, 231, 35);
        getContentPane().add(lblTitle);
        
        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(36, 120, 19, 14);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("First Name:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(36, 160, 77, 14);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Last Name:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(36, 200, 77, 14);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Birth Date:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(36, 240, 65, 14);
        getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Adress:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(36, 280, 55, 14);
        getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Phone Number:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(36, 320, 92, 14);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Email:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_7.setBounds(36, 360, 37, 14);
        getContentPane().add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Gender:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_8.setBounds(36, 400, 49, 14);
        getContentPane().add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Health Fund:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_9.setBounds(36, 440, 77, 14);
        getContentPane().add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Biological Sex:");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_10.setBounds(36, 480, 92, 21);
        getContentPane().add(lblNewLabel_10);
        
        id = new JTextField();
        id.setBounds(61, 118, 96, 20);
        getContentPane().add(id);
        id.setColumns(10);
        
        firstName = new JTextField();
        firstName.setBounds(113, 158, 96, 20);
        getContentPane().add(firstName);
        firstName.setColumns(10);
        
        lastName = new JTextField();
        lastName.setBounds(113, 198, 96, 20);
        getContentPane().add(lastName);
        lastName.setColumns(10);
        
        adress = new JTextField();
        adress.setBounds(87, 278, 96, 20);
        getContentPane().add(adress);
        adress.setColumns(10);
        
        phoneNumber = new JTextField();
        phoneNumber.setBounds(130, 318, 96, 20);
        getContentPane().add(phoneNumber);
        phoneNumber.setColumns(10);
        
        email = new JTextField();
        email.setBounds(83, 358, 96, 20);
        getContentPane().add(email);
        email.setColumns(10);
        
        JRadioButton male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma", Font.PLAIN, 13));
        male.setBounds(91, 397, 55, 23);
        getContentPane().add(male);
        
        JRadioButton Female = new JRadioButton("Female");
        Female.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Female.setBounds(148, 396, 69, 23);
        getContentPane().add(Female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(Female);
        
        JComboBox<HealthFund> healthFundComboBox = new JComboBox<>(HealthFund.values());
        healthFundComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        healthFundComboBox.setBounds(121, 436, 161, 22);
        getContentPane().add(healthFundComboBox);

        // JComboBox for BiologicalSex Enum
        JComboBox<BiologicalSex> biologicalSexComboBox = new JComboBox<>(BiologicalSex.values());
        biologicalSexComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        biologicalSexComboBox.setBounds(130, 480, 37, 22);
        getContentPane().add(biologicalSexComboBox);

        // JSpinner for Birth Date
        JSpinner birthDateSpinner = new JSpinner(new SpinnerDateModel());
        birthDateSpinner.setBounds(113, 238, 85, 22);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(birthDateSpinner, "dd/MM/yyyy");
        birthDateSpinner.setEditor(editor);
        getContentPane().add(birthDateSpinner);
        
        JButton addpatient = new JButton("");
        addpatient.setIcon(new ImageIcon(AddPatient.class.getResource("/pics/icons8-patient-48.png")));
        addpatient.setBounds(358, 305, 89, 109);
        getContentPane().add(addpatient);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(AddPatient.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 528);
        getContentPane().add(lblNewLabel);
        
        addpatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	
                	if (!male.isSelected() && !Female.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Please select a gender.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    int patientId = Integer.parseInt(id.getText());
                    String patientFirstName = firstName.getText();
                    String patientLastName = lastName.getText();
                    Date patientBirthDate = (Date) birthDateSpinner.getValue();
                    String patientAddress = adress.getText();
                    String patientPhoneNumber = phoneNumber.getText();
                    String patientEmail = email.getText();
                    String patientGender = male.isSelected() ? "Male" : "Female";
                    HealthFund patientHealthFund = (HealthFund) healthFundComboBox.getSelectedItem();
                    BiologicalSex patientBiologicalSex = (BiologicalSex) biologicalSexComboBox.getSelectedItem();

                    // Create a new Patient object
                    Patient newPatient = new Patient(patientId, patientFirstName, patientLastName, patientBirthDate,
                            patientAddress, patientPhoneNumber, patientEmail, patientGender, patientHealthFund, patientBiologicalSex);

                    // Add the patient to the hospital system
                    Hospital.getInstance().addPatient(newPatient);

                    // Save the hospital state
                    Main.save();

                    JOptionPane.showMessageDialog(null, "Patient added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error adding patient: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

	}
}
