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
import model.Treatment;
import javax.swing.ImageIcon;

public class SearchTreatment extends JInternalFrame {

    private static final long serialVersionUID = 37L;
    private JComboBox<Integer> treatmentComboBox;
    private JLabel treatmentNumberLabel;
    private JLabel descriptionLabel;
    private JLabel medicationsLabel;
    private JLabel doctorsLabel;
    private JLabel medicalProblemsLabel;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchTreatment frame = new SearchTreatment();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SearchTreatment() {
        initialize();
    }

    private void initialize() {
        setTitle("Search Treatment");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel selectLabel = new JLabel("Select Treatment Number:");
        selectLabel.setBounds(30, 20, 180, 25);
        getContentPane().add(selectLabel);

        treatmentComboBox = new JComboBox<>();
        treatmentComboBox.setBounds(210, 20, 200, 25);
        getContentPane().add(treatmentComboBox);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(210, 60, 100, 25);
        getContentPane().add(searchButton);

        treatmentNumberLabel = new JLabel("Treatment Number: ");
        treatmentNumberLabel.setBounds(30, 100, 400, 25);
        getContentPane().add(treatmentNumberLabel);

        descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setBounds(30, 130, 400, 25);
        getContentPane().add(descriptionLabel);

        medicationsLabel = new JLabel("Medications: ");
        medicationsLabel.setBounds(30, 160, 400, 25);
        getContentPane().add(medicationsLabel);

        doctorsLabel = new JLabel("Doctors: ");
        doctorsLabel.setBounds(30, 190, 400, 25);
        getContentPane().add(doctorsLabel);

        medicalProblemsLabel = new JLabel("Medical Problems: ");
        medicalProblemsLabel.setBounds(30, 220, 400, 25);
        getContentPane().add(medicalProblemsLabel);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SearchTreatment.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (treatmentComboBox.getItemCount() > 0) {
                    int selectedTreatmentNumber = (int) treatmentComboBox.getSelectedItem();
                    displayTreatmentInfo(selectedTreatmentNumber);
                }
            }
        });
    }

    // Updated populateComboBox method to accept a list of treatment serial numbers
    public void populateComboBox(Set<Integer> treatmentSerialNumbers) {
        treatmentComboBox.removeAllItems();

        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Integer serialNumber : treatmentSerialNumbers) {
            treatmentComboBox.addItem(serialNumber);
        }

        if (treatmentComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No treatments found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayTreatmentInfo(int treatmentNumber) {
        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Treatment treatment = Hospital.getInstance().getRealTreatment(treatmentNumber);

        if (treatment != null) {
            treatmentNumberLabel.setText("Treatment Number: " + treatment.getSerialNumber());
            descriptionLabel.setText("Description: " + treatment.getDescription());

            StringBuilder medications = new StringBuilder();
            treatment.getMedicationsList().forEach(med -> medications.append(med.getName()).append(", "));
            medicationsLabel.setText("Medications: " + (medications.length() > 0 ? medications.substring(0, medications.length() - 2) : "None"));

            StringBuilder doctors = new StringBuilder();
            treatment.getDoctorsList().forEach(doc -> doctors.append(doc.getFirstName()).append(" ").append(doc.getLastName()).append(", "));
            doctorsLabel.setText("Doctors: " + (doctors.length() > 0 ? doctors.substring(0, doctors.length() - 2) : "None"));

            StringBuilder medicalProblems = new StringBuilder();
            treatment.getMedicalProblemsList().forEach(mp -> medicalProblems.append(mp.getName()).append(", "));
            medicalProblemsLabel.setText("Medical Problems: " + (medicalProblems.length() > 0 ? medicalProblems.substring(0, medicalProblems.length() - 2) : "None"));

        } else {
            resetLabels();
            JOptionPane.showMessageDialog(this, "Treatment not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetLabels() {
        treatmentNumberLabel.setText("Treatment Number: ");
        descriptionLabel.setText("Description: ");
        medicationsLabel.setText("Medications: ");
        doctorsLabel.setText("Doctors: ");
        medicalProblemsLabel.setText("Medical Problems: ");
    }
}
