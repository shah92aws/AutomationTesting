package exercise2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AgodaTestExercise1 {
	
	String baseUrl = "https://wwww.agoda.com";
	WebDriver driver;
	WebDriverWait wait;
	
	String actual = null;
	String expected = null;
	
  @BeforeClass
  public void StartTest() {
	  System.out.println("Agoda Exercise Test 1 Started...");
  }
  
  @BeforeMethod
  public void LaunchedBrowser() {
	System.out.println("Launching browser...");
	String workingDir = System.getProperty("user.dir");
	System.setProperty("webdriver.gecko.driver", workingDir+"\\ExecutableWebDriver\\geckodriver.exe");
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	driver = new FirefoxDriver();
	wait=new WebDriverWait(driver, 5);
	driver.get(baseUrl);
	Reporter.log("The Chrome browser is opened ");
  }
  
  @Test(priority=1,enabled=false,timeOut=7000)
  public void VerifiedTitle() {
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	  expected = "Agoda: Cheap Hotel Booking - Discount Accommodations";
	  actual = driver.getTitle();
	  Assert.assertEquals(actual, expected);
  }
  
  @Test(priority=0,enabled=false,dependsOnMethods="VerifiedTitle")
  public void SearchResult() {
	  expected = "BEST MATCH";
	  
	  Reporter.log("Inside search bar the 'Kedah' is entered");
	  
	  driver.findElement(By.xpath("//input[@placeholder='Enter a destination or property']")).sendKeys("Kedah");
	 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Popup__content']//li[2]//li[2]"))).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Months']//div[1]//div[3]//div[3]//div[3]//span[1]"))).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Day']//span[@class='DayPicker-Day__label'][contains(text(),'18')]"))).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Family travelers')]"))).click();
	  
	  for(int i=0;i<4;i++) {
		  driver.findElement(By.xpath("//div[@class='OccupancySelector OccupancySelector--travelWithKids']//div[2]//span[4]")).click();
	  }
	  
	  Reporter.log("Search button is clicked");
	  
	  driver.findElement(By.xpath("//button[@class='btn Searchbox__searchButton Searchbox__searchButton--active']")).click();
	  
	  Reporter.log("Result generated");
	  
	  actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'BEST MATCH')]"))).getText();
	  
	  Assert.assertEquals(actual, expected);
  }
  
  @AfterMethod
  public void terminateBrowser(){
	  System.out.println("Closing browser...");
      driver.close();
  }
  
  @AfterClass
  public void EndTest() {
	  System.out.println("Agoda Exercise Test 1 Ended...");
  }
  
  
 
}
