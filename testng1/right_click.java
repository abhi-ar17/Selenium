package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class right_click {
   WebDriver driver;
	@Test
  public void f() {
		 WebElement e = driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/p/span"));
		 Actions act = new Actions(driver);
		 act.contextClick(e).perform();
		 
	}
  @BeforeTest
  public void beforeTest() {

		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver(); 
		 driver.get("http://medialize.github.io/jQuery-contextMenu/demo.html");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
