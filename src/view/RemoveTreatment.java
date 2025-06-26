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

public class RemoveTreatment extends JInternalFrame {

	private static final long serialVersionUID = 31L;
	private JComboBox<Integer> treatmentComboBox;
    private JButton removeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveTreatment frame = new RemoveTreatment();
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
	public RemoveTreatment() {
		setTitle("Remove Treatment");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);
        
        JLabel lblTitle11 = new JLabel("Here you can remove Treatment...");
        lblTitle11.setForeground(new Color(0, 64, 64));
        lblTitle11.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle11.setBounds(162, 35, 281, 35);
        getContentPane().add(lblTitle11);

        treatmentComboBox = new JComboBox<>();
        treatmentComboBox.setBounds(25, 149, 180, 25);
        getContentPane().add(treatmentComboBox);
        
        JButton removeButton = new JButton("Remove");
        removeButton.setForeground(new Color(255, 0, 0));
        removeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        removeButton.setBounds(58, 243, 100, 25);
        getContentPane().add(removeButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RemoveTreatment.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 556);
        getContentPane().add(lblNewLabel);
        
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSelectedTreatment();
            }
        });
    }

    public void populateComboBox() {
        treatmentComboBox.removeAllItems();
        for (Integer serialNumber : Hospital.getInstance().getTreatments().keySet()) {
            treatmentComboBox.addItem(serialNumber);
        }
    }

    private void removeSelectedTreatment() {
        Integer selectedSerialNumber = (Integer) treatmentComboBox.getSelectedItem();
        
        if (selectedSerialNumber != null) {
            boolean removed = Hospital.getInstance().removeTreatment(Hospital.getInstance().getRealTreatment(selectedSerialNumber));
            if (removed) {
                JOptionPane.showMessageDialog(this, "Treatment removed successfully.");
                populateComboBox(); // Refresh the ComboBox after removal
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove Treatment.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a treatment to remove.");
        }
    }
}
