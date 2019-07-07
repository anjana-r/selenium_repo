package account.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import dataprovider.ConfigFileReader;


public class CreateAccount {
	public WebDriver driver = null;
	public ConfigFileReader reader =null;
	
	//String driverPath = "F:\\Selenium_Jar_files\\drivers\\chromedriver_win32\\chromedriver.exe";
	String driverPath = "F:\\Anjana\\Selenium_Jar_files\\drivers\\chromedriver_win32\\chromedriver.exe";
	String appURL = "http://automationpractice.com/index.php";
	//String workingDir = "F:\\Selenium_Workspace\\SampleProject\\bin";
	String workingDir = "F:\\Anjana\\Sel_workspace\\selenium_repo\\bin";
	
		
	

	
	@BeforeClass
	public void setUp() throws Exception{	
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(appURL);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void signUp(){
		reader = new ConfigFileReader(workingDir+"\\Configs\\Object_Repo.properties");
		checkValidEmail();
		try {
			addNewUser();
		} catch (Exception e) {
			System.out.println();
			Reporter.log("error in addNewUser function");
			
		}
				
	}	
		
	
	public void checkValidEmail() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("a_headerSignIn")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("input_createEmail")))).sendKeys(reader.getData("email"));
		driver.findElement(By.xpath(reader.getData("btn_registerUser"))).click();
	}
	
	
	public void addNewUser() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("div_Gender")))).click();
		driver.findElement(By.xpath(reader.getData("input_firstName"))).sendKeys(reader.getData("firstName"));
		driver.findElement(By.xpath(reader.getData("input_lastName"))).sendKeys(reader.getData("lastName"));
		driver.findElement(By.xpath(reader.getData("input_password"))).sendKeys(reader.getData("password"));
		driver.findElement(By.xpath(reader.getData("dd_day"))).click();
		driver.findElement(By.xpath(reader.getData("dd_month"))).click();
		driver.findElement(By.xpath(reader.getData("dd_year"))).click();
		driver.findElement(By.xpath(reader.getData("checkbx_receiveOffers"))).click();	
		driver.findElement(By.xpath(reader.getData("input_addressFname"))).sendKeys(reader.getData("firstName"));
		driver.findElement(By.xpath(reader.getData("input_addressLname"))).sendKeys(reader.getData("lastName"));
		driver.findElement(By.xpath(reader.getData("input_addressCompany"))).sendKeys(reader.getData("company"));
		driver.findElement(By.xpath(reader.getData("input_address1"))).sendKeys(reader.getData("address1"));
		driver.findElement(By.xpath(reader.getData("input_address2"))).sendKeys(reader.getData("address2"));
		driver.findElement(By.xpath(reader.getData("input_city"))).sendKeys(reader.getData("city"));
		driver.findElement(By.xpath(reader.getData("dd_state"))).click();
		driver.findElement(By.xpath(reader.getData("input_postalCode"))).sendKeys(reader.getData("postalCode"));
		driver.findElement(By.xpath(reader.getData("dd_country"))).click();
		driver.findElement(By.xpath(reader.getData("input_mobile"))).sendKeys(reader.getData("mobile"));
		driver.findElement(By.xpath(reader.getData("input_aliasAddress"))).sendKeys(reader.getData("aliasAddress"));
		driver.findElement(By.xpath(reader.getData("btn_submitAccount"))).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("header_welcomeText"))));
		WebElement text = driver.findElement(By.xpath(reader.getData("header_welcomeText")));
		Assert.assertEquals(true, text.isDisplayed());		
	}
	
	
	@Test(priority=2)
	public void signOut(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("a_signOut")))).click();
	}
	
		
	@Test(priority=3)
	public void login(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.getData("input_registeredEmail")))).sendKeys(reader.getData("email"));
		driver.findElement(By.xpath(reader.getData("input_registeredPwd"))).sendKeys(reader.getData("password"));
		driver.findElement(By.xpath(reader.getData("btn_submitLogin"))).click();
		WebElement text = driver.findElement(By.xpath(reader.getData("header_welcomeText")));
		Assert.assertEquals(true, text.isDisplayed());		
	}
	
	@AfterClass
	public void afterTest(){
		driver.close();
		
	}

}
