package com.candidatepsiexams.testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestcases implements IRetryAnalyzer {
	private int retryCnt = 0;
    //You could mentioned maxRetryCnt (Maximiun Retry Count) as per your requirement. Here I took 2, If any failed testcases then it runs two times
    private int maxRetryCnt = 2;
    
    //This method will be called everytime a test fails. It will return TRUE if a test fails and need to be retried, else it returns FALSE
    public boolean retry(ITestResult result) {
        if (retryCnt < maxRetryCnt) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
        return false;
    }
   
	/*private int retrycnt=0;
	private int maxretrycnt=2;
	public boolean retry(ITestResult result) {
		if(retrycnt<maxretrycnt) {
			System.out.println("retrying"+result.getTestName()+"again and the count is"+);
			retrycnt++;
			return true;
		}
	}*/

}
