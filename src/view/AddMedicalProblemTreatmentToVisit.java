package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import control.Hospital;
import model.MedicalProblem;
import model.Treatment;
import model.Visit;

public class AddMedicalProblemTreatmentToVisit extends JInternalFrame {

    private static final long serialVersionUID = 43L;
    private JComboBox<Integer> visitComboBox;
    private JComboBox<String> medicalProblemComboBox;
    private JComboBox<Integer> treatmentComboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddMedicalProblemTreatmentToVisit frame = new AddMedicalProblemTreatmentToVisit();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddMedicalProblemTreatmentToVisit() {
        initialize();
        
        // Adding InternalFrameListener to populate the combo boxes when the frame is opened
        this.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                populateComboBoxes();
            }
        });
    }

    private void initialize() {
        setTitle("Add Medical Problem/Treatment to Visit");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel visitLabel = new JLabel("Select Visit:");
        visitLabel.setBounds(30, 20, 150, 25);
        getContentPane().add(visitLabel);

        visitComboBox = new JComboBox<>();
        visitComboBox.setBounds(180, 20, 200, 25);
        getContentPane().add(visitComboBox);

        JLabel medicalProblemLabel = new JLabel("Select Medical Problem:");
        medicalProblemLabel.setBounds(30, 60, 150, 25);
        getContentPane().add(medicalProblemLabel);

        medicalProblemComboBox = new JComboBox<>();
        medicalProblemComboBox.setBounds(180, 60, 200, 25);
        getContentPane().add(medicalProblemComboBox);

        JLabel treatmentLabel = new JLabel("Select Treatment:");
        treatmentLabel.setBounds(30, 100, 150, 25);
        getContentPane().add(treatmentLabel);

        treatmentComboBox = new JComboBox<>();
        treatmentComboBox.setBounds(180, 100, 200, 25);
        getContentPane().add(treatmentComboBox);

        JButton addButton = new JButton("Add to Visit");
        addButton.setBounds(180, 140, 150, 25);
        getContentPane().add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedicalProblemOrTreatmentToVisit();
            }
        });

        // Background
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(AddMedicalProblemTreatmentToVisit.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);
    }

    private void populateComboBoxes() {
        visitComboBox.removeAllItems();
        medicalProblemComboBox.removeAllItems();
        treatmentComboBox.removeAllItems();

        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Visit visit : Hospital.getInstance().getVisits().values()) {
            visitComboBox.addItem(visit.getNumber());
        }

        List<String> medicalProblemCodes = Hospital.getInstance().getMedicalProblems().keySet().stream().toList();
        for (String code : medicalProblemCodes) {
            medicalProblemComboBox.addItem(code);
        }

        List<Integer> treatmentNumbers = Hospital.getInstance().getTreatments().keySet().stream().toList();
        for (Integer number : treatmentNumbers) {
            treatmentComboBox.addItem(number);
        }

        if (visitComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No visits found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        if (medicalProblemComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No medical problems found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        if (treatmentComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No treatments found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addMedicalProblemOrTreatmentToVisit() {
        if (visitComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a visit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer selectedVisitNumber = (Integer) visitComboBox.getSelectedItem();
        String selectedMedicalProblemCode = (String) medicalProblemComboBox.getSelectedItem();
        Integer selectedTreatmentNumber = (Integer) treatmentComboBox.getSelectedItem();

        if (selectedMedicalProblemCode == null && selectedTreatmentNumber == null) {
            JOptionPane.showMessageDialog(this, "Please select either a medical problem or a treatment.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Visit visit = Hospital.getInstance().getRealVisit(selectedVisitNumber);

        if (selectedMedicalProblemCode != null) {
            MedicalProblem medicalProblem = Hospital.getInstance().getMedicalProblem(selectedMedicalProblemCode);
            visit.addMedicalProblem(medicalProblem);
        }

        if (selectedTreatmentNumber != null) {
            Treatment treatment = Hospital.getInstance().getRealTreatment(selectedTreatmentNumber);
            visit.addTreatment(treatment);
        }

        JOptionPane.showMessageDialog(this, "Medical problem and/or treatment successfully added to visit.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
