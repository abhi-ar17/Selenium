package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate_commands {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 
		 String appUrl="http://www.DemoQA.com";
		 driver.navigate().to(appUrl);
		 
		 driver.findElement(By.xpath("//*[@id=\"menu-top\"]/li[2]/a")).click();
		 Thread.sleep(1500l);
		 driver.navigate().back();
		 Thread.sleep(1500l);
		 driver.navigate().forward();
		 Thread.sleep(1500l);
		 driver.navigate().to(appUrl);
		 Thread.sleep(1500l);
		 driver.navigate().refresh();
		 Thread.sleep(3000l);
		 driver.close();

	}

}
