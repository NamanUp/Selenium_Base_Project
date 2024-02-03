package com.generic_Library;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Utility {

	public static String getPropertyValue(String KEY) throws Throwable {
		
		FileInputStream file = new FileInputStream("./src/test/resources/data/commonData.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(KEY);
		
	}
	
	public static String fetchSingleDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/data/registerScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);		
		return cell.getStringCellValue();
	}
	
	public static Object[][] fetchMultipleDataFromExcel(String sheetname) throws Throwable{
		FileInputStream fis = new FileInputStream("./src/test/resources/data/registerScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		
		int rowCount = sheet.getPhysicalNumberOfRows(); 		 	//number of rows
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells(); // number of headings inside the row - username & password
		
		Object[][] data = new Object[rowCount-1][cellCount];
		
		for(int i = 1; i < rowCount; i++) {
			for(int j = 0; j < cellCount; j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
				
	}
}
