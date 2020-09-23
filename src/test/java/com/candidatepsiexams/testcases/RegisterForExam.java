package com.candidatepsiexams.testcases;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.candidatepsiexams.objectrepository.Constants;
import com.candidatepsiexams.reusables.ReusableWebObjectsForTestBase;
import com.candidatepsiexams.reusables.TestNGReusables;

public class RegisterForExam extends TestNGReusables {
	
	@BeforeClass(groups= {"regression","smoke"})
	public void clickOnRegisterLink() {
		click(By.linkText(Constants.registerlinktext));
	}
	
@Test(priority=5,groups= {"smoke"})
public void printingOrganisationNames() throws InterruptedException {
	Thread.sleep(4000);
	List<String> str = printingdropdownvalues(By.xpath(Constants.xpathforPrintingOrganisationNames));
	click(By.xpath(Constants.xpathforPrintingOrganisationNames));
	Thread.sleep(3000);
	//Assert.assertTrue(str.contains("FDNY"));
	//List<WebElement> list= 
for(int i=0;i<str.size();i++) {
	String text= str.get(i);
	System.out.println(text);
	//Assert.assertTrue(validationcontrols(By.xpath(Constants.xpathforPrintingOrganisationNames)));
	
	Assert.assertTrue(str.contains(text));
}
}


@Test(priority=6,groups= {"regression"})
public void verifyTestcenterScreen() throws InterruptedException {
	Thread.sleep(3000);
	dropdowntext(By.id("c0"), "Certification/Professional Associations");
	//dropdown(By.id("c0"), 2);
	Thread.sleep(3000);
	//dropdown(By.id("c1"), 4);
	dropdowntext(By.id("c1"), "American Board of Pain Medicine (ABPM)");
	//Thread.sleep(3000);
	click(By.linkText("American Board of Pain Medicine Certification Part 2"));
	//Thread.sleep(3000);
	//click(By.linkText("Test Centers"));
	//Thread.sleep(3000);
	//driver.switchTo().window("PSI Online - one stop solution for Test Takers");
}

/*@Test
public void cancelRegisteration() {
	click(By.name("Cancel"));
	
	//Assert.assertTrue(validationcontrols(By.xpath("//*[@id=\'body\']/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]")), "error while handling site");
//click(By.linkText("Home"));
//click(By.linkText("FAQs"));
//driver.switchTo().window("PSI Online - FAQs");
}*/


@Test(priority=7,groups= {"smoke"})
public void signInToregisterTest() throws InterruptedException {
	Thread.sleep(3000);
	click(By.name("Submit3"));
	sendtexts(By.name(Constants.emailId),"testingpractice4442020@gmail.com" );
	sendtexts(By.name(Constants.password), "12345678Jj$$");
	click(By.name("loginbtn"));
	click(By.linkText("Find test date"));
	dropdowntext(By.id("c0"), "Certification/Professional Associations");
	Thread.sleep(3000);
	dropdowntext(By.id("c1"), "American Board of Pain Medicine (ABPM)");
	Thread.sleep(3000);
	click(By.xpath("//*[@id=\'radio1\']"));
	
	click(By.id("Continue"));
	Thread.sleep(3000);
	sendtexts(By.name("autoSuggestField"), "21001");
	
	//autoComplete(By.xpath("//*[@id=\'zip_list\']/ul"), By.tagName("li"), "15003,Fair Oaks,PA");
	driver.findElement(By.name("autoSuggestField")).sendKeys(Keys.ENTER);
	//driver.findElements(By.name("autoSuggestField")).send
	Thread.sleep(4000);
	driver.findElement(By.name("autoSuggestField")).sendKeys(Keys.TAB);
	Thread.sleep(8000);
	click(By.id("Searchbtn"));
	//click(By.id("Searchbtn"));
	Thread.sleep(8000);
	
	//explicitwaitforClicking(By.id("TestCenterCB_3"));
	click(By.id("TestCenterCB_3"));
	Thread.sleep(4000);
	click(By.id("Submit4"));
	
	Assert.assertTrue(validationcontrols(By.xpath("//*[@id=\'TCSessionsTbl\']/tbody/tr[2]/td")));
}

@AfterTest(groups= {"regression","smoke"})
public void tearDown() {
	driver.close();
	report.endTest(test);
	report.flush();
}






}
