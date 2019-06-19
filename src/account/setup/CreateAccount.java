package account.setup;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import dataprovider.ConfigFileReader;


public class CreateAccount {
	public WebDriver driver = null;
	public ConfigFileReader reader =null;

	
	@BeforeClass
	public void setUp() throws Exception{				
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Jar_files\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();		
	}
	
	@Test
	public void signUp() throws Exception{
		reader = new ConfigFileReader("F:\\Selenium_Workspace\\SampleProject\\bin\\Configs\\Object_Repo.properties");		
		checkValidEmail();
		addNewUserDetails();
		Thread.sleep(5000);
		 
		
	}
	
	@Test
	public void checkValidEmail() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("a_headerSignIn")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("input_createEmail")))).sendKeys("anjana.2588@yahoo.in");
		driver.findElement(By.xpath(reader.getData("btn_registerUser"))).click();
	}
	
	@Test
	public void addNewUserDetails(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("input_Gender")))).click();
		driver.findElement(By.xpath(reader.getData("input_firstName"))).sendKeys("Test");
		driver.findElement(By.xpath(reader.getData("input_lastName"))).sendKeys("User1");
		driver.findElement(By.xpath(reader.getData("input_password"))).sendKeys("automation");
		driver.findElement(By.xpath(reader.getData("dd_day"))).click();
		driver.findElement(By.xpath(reader.getData("dd_month"))).click();
		driver.findElement(By.xpath(reader.getData("dd_year"))).click();
		
		
	/*	driver.findElement(By.xpath(reader.getData(""))).sendKeys("automation");
		
		driver.findElement(By.xpath(reader.getData(""))).sendKeys("automation");
		driver.findElement(By.xpath(reader.getData(""))).sendKeys("automation");
		driver.findElement(By.xpath(reader.getData(""))).sendKeys("automation");
		driver.findElement(By.xpath(reader.getData(""))).sendKeys("automation");
		driver.findElement(By.xpath(reader.getData(""))).sendKeys("automation");*/
		
	}
	
	@AfterClass
	public void afterTest(){
		driver.close();
		
	}

}
