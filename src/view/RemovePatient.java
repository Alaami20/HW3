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
import model.Patient;
import javax.swing.ImageIcon;

public class RemovePatient extends JInternalFrame {

	private static final long serialVersionUID = 29L;
	private JComboBox<Integer> patientComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemovePatient frame = new RemovePatient();
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
	public RemovePatient() {
		setTitle("Remove Patient");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        JLabel lblTitle11 = new JLabel("Here you can remove Patient...");
        lblTitle11.setForeground(new Color(0, 64, 64));
        lblTitle11.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle11.setBounds(162, 35, 268, 35);
        getContentPane().add(lblTitle11);

		patientComboBox = new JComboBox<>();
        patientComboBox.setBounds(25, 149, 180, 25);
        getContentPane().add(patientComboBox);
        
        JButton removeButton = new JButton("Remove");
        removeButton.setForeground(new Color(255, 0, 0));
        removeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        removeButton.setBounds(58, 243, 100, 25);
        getContentPane().add(removeButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RemovePatient.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 556);
        getContentPane().add(lblNewLabel);

        // Populate ComboBox with patient IDs
        populateComboBox();

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSelectedPatient();
            }
        });
    }

    public void populateComboBox() {
        patientComboBox.removeAllItems();
        for (Patient patient : Hospital.getInstance().getPatients().values()) {
            patientComboBox.addItem(patient.getId());
        }
    }

    private void removeSelectedPatient() {
        try {
            Integer selectedPatientId = (Integer) patientComboBox.getSelectedItem();
            if (selectedPatientId == null) {
                throw new NullPointerException("No patient selected.");
            }

            Patient patient = Hospital.getInstance().getRealPatient(selectedPatientId);
            if (patient == null) {
                throw new NullPointerException("Selected patient does not exist.");
            }

            boolean success = Hospital.getInstance().removePatient(patient);
            if (success) {
                JOptionPane.showMessageDialog(null, "Patient removed successfully.");
                populateComboBox(); // Refresh the combo box
            } else {
                JOptionPane.showMessageDialog(null, "Error removing patient.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
