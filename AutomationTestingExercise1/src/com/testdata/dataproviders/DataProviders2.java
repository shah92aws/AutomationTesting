package com.testdata.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders2 {
	
	@DataProvider(name="Exceldata")
	public Object[][] readExcelFiles() throws IOException {
		
		String filepath = "C:\\Users\\shahrid92\\Desktop";
		String filename = "Book1.xlsx";
		String sheetname = "Sheet1";
		
		String[][] tabArray = null;
		
		File file =    new File(filepath+"\\"+filename);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		String fileExtensionName = filename.substring(filename.indexOf("."));
		
		if(fileExtensionName.equals(".xlsx")){
			
		    guru99Workbook = new XSSFWorkbook(inputStream);
		    

		} 
		
		else if(fileExtensionName.equals(".xls")){

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }
		
		
		Sheet guru99Sheet = guru99Workbook.getSheet(sheetname);
		
		int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
		
		
		//System.out.println(guru99Sheet.getRow(0).getCell(0));
		
		int totalCols = 2;
		
		tabArray=new String[rowCount+1][totalCols];
		
		//System.out.println(rowCount);
		
		for (int i = 1; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);
	        //System.out.println("loop1 : "+i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        	
	        	//System.out.println("loop2 : "+j);
	            //System.out.print(row.getCell(j).getStringCellValue()+",");
	            tabArray[i][j] = row.getCell(j).getStringCellValue();
	            System.out.println(guru99Sheet.getRow(i).getCell(j));
	        }

	        System.out.println();
	    } 
		
		
		return tabArray;
	}
	
	
	
//	public static void main(String...strings) throws IOException{
//
//	    DataProviders2 objExcelFile = new DataProviders2();
//
//	    String filePath = "C:\\Users\\shahrid92\\Desktop";
//
//	    //objExcelFile.readExcelFiles(filePath,"Book1.xlsx","Sheet1");
//
//	}

	
}
