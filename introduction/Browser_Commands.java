package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Commands {

	public static void main(String[] args) {
	
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 String url = "https://www.google.com";
		 driver.get(url);
		 
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
	  driver.close();
	}

}
