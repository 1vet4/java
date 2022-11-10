package swingex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.border.LineBorder;

public class CreateCourse extends JFrame {

	private JPanel contentPane;
	private JFrame frame=new JFrame();
	private JTextField name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCourse frame = new CreateCourse();
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
	public CreateCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 448, 308);
		contentPane = new JPanel();
		contentPane.setAlignmentX(50.0f);
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new LineBorder(new Color(0, 51, 0), 3));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("x");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setForeground(new Color(204, 255, 153));
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel.setBounds(419, 0, 29, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course name");
		lblNewLabel_1.setForeground(new Color(204, 255, 153));
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 23));
		lblNewLabel_1.setBounds(10, 130, 140, 30);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(179, 123, 246, 42);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userManager um=new userManager();
				DBConnection dbCon=new DBConnection();
				Connection con=dbCon.getDBConnection();
				String Name=name.getText().toLowerCase();
				boolean val=um.insertCourse(con, Name);
				 if(val==true) {
					 JOptionPane.showMessageDialog(frame, "Course created successfuly.");
					 dispose();
				 }
				 else {
					 JOptionPane.showMessageDialog(frame, "Course already exist.");
				 }
					 
					     
				//closing the connection
					     System.out.println("Closing the connection.");
					     if (con != null) try { con.close(); } catch (SQLException ignore) {}
			}
		});
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(0, 51, 0));
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 20));
		btnNewButton.setBounds(322, 254, 103, 30);
		contentPane.add(btnNewButton);
	}

}
