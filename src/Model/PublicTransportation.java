package Model;

public class PublicTransportation extends Outcome {
	
	private double train;
	private double bus;

	public PublicTransportation(String month, String year, double train, double bus) {
		super(month, year);
		this.train = train;
		this.bus = bus;
	}

	public double getTrain() {
		return train;
	}

	public void setTrain(double train) {
		this.train = train;
	}

	public double getBus() {
		return bus;
	}

	public void setBus(double bus) {
		this.bus = bus;
	}
	
	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow(type, "תחבורה ציבורית", train, getMonth(), getYear(), "רכבת");
		dbf.insertRow(type, "תחבורה ציבורית", bus, getMonth(), getYear(), "אוטובוסים");
	}

}
