package View;
import java.util.Date;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MyMoneyController;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MonthlyData_out extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	private int countMore=0;   // Count how many records that belong to category "Other" added by the user
	private MyMoneyController controller2 = new MyMoneyController();
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;

	/**
	 * Create the frame.
	 */
	public MonthlyData_out() {
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
				mainBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
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
				mainBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel addBTN = new JLabel("+ הוסף הוצאה");
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

		
		JLabel label_24 = new JLabel(":: מזון וקמעונאות");
		label_24.setHorizontalAlignment(SwingConstants.RIGHT);
		label_24.setForeground(new Color(153, 255, 255));
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_24.setBounds(0, 380, 516, 33);
		contentPane.add(label_24);
		
		JLabel label_25 = new JLabel("קניות בסופר");
		label_25.setHorizontalAlignment(SwingConstants.RIGHT);
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_25.setBounds(276, 422, 240, 40);
		contentPane.add(label_25);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(SystemColor.activeCaption);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(73, 414, 450, 4);
		contentPane.add(separator_4);
		
		JLabel label_26 = new JLabel("מסעדות");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_26.setBounds(276, 472, 240, 40);
		contentPane.add(label_26);
		
		JLabel label_27 = new JLabel("ביגוד והנעלה");
		label_27.setHorizontalAlignment(SwingConstants.RIGHT);
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_27.setBounds(276, 522, 240, 40);
		contentPane.add(label_27);
		
		textField_15 = new JTextField();
		textField_15.setDocument(new JTextFieldLimit(11));
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_15.setColumns(10);
		textField_15.setBounds(124, 522, 140, 40);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setDocument(new JTextFieldLimit(11));
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_16.setColumns(10);
		textField_16.setBounds(124, 472, 140, 40);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setDocument(new JTextFieldLimit(11));
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_17.setColumns(10);
		textField_17.setBounds(124, 422, 140, 40);
		contentPane.add(textField_17);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setBounds(72, 422, 40, 40);
		contentPane.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setBounds(71, 472, 40, 40);
		contentPane.add(label_29);
		
		JLabel label_30 = new JLabel("");
		label_30.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setBounds(71, 522, 40, 40);
		contentPane.add(label_30);
		addBTN.setHorizontalAlignment(SwingConstants.RIGHT);
		addBTN.setForeground(Color.LIGHT_GRAY);
		addBTN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addBTN.setBounds(77, 577, 120, 33);
		contentPane.add(addBTN);
		
		textField_11 = new JTextField();
		textField_11.setDocument(new JTextFieldLimit(30));
		textField_11.setVisible(false);
		textField_11.setBackground(Color.WHITE);
		textField_11.setToolTipText("תיאור מקור ההכנסה");
		textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(280, 667, 240, 40);
		contentPane.add(textField_11);
		
		textField_8 = new JTextField();
		textField_8.setDocument(new JTextFieldLimit(11));
		textField_8.setVisible(false);
		textField_8.setBackground(Color.WHITE);
		textField_8.setToolTipText("סכום");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(128, 667, 140, 40);
		contentPane.add(textField_8);
		
		JLabel nis2 = new JLabel("");
		nis2.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		nis2.setHorizontalAlignment(SwingConstants.CENTER);
		nis2.setBounds(75, 667, 40, 40);
		contentPane.add(nis2);
		
		textField_10 = new JTextField();
		textField_10.setDocument(new JTextFieldLimit(30));
		textField_10.setVisible(false);
		textField_10.setColumns(10);
		textField_10.setBackground(Color.WHITE);
		textField_10.setToolTipText("תיאור מקור ההכנסה");
		textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_10.setBounds(280, 617, 240, 40);
		contentPane.add(textField_10);
		
		textField_9 = new JTextField();
		textField_9.setDocument(new JTextFieldLimit(11));
		textField_9.setVisible(false);
		textField_9.setBackground(Color.WHITE);
		textField_9.setToolTipText("סכום");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(128, 617, 140, 40);
		contentPane.add(textField_9);
		
		JLabel nis1 = new JLabel("");
		nis1.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		nis1.setHorizontalAlignment(SwingConstants.CENTER);
		nis1.setBounds(75, 617, 40, 40);
		contentPane.add(nis1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.activeCaption);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(77, 606, 450, 4);
		contentPane.add(separator_2);
		
		JLabel label_21 = new JLabel(":: הוצאות נוספות");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setForeground(new Color(153, 255, 255));
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_21.setBounds(186, 575, 334, 33);
		contentPane.add(label_21);
		
		JLabel label_14 = new JLabel("ביטוח בריאות");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_14.setBounds(276, 226, 240, 40);
		contentPane.add(label_14);
		
		textField_6 = new JTextField();
		textField_6.setDocument(new JTextFieldLimit(11));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(124, 226, 140, 40);
		contentPane.add(textField_6);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.activeCaption);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(73, 218, 450, 4);
		contentPane.add(separator_1);
		
		JLabel label_15 = new JLabel(":: ביטוחים");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setForeground(new Color(153, 255, 255));
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_15.setBounds(0, 184, 516, 33);
		contentPane.add(label_15);
		
		JLabel label_18 = new JLabel("אוטובוסים");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_18.setBounds(756, 561, 240, 40);
		contentPane.add(label_18);
		
		textField_13 = new JTextField();
		textField_13.setDocument(new JTextFieldLimit(11));
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_13.setColumns(10);
		textField_13.setBounds(604, 561, 140, 40);
		contentPane.add(textField_13);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(551, 561, 40, 40);
		contentPane.add(label_19);
		
		JLabel label_3 = new JLabel("רכבת");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(756, 514, 240, 40);
		contentPane.add(label_3);
		
		JLabel label_17 = new JLabel(":: תחבורה ציבורית");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setForeground(new Color(153, 255, 255));
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_17.setBounds(480, 472, 516, 33);
		contentPane.add(label_17);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(SystemColor.activeCaption);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(553, 506, 450, 4);
		contentPane.add(separator_3);
		
		textField_5 = new JTextField();
		textField_5.setDocument(new JTextFieldLimit(11));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(604, 514, 140, 40);
		contentPane.add(textField_5);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(551, 514, 40, 40);
		contentPane.add(label_12);
		
		JLabel label_10 = new JLabel("אחזקת רכב וטיפולים");
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
		label_11.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(551, 421, 40, 40);
		contentPane.add(label_11);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(551, 371, 40, 40);
		contentPane.add(label_1);
		
		JLabel label_8 = new JLabel("דלק");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_8.setBounds(756, 371, 240, 40);
		contentPane.add(label_8);
		
		textField_3 = new JTextField();
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
		
		JLabel label_9 = new JLabel(":: רכב");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(new Color(153, 255, 255));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_9.setBounds(480, 329, 516, 33);
		contentPane.add(label_9);
		
		JLabel label_20 = new JLabel("ביטוח רכב");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_20.setBounds(276, 326, 240, 40);
		contentPane.add(label_20);
		
		textField_14 = new JTextField();
		textField_14.setDocument(new JTextFieldLimit(11));
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_14.setColumns(10);
		textField_14.setBounds(124, 326, 140, 40);
		contentPane.add(textField_14);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBounds(71, 326, 40, 40);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBounds(72, 226, 40, 40);
		contentPane.add(label_23);
		
		JLabel label_6 = new JLabel("ביטוח חיים");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(276, 276, 240, 40);
		contentPane.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setDocument(new JTextFieldLimit(11));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(124, 276, 140, 40);
		contentPane.add(textField_2);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(71, 276, 40, 40);
		contentPane.add(label_7);
		
		JLabel label_4 = new JLabel("חשבונות שוטפים");
		label_4.setToolTipText("חשמל, מים, ביוב, גז");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(763, 278, 240, 40);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setDocument(new JTextFieldLimit(11));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(611, 278, 140, 40);
		contentPane.add(textField_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(558, 278, 40, 40);
		contentPane.add(label_5);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/nisWhite.png")));
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(558, 231, 40, 40);
		contentPane.add(label_16);
		
		JLabel label_2 = new JLabel("שכר דירה");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(763, 228, 240, 40);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
		textField.setDocument(new JTextFieldLimit(11));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(611, 229, 140, 40);
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
		
		JLabel subTitle1 = new JLabel(":: דירה");
		subTitle1.setHorizontalAlignment(SwingConstants.RIGHT);
		subTitle1.setForeground(new Color(153, 255, 255));
		subTitle1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subTitle1.setBounds(487, 189, 516, 33);
		contentPane.add(subTitle1);
		
		JLabel pageTitle = new JLabel("הוצאות");
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
		mainBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
		mainBTN.setHorizontalAlignment(SwingConstants.LEFT);
		mainBTN.setBounds(1036, 130, 240, 56);
		contentPane.add(mainBTN);
		
		//Main Menu - detail 
		JLabel detailsBTN = new JLabel("");
		detailsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				detailsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
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
				detailsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelDetails = new JLabel("\u05D4\u05D6\u05E0\u05EA \u05E0\u05EA\u05D5\u05E0\u05D9\u05DD");
		labelDetails.setHorizontalAlignment(SwingConstants.CENTER);
		labelDetails.setForeground(Color.WHITE);
		labelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDetails.setBounds(1036, 200, 240, 56);
		contentPane.add(labelDetails);
		labelDetails.setLabelFor(detailsBTN);
		
		detailsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
		detailsBTN.setVerticalAlignment(SwingConstants.TOP);
		detailsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		detailsBTN.setBounds(1036, 200, 240, 56);
		contentPane.add(detailsBTN);
		
		JLabel reportsBTN = new JLabel("");
		reportsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				reportsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
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
				reportsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelReports = new JLabel("\u05D4\u05E4\u05E7\u05EA \u05D3\u05D5\u05D7\u05D5\u05EA");
		labelReports.setHorizontalAlignment(SwingConstants.CENTER);
		labelReports.setForeground(Color.WHITE);
		labelReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReports.setBounds(1036, 270, 240, 56);
		contentPane.add(labelReports);
		labelReports.setLabelFor(reportsBTN);
		reportsBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
		reportsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		reportsBTN.setVerticalAlignment(SwingConstants.TOP);
		reportsBTN.setBounds(1036, 270, 240, 56);
		contentPane.add(reportsBTN);
		
		JLabel helpBTN = new JLabel("");
		helpBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				helpBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
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
				helpBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelHelp = new JLabel("\u05E2\u05D6\u05E8\u05D4");
		labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
		labelHelp.setForeground(Color.WHITE);
		labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHelp.setBounds(1036, 340, 240, 56);
		contentPane.add(labelHelp);
		labelHelp.setLabelFor(helpBTN);
		helpBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
		helpBTN.setHorizontalAlignment(SwingConstants.LEFT);
		helpBTN.setVerticalAlignment(SwingConstants.TOP);
		helpBTN.setBounds(1036, 340, 240, 56);
		contentPane.add(helpBTN);
		
		JLabel aboutBTN = new JLabel("");
		aboutBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				aboutBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
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
				aboutBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelAbout = new JLabel("\u05D0\u05D5\u05D3\u05D5\u05EA");
		labelAbout.setHorizontalAlignment(SwingConstants.CENTER);
		labelAbout.setForeground(Color.WHITE);
		labelAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAbout.setBounds(1036, 410, 240, 56);
		contentPane.add(labelAbout);
		labelAbout.setLabelFor(aboutBTN);
		aboutBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn.jpg")));
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
				clearBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn40_60Over.jpg")));
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
						textField_13.setText("");
						textField_8.setText("");
						textField_9.setText("");
						textField_10.setText("");
						textField_11.setText("");
						textField_14.setText("");
						textField_15.setText("");
						textField_16.setText("");
						textField_17.setText("");
				}

			}
			@Override
			public void mousePressed(MouseEvent e) {
				clearBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn40_60Pushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				clearBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn40_60Over.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				clearBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn40_60.jpg")));
			}
		});
		clearBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn40_60.jpg")));
		clearBTN.setHorizontalAlignment(SwingConstants.CENTER);
		clearBTN.setBounds(943, 666, 60, 40);
		contentPane.add(clearBTN);
		
		JLabel labelOk = new JLabel("המשך");
		labelOk.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		labelOk.setHorizontalAlignment(SwingConstants.CENTER);
		labelOk.setForeground(Color.WHITE);
		labelOk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelOk.setBounds(31, 714, 185, 56);
		contentPane.add(labelOk);
		
		JLabel okBTN = new JLabel("");
		okBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				okBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn185Over.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) { // OK Button
				
				// Insert monthly incomes into objects
				
				
				if (countMore == 0)
				{
					if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty() || textField_13.getText().isEmpty() || textField_6.getText().isEmpty() || textField_2.getText().isEmpty() || textField_14.getText().isEmpty() || textField_17.getText().isEmpty() || textField_16.getText().isEmpty() || textField_15.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "אין להשאיר שדות ריקים");
						return;
					}
					else
					{	
						controller2.insertApartmentInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField.getText()), Double.parseDouble(textField_1.getText()));
						controller2.insertCarInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_3.getText()), Double.parseDouble(textField_4.getText()));
						controller2.insertPublicTransportationInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_5.getText()), Double.parseDouble(textField_13.getText()));
						controller2.insertInsurancesInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_6.getText()), Double.parseDouble(textField_2.getText()), Double.parseDouble(textField_14.getText()));
					    controller2.insertFoodAndShoppingInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_17.getText()), Double.parseDouble(textField_16.getText()), Double.parseDouble(textField_15.getText()));
					}
				}
				
				
			    if (countMore == 1)
			    {
			    	if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty() || textField_13.getText().isEmpty() || textField_6.getText().isEmpty() || textField_2.getText().isEmpty() || textField_14.getText().isEmpty() || textField_17.getText().isEmpty() || textField_16.getText().isEmpty() || textField_15.getText().isEmpty() || textField_10.getText().isEmpty() || textField_9.getText().isEmpty())
			    	{
			    		JOptionPane.showMessageDialog(null, "אין להשאיר שדות ריקים");
						return;
			    	}
			    	else
			    	{
			    		controller2.insertApartmentInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField.getText()), Double.parseDouble(textField_1.getText()));
						controller2.insertCarInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_3.getText()), Double.parseDouble(textField_4.getText()));
						controller2.insertPublicTransportationInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_5.getText()), Double.parseDouble(textField_13.getText()));
						controller2.insertInsurancesInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_6.getText()), Double.parseDouble(textField_2.getText()), Double.parseDouble(textField_14.getText()));
					    controller2.insertFoodAndShoppingInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_17.getText()), Double.parseDouble(textField_16.getText()), Double.parseDouble(textField_15.getText()));
					    controller2.insertCustomOutcomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_10.getText().toString(), Double.parseDouble(textField_9.getText()));
			    	}
			    	
			    	if (countMore == 2)
			    	{
			    		if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty() || textField_13.getText().isEmpty() || textField_6.getText().isEmpty() || textField_2.getText().isEmpty() || textField_14.getText().isEmpty() || textField_17.getText().isEmpty() || textField_16.getText().isEmpty() || textField_15.getText().isEmpty() || textField_10.getText().isEmpty() || textField_9.getText().isEmpty() || textField_11.getText().isEmpty() || textField_8.getText().isEmpty())
			    		{
			    			JOptionPane.showMessageDialog(null, "אין להשאיר שדות ריקים");
							return;	
			    		}
			    		else
			    		{
					    controller2.insertApartmentInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField.getText()), Double.parseDouble(textField_1.getText()));
						controller2.insertCarInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_3.getText()), Double.parseDouble(textField_4.getText()));
						controller2.insertPublicTransportationInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_5.getText()), Double.parseDouble(textField_13.getText()));
						controller2.insertInsurancesInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_6.getText()), Double.parseDouble(textField_2.getText()), Double.parseDouble(textField_14.getText()));
						controller2.insertFoodAndShoppingInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, Double.parseDouble(textField_17.getText()), Double.parseDouble(textField_16.getText()), Double.parseDouble(textField_15.getText()));
						controller2.insertCustomOutcomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_10.getText().toString(), Double.parseDouble(textField_9.getText()));	
						controller2.insertCustomOutcomeInstance(MonthlyData.chosenMonth, MonthlyData.chosenYear, textField_11.getText().toString(), Double.parseDouble(textField_8.getText()));	
			    		}
			    	}
			    	
			    }
			    
				setVisible(false);	
				try {
					new MonthlyData_sum().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				okBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn185Pushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				okBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn185Over.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				okBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn185.jpg")));
			}
		});
		okBTN.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/Btn185.jpg")));
		labelOk.setLabelFor(okBTN);
		okBTN.setBounds(31, 714, 185, 56);
		contentPane.add(okBTN);
		
		JLabel treeLevel = new JLabel("");
		treeLevel.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/treeLevel2.jpg")));
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
		back.setIcon(new ImageIcon(MonthlyData_out.class.getResource("/MM UI clean.JPG")));
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
