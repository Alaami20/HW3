package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.Hospital;
import enums.Specialization;
import model.Department;
import model.Doctor;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AddDepartment extends JInternalFrame {

	private static final long serialVersionUID = 16L;
	private JComboBox specializationss;
	private JTextField number;
	private JTextField name;
	private JTextField manager;
	private JTextField location;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepartment frame = new AddDepartment();
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
	public AddDepartment() {
		 setTitle("Add Department");
	        setClosable(true);
	        setMaximizable(true);
	        setIconifiable(true);
	        setResizable(true);
	        setBounds(100, 100, 609, 558);
	        getContentPane().setLayout(null);

	        JLabel lblTitle1 = new JLabel("Here you can add Department...");
	        lblTitle1.setForeground(new Color(0, 64, 64));
	        lblTitle1.setFont(new Font("Tahoma", Font.BOLD, 16));
	        lblTitle1.setBounds(162, 35, 268, 35);
	        getContentPane().add(lblTitle1);
	        
	        JLabel aa = new JLabel("Department Number:");
	        aa.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        aa.setBounds(36, 160, 127, 21);
	        getContentPane().add(aa);
	        
	        JLabel aaa = new JLabel("Department Name:");
	        aaa.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        aaa.setBounds(36, 200, 115, 21);
	        getContentPane().add(aaa);
	        
	        JLabel ddd = new JLabel("Manager ID:");
	        ddd.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        ddd.setBounds(36, 240, 74, 21);
	        getContentPane().add(ddd);
	        
	        JLabel zzz = new JLabel("Location:");
	        zzz.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        zzz.setBounds(36, 280, 65, 14);
	        getContentPane().add(zzz);
	        
	        JLabel specialization = new JLabel("Specialization:");
	        specialization.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        specialization.setBounds(36, 320, 93, 21);
	        getContentPane().add(specialization);
	        
	        specializationss = new JComboBox<String>();
	        specializationss.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    	String[] specializations = {"Neurology", "Other", "Cardiology", "Otolaryngology",
	    			"Orthopedics", "Surgery", "Ophthalmology", 
	    			"Pulmonology", "IntensiveCare"};
	    	for (String specializationn : specializations) {
	    		specializationss.addItem(specializationn);
	    	}
	    	specializationss.setBounds(131, 320, 96, 20);
	    	getContentPane().add(specializationss);
	    	
	    	number = new JTextField();
	    	number.setBounds(171, 161, 96, 20);
	    	getContentPane().add(number);
	    	number.setColumns(10);
	    	
	    	name = new JTextField();
	    	name.setBounds(155, 201, 96, 20);
	    	getContentPane().add(name);
	    	name.setColumns(10);
	    	
	    	manager = new JTextField();
	    	manager.setBounds(114, 241, 96, 20);
	    	getContentPane().add(manager);
	    	manager.setColumns(10);
	    	
	    	location = new JTextField();
	    	location.setBounds(95, 278, 96, 20);
	    	getContentPane().add(location);
	    	location.setColumns(10);
	    	
	    	JButton addDepartment = new JButton("");
	    	addDepartment.setIcon(new ImageIcon(AddDepartment.class.getResource("/pics/icons8-out-patient-department-64.png")));
	    	addDepartment.setBounds(436, 305, 87, 111);
	    	getContentPane().add(addDepartment);
	    	
	    	addDepartment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						// Retrieve and parse data from the input fields
						int deptNumber = Integer.parseInt(number.getText());
						String deptName = name.getText();
						int managerId = Integer.parseInt(manager.getText());
						String deptLocation = location.getText();
						String specializationStr = (String) specializationss.getSelectedItem();

						// Retrieve the manager object from the hospital system
						Doctor deptManager = (Doctor) Hospital.getInstance().getStaffMember(managerId);

						// Convert the selected specialization string to Specialization enum
						Specialization specialization = Specialization.valueOf(specializationStr);

						// Create the Department object
						Department newDepartment = new Department(deptNumber, deptName, deptManager, deptLocation, specialization);

						// Add the department to the hospital system
						Hospital.getInstance().addDepartment(newDepartment);

						// Save the hospital state
						Main.save();

						// Show a success message
						JOptionPane.showMessageDialog(null, "Department added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

					} catch (NumberFormatException ex) {
						// Handle invalid number inputs
						JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
					} catch (NullPointerException ex) {
						// Handle cases where the manager or specialization is not found
						JOptionPane.showMessageDialog(null, "Manager not found or invalid specialization.", "Input Error", JOptionPane.ERROR_MESSAGE);
					} catch (Exception ex) {
						// Handle all other errors
						JOptionPane.showMessageDialog(null, "Error adding department: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
	    	
	    	JLabel lblNewLabel = new JLabel("");
	    	lblNewLabel.setIcon(new ImageIcon(AddDepartment.class.getResource("/pics/amjadhospital.png")));
	    	lblNewLabel.setBounds(0, 0, 593, 528);
	    	getContentPane().add(lblNewLabel);
	}
}
