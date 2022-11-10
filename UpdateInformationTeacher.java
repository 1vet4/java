package swingex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UpdateInformationTeacher extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JPasswordField repeatPassword;
	private JFrame frame=new JFrame();
	private JTextField username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateInformationTeacher frame = new UpdateInformationTeacher();
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
	public UpdateInformationTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New password");
		lblNewLabel.setBounds(63, 205, 212, 41);
		lblNewLabel.setForeground(new Color(204, 255, 153));
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblRepeatPassword = new JLabel("Repeat password");
		lblRepeatPassword.setBounds(63, 281, 212, 41);
		lblRepeatPassword.setForeground(new Color(204, 255, 153));
		lblRepeatPassword.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		contentPane.add(lblRepeatPassword);
		
		password = new JPasswordField();
		password.setBounds(301, 205, 355, 41);
		contentPane.add(password);
		
		repeatPassword = new JPasswordField();
		repeatPassword.setBounds(301, 281, 355, 41);
		contentPane.add(repeatPassword);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(658, 399, 149, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userManager um=new userManager();
				DBConnection dbCon=new DBConnection();
				Connection con=dbCon.getDBConnection();
				//get values from input
				String pass=String.valueOf(password.getPassword());
				String passRepeat=String.valueOf(repeatPassword.getPassword());
				String us=username.getText();
				//validate the password
				
				boolean passwordValidation=um.validate(pass);
				if(passwordValidation==false) {
					
					pass=null;
					JOptionPane.showMessageDialog(frame, "Password does not meet the requirements.");
				}
				//check if password matches
				
				boolean matchPass=um.matchingPassword(pass, passRepeat);
				if(matchPass==false) {
					
					pass=null;
					JOptionPane.showMessageDialog(frame, "Password does not match.");
				}
						 
				 boolean val=um.updatePassword(con,pass,us,"teacher");
				 if(val==true) {
					 JOptionPane.showMessageDialog(frame, "Password updated successfuly.");
					 dispose();
				 }
					 
					     
				//closing the connection
					     System.out.println("Closing the connection.");
					     if (con != null) try { con.close(); } catch (SQLException ignore) {}
			}
			
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 17));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 51, 0));
		btnNewButton.setForeground(new Color(204, 255, 102));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("x");
		lblNewLabel_1.setBounds(816, 0, 32, 41);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setForeground(new Color(0, 51, 0));
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 22));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCurrentPassword = new JLabel("Username");
		lblCurrentPassword.setBounds(63, 127, 212, 41);
		lblCurrentPassword.setForeground(new Color(204, 255, 153));
		lblCurrentPassword.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		contentPane.add(lblCurrentPassword);
		
		username = new JTextField();
		username.setBounds(301, 127, 355, 41);
		contentPane.add(username);
		username.setColumns(10);
	}
}
