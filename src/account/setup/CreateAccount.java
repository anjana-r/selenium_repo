package account.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import dataprovider.ConfigFileReader;


public class CreateAccount {
	public WebDriver driver = null;
	public ConfigFileReader reader =null;
	String driverPath = "F:\\Selenium_Jar_files\\drivers\\chromedriver_win32\\chromedriver.exe";
	String appURL = "http://automationpractice.com/index.php";
	String workingDir = "F:\\Selenium_Workspace\\SampleProject\\bin";

	
	@BeforeClass
	public void setUp() throws Exception{	
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(appURL);
		driver.manage().window().maximize();		
	}
	
	@Test
	public void signUp() throws Exception{
		reader = new ConfigFileReader(workingDir+"\\Configs\\Object_Repo.properties");			
		checkValidEmail();
		addNewUserDetails();
		Thread.sleep(5000);
		 
		
	}
	
	@Test
	public void checkValidEmail() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("a_headerSignIn")))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("input_createEmail")))).sendKeys("anjana.2588@yahoo.in");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("input_createEmail")))).sendKeys("demo.userC@yahoo.in");
		driver.findElement(By.xpath(reader.getData("btn_registerUser"))).click();
	}
	
	@Test
	public void addNewUserDetails() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("input_Gender")))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(reader.getData("input_firstName"))).sendKeys("Test");
		driver.findElement(By.xpath(reader.getData("input_lastName"))).sendKeys("User");
		driver.findElement(By.xpath(reader.getData("input_password"))).sendKeys("automation");
		driver.findElement(By.xpath(reader.getData("dd_day"))).click();
		driver.findElement(By.xpath(reader.getData("dd_month"))).click();
		driver.findElement(By.xpath(reader.getData("dd_year"))).click();
		driver.findElement(By.xpath(reader.getData("checkbx_receiveOffers"))).click();	
		driver.findElement(By.xpath(reader.getData("input_addressFname"))).sendKeys("Test");
		driver.findElement(By.xpath(reader.getData("input_addressLname"))).sendKeys("User");
		driver.findElement(By.xpath(reader.getData("input_addressCompany"))).sendKeys("Chirag LLC");
		driver.findElement(By.xpath(reader.getData("input_address1"))).sendKeys("San Mateo");
		driver.findElement(By.xpath(reader.getData("input_address2"))).sendKeys("North Carolina");
		driver.findElement(By.xpath(reader.getData("input_city"))).sendKeys("Los Angeles");
		driver.findElement(By.xpath(reader.getData("dd_state"))).click();
		driver.findElement(By.xpath(reader.getData("input_postalCode"))).sendKeys("78701");
		driver.findElement(By.xpath(reader.getData("dd_country"))).click();
		driver.findElement(By.xpath(reader.getData("input_mobile"))).sendKeys("9874563212");
		driver.findElement(By.xpath(reader.getData("input_address2"))).sendKeys("US");
		Thread.sleep(10000);
		
		//driver.findElement(By.xpath(reader.getData("btn_submitAccount"))).click();		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("header_welcomeText"))));
		//WebElement text = driver.findElement(By.xpath(reader.getData("header_welcomeText")));
		//Assert.assertEquals(true, text.isDisplayed());
		
	}
	
	@AfterClass
	public void afterTest(){
		driver.close();
		
	}

}
