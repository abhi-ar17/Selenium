package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class gmail {
	WebDriver driver;
  @Test
  public void f() {
	  
		 driver.findElement(By.className("gb_g")).click();
		 
		// driver.findElement(By.xpath("//*[@id='ow275']/span/span")).click();
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul[1]/li/div/div/div[1]/div/div[3]/a[1]")).click();
  }
  @Test
  public void h() throws InterruptedException
  {
	  ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(availableWindows.get(1)); 
		 
		 driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Abhirag");
	     Thread.sleep(3000L);                                             
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("A S");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("asabhirag");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("asabhira");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("asabhira");
		 driver.findElement(By.className("CwaK9")).click();

  }
  @BeforeTest
  public void beforeTest() {


		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();  
		 driver.get("https://www.google.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
