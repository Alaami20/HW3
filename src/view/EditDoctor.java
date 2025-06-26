package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import control.Hospital;
import model.Doctor;
import model.IntensiveCareDoctor;

public class EditDoctor extends JInternalFrame {

    private static final long serialVersionUID = 44L;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtAddress;
    private JTextField txtPhoneNumber;
    private JTextField txtEmail;
    private JTextField txtSalary;
    private Doctor loggedInDoctor;
    
   

    public EditDoctor(Doctor doctor) {
        this.loggedInDoctor = doctor;
        setTitle("Edit Doctor Information");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        // Background image panel
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 609, 558);
        backgroundPanel.setLayout(null);
        JLabel backgroundLabel = new JLabel("");
        backgroundLabel.setIcon(new ImageIcon(EditDoctor.class.getResource("/pics/amjadhospital.png")));
        backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.setBounds(0, 0, 609, 558);
        backgroundPanel.add(backgroundLabel);
        getContentPane().add(backgroundPanel);

        JLabel lblTitle = new JLabel("Edit Doctor Information");
        lblTitle.setForeground(new Color(0, 64, 64));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(162, 35, 268, 35);
        backgroundLabel.add(lblTitle);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblFirstName.setBounds(36, 100, 100, 14);
        backgroundLabel.add(lblFirstName);

        txtFirstName = new JTextField(doctor.getFirstName());
        txtFirstName.setBounds(140, 98, 150, 20);
        backgroundLabel.add(txtFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblLastName.setBounds(36, 140, 100, 14);
        backgroundLabel.add(lblLastName);

        txtLastName = new JTextField(doctor.getLastName());
        txtLastName.setBounds(140, 138, 150, 20);
        backgroundLabel.add(txtLastName);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblAddress.setBounds(36, 180, 100, 14);
        backgroundLabel.add(lblAddress);

        txtAddress = new JTextField(doctor.getAddress());
        txtAddress.setBounds(140, 178, 150, 20);
        backgroundLabel.add(txtAddress);

        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPhoneNumber.setBounds(36, 220, 100, 14);
        backgroundLabel.add(lblPhoneNumber);

        txtPhoneNumber = new JTextField(doctor.getPhoneNumber());
        txtPhoneNumber.setBounds(140, 218, 150, 20);
        backgroundLabel.add(txtPhoneNumber);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblEmail.setBounds(36, 260, 100, 14);
        backgroundLabel.add(lblEmail);

        txtEmail = new JTextField(doctor.getEmail());
        txtEmail.setBounds(140, 258, 150, 20);
        backgroundLabel.add(txtEmail);

        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSalary.setBounds(36, 300, 100, 14);
        backgroundLabel.add(lblSalary);

        txtSalary = new JTextField(Double.toString(doctor.getSalary()));
        txtSalary.setBounds(140, 298, 150, 20);
        backgroundLabel.add(txtSalary);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(69, 350, 100, 25);
        backgroundLabel.add(btnSave);

        JButton btnConvertToIC = new JButton("Convert to Intensive Care");
        btnConvertToIC.setBounds(180, 350, 200, 25);
        backgroundLabel.add(btnConvertToIC);

        btnSave.addActionListener(e -> saveDoctorInfo());

        btnConvertToIC.addActionListener(e -> convertToIntensiveCare());

    }

    protected void saveDoctorInfo() {
        loggedInDoctor.setFirstName(txtFirstName.getText());
        loggedInDoctor.setLastName(txtLastName.getText());
        loggedInDoctor.setAddress(txtAddress.getText());
        loggedInDoctor.setPhoneNumber(txtPhoneNumber.getText());
        loggedInDoctor.setEmail(txtEmail.getText());
        loggedInDoctor.setSalary(Double.parseDouble(txtSalary.getText()));


        JOptionPane.showMessageDialog(this, "Doctor information updated successfully!");
    }

    protected void convertToIntensiveCare() {
        IntensiveCareDoctor icDoctor = new IntensiveCareDoctor(
            loggedInDoctor.getId(), 
            loggedInDoctor.getFirstName(), 
            loggedInDoctor.getLastName(), 
            loggedInDoctor.getBirthDate(), 
            loggedInDoctor.getAddress(), 
            loggedInDoctor.getPhoneNumber(), 
            loggedInDoctor.getEmail(), 
            loggedInDoctor.getGender(), 
            loggedInDoctor.getWorkStartDate(), 
            loggedInDoctor.getSalary(), 
            loggedInDoctor.getPassword(), 
            loggedInDoctor.getLicenseNumber(), 
            loggedInDoctor.isFinishInternship()
        );

        Hospital.getInstance().removeDoctor(loggedInDoctor);
        Hospital.getInstance().addIntensiveCareDoctor(icDoctor);

        JOptionPane.showMessageDialog(this, "Doctor successfully converted to Intensive Care!");
    }

}
