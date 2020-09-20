package Model;

public abstract class Outcome extends Record {
	
	public static final String type = "הוצאות";

	public Outcome(String month, String year) {
		super(month, year);
		// TODO Auto-generated constructor stub
	}

	public static String getType() {
		return type;
	}
	
}
	
	