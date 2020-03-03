package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Switch_frame {
	 WebDriver driver;
	@Test
  public void f() {
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		 WebElement source = driver.findElement(By.xpath(".//*[@id='draggable']"));
		 WebElement target = driver.findElement(By.xpath(".//*[@id='droppable']"));
		 Actions a = new Actions(driver);
		 a.dragAndDrop(source, target).build().perform();
		 driver.switchTo().defaultContent();
  }
  @BeforeTest
  public void beforeTest() {
		
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver(); 
		 driver.get("http://jqueryui.com/droppable");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
