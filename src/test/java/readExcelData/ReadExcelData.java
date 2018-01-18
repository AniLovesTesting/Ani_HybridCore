package readExcelData;

public class ReadExcelData {

	public static void main(String[] args) {

		ExcelDataConfig excel = new ExcelDataConfig("D://Animesh//Automation//Eclipse-Luna//Workspace//Ani_HybridCore//data//suitA.xls" );
			System.out.println(excel.getData(1, 0, 1));
			

	}

}
