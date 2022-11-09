package swingex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JFrame frame=new JFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 51, 0));
		contentPane.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		contentPane.setBackground(new Color(0, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 51, 0));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 48));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(204, 255, 153));
		lblNewLabel.setBounds(131, 11, 274, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("x");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.PLAIN, 24));
		lblNewLabel_1.setForeground(new Color(204, 255, 153));
		lblNewLabel_1.setBounds(528, 0, 22, 31);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		username.setForeground(new Color(0, 51, 0));
		username.setBackground(new Color(255, 255, 204));
		username.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		username.setBounds(214, 128, 233, 40);
		contentPane.add(username);
		username.setColumns(10);
		
		JComboBox occupancy = new JComboBox();
		occupancy.setBackground(new Color(255, 255, 204));
		occupancy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		occupancy.setForeground(new Color(0, 51, 0));
		occupancy.setFont(new Font("Sitka Display", Font.BOLD, 16));
		occupancy.setModel(new DefaultComboBoxModel(new String[] {"Student", "Teacher"}));
		occupancy.setBounds(214, 284, 118, 31);
		contentPane.add(occupancy);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(new Color(204, 255, 153));
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.PLAIN, 27));
		lblNewLabel_2.setBounds(38, 128, 166, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(new Color(204, 255, 153));
		lblNewLabel_2_1.setFont(new Font("Sitka Display", Font.PLAIN, 27));
		lblNewLabel_2_1.setBounds(38, 210, 166, 40);
		contentPane.add(lblNewLabel_2_1);
		
		password = new JPasswordField();
		password.setAlignmentY(Component.TOP_ALIGNMENT);
		password.setAlignmentX(Component.LEFT_ALIGNMENT);
		password.setLocation(new Point(9, 0));
		password.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		password.setForeground(new Color(0, 51, 0));
		password.setBackground(new Color(255, 255, 204));
		password.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		password.setBounds(214, 200, 233, 40);
		contentPane.add(password);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("I am");
		lblNewLabel_2_1_1.setForeground(new Color(204, 255, 153));
		lblNewLabel_2_1_1.setFont(new Font("Sitka Display", Font.PLAIN, 27));
		lblNewLabel_2_1_1.setBounds(38, 284, 166, 40);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection dbCon=new DBConnection();
				userManager um=new userManager();
				Connection con=dbCon.getDBConnection();
				String us=username.getText();
				String pass=String.valueOf(password.getPassword());
				String occ=occupancy.getSelectedItem().toString().toLowerCase();
				secondWindow second=new secondWindow();
				boolean validation=um.validateLogin(con,us,pass,occ);
				if(validation==true) {
					second.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBackground(new Color(204, 255, 153));
		btnNewButton.setForeground(new Color(0, 51, 0));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		btnNewButton.setBounds(427, 339, 89, 31);
		contentPane.add(btnNewButton);
		setUndecorated(true);
	}
}
