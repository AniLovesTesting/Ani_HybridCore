package core_Hybrid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginIntoApplication {
	
	
	
	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/browser/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		 	driver.get("https://in.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='mega-bottombar']/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='mega-bottombar']/ul/li[3]/a")).click();
		
		
		 
		
		
	}

}
