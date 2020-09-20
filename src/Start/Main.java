package Start;
import Model.*;
import View.*;

import java.sql.SQLException;

import Controller.*;

public class Main {
	
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
		MyMoneyController controller = new MyMoneyController();
		controller.startApplication();
	}

}
