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
import model.Department;
import javax.swing.ImageIcon;

public class RemoveDepartment extends JInternalFrame {

	private static final long serialVersionUID = 26L;
	private JComboBox<Integer> departmentComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveDepartment frame = new RemoveDepartment();
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
	public RemoveDepartment() {
		setTitle("Remove Department");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        JLabel lblTitle11 = new JLabel("Here you can remove Department...");
        lblTitle11.setForeground(new Color(0, 64, 64));
        lblTitle11.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle11.setBounds(162, 35, 268, 35);
        getContentPane().add(lblTitle11);

        departmentComboBox = new JComboBox<>();
        departmentComboBox.setBounds(25, 149, 180, 25);
        getContentPane().add(departmentComboBox);

        JButton removeButton = new JButton("Remove");
        removeButton.setForeground(new Color(255, 0, 0));
        removeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        removeButton.setBounds(58, 243, 100, 25);
        getContentPane().add(removeButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RemoveDepartment.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 545);
        getContentPane().add(lblNewLabel);

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer selectedDepartmentNumber = (Integer) departmentComboBox.getSelectedItem();
                    if (selectedDepartmentNumber == null) {
                        throw new NullPointerException("No department selected.");
                    }

                    Department department = Hospital.getInstance().getDepartmentByNumber(selectedDepartmentNumber);
                    if (department == null) {
                        throw new NullPointerException("Selected department does not exist.");
                    }

                    boolean success = Hospital.getInstance().removeDepartment(department);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Department removed successfully.");
                        populateComboBox(); // Refresh the combo box
                    } else {
                        JOptionPane.showMessageDialog(null, "Error removing department.");
                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        populateComboBox(); // Populate the combo box when the frame is initialized
    }

    public void populateComboBox() {
        departmentComboBox.removeAllItems();
        for (Integer departmentNumber : Hospital.getInstance().getDepartments().keySet()) {
            departmentComboBox.addItem(departmentNumber);
        }
    }
}
