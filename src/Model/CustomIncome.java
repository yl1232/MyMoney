package Model;

public class CustomIncome extends Income {
	
	private String nameOfIncome;
	private double profit;
	
	public CustomIncome(String month, String year, String nameOfIncome, double profit) {
		super(month, year);
		this.nameOfIncome = nameOfIncome;
		this.profit = profit;
	}
	
	public String getNameOfIncome() {
		return nameOfIncome;
	}
	public void setNameOfIncome(String nameOfIncome) {
		this.nameOfIncome = nameOfIncome;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow("הכנסות", "אחר", profit, getMonth(), getYear(), nameOfIncome);
	}

}
