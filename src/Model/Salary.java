package Model;

public class Salary extends Income {
	
	private String workplace;
	private double profit;

	public Salary(String month, String year, String workplace, double profit) {
		super(month, year);
		this.workplace = workplace;
		this.profit = profit;
	}

	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow(type, "משכורת", profit, getMonth(), getYear(), workplace);
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	
}
