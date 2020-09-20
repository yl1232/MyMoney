package View;
import java.util.Date;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Canvas;

import javax.swing.table.DefaultTableModel;

import Controller.MyMoneyController;
import Model.DBFunctions1;
import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Reports_custom extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private boolean dataExists;
    private JTable table_1;
	private MyMoneyController controller = new MyMoneyController();

	/**
	 * Create the frame.
	 */
	public Reports_custom() {
		setResizable(false);
		setTitle("MyMoney");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 828);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		//Main Menu - main 
		JLabel mainBTN = new JLabel("");
		mainBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
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
				mainBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
			}
		});
		
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
		
		JLabel pageTitle = new JLabel("\u05D3\u05D5\u05D7 \u05DE\u05D5\u05EA\u05D0\u05DD \u05D0\u05D9\u05E9\u05D9\u05EA");
		pageTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		pageTitle.setForeground(Color.WHITE);
		pageTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pageTitle.setBounds(27, 130, 976, 56);
		contentPane.add(pageTitle);
		
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"בחר קטגוריה", "דירה", "רכב", "תחבורה ציבורית", "ביטוחים", "מזון וקמעונאות", "אחר"}));
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_3.setBounds(329, 199, 187, 40);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"בחר קטגוריה", "משכורת", "קצבאות", "מתנות", "אחר"}));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_4.setBounds(329, 199, 187, 40);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		if (comboBox_2.getSelectedItem().toString() == "הכנסות")
				{
					comboBox_3.setVisible(false);
					comboBox_4.setVisible(true);
				}
		else if (comboBox_2.getSelectedItem().toString() == "הוצאות")
		{
					comboBox_4.setVisible(false);
					comboBox_3.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "יש לבחור סוג רשומה");
			return;
		}
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\u05D1\u05D7\u05E8 \u05E1\u05D5\u05D2 \u05E8\u05E9\u05D5\u05DE\u05D4", "\u05D4\u05D5\u05E6\u05D0\u05D5\u05EA", "\u05D4\u05DB\u05E0\u05E1\u05D5\u05EA"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_2.setBounds(528, 199, 176, 40);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u05D1\u05D7\u05E8 \u05E9\u05E0\u05D4", "2019", "2020", "2021", "2022"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(716, 199, 131, 40);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u05D1\u05D7\u05E8 \u05D7\u05D5\u05D3\u05E9", "\u05D9\u05E0\u05D5\u05D0\u05E8", "\u05E4\u05D1\u05E8\u05D5\u05D0\u05E8", "\u05DE\u05E8\u05E5", "\u05D0\u05E4\u05E8\u05D9\u05DC", "\u05DE\u05D0\u05D9", "\u05D9\u05D5\u05E0\u05D9", "\u05D9\u05D5\u05DC\u05D9", "\u05D0\u05D5\u05D2\u05D5\u05E1\u05D8", "\u05E1\u05E4\u05D8\u05DE\u05D1\u05E8", "\u05D0\u05D5\u05E7\u05D8\u05D5\u05D1\u05E8", "\u05E0\u05D5\u05D1\u05DE\u05D1\u05E8", "\u05D3\u05E6\u05DE\u05D1\u05E8"}));
		comboBox.setBounds(857, 199, 146, 40);
		contentPane.add(comboBox);
		
		JLabel labelMain = new JLabel("\u05E2\u05DE\u05D5\u05D3 \u05E8\u05D0\u05E9\u05D9");
		labelMain.setLabelFor(mainBTN);
		labelMain.setForeground(Color.WHITE);
		labelMain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelMain.setBounds(1036, 130, 240, 56);
		contentPane.add(labelMain);

		mainBTN.setVerticalAlignment(SwingConstants.TOP);
		mainBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
		mainBTN.setHorizontalAlignment(SwingConstants.LEFT);
		mainBTN.setBounds(1036, 130, 240, 56);
		contentPane.add(mainBTN);
		
		//Main Menu - detail 
		JLabel detailsBTN = new JLabel("");
		detailsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				detailsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new MonthlyData().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelDetails = new JLabel("\u05D4\u05D6\u05E0\u05EA \u05E0\u05EA\u05D5\u05E0\u05D9\u05DD");
		labelDetails.setHorizontalAlignment(SwingConstants.CENTER);
		labelDetails.setForeground(Color.WHITE);
		labelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDetails.setBounds(1036, 200, 240, 56);
		contentPane.add(labelDetails);
		labelDetails.setLabelFor(detailsBTN);
		
		detailsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
		detailsBTN.setVerticalAlignment(SwingConstants.TOP);
		detailsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		detailsBTN.setBounds(1036, 200, 240, 56);
		contentPane.add(detailsBTN);
		
		JLabel reportsBTN = new JLabel("");
		reportsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				reportsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Reports_custom().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelReports = new JLabel("\u05D4\u05E4\u05E7\u05EA \u05D3\u05D5\u05D7\u05D5\u05EA");
		labelReports.setHorizontalAlignment(SwingConstants.CENTER);
		labelReports.setForeground(Color.WHITE);
		labelReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReports.setBounds(1036, 270, 240, 56);
		contentPane.add(labelReports);
		labelReports.setLabelFor(reportsBTN);
		reportsBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
		reportsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		reportsBTN.setVerticalAlignment(SwingConstants.TOP);
		reportsBTN.setBounds(1036, 270, 240, 56);
		contentPane.add(reportsBTN);
		
		JLabel helpBTN = new JLabel("");
		helpBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				helpBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Help().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelHelp = new JLabel("\u05E2\u05D6\u05E8\u05D4");
		labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
		labelHelp.setForeground(Color.WHITE);
		labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHelp.setBounds(1036, 340, 240, 56);
		contentPane.add(labelHelp);
		labelHelp.setLabelFor(helpBTN);
		helpBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
		helpBTN.setHorizontalAlignment(SwingConstants.LEFT);
		helpBTN.setVerticalAlignment(SwingConstants.TOP);
		helpBTN.setBounds(1036, 340, 240, 56);
		contentPane.add(helpBTN);
		
		JLabel aboutBTN = new JLabel("");
		aboutBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				aboutBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new About().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelAbout = new JLabel("\u05D0\u05D5\u05D3\u05D5\u05EA");
		labelAbout.setHorizontalAlignment(SwingConstants.CENTER);
		labelAbout.setForeground(Color.WHITE);
		labelAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAbout.setBounds(1036, 410, 240, 56);
		contentPane.add(labelAbout);
		labelAbout.setLabelFor(aboutBTN);
		aboutBTN.setIcon(new ImageIcon(Reports_custom.class.getResource("/Btn.jpg")));
		aboutBTN.setHorizontalAlignment(SwingConstants.LEFT);
		aboutBTN.setVerticalAlignment(SwingConstants.TOP);
		aboutBTN.setBounds(1036, 410, 240, 56);
		contentPane.add(aboutBTN);
		
		JLabel label = new JLabel("\u05D4\u05E4\u05E7\u05EA \u05D3\u05D5\u05D7\u05D5\u05EA");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 47));
		label.setBounds(393, 26, 883, 56);
		contentPane.add(label);
		
		JLabel dateLabel = new JLabel("");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateLabel.setForeground(Color.LIGHT_GRAY);
		dateLabel.setBounds(1036, 480, 240, 56);
		contentPane.add(dateLabel);
		
		JButton reportsButton = new JButton("\u05D4\u05E6\u05D2");
		reportsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		reportsButton.addActionListener(new ActionListener() {     // Display the table according to selected parameters
			public void actionPerformed(ActionEvent arg0) {
				try {
					table_1 = new JTable();
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(34, 270, 911, 296);
					contentPane.add(scrollPane);
					scrollPane.setViewportView(table_1);
					String month = comboBox.getSelectedItem().toString();
					String year = comboBox_1.getSelectedItem().toString();
					String type = comboBox_2.getSelectedItem().toString();
					String category = " ";
					if (comboBox_2.getSelectedItem().toString() == "הכנסות")
					{
						category = comboBox_4.getSelectedItem().toString();
					}
					else if (comboBox_2.getSelectedItem().toString() == "הוצאות")
					{
						category = comboBox_3.getSelectedItem().toString();
					}
				
					ResultSet rs = controller.displayTable(month,year,type,category);
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		reportsButton.setBounds(201, 199, 116, 40);
		contentPane.add(reportsButton);
		
		JButton button = new JButton("\u05E1\u05D9\u05DB\u05D5\u05DD \u05D7\u05D5\u05D3\u05E9\u05D9");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { // Display monthly summary of the selected month and year
				try {
					if (comboBox.getSelectedItem().toString() == "בחר חודש")
					{
						JOptionPane.showMessageDialog(null, "יש לבחור חודש");
						return;	
					}
					if (comboBox_1.getSelectedItem().toString() == "בחר שנה")
					{
						JOptionPane.showMessageDialog(null, "יש לבחור שנה");
						return;	
					}
					dataExists = controller.checkIfDataExists(comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString());
					if (dataExists == true)
					{
						MonthlyData.chosenMonth = comboBox.getSelectedItem().toString();
						MonthlyData.chosenYear = comboBox_1.getSelectedItem().toString();
						setVisible(false);
						new Monthly_Summary().setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "לא קיימים נתונים עבור חודש זה");
						return;
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(31, 199, 158, 40);
		contentPane.add(button);
		
		
		JLabel back = new JLabel("");
		back.setName("background");
		back.setLabelFor(contentPane);
		back.setIcon(new ImageIcon(Reports_custom.class.getResource("/MM UI clean.JPG")));
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

		

