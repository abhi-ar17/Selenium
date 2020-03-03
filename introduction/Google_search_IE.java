package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class Google_search_IE {

	public static void main(String[] args) {
	
		 System.setProperty("webdriver.ie.driver","C:\\New folder\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		 WebDriver driver=new InternetExplorerDriver(); 
		 driver.get("https://www.google.com");
		 
		 driver.findElement(By.name("q")).sendKeys("Flipkart");
		 
		 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		 
		 driver.quit();
		 
	}

}
