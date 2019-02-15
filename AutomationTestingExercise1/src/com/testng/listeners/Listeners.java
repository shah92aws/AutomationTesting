package com.testng.listeners;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testng.TestBase.*;

public class Listeners implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Start Test");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() +" Test Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		Object currentClass = result.getInstance();
		WebDriver webDriver = ((TestBase) currentClass).getDriver();
		
		try{
			
			TakesScreenshot scrShot =((TakesScreenshot)webDriver);
			
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			File DestFile=new File("c://test.png");
			
			FileUtils.copyFile(SrcFile, DestFile);
			
			System.out.println(result.getName() + " Test Failed");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
