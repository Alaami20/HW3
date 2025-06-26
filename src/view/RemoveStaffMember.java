package view;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.Hospital;
import model.Doctor;
import model.Nurse;
import javax.swing.ImageIcon;

public class RemoveStaffMember extends JInternalFrame {
	
	private static final long serialVersionUID = 30L;
    private JComboBox<Integer> staffComboBox;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RemoveStaffMember frame = new RemoveStaffMember("Doctor"); 
                    frame.populateComboBox("Doctor"); 
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public RemoveStaffMember(String staffType) {
        setTitle("Remove " + staffType);
        setBounds(100, 100, 609, 558);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Here you can remove " + staffType + "...");
        lblTitle.setForeground(new Color(0, 64, 64));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(175, 35, 315, 35);
        getContentPane().add(lblTitle);
        
        staffComboBox = new JComboBox<>();
        staffComboBox.setBounds(25, 149, 180, 25);
        getContentPane().add(staffComboBox);

        JButton removeButton = new JButton("Remove");
        removeButton.setForeground(new Color(255, 0, 0));
        removeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        removeButton.setBounds(58, 243, 100, 25);
        getContentPane().add(removeButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RemoveStaffMember.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 539);
        getContentPane().add(lblNewLabel);

        removeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                try {
                    Integer selectedStaffId = (Integer) staffComboBox.getSelectedItem();
                    if (selectedStaffId == null) {
                        throw new NullPointerException("No staff member selected.");
                    }

                    boolean success = false;

                    if ("Doctor".equalsIgnoreCase(staffType)) {
                        Doctor doctor = Hospital.getInstance().getRealDoctor(selectedStaffId);
                        if (doctor == null) {
                            throw new NullPointerException("Selected doctor does not exist.");
                        }
                        success = Hospital.getInstance().removeDoctor(doctor);
                    } else if ("Nurse".equalsIgnoreCase(staffType)) {
                        Nurse nurse = Hospital.getInstance().getRealNurse(selectedStaffId);
                        if (nurse == null) {
                            throw new NullPointerException("Selected nurse does not exist.");
                        }
                        success = Hospital.getInstance().removeNurse(nurse);
                    }

                    if (success) {
                        JOptionPane.showMessageDialog(null, staffType + " removed successfully.");
                        populateComboBox(staffType); // Refresh the combo box
                    } else {
                        JOptionPane.showMessageDialog(null, "Error removing " + staffType + ".");
                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void populateComboBox(String staffType) {
        staffComboBox.removeAllItems();

        if ("Doctor".equalsIgnoreCase(staffType)) {
            Hospital.getInstance().getStaffMembers().values().stream()
                    .filter(staff -> staff instanceof Doctor)
                    .forEach(doctor -> staffComboBox.addItem(doctor.getId()));
        } else if ("Nurse".equalsIgnoreCase(staffType)) {
            Hospital.getInstance().getStaffMembers().values().stream()
                    .filter(staff -> staff instanceof Nurse)
                    .forEach(nurse -> staffComboBox.addItem(nurse.getId()));
        }
    }
}
