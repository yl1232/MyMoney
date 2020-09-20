package Model;

public class Apartment extends Outcome {
	
	private double rent;
	private double bills;

	public Apartment(String month, String year, double rent, double bills) {
		super(month, year);
		this.rent = rent;
		this.bills = bills;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public double getBills() {
		return bills;
	}

	public void setBills(double bills) {
		this.bills = bills;
	}
	
	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow("הוצאות", "דירה", rent, getMonth(), getYear(), "שכר דירה");
		dbf.insertRow("הוצאות", "דירה", bills, getMonth(), getYear(), "חשבונות שוטפים");
	}
}
