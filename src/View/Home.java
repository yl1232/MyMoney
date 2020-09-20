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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Controller.MyMoneyController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.Spring;

import java.awt.SystemColor;
import java.awt.Canvas;

public class Home extends JFrame {

	private JPanel contentPane;
	private MyMoneyController controller = new MyMoneyController();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Home() throws SQLException {
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


		YearMonth thisMonth    = YearMonth.now();
		YearMonth thisMonthMinus1    = thisMonth.minusMonths(1);
		YearMonth thisMonthMinus2 = thisMonth.minusMonths(2);
		YearMonth thisMonthMinus3 = thisMonth.minusMonths(3);
		YearMonth thisMonthMinus4 = thisMonth.minusMonths(4);
		YearMonth thisMonthMinus5 = thisMonth.minusMonths(5);
		YearMonth thisMonthMinus6 = thisMonth.minusMonths(6);
		DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
		DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");
		String thisMonthMinus1str = thisMonthMinus1.format(monthFormatter);
		String thisMonthYearMinus1str = thisMonthMinus1.format(yearFormatter);
		String thisMonthMinus2str = thisMonthMinus2.format(monthFormatter); 
		String thisMonthYearMinus2str = thisMonthMinus2.format(yearFormatter);
		String thisMonthMinus3str = thisMonthMinus3.format(monthFormatter); 
		String thisMonthYearMinus3str = thisMonthMinus3.format(yearFormatter); 
		String thisMonthMinus4str = thisMonthMinus4.format(monthFormatter); 
		String thisMonthYearMinus4str = thisMonthMinus4.format(yearFormatter); 
		String thisMonthMinus5str = thisMonthMinus5.format(monthFormatter); 
		String thisMonthYearMinus5str = thisMonthMinus5.format(yearFormatter); 
		String thisMonthMinus6str = thisMonthMinus6.format(monthFormatter); 
		String thisMonthYearMinus6str = thisMonthMinus6.format(yearFormatter);
		
		DefaultPieDataset dataset1 = new DefaultPieDataset( );
		dataset1.setValue( "משכורת" , controller.calculateMonthlyProfitsByCategory("משכורת", thisMonthMinus1str, thisMonthYearMinus1str) );
	    dataset1.setValue( "קצבאות" , controller.calculateMonthlyProfitsByCategory("קצבאות", thisMonthMinus1str, thisMonthYearMinus1str) );  
	    dataset1.setValue( "מתנות" , controller.calculateMonthlyProfitsByCategory("מתנות", thisMonthMinus1str, thisMonthYearMinus1str) );  
	    dataset1.setValue( "אחר" , controller.calculateMonthlyProfitsByCategory("אחר", thisMonthMinus1str, thisMonthYearMinus1str) );     
		
	    JFreeChart PieChart = ChartFactory.createPieChart(      
	    	         "פילוח הוצאות",   // chart title 
	    	         dataset1,          // data    
	    	         true,             // include legend   
	    	         true, 
	    	         false);
		
		  DefaultPieDataset dataset2 = new DefaultPieDataset( );
		  dataset2.setValue( "דירה" , controller.calculateMonthlyExpensesByCategory("דירה", thisMonthMinus1str, thisMonthYearMinus1str) );
	      dataset2.setValue( "רכב" , controller.calculateMonthlyExpensesByCategory("רכב", thisMonthMinus1str, thisMonthYearMinus1str) );  
	      dataset2.setValue( "תחבורה ציבורית" , controller.calculateMonthlyExpensesByCategory("תחבורה ציבורית", thisMonthMinus1str, thisMonthYearMinus1str) );  
	      dataset2.setValue( "ביטוחים" , controller.calculateMonthlyExpensesByCategory("ביטוחים", thisMonthMinus1str, thisMonthYearMinus1str) );     
	      dataset2.setValue( "מזון וקמעונאות" , controller.calculateMonthlyExpensesByCategory("מזון וקמעונאות", thisMonthMinus1str, thisMonthYearMinus1str) );  
	      dataset2.setValue( "אחר" , controller.calculateMonthlyExpensesByCategory("אחר", thisMonthMinus1str, thisMonthYearMinus1str) );
		
	      JFreeChart PieChart2 = ChartFactory.createPieChart(      
	    	         "פילוח הכנסות",   // chart title 
	    	         dataset2,          // data    
	    	         true,             // include legend   
	    	         true, 
	    	         false);
		
		// controller.calculateMonthlyExpenses(lM, lY)

	    final DefaultCategoryDataset barChartDataset = new DefaultCategoryDataset( );
	    
	      barChartDataset.addValue(controller.calculateMonthlyExpenses(thisMonthMinus1str, thisMonthYearMinus1str) , "הוצאות" , thisMonthMinus1str + " " + thisMonthYearMinus1str);
	      barChartDataset.addValue(controller.calculateMonthlyProfits(thisMonthMinus1str, thisMonthYearMinus1str) , "הכנסות" , thisMonthMinus1str + " " + thisMonthYearMinus1str);
	  
	      barChartDataset.addValue(controller.calculateMonthlyExpenses(thisMonthMinus2str, thisMonthYearMinus2str) , "הוצאות" , thisMonthMinus2str + " " + thisMonthYearMinus2str);
	      barChartDataset.addValue(controller.calculateMonthlyProfits(thisMonthMinus2str, thisMonthYearMinus2str), "הכנסות" , thisMonthMinus2str + " " + thisMonthYearMinus2str);

	      barChartDataset.addValue(controller.calculateMonthlyExpenses(thisMonthMinus3str, thisMonthYearMinus3str) , "הוצאות" , thisMonthMinus3str + " " + thisMonthYearMinus3str);
	      barChartDataset.addValue(controller.calculateMonthlyProfits(thisMonthMinus3str, thisMonthYearMinus3str), "הכנסות" , thisMonthMinus3str + " " + thisMonthYearMinus3str);
	      
	      barChartDataset.addValue(controller.calculateMonthlyExpenses(thisMonthMinus4str, thisMonthYearMinus4str) , "הוצאות" , thisMonthMinus4str + " " + thisMonthYearMinus4str);
	      barChartDataset.addValue(controller.calculateMonthlyProfits(thisMonthMinus4str, thisMonthYearMinus4str), "הכנסות" , thisMonthMinus4str + " " + thisMonthYearMinus4str);
	      
	      barChartDataset.addValue(controller.calculateMonthlyExpenses(thisMonthMinus5str, thisMonthYearMinus5str) , "הוצאות" , thisMonthMinus5str + " " + thisMonthYearMinus5str);
	      barChartDataset.addValue(controller.calculateMonthlyProfits(thisMonthMinus5str, thisMonthYearMinus5str), "הכנסות" , thisMonthMinus5str + " " + thisMonthYearMinus5str);
	      
	      barChartDataset.addValue(controller.calculateMonthlyExpenses(thisMonthMinus6str, thisMonthYearMinus6str) , "הוצאות" , thisMonthMinus6str + " " + thisMonthYearMinus6str);
	      barChartDataset.addValue(controller.calculateMonthlyProfits(thisMonthMinus6str, thisMonthYearMinus6str), "הכנסות" , thisMonthMinus6str + " " + thisMonthYearMinus6str);
	      
	     JFreeChart barChart = ChartFactory.createBarChart(
	         "מאזן עבור 6 החודשים האחרונים", 
	         "ציר X", "סכום", 
	         barChartDataset,PlotOrientation.VERTICAL, 
	         true, true, false);
		   
		
		
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
		
		JLabel pageTitle = new JLabel("\u05E9\u05DC\u05D5\u05DD, \u05D1\u05D0\u05E4\u05DC\u05D9\u05E7\u05E6\u05D9\u05D4 \u05D6\u05D5 \u05D0\u05EA\u05D4 \u05D9\u05DB\u05D5\u05DC \u05DC\u05E0\u05D4\u05DC \u05D0\u05EA \u05DE\u05D0\u05D6\u05DF \u05D4\u05DB\u05DC\u05DB\u05DC\u05D9 \u05E9\u05DC \u05DE\u05E9\u05E7 \u05D4\u05D1\u05D9\u05EA \u05E9\u05DC\u05DA");
		pageTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		pageTitle.setForeground(Color.WHITE);
		pageTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		mainBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
		mainBTN.setHorizontalAlignment(SwingConstants.LEFT);
		mainBTN.setBounds(1036, 130, 240, 56);
		contentPane.add(mainBTN);
		
		//Main Menu - detail 
		JLabel detailsBTN = new JLabel("");
		detailsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				detailsBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new MonthlyData().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				detailsBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelDetails = new JLabel("\u05D4\u05D6\u05E0\u05EA \u05E0\u05EA\u05D5\u05E0\u05D9\u05DD");
		labelDetails.setHorizontalAlignment(SwingConstants.CENTER);
		labelDetails.setForeground(Color.WHITE);
		labelDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDetails.setBounds(1036, 200, 240, 56);
		contentPane.add(labelDetails);
		labelDetails.setLabelFor(detailsBTN);
		
		detailsBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
		detailsBTN.setVerticalAlignment(SwingConstants.TOP);
		detailsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		detailsBTN.setBounds(1036, 200, 240, 56);
		contentPane.add(detailsBTN);
		
		JLabel reportsBTN = new JLabel("");
		reportsBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				reportsBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Reports_custom().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reportsBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
			}
		});
		
		JLabel labelReports = new JLabel("\u05D4\u05E4\u05E7\u05EA \u05D3\u05D5\u05D7\u05D5\u05EA");
		labelReports.setHorizontalAlignment(SwingConstants.CENTER);
		labelReports.setForeground(Color.WHITE);
		labelReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReports.setBounds(1036, 270, 240, 56);
		contentPane.add(labelReports);
		labelReports.setLabelFor(reportsBTN);
		reportsBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
		reportsBTN.setHorizontalAlignment(SwingConstants.LEFT);
		reportsBTN.setVerticalAlignment(SwingConstants.TOP);
		reportsBTN.setBounds(1036, 270, 240, 56);
		contentPane.add(reportsBTN);
		
		JLabel helpBTN = new JLabel("");
		helpBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				helpBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new Help().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				helpBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
			}
		});
	
		JLabel labelHelp = new JLabel("\u05E2\u05D6\u05E8\u05D4");
		labelHelp.setHorizontalAlignment(SwingConstants.CENTER);
		labelHelp.setForeground(Color.WHITE);
		labelHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelHelp.setBounds(1036, 340, 240, 56);
		contentPane.add(labelHelp);
		labelHelp.setLabelFor(helpBTN);
		helpBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
		helpBTN.setHorizontalAlignment(SwingConstants.LEFT);
		helpBTN.setVerticalAlignment(SwingConstants.TOP);
		helpBTN.setBounds(1036, 340, 240, 56);
		contentPane.add(helpBTN);
		
		JLabel aboutBTN = new JLabel("");
		aboutBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				aboutBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);	
				new About().setVisible(true);	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnPushed.jpg")));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Home.class.getResource("/BtnOver.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
			}
		});
	
		JLabel labelAbout = new JLabel("\u05D0\u05D5\u05D3\u05D5\u05EA");
		labelAbout.setHorizontalAlignment(SwingConstants.CENTER);
		labelAbout.setForeground(Color.WHITE);
		labelAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAbout.setBounds(1036, 410, 240, 56);
		contentPane.add(labelAbout);
		labelAbout.setLabelFor(aboutBTN);
		aboutBTN.setIcon(new ImageIcon(Home.class.getResource("/Btn.jpg")));
		aboutBTN.setHorizontalAlignment(SwingConstants.LEFT);
		aboutBTN.setVerticalAlignment(SwingConstants.TOP);
		aboutBTN.setBounds(1036, 410, 240, 56);
		contentPane.add(aboutBTN);
		
		JLabel label = new JLabel("\u05D1\u05E8\u05D5\u05DB\u05D9\u05DD \u05D4\u05D1\u05D0\u05D9\u05DD");
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/MM UI.png")));
		lblNewLabel.setBounds(96, 293, 772, 212);
		contentPane.add(lblNewLabel);
		
		JLabel back = new JLabel("");
		back.setName("background");
		back.setLabelFor(contentPane);
		back.setIcon(new ImageIcon(Home.class.getResource("/MM UI clean.JPG")));
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
