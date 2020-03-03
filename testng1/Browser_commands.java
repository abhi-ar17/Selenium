package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Browser_commands {
	 String url = "https://www.google.com";
	WebDriver driver;
  @Test
  public void f() {
	  String title = driver.getTitle();
		 
		 int titleLength = driver.getTitle().length();
		 
		 System.out.println("Title of the page is : " + title);
		 System.out.println("Length of the title  is : " + titleLength);
		 
		 String actualUrl = driver.getCurrentUrl();
		 
		 if(actualUrl.equals(url))
		 {
			 System.out.println("Verification Successful - The correct url is opened");
		}
		 else
		 {
			 System.out.println("Verification Failed - An incorrect Url is opened");
			 System.out.println("Actual URL is :"+ actualUrl);
			 System.out.println("Expected Url is : " + url);
		 }
   String pageSource = driver.getPageSource();
   int pageSourceLength=pageSource.length();
   System.out.println("Total length of the page Source is : " + pageSourceLength);
  }
  @BeforeTest
  public void beforeTest() {

		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver(); 
	
		 driver.get(url);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
