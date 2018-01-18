package coreHybrid_testCases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import coreHybrid_Util.Constants;
import coreHybrid_Util.ExtentManager;
import coreHybrid_Util.Xls_Reader;
import core_Hybrid.Keywords;

public class GmailLogin {
	
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public Keywords app;
	public Xls_Reader xls ;
	public String testName = "GmailTest";
	
	
	/*@BeforeTest
	
	FirefoxDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");*/
	
		
	@Test(dataProvider="getData")
	public void dologin(Hashtable<String, String>data){
		
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting gmail login Test");
		Xls_Reader xls = new Xls_Reader(Constants.suitA_XLS);
		
		Keywords app = new Keywords(test);
		test.log(LogStatus.INFO, "Excuting Keywords");
		//app.executeKeywords(testName, xls);
		app.getGenericKeyWords().reportFailure("xxxxxx");
		/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//browser//geckodriver.exe");
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.google.co.in/");
			driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).click();
			driver.findElement(By.id("identifierId")).sendKeys("cseanimeshkr");
			driver.findElement(By.id("identifierNext")).click();
			driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Ani_Aim@2017");
			driver.findElement(By.id("passwordNext")).click();*/
		
		
			
	}
			
			@DataProvider()
			public Object[][]getData(){
			
					//Xls_Reader xls = new Xls_Reader("D://Animesh//Automation//Eclipse-Luna//Workspace//Ani_HybridCore//data//suitA.xls");
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


