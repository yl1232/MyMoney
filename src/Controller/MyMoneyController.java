package Controller;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.*;
import View.*;

public class MyMoneyController {
	
	public void startApplication() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connectToDB();
					createUserTable();
					createTable();
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
	public static void connectToDB() throws ClassNotFoundException, SQLException
	{
		DBFunctions1.connectToDB();
	}
	
	public static void createTable() throws ClassNotFoundException
	{
		DBFunctions1.createTable();
	}
	
	public void createUserTable() throws ClassNotFoundException
	{
		DBFunctions1.createUserTable();
	}
	
	public ResultSet getUser () throws SQLException 
	{
		DBFunctions1 dbf = new DBFunctions1();
		return dbf.getUser();
	}
	
	public boolean checkIfDataExists(String month, String year) throws SQLException
	{
		DBFunctions1 dbf = new DBFunctions1();
		if (dbf.checkIfDataExists(month,year) == true)
		{
			return true;
		}
		else return false;
	}
	
	public void deleteMonthlyData(String month, String year) throws SQLException
	{
		DBFunctions1 dbf = new DBFunctions1();
		dbf.deleteMonthlyData(month, year);
	}
	
	public double calculateMonthlyExpenses(String month, String year) throws SQLException
	{
		DBFunctions1 dbf = new DBFunctions1();
		return dbf.calculateMonthlyExpenses(month,year);
	}
	
	public double calculateMonthlyExpensesByCategory(String category, String month, String year) throws SQLException
	{
		DBFunctions1 dbf = new DBFunctions1();
		return dbf.calculateMonthlyExpensesByCategory(category,month,year);
	}
	
	public double calculateMonthlyProfitsByCategory(String category, String month, String year) throws SQLException
	{
		DBFunctions1 dbf = new DBFunctions1();
		return dbf.calculateMonthlyProfitsByCategory(category,month,year);
	}
	
	public double calculateMonthlyProfits(String month, String year) throws SQLException
	{
		DBFunctions1 dbf = new DBFunctions1();
		return dbf.calculateMonthlyProfits(month,year);
	}
	
	public double calculateMonthlyBalance(String month, String year) throws SQLException
	{
		DBFunctions1 dbf = new DBFunctions1();
		return dbf.calculateMonthlyBalance(month,year);
	}
	
	public void insertNote(String month, String year, String note)
	{
		Note nt = new Note(month, year, note);
		nt.insertToDB();
	} 

	public void insertSalaryInstance(String month, String year, String workplace, double profit)
	{
		Salary sl = new Salary (month, year, workplace, profit);
		sl.insertToDB();
	}
	
	public void insertAllowancesInstance(String month, String year, double unemploymentBenefits, double childAllowance, double incomeSupport)
	{
		Allowances al = new Allowances (month, year, unemploymentBenefits, childAllowance, incomeSupport);
		al.insertToDB();
	}
	
	public void insertGiftsInstance(String month, String year, String giftFromWho, double profit)
	{
		Gifts gf = new Gifts (month, year, giftFromWho, profit);
		gf.insertToDB();
	}	
	
	public void insertCustomIncomeInstance(String month, String year, String nameOfIncome, double profit)
	{
		CustomIncome ci = new CustomIncome (month, year,nameOfIncome, profit);
		ci.insertToDB();
	}	
	
	public void insertApartmentInstance(String month, String year, double rent, double bills)
	{
		Apartment ap = new Apartment (month, year, rent, bills);
		ap.insertToDB();
	}	
	
	public void insertCarInstance(String month, String year, double fuel, double maintenance)
	{
		Car car = new Car (month, year, fuel, maintenance);
		car.insertToDB();
	}	
	
	public void insertPublicTransportationInstance(String month, String year, double train, double bus)
	{
		PublicTransportation pt = new PublicTransportation (month, year, train, bus);
		pt.insertToDB();
	}	
	
	public void insertInsurancesInstance(String month, String year, double healthInsurance, double lifeInsurance, double carInsurance)
	{
		Insurances is = new Insurances (month, year, healthInsurance, lifeInsurance, carInsurance);
		is.insertToDB();
	}	
	
	public void insertFoodAndShoppingInstance(String month, String year, double supermarket, double restaurants, double shopping)
	{
		FoodAndShopping fs = new FoodAndShopping (month, year, supermarket, restaurants, shopping);
		fs.insertToDB();
	}	
	
	public void insertCustomOutcomeInstance(String month, String year, String nameOfOutcome, double expense)
	{
		CustomOutcome co = new CustomOutcome (month, year, nameOfOutcome, expense);
		co.insertToDB();
	}	
	
	public ResultSet displayTable (String month, String year, String type, String category) throws SQLException 
	{
		DBFunctions1 dbf = new DBFunctions1();
		return dbf.displayTable(month, year, type, category);
	}
	
	public String displayNote (String month, String year) throws SQLException 
	{
		DBFunctions1 dbf = new DBFunctions1();
		return dbf.displayNote(month, year);
	}
	
	public void insertUserData(String fname, String lname) 
	{
		User.getInstance().add(fname, lname);
		DBFunctions1 dbf = new DBFunctions1();
		dbf.insertUserToDB(fname, lname);
	}

}
