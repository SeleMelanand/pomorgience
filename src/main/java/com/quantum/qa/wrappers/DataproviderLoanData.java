package com.quantum.qa.wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataproviderLoanData {

	
	public static int rowCount;
	public static String getSheet(String worksheetname) {
		
		String datafromexcel = null;
		try {
			FileInputStream fis = new FileInputStream(new File("./testdata/loanData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(worksheetname);
			// get the number of rows
			rowCount = sheet.getLastRowNum();
			System.out.println("count fo row is :"+ rowCount);
			//get the specific value from the last row and save it in a variable
			XSSFRow row = sheet.getRow(rowCount);
			datafromexcel = row.getCell(0).getStringCellValue();
			System.out.println("value from spreadsheet is : "+ datafromexcel);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datafromexcel;

	}	
}





			/*
			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];
			
			
			// loop through all the rows to retrieve the data
			for (int i = 1; i < rowCount + 1; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					for (int j = 0; j < columnCount; j++) { // loop through the columns
						Object cellValue = ""; 
						try {
							cellValue = row.getCell(j).getStringCellValue();
						} catch (Exception e) {
							System.out.println("No data in the respective cell");
						}
						data[i - 1][j] = cellValue; // add to the data array
						//System.out.println(data[i - 1][j]);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}*/
			
			
