package prgrms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

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

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;

public class Flipkart {
	WebDriver driver;


	@Test
	public void a_Search() {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Flipkart");
		driver.manage().window().maximize();
		element.sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3")).click();
	}

	@Test
	public void b_Login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000l);
		driver.findElement(By.xpath("//input[@class=\"_2zrpKA _1dBPDZ\"]")).sendKeys("8129187278");
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys("abhi@7295");

		driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]")).click();

	}

	@Test
	public void c_Search_Item() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("Casual shoes");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@class='_1p7h2j _2irnD_']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000l);
		 driver.findElements(By.xpath("//div[@class='_1p7h2j']")).get(1).click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     	Thread.sleep(2000l);
	    driver.findElements(By.xpath("//*[@class='_3dqZjq']")).get(8).click();
		

		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(availableWindows.get(1));
	}

	@Test
	public void d_Size_And_Address()  {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> shoe_Size = driver.findElements(By.xpath("//*[@class='_1TJldG _2I_hq9 _2UBURg']"));
		int i = 0;
		String txt;
		while (i<shoe_Size.size()) {
//			System.out.println(".........................................."+shoe_Size.get(i).getText());
			 txt = shoe_Size.get(i).getText();
			if (txt.equalsIgnoreCase("9") )
					{
//			    System.out.println("////////////////////");
				break;
			}
			if (txt.equalsIgnoreCase("11") )
			{
//	    System.out.println("////////////////////");
		break;
	      }
			i++;
		}
		shoe_Size.get(i).click();
//		Thread.sleep(2500l);
		WebElement gh = driver.findElement(By.xpath("//div[@class='_2LG8B7']"));
		Actions act = new Actions(driver);
		Action asd_ac = act.moveToElement(gh).click().build();
		asd_ac.perform();
//		Thread.sleep(2500l);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement ret = driver.findElement(By.xpath("//div[@class='_3v8QJy _3MXgMR']//div[@class='KQi2jt']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Action asd_act = act.moveToElement(ret).click().build();
		asd_act.perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")).click();

	}


	@Test
	public void e_Payment()  {
		// driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button")).click();
		// Thread.sleep(2500l);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement fg = driver.findElement(By.xpath("//*[@id=\"CNTCT308E32672EF546C3BA3ED9C64\"]/button"));
//		Thread.sleep(2500l);
		Actions act = new Actions(driver);
		Action asd_a = act.moveToElement(fg).click().build();
		asd_a.perform();
//		Thread.sleep(2500l);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"to-payment\"]/button")).click();
//		Thread.sleep(2500l);

		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[4]/div/div/div[1]/div/label[2]/div[1]")).click();
	}


	@Test
	public void f_Card_Details() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='_16qL6K _366U7Q' and @tabindex='1']")).sendKeys("4567839203491278");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select s = new Select(driver.findElement(By.xpath("//select[@class='_1TQIV6 _1E21Zg _8rlsVy']")));
		s.selectByVisibleText("08");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		Select y = new Select(driver.findElement(By.xpath("//select[@class='_1TQIV6 _1E21Zg']")));
		y.selectByVisibleText("32");
//		Thread.sleep(2500l);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='_16qL6K _366U7Q' and @tabindex='6']")).sendKeys("788");
    	Thread.sleep(2000l);
		driver.findElement(By.xpath("//button[@class='_2AkmmA wbv91z _7UHT_c']")).click();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "http://google.com";
		driver.get(baseUrl);
	}

	@AfterTest
	public void afterTest() throws IOException, InterruptedException {

		TakesScreenshot scrnshot = ((TakesScreenshot) driver);
		File src = scrnshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\837366\\Desktop\\Screenshot" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, dest);
		Thread.sleep(5000l);
		// driver.quit();
	}

}