package exercise1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenChromeBrowser {
	
	String baseUrl = "https://www.google.com";
	String workingDir = System.getProperty("user.dir");
	String test = System.setProperty("webdriver.chrome.driver", workingDir+"\\ExecutableWebDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
  @Test
  public void chrome() {
	driver.manage().window().maximize();
	driver.get(baseUrl);
	driver.close();
	driver.quit();
  }
}
