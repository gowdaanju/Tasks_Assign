package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet implements AutoConstant {
	public static String readDataFromexcel(String sheetName, int row, int cell) throws IOException {

		
		
			XSSFWorkbook workbook=null;
			String val="";
			
			try {
				FileInputStream fis = new FileInputStream(Excel_Path);
				workbook = new XSSFWorkbook(fis);
				val = workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
			} catch (FileNotFoundException e) {	
				System.out.println("Failed to read data from excel..!!!!");
			
			} finally {
					
				try {
					workbook.close();
				} catch (Exception e2) {
					System.out.println("Failed to close excel..!!!!");
				}
			}
				
			return val;
		}
		
		
	public static void writeDataToExcel(String sheetName, int row, int cell, String status) throws IOException {
				
		try {
			FileInputStream fis = new FileInputStream(Excel_Path);	
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row rowno = sheet.createRow(row);
			Cell cellno = rowno.createCell(cell);	
					
//			if(cellno==null) {
//				rowno.createCell(cell);
//				cellno.setCellValue(status);
//			}else {
//				cellno.setCellValue(status);
//			}
//				
			FileOutputStream fio = new FileOutputStream(Excel_Path);			
			workbook.write(fio);
			workbook.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
					
	}

}



