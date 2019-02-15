package exercise3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import com.testng.TestBase.TestBase;


public class LazadaTestExercise1 extends TestBase {
	
	WebDriver driver;
	String DataDrivenPropertiesFilePath = null;
	
	@BeforeClass
	public void StartTest() {
		System.out.println("Starting Test Scenario 01");
		System.out.println("Checking url ecommerce lazada web application");
	}
	
	@AfterClass
	public void EndTest() {
		System.out.println("End Test Test Scenario 01");
	}
	
	@Parameters({"URL","DDPFileName"})
	@BeforeMethod
	public void LaunchedBrowser(String Url,String DDPFileName) throws IOException {
		
		DataDrivenPropertiesFilePath = System.getProperty("user.dir");
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream(DataDrivenPropertiesFilePath+"\\DataDrivenProperties\\"+DDPFileName);
		properties.load(file);
		
		driver = GetWebDriver(getBrowser(properties.getProperty("browser")));
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	}
	
	@AfterMethod
	public void TerminateBrowser() {
		driver.quit();
	}
	
	
	@Test(enabled=true,timeOut=5000)
	public void TestCase01() {
		
		Assert.assertEquals(driver.getTitle(), driver.getTitle());
	}
	
	@Test(enabled=true,timeOut=5000)
	public void TestCase02() {
		
		Assert.assertEquals(driver.getTitle(), driver.getTitle());
	}
	
	@Test(enabled=true,timeOut=5000)
	public void TestCase03() {
		
		Assert.assertEquals(driver.getTitle(), "Test");
	}
	
}
