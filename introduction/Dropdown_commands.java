package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_commands {

	public static void main(String[] args) throws InterruptedException {

		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.get("https://www.testandquiz.com/selenium/testing.html");
		 Select s = new Select(driver.findElement(By.id("testingDropdown")));
		 s.selectByVisibleText("Manual Testing");
		 Thread.sleep(2000l);
		 s.selectByValue("Automation");
		 Thread.sleep(2000l);
		 s.selectByIndex(3);
		 Thread.sleep(2000l);
		 driver.close();
	}

}
