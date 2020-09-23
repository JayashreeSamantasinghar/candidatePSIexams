package com.candidatepsiexams.reusables;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.LogStatus;
//testng extend  testbase
public class TestNGReusables extends  ExtentCustomizedReports  {
	public static WebDriver driver;
	public static Select select;
	public static ExtentCustomizedReports ext;
	
	//public static ExtentCustomizedReports ext;
	//public static ReusablePropertiesFile reusableProperties;
	
	
	@BeforeTest(groups= {"regression","smoke"})
	public void setup() {
	ext= new ExtentCustomizedReports(System.getProperty("user.dir")+"\\results.html");
		launchbrowser("https://candidate.psiexams.com/index.jsp", "Chrome");		
	}
	

	/*@AfterTest(groups= {"regression","smoke"})
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	
	}*/
	
	
	
	public static void launchbrowser(String url,String browser) {
		if(browser=="Chrome") {	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jayas\\Desktop\\selenium softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		//driver.navigate().to(url);
		}else if(browser=="Firefox")
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\jayas\\Desktop\\selenium softwares\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
	}
	

	public static void sendtexts(By locatorname,String value)throws InterruptedException {
		try {
		driver.findElement(locatorname).clear();
		driver.findElement(locatorname).sendKeys(value);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//test.log(LogStatus.PASS, stepname);
		}catch(Exception e) {
			//test.log(LogStatus.FAIL, stepname);
			e.printStackTrace();
		}	
	}
	
	
	public static void click(By locatorname) {
		try {
		driver.findElement(locatorname).click();
		
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public static Select sponsorname;
	public static void dropdowntext(By locatorname,String text)throws InterruptedException {
		try {
		WebElement dropdownlist=driver.findElement(locatorname);
		sponsorname=new Select(dropdownlist);
			sponsorname.selectByVisibleText(text);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
public static void dropdown(By locatorname,int index) {
		
		WebElement dropdownlist=driver.findElement(locatorname);
		sponsorname=new Select(dropdownlist);
			sponsorname.selectByIndex(index);
			
}

	
	
	public static boolean  validationcontrols(By locatorname) {
		boolean status=false;
		try {
		 status=driver.findElement(locatorname).isDisplayed();
		
		}catch(Exception e)
		{
			//test.log(LogStatus.FAIL, stepname);
			e.printStackTrace();
		}
		return status;
		}

	
	
	public static  List<String> printingdropdownvalues(By locatorname){
		
		List<WebElement> ele = driver.findElements(locatorname);
		List<String> list = new ArrayList<String>();
		for(int i=0;i<ele.size();i++) {
		list.add(ele.get(i).getText());	
		}
	return list;
	}


	
	
	
			
			public static String alertText(String stepname) {
		String text=null;
		try {
		text=driver.switchTo().alert().getText();
	    //System.out.println(text);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    test.log(LogStatus.PASS, stepname);
	    }
		catch(Exception e) {
			test.log(LogStatus.FAIL, stepname);
			//test.log(LogStatus.FAIL, test.addScreenCapture(takeScreenShot(driver))+"test failed");
		}
	    return text;    		
	}
			
			
			public static void alert() {
			    try {
				driver.switchTo().alert().accept();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    }catch(Exception e) {
			    	e.printStackTrace();
				}
			}

	
	
	
	public static Actions action;
	public static void mouseover(By locatorname) {
		try {
		  action=new Actions(driver);
		action.moveToElement(driver.findElement(locatorname)).build().perform();
		//test.log(LogStatus.PASS, stepname);
		}catch(Exception e) {
			//test.log(LogStatus.FAIL, stepname);
			e.printStackTrace();
		}
	}
	
	
	public static void scrollbar(By locatorname) {
		try {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement element= driver.findElement(locatorname);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 js.executeScript("arguments[0].scrollIntoView(true);", element);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// test.log(LogStatus.PASS, stepname);
	}catch(Exception e) {
		//test.log(LogStatus.FAIL, stepname);
		e.printStackTrace();
	}
}
	
	public static void takeScreenShotOfPage(String path) throws IOException {
		TakesScreenshot tc = (TakesScreenshot)driver;
		File fi = tc.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(fi, new File(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
}
