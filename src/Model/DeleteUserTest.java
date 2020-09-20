package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class DeleteUserTest {

	@Test
	public void deleteUserTest() throws SQLException, ClassNotFoundException {
		
	    DBFunctions test=new DBFunctions();
	    DBFunctions.connectToDB();  /* Creating connection with Data Base */
	    DBFunctions.createUserTable();
		test.deleteUser();
		boolean res = test.getUser().next();  	/* Checking if the user still exists */
		assertEquals(false,res);
	}
}
