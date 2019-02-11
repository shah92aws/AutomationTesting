package exercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testdata.dataproviders.DataProviders2;

public class AgodaTestExercise3 {
	
	String baseUrl = "https://wwww.agoda.com";
	WebDriver driver;
	WebDriverWait wait;
	
	String actual = null;
	String expected = null;
	
	public WebDriver getDriver() {
        return driver;
    }
	
	 @BeforeClass
	  public void StartTest() {
		  System.out.println("Agoda Exercise Test 1 Started...");
	  }
	  
	  @AfterClass
	  public void EndTest() {
		  System.out.println("Agoda Exercise Test 1 Ended...");
	  }
	  
	  //@Parameters({"URL"})
	  @BeforeMethod
	  public void LaunchedBrowser() {
		System.out.println("Launching browser...");
		String workingDir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", workingDir+"\\ExecutableWebDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		wait=new WebDriverWait(driver, 5);
		driver.get("https://wwww.agoda.com");
		Reporter.log("The Mozilla browser is opened ");
	  }
	  
	  @AfterMethod
	  public void terminateBrowser(){
		  System.out.println("Closing browser...");
	      driver.close();
	  }
	  
	 
	  @Test(enabled=true,dataProviderClass=DataProviders2.class, dataProvider = "Exceldata")
	  public void TestUrlParameter(String name,String add) {
		  System.out.println("Test1 : "+name);
		  System.out.println("Test2 : "+add);
	  }

}
