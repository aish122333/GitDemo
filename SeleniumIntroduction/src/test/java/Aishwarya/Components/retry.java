package Aishwarya.Components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {
	int count = 0;
	int maxRetry = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (count < maxRetry) {
			count++;
			return true;
		}
		return false;
	}

}
