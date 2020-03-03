package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Alert_window {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button")).click();
		 Alert simpleAlert=driver.switchTo().alert();
		 String alertText = simpleAlert.getText();
		 System.out.println("Alert text is :  " + alertText);
		 Thread.sleep(2000l);
		 simpleAlert.accept();
		 Thread.sleep(2000l);
		 driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button")).click();
		 Thread.sleep(2000l);
		 driver.switchTo().alert().dismiss();
		 //driver.switchTo().alert().accept();
		 Thread.sleep(2000l);
		 System.out.println("You clicked Cancel");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver(); 
		 driver.get("https://www.testandquiz.com/selenium/testing.html");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
