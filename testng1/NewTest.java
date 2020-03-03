package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("Executing Test 1");
  }             
  @Test
  public void g() {
	  System.out.println("Executing Test 2");
  }
  @Test
  public void k() {
	  System.out.println("Executing Test3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This block executes before each test");
}

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This block executes after each test");
	 
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This block executes before all testcases");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This block executes after all testcases");
  }

}

