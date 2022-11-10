package swingex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class index extends JFrame {

	private JPanel contentPane;
	private JFrame frame=new JFrame();
	ImageIcon imageCap=new ImageIcon("cap.png");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
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
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setForeground(new Color(0, 51, 0));
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 63));
		lblNewLabel.setBounds(269, 25, 286, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("x");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setForeground(new Color(0, 51, 0));
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 26));
		lblNewLabel_1.setBounds(809, 11, 29, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistration registration= new UserRegistration();
				registration.setVisible(true);
			}
		});
		register.setForeground(new Color(0, 51, 0));
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		register.setFont(new Font("Sitka Subheading", Font.BOLD, 27));
		register.setBounds(125, 241, 208, 53);
		contentPane.add(register);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin login=new UserLogin();
				login.setVisible(true);
				
			}
		});
		login.setForeground(new Color(0, 51, 0));
		login.setFont(new Font("Sitka Subheading", Font.BOLD, 27));
		login.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		login.setBounds(470, 241, 208, 53);
		contentPane.add(login);
		
	
}
}
