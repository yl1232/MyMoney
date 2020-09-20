package Model;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class GetRowTest {

	@Test
	public void getRowTest() throws ClassNotFoundException, SQLException {
		
		DBFunctions test=new DBFunctions();
		DBFunctions.connectToDB();  /* Creating connection with Data Base */
	    DBFunctions.createTable();
	
	    test.insertRow("הכנסות", "משכורת", 1700, "אפריל", "2019", "מכללה");  	/* Here we are inserting the temporary data for JUnit */
	    ResultSet rs=test.getRow();
		String res=rs.getString("סוג");
	    assertEquals("הכנסות",res);
	 
        test.deleteMonthlyData("אפריל", "2019");     /* We must delete the temporary data */
	}
}
