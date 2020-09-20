package Model;

public class CustomOutcome extends Outcome {
	
	private String nameOfOutcome;
	private double expense;

	public CustomOutcome(String month, String year, String nameOfOutcome, double expense) {
		super(month, year);
		this.nameOfOutcome = nameOfOutcome;
		this.expense = expense;
	}

	public String getNameOfOutcome() {
		return nameOfOutcome;
	}

	public void setNameOfOutcome(String nameOfOutcome) {
		this.nameOfOutcome = nameOfOutcome;
	}
	
	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow("הוצאות", "אחר", expense, getMonth(), getYear(), nameOfOutcome);
	}

}
