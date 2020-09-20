package View;
import Model.*;
import java.util.Date;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import Controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.Spring;

import java.awt.SystemColor;
import java.awt.Canvas;
import java.awt.Checkbox;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MonthlyData_in extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	
	private int countMore=0;   // Count how many records that belong to category "Other" added by the user
	private MyMoneyController controller = new MyMoneyController();
	

	/**
	 * Create the frame.
	 */
	public MonthlyData_in() {
		setResizable(false);
		setTitle("MyMoney - \u05D4\u05D6\u05E0\u05EA \u05E0\u05EA\u05D5\u05E0\u05D9\u05DD - \u05D4\u05DB\u05E0\u05E1\u05D5\u05EA");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 828);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		//////////////////////////////////////////////////////////////////////////////
		
		//Main Menu - main 
		JLabel mainBTN = new JLabel("");
		mainBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = { "המשך", "בטל" };
				 if(JOptionPane.showOptionDialog(null, "הינך יוצא ממסך הזנת נתונים. נתונים חדשים לא ישמרו", "Warning",
			             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			             null, options, options[0]) == 0) {
				setVisible(false);	
				try {
					new Home().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel addBTN = new JLabel("+ הוסף הכנסה");
		addBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (countMore == 0) {
					countMore++;
					textField_9.setVisible(true);
					textField_10.setVisible(true);
				}				
				else if (countMore == 1) {
					countMore++;
					textField_8.setVisible(true);
					textField_11.setVisible(true);
				}
				else if (countMore == 2) {
					countMore++;
					textField_7.setVisible(true);
					textField_12.setVisible(true);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				addBTN.setForeground(Color.WHITE);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				addBTN.setForeground(Color.LIGHT_GRAY);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				addBTN.setForeground(Color.LIGHT_GRAY);

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				addBTN.setForeground(Color.WHITE);

			}
		});

		addBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					textField_9.setVisible(true);
					textField_10.setVisible(true);

			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				addBTN.setForeground(Color.WHITE);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				addBTN.setForeground(Color.LIGHT_GRAY);

			}
			@Override
			public void mousePressed(MouseEvent e) {
				addBTN.setForeground(Color.LIGHT_GRAY);

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				addBTN.setForeground(Color.WHITE);

			}
		});
		addBTN.setHorizontalAlignment(SwingConstants.RIGHT);
		addBTN.setForeground(Color.LIGHT_GRAY);
		addBTN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addBTN.setBounds(57, 191, 120, 33);
		contentPane.add(addBTN);
		
		textField_12 = new JTextField();
		textField_12.setDocument(new JTextFieldLimit(30));
		textField_12.setVisible(false);
		textField_12.setBackground(Color.WHITE);
		textField_12.setToolTipText("תיאור מקור ההכנסה");
		textField_12.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_12.setColumns(10);
		textField_12.setBounds(260, 331, 240, 40);
		contentPane.add(textField_12);
		
		textField_7 = new JTextField();
		textField_7.setDocument(new JTextFieldLimit(11));
		textField_7.setVisible(false);
		textField_7.setBackground(Color.WHITE);
		textField_7.setToolTipText("סכום");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(108, 331, 140, 40);
		contentPane.add(textField_7);
		
		JLabel nis3 = new JLabel("");
		nis3.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/nisWhite.png")));
		nis3.setHorizontalAlignment(SwingConstants.CENTER);
		nis3.setBounds(55, 331, 40, 40);
		contentPane.add(nis3);
		
		textField_11 = new JTextField();
		textField_11.setDocument(new JTextFieldLimit(30));
		textField_11.setVisible(false);
		textField_11.setBackground(Color.WHITE);
		textField_11.setToolTipText("תיאור מקור ההכנסה");
		textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(260, 281, 240, 40);
		contentPane.add(textField_11);
		
		textField_8 = new JTextField();
		textField_8.setDocument(new JTextFieldLimit(11));
		textField_8.setVisible(false);
		textField_8.setBackground(Color.WHITE);
		textField_8.setToolTipText("סכום");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(108, 281, 140, 40);
		contentPane.add(textField_8);
		
		JLabel nis2 = new JLabel("");
		nis2.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/nisWhite.png")));
		nis2.setHorizontalAlignment(SwingConstants.CENTER);
		nis2.setBounds(55, 281, 40, 40);
		contentPane.add(nis2);
		
		textField_10 = new JTextField();
		textField_10.setDocument(new JTextFieldLimit(30));
		textField_10.setVisible(false);
		textField_10.setColumns(10);
		textField_10.setBackground(Color.WHITE);
		textField_10.setToolTipText("תיאור מקור ההכנסה");
		textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_10.setBounds(260, 231, 240, 40);
		contentPane.add(textField_10);
		
		textField_9 = new JTextField();
		textField_9.setDocument(new JTextFieldLimit(11));
		textField_9.setVisible(false);
		textField_9.setBackground(Color.WHITE);
		textField_9.setToolTipText("סכום");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(108, 231, 140, 40);
		contentPane.add(textField_9);
		
		JLabel nis1 = new JLabel("");
		nis1.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/nisWhite.png")));
		nis1.setHorizontalAlignment(SwingConstants.CENTER);
		nis1.setBounds(55, 231, 40, 40);
		contentPane.add(nis1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.activeCaption);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(57, 223, 450, 4);
		contentPane.add(separator_2);
		
		JLabel label_21 = new JLabel(":: הכנסות נוספות");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setForeground(new Color(153, 255, 255));
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_21.setBounds(166, 189, 334, 33);
		contentPane.add(label_21);
		
		JLabel label_14 = new JLabel("\u05DE\u05E7\u05D5\u05E8");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_14.setBounds(756, 563, 240, 40);
		contentPane.add(label_14);
		
		textField_6 = new JTextField();
		textField_6.setDocument(new JTextFieldLimit(30));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(553, 563, 191, 40);
		contentPane.add(textField_6);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.activeCaption);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(553, 555, 450, 4);
		contentPane.add(separator_1);
		
		JLabel label_15 = new JLabel(":: \u05DE\u05EA\u05E0\u05D5\u05EA");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setForeground(new Color(153, 255, 255));
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_15.setBounds(480, 521, 516, 33);
		contentPane.add(label_15);
		
		JLabel label_3 = new JLabel("\u05D4\u05D1\u05D8\u05D7\u05EA \u05D4\u05DB\u05E0\u05E1\u05D4");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(756, 471, 240, 40);
		contentPane.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setDocument(new JTextFieldLimit(11));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(604, 471, 140, 40);
		contentPane.add(textField_5);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/nisWhite.png")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(551, 471, 40, 40);
		contentPane.add(label_12);
		
		JLabel label_10 = new JLabel("\u05E7\u05E6\u05D1\u05EA \u05D9\u05DC\u05D3\u05D9\u05DD");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_10.setBounds(756, 421, 240, 40);
		contentPane.add(label_10);
		
		textField_4 = new JTextField();
		textField_4.setDocument(new JTextFieldLimit(11));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(604, 421, 140, 40);
		contentPane.add(textField_4);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/nisWhite.png")));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(551, 421, 40, 40);
		contentPane.add(label_11);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/nisWhite.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(551, 371, 40, 40);
		contentPane.add(label_1);
		
		JLabel label_8 = new JLabel("\u05D3\u05DE\u05D9 \u05D0\u05D1\u05D8\u05DC\u05D4");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_8.setBounds(756, 371, 240, 40);
		contentPane.add(label_8);
		
		textField_3 = new JTextField(); // דמי אבטלה
		textField_3.setDocument(new JTextFieldLimit(11));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(604, 371, 140, 40);
		contentPane.add(textField_3);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(Color.BLACK);
		separator.setBounds(553, 363, 450, 4);
		contentPane.add(separator);
		
		JLabel label_9 = new JLabel(":: \u05E7\u05E6\u05D1\u05D0\u05D5\u05EA");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(new Color(153, 255, 255));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_9.setBounds(480, 329, 516, 33);
		contentPane.add(label_9);
		
		JLabel label_6 = new JLabel("\u05E1\u05DB\u05D5\u05DD");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(756, 613, 240, 40);
		contentPane.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setDocument(new JTextFieldLimit(11));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(604, 613, 140, 40);
		contentPane.add(textField_2);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/nisWhite.png")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(551, 613, 40, 40);
		contentPane.add(label_7);
		
		JLabel label_4 = new JLabel("\u05E1\u05DB\u05D5\u05DD");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(763, 278, 240, 40);
		contentPane.add(label_4);
		
		textField_1 = new JTextField(); // סכום משכורת
		textField_1.setDocument(new JTextFieldLimit(11));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(611, 278, 140, 40);
		contentPane.add(textField_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/nisWhite.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(558, 278, 40, 40);
		contentPane.add(label_5);
		
		JLabel label_2 = new JLabel("\u05DE\u05E7\u05D5\u05DD \u05E2\u05D1\u05D5\u05D3\u05D4");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(763, 228, 240, 40);
		contentPane.add(label_2);
		
		textField = new JTextField();    // מקום עבודה
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				
			}
		});
		textField.setDocument(new JTextFieldLimit(30));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(558, 229, 193, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator_Right = new JSeparator();
		separator_Right.setBackground(Color.BLACK);
		separator_Right.setForeground(SystemColor.activeCaption);
		separator_Right.setOrientation(SwingConstants.VERTICAL);
		separator_Right.setBounds(1015, 130, 4, 640);
		contentPane.add(separator_Right);
		
		JSeparator separator_Left = new JSeparator();
		separator_Left.setOrientation(SwingConstants.VERTICAL);
		separator_Left.setForeground(SystemColor.activeCaption);
		separator_Left.setBackground(Color.BLACK);
		separator_Left.setBounds(15, 130, 4, 640);
		contentPane.add(separator_Left);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(SystemColor.activeCaption);
		separator1.setBackground(Color.BLACK);
		separator1.setBounds(560, 222, 450, 4);
		contentPane.add(separator1);
		
		JLabel subTitle1 = new JLabel(":: \u05DE\u05E9\u05DB\u05D5\u05E8\u05EA");
		subTitle1.setHorizontalAlignment(SwingConstants.RIGHT);
		subTitle1.setForeground(new Color(153, 255, 255));
		subTitle1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subTitle1.setBounds(487, 189, 516, 33);
		contentPane.add(subTitle1);
		
		JLabel pageTitle = new JLabel("\u05D4\u05DB\u05E0\u05E1\u05D5\u05EA");
		pageTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		pageTitle.setForeground(Color.WHITE);
		pageTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pageTitle.setBounds(477, 130, 526, 56);
		contentPane.add(pageTitle);
		
		JLabel labelMain = new JLabel("\u05E2\u05DE\u05D5\u05D3 \u05E8\u05D0\u05E9\u05D9");
		labelMain.setLabelFor(mainBTN);
		labelMain.setForeground(Color.WHITE);
		labelMain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelMain.setBounds(1036, 130, 240, 56);
		contentPane.add(labelMain);

		mainBTN.setVerticalAlignment(SwingConstants.TOP);
		mainBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
		mainBTN.setHorizontalAlignment(SwingConstants.LEFT);
		mainBTN.setBounds(1036, 130, 240, 56);
		contentPane.add(mainBTN);
		
		//Main Menu - detail 
		JLabel detailsBTN = new JLabel("");
		detailsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				detailsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = { "המשך", "בטל" };
				 if(JOptionPane.showOptionDialog(null, "הינך יוצא ממסך הזנת נתונים. נתונים חדשים לא ישמרו", "Warning",
			             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			             null, options, options[0]) == 0) {
				setVisible(false);	
				new MonthlyData().setVisible(true);
				}	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelDetails = new JLabel("\u05D4\u05D6\u05E0\u05EA \u05E0\u05EA\u05D5\u05E0\u05D9\u05DD");
		labelDetails.setHorizontalAlignment(SwingConstants.CENTER);
		labelDetails.setForeground(Color.WHITE);
		labelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDetails.setBounds(1036, 200, 240, 56);
		contentPane.add(labelDetails);
		labelDetails.setLabelFor(detailsBTN);
		
		detailsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
		detailsBTN.setVerticalAlignment(SwingConstants.TOP);
		detailsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		detailsBTN.setBounds(1036, 200, 240, 56);
		contentPane.add(detailsBTN);
		
		JLabel reportsBTN = new JLabel("");
		reportsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				reportsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = { "המשך", "בטל" };
				 if(JOptionPane.showOptionDialog(null, "הינך יוצא ממסך הזנת נתונים. נתונים חדשים לא ישמרו", "Warning",
			             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			             null, options, options[0]) == 0) {
				setVisible(false);	
				new Reports_custom().setVisible(true);
				}	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelReports = new JLabel("\u05D4\u05E4\u05E7\u05EA \u05D3\u05D5\u05D7\u05D5\u05EA");
		labelReports.setHorizontalAlignment(SwingConstants.CENTER);
		labelReports.setForeground(Color.WHITE);
		labelReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReports.setBounds(1036, 270, 240, 56);
		contentPane.add(labelReports);
		labelReports.setLabelFor(reportsBTN);
		reportsBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
		reportsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		reportsBTN.setVerticalAlignment(SwingConstants.TOP);
		reportsBTN.setBounds(1036, 270, 240, 56);
		contentPane.add(reportsBTN);
		
		JLabel helpBTN = new JLabel("");
		helpBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				helpBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = { "המשך", "בטל" };
				 if(JOptionPane.showOptionDialog(null, "הינך יוצא ממסך הזנת נתונים. נתונים חדשים לא ישמרו", "Warning",
			             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			             null, options, options[0]) == 0) {
				setVisible(false);	
				new Help().setVisible(true);
				}	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelHelp = new JLabel("\u05E2\u05D6\u05E8\u05D4");
		labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
		labelHelp.setForeground(Color.WHITE);
		labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHelp.setBounds(1036, 340, 240, 56);
		contentPane.add(labelHelp);
		labelHelp.setLabelFor(helpBTN);
		helpBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
		helpBTN.setHorizontalAlignment(SwingConstants.LEFT);
		helpBTN.setVerticalAlignment(SwingConstants.TOP);
		helpBTN.setBounds(1036, 340, 240, 56);
		contentPane.add(helpBTN);
		
		JLabel aboutBTN = new JLabel("");
		aboutBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				aboutBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = { "המשך", "בטל" };
				 if(JOptionPane.showOptionDialog(null, "הינך יוצא ממסך הזנת נתונים. נתונים חדשים לא ישמרו", "Warning",
			             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			             null, options, options[0]) == 0) {
				setVisible(false);	
				new About().setVisible(true);
				}	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelAbout = new JLabel("\u05D0\u05D5\u05D3\u05D5\u05EA");
		labelAbout.setHorizontalAlignment(SwingConstants.CENTER);
		labelAbout.setForeground(Color.WHITE);
		labelAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAbout.setBounds(1036, 410, 240, 56);
		contentPane.add(labelAbout);
		labelAbout.setLabelFor(aboutBTN);
		aboutBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn.jpg")));
		aboutBTN.setHorizontalAlignment(SwingConstants.LEFT);
		aboutBTN.setVerticalAlignment(SwingConstants.TOP);
		aboutBTN.setBounds(1036, 410, 240, 56);
		contentPane.add(aboutBTN);
		
		JLabel label = new JLabel("הזנת נתונים - " + MonthlyData.chosenMonth + " " + MonthlyData.chosenYear);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 47));
		label.setBounds(393, 26, 883, 56);
		contentPane.add(label);
		
		JLabel labelClear = new JLabel("\u05E0\u05E7\u05D4");
		labelClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelClear.setForeground(Color.YELLOW);
		labelClear.setHorizontalAlignment(SwingConstants.CENTER);
		labelClear.setBounds(943, 666, 60, 40);
		contentPane.add(labelClear);
		
		JLabel clearBTN = new JLabel("");
		clearBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				clearBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn40_60Over.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = { "מחק שדות", "בטל" };
				 if(JOptionPane.showOptionDialog(null, "האם למחוק את כל השדות בטופס?", "Warning",
			             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			             null, options, options[0]) == 0) {
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
						textField_10.setText("");
						textField_11.setText("");
						textField_12.setText("");
				}

			}
			@Override
			public void mousePressed(MouseEvent e) {
				clearBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn40_60Pushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				clearBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn40_60Over.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				clearBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn40_60.jpg")));
			}
		});
		clearBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn40_60.jpg")));
		clearBTN.setHorizontalAlignment(SwingConstants.CENTER);
		clearBTN.setBounds(943, 666, 60, 40);
		contentPane.add(clearBTN);
		
		JLabel labelOk = new JLabel("\u05D4\u05DE\u05E9\u05DA");
		labelOk.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		labelOk.setHorizontalAlignment(SwingConstants.CENTER);
		labelOk.setForeground(Color.WHITE);
		labelOk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelOk.setBounds(31, 714, 185, 56);
		contentPane.add(labelOk);
		
		JLabel okBTN = new JLabel("");
		okBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185Over.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) { // לחיצה על כפתור "המשך"
				
				// Insert monthly incomes into objects
				
				if (countMore == 0)
				{
					if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "אין להשאיר שדות ריקים");
						return;
					}
					else
					{	
					controller.insertSalaryInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField.getText().toString(), Double.parseDouble(textField_1.getText()));
					controller.insertAllowancesInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_3.getText()), Double.parseDouble(textField_4.getText()), Double.parseDouble(textField_5.getText()));
					if (!(textField_6.getText().isEmpty()) && !(textField_2.getText().isEmpty()))
					{
					controller.insertGiftsInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_6.getText().toString(), Double.parseDouble(textField_2.getText()));
					}
					}
				}
				
				else if (countMore == 1)
				{
					if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty() || textField_10.getText().isEmpty() || textField_9.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "אין להשאיר שדות ריקים");
						return;
					}
					else
					{
					controller.insertSalaryInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField.getText().toString(), Double.parseDouble(textField_1.getText()));
					controller.insertAllowancesInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_3.getText()), Double.parseDouble(textField_4.getText()), Double.parseDouble(textField_5.getText()));			
					controller.insertCustomIncomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_10.getText().toString(), Double.parseDouble(textField_9.getText()));
					if (!(textField_6.getText().isEmpty()) && !(textField_2.getText().isEmpty()))
					{
						controller.insertGiftsInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_6.getText().toString(), Double.parseDouble(textField_2.getText()));	
					}
					}	
				}
				
				else if (countMore == 2)
				{
					if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty() || textField_10.getText().isEmpty() || textField_9.getText().isEmpty() || textField_11.getText().isEmpty() || textField_8.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "אין להשאיר שדות ריקים");
						return;
					}
					else
					{
					controller.insertSalaryInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField.getText().toString(), Double.parseDouble(textField_1.getText()));
					controller.insertAllowancesInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_3.getText()), Double.parseDouble(textField_4.getText()), Double.parseDouble(textField_5.getText()));
					controller.insertCustomIncomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_10.getText().toString(), Double.parseDouble(textField_9.getText()));
					controller.insertCustomIncomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_11.getText().toString(), Double.parseDouble(textField_8.getText()));
					if (!(textField_6.getText().isEmpty()) && !(textField_2.getText().isEmpty()))
					{
						controller.insertGiftsInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_6.getText().toString(), Double.parseDouble(textField_2.getText()));	
					}
					}
				}
				
				else
				{
					if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty() || textField_10.getText().isEmpty() || textField_9.getText().isEmpty() || textField_11.getText().isEmpty() || textField_8.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "אין להשאיר שדות ריקים");
						return;
					}
					
					else
					{
						controller.insertSalaryInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField.getText().toString(), Double.parseDouble(textField_1.getText()));
						controller.insertAllowancesInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_3.getText()), Double.parseDouble(textField_4.getText()), Double.parseDouble(textField_5.getText()));
						controller.insertCustomIncomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_10.getText().toString(), Double.parseDouble(textField_9.getText()));
						controller.insertCustomIncomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_11.getText().toString(), Double.parseDouble(textField_8.getText()));	
						controller.insertCustomIncomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_12.getText().toString(), Double.parseDouble(textField_7.getText()));
						if (!(textField_6.getText().isEmpty()) && !(textField_2.getText().isEmpty()))
						{
							controller.insertGiftsInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_6.getText().toString(), Double.parseDouble(textField_2.getText()));	
						}
					}
					
				}
				
				setVisible(false);	
				new MonthlyData_out().setVisible(true);	
				
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
		okBTN.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/Btn185.jpg")));
		labelOk.setLabelFor(okBTN);
		okBTN.setBounds(31, 714, 185, 56);
		contentPane.add(okBTN);
		
		JLabel treeLevel = new JLabel("");
		treeLevel.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/treeLevel1.jpg")));
		treeLevel.setHorizontalAlignment(SwingConstants.CENTER);
		treeLevel.setBounds(27, 142, 300, 40);
		contentPane.add(treeLevel);
		
		JLabel dateLabel = new JLabel("");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateLabel.setForeground(Color.LIGHT_GRAY);
		dateLabel.setBounds(1036, 480, 240, 56);
		contentPane.add(dateLabel);
		
		JLabel back = new JLabel("");
		back.setName("background");
		back.setLabelFor(contentPane);
		back.setIcon(new ImageIcon(MonthlyData_in.class.getResource("/MM UI clean.JPG")));
		back.setVerticalAlignment(SwingConstants.TOP);
		back.setBounds(0, 0, 1300, 800);
		contentPane.add(back);
	
		date1(dateLabel);

	}
	
	public void date1(JLabel dateLabel) {
		String txtDate=new SimpleDateFormat ("dd/MM/YYYY", Locale.ENGLISH).format(new Date());
		dateLabel.setText(txtDate);
	}

}
