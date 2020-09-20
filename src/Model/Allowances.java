package Model;

public class Allowances extends Income {
	
	private double unemploymentBenefits;
	private double childAllowance;
	private double incomeSupport;
	
	public Allowances(String month, String year, double unemploymentBenefits, double childAllowance,
			double incomeSupport) {
		super(month, year);
		this.unemploymentBenefits = unemploymentBenefits;
		this.childAllowance = childAllowance;
		this.incomeSupport = incomeSupport;
	}
	public double getUnemploymentBenefits() {
		return unemploymentBenefits;
	}
	public void setUnemploymentBenefits(double unemploymentBenefits) {
		this.unemploymentBenefits = unemploymentBenefits;
	}
	public double getChildAllowance() {
		return childAllowance;
	}
	public void setChildAllowance(double childAllowance) {
		this.childAllowance = childAllowance;
	}

	public double getIncomeSupport() {
		return incomeSupport;
	}

	public void setIncomeSupport(double incomeSupport) {
		this.incomeSupport = incomeSupport;
	}
	
	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertRow("הכנסות", "קצבאות", unemploymentBenefits, getMonth(), getYear(), "דמי אבטלה");
		dbf.insertRow("הכנסות", "קצבאות", childAllowance, getMonth(), getYear(), "קצבת ילדים");
		dbf.insertRow("הכנסות", "קצבאות", incomeSupport, getMonth(), getYear(), "הבטחת הכנסה");
	}
		
}
