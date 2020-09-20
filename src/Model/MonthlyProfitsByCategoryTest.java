package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class MonthlyProfitsByCategoryTest {

	@Test
	public void byCategoryTest() throws SQLException, ClassNotFoundException {
		/* Creating connection with data base */
		DBFunctions test=new DBFunctions();
	    DBFunctions.connectToDB();
	    DBFunctions.createTable();
	    if(test.checkIfDataExists("אפריל", "2019")==true) // If there is a data for this month, delete the data
	     test.deleteMonthlyData("אפריל", "2019");
	    /* Here we are entering the temporary data for JUnit */
	    test.insertRow("הוצאות", "קצבת ילדים", 150, "אפריל", "2019", "");
	    /* Checking our function */
	    double res=test.calculateMonthlyExpensesByCategory("קצבת ילדים", "אפריל", "2019");
	    assertEquals(150.0,res,0);
	    /* We must delete the temporary data */
	    test.deleteMonthlyData("אפריל", "2019");  
	}
}
