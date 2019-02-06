package exercise1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenMozillaBrowser {
	
	String baseUrl = "https://www.google.com";
	String workingDir = System.getProperty("user.dir");
	String driverPath = System.setProperty("webdriver.gecko.driver", workingDir+"\\ExecutableWebDriver\\geckodriver.exe");
	String browserPath = System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	WebDriver driver = new FirefoxDriver();

  @Test
  public void mozilla() {
	driver.manage().window().maximize();
	driver.get(baseUrl);
	System.out.println(driver.getTitle());
	//driver.close(); //will throw an exception
	driver.quit();
  }
}
