package exercise3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;


public class LazadaTestExercise1 {
	
	@Test
	public void getProperties() throws IOException {
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("D:\\01 My Project 1\\03 Eclipse Workspace 1\\AutomationTestingExercise1\\src\\exercise3\\datadriven.properties");
	
		properties.load(file);
		
		System.out.println(properties.getProperty("url"));
	}
	
}
