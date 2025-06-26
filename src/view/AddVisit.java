package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import control.Hospital;
import model.Patient;
import model.Visit;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AddVisit extends JInternalFrame {

	private static final long serialVersionUID = 23L;
	private JTextField number;
	private JTextField patient;
	private JSpinner startDateSpinner;
	private JSpinner endDateSpinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVisit frame = new AddVisit();
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
	public AddVisit() {
		 setTitle("Add Visit");
	        setClosable(true);
	        setMaximizable(true);
	        setIconifiable(true);
	        setResizable(true);
	        setBounds(100, 100, 609, 558);
	        getContentPane().setLayout(null);
	        
	        JLabel lblTitle11 = new JLabel("Here you can add Visit...");
	        lblTitle11.setForeground(new Color(0, 64, 64));
	        lblTitle11.setFont(new Font("Tahoma", Font.BOLD, 16));
	        lblTitle11.setBounds(162, 35, 268, 35);
	        getContentPane().add(lblTitle11);
	        
	        JLabel lblNewLabel_1 = new JLabel("Visit Number:");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_1.setBounds(36, 160, 87, 14);
	        getContentPane().add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("Patient ID:");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_2.setBounds(36, 200, 65, 14);
	        getContentPane().add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_3 = new JLabel("Start date:");
	        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_3.setBounds(36, 240, 65, 14);
	        getContentPane().add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_4 = new JLabel("End date:");
	        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_4.setBounds(36, 280, 65, 14);
	        getContentPane().add(lblNewLabel_4);
	        
	        number = new JTextField();
	        number.setBounds(123, 158, 96, 20);
	        getContentPane().add(number);
	        number.setColumns(10);
	        
	        patient = new JTextField();
	        patient.setBounds(104, 198, 96, 20);
	        getContentPane().add(patient);
	        patient.setColumns(10);
	        
	        startDateSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
			startDateSpinner.setBounds(104, 238, 78, 20);
			JSpinner.DateEditor startEditor = new JSpinner.DateEditor(startDateSpinner, "dd/MM/yyyy");
			startDateSpinner.setEditor(startEditor);
			getContentPane().add(startDateSpinner);

			endDateSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
			endDateSpinner.setBounds(104, 278, 78, 20);
			JSpinner.DateEditor endEditor = new JSpinner.DateEditor(endDateSpinner, "dd/MM/yyyy");
			endDateSpinner.setEditor(endEditor);
			getContentPane().add(endDateSpinner);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(AddVisit.class.getResource("/pics/icons8-surgery-64.png")));
			btnNewButton.setBounds(69, 335, 78, 97);
			getContentPane().add(btnNewButton);
			
			 btnNewButton.addActionListener(e -> {
		            try {
		                // Retrieve and parse data from the input fields
		                int visitNumber = Integer.parseInt(number.getText());
		                int patientId = Integer.parseInt(patient.getText());
		                Date startDate = (Date) startDateSpinner.getValue();
		                Date endDate = (Date) endDateSpinner.getValue();

		                // Retrieve the patient object from the hospital system
		                Patient visitPatient = Hospital.getInstance().getRealPatient(patientId);
		                if (visitPatient == null) {
		                    throw new NullPointerException("Patient not found");
		                }

		                // Create the Visit object
		                Visit newVisit = new Visit(visitNumber, visitPatient, startDate, endDate);

		                // Add the visit to the hospital system
		                Hospital.getInstance().addVisit(newVisit);

		                // Save the hospital state
		                Main.save();

		                // Show a success message
		                JOptionPane.showMessageDialog(null, "Visit added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

		            } catch (NumberFormatException ex) {
		                // Handle invalid number inputs
		                JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
		            } catch (NullPointerException ex) {
		                // Handle cases where the patient is not found
		                JOptionPane.showMessageDialog(null, "Patient not found.", "Input Error", JOptionPane.ERROR_MESSAGE);
		            } catch (Exception ex) {
		                // Handle all other errors
		                JOptionPane.showMessageDialog(null, "Error adding visit: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        });
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(AddVisit.class.getResource("/pics/amjadhospital.png")));
			lblNewLabel.setBounds(0, 0, 593, 528);
			getContentPane().add(lblNewLabel);
	        
	        

	}

}
