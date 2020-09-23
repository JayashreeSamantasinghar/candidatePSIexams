package com.candidatepsiexams.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.candidatepsiexams.reusables.ReusableWebObjectsForTestBase;

//import com.candiatepsiexams.testcases.ITestContext;

public class TestListner extends ReusableWebObjectsForTestBase implements ITestListener {
	//@Override
	public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();       
    	takeScreenShot(methodName, driver);
    }
    
    public void takeScreenShot(String methodName, WebDriver driver) {
    	Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
            	String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                File destFile = new File((String) reportDirectory+"/failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }

	/*public void onTestFailure(ITestResult result) {
		System.out.println("xxxxError"+result.getName()+"test has failedxxxx");
		String methodname = result.getName().toString().trim();
		takeScreenShot(methodname,driver);
	}
	
	public void takeScreenShot(String methodname,WebDriver driver) {
		//Calender calender = Calender.
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String reportDirectory = new File(System.getProperty("user.dir"))+"/target/reports";
		File destfile = new File((String)reportDirectory+"failure screenshots"+methodname+"_"+formater.format(date));
	}*/
	
	

}
