package Model;

public abstract class Record {
	
	private String month;
	private String year;
  
  public Record(String month, String year)
  {
	  super();
	  this.month=month;
	  this.year=year;
  }
  
  public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
