package prgms;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 String baseUrl="http://google.com";
		 driver.get(baseUrl);
		 WebElement element = driver.findElement(By.name("q"));
		 element.sendKeys("Flipkart");
		 driver.manage().window().maximize();
		 element.sendKeys(Keys.RETURN);
		 driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3")).click();
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("8129187278");
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("abhi@7295");
	
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		 Thread.sleep(2000L);
		 driver.findElement(By.name("q")).sendKeys("Casual shoes");
		 driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	
	        
			 Thread.sleep(3000L);
			 WebElement ad=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[5]/div/div[2]"));
			 Thread.sleep(3000L);
			 Actions act = new Actions(driver);
			 Action seriesOfActions = act
					 .moveToElement(ad)
					 .click()
					 .build();
			 seriesOfActions.perform();
					 
			 ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
			 driver.switchTo().window(availableWindows.get(1)); 
			 driver.findElement(By.xpath("//*[@id=\"swatch-4-size\"]/a")).click();
			 Thread.sleep(2500l);
			 WebElement gh= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/div/div[2]/div[1]/div"));
			 Action asd_ac = act
					 .moveToElement(gh)
					 .click()
					 .build();
			 asd_ac.perform();
			 Thread.sleep(2500l);
			 WebElement ret = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/div/div[2]/div[2]/div[1]/div[1]"));
			 Action asd_act = act
					 .moveToElement(ret)
					 .click()
					 .build();
			 asd_act.perform();
			 
			 driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button")).click();
			Thread.sleep(2500l);
			 
			 WebElement fg= driver.findElement(By.xpath("//*[@id=\"CNTCT308E32672EF546C3BA3ED9C64\"]/button"));
			 Action asd_a = act
					 .moveToElement(fg)
					 .click()
					 .build();
			 asd_a.perform();
			 driver.findElement(By.xpath("//*[@id=\"to-payment\"]/button")).click();
			 
			 driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[4]/div/div/div[1]/div/label[1]/div[2]/div/div/div[2]/button")).click();
		 
		 
	}

}
