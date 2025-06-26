package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import control.Hospital;
import model.Medication;

import javax.swing.ImageIcon;

public class SearchMedication extends JInternalFrame {

    private static final long serialVersionUID = 38L;
    private JComboBox<Integer> medicationComboBox;
    private JLabel medicationCodeLabel;
    private JLabel nameLabel;
    private JLabel dosageLabel;
    private JLabel numberOfDoseLabel;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchMedication frame = new SearchMedication();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SearchMedication() {
        initialize();
    }

    private void initialize() {
        setTitle("Search Medication");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel selectLabel = new JLabel("Select Medication Code:");
        selectLabel.setBounds(30, 20, 180, 25);
        getContentPane().add(selectLabel);

        medicationComboBox = new JComboBox<>();
        medicationComboBox.setBounds(210, 20, 200, 25);
        getContentPane().add(medicationComboBox);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(210, 60, 100, 25);
        getContentPane().add(searchButton);

        medicationCodeLabel = new JLabel("Medication Code: ");
        medicationCodeLabel.setBounds(30, 100, 400, 25);
        getContentPane().add(medicationCodeLabel);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(30, 130, 400, 25);
        getContentPane().add(nameLabel);

        dosageLabel = new JLabel("Dosage: ");
        dosageLabel.setBounds(30, 160, 400, 25);
        getContentPane().add(dosageLabel);

        numberOfDoseLabel = new JLabel("Number of Doses: ");
        numberOfDoseLabel.setBounds(30, 190, 400, 25);
        getContentPane().add(numberOfDoseLabel);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SearchMedication.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (medicationComboBox.getItemCount() > 0) {
                    int selectedMedicationCode = (int) medicationComboBox.getSelectedItem();
                    displayMedicationInfo(selectedMedicationCode);
                }
            }
        });
    }

    // Updated populateComboBox method to accept a list of medication codes
    public void populateComboBox(Set<Integer> medicationCodes) {
        medicationComboBox.removeAllItems();

        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Integer code : medicationCodes) {
            medicationComboBox.addItem(code);
        }

        if (medicationComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No medications found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayMedicationInfo(int medicationCode) {
        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Medication medication = Hospital.getInstance().getRealMedication(medicationCode);

        if (medication != null) {
            medicationCodeLabel.setText("Medication Code: " + medication.getCode());
            nameLabel.setText("Name: " + medication.getName());
            dosageLabel.setText("Dosage: " + medication.getDosage());
            numberOfDoseLabel.setText("Number of Doses: " + medication.getNumberOfDose());
        } else {
            resetLabels();
            JOptionPane.showMessageDialog(this, "Medication not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetLabels() {
        medicationCodeLabel.setText("Medication Code: ");
        nameLabel.setText("Name: ");
        dosageLabel.setText("Dosage: ");
        numberOfDoseLabel.setText("Number of Doses: ");
    }
}
