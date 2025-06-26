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

public class RemoveVisit extends JInternalFrame {

	private static final long serialVersionUID = 32L;
	private JComboBox<Integer> patientComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveVisit frame = new RemoveVisit();
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
	public RemoveVisit() {
		setTitle("Remove Visit");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        JLabel lblTitle11 = new JLabel("Here you can remove Visit...");
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
        lblNewLabel.setIcon(new ImageIcon(RemoveVisit.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSelectedVisit();
            }
        });

        populateComboBox(); // Populate the ComboBox when the frame is opened
    }

    public void populateComboBox() {
        patientComboBox.removeAllItems();
        for (Patient patient : Hospital.getInstance().getPatients().values()) {
            patientComboBox.addItem(patient.getId());
        }
    }

    private void removeSelectedVisit() {
        try {
            Integer selectedPatientId = (Integer) patientComboBox.getSelectedItem();
            if (selectedPatientId == null) {
                throw new NullPointerException("No patient selected.");
            }

            Patient patient = Hospital.getInstance().getRealPatient(selectedPatientId);
            if (patient.getVisitsList().isEmpty()) {
                JOptionPane.showMessageDialog(this, "The patient has no visits to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Assume that you want to remove all visits of the selected patient
            patient.getVisitsList().clear();
            JOptionPane.showMessageDialog(this, "All visits for the patient ID " + selectedPatientId + " have been removed.");

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
