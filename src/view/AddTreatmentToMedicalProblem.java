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
import model.MedicalProblem;
import model.Treatment;
import javax.swing.ImageIcon;

public class AddTreatmentToMedicalProblem extends JInternalFrame {

    private static final long serialVersionUID = 41L;
    private JComboBox<Integer> treatmentComboBox;
    private JComboBox<String> medicalProblemComboBox;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddTreatmentToMedicalProblem frame = new AddTreatmentToMedicalProblem();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddTreatmentToMedicalProblem() {
        initialize();
    }

    private void initialize() {
        setTitle("Add Treatment to Medical Problem");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel selectTreatmentLabel = new JLabel("Select Treatment:");
        selectTreatmentLabel.setBounds(30, 20, 150, 25);
        getContentPane().add(selectTreatmentLabel);

        treatmentComboBox = new JComboBox<>();
        treatmentComboBox.setBounds(180, 20, 200, 25);
        getContentPane().add(treatmentComboBox);

        JLabel selectMedicalProblemLabel = new JLabel("Select Medical Problem:");
        selectMedicalProblemLabel.setBounds(30, 60, 150, 25);
        getContentPane().add(selectMedicalProblemLabel);

        medicalProblemComboBox = new JComboBox<>();
        medicalProblemComboBox.setBounds(180, 60, 200, 25);
        getContentPane().add(medicalProblemComboBox);

        JButton addButton = new JButton("Add");
        addButton.setBounds(180, 100, 100, 25);
        getContentPane().add(addButton);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(AddTreatmentToMedicalProblem.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTreatmentToMedicalProblem();
            }
        });
    }

    public void populateComboBoxes() {
        treatmentComboBox.removeAllItems();
        medicalProblemComboBox.removeAllItems();

        for (Treatment treatment : Hospital.getInstance().getTreatments().values()) {
            treatmentComboBox.addItem(treatment.getSerialNumber());
        }

        for (MedicalProblem medicalProblem : Hospital.getInstance().getMedicalProblems().values()) {
            medicalProblemComboBox.addItem(medicalProblem.getCode());
        }

        if (treatmentComboBox.getItemCount() == 0 || medicalProblemComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No treatments or medical problems found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addTreatmentToMedicalProblem() {
        try {
            int selectedTreatmentNumber = (int) treatmentComboBox.getSelectedItem();
            String selectedMedicalProblemCode = (String) medicalProblemComboBox.getSelectedItem();

            Treatment treatment = Hospital.getInstance().getRealTreatment(selectedTreatmentNumber);
            MedicalProblem medicalProblem = Hospital.getInstance().getMedicalProblem(selectedMedicalProblemCode);

            if (medicalProblem.addTreatment(treatment)) {
                JOptionPane.showMessageDialog(this, "Treatment added to medical problem successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add treatment to medical problem.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Please select valid entries.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
