package swingex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class Teacher_window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_window frame = new Teacher_window();
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
	public Teacher_window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 848, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(204, 255, 153));
		lblNewLabel.setBounds(806, 11, 32, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update user information");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 51, 0)));
		lblNewLabel_1.setForeground(new Color(0, 51, 0));
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateInformationTeacher updateInfo=new UpdateInformationTeacher();
				updateInfo.setVisible(true);
			}
			
		});
		lblNewLabel_1.setBounds(28, 24, 236, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Create new course");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateCourse cc=new CreateCourse();
				cc.setVisible(true);
			}
		});
		lblNewLabel_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 51, 0)));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 51, 0));
		lblNewLabel_1_1.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(287, 24, 236, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Course information");
		lblNewLabel_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(0, 51, 0));
		lblNewLabel_1_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 51, 0)));
		lblNewLabel_1_2.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(539, 24, 236, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome back!");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 38));
		lblNewLabel_2.setForeground(new Color(204, 255, 153));
		lblNewLabel_2.setBounds(269, 155, 274, 116);
		contentPane.add(lblNewLabel_2);
	}
}
