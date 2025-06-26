package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Hospital;
import model.Doctor;
import model.Nurse;
import model.StaffMember;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 25L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		
		if (Main.libr == null) {
            try {
                Main.libr = Main.loadingLibr();
                if (Main.libr == null) {
                    Main.libr = Hospital.getInstance(); // Create new Hospital if loading fails
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading hospital data", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 30, 90, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 80, 100, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton logIn = new JButton("");
		logIn.addActionListener(new ActionListener() {
		    @SuppressWarnings("deprecation")
		    public void actionPerformed(ActionEvent e) {

		        // Check if username and password fields are empty
		        if (username.getText().isEmpty() || passwordField.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "There's an empty field, please try again...");
		            return;
		        }
		        
		        String role = "Unknown";
		        StaffMember loggedInStaffMember = null;
		        int usernamee = -1;
		        // Check if the user is ADMIN
		        if (username.getText().equals("ADMIN") && passwordField.getText().equals("ADMIN")) {
		            role = "Admin";
		            adminpage1 newAdmin = new adminpage1(role, null); // No need to pass a StaffMember for Admin
		            newAdmin.setVisible(true);
		            setVisible(false);
		        }else {

		        // Attempt to parse the username as an integer
		        try {
		            usernamee = Integer.parseInt(username.getText());
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "The username must be a valid integer. Please try again...");
		            return;
		        }
		        
		        String enteredPassword = passwordField.getText();
	            StaffMember sm = Main.libr.getStaffMemberByUsernameAndPassword(usernamee, enteredPassword);
	            if (sm == null) {
	                JOptionPane.showMessageDialog(null, "Your username or password is wrong. Try again.");
	                return;
	            }
	            
	            loggedInStaffMember = sm;
		        if(sm instanceof Doctor) {
		        	role = "doctor";
		        }else if(sm instanceof Nurse) {
		        	role= "Nurse";
		        }
		     
		
		    adminpage1 newAdmin = new adminpage1(role, loggedInStaffMember);
	        newAdmin.setVisible(true);
	        setVisible(false);
	    }
		    }});

		
		logIn.setIcon(new ImageIcon(LoginFrame.class.getResource("/pics/icons8-login-48.png")));
		logIn.setBounds(288, 43, 50, 51);
		contentPane.add(logIn);
		
		username = new JTextField();
		username.setBounds(120, 30, 96, 25);
		contentPane.add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 80, 96, 25);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/pics/ezgif.com-webp-to-gif-converter.gif")));
		lblNewLabel_1.setBounds(0, 0, 480, 360);
		contentPane.add(lblNewLabel_1);
	}
}