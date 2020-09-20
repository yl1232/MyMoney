package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CalcMonthlyBalanceTest {

	@Test
	public void monthlyBalanceTest() throws ClassNotFoundException, SQLException {
		DBFunctions test=new DBFunctions();
	    DBFunctions.connectToDB();  /*Creating connection with data base*/
	    DBFunctions.createTable();
	    if(test.checkIfDataExists("ינואר", "2019")==true) // If there is a data for this month, delete the data
	    {
	    	test.deleteMonthlyData("ינואר", "2019");
	    }
	   
	    /* Here we are entering the temporary data for JUnit */
	    
	    test.insertRow("הוצאות", "שכר דירה", 1700, "ינואר", "2019", "");
	    test.insertRow("הכנסות", "משכורת", 5000, "ינואר", "2019", "מכללה");
	  
	    double res=test.calculateMonthlyBalance("ינואר", "2019");    /*Checking our function*/
	    assertEquals(3300.0,res,0);
	    test.deleteMonthlyData("ינואר", "2019");   /*We must delete the temporary data*/
	}
}
