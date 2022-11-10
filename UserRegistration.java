package swingex;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Component;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UserRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField username_2;
	private JTextField email;
	private JPasswordField password;
	private JPasswordField repeatPassword;
	private JFrame frame=new JFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
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
	public UserRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(153, 204, 102), new Color(153, 204, 102), new Color(153, 204, 102), new Color(153, 204, 102)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(415, 10, 2, 2);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 55));
		lblNewLabel.setBackground(new Color(204, 255, 153));
		lblNewLabel.setBounds(33, 23, 776, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("x");
		lblNewLabel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(102, 153, 51));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.PLAIN, 33));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(806, 10, 32, 41);
		contentPane.add(lblNewLabel_1);
		
		username_2 = new JTextField();
		username_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		username_2.setBackground(new Color(204, 255, 153));
		username_2.setBounds(316, 142, 341, 28);
		contentPane.add(username_2);
		username_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 22));
		lblNewLabel_2.setForeground(new Color(255, 255, 204));
		lblNewLabel_2.setBounds(47, 142, 230, 28);
		contentPane.add(lblNewLabel_2);
		
		email = new JTextField();
		email.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		email.setBackground(new Color(204, 255, 153));
		email.setColumns(10);
		email.setBounds(316, 199, 341, 28);
		contentPane.add(email);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(47, 199, 230, 28);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Password");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 204));
		lblNewLabel_2_2.setFont(new Font("Sitka Subheading", Font.BOLD, 22));
		lblNewLabel_2_2.setBounds(47, 259, 230, 28);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Repeat password");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 204));
		lblNewLabel_2_3.setFont(new Font("Sitka Subheading", Font.BOLD, 22));
		lblNewLabel_2_3.setBounds(47, 316, 230, 28);
		contentPane.add(lblNewLabel_2_3);
		
		password = new JPasswordField();
		password.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		password.setBackground(new Color(204, 255, 153));
		password.setBounds(316, 259, 341, 28);
		contentPane.add(password);
		
		
		
		repeatPassword = new JPasswordField();
		repeatPassword.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 255, 204), new Color(255, 255, 204), null, null));
		repeatPassword.setBackground(new Color(204, 255, 153));
		repeatPassword.setBounds(316, 315, 341, 28);
		contentPane.add(repeatPassword);
		
		JComboBox occupancy = new JComboBox();
		occupancy.setOpaque(false);
		occupancy.setBackground(new Color(204, 255, 153));
		occupancy.setFont(new Font("Tahoma", Font.BOLD, 11));
		occupancy.setForeground(new Color(0, 51, 0));
		occupancy.setModel(new DefaultComboBoxModel(new String[] {"Student", "Teacher"}));
		occupancy.setBounds(316, 369, 158, 28);
		contentPane.add(occupancy);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Select");
		lblNewLabel_2_3_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_2_3_1.setFont(new Font("Sitka Subheading", Font.BOLD, 22));
		lblNewLabel_2_3_1.setBounds(47, 370, 230, 28);
		contentPane.add(lblNewLabel_2_3_1);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userManager um=new userManager();
				DBConnection dbCon=new DBConnection();
				Connection con=dbCon.getDBConnection();
				//get values from input
				String pass=String.valueOf(password.getPassword());
				String us=username_2.getText();
				String em=email.getText();
				String passRepeat=String.valueOf(repeatPassword.getPassword());
				String occ=occupancy.getSelectedItem().toString().toLowerCase();
				//validate the password
				
				boolean passwordValidation=um.validate(pass);
				if(passwordValidation==false) {
					
					pass=null;
					JOptionPane.showMessageDialog(frame, "Password does not meet the requirements.");
				}
				//check if password matches
				
				boolean matchPass=um.matchingPassword(pass, passRepeat);
				if(matchPass==false) {
					
					passRepeat=null;
					JOptionPane.showMessageDialog(frame, "Password does not match.");
				}
				
				//check username
				
				boolean usernameValidation=um.checkIfUsernameAvailable(con,occ, us);
					if(usernameValidation==false) {
							us=null;
							JOptionPane.showMessageDialog(frame, "Username is already taken");
					}
				//check email
					
				boolean emailValidation=um.checkIfEmailAvailable(con,occ,em);
					if(emailValidation==false) {
							em=null;
							JOptionPane.showMessageDialog(frame, "User with this email already exists.");
					}
					if(em.indexOf('@')==-1 || !em.contains(".com")) {
						em=null;
						JOptionPane.showMessageDialog(frame, "Email invalid.");
					}
					
				
				//checking to which table insert data
					     
					
						 
				 int rows=um.insertNewUser(con, occ,passRepeat, us, em);
				 System.out.println(rows);
				    if(rows>0) {
				    	dispose();
				    }
					 
					     
				//closing the connection
					     System.out.println("Closing the connection.");
					     if (con != null) try { con.close(); } catch (SQLException ignore) {}
			
			}
		});
		
		
				
		submit.setForeground(new Color(0, 51, 51));
		submit.setFont(new Font("Sitka Heading", Font.BOLD, 19));
		submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		submit.setBorderPainted(false);
		submit.setBackground(new Color(204, 255, 153));
		submit.setBounds(711, 412, 109, 31);
		contentPane.add(submit);
		
		JLabel lblNewLabel_3 = new JLabel("At least 1 upper letter, 1 number, 8 characters.");
		lblNewLabel_3.setForeground(new Color(204, 255, 153));
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(316, 290, 341, 14);
		contentPane.add(lblNewLabel_3);
		setUndecorated(true);
	}
}
