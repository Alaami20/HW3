package view;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.Hospital;
import model.Medication;
import model.Treatment;
import javax.swing.ImageIcon;

public class AddMedicationToTreatment extends JInternalFrame {

    private static final long serialVersionUID = 42L;
    private JComboBox<Integer> medicationComboBox;
    private JComboBox<Integer> treatmentComboBox;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddMedicationToTreatment frame = new AddMedicationToTreatment();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddMedicationToTreatment() {
        initialize();
    }

    private void initialize() {
        setTitle("Add Medication to Treatment");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel selectMedicationLabel = new JLabel("Select Medication:");
        selectMedicationLabel.setBounds(30, 20, 150, 25);
        getContentPane().add(selectMedicationLabel);

        medicationComboBox = new JComboBox<>();
        medicationComboBox.setBounds(180, 20, 200, 25);
        getContentPane().add(medicationComboBox);

        JLabel selectTreatmentLabel = new JLabel("Select Treatment:");
        selectTreatmentLabel.setBounds(30, 60, 150, 25);
        getContentPane().add(selectTreatmentLabel);

        treatmentComboBox = new JComboBox<>();
        treatmentComboBox.setBounds(180, 60, 200, 25);
        getContentPane().add(treatmentComboBox);

        JButton addButton = new JButton("Add");
        addButton.setBounds(180, 100, 100, 25);
        getContentPane().add(addButton);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(AddMedicationToTreatment.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedicationToTreatment();
            }
        });
    }

    public void populateComboBoxes() {
        medicationComboBox.removeAllItems();
        treatmentComboBox.removeAllItems();

        for (Medication medication : Hospital.getInstance().getMedications().values()) {
            medicationComboBox.addItem(medication.getCode());
        }

        for (Treatment treatment : Hospital.getInstance().getTreatments().values()) {
            treatmentComboBox.addItem(treatment.getSerialNumber());
        }

        if (medicationComboBox.getItemCount() == 0 || treatmentComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No medications or treatments found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addMedicationToTreatment() {
        try {
            int selectedMedicationCode = (int) medicationComboBox.getSelectedItem();
            int selectedTreatmentNumber = (int) treatmentComboBox.getSelectedItem();

            Medication medication = Hospital.getInstance().getRealMedication(selectedMedicationCode);
            Treatment treatment = Hospital.getInstance().getRealTreatment(selectedTreatmentNumber);

            if (treatment.addMedication(medication)) {
                JOptionPane.showMessageDialog(this, "Medication added to treatment successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add medication to treatment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Please select valid entries.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
