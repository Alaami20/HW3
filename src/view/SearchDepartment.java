package view;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Department;
import model.StaffMember;
import view.Main;
import javax.swing.ImageIcon;
import java.awt.Font;

public class SearchDepartment extends JInternalFrame {

    private static final long serialVersionUID = 33L;
    private JComboBox<Integer> departmentComboBox;
    private JLabel nameLabel;
    private JLabel managerLabel;
    private JLabel locationLabel;
    private JLabel specializationLabel;
    private JLabel staffListLabel;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchDepartment frame = new SearchDepartment();
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
    public SearchDepartment() {
        setBounds(100, 100, 609, 558);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Search Department");
        getContentPane().setLayout(null);
        
        JLabel selectLabel = new JLabel("Select Department Number:");
        selectLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        selectLabel.setBounds(36, 50, 175, 25);
        getContentPane().add(selectLabel);

        departmentComboBox = new JComboBox<>();
        departmentComboBox.setBounds(220, 50, 200, 25);
        getContentPane().add(departmentComboBox);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(30, 120, 400, 25);
        getContentPane().add(nameLabel);

        managerLabel = new JLabel("Manager: ");
        managerLabel.setBounds(30, 160, 400, 25);
        getContentPane().add(managerLabel);

        locationLabel = new JLabel("Location: ");
        locationLabel.setBounds(30, 200, 400, 25);
        getContentPane().add(locationLabel);

        specializationLabel = new JLabel("Specialization: ");
        specializationLabel.setBounds(30, 240, 400, 25);
        getContentPane().add(specializationLabel);

        staffListLabel = new JLabel("Staff Members: ");
        staffListLabel.setBounds(30, 280, 400, 25);
        getContentPane().add(staffListLabel);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SearchDepartment.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 563);
        getContentPane().add(lblNewLabel);

        departmentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (departmentComboBox.getItemCount() > 0) {
                    int selectedDepartmentNumber = (int) departmentComboBox.getSelectedItem();
                    displayDepartmentInfo(selectedDepartmentNumber);
                }
            }
        });
    }

    public void populateComboBox() {
        departmentComboBox.removeAllItems();

        if (Main.libr == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Department department : Main.libr.getDepartments().values()) {
            departmentComboBox.addItem(department.getNumber());
        }

        if (departmentComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No departments found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayDepartmentInfo(int departmentNumber) {
        if (Main.libr == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Department department = Main.libr.getRealDepartment(departmentNumber);

        if (department != null) {
            nameLabel.setText("Name: " + department.getName());
            managerLabel.setText("Manager: " + (department.getmanager() != null ? department.getmanager().getFirstName() + " " + department.getmanager().getLastName() : "None"));
            locationLabel.setText("Location: " + department.getLocation());
            specializationLabel.setText("Specialization: " + department.getSpecialization());

            StringBuilder staffList = new StringBuilder("Staff Members: ");
            if (department.getStaffMembersList().isEmpty()) {
                staffList.append("None");
            } else {
                for (StaffMember staffMember : department.getStaffMembersList()) {
                    staffList.append(staffMember.getFirstName()).append(" ").append(staffMember.getLastName()).append(", ");
                }
                // Remove the last comma and space
                staffList.setLength(staffList.length() - 2);
            }
            staffListLabel.setText(staffList.toString());
        } else {
            // Reset labels if no department is found
            resetLabels();
            JOptionPane.showMessageDialog(this, "Department not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetLabels() {
        nameLabel.setText("Name: ");
        managerLabel.setText("Manager: ");
        locationLabel.setText("Location: ");
        specializationLabel.setText("Specialization: ");
        staffListLabel.setText("Staff Members: ");
    }
}
