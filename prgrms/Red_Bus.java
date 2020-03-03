package prgrms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Red_Bus {
	WebDriver driver;
  @Test
  public void a_from_and_to() throws InterruptedException {
	
	  driver.findElement(By.xpath("//*[@id=\"src\"]")).sendKeys("Chennai");
	  driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[1]/div/ul/li[2]")).click();
	 driver.findElement(By.xpath("//*[@id=\"dest\"]")).sendKeys("Trivandrum"); 
	 driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]/div/ul/li[1]")).click();
	  
  }
  
  @Test
  public void b_date_picker() throws InterruptedException
  {
	  
	//  driver.findElement(By.xpath("//*[@id=\"onward_cal\"]")).click();

	
	 driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
	  
	  while(true)
	  {
		  WebElement  mon = driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]"));
		  if(mon.getAttribute("innerHTML").contains("Apr 2020"))
		  {
			  break;
		  }
		  else
		  {
			//  System.out.println("....................................................................");
				 driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
		  }
	  }

	  List<WebElement> dates = driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']//*[@class='wd day' or @class='we day']"));
	  int count = dates.size();
	// System.out.println(count);
	  
	  for(int i=0;i<count;i++)
	  {
		  String text = dates.get(i).getText();
		//  System.out.println(text);
		  
		  if(text.equalsIgnoreCase("15"))
		  {
			  dates.get(i).click();
			  break;  
		  }
	  }
  }
  
  @Test
  public void c_search()
  {
	  driver.findElement(By.xpath("//*[@id=\"search_btn\"]")).click();
  }
  
  @Test
  public void d_view_seats()
  {
	  driver.findElement(By.xpath("//*[@id=\"12083548\"]/div/div[2]/div[1]")).click();
		 Actions actions = new Actions(driver);
		 WebElement menuOption = driver.findElement(By.xpath("//*[@id='rt_12083548']/div/div/div/div[3]/div[2]/div[3]/canvas"));
		 actions.moveToElement(menuOption).perform();

  }
  @BeforeClass
  public void beforeClass() {
		
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver(options); 
		  driver.get("https://www.redbus.in/");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
  }
//*[@id="rb-calendar_onward_cal"]/table/tbody/tr[1]/td[2]
}
