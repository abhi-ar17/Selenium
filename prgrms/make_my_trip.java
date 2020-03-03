package prgrms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;

public class make_my_trip {
	
	WebDriver driver;
	
  @Test
  public void a_from_and_to() throws InterruptedException {
	 WebElement abc= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]"));
	 Actions act = new Actions(driver);
	 Action seriesOfActions = act
			 .moveToElement(abc)
			 .click()
			 .build();
	 seriesOfActions.perform();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 // WebDriverWait wait=new WebDriverWait(driver,20);
	  
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("chenn");
	  Thread.sleep(6000l);
	  
	  //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"react-autowhatever-1-section-0-item-0\\\"]/div/div[1]/p[1]")));
	  

		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")).click();
        
		 WebElement bc= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/label/span"));
		// Actions act = new Actions(driver);
		 Action seri = act
				 .moveToElement(bc)
				 .click()
				 .build();
		 seri.perform();
		 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("mumbai,india");
		 Thread.sleep(6500l);
		 WebElement arc = driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1\"]"));
		arc.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']/div/div[1]/p[1]")).click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		// driver.findElement(By.xpath())
  }
  
  @Test
  public void b_date_picker() throws InterruptedException
  {
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]")).click();
	  WebElement month = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div"));
	  while(!month.getText().contains("April 2020"))
	  {
		  WebElement tre=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
		  Actions act = new Actions(driver);
		  Action seria = act
					 .moveToElement(tre)
					 .click()
					 .build();
			 seria.perform();
	  }
	  Thread.sleep(2000l);
	  List<WebElement> dates = driver.findElements(By.xpath(".//*[@class='DayPicker-Day']//*[@class=\"dateInnerCell\"]//p[1]"));
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
	driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/p/a")).click();
  }
  @Test
  public void d_viewfares_and_book()
  {
	 
	  List<WebElement> ayu=driver.findElements(By.xpath("//*[@class=\"pull-left make_relative\"]//*[@class=\" fli_primary_btn text-uppercase \"]"));
	 WebElement fgh = ayu.get(0);
	  Actions act = new Actions(driver);
	  Action seria = act
				 .moveToElement(fgh)
				 .click()
				 .build();
		 seria.perform();
		 //System.out.println("Book now is pressed");
  }
  
  @Test
  public void e_switch() throws InterruptedException
  {
	  ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(availableWindows.get(1)); 


	  Thread.sleep(1000l);
	List<WebElement> fdg=driver.findElements(By.xpath("//*[@class='block radio']//input[@value='no']"));
	
	Thread.sleep(3000l);
	if(fdg.size()!=0)
	{
	fdg.get(0).click();
	driver.findElement(By.xpath("//*[@class=\"fli_primary_btn btn text-uppercase continue_cta \"]")).click();
	} 
	else
	{
	driver.findElement(By.xpath("//*[@class=\"fli_primary_btn btn text-uppercase continue_cta \"]")).click();  
	} 
	  


	//driver.navigate().refresh();
 // System.out.println("Beffore");
	  
	  
		     WebElement add =driver.findElement(By.xpath("//*[@id=\"wrapper_ADULT\"]/a"));//Add adults
		     
//  System.out.println("ADD ADULT");
		     
		     Thread.sleep(2000L);
		     Actions act = new Actions(driver);
		     Action s2 = act
	 				 .moveToElement(add)
	 				 .click()
	 				 .build();
	 		 s2.perform(); 
		    
		     Thread.sleep(3000L);
		    

	  
	  
	  driver.findElement(By.xpath("//*[@class='tvlrFormField make_relative FIRST_NAME']//*[@type='text']")).sendKeys("Abhi");
	  driver.findElement(By.xpath("//*[@class='tvlrFormField make_relative LAST_NAME']//*[@type='text']")).sendKeys("A S");
	  driver.findElement(By.xpath("//*[@class='chooseGender-info GENDER ']//*[@tabindex='0']")).click();
	  driver.findElement(By.xpath("//*[@class='tvlrFormField make_relative MOBILE_NUMBER']//input[@type='text']")).sendKeys("8129180000");
	  driver.findElement(By.xpath("//*[@class='tvlrFormField make_relative EMAIL']//input[@type='text']")).sendKeys("asabh@gmail.com");
	  driver.findElement(By.xpath("//*[@class='make_relative blocked_traveller_booking']//*[@type='button']")).click();
	WebElement sda=  driver.findElement(By.xpath("//*[@id=\"ancillary-secondary\"]"));
	//  Actions act = new Actions(driver);
	     Action s3 = act
				 .moveToElement(sda)
				 .click()
				 .build();
		 s3.perform(); 
	    
	     Thread.sleep(3000L);
  }
  
  @Test
  public void h_payment()
  {
	  driver.findElement(By.xpath("//*[@id=\"CC\"]/span[2]")).click();
	  driver.findElement(By.xpath("//*[@id=\"PAYMENT_cardNumber\"]")).sendKeys("5228791099000012");
	  driver.findElement(By.xpath("//*[@id=\"PAYMENT_nameOnCard\"]")).sendKeys("Abhi A S");
	  //Dropdown
	  Select s = new Select(driver.findElement(By.xpath("//*[@id=\"PAYMENT_expiryMonth\"]")));
		 s.selectByVisibleText("06");
		 
		 Select sa = new Select(driver.findElement(By.xpath("//*[@id=\"PAYMENT_expiryYear\"]")));
		 sa.selectByVisibleText("2024");
		 
		 driver.findElement(By.xpath("//*[@id=\"PAYMENT_cvv\"]")).sendKeys("455");
	
  }
  @Test
  public void i_address() throws InterruptedException
  {
	  Select s = new Select(driver.findElement(By.xpath("//*[@id=\"PAYMENT_billingCountry\"]")));
		 s.selectByVisibleText("India");
		 Thread.sleep(1500l);
		 driver.findElement(By.xpath("//*[@id=\"PAYMENT_billingAddress\"]")).sendKeys("Abhi at atrenath");
		 driver.findElement(By.xpath("//*[@id=\"PAYMENT_billingCity\"]")).sendKeys("TSR");
	
		 driver.findElement(By.xpath("//*[@id=\"PAYMENT_billingPin\"]")).sendKeys("098765");
		 driver.findElement(By.xpath("//*[@id=\"PAYMENT_billingState\"]")).sendKeys("Kerala");
	
		 driver.findElement(By.xpath("//*[@id=\"widgetPayBtn\"]/span")).click();
  }

  
  @BeforeTest
  public void beforeTest() {

		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver(); 
		  driver.get("https://www.makemytrip.com/");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();

  }

  @AfterTest
  public void afterTest() throws IOException, InterruptedException {
	  TakesScreenshot scrnshot=((TakesScreenshot)driver);
	  File src=scrnshot.getScreenshotAs(OutputType.FILE);
	  File dest = new File("C:\\Users\\837366\\Desktop\\Screenshot" + System.currentTimeMillis() + ".png");
	  FileUtils.copyFile(src,dest);
	  Thread.sleep(5000l);
	  driver.quit();

  }

}

