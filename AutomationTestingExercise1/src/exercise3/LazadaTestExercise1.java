package exercise3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testng.TestBase.TestBase;


public class LazadaTestExercise1 extends TestBase {
	
	WebDriver driver;
	String DataDrivenPropertiesFilePath = null;
	
	@Parameters({"URL","DDPFileName"})
	@Test
	public void getProperties(String Url,String DDPFileName) throws IOException {
		
		DataDrivenPropertiesFilePath = System.getProperty("user.dir");
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream(DataDrivenPropertiesFilePath+"\\DataDrivenProperties\\"+DDPFileName);
		
		properties.load(file);
		driver = GetWebDriver(getBrowser(properties.getProperty("browser")));
		driver.get(Url);
		driver.quit();
	}
	
}
