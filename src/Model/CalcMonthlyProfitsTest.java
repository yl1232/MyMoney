package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CalcMonthlyProfitsTest {

	@Test
	public void calculateMonthlyExpensesTest() throws ClassNotFoundException, SQLException {
		DBFunctions test=new DBFunctions();
	    DBFunctions.connectToDB();  /* Creating connection with data base */
	    DBFunctions.createTable();
	    if(test.checkIfDataExists("אפריל", "2019")==true) // If there is a data for this month, delete the data
	     test.deleteMonthlyData("אפריל", "2019");
	    
	    /* Here we are inserting the temporary data for JUnit */
	    
	    test.insertRow("הכנסות", "משכורת", 5000, "אפריל", "2019", "מכללה");
	    test.insertRow("הכנסות", "דמי אבטלה", 0, "אפריל", "2019", "");
	    test.insertRow("הכנסות", "קצבת ילדים", 150, "אפריל", "2019", "");
	    test.insertRow("הכנסות", "הבטחת הכנסה", 0, "אפריל", "2019", "");
	  
	    double res=test.calculateMonthlyProfits("אפריל", "2019");    /* Checking our function */
	    assertEquals(5150.0,res,0);
	   
	    test.deleteMonthlyData("אפריל", "2019");   /* We must delete the temporary data */
	}
}
