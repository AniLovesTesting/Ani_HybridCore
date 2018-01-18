package core_Hybrid;

import coreHybrid_Util.Xls_Reader;

public class DataManagement {

	public static void main(String[] args) {
		Xls_Reader xls = new Xls_Reader("D://Animesh//Automation//Eclipse-Luna//Workspace//Ani_HybridCore//data//LoginSampleDate.xls");
		String sheetName ="Data";
		String TestCaseName ="TestA";
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
		
		
		//calculate rows of data 
			int cols =1;
			while(!xls.getCellData(sheetName, cols-1, colsStartRowNum).equals("")){
				cols++;
			}
			
			System.out.println("Total no  of columns : " + cols);
			//Reading data from excel sheet
			
			for(int rNum=dataStartRowNum; rNum<dataStartRowNum+rows; rNum++ ){
				
				for(int CNum=0; CNum<cols; CNum++){
					System.out.println(xls.getCellData(sheetName, CNum, rNum));
				}
			}
	}	
		
	
	
}
