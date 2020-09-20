package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CalcExpensesByCategoryTest {

	@Test
	public void byCategoryTest() throws SQLException, ClassNotFoundException {
	
		DBFunctions test = new DBFunctions();  	/* Creating connection with data base */
	    DBFunctions.connectToDB();
	    DBFunctions.createTable();
	    
	    if (test.checkIfDataExists("אפריל", "2019")== true ) // If there is a data for this month, delete the data
	    {
	    	test.deleteMonthlyData("אפריל", "2019"); 
	    }	
	    
	    test.insertRow("הוצאות", "דלק", 0, "אפריל", "2019", "");     /* Here we are entering the temporary data for JUnit */
	  
	    double res = test.calculateMonthlyExpensesByCategory("דלק", "אפריל", "2019");    /* Checking our function */
	    assertEquals(0.0 , res , 0);
	    test.deleteMonthlyData("אפריל", "2019");   /* We must delete the temporary data */
	}
}
