package View;
import java.util.Date;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

public class Monthly_Summary extends JFrame { // Monthly Summary page, reached from Reports page

	private JPanel contentPane;
	private MyMoneyController controller = new MyMoneyController();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	
	public Monthly_Summary() throws SQLException {
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
				mainBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
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
				mainBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/nisWhite.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(558, 328, 40, 40);
		contentPane.add(label_1);
		
		JLabel label_8 = new JLabel("מאזן חודשי");
		label_8.setToolTipText("הכנסות פחות הוצאות");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_8.setBounds(763, 328, 240, 40);
		contentPane.add(label_8);
		
		JLabel label_19 = new JLabel(Double.toString(controller.calculateMonthlyBalance(MonthlyData.chosenMonth, MonthlyData.chosenYear)));
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_19.setBounds(610, 328, 160, 40);
		contentPane.add(label_19);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/num160.jpg")));
		label_9.setBounds(611, 328, 160, 40);
		contentPane.add(label_9);
		
		
		if (Double.parseDouble(label_19.getText())>0)
		{
		
		JLabel label_20 = new JLabel("כדאי לכתוב תובנות בתיבת הערות אישיות.");
		label_20.setVerticalAlignment(SwingConstants.TOP);
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_20.setBounds(26, 336, 510, 33);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel("נסה להבין ממה נובעת היתרה והחלט האם להכניס לחיסכון.");
		label_21.setVerticalAlignment(SwingConstants.TOP);
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_21.setBounds(26, 303, 510, 33);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel("החודש הצלחת לעמוד במאזן חודשי תקין.");
		label_22.setVerticalAlignment(SwingConstants.TOP);
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_22.setBounds(26, 270, 510, 33);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("מאזן חודשי חיובי");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_23.setBounds(26, 222, 510, 45);
		contentPane.add(label_23);
		}
		else
		{	
		JLabel label_14 = new JLabel("על סכומי ההוצאות בקטגוריות בעלות פוטנציאל לחריגה.");
		label_14.setVerticalAlignment(SwingConstants.TOP);
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_14.setBounds(26, 336, 510, 33);
		contentPane.add(label_14);
		
		JLabel label_13 = new JLabel("למנוע את החריגה מהתקציב. כדאי לעקוב במהלך החודש");
		label_13.setVerticalAlignment(SwingConstants.TOP);
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_13.setBounds(26, 303, 510, 33);
		contentPane.add(label_13);
		
		JLabel label_12 = new JLabel("עליך לבדוק באיזו קטגוריה היתה חריגה החודש ואיך היה ניתן");
		label_12.setVerticalAlignment(SwingConstants.TOP);
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_12.setBounds(26, 270, 510, 33);
		contentPane.add(label_12);
		
		JLabel label_11 = new JLabel("מאזן חודשי שלילי");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setForeground(Color.WHITE);
		label_11.setBounds(26, 222, 510, 45);
		contentPane.add(label_11);

		
		}
		
		
		
		JLabel label_4 = new JLabel("סך הוצאות");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(763, 278, 240, 40);
		contentPane.add(label_4);
		
		JLabel label_18 = new JLabel(Double.toString(controller.calculateMonthlyExpenses(MonthlyData.chosenMonth, MonthlyData.chosenYear)));
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_18.setBounds(611, 278, 160, 40);
		contentPane.add(label_18);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/num160.jpg")));
		label_7.setBounds(611, 278, 160, 40);
		contentPane.add(label_7);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/nisWhite.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(558, 278, 40, 40);
		contentPane.add(label_5);
		
		JLabel label_2 = new JLabel("סך הכנסות");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(763, 228, 240, 40);
		contentPane.add(label_2);
		
		JLabel label_17 = new JLabel(Double.toString(controller.calculateMonthlyProfits(MonthlyData.chosenMonth, MonthlyData.chosenYear)));
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_17.setBounds(611, 228, 160, 40);
		contentPane.add(label_17);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/num160.jpg")));
		label_6.setBounds(611, 229, 160, 40);
		contentPane.add(label_6);
		
		
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/nisWhite.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(558, 229, 40, 40);
		contentPane.add(label_3);
		
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
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane.setBounds(558, 431, 448, 270);
		contentPane.add(textPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.activeCaption);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(26, 416, 520, 4);
		contentPane.add(separator_1);
		
		JLabel label_16 = new JLabel(":: תרשים פילוח הוצאות לפי קטגוריה");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setForeground(new Color(153, 255, 255));
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_16.setBounds(25, 381, 516, 33);
		contentPane.add(label_16);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(Color.BLACK);
		separator.setBounds(558, 416, 450, 4);
		contentPane.add(separator);
		
		JLabel label_15 = new JLabel(":: הערות אישיות");
		label_15.setToolTipText("כתוב את המאפיינים המיוחדים לחודש זה - אירועים מיוחדים, ימי הולדת, לידה, טיסה וכו. הוסף תובנות הנובעות מהתנהלות הכלכלית החודש.");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setForeground(new Color(153, 255, 255));
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_15.setBounds(487, 381, 516, 33);
		contentPane.add(label_15);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(SystemColor.activeCaption);
		separator1.setBackground(Color.BLACK);
		separator1.setBounds(560, 222, 450, 4);
		contentPane.add(separator1);
		
		JLabel subTitle1 = new JLabel(":: חישוב מאזן חודשי");
		subTitle1.setHorizontalAlignment(SwingConstants.RIGHT);
		subTitle1.setForeground(new Color(153, 255, 255));
		subTitle1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subTitle1.setBounds(487, 189, 516, 33);
		contentPane.add(subTitle1);
		
		JLabel pageTitle = new JLabel("סיכום");
		pageTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		pageTitle.setForeground(Color.WHITE);
		pageTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pageTitle.setBounds(477, 130, 526, 56);
		contentPane.add(pageTitle);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/box.jpg")));
		label_10.setBounds(26, 222, 520, 146);
		contentPane.add(label_10);
		
		JLabel labelMain = new JLabel("\u05E2\u05DE\u05D5\u05D3 \u05E8\u05D0\u05E9\u05D9");
		labelMain.setLabelFor(mainBTN);
		labelMain.setForeground(Color.WHITE);
		labelMain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelMain.setBounds(1036, 130, 240, 56);
		contentPane.add(labelMain);

		mainBTN.setVerticalAlignment(SwingConstants.TOP);
		mainBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
		mainBTN.setHorizontalAlignment(SwingConstants.LEFT);
		mainBTN.setBounds(1036, 130, 240, 56);
		contentPane.add(mainBTN);
		
		
		/// Pie Chart ////
		
		JPanel panelForPieChart = new JPanel();
			panelForPieChart.setBounds(31, 431, 510, 270);
			contentPane.add(panelForPieChart);
		DefaultPieDataset dataset = new DefaultPieDataset( );
		 dataset.setValue( "דירה" , controller.calculateMonthlyExpensesByCategory("דירה", MonthlyData.chosenMonth, MonthlyData.chosenYear) );
	      dataset.setValue( "רכב" , controller.calculateMonthlyExpensesByCategory("רכב", MonthlyData.chosenMonth, MonthlyData.chosenYear) );  
	      dataset.setValue( "תחבורה ציבורית" , controller.calculateMonthlyExpensesByCategory("תחבורה ציבורית", MonthlyData.chosenMonth, MonthlyData.chosenYear) );  
	      dataset.setValue( "ביטוחים" , controller.calculateMonthlyExpensesByCategory("ביטוחים", MonthlyData.chosenMonth, MonthlyData.chosenYear) );     
	      dataset.setValue( "מזון וקמעונאות" , controller.calculateMonthlyExpensesByCategory("מזון וקמעונאות", MonthlyData.chosenMonth, MonthlyData.chosenYear) );  
	      dataset.setValue( "אחר" , controller.calculateMonthlyExpensesByCategory("אחר", MonthlyData.chosenMonth, MonthlyData.chosenYear) );  
	      
	    JFreeChart PieChart = ChartFactory.createPieChart(      
	    	         "",   // chart title 
	    	         dataset,          // data    
	    	         true,             // include legend   
	    	         true, 
	    	         false);
	
		ChartPanel CP = new ChartPanel(PieChart);
		CP.setPreferredSize(new Dimension(510, 270));
	
		panelForPieChart.add(CP);
		
		
		//////
		
		
		//Main Menu - detail 
		JLabel detailsBTN = new JLabel("");
		detailsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				detailsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new MonthlyData().setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelDetails = new JLabel("\u05D4\u05D6\u05E0\u05EA \u05E0\u05EA\u05D5\u05E0\u05D9\u05DD");
		labelDetails.setHorizontalAlignment(SwingConstants.CENTER);
		labelDetails.setForeground(Color.WHITE);
		labelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDetails.setBounds(1036, 200, 240, 56);
		contentPane.add(labelDetails);
		labelDetails.setLabelFor(detailsBTN);
		
		detailsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
		detailsBTN.setVerticalAlignment(SwingConstants.TOP);
		detailsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		detailsBTN.setBounds(1036, 200, 240, 56);
		contentPane.add(detailsBTN);
		
		JLabel reportsBTN = new JLabel("");
		reportsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				reportsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Reports_custom().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelReports = new JLabel("\u05D4\u05E4\u05E7\u05EA \u05D3\u05D5\u05D7\u05D5\u05EA");
		labelReports.setHorizontalAlignment(SwingConstants.CENTER);
		labelReports.setForeground(Color.WHITE);
		labelReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReports.setBounds(1036, 270, 240, 56);
		contentPane.add(labelReports);
		labelReports.setLabelFor(reportsBTN);
		reportsBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
		reportsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		reportsBTN.setVerticalAlignment(SwingConstants.TOP);
		reportsBTN.setBounds(1036, 270, 240, 56);
		contentPane.add(reportsBTN);
		
		JLabel helpBTN = new JLabel("");
		helpBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				helpBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Help().setVisible(true);
					
			}
			@Override
			public void mousePressed(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelHelp = new JLabel("\u05E2\u05D6\u05E8\u05D4");
		labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
		labelHelp.setForeground(Color.WHITE);
		labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHelp.setBounds(1036, 340, 240, 56);
		contentPane.add(labelHelp);
		labelHelp.setLabelFor(helpBTN);
		helpBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
		helpBTN.setHorizontalAlignment(SwingConstants.LEFT);
		helpBTN.setVerticalAlignment(SwingConstants.TOP);
		helpBTN.setBounds(1036, 340, 240, 56);
		contentPane.add(helpBTN);
		
		JLabel aboutBTN = new JLabel("");
		aboutBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				aboutBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new About().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelAbout = new JLabel("\u05D0\u05D5\u05D3\u05D5\u05EA");
		labelAbout.setHorizontalAlignment(SwingConstants.CENTER);
		labelAbout.setForeground(Color.WHITE);
		labelAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAbout.setBounds(1036, 410, 240, 56);
		contentPane.add(labelAbout);
		labelAbout.setLabelFor(aboutBTN);
		aboutBTN.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/Btn.jpg")));
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
		
		JLabel dateLabel = new JLabel("");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateLabel.setForeground(Color.LIGHT_GRAY);
		dateLabel.setBounds(1036, 480, 240, 56);
		contentPane.add(dateLabel);
		
		JLabel back = new JLabel("");
		back.setName("background");
		back.setLabelFor(contentPane);
		back.setIcon(new ImageIcon(Monthly_Summary.class.getResource("/MM UI clean.JPG")));
		back.setVerticalAlignment(SwingConstants.TOP);
		back.setBounds(0, 0, 1300, 800);
		contentPane.add(back);
	
		date1(dateLabel);
		
		textPane.setText(controller.displayNote(MonthlyData.chosenMonth, MonthlyData.chosenYear)); // Show user note related to the chosen month
		

	}
	
	public void date1(JLabel dateLabel) {
		String txtDate=new SimpleDateFormat ("dd/MM/YYYY", Locale.ENGLISH).format(new Date());
		dateLabel.setText(txtDate);
	}
}
