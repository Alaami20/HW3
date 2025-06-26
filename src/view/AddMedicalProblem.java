package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.Hospital;
import model.Department;
import model.Disease;
import model.Fracture;
import model.Injury;
import model.MedicalProblem;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AddMedicalProblem extends JInternalFrame {

	private static final long serialVersionUID = 18L;
	private JTextField name;
	private JTextField department;
	private JTextField description;
	private JTextField commonRecoveryTime;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMedicalProblem frame = new AddMedicalProblem();
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
	public AddMedicalProblem() {
		setTitle("Add MedicalProblem");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        JLabel lblTitle11 = new JLabel("Here you can add Medical Problem...");
        lblTitle11.setForeground(new Color(0, 64, 64));
        lblTitle11.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle11.setBounds(147, 35, 304, 35);
        getContentPane().add(lblTitle11);
        
        JRadioButton injuryRadioButton = new JRadioButton("Injury");
        injuryRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        injuryRadioButton.setBounds(73, 120, 61, 19);
        getContentPane().add(injuryRadioButton);
        
        JLabel lblNewLabel = new JLabel("Type:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(36, 120, 34, 14);
        getContentPane().add(lblNewLabel);
        
        JRadioButton diseaseRadioButton = new JRadioButton("Disease");
        diseaseRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        diseaseRadioButton.setBounds(137, 120, 73, 19);
        getContentPane().add(diseaseRadioButton);
        
        JRadioButton fractureRadioButton = new JRadioButton("Fracture");
        fractureRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        fractureRadioButton.setBounds(213, 120, 80, 19);
        getContentPane().add(fractureRadioButton);
        
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(diseaseRadioButton);
        typeGroup.add(injuryRadioButton);
        typeGroup.add(fractureRadioButton);
        
        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(36, 160, 39, 14);
        getContentPane().add(lblNewLabel_1);
        
        name = new JTextField();
        name.setBounds(82, 158, 96, 20);
        getContentPane().add(name);
        name.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Department Number:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(36, 200, 127, 14);
        getContentPane().add(lblNewLabel_2);
        
        department = new JTextField();
        department.setBounds(168, 198, 96, 20);
        getContentPane().add(department);
        department.setColumns(10);
        
        description = new JTextField();
        description.setBounds(210, 238, 136, 20);
        getContentPane().add(description);
        description.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Description");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(36, 240, 67, 14);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("(if Disease only):");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(105, 240, 102, 14);
        getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("(if Injury only):");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4_1.setBounds(186, 280, 102, 14);
        getContentPane().add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_5 = new JLabel("Common Recovery Time");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(36, 280, 145, 14);
        getContentPane().add(lblNewLabel_5);
        
        commonRecoveryTime = new JTextField();
        commonRecoveryTime.setBounds(281, 278, 96, 20);
        getContentPane().add(commonRecoveryTime);
        commonRecoveryTime.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Location");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(36, 320, 50, 14);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_4_1_1 = new JLabel("(if Injury\\Fracture only):");
        lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4_1_1.setBounds(92, 320, 145, 14);
        getContentPane().add(lblNewLabel_4_1_1);
        
        textField = new JTextField();
        textField.setBounds(239, 318, 96, 20);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_7 = new JLabel("Does it requires cast?");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_7.setBounds(36, 360, 130, 14);
        getContentPane().add(lblNewLabel_7);
        
        JLabel lblNewLabel_4_1_1_1 = new JLabel("(if Fracture only):");
        lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4_1_1_1.setBounds(165, 360, 105, 14);
        getContentPane().add(lblNewLabel_4_1_1_1);
        
        JRadioButton yesRadioButton = new JRadioButton("Yes");
        yesRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        yesRadioButton.setBounds(269, 357, 48, 23);
        getContentPane().add(yesRadioButton);
        
        JRadioButton noRadioButton = new JRadioButton("No");
        noRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        noRadioButton.setBounds(322, 357, 41, 23);
        getContentPane().add(noRadioButton);
        
        ButtonGroup yesNoGroup = new ButtonGroup();
        yesNoGroup.add(yesRadioButton);
        yesNoGroup.add(noRadioButton);
        
        JButton addMedicalProblem = new JButton("");
        addMedicalProblem.setIcon(new ImageIcon(AddMedicalProblem.class.getResource("/pics/icons8-disease-48.png")));
        addMedicalProblem.setBounds(61, 402, 73, 64);
        getContentPane().add(addMedicalProblem);
        
        addMedicalProblem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Validate common fields
                    String medicalProblemName = name.getText().trim();
                    int departmentNumber = Integer.parseInt(department.getText().trim());
                    Department department = Hospital.getInstance().getDepartmentByNumber(departmentNumber);

                    if (medicalProblemName.isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty");
                    }

                    if (department == null) {
                        throw new IllegalArgumentException("Department does not exist");
                    }

                    MedicalProblem medicalProblem = null;

                    // Determine which type of medical problem is selected
                    if (diseaseRadioButton.isSelected()) {
                        // Ensure irrelevant fields are empty
                        if (!commonRecoveryTime.getText().trim().isEmpty() || !textField.getText().trim().isEmpty()) {
                            throw new IllegalArgumentException("Common Recovery Time and Location should be empty for Disease");
                        }
                        
                        String descriptionText = description.getText().trim();
                        if (descriptionText.isEmpty()) {
                            throw new IllegalArgumentException("Description cannot be empty for Disease");
                        }
                        medicalProblem = new Disease(medicalProblemName, department, descriptionText);

                    } else if (injuryRadioButton.isSelected()) {
                        // Ensure irrelevant fields are empty
                        if (!description.getText().trim().isEmpty()) {
                            throw new IllegalArgumentException("Description should be empty for Injury");
                        }

                        double recoveryTime = Double.parseDouble(commonRecoveryTime.getText().trim());
                        String locationText = textField.getText().trim();
                        if (locationText.isEmpty()) {
                            throw new IllegalArgumentException("Location cannot be empty for Injury");
                        }
                        medicalProblem = new Injury(medicalProblemName, department, recoveryTime, locationText);

                    } else if (fractureRadioButton.isSelected()) {
                        // Ensure irrelevant fields are empty
                        if (!description.getText().trim().isEmpty() || !commonRecoveryTime.getText().trim().isEmpty()) {
                            throw new IllegalArgumentException("Description and Common Recovery Time should be empty for Fracture");
                        }

                        String locationText = textField.getText().trim();
                        if (locationText.isEmpty()) {
                            throw new IllegalArgumentException("Location cannot be empty for Fracture");
                        }
                        boolean requiresCast = yesRadioButton.isSelected();
                        medicalProblem = new Fracture(medicalProblemName, department, locationText, requiresCast);
                    } else {
                        throw new IllegalArgumentException("Please select a medical problem type");
                    }

                    // Add the medical problem to the hospital
                    if (Hospital.getInstance().addMedicalProblem(medicalProblem)) {
                        Main.save(); // Save the hospital state
                        JOptionPane.showMessageDialog(null, "Medical Problem added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        throw new Exception("Failed to add the medical problem");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        JLabel dd = new JLabel("");
        dd.setIcon(new ImageIcon(AddMedicalProblem.class.getResource("/pics/amjadhospital.png")));
        dd.setBounds(0, 0, 593, 528);
        getContentPane().add(dd);

	}
}
