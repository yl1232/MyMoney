package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MyMoneyController;

import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JSeparator;

public class Sign_up extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String firstname;
	private String lastname;
	private MyMoneyController controller = new MyMoneyController();

	/**
	 * Create the frame.
	 */
	public Sign_up() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_3 = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(120, 200, 266, 30);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(JTextField.RIGHT);
		textField_1.setDocument(new JTextFieldLimit(15));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(146, 230, 240, 40);
		contentPane.add(textField_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setDocument(new JTextFieldLimit(15));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(146, 160, 240, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel emploee = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		emploee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emploee.setForeground(Color.WHITE);
		emploee.setHorizontalAlignment(SwingConstants.RIGHT);
		emploee.setBounds(120, 130, 266, 30);
		contentPane.add(emploee);
		
		JLabel label_1 = new JLabel("\u05E4\u05E8\u05D8\u05D9 \u05DE\u05E9\u05EA\u05DE\u05E9");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(116, 72, 270, 40);
		contentPane.add(label_1);
		
		JLabel okBTN = new JLabel("");
		okBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185Over.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				try {
					firstname = textField.getText().toString();
					lastname = textField_1.getText().toString();
					controller.insertUserData(firstname, lastname);
					new Welcome().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
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
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(15, 231, 119, 40);
		contentPane.add(label);
		okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185.jpg")));
		okBTN.setHorizontalAlignment(SwingConstants.CENTER);
		okBTN.setBounds(15, 231, 120, 40);
		contentPane.add(okBTN);
		
		JLabel back = new JLabel("");
		back.setVerticalAlignment(SwingConstants.TOP);
		back.setIcon(new ImageIcon(Home.class.getResource("/subForm.jpg")));
		back.setHorizontalAlignment(SwingConstants.LEFT);
		back.setBounds(0, 0, 400, 313);
		contentPane.add(back);
		
	}

}
