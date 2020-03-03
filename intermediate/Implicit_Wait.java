package intermediate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implicit_Wait {

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 String baseUrl="http://google.com";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get(baseUrl);
		 WebElement element = driver.findElement(By.name("q"));
		 element.sendKeys("Selenium Webdriver Interview Questions");
		 element.sendKeys(Keys.RETURN);
		 List<WebElement> list = driver.findElements(By.className("sfbgx"));
		 System.out.println(list.size());
		 System.out.println(driver.findElements(By.tagName("div")).size());
		 driver.quit();

	}

}
