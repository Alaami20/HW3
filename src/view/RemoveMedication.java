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
import javax.swing.ImageIcon;

public class RemoveMedication extends JInternalFrame {

	private static final long serialVersionUID = 28L;
	private JComboBox<Integer> medicationComboBox;
    private JButton removeButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveMedication frame = new RemoveMedication();
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
	public RemoveMedication() {
		setTitle("Remove Medication");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        JLabel lblTitle11 = new JLabel("Here you can remove Medication...");
        lblTitle11.setForeground(new Color(0, 64, 64));
        lblTitle11.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle11.setBounds(162, 35, 277, 35);
        getContentPane().add(lblTitle11);

        medicationComboBox = new JComboBox<>();
        medicationComboBox.setBounds(25, 149, 180, 25);
        getContentPane().add(medicationComboBox);
        
        JButton removeButton = new JButton("Remove");
        removeButton.setForeground(new Color(255, 0, 0));
        removeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        removeButton.setBounds(58, 243, 100, 25);
        getContentPane().add(removeButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RemoveMedication.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 543);
        getContentPane().add(lblNewLabel);
        
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSelectedMedication();
            }
        });
    }

    public void populateComboBox() {
        medicationComboBox.removeAllItems();
        for (Integer code : Hospital.getInstance().getMedications().keySet()) {
            medicationComboBox.addItem(code);
        }
    }

    private void removeSelectedMedication() {
        Integer selectedCode = (Integer) medicationComboBox.getSelectedItem();
        
        if (selectedCode != null) {
            boolean removed = Hospital.getInstance().removeMedication(Hospital.getInstance().getRealMedication(selectedCode));
            if (removed) {
                JOptionPane.showMessageDialog(this, "Medication removed successfully.");
                populateComboBox(); // Refresh the ComboBox after removal
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove Medication.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a medication to remove.");
        }
    }
}
