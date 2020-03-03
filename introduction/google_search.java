package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_search {

	public static void main(String[] args) {
	
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 driver.get("https://www.google.com");
		 
		 driver.findElement(By.name("q")).sendKeys("Flipkart");
		 
		 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		 
		 driver.quit();
		 
	}

}
