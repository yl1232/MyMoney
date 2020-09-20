package Model;

public class Insurances extends Outcome {
	
	private double healthInsurance;
	private double lifeInsurance;
	private double carInsurance;

	public Insurances(String month, String year, double healthInsurance, double lifeInsurance, double carInsurance) {
		super(month, year);
		this.healthInsurance = healthInsurance;
		this.lifeInsurance = lifeInsurance;
		this.carInsurance = carInsurance;
	}

	public double getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(double healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public double getLifeInsurance() {
		return lifeInsurance;
	}

	public void setLifeInsurance(double lifeInsurance) {
		this.lifeInsurance = lifeInsurance;
	}

	public double getCarInsurance() {
		return carInsurance;
	}

	public void setCarInsurance(double carInsurance) {
		this.carInsurance = carInsurance;
	}
	
	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow("הוצאות", "ביטוחים", healthInsurance, getMonth(), getYear(), "ביטוח בריאות");
		dbf.insertRow("הוצאות", "ביטוחים", lifeInsurance, getMonth(), getYear(), "ביטוח חיים");
		dbf.insertRow("הוצאות", "ביטוחים", carInsurance, getMonth(), getYear(), "ביטוח רכב");
	}

}
