package exercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AgodaTestExercise3 {
	
	String baseUrl = "https://wwww.agoda.com";
	WebDriver driver;
	WebDriverWait wait;
	
	String actual = null;
	String expected = null;
	
	 
	
	 @BeforeClass
	  public void StartTest() {
		  System.out.println("Agoda Exercise Test 1 Started...");
	  }
	  
	  @AfterClass
	  public void EndTest() {
		  System.out.println("Agoda Exercise Test 1 Ended...");
	  }
	  
	  @Parameters({"URL"})
	  @BeforeMethod
	  public void LaunchedBrowser(String url) {
		System.out.println("Launching browser...");
		String workingDir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", workingDir+"\\ExecutableWebDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		wait=new WebDriverWait(driver, 5);
		driver.get(url);
		Reporter.log("The Mozilla browser is opened ");
	  }
	  
	  @AfterMethod
	  public void terminateBrowser(){
		  System.out.println("Closing browser...");
	      driver.close();
	  }
	  
	  @Parameters({"URL"})
	  @Test
	  public void TestUrlParameter(String url) {
		  System.out.println("Url Parameter : "+url);
	  }
	  
	  
	  
	  
}
