package intermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Action;

public class Mouse_hover {

	public static void main(String[] args) {

		
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 driver.get("http://demoqa.com/menu/");
		 System.out.println("Demoqa webpage Displayed");
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		 
		 Actions actions = new Actions(driver);
		 WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
		 actions.moveToElement(menuOption).perform();
		 System.out.println("Done mouse hover on 'Music' from Menu");
		 
		 
	}

}
