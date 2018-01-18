package readExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		
		File src = new File("D:\\Animesh\\Automation\\Fileinput\\testdata1.xls");
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = wb.getSheetAt(0);
		String data1 = sheet1.getRow(2).getCell(1).getStringCellValue();
		
		System.out.println("iData from excel 0 is -" + data1);
		
		wb.close();
	}
	
	
	

}
