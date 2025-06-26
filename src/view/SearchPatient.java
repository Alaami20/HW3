package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import control.Hospital;
import model.Patient;
import model.Visit;
import javax.swing.ImageIcon;

public class SearchPatient extends JInternalFrame {

    private static final long serialVersionUID = 34L;
    private JComboBox<Integer> patientComboBox;
    private JLabel patientIdLabel;
    private JLabel patientNameLabel;
    private JLabel patientBirthDateLabel;
    private JLabel patientAddressLabel;
    private JLabel patientPhoneLabel;
    private JLabel patientEmailLabel;
    private JLabel patientHealthFundLabel;
    private JLabel patientBiologicalSexLabel;
    private JLabel visitsLabel;
    private JLabel lblNewLabel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchPatient frame = new SearchPatient();
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
    public SearchPatient() {
        initialize();
    }

    private void initialize() {
        setTitle("Search Patient");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setBounds(100, 100, 609, 558);  // Set the same size as SearchTreatment
        getContentPane().setLayout(null);

        JLabel selectLabel = new JLabel("Select Patient ID:");
        selectLabel.setBounds(30, 20, 180, 25);
        getContentPane().add(selectLabel);

        patientComboBox = new JComboBox<>();
        patientComboBox.setBounds(210, 20, 200, 25);
        getContentPane().add(patientComboBox);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(210, 60, 100, 25);
        getContentPane().add(searchButton);

        patientIdLabel = new JLabel("Patient ID: ");
        patientIdLabel.setBounds(30, 100, 400, 25);
        getContentPane().add(patientIdLabel);

        patientNameLabel = new JLabel("Name: ");
        patientNameLabel.setBounds(30, 130, 400, 25);
        getContentPane().add(patientNameLabel);

        patientBirthDateLabel = new JLabel("Birth Date: ");
        patientBirthDateLabel.setBounds(30, 160, 400, 25);
        getContentPane().add(patientBirthDateLabel);

        patientAddressLabel = new JLabel("Address: ");
        patientAddressLabel.setBounds(30, 190, 400, 25);
        getContentPane().add(patientAddressLabel);

        patientPhoneLabel = new JLabel("Phone: ");
        patientPhoneLabel.setBounds(30, 220, 400, 25);
        getContentPane().add(patientPhoneLabel);

        patientEmailLabel = new JLabel("Email: ");
        patientEmailLabel.setBounds(30, 250, 400, 25);
        getContentPane().add(patientEmailLabel);

        patientHealthFundLabel = new JLabel("Health Fund: ");
        patientHealthFundLabel.setBounds(30, 280, 400, 25);
        getContentPane().add(patientHealthFundLabel);

        patientBiologicalSexLabel = new JLabel("Biological Sex: ");
        patientBiologicalSexLabel.setBounds(30, 310, 400, 25);
        getContentPane().add(patientBiologicalSexLabel);

        visitsLabel = new JLabel("Visits: ");
        visitsLabel.setBounds(30, 340, 400, 100); // Adjusted height to accommodate multiline text
        getContentPane().add(visitsLabel);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SearchPatient.class.getResource("/pics/amjadhospital.png"))); // Use the same background image
        lblNewLabel.setBounds(0, 0, 593, 551);
        getContentPane().add(lblNewLabel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (patientComboBox.getItemCount() > 0) {
                    int selectedPatientId = (int) patientComboBox.getSelectedItem();
                    displayPatientInfo(selectedPatientId);
                }
            }
        });
    }

    // Updated populateComboBox method to accept a set of patient IDs
    public void populateComboBox(Set<Integer> patientIds) {
        patientComboBox.removeAllItems();

        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Integer id : patientIds) {
            patientComboBox.addItem(id);
        }

        if (patientComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No patients found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayPatientInfo(int patientId) {
        if (Hospital.getInstance() == null) {
            JOptionPane.showMessageDialog(this, "Hospital data is not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Patient patient = Hospital.getInstance().getRealPatient(patientId);

        if (patient != null) {
            patientIdLabel.setText("Patient ID: " + patient.getId());
            patientNameLabel.setText("Name: " + patient.getFirstName() + " " + patient.getLastName());
            patientBirthDateLabel.setText("Birth Date: " + dateFormat.format(patient.getBirthDate()));
            patientAddressLabel.setText("Address: " + patient.getAddress());
            patientPhoneLabel.setText("Phone: " + patient.getPhoneNumber());
            patientEmailLabel.setText("Email: " + patient.getEmail());
            patientHealthFundLabel.setText("Health Fund: " + patient.getHealthFund());
            patientBiologicalSexLabel.setText("Biological Sex: " + patient.getBiologicalSex());

            StringBuilder visits = new StringBuilder();
            for (Visit visit : patient.getVisitsList()) {
                visits.append("Visit No: ").append(visit.getNumber())
                      .append(", Start: ").append(dateFormat.format(visit.getStartDate()))
                      .append(", End: ").append(dateFormat.format(visit.getEndDate()))
                      .append(", Problems: ").append(visit.getMedicalProblemsList().toString())
                      .append(", Treatments: ").append(visit.getTreatmentsList().toString())
                      .append("\n");
            }
            visitsLabel.setText("<html><body>" + visits.toString().replace("\n", "<br>") + "</body></html>");

        } else {
            resetLabels();
            JOptionPane.showMessageDialog(this, "Patient not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetLabels() {
        patientIdLabel.setText("Patient ID: ");
        patientNameLabel.setText("Name: ");
        patientBirthDateLabel.setText("Birth Date: ");
        patientAddressLabel.setText("Address: ");
        patientPhoneLabel.setText("Phone: ");
        patientEmailLabel.setText("Email: ");
        patientHealthFundLabel.setText("Health Fund: ");
        patientBiologicalSexLabel.setText("Biological Sex: ");
        visitsLabel.setText("Visits: ");
    }
}
