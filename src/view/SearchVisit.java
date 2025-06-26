package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Visit;
import control.Hospital;
import javax.swing.ImageIcon;

public class SearchVisit extends JInternalFrame {

    private static final long serialVersionUID = 36L;
    private JComboBox<Integer> visitComboBox;
    private JLabel visitNumberLabel;
    private JLabel patientIdLabel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JLabel medicalProblemsLabel;
    private JLabel treatmentsLabel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchVisit frame = new SearchVisit();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SearchVisit() {
        initialize();
    }

    private void initialize() {
        setTitle("Search Visit");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);
        getContentPane().setLayout(null);

        JLabel selectLabel = new JLabel("Select Visit Number:");
        selectLabel.setBounds(30, 20, 150, 25);
        getContentPane().add(selectLabel);

        visitComboBox = new JComboBox<>();
        visitComboBox.setBounds(180, 20, 200, 25);
        getContentPane().add(visitComboBox);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(180, 60, 100, 25);
        getContentPane().add(searchButton);

        visitNumberLabel = new JLabel("Visit Number: ");
        visitNumberLabel.setBounds(30, 100, 400, 25);
        getContentPane().add(visitNumberLabel);

        patientIdLabel = new JLabel("Patient ID: ");
        patientIdLabel.setBounds(30, 130, 400, 25);
        getContentPane().add(patientIdLabel);

        startDateLabel = new JLabel("Start Date: ");
        startDateLabel.setBounds(30, 160, 400, 25);
        getContentPane().add(startDateLabel);

        endDateLabel = new JLabel("End Date: ");
        endDateLabel.setBounds(30, 190, 400, 25);
        getContentPane().add(endDateLabel);

        medicalProblemsLabel = new JLabel("Medical Problems: ");
        medicalProblemsLabel.setBounds(30, 220, 400, 25);
        getContentPane().add(medicalProblemsLabel);

        treatmentsLabel = new JLabel("Treatments: ");
        treatmentsLabel.setBounds(30, 250, 400, 25);
        getContentPane().add(treatmentsLabel);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SearchVisit.class.getResource("/pics/amjadhospital.png")));
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (visitComboBox.getItemCount() > 0) {
                    int selectedVisitNumber = (int) visitComboBox.getSelectedItem();
                    displayVisitInfo(selectedVisitNumber);
                }
            }
        });
    }

    public void populateComboBox() {
        visitComboBox.removeAllItems();

        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Visit visit : Hospital.getInstance().getVisits().values()) {
            visitComboBox.addItem(visit.getNumber());
        }

        if (visitComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No visits found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayVisitInfo(int visitNumber) {
        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Visit visit = Hospital.getInstance().getRealVisit(visitNumber);

        if (visit != null) {
            visitNumberLabel.setText("Visit Number: " + visit.getNumber());
            patientIdLabel.setText("Patient ID: " + visit.getPatient().getId());
            startDateLabel.setText("Start Date: " + dateFormat.format(visit.getStartDate()));
            endDateLabel.setText("End Date: " + dateFormat.format(visit.getEndDate()));
            medicalProblemsLabel.setText("Medical Problems: " + visit.getMedicalProblemsList().toString());
            treatmentsLabel.setText("Treatments: " + visit.getTreatmentsList().toString());
        } else {
            resetLabels();
            JOptionPane.showMessageDialog(this, "Visit not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetLabels() {
        visitNumberLabel.setText("Visit Number: ");
        patientIdLabel.setText("Patient ID: ");
        startDateLabel.setText("Start Date: ");
        endDateLabel.setText("End Date: ");
        medicalProblemsLabel.setText("Medical Problems: ");
        treatmentsLabel.setText("Treatments: ");
    }
}
