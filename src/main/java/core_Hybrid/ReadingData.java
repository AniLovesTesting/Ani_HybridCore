package core_Hybrid;

import java.util.Hashtable;
import java.util.jar.Attributes.Name;

import coreHybrid_Util.Xls_Reader;

public class ReadingData {

	public static void main(String[] args) {
		Xls_Reader xls = new Xls_Reader("D://Animesh//Automation//Eclipse-Luna//Workspace//Ani_HybridCore//data//LoginSampleDate.xls");
			int rows =xls.getRowCount("Login");
			System.out.println("Total no of Rows: "+ rows);
			int cols = xls.getColumnCount("Login");
			System.out.println("Total no of cols: " + cols);
			
			String data = xls.getCellData("Login", 0, 5);
			System.out.println(data);
			data = xls.getCellData("Login", 0, 3);
			System.out.println(data);
			 
			xls.setCellData("Login", "Password", 8, "Animesh/Learning");
			
			Hashtable<String,String> table = new Hashtable<String, String>();
				table.put("City", "London");
				table.put("Name", "Ani");
				System.out.println(table.get("Name"));
					
			
		

	}

}
