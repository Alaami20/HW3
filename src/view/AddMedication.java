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
import model.Medication;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AddMedication extends JInternalFrame {

	private static final long serialVersionUID = 19L;
	private JTextField code;
	private JTextField name;
	private JTextField dosage;
	private JTextField numberOfDosage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMedication frame = new AddMedication();
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
	public AddMedication() {
		setTitle("Add Medication");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel lblTitle1 = new JLabel("Here you can add Medication...");
        lblTitle1.setForeground(new Color(0, 64, 64));
        lblTitle1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle1.setBounds(162, 35, 268, 35);
        getContentPane().add(lblTitle1);
        
        JLabel lblNewLabel = new JLabel("Code:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(36, 160, 35, 14);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(36, 200, 39, 14);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Dosage:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(36, 240, 49, 18);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Number Of Dosage:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(36, 280, 123, 18);
        getContentPane().add(lblNewLabel_3);
        
        code = new JTextField();
        code.setBounds(73, 158, 96, 20);
        getContentPane().add(code);
        code.setColumns(10);
        
        name = new JTextField();
        name.setBounds(83, 198, 96, 20);
        getContentPane().add(name);
        name.setColumns(10);
        
        dosage = new JTextField();
        dosage.setBounds(93, 238, 96, 20);
        getContentPane().add(dosage);
        dosage.setColumns(10);
        
        numberOfDosage = new JTextField();
        numberOfDosage.setBounds(155, 278, 96, 20);
        getContentPane().add(numberOfDosage);
        numberOfDosage.setColumns(10);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(AddMedication.class.getResource("/pics/icons8-medication-64.png")));
        btnNewButton.setBounds(58, 340, 80, 73);
        getContentPane().add(btnNewButton);
        
        btnNewButton.addActionListener(e -> {
            try {
                // Check for missing fields
                if (code.getText().trim().isEmpty() || name.getText().trim().isEmpty() ||
                    dosage.getText().trim().isEmpty() || numberOfDosage.getText().trim().isEmpty()) {
                    throw new NullPointerException("Please fill in all fields.");
                }

                // Retrieve and parse data from the input fields
                int medCode = Integer.parseInt(code.getText().trim());
                String medName = name.getText().trim();
                double medDosage = Double.parseDouble(dosage.getText().trim());
                int medNumberOfDosage = Integer.parseInt(numberOfDosage.getText().trim());

                // Create a new Medication object
                Medication newMedication = new Medication(medCode, medName, medDosage, medNumberOfDosage);

                // Add the new medication to the hospital system
                Hospital hospital = Hospital.getInstance();
                if (hospital.addMedication(newMedication)) {
                    // Show a success message
                    JOptionPane.showMessageDialog(null, "Medication added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                // Handle invalid number inputs
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for code, dosage, and number of dosage.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException ex) {
                // Handle missing fields
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (ObjectAlreadyExistsException ex) {
                // Handle cases where the medication already exists
                JOptionPane.showMessageDialog(null, "A medication with this code already exists.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                // Handle all other errors
                JOptionPane.showMessageDialog(null, "Error adding medication: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(AddMedication.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel_4.setBounds(0, 0, 593, 540);
        getContentPane().add(lblNewLabel_4);

	}

}
