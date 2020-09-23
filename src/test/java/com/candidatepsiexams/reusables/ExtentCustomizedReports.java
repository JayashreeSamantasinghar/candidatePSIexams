package com.candidatepsiexams.reusables;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

public class ExtentCustomizedReports {
	
	public static ExtentReports report;//path of report where it is resent
	public static ExtentTest test; //status of report(pass/fail)
	
ExtentCustomizedReports(){
	
}
ExtentCustomizedReports(String path){
	report= new ExtentReports(path);
	
}
}
