package Model;

public class User {

	private static User instance;
	private String firstname;
	private String lastname;
	
    /* private constructor to prevent others from instantiating this class */
    private User() {}

    
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }
    
    public void add(String fname, String lname)
    {
    	this.firstname=fname;
    	this.lastname=lname;
    }
    
	public String getfname() {
		return firstname;
	}
	
	public String getlname() {
		return lastname;
	}
	
}