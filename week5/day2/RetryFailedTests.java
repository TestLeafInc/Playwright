package week5.day2;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests extends BaseClass implements IRetryAnalyzer{
	
	int numRetry = 0;

	@Override
	public boolean retry(ITestResult result) {
		
		if(numRetry < 1) {
			numRetry++;
			setBrowserName("msedge");
			return true;
		}
		
		return false;
	}

}
