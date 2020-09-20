package Model;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class GetUserFromDbTest {

	@Test
	public void getUserTest() throws ClassNotFoundException, SQLException {
		DBFunctions test=new DBFunctions(); 
		DBFunctions.connectToDB();   /* Creating connection with Data Base */
	    DBFunctions.createUserTable();
		test.deleteUser();  	/* Delete the user if he is already exists */
		
		/* Here we are inserting the temporary data for JUnit */
		test.insertUserToDB("אליסה","מקרוב");
		ResultSet rs=test.getUser();
		String res1=rs.getString("שם_פרטי");
		assertEquals("אליסה",res1);
		String res2=rs.getString("שם_משפחה");
		assertEquals("מקרוב",res2);
	 
		test.deleteUser();     /* We must delete the temporary data */
	}
}
