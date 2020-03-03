package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Explicit_wait {
	 String eTitle = "Demo Guru99 Page";
	 String aTitle="";
	 WebDriver driver;
	 WebDriverWait wait=new WebDriverWait(driver,20);
  @Test
  public void f() {
	  aTitle=driver.getTitle();
		 if(aTitle.contentEquals(eTitle))
		 {
			 System.out.println("Test Passed");
		 }
		 else
		 {
			 System.out.println("Test Failed");
		 }
      WebElement guru99seleniumlink;
      guru99seleniumlink=wait.until(ExpectedConditions.elementToBeClickable(By.id("philadelphia-field-submit")));
      guru99seleniumlink.click();
      System.out.println("Button Clicked");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver(); 

		
		 driver.get("http://demo.guru99.com/test/guru99home/");
		 driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
