package core_Hybrid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class GenericKeywords {
	 public WebDriver driver;
	 public Properties prop;
	 
	 public GenericKeywords() throws IOException{
		 prop = new Properties();
		 try{
			 FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//resourse//project.properties");
			 prop.load(fs);
			// System.out.println("prpperties loaded");
		 }catch(FileNotFoundException e){
			 e.printStackTrace();
		 }
		 
	 }
	 
	public void openBrowser(String browserType){
		
		if (browserType.equals("Mozilla")){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//browser//geckodriver.exe" );
			driver = new FirefoxDriver(); 
		}else if(browserType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//browser//chromedriver.exe" );
				driver = new ChromeDriver();
				
		}else if (browserType.equals("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//src//test//resources//browser//IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		
	}
	
	public void navigate(String urlkey){
		
		System.out.println("Navigating to " + prop.getProperty(urlkey));
		
		driver.get(prop.getProperty(urlkey));
		
		}
	
	public void click(String locatorkey){
		
		System.out.println("Clicking on " + prop.getProperty(locatorkey));
		WebElement e = getElement(locatorkey);
		e.click();
				
		
	}
	
	public void input(String locatorkey, String data){
		
		System.out.println("Typing email " + prop.getProperty(locatorkey));
		WebElement e = getElement(locatorkey);
		e.sendKeys(data);
		
	}
	
	public void veryfyTest(String  locator, String expectedTest){
		
		
	}
	/*******************************utilities functions***************************/
	
	public WebElement getElement(String locatorkey){
		WebElement e = null;
		try{
			if(locatorkey.endsWith("_id"))
				e = driver.findElement(By.id(prop.getProperty(locatorkey)));
			else if(locatorkey.endsWith("_xpath"))
				e = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
			else if(locatorkey.endsWith("_name"))
				e = driver.findElement(By.name(prop.getProperty(locatorkey)));
		}catch(Exception ex){
			Assert.fail("Failure in Element Extraction -" + locatorkey);
			
		}
		
		return e;
		
		
	}
	
	
	
}
