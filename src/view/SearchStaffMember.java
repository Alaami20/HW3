package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Department;
import model.Doctor;
import model.Nurse;
import model.StaffMember;
import javax.swing.ImageIcon;

public class SearchStaffMember extends JInternalFrame {

    private static final long serialVersionUID = 35L;
    private JComboBox<Integer> staffIdComboBox;
    private JLabel nameLabel;
    private JLabel birthDateLabel;
    private JLabel addressLabel;
    private JLabel phoneNumberLabel;
    private JLabel emailLabel;
    private JLabel genderLabel;
    private JLabel workStartDateLabel;
    private JLabel salaryLabel;
    private JLabel licenseNumberLabel;
    private JLabel specializationLabel;
    private JLabel isInternshipCompleteLabel;
    private JLabel departmentLabel;
    private String staffType;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String staffType = "Doctor"; // or "Nurse" depending on what you want to test
                    SearchStaffMember frame = new SearchStaffMember(staffType);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SearchStaffMember(String staffType) {
        this.staffType = staffType;
        initialize();
    }

    private void initialize() {
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
        setTitle("Search " + staffType);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel selectLabel = new JLabel("Select " + staffType + " ID:");
        selectLabel.setBounds(30, 20, 150, 25);
        getContentPane().add(selectLabel);

        staffIdComboBox = new JComboBox<>();
        staffIdComboBox.setBounds(180, 20, 200, 25);
        getContentPane().add(staffIdComboBox);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(180, 60, 100, 25);
        getContentPane().add(searchButton);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(30, 100, 400, 25);
        getContentPane().add(nameLabel);

        birthDateLabel = new JLabel("Birth Date: ");
        birthDateLabel.setBounds(30, 130, 400, 25);
        getContentPane().add(birthDateLabel);

        addressLabel = new JLabel("Address: ");
        addressLabel.setBounds(30, 160, 400, 25);
        getContentPane().add(addressLabel);

        phoneNumberLabel = new JLabel("Phone Number: ");
        phoneNumberLabel.setBounds(30, 190, 400, 25);
        getContentPane().add(phoneNumberLabel);

        emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(30, 220, 400, 25);
        getContentPane().add(emailLabel);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(30, 250, 400, 25);
        getContentPane().add(genderLabel);

        workStartDateLabel = new JLabel("Work Start Date: ");
        workStartDateLabel.setBounds(30, 280, 400, 25);
        getContentPane().add(workStartDateLabel);

        salaryLabel = new JLabel("Salary: ");
        salaryLabel.setBounds(30, 310, 400, 25);
        getContentPane().add(salaryLabel);

        licenseNumberLabel = new JLabel("License Number: ");
        licenseNumberLabel.setBounds(30, 340, 400, 25);
        getContentPane().add(licenseNumberLabel);

        departmentLabel = new JLabel("Departments: ");
        departmentLabel.setBounds(30, 370, 400, 25);
        getContentPane().add(departmentLabel);

        isInternshipCompleteLabel = new JLabel("Internship Completed: ");
        isInternshipCompleteLabel.setBounds(30, 400, 400, 25);
        getContentPane().add(isInternshipCompleteLabel);

        specializationLabel = new JLabel("Specialization: ");
        specializationLabel.setBounds(30, 430, 400, 25);
        getContentPane().add(specializationLabel);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SearchStaffMember.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);

        // Hide the specialization and internship labels initially for Nurse
        if (staffType.equals("Nurse")) {
            specializationLabel.setVisible(false);
            isInternshipCompleteLabel.setVisible(false);
        }

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (staffIdComboBox.getItemCount() > 0) {
                    int selectedId = (int) staffIdComboBox.getSelectedItem();
                    displayStaffMemberInfo(selectedId);
                }
            }
        });
    }

    public void populateComboBox(String staffType) {
        staffIdComboBox.removeAllItems();

        if (Main.libr == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (staffType.equals("Doctor")) {
            for (Doctor doctor : Main.libr.getDoctors()) {
                staffIdComboBox.addItem(doctor.getId());
            }
        } else if (staffType.equals("Nurse")) {
            for (Nurse nurse : Main.libr.getNurses()) {
                staffIdComboBox.addItem(nurse.getId());
            }
        }

        if (staffIdComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No staff members found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayStaffMemberInfo(int staffId) {
        if (Main.libr == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StaffMember staffMember = null;

        if (staffType.equals("Doctor")) {
            staffMember = Main.libr.getRealDoctor(staffId);
            specializationLabel.setVisible(true);
            isInternshipCompleteLabel.setVisible(true);
        } else if (staffType.equals("Nurse")) {
            staffMember = Main.libr.getRealNurse(staffId);
            specializationLabel.setVisible(false);
            isInternshipCompleteLabel.setVisible(false);
        }

        if (staffMember != null) {
            // Set common information
            nameLabel.setText("Name: " + staffMember.getFirstName() + " " + staffMember.getLastName());
            birthDateLabel.setText("Birth Date: " + dateFormat.format(staffMember.getBirthDate()));
            addressLabel.setText("Address: " + staffMember.getAddress());
            phoneNumberLabel.setText("Phone Number: " + staffMember.getPhoneNumber());
            emailLabel.setText("Email: " + staffMember.getEmail());
            genderLabel.setText("Gender: " + staffMember.getGender());
            workStartDateLabel.setText("Work Start Date: " + dateFormat.format(staffMember.getWorkStartDate()));
            salaryLabel.setText("Salary: " + staffMember.getSalary());
            licenseNumberLabel.setText("License Number: " + ((staffMember instanceof Doctor) ? ((Doctor) staffMember).getLicenseNumber() : ((Nurse) staffMember).getLicenseNumber()));

            if (staffMember instanceof Doctor) {
                Doctor doctor = (Doctor) staffMember;
                specializationLabel.setText("Specialization: " + doctor.getSpecialization());
                isInternshipCompleteLabel.setText("Internship Completed: " + (doctor.isFinishInternship() ? "Yes" : "No"));
            }

            // Display departments as a list
            HashSet<Department> departments = staffMember.getDepartments();
            if (departments.isEmpty()) {
                departmentLabel.setText("Departments: None");
            } else {
                StringBuilder departmentNames = new StringBuilder("Departments: ");
                for (Department department : departments) {
                    departmentNames.append(department.getName()).append(", ");
                }
                // Remove the last comma and space
                departmentLabel.setText(departmentNames.substring(0, departmentNames.length() - 2));
            }
        } else {
            // Reset labels if no staff member is found
            resetLabels();
            JOptionPane.showMessageDialog(this, "Staff Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetLabels() {
        nameLabel.setText("Name: ");
        birthDateLabel.setText("Birth Date: ");
        addressLabel.setText("Address: ");
        phoneNumberLabel.setText("Phone Number: ");
        emailLabel.setText("Email: ");
        genderLabel.setText("Gender: ");
        workStartDateLabel.setText("Work Start Date: ");
        salaryLabel.setText("Salary: ");
        licenseNumberLabel.setText("License Number: ");
        specializationLabel.setText("Specialization: ");
        isInternshipCompleteLabel.setText("Internship Completed: ");
        departmentLabel.setText("Departments: ");
    }
}
