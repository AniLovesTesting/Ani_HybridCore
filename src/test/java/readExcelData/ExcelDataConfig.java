package readExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataConfig {
	
	HSSFWorkbook wb;
	HSSFSheet sheet1;
	
	public ExcelDataConfig(String excelpath){
		
		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new HSSFWorkbook(fis);
			
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public String getData(int sheetNumber, int row, int column){
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	} 
	public int getindex(int rowNum){
		sheet1 = wb.getSheetAt(rowNum);
		int noOfRows = sheet1.getLastRowNum();
		return noOfRows;
	}
	
	
	

}
