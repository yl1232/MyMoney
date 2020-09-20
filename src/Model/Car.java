package Model;

public class Car extends Outcome {
	
	private double fuel;
	private double maintenance;

	public Car(String month, String year, double fuel, double maintenance) {
		super(month, year);
		this.fuel = fuel;
		this.maintenance = maintenance;
	}
	public double getFuel() {
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	public double getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(double maintenance) {
		this.maintenance = maintenance;
	}
	
	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow("הוצאות", "רכב", fuel, getMonth(), getYear(), "דלק");
		dbf.insertRow("הוצאות", "רכב", maintenance, getMonth(), getYear(), "אחזקת רכב וטיפולים");
	}
	
}
