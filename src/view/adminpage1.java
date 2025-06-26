package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import control.Hospital;
import enums.Specialization;
import model.Department;
import model.Doctor;
import model.Nurse;
import model.StaffMember;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class adminpage1 extends JFrame {

	private static final long serialVersionUID = 24L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel resultLabel;
    private JSpinner dateSpinner;
    private JLabel admin4;
    private JTextField admin7;
    private JLabel intensiveCareCountLabel;
    private JTextField avgSalaryTextField;
    private JLabel complianceStatusLabel;
    private String role;
    private AddDoctor addDoctorFrame;
    private AddPatient addPatientFrame;
    private AddDepartment addDepartmentFrame;
    private AddVisit addVisitFrame;
    private AddMedicalProblem addMedicalProblemFrame;
    private AddTreatment addTreatmentFrame;
    private AddMedication addMedicationFrame;
    private RemoveStaffMember removeDoctorFrame;
    private RemoveStaffMember removeNurseFrame;
    private RemoveDepartment removeDepartmentFrame;
    private RemovePatient removePatientFrame;
    private RemoveVisit removeVisitFrame;
    private RemoveMedicalProblem removeDiseaseFrame;
    private RemoveMedicalProblem removeFractureFrame;
    private RemoveMedicalProblem removeInjuryFrame;
    private RemoveTreatment removeTreatmentFrame;
    private RemoveMedication removeMedicationFrame;
    private SearchStaffMember searchDoctorFrame;
    private SearchStaffMember searchNurseFrame;
    private SearchDepartment searchDepartmentFrame;
    private SearchPatient searchPatientFrame;
    private SearchVisit searchVisitFrame;
    private SearchMedicalProblem searchDiseaseFrame;
    private SearchMedicalProblem searchFractureFrame;
    private SearchMedicalProblem searchInjuryFrame;
    private SearchTreatment searchTreatmentFrame;
    private SearchMedication searchMedicationFrame;
    private AddMedicationToTreatment addMedicationToTreatmentFrame;
    private AddTreatmentToMedicalProblem addTreatmentToMedicalProblemFrame;
    private AddMedicalProblemTreatmentToVisit addMedicalProblemTreatmentToVisitFrame;
    private EditDoctor editDoctorFrame;
    private EditNurse editNurseFrame;
    private Doctor loggedInDoctor;
    private Nurse loggedInNurse; 
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String role = "doctor";
                    StaffMember loggedInStaffMember=null;
                    adminpage1 frame = new adminpage1(role, loggedInStaffMember);
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
	public adminpage1(String role, StaffMember loggedInStaffMember) {
		this.setRole(role);
		System.out.println("Role: " + role);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addDoctorFrame = new AddDoctor();
		addDoctorFrame.setLocation(-11, 11);
	    contentPane.add(addDoctorFrame);
	    addDoctorFrame.setVisible(false);
	    
	    addPatientFrame = new AddPatient(); 
        addPatientFrame.setLocation(-11, 11);
        contentPane.add(addPatientFrame);
        addPatientFrame.setVisible(false);
        
        addDepartmentFrame = new AddDepartment(); // Initialize AddDepartment frame
        addDepartmentFrame.setLocation(-11, 11);
        contentPane.add(addDepartmentFrame);
        addDepartmentFrame.setVisible(false);
        
        addVisitFrame = new AddVisit(); // Initialize AddVisit frame
        addVisitFrame.setLocation(-11, 11);
        contentPane.add(addVisitFrame);
        addVisitFrame.setVisible(false);
        
        addMedicalProblemFrame = new AddMedicalProblem(); // Initialize AddMedicalProblem frame
        addMedicalProblemFrame.setLocation(-11, 11);
        contentPane.add(addMedicalProblemFrame);
        addMedicalProblemFrame.setVisible(false);
        
        addTreatmentFrame = new AddTreatment(); // Initialize the AddTreatment frame
        addTreatmentFrame.setLocation(-11, 11);
        contentPane.add(addTreatmentFrame);
        addTreatmentFrame.setVisible(false);
        
        addMedicationFrame = new AddMedication(); // Initialize the AddMedication frame
        addMedicationFrame.setLocation(-11, 11);
        contentPane.add(addMedicationFrame);
        addMedicationFrame.setVisible(false);
        
        removeDoctorFrame = new RemoveStaffMember("Doctor");
        removeDoctorFrame.setLocation(-11, 11);
        contentPane.add(removeDoctorFrame);
        removeDoctorFrame.setVisible(false);

        removeNurseFrame = new RemoveStaffMember("Nurse");
        removeNurseFrame.setLocation(-11, 11);
        contentPane.add(removeNurseFrame);
        removeNurseFrame.setVisible(false);
        
        removeDepartmentFrame = new RemoveDepartment();
        removeDepartmentFrame.setLocation(-11, 11);
        contentPane.add(removeDepartmentFrame);
        removeDepartmentFrame.setVisible(false);
        
        removePatientFrame = new RemovePatient();
        removePatientFrame.setLocation(-11, 11);
        contentPane.add(removePatientFrame);
        removePatientFrame.setVisible(false);
        
        removeVisitFrame = new RemoveVisit();
        removeVisitFrame.setLocation(-11, 11);
        contentPane.add(removeVisitFrame);
        removeVisitFrame.setVisible(false);
        
        removeDiseaseFrame = new RemoveMedicalProblem("Disease");
        removeDiseaseFrame.setLocation(-11, 11);
        contentPane.add(removeDiseaseFrame);
        removeDiseaseFrame.setVisible(false);

        removeFractureFrame = new RemoveMedicalProblem("Fracture");
        removeFractureFrame.setLocation(-11, 11);
        contentPane.add(removeFractureFrame);
        removeFractureFrame.setVisible(false);

        removeInjuryFrame = new RemoveMedicalProblem("Injury");
        removeInjuryFrame.setLocation(-11, 11);
        contentPane.add(removeInjuryFrame);
        removeInjuryFrame.setVisible(false);
        
        removeTreatmentFrame = new RemoveTreatment();
        removeTreatmentFrame.setLocation(-11, 11);
        contentPane.add(removeTreatmentFrame);
        removeTreatmentFrame.setVisible(false);
        
        removeMedicationFrame = new RemoveMedication();
        removeMedicationFrame.setLocation(-11, 11);
        contentPane.add(removeMedicationFrame);
        removeMedicationFrame.setVisible(false);
        
        searchDoctorFrame = new SearchStaffMember("Doctor");
        searchDoctorFrame.setLocation(-11, 11);
        contentPane.add(searchDoctorFrame);
        searchDoctorFrame.setVisible(false);

        searchNurseFrame = new SearchStaffMember("Nurse");
        searchNurseFrame.setLocation(-11, 11);
        contentPane.add(searchNurseFrame);
        searchNurseFrame.setVisible(false);
        
        searchDepartmentFrame = new SearchDepartment(); // Initialize SearchDepartment frame
        searchDepartmentFrame.setLocation(-11, 11);
        contentPane.add(searchDepartmentFrame);
        searchDepartmentFrame.setVisible(false);
        
        searchPatientFrame = new SearchPatient();
        searchPatientFrame.setLocation(-11, 11);
        contentPane.add(searchPatientFrame);
        searchPatientFrame.setVisible(false);
        
        searchVisitFrame = new SearchVisit();
        searchVisitFrame.setLocation(-11, 11);
        contentPane.add(searchVisitFrame);
        searchVisitFrame.setVisible(false);
        
        searchDiseaseFrame = new SearchMedicalProblem("Disease");
        searchDiseaseFrame.setLocation(-11, 11);
        contentPane.add(searchDiseaseFrame);
        searchDiseaseFrame.setVisible(false);

        searchFractureFrame = new SearchMedicalProblem("Fracture");
        searchFractureFrame.setLocation(-11, 11);
        contentPane.add(searchFractureFrame);
        searchFractureFrame.setVisible(false);

        searchInjuryFrame = new SearchMedicalProblem("Injury");
        searchInjuryFrame.setLocation(-11, 11);
        contentPane.add(searchInjuryFrame);
        searchInjuryFrame.setVisible(false);
        
        searchTreatmentFrame = new SearchTreatment();
        searchTreatmentFrame.setLocation(-11, 11);
        contentPane.add(searchTreatmentFrame);
        searchTreatmentFrame.setVisible(false);
        
        searchMedicationFrame = new SearchMedication();
        searchMedicationFrame.setLocation(-11, 11);
        contentPane.add(searchMedicationFrame);
        searchMedicationFrame.setVisible(false);
        
        addMedicationToTreatmentFrame = new AddMedicationToTreatment();
        addMedicationToTreatmentFrame.setLocation(-11, 11);
        contentPane.add(addMedicationToTreatmentFrame);
        addMedicationToTreatmentFrame.setVisible(false);
		
        addTreatmentToMedicalProblemFrame = new AddTreatmentToMedicalProblem();
        addTreatmentToMedicalProblemFrame.setLocation(-11, 11);
        contentPane.add(addTreatmentToMedicalProblemFrame);
        addTreatmentToMedicalProblemFrame.setVisible(false);
        
        addMedicalProblemTreatmentToVisitFrame = new AddMedicalProblemTreatmentToVisit();
        addMedicalProblemTreatmentToVisitFrame.setLocation(-11, 11);
        contentPane.add(addMedicalProblemTreatmentToVisitFrame);
        addMedicalProblemTreatmentToVisitFrame.setVisible(false);
        
        if (role.equals("doctor") && loggedInStaffMember instanceof Doctor) {
            loggedInDoctor = (Doctor) loggedInStaffMember;
            editDoctorFrame = new EditDoctor(loggedInDoctor);
            editDoctorFrame.setLocation(-11, 11);
            contentPane.add(editDoctorFrame);
            editDoctorFrame.setVisible(false);
        } else if (role.equals("Nurse") && loggedInStaffMember instanceof Nurse) {
            loggedInNurse = (Nurse) loggedInStaffMember;
            editNurseFrame = new EditNurse(loggedInNurse);
            editNurseFrame.setLocation(-11, 11);
            contentPane.add(editNurseFrame);
            editNurseFrame.setVisible(false);
        } else if (role.equals("Admin")) {
            // No need to initialize edit frames for Admin
            System.out.println("Admin logged in");
        }


		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 598, 19);
		contentPane.add(menuBar);
		
		JButton btnRefresh = new JButton("REFRESH");
		menuBar.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        refreshData11();
		    }
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));

		
		  menuBar.add(Box.createHorizontalGlue());

		JMenu mnNewMenu = new JMenu("Add");
		menuBar.add(mnNewMenu);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		if (role.equals("Admin")) {
		JMenu mnNewMenu_5 = new JMenu("Staff Member");
		mnNewMenu.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Doctor");
		mnNewMenu_5.add(mntmNewMenuItem_10);
		
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addDoctorFrame.setVisible(true); // Make the frame visible
		        addDoctorFrame.showDoctorFields(); // Show doctor-specific fields
		        try {
		            addDoctorFrame.setSelected(true); // Bring the frame to focus
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		        addDoctorFrame.addInternalFrameListener(new InternalFrameAdapter() {
		            @Override
		            public void internalFrameClosed(InternalFrameEvent e) {
		                refreshData();
		            }
		        });
		    }
		});
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Nurse");
		mnNewMenu_5.add(mntmNewMenuItem_16);
		
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addDoctorFrame.setVisible(true); // Make the frame visible
		        addDoctorFrame.showNurseFields(); // Show nurse-specific fields
		        try {
		            addDoctorFrame.setSelected(true); // Bring the frame to focus
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		        addDoctorFrame.addInternalFrameListener(new InternalFrameAdapter() {
		            @Override
		            public void internalFrameClosed(InternalFrameEvent e) {
		                refreshData(); // Refresh data after closing the frame
		            }
		        });
		    }
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Department");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addDepartmentFrame.setVisible(true); // Make the AddDepartment frame visible
		        try {
		            addDepartmentFrame.setSelected(true); // Bring the frame to focus
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
	}
		
	if (role.equals("Admin") || role.equals("Nurse")) {
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Patient");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPatientFrame.setVisible(true); 
                try {
                    addPatientFrame.setSelected(true); 
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		JMenuItem mntmNewMenuItem_22 = new JMenuItem("Visit");
		mnNewMenu.add(mntmNewMenuItem_22);
		
		mntmNewMenuItem_22.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addVisitFrame.setVisible(true); // Make the AddVisit frame visible
		        try {
		            addVisitFrame.setSelected(true); // Bring the frame to focus
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
	}
		JMenuItem mntmNewMenuItem_32 = new JMenuItem("Medical Problem");
		mnNewMenu.add(mntmNewMenuItem_32);
		
		mnNewMenu.add(mntmNewMenuItem_32);
        mntmNewMenuItem_32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMedicalProblemFrame.setVisible(true); // Make the AddMedicalProblem frame visible
                try {
                    addMedicalProblemFrame.setSelected(true); // Bring the frame to focus
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Treatment");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTreatmentFrame.setVisible(true); // Show the AddTreatment frame
                try {
                    addTreatmentFrame.setSelected(true); // Bring it to focus
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		JMenuItem mntmNewMenuItem_27 = new JMenuItem("Medication");
		mnNewMenu.add(mntmNewMenuItem_27);
		mntmNewMenuItem_27.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMedicationFrame.setVisible(true); // Show the AddMedication frame
                try {
                    addMedicationFrame.setSelected(true); // Bring it to focus
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		if (role.equals("Admin") || role.equals("doctor")) {
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Medication To Treatment");
		mnNewMenu.add(mntmNewMenuItem_17);
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addMedicationToTreatmentFrame.setVisible(true); // Show the AddMedicationToTreatment frame
		        try {
		            addMedicationToTreatmentFrame.setSelected(true); // Bring it to focus
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Treatment To MedicalProblem");
		mnNewMenu.add(mntmNewMenuItem_18);
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addTreatmentToMedicalProblemFrame.setVisible(true); // Show the AddTreatmentToMedicalProblem frame
		        try {
		            addTreatmentToMedicalProblemFrame.setSelected(true); // Bring it to focus
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("MedicalProblem And Treatment To Visit");
		mnNewMenu.add(mntmNewMenuItem_19);
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addMedicalProblemTreatmentToVisitFrame.setVisible(true); // Show the AddMedicalProblemTreatmentToVisit frame
		        try {
		            addMedicalProblemTreatmentToVisitFrame.setSelected(true); // Bring it to focus
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
	}
		
		
		if (role.equals("Admin")) {
		JMenu mnNewMenu_1 = new JMenu("Remove");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JMenu mnNewMenu_7 = new JMenu("Staff Member");
		mnNewMenu_1.add(mnNewMenu_7);
		
		JMenuItem mntmRemoveDoctor = new JMenuItem("Doctor");
		mntmRemoveDoctor.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removeDoctorFrame.populateComboBox("Doctor"); // Populate ComboBox with doctors
		        removeDoctorFrame.setVisible(true);
		        try {
		            removeDoctorFrame.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		        removeDoctorFrame.addInternalFrameListener(new InternalFrameAdapter() {
		            @Override
		            public void internalFrameClosed(InternalFrameEvent e) {
		                refreshData(); // Refresh data after closing the frame
		            }
		        });
		    }
		});
		mnNewMenu_7.add(mntmRemoveDoctor);
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Nurse");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        removeNurseFrame.populateComboBox("Nurse"); // Populate ComboBox with nurses
		        removeNurseFrame.setVisible(true);
		        try {
		            removeNurseFrame.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		        removeNurseFrame.addInternalFrameListener(new InternalFrameAdapter() {
		            @Override
		            public void internalFrameClosed(InternalFrameEvent e) {
		                refreshData(); // Refresh data after closing the frame
		            }
		        });
		    }
		});
		mnNewMenu_7.add(mntmNewMenuItem_21);
		
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Department");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            removeDepartmentFrame.populateComboBox(); // Populate ComboBox with department numbers
	            removeDepartmentFrame.setVisible(true);
	            try {
	                removeDepartmentFrame.setSelected(true);
	            } catch (java.beans.PropertyVetoException ex) {
	                ex.printStackTrace();
	            }
	        }
	    });
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Patient");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removePatientFrame.populateComboBox(); // Populate ComboBox with patients
		        removePatientFrame.setVisible(true);   // Show the RemovePatient frame
		        try {
		            removePatientFrame.setSelected(true); // Bring the frame to focus
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Visit");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeVisitFrame.populateComboBox(); // Populate the ComboBox with patient IDs
                removeVisitFrame.setVisible(true);
                try {
                    removeVisitFrame.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		JMenu mnNewMenu_8 = new JMenu("Medical Problem");
		mnNewMenu_1.add(mnNewMenu_8);
		
		JMenuItem mntmRemoveDisease = new JMenuItem("Disease");
		mntmRemoveDisease.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removeDiseaseFrame.populateComboBox(new ArrayList<>(Hospital.getInstance().getDiseaseCodes()));
		        removeDiseaseFrame.setVisible(true);
		        try {
		            removeDiseaseFrame.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		mnNewMenu_8.add(mntmRemoveDisease);
		
		JMenuItem mntmNewMenuItem_24 = new JMenuItem("Fracture");
		mntmNewMenuItem_24.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removeFractureFrame.populateComboBox(new ArrayList<>(Hospital.getInstance().getFractureCodes()));
		        removeFractureFrame.setVisible(true);
		        try {
		            removeFractureFrame.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		mnNewMenu_8.add(mntmNewMenuItem_24);
		
		JMenuItem mntmNewMenuItem_25 = new JMenuItem("Injury");
		mntmNewMenuItem_25.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removeInjuryFrame.populateComboBox(new ArrayList<>(Hospital.getInstance().getInjuryCodes()));
		        removeInjuryFrame.setVisible(true);
		        try {
		            removeInjuryFrame.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		mnNewMenu_8.add(mntmNewMenuItem_25);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Treatment");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removeTreatmentFrame.populateComboBox(); // Populate ComboBox with treatment serial numbers
		        removeTreatmentFrame.setVisible(true);
		        try {
		            removeTreatmentFrame.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_28 = new JMenuItem("Medication");
		mntmNewMenuItem_28.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removeMedicationFrame.populateComboBox(); // Populate ComboBox with medication codes
		        removeMedicationFrame.setVisible(true);
		        try {
		            removeMedicationFrame.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		mnNewMenu_1.add(mntmNewMenuItem_28);
		}
		
		
		  JMenu mnNewMenu_2 = new JMenu("Search");
		  menuBar.add(mnNewMenu_2);
		  mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		  
			if (role.equals("Admin")) {
		  JMenu mnNewMenu_4 = new JMenu("Staff Member");
		  mnNewMenu_2.add(mnNewMenu_4);
		  
		  JMenuItem mntmNewMenuItem_7 = new JMenuItem("Doctor");
		  mntmNewMenuItem_7.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            searchDoctorFrame.populateComboBox("Doctor");
		            searchDoctorFrame.setVisible(true);
		            try {
		                searchDoctorFrame.setSelected(true);
		            } catch (java.beans.PropertyVetoException ex) {
		                ex.printStackTrace();
		            }
		        }
		    });
		  mnNewMenu_4.add(mntmNewMenuItem_7);
		  
		  JMenuItem mntmNewMenuItem_8 = new JMenuItem("Nurse");
		  mntmNewMenuItem_8.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            searchNurseFrame.populateComboBox("Nurse");
		            searchNurseFrame.setVisible(true);
		            try {
		                searchNurseFrame.setSelected(true);
		            } catch (java.beans.PropertyVetoException ex) {
		                ex.printStackTrace();
		            }
		        }
		    });
		  mnNewMenu_4.add(mntmNewMenuItem_8);
			}
			
		  JMenuItem mntmNewMenuItem_9 = new JMenuItem("Department");
		  mnNewMenu_2.add(mntmNewMenuItem_9);
	        mntmNewMenuItem_9.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                searchDepartmentFrame.populateComboBox(); // Populate ComboBox with department numbers
	                searchDepartmentFrame.setVisible(true);
	                try {
	                    searchDepartmentFrame.setSelected(true);
	                } catch (java.beans.PropertyVetoException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
		  
		  JMenuItem mntmNewMenuItem_12 = new JMenuItem("Patient");
		  mnNewMenu_2.add(mntmNewMenuItem_12);
		  mntmNewMenuItem_12.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        // Retrieve the patient IDs from the Hospital instance
			        Set<Integer> patientIds = Hospital.getInstance().getPatients().keySet();

			        // Populate ComboBox with patient IDs
			        searchPatientFrame.populateComboBox(patientIds);

			        // Make the SearchPatient frame visible
			        searchPatientFrame.setVisible(true);
			        try {
			            searchPatientFrame.setSelected(true);
			        } catch (java.beans.PropertyVetoException ex) {
			            ex.printStackTrace();
			        }
			    }
			});
		  
		  JMenuItem mntmNewMenuItem_26 = new JMenuItem("Visit");
		  mnNewMenu_2.add(mntmNewMenuItem_26);
		  mntmNewMenuItem_26.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        searchVisitFrame.populateComboBox(); // Populate the ComboBox with visit numbers
			        searchVisitFrame.setVisible(true); // Show the SearchVisit frame
			        try {
			            searchVisitFrame.setSelected(true); // Bring the frame to focus
			        } catch (java.beans.PropertyVetoException ex) {
			            ex.printStackTrace();
			        }
			    }
			});
		  
		  JMenu mnNewMenu_3 = new JMenu("Medical Problem");
		  mnNewMenu_2.add(mnNewMenu_3);
		  
		  JMenuItem mntmNewMenuItem_13 = new JMenuItem("Disease");
		  mnNewMenu_3.add(mntmNewMenuItem_13);
		  mntmNewMenuItem_13.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        List<String> diseaseCodes = Hospital.getInstance().getDiseaseCodes();
			        searchDiseaseFrame.populateComboBox(diseaseCodes);
			        searchDiseaseFrame.setVisible(true);
			        try {
			            searchDiseaseFrame.setSelected(true);
			        } catch (java.beans.PropertyVetoException ex) {
			            ex.printStackTrace();
			        }
			    }
			});
		  
		  JMenuItem mntmNewMenuItem_14 = new JMenuItem("Fracture");
		  mnNewMenu_3.add(mntmNewMenuItem_14);
		  mntmNewMenuItem_14.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        List<String> fractureCodes = Hospital.getInstance().getFractureCodes();
			        searchFractureFrame.populateComboBox(fractureCodes);
			        searchFractureFrame.setVisible(true);
			        try {
			            searchFractureFrame.setSelected(true);
			        } catch (java.beans.PropertyVetoException ex) {
			            ex.printStackTrace();
			        }
			    }
			});
		  
		  JMenuItem mntmNewMenuItem_15 = new JMenuItem("Injury");
		  mnNewMenu_3.add(mntmNewMenuItem_15);
		  mntmNewMenuItem_15.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        List<String> injuryCodes = Hospital.getInstance().getInjuryCodes();
			        searchInjuryFrame.populateComboBox(injuryCodes);
			        searchInjuryFrame.setVisible(true);
			        try {
			            searchInjuryFrame.setSelected(true);
			        } catch (java.beans.PropertyVetoException ex) {
			            ex.printStackTrace();
			        }
			    }
			});
		  
		  JMenuItem mntmNewMenuItem_11 = new JMenuItem("Treatment");
		  mntmNewMenuItem_11.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        Set<Integer> treatmentSerialNumbers = Hospital.getInstance().getTreatments().keySet();
			        searchTreatmentFrame.populateComboBox(treatmentSerialNumbers);
			        searchTreatmentFrame.setVisible(true);
			        try {
			            searchTreatmentFrame.setSelected(true);
			        } catch (java.beans.PropertyVetoException ex) {
			            ex.printStackTrace();
			        }
			    }
			});

		  mnNewMenu_2.add(mntmNewMenuItem_11);
		  
		  JMenuItem mntmNewMenuItem_29 = new JMenuItem("Medication");
		  mnNewMenu_2.add(mntmNewMenuItem_29);
		  mntmNewMenuItem_29.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        Set<Integer> medicationCodes = Hospital.getInstance().getMedications().keySet();
			        searchMedicationFrame.populateComboBox(medicationCodes);
			        searchMedicationFrame.setVisible(true);
			        try {
			            searchMedicationFrame.setSelected(true);
			        } catch (java.beans.PropertyVetoException ex) {
			            ex.printStackTrace();
			        }
			    }
			});
		
		  menuBar.add(Box.createHorizontalGlue());
		  
		  JButton btnNewButton_1 = new JButton("Log Out");
		  btnNewButton_1.setForeground(new Color(220, 20, 60));
		  btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		  menuBar.add(btnNewButton_1);
		  
		  JLabel lblNewLabel = new JLabel();
		  lblNewLabel.setForeground(new Color(0, 64, 64));
		  lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		  lblNewLabel.setBounds(218, 68, 165, 31);
		  contentPane.add(lblNewLabel);
		  
		  if (role.equals("doctor") || role.equals("Nurse")) {
		  JButton btnEditInformation = new JButton("Edit Information");
		  btnEditInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
		  btnEditInformation.setForeground(Color.BLUE);  // Optional: Set the text color
		  btnEditInformation.setBounds(450, 25, 140, 25);  
		  contentPane.add(btnEditInformation);
		  btnEditInformation.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        if (role.equals("doctor") && editDoctorFrame != null) {
			            editDoctorFrame.setVisible(true);
			            try {
			                editDoctorFrame.setSelected(true);
			            } catch (java.beans.PropertyVetoException ex) {
			                ex.printStackTrace();
			            }
			        } else if (role.equals("Nurse") && editNurseFrame != null) {
			            editNurseFrame.setVisible(true);
			            try {
			                editNurseFrame.setSelected(true);
			            } catch (java.beans.PropertyVetoException ex) {
			                ex.printStackTrace();
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "This option is only available for Doctors and Nurses.");
			        }
			    }
			});
		}
		  
		  if (role.equals("Admin")) {
	            lblNewLabel.setText("Welcome Admin!!");
	        } else if (role.equals("doctor")) {
	            lblNewLabel.setText("Welcome Doctor!!");
	        } else if (role.equals("Nurse")) {
	            lblNewLabel.setText("Welcome Nurse!!");
	        }
		  
		  JLabel lblNewLabel_1 = new JLabel("Number of medications with dosages between (min dosage)");
		  lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		  lblNewLabel_1.setBounds(25, 215, 358, 19);
		  contentPane.add(lblNewLabel_1);
		  
		  JLabel lblNewLabel_3 = new JLabel("and (max dosage)");
		  lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		  lblNewLabel_3.setBounds(427, 217, 111, 19);
		  contentPane.add(lblNewLabel_3);
		  
		  textField = new JTextField();
		  textField.setBounds(382, 215, 35, 20);
		  contentPane.add(textField);
		  textField.setColumns(10);
		  
		  textField_1 = new JTextField();
		  textField_1.setBounds(537, 215, 35, 20);
		  contentPane.add(textField_1);
		  textField_1.setColumns(10);
		  btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                LoginFrame loginFrame = new LoginFrame();
	                loginFrame.setVisible(true);
	                dispose();
	            }});        
	       JButton btnCalculate = new JButton("Calculate");
	       btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 10));
	       btnCalculate.setBounds(25, 252, 79, 25);
	       contentPane.add(btnCalculate);

	                // Result label
	       resultLabel = new JLabel("Result: ");
	       resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
	       resultLabel.setBounds(132, 253, 200, 20);
	        contentPane.add(resultLabel);
	        
	        JLabel lblNewLabel_2 = new JLabel("How many visits before (date)");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_2.setBounds(30, 295, 181, 14);
	        contentPane.add(lblNewLabel_2);
	        
	        dateSpinner = new JSpinner(new SpinnerDateModel());
	        dateSpinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
	        dateSpinner.setEditor(dateEditor);
	        dateSpinner.setBounds(218, 292, 91, 19);
	        contentPane.add(dateSpinner);
	        
	        JButton btnCheckVisits = new JButton("Check Visits");
	        btnCheckVisits.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        btnCheckVisits.setBounds(328, 293, 106, 19);
	        contentPane.add(btnCheckVisits);

	        JLabel visitResultLabel = new JLabel("Visits Result: ");
	        visitResultLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        visitResultLabel.setBounds(59, 312, 200, 20);
	        contentPane.add(visitResultLabel);
	        
	        if (role.equals("Admin")) {
	        	
	        	JLabel admin1 = new JLabel("Number of doctors specialized in");
	        	admin1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        	admin1.setBounds(30, 424, 224, 14);
	        	contentPane.add(admin1);
	        
	        
	        	JComboBox<String> admin2 = new JComboBox<String>();
	        	admin2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        	String[] specializations = {"Neurology", "Other", "Cardiology", "Otolaryngology",
	        			"Orthopedics", "Surgery", "Ophthalmology", 
	        			"Pulmonology", "IntensiveCare"};
	        	for (String specialization : specializations) {
	        		admin2.addItem(specialization);
	        	}
	        	admin2.setBounds(230, 421, 79, 22);
	        	contentPane.add(admin2);
	        
	        	admin4 = new JLabel("");
	        	admin4.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        	admin4.setBounds(350, 421, 248, 20); 
	        	contentPane.add(admin4);
	        
	        	JLabel admin3 = new JLabel("is:");
	        	admin3.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        	admin3.setBounds(319, 425, 49, 14);
	        	contentPane.add(admin3);
	        
	        	JLabel admin5 = new JLabel("Appoint a new manager to the department");
	        	admin5.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        	admin5.setBounds(30, 465, 255, 14);
	        	contentPane.add(admin5);
	        
	        	JLabel admin6 = new JLabel("(enter department number)");
	        	admin6.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        	admin6.setBounds(291, 465, 165, 14);
	        	contentPane.add(admin6);
	        
	        	admin7 = new JTextField();
	        	admin7.setBounds(463, 462, 54, 22);
	        	contentPane.add(admin7);

	        	JLabel admin8 = new JLabel("");
	        	admin8.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        	admin8.setBounds(59, 489, 350, 20);
	        	contentPane.add(admin8);
	        	
	        	admin7.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                appointNewManager(admin8);
		            }
		        });

		        // Add action listener to the combo box to update doctor count
		        admin2.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	 String selectedSpecializationStr = (String) admin2.getSelectedItem();
		                 updateDoctorCount(selectedSpecializationStr);
		            } });
	        }
	        
	        JLabel lblNewLabel_8 = new JLabel("There is ");
	        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_8.setBounds(30, 343, 60, 14);
	        contentPane.add(lblNewLabel_8);
		        
	        intensiveCareCountLabel = new JLabel(); // Initialize JLabel
	        intensiveCareCountLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
	        intensiveCareCountLabel.setBounds(83, 344, 50, 14);
	        contentPane.add(intensiveCareCountLabel);
	        
	        JLabel lblNewLabel_9 = new JLabel("IntensiveCare staff members.");
	        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_9.setBounds(115, 343, 211, 14);
	        contentPane.add(lblNewLabel_9);
	        
	        JLabel lblNewLabel_10 = new JLabel("Salary average is:");
	        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_10.setBounds(30, 368, 137, 14);
	        contentPane.add(lblNewLabel_10);
	        
	        avgSalaryTextField = new JTextField();
	        avgSalaryTextField.setBounds(149, 366, 100, 20);
	        avgSalaryTextField.setEditable(false);  
	        contentPane.add(avgSalaryTextField);
	        
	        JLabel complianceStatusTextLabel = new JLabel("Does the hospital complies with Health Standard?");
	        complianceStatusTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        complianceStatusTextLabel.setBounds(30, 393, 320, 20);
	        contentPane.add(complianceStatusTextLabel);
	        
	        complianceStatusLabel = new JLabel();
	        complianceStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	        complianceStatusLabel.setBounds(338, 393, 150, 20);
	        contentPane.add(complianceStatusLabel);
	        
	        JLabel lblNewLabel_12 = new JLabel("Here you can find what you are looking for...");
	        lblNewLabel_12.setForeground(new Color(0, 64, 64));
	        lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_12.setBounds(47, 127, 387, 31);
	        contentPane.add(lblNewLabel_12);
	        
	        JLabel lblNewLabel_11 = new JLabel("");
	        lblNewLabel_11.setIcon(new ImageIcon(adminpage1.class.getResource("/pics/amjadhospital.png")));
	        lblNewLabel_11.setBounds(-13, 11, 637, 548);
	        contentPane.add(lblNewLabel_11); 
	
	        btnCheckVisits.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	checkVisitsBeforeDate(visitResultLabel);
	            }

				private void checkVisitsBeforeDate(JLabel visitResultLabel) {
					try {
		                Date selectedDate = (Date) dateSpinner.getValue();
		                int visitCount = Main.libr.howManyVisitBefore(selectedDate);
		                visitResultLabel.setText("Visits Result: " + visitCount + " visits before the date.");
		            } catch (NullPointerException ex) {
		                visitResultLabel.setText("Hospital data not loaded.");
		            }
		        					
				}
	        });
	        
	                // Action listener for the Calculate button
	        btnCalculate.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                        calculateMedications();
	                    }
	                });
	        
	        updateIntensiveCareStaffCount();
	        updateAvgSalary();
	        updateComplianceStatus();
	}
	 private void updateDoctorCount(String selectedSpecializationStr) {
		 try {
		        // Convert the string directly to the corresponding enum (if exact match)
		        Specialization selectedSpecialization = Specialization.valueOf(selectedSpecializationStr);

		        // Get the number of doctors by specialization from the Hospital class
		        HashMap<Specialization, Integer> doctorCounts = Main.libr.getNumberOfDoctorsBySpecialization();

		        int count = doctorCounts.getOrDefault(selectedSpecialization, 0);
		        admin4.setText(""+ count );
		    } catch (IllegalArgumentException ex) {
		        admin4.setText("Error: Invalid specialization selected.");
		    } catch (Exception ex) {
		        admin4.setText("Hospital data not loaded.");
		    }
		}

	private void calculateMedications() {
	        try {
	            double minDosage = Double.parseDouble(textField.getText());
	            double maxDosage = Double.parseDouble(textField_1.getText());

	            // Use the Hospital instance from the Main class
	            int count = Main.libr.countMedications(minDosage, maxDosage);

	            // Display the result in the JLabel
	            resultLabel.setText("Result: " + count + " medications found.");
	        } catch (NumberFormatException ex) {
	            resultLabel.setText("Please enter valid numbers.");
	        } catch (NullPointerException ex) {
	            resultLabel.setText("Hospital data not loaded.");
	        }
	    }
	
	private void appointNewManager(JLabel appointResultLabel) {
        try {
            int departmentNumber = Integer.parseInt(admin7.getText());

            // Retrieve the Department object from the Hospital class
            Department department = Main.libr.getDepartmentByNumber(departmentNumber);

            if (department != null) {
                // Call the AppointANewManager method
                Doctor newManager = Main.libr.AppointANewManager(department);
                
                if (newManager != null) {
                    appointResultLabel.setText("New Manager: Dr. " + newManager.getFirstName() + " appointed to Department " + departmentNumber);
                } else {
                    appointResultLabel.setText("No suitable doctor found to be the new manager.");
                }
            } else {
                appointResultLabel.setText("Invalid department number.");
            }
        } catch (NumberFormatException ex) {
            appointResultLabel.setText("Please enter a valid department number.");
        } catch (Exception ex) {
            appointResultLabel.setText("An error occurred while appointing the manager.");
        }
    }

	private void updateIntensiveCareStaffCount() {
		try {
			int intensiveCareCount = Main.libr.howManyIntensiveCareStaffMembers();
			intensiveCareCountLabel.setText(String.valueOf(intensiveCareCount));
		} catch (Exception e) {
			intensiveCareCountLabel.setText("Error");
		}
	}
	
	private void updateAvgSalary() {
        try {
            double avgSalary = Main.libr.avgSalary();
            avgSalaryTextField.setText(String.format("%.2f", avgSalary));  // Format to 2 decimal places
        } catch (Exception e) {
            avgSalaryTextField.setText("Error");
        }
    }
	
	private void updateComplianceStatus() {
        try {
            boolean complies = Main.libr.isCompliesWithTheMinistryOfHealthStandard();
            complianceStatusLabel.setText(complies ? "Yes" : "No");
            complianceStatusLabel.setForeground(complies ? Color.GREEN : Color.RED);
        } catch (Exception e) {
            complianceStatusLabel.setText("Error");
            complianceStatusLabel.setForeground(Color.RED);
        }
    }
	
	private void refreshData11() {
	    try {
	        // Re-fetch data and update labels
	        updateIntensiveCareStaffCount();
	        updateAvgSalary();
	        updateComplianceStatus();

	        // Re-populate combo boxes in all relevant internal frames
	        removeDoctorFrame.populateComboBox("Doctor");
	        removeNurseFrame.populateComboBox("Nurse");
	        removeDepartmentFrame.populateComboBox();
	        removePatientFrame.populateComboBox();
	        removeVisitFrame.populateComboBox();
	        removeDiseaseFrame.populateComboBox(new ArrayList<>(Hospital.getInstance().getDiseaseCodes()));
	        removeFractureFrame.populateComboBox(new ArrayList<>(Hospital.getInstance().getFractureCodes()));
	        removeInjuryFrame.populateComboBox(new ArrayList<>(Hospital.getInstance().getInjuryCodes()));
	        removeTreatmentFrame.populateComboBox();
	        removeMedicationFrame.populateComboBox();

	        // Also refresh search frames if needed
	        searchDoctorFrame.populateComboBox("Doctor");
	        searchNurseFrame.populateComboBox("Nurse");
	        searchDepartmentFrame.populateComboBox();
	        searchPatientFrame.populateComboBox(Hospital.getInstance().getPatients().keySet()); 
	        searchVisitFrame.populateComboBox();
	        searchDiseaseFrame.populateComboBox(Hospital.getInstance().getDiseaseCodes());
	        searchFractureFrame.populateComboBox(Hospital.getInstance().getFractureCodes());
	        searchInjuryFrame.populateComboBox(Hospital.getInstance().getInjuryCodes());
	        searchTreatmentFrame.populateComboBox(Hospital.getInstance().getTreatments().keySet());
	        searchMedicationFrame.populateComboBox(Hospital.getInstance().getMedications().keySet());

	        JOptionPane.showMessageDialog(this, "Data refreshed successfully!", "Refresh", JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error refreshing data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void refreshData() {
	    updateIntensiveCareStaffCount();
	    updateAvgSalary();
	    updateComplianceStatus();
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}

