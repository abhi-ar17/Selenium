package prgrms;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Flipkart_Data_Driven_wait {
	WebDriver driver;

int f=0;
int inst=0;
ReadExcel config;

	int rows=2;
	Object[][] asd= new Object[rows][1];

	@Test(dataProvider = "testdata")

	public void a_Login(String username, String pass, String search, String fsure, String brand, Integer model,Integer size, String address, String credit, Integer month, Integer year, Integer cvv)
			throws InterruptedException, IOException 
	{
		f=0;
	inst++;
	System.out.println(inst);
		WebDriverWait wait=new WebDriverWait(driver,20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		// Login 
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]")));
        driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	Thread.sleep(3000l);
		
		//Searching
		wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		driver.findElement(By.name("q")).sendKeys(search);
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(2000l);
		
		//clicking Fassured
		if (fsure.equals("Yes"))
		{
			driver.findElement(By.xpath("//*[@class='_1p7h2j _2irnD_']")).click();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Selecting brand for the shoes
		int i;
		List<WebElement> abc = driver.findElements(By.xpath("//*[@class='_1GEhLw']"));
		for (i = 0; i < abc.size(); i++)
		{
		
			if (abc.get(i).getText().equalsIgnoreCase(brand)) {
			
				break;
			}
		}

		  Thread.sleep(2000l);
		  WebElement model_Shoe = driver.findElements(By.xpath("//*[@class='_1p7h2j']")).get(i-1);
		  wait.until(ExpectedConditions.elementToBeClickable(model_Shoe));
		  Actions act = new Actions(driver);
		  Action seria = act
					 .moveToElement(model_Shoe)
					 .click()
					 .build();
			 seria.perform();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000l);
		
		//Selecting shoe from the results shown
		
		WebElement au=driver.findElements(By.xpath("//*[@class=\"_3JlYXy\"]")).get(model);

		  au.click();


		//Switching Window
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(availableWindows.get(1));
		
		
		//Selecting size of the product
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(2000l);
		List<WebElement> shoe_Size = driver.findElements(By.xpath("//*[@class='_1TJldG _2I_hq9 _2UBURg']"));
		int j = 0;
		String txt;
		while (j < shoe_Size.size()) 
		{
			txt = size.toString();
			if (txt.equalsIgnoreCase(shoe_Size.get(j).getText()))
			{
				shoe_Size.get(j).click();
				break;
			}
			j++;
		}
		
		//Thread.sleep(2000l);
		//Selecting Address
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='_2LG8B7']")));
		driver.findElement(By.xpath("//*[@class='_2LG8B7']")).click();
		List<WebElement> gh = driver.findElements(By.xpath("//*[@class='_1icAMV']"));
		for (i = 0; i < gh.size(); i++)
		{
			if (gh.get(i).getText().contains(address))
			{
				gh.get(i).click();
			}
		}

		//Continue to payment
		 
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")));
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Q4i61 _7UHT_c']")).click();


		//Selecting Payment method 
		driver.findElements(By.xpath("//*[@class='_6ATDKp']")).get(1).click();
  
		//Entering payment details
		driver.findElement(By.xpath("//input[@class='_16qL6K _366U7Q' and @tabindex='1']")).sendKeys(credit);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select s = new Select(driver.findElement(By.xpath("//select[@class='_1TQIV6 _1E21Zg _8rlsVy']")));
		s.selectByIndex(month-1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String yr = year.toString();
		Select y = new Select(driver.findElement(By.xpath("//select[@class='_1TQIV6 _1E21Zg']")));
		y.selectByVisibleText(yr);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String cv = cvv.toString();
		driver.findElement(By.xpath("//input[@class='_16qL6K _366U7Q' and @tabindex='6']")).sendKeys(cv);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='_2AkmmA wbv91z _7UHT_c']")));
			Thread.sleep(2000l);
		driver.findElement(By.xpath("//button[@class='_2AkmmA wbv91z _7UHT_c']")).click();
		f=1;
	Thread.sleep(2000l);
		

		
}


	@BeforeMethod
	public void beforeTest() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "http://google.com";
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Flipkart");
		driver.manage().window().maximize();
		element.sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
		
	}

	@AfterMethod
	public void afterTest() throws InterruptedException, IOException 
		{
		TakesScreenshot scrnshot = ((TakesScreenshot) driver);
		File src = scrnshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\837366\\Desktop\\Fkart\\Screenshot" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, dest);
		Thread.sleep(2000l);

		if(f==1)
		{
			asd[inst-1][0]="PASSED";
			System.out.println(asd[inst-1][0]);
		}
		else
		{
			asd[inst-1][0]="FAILED";
			System.out.println(asd[inst-1][0]);
		}
	config.close();
		driver.quit();
		}

	@AfterTest
	public void Write() throws IOException
	{

		WriteExcel con = new WriteExcel("C:\\Users\\837366\\Desktop\\rtu_.xlsx");
		System.out.println("After Test"+asd);
		con.writeData(asd,rows);
	}
	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() 
	{
		config = new ReadExcel("C:\\Users\\837366\\Desktop\\rtu_.xlsx");

		 rows = config.getRowCount(0);

		Object[][] credentials = new Object[rows][12];
		for (int instant = 0; instant < rows; instant++) 
		{
			for(int z=0;z<12;z++)
			{

			credentials[instant][z] = config.getData(0,instant, z);

			}	
		}

		return credentials;
	}

}
