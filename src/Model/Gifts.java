package Model;

public class Gifts extends Income {

	private String giftFromWho;
	private double profit;

	public Gifts(String month, String year, String giftFromWho, double profit) {
		super(month, year);
		this.giftFromWho = giftFromWho;
		this.profit = profit;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getGiftFromWho() {
		return giftFromWho;
	}

	public void setGiftFromWho(String giftFromWho) {
		this.giftFromWho = giftFromWho;
	}
	
	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow("הכנסות", "מתנות", profit, getMonth(), getYear(), giftFromWho);
	}

}
