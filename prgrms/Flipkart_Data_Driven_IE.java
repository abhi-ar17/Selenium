package prgrms;

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

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Flipkart_Data_Driven_IE {
	WebDriver driver;

	@Test(dataProvider = "testdata")
	public void a_Login(String username, String pass, String search, String fsure, String brand, Integer model,Integer size, String address, String credit, Integer month, Integer year, Integer cvv)
			throws InterruptedException {
		System.out.println(username);
		System.out.println(size);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000l);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys(pass);

		driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000l);
		driver.findElement(By.name("q")).sendKeys(search);
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (fsure.equals("Yes")) {
			driver.findElement(By.xpath("//*[@class='_1p7h2j _2irnD_']")).click();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int i;
		List<WebElement> abc = driver.findElements(By.xpath("//*[@class='_1GEhLw']"));
		for (i = 0; i < abc.size(); i++) {

			System.out.println("lll" + abc.get(i).getText() + "..............." + brand);
			if (abc.get(i).getText().equalsIgnoreCase(brand)) {
				break;
			}
		}
		System.out.println("......///..." + i);
		List<WebElement> model_Shoe = driver.findElements(By.xpath("//*[@class='_1p7h2j']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000l);
		model_Shoe.get(i - 1).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000l);
		driver.findElements(By.xpath("//*[@class='_3dqZjq']")).get(model).click();

		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(availableWindows.get(1));
		Thread.sleep(2000l);
		List<WebElement> shoe_Size = driver.findElements(By.xpath("//*[@class='_1TJldG _2I_hq9 _2UBURg']"));
		int j = 0;
		String txt;
		while (j < shoe_Size.size()) {
//			System.out.println(".........................................."+shoe_Size.get(i).getText());
			txt = size.toString();

			if (txt.equalsIgnoreCase(shoe_Size.get(j).getText())) {

				shoe_Size.get(j).click();
				break;
			}
			j++;
		}

//		Thread.sleep(2500l);
		driver.findElement(By.xpath("//*[@class='_2LG8B7']")).click();
		List<WebElement> gh = driver.findElements(By.xpath("//*[@class='_1icAMV']"));
		for (i = 0; i < gh.size(); i++) {
			if (gh.get(i).getText().contains(address)) {
				gh.get(i).click();
			}
		}
//		Thread.sleep(2500l);
		/*
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); WebElement
		 * ret = driver.findElement(By.
		 * xpath("//div[@class='_3v8QJy _3MXgMR']//div[@class='KQi2jt']"));
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); Actions act=
		 * new Actions(driver); Action asd_act =act.moveToElement(ret).click().build();
		 * asd_act.perform();
		 */
		Thread.sleep(2500l);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")).click();
		Thread.sleep(2500l);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Q4i61 _7UHT_c']")).click();
		Thread.sleep(2500l);

		// driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button")).click();
		// Thread.sleep(2500l);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * WebElement fg = driver.findElement(By.xpath(
		 * "//*[@id=\"CNTCT308E32672EF546C3BA3ED9C64\"]/button")); //
		 * Thread.sleep(2500l); Actions act= new Actions(driver); Action asd_a =
		 * act.moveToElement(fg).click().build(); asd_a.perform(); //
		 * Thread.sleep(2500l); driver.manage().timeouts().implicitlyWait(30,
		 * TimeUnit.SECONDS);
		 * driver.findElement(By.xpath("//*[@id=\"to-payment\"]/button")).click(); //
		 * Thread.sleep(2500l);
		 */
		driver.findElements(By.xpath("//*[@class='_6ATDKp']")).get(1).click();
  
		driver.findElement(By.xpath("//input[@class='_16qL6K _366U7Q' and @tabindex='1']")).sendKeys(credit);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select s = new Select(driver.findElement(By.xpath("//select[@class='_1TQIV6 _1E21Zg _8rlsVy']")));
		s.selectByIndex(month-1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String yr = year.toString();
		Select y = new Select(driver.findElement(By.xpath("//select[@class='_1TQIV6 _1E21Zg']")));
		y.selectByVisibleText(yr);
//		Thread.sleep(2500l);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String cv = cvv.toString();
		driver.findElement(By.xpath("//input[@class='_16qL6K _366U7Q' and @tabindex='6']")).sendKeys(cv);
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//button[@class='_2AkmmA wbv91z _7UHT_c']")).click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	@BeforeTest
	public void beforeTest() {
		 System.setProperty("webdriver.ie.driver","C:\\New folder\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		 driver=new InternetExplorerDriver(); 
		String baseUrl = "http://google.com";
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Flipkart");
		driver.manage().window().maximize();
		element.sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3")).click();
	}

	@AfterTest
	public void afterTest() throws InterruptedException, IOException {
		TakesScreenshot scrnshot = ((TakesScreenshot) driver);
		File src = scrnshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\837366\\Desktop\\Screenshot" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, dest);
		Thread.sleep(5000l);
	}

	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() {
		ReadExcel config = new ReadExcel("C:\\Users\\837366\\Desktop\\Flipkart.xlsx");

		int rows = config.getRowCount(0);

		Object[][] credentials = new Object[rows][12];
		for (int instant = 0; instant < rows; instant++) {

			credentials[instant][0] = config.getData(0, instant, 0);
			credentials[instant][1] = config.getData(0, instant, 1);
			credentials[instant][2] = config.getData(0, instant, 2);
			credentials[instant][3] = config.getData(0, instant, 3);
			credentials[instant][4] = config.getData(0, instant, 4);
			credentials[instant][5] = config.getData(0, instant, 5);
			credentials[instant][6] = config.getData(0, instant, 6);
			credentials[instant][7] = config.getData(0, instant, 7);

			  credentials[instant][8] = config.getData(0, instant, 8);
			  credentials[instant][9] = config.getData(0, instant, 9);
			 credentials[instant][10] = config.getData(0, instant, 10);
			 credentials[instant][11] = config.getData(0, instant, 11);
			
		}

		return credentials;
	}

}