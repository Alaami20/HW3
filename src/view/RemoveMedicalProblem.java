package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.ImageIcon;

public class RemoveMedicalProblem extends JInternalFrame {

    private static final long serialVersionUID = 27L;
    private JComboBox<String> problemCodeComboBox;
    private JButton removeButton;
    private JLabel codeLabel;
    private String medicalProblemType;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Pass the medical problem type to the constructor
                    String problemType = "Disease"; // Example type, you can change this to "Fracture" or "Injury"
                    RemoveMedicalProblem frame = new RemoveMedicalProblem(problemType);
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
    public RemoveMedicalProblem(String type) {
        this.medicalProblemType = type;
        setTitle("Remove " + type);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel lblTitle11 = new JLabel("Here you can remove " + type + "...");
        lblTitle11.setForeground(new Color(0, 64, 64));
        lblTitle11.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle11.setBounds(162, 35, 268, 35);
        getContentPane().add(lblTitle11);

        problemCodeComboBox = new JComboBox<>();
        problemCodeComboBox.setBounds(25, 149, 180, 25);
        getContentPane().add(problemCodeComboBox);

        removeButton = new JButton("Remove");
        removeButton.setForeground(new Color(255, 0, 0));
        removeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        removeButton.setBounds(58, 243, 100, 25);
        getContentPane().add(removeButton);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RemoveMedicalProblem.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 542);
        getContentPane().add(lblNewLabel);

        loadMedicalProblems();

        // Remove the selected medical problem
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedMedicalProblem();
            }
        });
    }

    // Method to populate the ComboBox with problem codes
    public void populateComboBox(ArrayList<String> problemCodes) {
        problemCodeComboBox.removeAllItems();
        for (String code : problemCodes) {
            problemCodeComboBox.addItem(code);
        }
    }

    private void loadMedicalProblems() {
        problemCodeComboBox.removeAllItems();
        ArrayList<MedicalProblem> problems = getProblemsByType(medicalProblemType);
        for (MedicalProblem problem : problems) {
            problemCodeComboBox.addItem(problem.getCode());
        }
    }

    private ArrayList<MedicalProblem> getProblemsByType(String type) {
        Hospital hospital = Hospital.getInstance();
        ArrayList<MedicalProblem> problems = new ArrayList<>();
        switch (type) {
            case "Disease":
                for (MedicalProblem problem : hospital.getMedicalProblems().values()) {
                    if (problem instanceof Disease) {
                        problems.add(problem);
                    }
                }
                break;
            case "Fracture":
                for (MedicalProblem problem : hospital.getMedicalProblems().values()) {
                    if (problem instanceof Fracture) {
                        problems.add(problem);
                    }
                }
                break;
            case "Injury":
                for (MedicalProblem problem : hospital.getMedicalProblems().values()) {
                    if (problem instanceof Injury) {
                        problems.add(problem);
                    }
                }
                break;
        }
        return problems;
    }

    private void removeSelectedMedicalProblem() {
        String selectedCode = (String) problemCodeComboBox.getSelectedItem();

        if (selectedCode != null) {
            Hospital hospital = Hospital.getInstance();
            boolean removed = false;
            switch (medicalProblemType) {
                case "Disease":
                    removed = hospital.removeDisease(hospital.getRealDisease(selectedCode));
                    break;
                case "Fracture":
                    removed = hospital.removeFracture(hospital.getRealFracture(selectedCode));
                    break;
                case "Injury":
                    removed = hospital.removeInjury(hospital.getRealInjury(selectedCode));
                    break;
            }

            if (removed) {
                JOptionPane.showMessageDialog(this, medicalProblemType + " removed successfully.");
                loadMedicalProblems();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove " + medicalProblemType + ".");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a " + medicalProblemType + " to remove.");
        }
    }
}
