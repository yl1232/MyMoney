package View;
import Controller.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JSeparator;

public class Welcome extends JFrame {
	

	private JPanel contentPane;
	private MyMoneyController controller = new MyMoneyController();
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public Welcome() throws SQLException {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel employee = new JLabel("\u05D4\u05D9\u05E0\u05DA \u05DE\u05E9\u05EA\u05DE\u05E9/\u05EA \u05D7\u05D3\u05E9/\u05D4");
		employee.setVisible(false);
		employee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		employee.setForeground(Color.WHITE);
		employee.setHorizontalAlignment(SwingConstants.RIGHT);
		employee.setBounds(120, 130, 266, 30);
		contentPane.add(employee);
		
		JLabel label_3 = new JLabel("\u05EA\u05D7\u05D9\u05DC\u05D4 \u05D4\u05DB\u05E0\u05E1/\u05D9 \u05D0\u05EA \u05E4\u05E8\u05D8\u05D9\u05DA \u05D4\u05D0\u05D9\u05E9\u05D9\u05D9\u05DD");
		label_3.setVisible(false);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(56, 161, 330, 30);
		contentPane.add(label_3);
		
		JLabel label_1 = new JLabel("\u05D1\u05E8\u05D5\u05DB\u05D9\u05DD \u05D4\u05D1\u05D0\u05D9\u05DD");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(191, 72, 195, 40);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u05DB\u05E0\u05D9\u05E1\u05D4");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(191, 7, 195, 46);
		contentPane.add(label_2);
		
		JLabel okBTN = new JLabel("");
		okBTN.setVisible(false);
		okBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185Over.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Sign_up().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185Pushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185Over.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185.jpg")));
			}
		});
		
		JLabel label = new JLabel("\u05D0\u05D9\u05E9\u05D5\u05E8");
		label.setVisible(false);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(110, 214, 185, 58);
		contentPane.add(label);
		okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185.jpg")));
		okBTN.setHorizontalAlignment(SwingConstants.CENTER);
		okBTN.setBounds(110, 212, 185, 60);
		contentPane.add(okBTN);
		
		JLabel label_4 = new JLabel("\u05DB\u05E0\u05D9\u05E1\u05D4");
		label_4.setVisible(false);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(110, 168, 185, 58);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setVisible(false);
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label_5.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185Over.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
					try {
						new Home().setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_5.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185Pushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label_5.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185Over.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_5.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185.jpg")));
			}
		});
		
				label_5.setIcon(new ImageIcon(Home.class.getResource("/Btn185.jpg")));
				label_5.setHorizontalAlignment(SwingConstants.CENTER);
				label_5.setBounds(110, 168, 185, 60);
				contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_6.setBounds(12, 72, 170, 40);
		contentPane.add(label_6);
		
		JLabel back = new JLabel("");
		back.setVerticalAlignment(SwingConstants.TOP);
		back.setIcon(new ImageIcon(Home.class.getResource("/subForm.jpg")));
		back.setHorizontalAlignment(SwingConstants.LEFT);
		back.setBounds(0, 0, 400, 328);
		
		contentPane.add(back);
		ResultSet rs = controller.getUser();  
		
		if (rs !=null && rs.next()) // Check if the user already exists
		{
			label_4.setVisible(true);	
			label_5.setVisible(true);
			label_6.setText(rs.getString("שם_פרטי"));
			label_6.setVisible(true);
			label.setVisible(false);
			okBTN.setVisible(false);
			employee.setVisible(false);
			label_3.setVisible(false);
		}
		else
		{
			label.setVisible(true);
			okBTN.setVisible(true);
			employee.setVisible(true);
			label_3.setVisible(true);
			label_4.setVisible(false);	
			label_5.setVisible(false);
			label_6.setVisible(false);
		} 
		
	}
	
}
