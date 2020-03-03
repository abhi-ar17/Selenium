package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class google {
	WebDriver driver;
  @Test
  public void f() {
	 
	  driver.findElement(By.name("q")).sendKeys("Flipkart");
		 
		 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
  }
  @BeforeTest
  public void beforeTest() {
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver(); 
		 driver.get("https://www.google.com");
		
	  
  }

  @AfterTest
  public void afterTest() {
		 driver.close();
  }

}
