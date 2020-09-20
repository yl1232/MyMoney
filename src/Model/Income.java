package Model;

public abstract class Income extends Record {
	
	public static final String type = "הכנסות";
	
	public Income(String month, String year) {
		super(month, year);
		// TODO Auto-generated constructor stub
	}

	public static String getType() {
		return type;
	}

}
