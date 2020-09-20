package Model;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  
  
public class DBFunctions {
	
	static Connection conn = null;
	
	public static void connectToDB() throws ClassNotFoundException, SQLException  // Connect to database
	{
		if(conn==null) {
		String url = "jdbc:sqlite:MyMoney.db";       
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection(url);
		}
	}
	
	public static void createTable() throws ClassNotFoundException // Create main table
	{
		Statement stmt = null;
		
	        try {  
	            
	            String sql = "CREATE TABLE IF NOT EXISTS expenses " +
	                    "(סוג VARCHAR(255), " +
	                    " כותרת VARCHAR(255), " +
	                    " קטגוריה VARCHAR(255), " + 
	                    " סכום DOUBLE, " + 
	                    " חודש VARCHAR(255), " + 
	                    " שנה VARCHAR(255) )";
	
	            stmt = conn.createStatement();  
	            stmt.execute(sql);
	 
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }
	}
	
	public static void createUserTable() throws ClassNotFoundException  // Create user table
	{
		Statement stmt = null;
		
	        try {  
	            
	            String sql = "CREATE TABLE IF NOT EXISTS users " +
	                    "(שם_פרטי VARCHAR(255), " +
	                    " שם_משפחה VARCHAR(255) )";
	
	            stmt = conn.createStatement();  
	            stmt.execute(sql);
	 
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }
	        
	}
	
	public void insertUserToDB(String firstname, String lastname) // Insert user details to database
	{
		String sql = "INSERT or IGNORE INTO users(שם_פרטי, שם_משפחה) VALUES(?,?)";	
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, firstname);  
            pstmt.setString(2, lastname);
            pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getUser() throws SQLException  // Get user details from database
	{
		
		String sql="Select * FROM users";
		PreparedStatement pst= conn.prepareStatement(sql); 
		ResultSet rs = pst.executeQuery();
		return rs;	
	}
	

	public void deleteUser() throws SQLException // Delete user for JUnit Test
	{
		ResultSet rs = getUser();
		if(!rs.next())
		{
			return;
		}
		String sql = "DELETE FROM users";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}

	
	public void insertRow (String type, String category, double value, String month, String year, String title) {  // Insert a record to table
		String sql = "INSERT or IGNORE INTO expenses(סוג, כותרת, קטגוריה, סכום, חודש, שנה) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);  
            pstmt.setString(2, title);
            pstmt.setString(3, category);  
            pstmt.setDouble(4, value);
            pstmt.setString(5, month);
            pstmt.setString(6, year);
            pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getRow() throws SQLException  // Get a details from database
	{
		
		String sql="Select * FROM expenses";
		PreparedStatement pst= conn.prepareStatement(sql); 
		ResultSet rs = pst.executeQuery();
		return rs;	
	}
	
	public void deleteMonthlyData (String selectedMonth, String selectedYear) throws SQLException  // Delete all data of a specific month
	{
		String sql = "DELETE FROM expenses WHERE חודש=? AND שנה=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectedMonth);
		pstmt.setString(2, selectedYear);
		pstmt.executeUpdate();
	}
	
	public boolean checkIfDataExists(String selectedMonth, String selectedYear) throws SQLException  // Check if data exists for a specific month
	{
		String sql = "SELECT COUNT(*) AS numrows FROM expenses WHERE חודש=? AND שנה=?";
		PreparedStatement stmt  = conn.prepareStatement(sql);
		stmt.setString(1, selectedMonth);
		stmt.setString(2, selectedYear);
		ResultSet rs = stmt.executeQuery();
 
        rs.next(); 
       	if (rs.getInt("numrows") > 0)
        	{
        		 return true;	
        	}
        	else return false;
     } 
	
	public double calculateMonthlyExpenses (String selectedMonth, String selectedYear) throws SQLException // Calculate expenses of a specific month
	{
		String sql = "SELECT SUM(סכום) AS sum_expenses FROM expenses WHERE סוג=? AND חודש=? AND שנה=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "הוצאות");
		stmt.setString(2, selectedMonth);
		stmt.setString(3, selectedYear);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		return rs.getDouble("sum_expenses");
	}
	
	public double calculateMonthlyExpensesByCategory (String category, String selectedMonth, String selectedYear) throws SQLException // Calculate expenses by category for a specific month
	{
		String sql = "SELECT COALESCE(SUM(סכום) , 0) AS sum_expenses FROM expenses WHERE סוג=? AND קטגוריה=? AND חודש=? AND שנה=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "הוצאות");
		stmt.setString(2, category);
		stmt.setString(3, selectedMonth);
		stmt.setString(4, selectedYear);
		ResultSet rs = stmt.executeQuery();

		rs.next();
		return rs.getDouble("sum_expenses");
	}
	
	public double calculateMonthlyProfitsByCategory (String category, String selectedMonth, String selectedYear) throws SQLException // Calculate expenses by category for a specific month
	{
		String sql = "SELECT COALESCE(SUM(סכום) , 0) AS sum_profits FROM expenses WHERE סוג=? AND קטגוריה=? AND חודש=? AND שנה=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "הכנסות");
		stmt.setString(2, category);
		stmt.setString(3, selectedMonth);
		stmt.setString(4, selectedYear);
		ResultSet rs = stmt.executeQuery();
       	stmt.close();
		rs.next();
		return rs.getDouble("sum_profits");
	}
	
	public double calculateMonthlyProfits (String selectedMonth, String selectedYear) throws SQLException // Calculate profits of a specific month
	{
		String sql = "SELECT SUM(סכום) AS sum_profits FROM expenses WHERE סוג=? AND חודש=? AND שנה=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "הכנסות");
		stmt.setString(2, selectedMonth);
		stmt.setString(3, selectedYear);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		return rs.getDouble("sum_profits");
	}
	
	public double calculateMonthlyBalance (String selectedMonth, String selectedYear) throws SQLException // Calculate monthly balance of a specific month
	{
		double profits = calculateMonthlyProfits(selectedMonth,selectedYear);
		double expenses = calculateMonthlyExpenses(selectedMonth,selectedYear);
		double balance = profits-expenses;
		return balance;
	}
	
	public ResultSet displayTable (String month, String year, String type, String category) throws SQLException // Display table in reports page
	{
		String sql="Select * FROM expenses WHERE חודש=? AND שנה=? AND סוג=? AND קטגוריה=?"; 
		PreparedStatement pst= conn.prepareStatement(sql);
		pst.setString(1, month);
		pst.setString(2, year);
		pst.setString(3, type);
		pst.setString(4, category); 
		ResultSet rs = pst.executeQuery();
		pst.close();
		return rs;
	}
	
	public void insertNote (String month, String year, String note) {  // Insert a note to the table
		String sql = "INSERT or IGNORE INTO expenses(סוג, כותרת, קטגוריה, סכום, חודש, שנה) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "הערות");  
            pstmt.setString(2, note);
            pstmt.setString(3, null);  
            pstmt.setDouble(4, 0);
            pstmt.setString(5, month);
            pstmt.setString(6, year);
            pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String displayNote (String selectedMonth, String selectedYear) throws SQLException // Display note of a specific month
	{
		String sql = "SELECT כותרת AS note FROM expenses WHERE חודש=? AND שנה=? AND סוג=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, selectedMonth);
		stmt.setString(2, selectedYear);
		stmt.setString(3, "הערות");
		ResultSet rs = stmt.executeQuery();
       	stmt.close();
		rs.next();
		return rs.getString("note");
	}
		
} 