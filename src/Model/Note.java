package Model;

public class Note extends Record {
	
	public static final String type = "הערות";
	private String note;
	
	public Note(String month, String year, String note) {
		super(month, year);
		this.note = note;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public void insertToDB()
	{
		DBFunctions1 dbf = new DBFunctions1 ();
		dbf.insertNote(getMonth(), getYear(), note);
	}

}
