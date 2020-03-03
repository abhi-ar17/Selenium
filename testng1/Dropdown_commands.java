package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Dropdown_commands {
	 WebDriver driver;
	@Test
  public void f() throws InterruptedException {
		 Select s = new Select(driver.findElement(By.id("testingDropdown")));
		 s.selectByVisibleText("Manual Testing");
		 Thread.sleep(2000l);
		 s.selectByValue("Automation");
		 Thread.sleep(2000l);
		 s.selectByIndex(3);
		 Thread.sleep(2000l);
  }
  @BeforeTest
  public void beforeTest() {

		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.get("https://www.testandquiz.com/selenium/testing.html");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
