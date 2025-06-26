package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.Hospital;
import exceptions.ObjectAlreadyExistsException;
import model.Treatment;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AddTreatment extends JInternalFrame {

	private static final long serialVersionUID = 22L;
	private JTextField serialNumber;
	private JTextField description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTreatment frame = new AddTreatment();
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
	public AddTreatment() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		setTitle("Add Treatment");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        JLabel lblTitle111 = new JLabel("Here you can add Treatment...");
        lblTitle111.setForeground(new Color(0, 64, 64));
        lblTitle111.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle111.setBounds(147, 35, 304, 35);
        getContentPane().add(lblTitle111);
        
        JLabel lblNewLabel = new JLabel("Serial Number:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(36, 180, 95, 14);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Description:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(36, 220, 75, 14);
        getContentPane().add(lblNewLabel_1);
        
        serialNumber = new JTextField();
        serialNumber.setBounds(131, 178, 96, 20);
        getContentPane().add(serialNumber);
        serialNumber.setColumns(10);
        
        description = new JTextField();
        description.setBounds(114, 218, 128, 20);
        getContentPane().add(description);
        description.setColumns(10);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(AddTreatment.class.getResource("/pics/icons8-treatment-64.png")));
        btnNewButton.setBounds(51, 306, 75, 73);
        getContentPane().add(btnNewButton);
        
        btnNewButton.addActionListener(e -> {
            try {
                // Check for missing fields
                if (serialNumber.getText().trim().isEmpty() || description.getText().trim().isEmpty()) {
                    throw new NullPointerException("Please fill in all fields.");
                }

                // Retrieve and parse data from the input fields
                int serialNum = Integer.parseInt(serialNumber.getText().trim());
                String desc = description.getText().trim();

                // Create a new Treatment object
                Treatment newTreatment = new Treatment(serialNum, desc);

                // Add the new treatment to the hospital system
                Hospital hospital = Hospital.getInstance();
                if (hospital.addTreatment(newTreatment)) {
                    // Show a success message
                    JOptionPane.showMessageDialog(null, "Treatment added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                // Handle invalid number inputs
                JOptionPane.showMessageDialog(null, "Please enter a valid serial number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException ex) {
                // Handle missing fields
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (ObjectAlreadyExistsException ex) {
                // Handle cases where the treatment already exists
                JOptionPane.showMessageDialog(null, "A treatment with this serial number already exists.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                // Handle all other errors
                JOptionPane.showMessageDialog(null, "Error adding treatment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(AddTreatment.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel_2.setBounds(0, 0, 593, 547);
        getContentPane().add(lblNewLabel_2);

	}
}
