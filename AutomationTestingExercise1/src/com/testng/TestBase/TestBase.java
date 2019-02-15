package com.testng.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	WebDriver driver;
	String WebDriverFilePath;
	
	public enum BrowserType{
		Chrome,
		Mozilla,
		IE,
		Safari,
		Opera,
		Edge,
		Null
	}
	
	public WebDriver GetWebDriver(BrowserType Browsers) {
		
		WebDriverFilePath = System.getProperty("user.dir");
		
		switch(Browsers) {
		
			case Chrome: 
				System.setProperty("webdriver.chrome.driver", WebDriverFilePath+"\\ExecutableWebDriver\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case Mozilla: 
				System.setProperty("webdriver.gecko.driver", WebDriverFilePath+"\\ExecutableWebDriver\\geckodriver.exe");
				System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				driver = new FirefoxDriver();
				
			case Edge:
				break;
				
			case IE:
				break;
				
			case Opera:
				break;
				
			case Safari:
				break;
				
			default:
				break;
		}
		
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public BrowserType getBrowser(String browser) {
		
		System.out.println("getbrowser : "+browser);
		
		switch(browser) {
		case "Chrome" : return BrowserType.Chrome;
			
		case "Mozilla" : return  BrowserType.Mozilla;
		
		default: return BrowserType.Null;
			
		}

	}

}
