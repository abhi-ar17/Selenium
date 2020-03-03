package testng1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class navigate_commands {
	 String appUrl="http://www.DemoQA.com";
	 WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"menu-top\"]/li[2]/a")).click();
		 Thread.sleep(1500l);
		 driver.navigate().back();
		 Thread.sleep(1500l);
		 driver.navigate().forward();
		 Thread.sleep(1500l);
		 driver.navigate().to(appUrl);
		 Thread.sleep(1500l);
		 driver.navigate().refresh();
		 Thread.sleep(3000l);
  }
  
  @BeforeTest
  public void g()
  {
	  System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 
	
		 driver.navigate().to(appUrl);
  }
  @AfterTest
  public void h()
  {
	  driver.close();
  }
}
