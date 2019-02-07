package com.testdata.dataproviders;
import org.testng.annotations.DataProvider;


public class DataProviders1 {
	
	@DataProvider(name="DataSet1")
	public Object[][] DataProviders1() {
		Object[][] data = new Object[3][1];
		
		data[0][0] = "Kuala Lumpur";
		data[1][0] = "Selangor";
		data[2][0] = "Kelantan";
		
		return data;
	}

}
