package com.candidatepsiexams.reusables;

import java.io.File;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//import com.relevantcodes.extentreports.LogStatus;
//testbase
public class ReusableWebObjectsForTestBase {
	//public class ReusableWebObjectsForTes	
	
	public static ReusablePropertiesFile reusableProperties;
	
@BeforeTest(groups= {"regression","smoke"})
public void setup() {
	//ext= new ExtentCustomizedReports(System.getProperty("user.dir")+"\\results.html");
	launchbrowser("https://candidate.psiexams.com/index.jsp", "Chrome");		
}


@AfterTest(groups= {"regression","smoke"})
public void tearDown() {
	close();
	//report.endTest(test);
	//report.flush();
}


public static WebDriver driver;
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
	
	
	public static void close() {
		driver.close();
	}

	
	
	public static void navigate(String url) {
		driver.navigate().to(url);
		//driver.navigate().to(reusableProperties.);
		
	}
	
	public static void frame(int index) {
		driver.switchTo().frame(index);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public static void sendtexts(By locatorname,String value) {
		driver.findElement(locatorname).clear();
		driver.findElement(locatorname).sendKeys(value);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	
	public static void click(By locatorname) {
		driver.findElement(locatorname).click();
	}
	
	
	
	public static boolean image(By locatorname) {
		boolean status=driver.findElement(locatorname).isDisplayed();
		return status;
	}
	
	
	
	public static boolean textbox(By locatorname) {

		boolean txtbox=driver.findElement(locatorname).isEnabled();
		return txtbox;
	}
	
	
	public static boolean checkbox(By locatorname) {
	
		boolean txtbox=driver.findElement(locatorname).isEnabled();
		return txtbox;
	
	}
	
	//public static WebElement dropdownlist;
	public static Select sponsorname;
public static void dropdown(By locatorname,int index) {
		
		WebElement dropdownlist=driver.findElement(locatorname);
		sponsorname=new Select(dropdownlist);
			sponsorname.selectByIndex(index);
			
}



public static void dropdowntext(By locatorname,String text) {
	WebElement dropdownlist=driver.findElement(locatorname);
	sponsorname=new Select(dropdownlist);
		sponsorname.selectByVisibleText(text);
		
		
}

public static  List<String> printingdropdownvalues(By locatorname){
	List<WebElement> ele = driver.findElements(locatorname);
	List<String> list = new ArrayList<String>();
	for(int i=0;i<ele.size();i++) {
	list.add(ele.get(i).getText());	
	}
return list;
}

	public static String texts(By locatorname) {
	String text = driver.findElement(locatorname).getText();
	return text;
	}
	

	
	//public static WebElement draggable;
	public static Actions action;
	public static void draggable(By locatorname,int xOffset, int yOffset) {
		action=new Actions(driver);
		WebElement draggable=driver.findElement(locatorname);
		
		//action=new Actions(driver);
		action.dragAndDropBy(draggable, xOffset, yOffset).perform();
	}
			

public static void mouseover(By locatorname) {
	  action=new Actions(driver);
	action.moveToElement(driver.findElement(locatorname)).build().perform();
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
}


public static String alertText() {
	String text=driver.switchTo().alert().getText();
    //System.out.println(text);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return text;
}


public static void alert() {
    //
	driver.switchTo().alert().accept();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
}



public static void selectable(By locatorname) {

	WebElement item = driver.findElement(locatorname);
	
	//WebElement item[]=new WebElement[100];	
action=new Actions(driver);
//for(int i=0;i<item.length;i++) {

action.keyDown(Keys.CONTROL).click(item).perform();
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
action.keyUp(Keys.CONTROL).perform();
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}



public static boolean  validationcontrols(By locatorname) {
	boolean status=driver.findElement(locatorname).isDisplayed();
return status;

}

public static WebDriverWait wait;
public static void explicitwaitforClicking(By locatorname) {
 wait=new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.elementToBeClickable(locatorname));
//wait.until(ExpectedConditions.	
	}

public static void autoComplete(By locatornameForSearch,By locatornameForListBox,String search){
	WebElement search1=driver.findElement(locatornameForSearch);
	List<WebElement> element1=search1.findElements(locatornameForListBox);
	for(int i=0;i<element1.size();i++){
		String text=element1.get(i).getText();
		if(text.equalsIgnoreCase(search)){
			element1.get(i).click();
			break;
			}
			}	
}

public static void scrollbar(By locatorname) {
	JavascriptExecutor js= (JavascriptExecutor)driver;
	WebElement element= driver.findElement(locatorname);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 js.executeScript("arguments[0].scrollIntoView(true);", element);
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
}

}

	
