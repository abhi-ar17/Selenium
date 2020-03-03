package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Implicit_wait {
	WebDriver driver;
	 String baseUrl="http://google.com";
  @Test
  public void f() {
	  WebElement element = driver.findElement(By.name("q"));
		 element.sendKeys("Selenium Webdriver Interview Questions");
		 element.sendKeys(Keys.RETURN);
		 List<WebElement> list = driver.findElements(By.className("sfbgx"));
		 System.out.println(list.size());
		 System.out.println(driver.findElements(By.tagName("div")).size());
	
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver(); 
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get(baseUrl);
  }

  @AfterTest
  public void afterTest() {
		 driver.quit();
  }

}
