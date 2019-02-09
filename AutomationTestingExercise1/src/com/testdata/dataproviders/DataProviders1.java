package com.testdata.dataproviders;
import org.testng.annotations.DataProvider;


public class DataProviders1 {
	
	@DataProvider(name="DataSet1")
	public static Object[][] DataProviders1() {
		Object[][] data = new Object[9][1];
		
		data[0][0] = "Kuala Lumpur";
		data[1][0] = "Selangor";
		data[2][0] = "Kelantan";
		data[3][0] = "Johor";
		data[4][0] = "Pahang";
		data[5][0] = "Perlis";
		data[6][0] = "Perak";
		data[7][0] = "Negeri Sembilan";
		data[8][0] = "Melaka";
		
		return data;
	}

}
