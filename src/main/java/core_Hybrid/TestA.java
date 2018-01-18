package core_Hybrid;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import coreHybrid_Util.Xls_Reader;
//import freemarker.core.ReturnInstruction.Return;

public class TestA {

	@Test(dataProvider ="getData")
	public void testC(Hashtable<String, String>data){
		System.out.println(data.get("Runmode") + "========" + data.get("Col1") + "==========" + data.get("Col2"));
		
	}
	
	@DataProvider()
	public Object[][]getData(){
	
			Xls_Reader xls = new Xls_Reader("D://Animesh//Automation//Eclipse-Luna//Workspace//Ani_HybridCore//data//LoginSampleDate.xls");
			String sheetName ="Data";
			String TestCaseName ="TestC";
			//read data from TestA only
			
			int testStartRowNum =1;
			while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(TestCaseName)){
				testStartRowNum++;
				}
			System.out.println("Test started from row : " + testStartRowNum);
			int colsStartRowNum = testStartRowNum+1;
			int dataStartRowNum =testStartRowNum+2;
			
			
			//calculate rows of data 
			int rows =0;
			while(!xls.getCellData(sheetName, 0, dataStartRowNum+ rows).equals("")){
				rows++;
			
				
			}
			System.out.println("Total no of rows: " + rows);
			
			
			//calculate cols of data 
				int cols =1;
				while(!xls.getCellData(sheetName, cols-1, colsStartRowNum).equals("")){
					cols++;
				}
				
				System.out.println("Total no  of columns : " + cols);
			//	Object[][] data =new Object[rows][cols];
				Object[][] data =new Object[rows][1];
				//Reading data from excel sheet
				int dataRow =0;
				Hashtable<String, String> table = null;
				
				for(int rNum=dataStartRowNum; rNum<dataStartRowNum+rows; rNum++ ){
					table = new Hashtable<String, String>();
					for(int CNum=0; CNum<cols; CNum++)
					{
						String key = xls.getCellData(sheetName, CNum, colsStartRowNum);
						String value=xls.getCellData(sheetName, CNum, rNum);
						table.put(key, value);
					}
					data[dataRow][0] =table;
					dataRow++;
				}  
				return data;
	}   
		
	
} 
	
	
	

