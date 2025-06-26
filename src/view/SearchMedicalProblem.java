package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.Hospital;
import model.Disease;
import model.Fracture;
import model.Injury;
import model.MedicalProblem;
import model.Treatment;
import javax.swing.ImageIcon;

public class SearchMedicalProblem extends JInternalFrame {

    private static final long serialVersionUID = 39L;
    private JComboBox<String> problemCodeComboBox;
    private JLabel nameLabel;
    private JLabel departmentLabel;
    private JLabel descriptionLabel;
    private JLabel locationLabel;
    private JLabel requiresCastLabel;
    private JLabel commonRecoveryTimeLabel;
    private JLabel treatmentListLabel;
    private String problemType;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchMedicalProblem frame = new SearchMedicalProblem("Disease");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SearchMedicalProblem(String problemType) {
        this.problemType = problemType;
        initialize();
    }

    private void initialize() {
        setTitle("Search " + problemType);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel selectLabel = new JLabel("Select " + problemType + " Code:");
        selectLabel.setBounds(30, 20, 150, 25);
        getContentPane().add(selectLabel);

        problemCodeComboBox = new JComboBox<>();
        problemCodeComboBox.setBounds(180, 20, 200, 25);
        getContentPane().add(problemCodeComboBox);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(180, 60, 100, 25);
        getContentPane().add(searchButton);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(30, 160, 400, 25);
        getContentPane().add(nameLabel);

        departmentLabel = new JLabel("Department: ");
        departmentLabel.setBounds(30, 190, 400, 25);
        getContentPane().add(departmentLabel);

        descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setBounds(30, 250, 400, 25);
        getContentPane().add(descriptionLabel);

        locationLabel = new JLabel("Location: ");
        locationLabel.setBounds(30, 250, 400, 25);
        getContentPane().add(locationLabel);

        requiresCastLabel = new JLabel("Requires Cast: ");
        requiresCastLabel.setBounds(30, 280, 400, 25);
        getContentPane().add(requiresCastLabel);

        commonRecoveryTimeLabel = new JLabel("Common Recovery Time: ");
        commonRecoveryTimeLabel.setBounds(30, 280, 400, 25);
        getContentPane().add(commonRecoveryTimeLabel);

        treatmentListLabel = new JLabel("Treatments: ");
        treatmentListLabel.setBounds(30, 220, 400, 25);
        getContentPane().add(treatmentListLabel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SearchMedicalProblem.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 567);
        getContentPane().add(lblNewLabel);

        // Hide irrelevant labels initially based on the problem type
        if (problemType.equals("Disease")) {
            locationLabel.setVisible(false);
            requiresCastLabel.setVisible(false);
            commonRecoveryTimeLabel.setVisible(false);
        } else if (problemType.equals("Fracture")) {
            descriptionLabel.setVisible(false);
            commonRecoveryTimeLabel.setVisible(false);
        } else if (problemType.equals("Injury")) {
            descriptionLabel.setVisible(false);
            requiresCastLabel.setVisible(false);
        }

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (problemCodeComboBox.getItemCount() > 0) {
                    String selectedCode = (String) problemCodeComboBox.getSelectedItem();
                    displayMedicalProblemInfo(selectedCode);
                }
            }
        });
    }

    public void populateComboBox(List<String> problemCodes) {
        problemCodeComboBox.removeAllItems();

        if (problemCodes == null || problemCodes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No medical problems found.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (String code : problemCodes) {
            problemCodeComboBox.addItem(code);
        }
    }

    private void displayMedicalProblemInfo(String problemCode) {
        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        MedicalProblem problem = Hospital.getInstance().getMedicalProblem(problemCode);

        if (problem != null) {
            nameLabel.setText("Name: " + problem.getName());
            departmentLabel.setText("Department: " + problem.getDepartment().getName());

            if (problem instanceof Disease) {
                Disease disease = (Disease) problem;
                descriptionLabel.setText("Description: " + disease.getDescription());
            } else if (problem instanceof Fracture) {
                Fracture fracture = (Fracture) problem;
                locationLabel.setText("Location: " + fracture.getLocation());
                requiresCastLabel.setText("Requires Cast: " + (fracture.isRequiresCast() ? "Yes" : "No"));
            } else if (problem instanceof Injury) {
                Injury injury = (Injury) problem;
                locationLabel.setText("Location: " + injury.getLocation());
                commonRecoveryTimeLabel.setText("Common Recovery Time: " + injury.getCommonRecoveryTime() + " days");
            }

            // Display treatments
            StringBuilder treatments = new StringBuilder();
            for (Treatment treatment : problem.getTreatmentsList()) {
                treatments.append("Treatment ID: ").append(treatment.getSerialNumber()).append(", ");
            }

            if (treatments.length() > 0) {
                treatments.setLength(treatments.length() - 2); // Remove last comma and space
            } else {
                treatments.append("No treatments available");
            }

            treatmentListLabel.setText("Treatments: " + treatments.toString());

        } else {
            // Reset labels if no medical problem is found
            resetLabels();
            JOptionPane.showMessageDialog(this, "Medical Problem not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetLabels() {
        nameLabel.setText("Name: ");
        departmentLabel.setText("Department: ");
        descriptionLabel.setText("Description: ");
        locationLabel.setText("Location: ");
        requiresCastLabel.setText("Requires Cast: ");
        commonRecoveryTimeLabel.setText("Common Recovery Time: ");
        treatmentListLabel.setText("Treatments: ");
    }
}
