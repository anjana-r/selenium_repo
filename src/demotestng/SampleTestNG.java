package demotestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SampleTestNG {
	public WebDriver driver;

	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Jar_files\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	  }	
	
	  @Test
	  public void searchProduct() throws InterruptedException {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search_query_top']"))).sendKeys("Summer Dress");
		  Thread.sleep(5000);
		  
	  }
  
    
	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

}
