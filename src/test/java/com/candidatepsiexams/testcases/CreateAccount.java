package com.candidatepsiexams.testcases;

import java.util.Date;

import java.util.Random;

//import java.io.FileInputStream;

//import java.io.IOException;
//import java.util.Properties;


//import org.apache.poi.openxml4j.opc.PackageProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.candidatepsiexams.objectrepository.Constants;
//import com.candidatepsiexams.reusables.Constants;
//import com.candidatepsiexams.reusables.ReusableWebObjectsForTestBase;
import com.candidatepsiexams.reusables.TestNGReusables;
import com.relevantcodes.extentreports.LogStatus;

//import utilities.ReadConfig;

public class CreateAccount extends TestNGReusables {//OR extends from testng reusables for extent report
	
	//ReadConfig p = new ReadConfig("C:\\Users\\jayas\\Desktop\\mypr\\MavenProject1\\config.proprtiesForPSI");
	
@BeforeClass(groups= {"regression","smoke"})
public void clickOnCreateAccount() {
	test= report.startTest("create an account");
	click(By.linkText(Constants.createAccountlinktext));
	//ReadConfig.prop.getProperty("createAccountlinktext");
	test.log(LogStatus.PASS, "account is created");
}

@Test(priority=4,groups= {"regression"})
public void createTheAccount() throws InterruptedException {
	
	Thread.sleep(4000);
	Random r= new Random();
	int num=r.nextInt(1000);
	//Date d=new Date();
	//d.getDay();
	//d.getDate();
	sendtexts(By.name(Constants.emailId),"testingpractice"+num+"2020@gmail.com" );
	
	sendtexts(By.name(Constants.firstname),"Jayas" );
	
	sendtexts(By.name(Constants.lastname),"Samanta" );
	
	sendtexts(By.name(Constants.password),"12345678Jj$$" );
	
	sendtexts(By.name(Constants.confirmpassword),"12345678Jj$$" );
	
	dropdown(By.name(Constants.securityquestion),1 );
	
	sendtexts(By.name(Constants.securityanswer),"california" );
	
	click(By.name(Constants.submit));
	
		
}

@Test(priority=2,groups= {"smoke"})
public void checkingforAlreadyExistingAccount() throws InterruptedException {
	Thread.sleep(4000);
sendtexts(By.name(Constants.emailId),"testingpractice2020@gmail.com" );
	
	sendtexts(By.name(Constants.firstname),"Jayas" );
	
	sendtexts(By.name(Constants.lastname),"Samanta" );
	
	sendtexts(By.name(Constants.password),"12345678Jj$$" );
	
	sendtexts(By.name(Constants.confirmpassword),"12345678Jj$$" );
	
	dropdown(By.name(Constants.securityquestion),1 );
	
	sendtexts(By.name(Constants.securityanswer),"california" );
	
	click(By.name(Constants.submit));
	Thread.sleep(4000);
	
}
@Test(priority=1,groups= {"regression"})
public void showUIValidations() throws InterruptedException {
	Thread.sleep(4000);
	click(By.name(Constants.submit));
	Assert.assertTrue(validationcontrols(By.xpath(Constants.xpathValidationForEmailID)),"error for emailId is shown" );

Assert.assertTrue(validationcontrols(By.xpath("//*[@id=\'tbl\']/table/tbody/tr[5]/td/fieldset/table/tbody/tr[3]/td[2]/div")), "error for firstname is shown");
Assert.assertTrue(validationcontrols(By.xpath("//*[@id=\'tbl\']/table/tbody/tr[5]/td/fieldset/table/tbody/tr[3]/td[4]/div")), "error for lastname is shown");

}

@Test(priority=3,groups= {"smoke"})
public void passwordRuleMatching() throws InterruptedException {
	Thread.sleep(4000);
sendtexts(By.name(Constants.emailId),"testingpractice2020@gmail.com" );
	
	sendtexts(By.name(Constants.firstname),"Jayas" );
	
	sendtexts(By.name(Constants.lastname),"Samanta" );
	
	sendtexts(By.name(Constants.password),"12345678Jj$$" );
	
	sendtexts(By.name(Constants.confirmpassword),"123456789Jj$$" );
	
	dropdown(By.name(Constants.securityquestion),1 );
	
	sendtexts(By.name(Constants.securityanswer),"california" );
	
	click(By.name(Constants.submit));
	alert();
		
}


@AfterClass(groups= {"regression","smoke"})
public void logout() throws InterruptedException {
	click(By.linkText("Logout"));
	Thread.sleep(3000);
}




}
