package prgrms;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RedBus_{
	WebDriver driver;


	@Test(dataProvider="testdata")
	public void a_Search(String source,String dest,String sourceStop ,String destStop,String monthAndYear ,String day , String retMonthAndYear,String retday, String boardingPoint_,String droppingPoint_,String retBoardingPoint_,String retDroppingPoint_,String name,String gender,String age,String mail,String phone,String business,String gst,String bName,String bAddress,String bEmail,String insurance,String cardNo,String expiryMonth,String expiryYear,String cvv,String cardHolderName
			) throws InterruptedException {

	
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Redbus");
		driver.manage().window().maximize();
		element.sendKeys(Keys.RETURN);
		driver.findElements(By.className("r")).get(0).click();
		driver.findElement(By.id("src")).sendKeys(source);						//Starting location
		 WebDriverWait wait=new WebDriverWait(driver,40);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='autoFill']//li")));
		List <WebElement> source_ = driver.findElements(By.xpath("//*[@class='autoFill']//li"));

	    for(int i=0;i<source_.size();i++)
	    {
	    	if(source_.get(i).getText().contains(sourceStop))
	    	{
	    		source_.get(i).click();

	    		break;
	    	}
	    }

		driver.findElement(By.id("dest")).sendKeys(dest);	//Destination
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='autoFill']//li")));
		//	System.out.println("........>>>>>>awsfdqfew>>");
		  List <WebElement> dest_ = driver.findElements(By.xpath("//*[@class='autoFill']//li"));

		    for(int i=0;i<dest_.size();i++)
		    {
		    //	System.out.println("kajb"+dest_.get(i).getText());
		    	if(dest_.get(i).getText().contains(destStop))
		    	{
		    		dest_.get(i).click();

		    		break;
		    	}
		    }
		
		//Date Picker onward date
		WebElement month=driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]"));

		while(!month.getText().contains(monthAndYear))
		{
		//	System.out.println("kkkkkkkkkk:"+month.getText());
			driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
			month=driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]"));
		
		}
		List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]//*[@class='we day' or @class='wd day']"));
		for(int i=0;i<dates.size();i++)
		{
	//		System.out.println("date : "+dates.get(i).getText());
			if(dates.get(i).getText().equalsIgnoreCase(day))
			{
				dates.get(i).click();
				break;
			}
		}
		//Date Picker return date
		driver.findElement(By.xpath("//label[@class='db text-trans-uc tal']")).click();
		WebElement retMonth=driver.findElement(By.xpath("//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[1]/td[2]"));

		while(!retMonth.getText().contains(retMonthAndYear))
		{
	//		System.out.println("kkkkkkkkkk:"+retMonth.getText());
			driver.findElement(By.xpath("//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
			retMonth=driver.findElement(By.xpath("//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[1]/td[2]"));
		
		}
		List<WebElement> retDates = driver.findElements(By.xpath("//*[@id=\"rb-calendar_return_cal\"]//*[@class='we day' or @class='wd day']"));
		for(int i=0;i<retDates.size();i++)
		{
	//	System.out.println("date : "+retDates.get(i).getText());
			if(retDates.get(i).getText().equalsIgnoreCase(retday))
			{
				retDates.get(i).click();
				break;
			}
		}
	//Search
		driver.findElement(By.id("search_btn")).click();
		
	//Selecting bus*****************************************************************************************************
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"button view-seats fr\"]")));
		List <WebElement> rate=driver.findElements(By.xpath("//*[@class='f-19 f-bold']"));
		int min=Integer.parseInt(rate.get(0).getText());
		int z = 0;
		for(int i=0;i<rate.size();i++)
		{
			if(Integer.parseInt(rate.get(i).getText())<min)
			{
				min=Integer.parseInt(rate.get(i).getText());
				z=i;
			}
		}
//		System.out.println("::::::::"+rate.get(z).getText());
		Thread.sleep(1500l);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"button view-seats fr\"]")));
		driver.findElements(By.xpath("//*[@class='button view-seats fr']")).get(z).click();
		
		
		//Select seats
		
		

		
		//Boarding Point
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		try
		{
		//	driver.findElement(By.xpath("//*[@class='select-list scrollbar height-bpdp-single-deck']//*[@class='radio-checked']"));
			driver.findElement(By.xpath("//*[@class='button continue inactive text-trans-uc w-h-cont']")).click();
		}
		catch(Exception e)
		{
		//	System.out.println("exception e   ..........");
		List <WebElement> boardingPoint =driver.findElements(By.xpath("//*[@class='loc ']"));
		for(int i=0;i<boardingPoint.size();i++)
		{
	//		System.out.println("ppppppppp"+boardingPoint.get(i).getText());
			if(boardingPoint.get(i).getText().contains(boardingPoint_))
			{
				driver.findElements(By.xpath("//*[@class=\"radio-unchecked\"]")).get(i).click();
				break;
			}
		}
		}
		//Dropping Point
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"radio-unchecked\"]")));
//wait.until(ExpectedConditions.attributeContains(By.xpath("//*[@id=\"10639417\"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/header/div[2]"),"class", "fl w-50 selector tac default-clr selected-bpdp-color"));

	try
		{
//	 driver.findElement(By.xpath("//*[@class='select-list scrollbar height-s-bpdp-s-deck']//*[@class='radio-checked']"));
//		driver.findElement(By.xpath("//*[@class='select-list scrollbar height-s-bpdp-s-deck']//*[@class='radio-checked']")).click();
		driver.findElement(By.xpath("//*[@class='button continue inactive text-trans-uc w-h-cont']")).click();
		}
		catch(Exception e)
		{
		List <WebElement> droppingPoint =driver.findElements(By.xpath("//*[@class='loc ']"));
		for(int i=0;i<droppingPoint.size();i++)
		{

			if(droppingPoint.get(i).getText().contains(droppingPoint_))
			{
				driver.findElements(By.xpath("//*[@class=\"radio-unchecked\"]")).get(i).click();
				break;
			}
			}

		}
		//clicking Proceed to book
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button continue inactive']")));
		driver.findElement(By.xpath("//*[@class='button continue inactive']")).click();
		
		//Booking Return ******************************************************************************************************
		
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"button view-seats fr\"]")));
		List <WebElement> retRate=driver.findElements(By.xpath("//*[@class='f-19 f-bold']"));
		int min_=Integer.parseInt(retRate.get(0).getText());
		int z_ = 0;
		for(int i=0;i<retRate.size();i++)
		{
			if(Integer.parseInt(retRate.get(i).getText())<min_)
			{
				min_=Integer.parseInt(retRate.get(i).getText());
				z_=i;
			}
		}
		Thread.sleep(1500l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"button view-seats fr\"]")));
		driver.findElements(By.xpath("//*[@class='button view-seats fr']")).get(z_).click();
		
		
		//Select seats
		
		

		
		//Boarding Point
//		wait.until(ExpectedConditions.attributeContains(By.xpath("	//*[@id=\"13437625\"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/header/div[1]"),"class", "fl w-50 selector tac default-clr selected-bpdp-color"));
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"radio-unchecked\"]")));
//		System.out.println("::::::::RET BOARDING::::::::::::::::::::::");

	try
	{
		driver.findElement(By.xpath("//*[@class='button continue inactive text-trans-uc w-h-cont']")).click();
//		driver.findElement(By.xpath("//*[@class='select-list scrollbar height-s-bpdp-s-deck']//*[@class='radio-checked']"));
//		driver.findElement(By.xpath("//*[@class='select-list scrollbar height-s-bpdp-s-deck']//*[@class='radio-checked']")).click();
	}
	catch(Exception e)
	{
	List <WebElement> retBoardingPoint =driver.findElements(By.xpath("//*[@class='loc ']"));
	for(int i=0;i<retBoardingPoint.size();i++)
	{
	//	System.out.println("ppppppppp"+retBoardingPoint.get(i).getText());
		if(retBoardingPoint.get(i).getText().contains(retBoardingPoint_))
		{
			driver.findElements(By.xpath("//*[@class=\"radio-unchecked\"]")).get(i).click();
			break;
		}
	}
	}

		//Dropping Point
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"radio-unchecked\"]")));
//	wait.until(ExpectedConditions.attributeContains(By.xpath("//*[@id=\"13939165\"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/header/div[2]"),"class", "fl w-50 selector tac default-clr selected-bpdp-color"));
	//	System.out.println(":::::::::::::::::::::::::RET DROPPPING:::::");
		

			try
			{
				driver.findElement(By.xpath("//*[@class='button continue inactive text-trans-uc w-h-cont']")).click();
//				driver.findElement(By.xpath("//*[@class='select-list scrollbar height-bpdp-single-deck']//*[@class='radio-checked']"));
//				driver.findElement(By.xpath("//*[@class='select-list scrollbar height-bpdp-single-deck']//*[@class='radio-checked']")).click();
			}
			catch(Exception e)
			{
			List <WebElement> retDroppingPoint =driver.findElements(By.xpath("//span[@class='loc ']"));
			for(int i=0;i<retDroppingPoint.size();i++)
			{
	//			System.out.println("ppppppppp"+retDroppingPoint.get(i).getText());
				if(retDroppingPoint.get(i).getText().contains(retDroppingPoint_))
				{
					driver.findElements(By.xpath("//*[@class=\"radio-unchecked\"]")).get(i).click();
					break;
				}
				}

			}
		
		//clicking Proceed to book
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button continue inactive']")));
		driver.findElement(By.xpath("//*[@class='button continue inactive']")).click();
		
		try
		{
			WebElement asd=driver.findElement(By.xpath("//*[@class='details']"));

			if(asd.isEnabled())
			{
	
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/div[2]/div/div/div[2]/div/div/div[3]/a")).click();
			}
		}
		catch(Exception e)
		{
			
		}
		//Entering Details
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='input_box' and @placeholder='Name']")));
		driver.findElement(By.xpath("//*[@class='input_box' and @placeholder='Name']")).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("div_22_0")));
		if(gender.equalsIgnoreCase(gender))
		{
		driver.findElement(By.id("div_22_0")).click();
		}
		else
		{
			driver.findElement(By.id("23_0")).click();
		}
		driver.findElement(By.xpath("//*[@class='input_box' and @placeholder='Age']")).sendKeys(age);
		driver.findElement(By.xpath("//*[@class='input_box' and @placeholder='Email ID']")).sendKeys(mail);
		driver.findElement(By.xpath("//*[@class='input_box' and @placeholder='Phone']")).sendKeys(phone);
		
		if(business.equalsIgnoreCase("Yes"))
		{
			driver.findElement(By.id("RUCFeatureCheckBox")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='input_box' and @placeholder='GSTIN']")));
			driver.findElement(By.xpath("//*[@class='input_box' and @placeholder='GSTIN']")).sendKeys(gst);
			driver.findElement(By.xpath("//*[@class='input_box' and @placeholder='Business Name']")).sendKeys(bName);
			driver.findElement(By.xpath("//*[@class='input_box' and @placeholder='Business Address']")).sendKeys(bAddress);
			driver.findElement(By.xpath("//*[@class='input_box' and @placeholder='Business Email']")).sendKeys(bEmail);
		}
		if(insurance.equalsIgnoreCase("Secure"))
		{
			driver.findElements(By.className("checkmark-radio")).get(0).click();
		}
		else
		{
			driver.findElements(By.className("checkmark-radio")).get(1).click();
		}
		
//		Proceed to pay
		
		driver.findElement(By.xpath("//*[@class='button-container fr']")).click();
		
		//Payment Details
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DCARDNO")));
		driver.findElement(By.id("DCARDNO")).sendKeys(cardNo);
		Select s = new Select(driver.findElement(By.id("DebitCardEXPMONTH")));
		s.selectByVisibleText(expiryMonth);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Select y = new Select(driver.findElement(By.id("DebitCardEXPYEAR")));
		y.selectByVisibleText(expiryYear);
		driver.findElement(By.id("DCVV")).sendKeys(cvv);
		driver.findElement(By.id("DCARD_HOLDER_NAME")).sendKeys(cardHolderName);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("makepayment")));
		driver.findElement(By.id("makepayment")).click();
	}

	@BeforeMethod
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(options);
		String baseUrl = "http://google.com";
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterTest() throws IOException, InterruptedException {

		TakesScreenshot scrnshot = ((TakesScreenshot) driver);
		File src = scrnshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\837366\\Desktop\\Screenshot" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, dest);
		Thread.sleep(5000l);
		driver.quit();
	}
	
	
	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() 
	{
		ReadExcel config = new ReadExcel("C:\\Users\\837366\\Desktop\\excel.xlsx");

		int rows = config.getRowCount(0);
		int col=28;
		Object[][] credentials = new Object[rows][col];
		for (int instant = 0; instant < rows; instant++) 
		{
			for(int z=0;z<col;z++)
			{

			credentials[instant][z] = config.getData(0, instant, z);

			}	
		}

		return credentials;
	}


}