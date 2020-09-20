package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CalculateMonthlyExpensesTest {

	@Test
	public void calculateMonthlyExpensesTest() throws ClassNotFoundException, SQLException {

		DBFunctions test=new DBFunctions();
	    DBFunctions.connectToDB();  		/* Creating connection with data base */
	    DBFunctions.createTable();
	    if(test.checkIfDataExists("אפריל", "2019") == true) //If there is a data for this month, delete the data
	    {
	    	test.deleteMonthlyData("אפריל", "2019");	
	    }
	    
	    /* Here we are inserting the temporary data for JUnit */
	    
	    test.insertRow("הוצאות", "שכר דירה", 1700, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "חשבונות שוטפים", 0, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "דלק", 0, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "אחזקת רכב וטיפולים", 0, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "רכבת", 215, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "אוטובוסים", 0, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "ביטוח בריאות", 0, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "ביטוח חיים", 0, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "ביטוח רכב", 0, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "קניות בסופר", 2000, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "מסעדות", 600, "אפריל", "2019", "");
	    test.insertRow("הוצאות", "ביגוד והנעלה", 0, "אפריל", "2019", "");
	    
	  
	    double res = test.calculateMonthlyExpenses("אפריל", "2019");    /* Checking our function */
	    assertEquals(4515.0,res,0);
	 
	    test.deleteMonthlyData("אפריל", "2019");     /* We must delete the temporary data */
	}
}
