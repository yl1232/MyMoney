package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class IfDataExistsTest {

	@Test
	public void testCheckIfExists() throws SQLException, ClassNotFoundException {
	
		DBFunctions test=new DBFunctions();
		DBFunctions.connectToDB();  	/* Creating connection with Data Base */
	    DBFunctions.createTable();
	    /* Here we are entering the temporary data for JUnit */
		test.insertRow("הכנסות", "משכורת", 5000, "מרץ", "2019", "מכללה");
		/* Checking our function */
		boolean res=test.checkIfDataExists("מרץ", "2019");
		assertEquals(true,res);	
	    /* We must delete the temporary data */
		test.deleteMonthlyData("מרץ", "2019");
	}
}
