package Model;

public class FoodAndShopping extends Outcome {
	
	private double supermarket;
	private double restaurants;
	private double shopping;

	public FoodAndShopping(String month, String year, double supermarket, double restaurants, double shopping) {
		super(month, year);
		this.supermarket = supermarket;
		this.restaurants = restaurants;
		this.shopping = shopping;
	}

	public double getSupermarket() {
		return supermarket;
	}

	public void setSupermarket(double supermarket) {
		this.supermarket = supermarket;
	}

	public double getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(double restaurants) {
		this.restaurants = restaurants;
	}

	public double getShopping() {
		return shopping;
	}

	public void setShopping(double shopping) {
		this.shopping = shopping;
	}
	
	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow("הוצאות", "מזון וקמעונאות", supermarket, getMonth(), getYear(), "קניות בסופר");
		dbf.insertRow("הוצאות", "מזון וקמעונאות", restaurants, getMonth(), getYear(), "מסעדות");
		dbf.insertRow("הוצאות", "מזון וקמעונאות", shopping, getMonth(), getYear(), "ביגוד והנעלה");
	}
	
}
