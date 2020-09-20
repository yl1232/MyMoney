package View;
import java.util.Date;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Help() {
		setResizable(false);
		setTitle("MyMoney");
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
		
		JLabel pageTitle = new JLabel("\u05D8\u05D9\u05E4\u05D9\u05DD \u05DC\u05E0\u05D9\u05D4\u05D5\u05DC \u05DB\u05DC\u05DB\u05DC\u05D9 \u05E0\u05DB\u05D5\u05DF");
		pageTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		pageTitle.setForeground(Color.WHITE);
		pageTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pageTitle.setBounds(27, 130, 976, 56);
		contentPane.add(pageTitle);
		
		JLabel labelMain = new JLabel("\u05E2\u05DE\u05D5\u05D3 \u05E8\u05D0\u05E9\u05D9");
		labelMain.setLabelFor(mainBTN);
		labelMain.setForeground(Color.WHITE);
		labelMain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelMain.setBounds(1036, 130, 240, 56);
		contentPane.add(labelMain);

		mainBTN.setVerticalAlignment(SwingConstants.TOP);
		mainBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
		mainBTN.setHorizontalAlignment(SwingConstants.LEFT);
		mainBTN.setBounds(1036, 130, 240, 56);
		contentPane.add(mainBTN);
		
		//Main Menu - detail 
		JLabel detailsBTN = new JLabel("");
		detailsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				detailsBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new MonthlyData().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelDetails = new JLabel("\u05D4\u05D6\u05E0\u05EA \u05E0\u05EA\u05D5\u05E0\u05D9\u05DD");
		labelDetails.setHorizontalAlignment(SwingConstants.CENTER);
		labelDetails.setForeground(Color.WHITE);
		labelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDetails.setBounds(1036, 200, 240, 56);
		contentPane.add(labelDetails);
		labelDetails.setLabelFor(detailsBTN);
		
		detailsBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
		detailsBTN.setVerticalAlignment(SwingConstants.TOP);
		detailsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		detailsBTN.setBounds(1036, 200, 240, 56);
		contentPane.add(detailsBTN);
		
		JLabel reportsBTN = new JLabel("");
		reportsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				reportsBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Reports_custom().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelReports = new JLabel("\u05D4\u05E4\u05E7\u05EA \u05D3\u05D5\u05D7\u05D5\u05EA");
		labelReports.setHorizontalAlignment(SwingConstants.CENTER);
		labelReports.setForeground(Color.WHITE);
		labelReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReports.setBounds(1036, 270, 240, 56);
		contentPane.add(labelReports);
		labelReports.setLabelFor(reportsBTN);
		reportsBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
		reportsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		reportsBTN.setVerticalAlignment(SwingConstants.TOP);
		reportsBTN.setBounds(1036, 270, 240, 56);
		contentPane.add(reportsBTN);
		
		JLabel helpBTN = new JLabel("");
		helpBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				helpBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Help().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelHelp = new JLabel("\u05E2\u05D6\u05E8\u05D4");
		labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
		labelHelp.setForeground(Color.WHITE);
		labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHelp.setBounds(1036, 340, 240, 56);
		contentPane.add(labelHelp);
		labelHelp.setLabelFor(helpBTN);
		helpBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
		helpBTN.setHorizontalAlignment(SwingConstants.LEFT);
		helpBTN.setVerticalAlignment(SwingConstants.TOP);
		helpBTN.setBounds(1036, 340, 240, 56);
		contentPane.add(helpBTN);
		
		JLabel aboutBTN = new JLabel("");
		aboutBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				aboutBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new About().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Help.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelAbout = new JLabel("\u05D0\u05D5\u05D3\u05D5\u05EA");
		labelAbout.setHorizontalAlignment(SwingConstants.CENTER);
		labelAbout.setForeground(Color.WHITE);
		labelAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAbout.setBounds(1036, 410, 240, 56);
		contentPane.add(labelAbout);
		labelAbout.setLabelFor(aboutBTN);
		aboutBTN.setIcon(new ImageIcon(Help.class.getResource("/Btn.jpg")));
		aboutBTN.setHorizontalAlignment(SwingConstants.LEFT);
		aboutBTN.setVerticalAlignment(SwingConstants.TOP);
		aboutBTN.setBounds(1036, 410, 240, 56);
		contentPane.add(aboutBTN);
		
		JLabel label = new JLabel("\u05E2\u05D6\u05E8\u05D4");
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
		
		JLabel label_1 = new JLabel("\u05DE\u05D5\u05DE\u05DC\u05E5 \u05DC\u05D4\u05EA\u05D9\u05D9\u05D7\u05E1 \u05DC\u05D4\u05DB\u05E0\u05E1\u05D5\u05EA \u05D5\u05D4\u05D5\u05E6\u05D0\u05D5\u05EA \u05E9\u05DC \u05DB\u05DC \u05DE\u05E9\u05E7 \u05D4\u05D1\u05D9\u05EA, \u05D5\u05DC\u05D0 \u05E8\u05E7 \u05DC\u05D4\u05DB\u05E0\u05E1\u05D5\u05EA \u05D5\u05D4\u05D5\u05E6\u05D0\u05D5\u05EA \u05E9\u05DC\u05DB\u05DD");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(31, 189, 976, 56);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u05E2\u05E6\u05DE\u05DB\u05DD. \u05D1\u05DB\u05DC \u05DE\u05E7\u05E8\u05D4, \u05D4\u05D9\u05D5 \u05D0\u05D7\u05D9\u05D3\u05D9\u05DD.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setBounds(31, 243, 976, 56);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u05DB\u05D3\u05D0\u05D9 \u05DC\u05D4\u05D9\u05E2\u05D6\u05E8 \u05D1\u05D3\u05D5\u05D7\u05D5\u05EA \u05E9\u05E7\u05D9\u05D1\u05DC\u05EA\u05DD \u05DE\u05D4\u05D1\u05E0\u05E7, \u05D7\u05D1\u05E8\u05D5\u05EA \u05DB\u05E8\u05D8\u05D9\u05E1\u05D9 \u05D4\u05D0\u05E9\u05E8\u05D0\u05D9 \u05D5\u05D7\u05D1\u05E8\u05D5\u05EA \u05D4\u05D1\u05D9\u05D8\u05D5\u05D7");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_3.setBounds(31, 300, 976, 56);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u05D5\u05DB\u05DF \u05D1\u05EA\u05DC\u05D5\u05E9\u05D9 \u05D4\u05E9\u05DB\u05E8 \u05D4\u05D0\u05D7\u05E8\u05D5\u05E0\u05D9\u05DD.");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_4.setBounds(31, 354, 976, 56);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u05E2\u05E6\u05DE\u05D0\u05D9\u05DD, \u05D4\u05E7\u05E4\u05D9\u05D3\u05D5 \u05DC\u05D4\u05E4\u05E8\u05D9\u05D3 \u05D1\u05D9\u05DF \u05D4\u05D5\u05E6\u05D0\u05D5\u05EA \u05D4\u05E2\u05E1\u05E7 \u05DC\u05D4\u05D5\u05E6\u05D0\u05D5\u05EA \u05D4\u05D1\u05D9\u05EA.");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_5.setBounds(31, 410, 976, 56);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u05DB\u05DC\u05DC \u05D4\u05E0\u05EA\u05D5\u05E0\u05D9\u05DD \u05D4\u05DE\u05D5\u05D6\u05E0\u05D9\u05DD \u05DE\u05EA\u05D9\u05D9\u05D7\u05E1\u05D9\u05DD \u05DC\u05D4\u05D5\u05E6\u05D0\u05D4 \u05D7\u05D5\u05D3\u05E9\u05D9\u05EA \u05D1\u05DC\u05D1\u05D3.");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_6.setBounds(31, 464, 976, 56);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u05D9\u05E9 \u05DC\u05D4\u05E7\u05E4\u05D9\u05D3 \u05DC\u05E1\u05D5\u05D5\u05D2 \u05D4\u05D5\u05E6\u05D0\u05D4 \u05EA\u05D7\u05EA \u05E7\u05D8\u05D2\u05D5\u05E8\u05D9\u05D4 \u05D0\u05D7\u05EA \u05D1\u05DC\u05D1\u05D3 \u05E2\u05DC \u05DE\u05E0\u05EA \u05DC\u05D4\u05D9\u05DE\u05E0\u05E2 \u05DE\u05D7\u05D9\u05E9\u05D5\u05D1 \u05DB\u05E4\u05D5\u05DC");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_7.setBounds(31, 521, 976, 56);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u05E9\u05DC \u05D0\u05D5\u05EA\u05D4 \u05D4\u05D5\u05E6\u05D0\u05D4.");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_8.setBounds(31, 575, 976, 56);
		contentPane.add(label_8);
		
		JLabel back = new JLabel("");
		back.setName("background");
		back.setLabelFor(contentPane);
		back.setIcon(new ImageIcon(Help.class.getResource("/MM UI clean.JPG")));
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
