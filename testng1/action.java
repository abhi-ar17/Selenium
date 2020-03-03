package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class action {
	WebDriver driver;
  @Test
  public void f() {
	  WebElement txtUsername=driver.findElement(By.id("email"));
		 Actions builder = new Actions(driver);
		 Action seriesOfActions = builder
				 .moveToElement(txtUsername)
				 .click()
				 .keyDown(txtUsername, Keys.SHIFT)
				 .sendKeys(txtUsername, "hello")
				 .keyUp(txtUsername, Keys.SHIFT)
				 .doubleClick(txtUsername)
				 .contextClick()
				 .build();
		 seriesOfActions.perform();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver(); 
		 driver.get("http://www.facebook.com");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
