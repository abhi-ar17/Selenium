package intermediate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class right_click {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 driver.get("http://medialize.github.io/jQuery-contextMenu/demo.html");
		 WebElement e = driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/p/span"));
		 Actions act = new Actions(driver);
		 act.contextClick(e).perform();
		 

	}

}
