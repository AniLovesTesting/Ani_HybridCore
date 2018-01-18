package readExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel1 {
	public static void main(String[] args) throws IOException {
		
		File src = new File("D:\\Animesh\\Automation\\Fileinput\\testdata1.xls");
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = wb.getSheetAt(0);
		int rowCount = sheet1.getLastRowNum();
		System.out.println("Total no of rows:- " + rowCount);
		
		for(int i=0; i<rowCount; i++){
			
			String data0= sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Test Sheet has data in first row: "+ i + "is"+ data0);
		}
		
wb.close();

	}
	
	
	

}
