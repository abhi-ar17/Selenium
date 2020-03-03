package introduction;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class Gmail {

	public static void main(String[] args) throws InterruptedException {


		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();  
		 driver.get("https://www.google.com/");
		 
		 driver.findElement(By.className("gb_g")).click();
		 
		// driver.findElement(By.xpath("//*[@id='ow275']/span/span")).click();
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul[1]/li/div/div/div[1]/div/div[3]/a[1]")).click();
 
		 ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(availableWindows.get(1)); 
		 
		 driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Abhirag");
	     Thread.sleep(3000L);                                             
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("A S");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("asabhirag");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("asabhira");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("asabhira");
		 driver.findElement(By.className("CwaK9")).click();
		 
		 driver.close();
     }

}


