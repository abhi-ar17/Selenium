package testng2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.apache.commons.io.FileUtils; 

public class Window_handle {
	WebDriver driver;
  @Test
  public void f() {
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//*[contains(@href='popup.php')]")).click();
	  Set<String> windowsID=driver.getWindowHandles();
	  Iterator<String> it=windowsID.iterator();
	//  String FirstWindow_id=it.next();
	  String SecondWindow_id = it.next();
	  driver.switchTo().window(SecondWindow_id);
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("example@gmail.com");
	  driver.findElement(By.xpath("//input[@name='btnlogin']")).click();
  }
  @BeforeTest
  public void beforeTest() {

		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver(); 
		  driver.get("https://demo.guru99.com/popup.php");
  }

  @AfterTest
  public void afterTest() throws IOException{
	  TakesScreenshot scrnshot=((TakesScreenshot)driver);
	  File src=scrnshot.getScreenshotAs(OutputType.FILE);
	  File dest = new File("C:\\Users\\837366\\Desktop\\Screenshot" + System.currentTimeMillis() + ".png");
	  FileUtils.copyFile(src,dest);
	  
	  driver.close();
  }

}
