package Model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CalcExpensesByCategoryTest.class, CalcMonthlyBalanceTest.class, CalcMonthlyProfitsTest.class,
		CalculateMonthlyExpensesTest.class, DeleteMonthlyDataTest.class, DeleteUserTest.class, GetRowTest.class,
		GetUserFromDbTest.class, IfDataExistsTest.class, MonthlyProfitsByCategoryTest.class })
public class AllTests {

}
