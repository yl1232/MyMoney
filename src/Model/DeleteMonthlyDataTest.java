package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class DeleteMonthlyDataTest {

	@Test
	public void deleteMonthlyDataTest() throws SQLException, ClassNotFoundException {
		
    DBFunctions test=new DBFunctions();
    DBFunctions.connectToDB();  /* Creating connection with Data Base */
    DBFunctions.createTable();
   
    test.insertRow("הכנסות", "משכורת", 5000, "אפריל", "2019", "מכללה");   /* Here we are entering the temporary data for JUnit */

    test.deleteMonthlyData("אפריל", "2019");   /* Checking our function */
	boolean res = test.checkIfDataExists("אפריל", "2019");
	assertEquals(false,res);
	}
}
