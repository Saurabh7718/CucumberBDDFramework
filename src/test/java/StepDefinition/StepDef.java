package StepDefinition;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.FixMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginPagePO;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import PageObject.NewCustomerAddPO;
import PageObject.searchUserPO;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

//child class of baseclass
public class StepDef extends BaseClass {

	// @BeforeMethod
	public void setup1() throws InterruptedException {
		// creating object of properties class
//		readConfig=new Properties();
//		try {
		// to open config.properties file
//			FileInputStream file=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\CucumberFramework\\config.properties");
//			//after opening file loading to readconfig object
		// readConfig.load(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		readConfig = new ReadConfig();
//		String browser = readConfig.getBrowser();
//		switch (browser) {
//
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			BaseClass.driver = new ChromeDriver();
//			break;
//
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			BaseClass.driver = new FirefoxDriver();
//			break;
//
//		case "msedge":
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//			break;
//
//		default:
//
//			driver = null;
//			break;
//
//		}

		// direct intialization of driver
		WebDriverManager.chromedriver().setup();
		BaseClass.driver = new ChromeDriver();

		// intialize logger
		// log = LogManager.getLogger("StepDef.class");

		System.out.println(" Set 1 Method Executed");
		// log.info("setup1 executed....");
	}

	// @BeforeMethod
	//@Before("@sanity1")
	@Before
    public void setup2() {
        // Check if the driver is null, then initialize it
        if (BaseClass.driver == null) {
        	WebDriverManager.chromedriver().clearResolutionCache();
            WebDriverManager.chromedriver().setup();
            BaseClass.driver = new ChromeDriver();
        }
        System.out.println("Setup method executed");
    		// log.info("setup2 executed....");
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginpg = new LoginPagePO(driver);
		newcustomer = new NewCustomerAddPO(driver);
		searchCustpg = new searchUserPO(driver);
		// log.info("chrome launch....");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		BaseClass.driver.get(url);
		// log.info("url opened....");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pass) throws InterruptedException {
		loginpg.enterPassword(email);
		loginpg.enterPassword(pass);

		// log.info("address and password entered....");

	}

	@When("Click on Login")
	public void click_on_login() {
		loginpg.clickOnLoginButton();
		// log.info("login button clicked....");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			// log.warn("Test passed : login feature -page title matched....");
			AssertJUnit.assertTrue(true);
		} else {

			AssertJUnit.assertTrue(false);
			// log.warn("Test Failed : login feature - page title not matched....");
		}

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {

		loginpg.clickOnLogOutButton();
		// log.info("user clicked on logout link....");
	}

//	@Then("close browser")
//	public void close_browser() {
//		driver.close();
//		driver.quit();
//		log.info("browser closed....");
//	}

	////////////////////////////// ADD NEW CUSTOMER /////////////////////

	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {
		// String title=driver.getTitle();

		// Assert.assertEquals(title, "Dashboard / nopCommerce administration");
		String actualTitle = newcustomer.dashboard();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			log.info("test passed : user can voew dashboard....");
			AssertJUnit.assertTrue(true);
		} else {
			log.warn("test failed: user can view dashboard....");
			AssertJUnit.assertTrue(false);
		}
	}

	@When("user clicks on customers Menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		newcustomer.clickCustomersMenu();
		Thread.sleep(1000);
		log.info("customer menu clicked....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		newcustomer.clickCustomers();
		log.info("customer menu item clicked....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		newcustomer.clickAddNew();
		log.info("add new clicked....");
	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = newcustomer.add_new_customer_view();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			log.info("test passed : user can view Add new customer page....");
			AssertJUnit.assertTrue(true); // pass
		} else {
			log.info("test failed: user can view Add new customer page....");
			AssertJUnit.assertTrue(false); // fail
		}

	}

	@When("user enter customer info")
	public void user_enter_customer_info() {

		// newcustomer.enterEmail("admin5@gmail.com");
		newcustomer.enterEmail(generateEmailId() + "@gmail.com");
		newcustomer.enterPassword("admin");
		newcustomer.enterFirstName("sam");
		newcustomer.enterLastName("curran");
		newcustomer.enterComapnyName("xyz");
		newcustomer.selectGenderMale();
		newcustomer.enterDob("6/12/2023");
		log.info("customer information entered....");

	}

	@When("click on save button")
	public void click_on_save_button() {
		newcustomer.clickOnSaveButton();
		log.info("clicked on save button....");
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		String bodyTag = driver.findElement(By.tagName("Body")).getText();
		if (bodyTag.contains(expectedConfirmationMsg)) {
			log.info("test passed: user can view confirmation message ....");
			AssertJUnit.assertTrue(true);
		} else {
			log.info("test failed: user can view confirmation message ....");
			AssertJUnit.assertTrue(false);
		}
	}

	@Then("logout")
	public void logout() {
		// Write code here that turns the phrase above into concrete actions
		loginpg.clickOnLogOutButton();
		log.info("logout ....");

	}

	@AfterMethod
	@After("@DelayBetweenScenarios")
	public void delayBetweenScenarios1(Scenario scenario) throws InterruptedException {
		// Add a delay if the scenario has a specific tag
		if (scenario.getSourceTagNames().contains("@DelayBetweenScenarios")) {
			Thread.sleep(5000); // Sleep for 5 seconds (adjust as needed)
		}
	}

	/////////////////////////////////////////////////////// Search User by email
	/////////////////////////////////////////////////////// /////////////////////////////////

	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustpg.enterEmailAdd("admin5@gmail.com");
		log.info("email address entered....");
	}

	@When("click on search button")
	public void click_on_search_button() {

		searchCustpg.clickOnSearchBtn();
		log.info("clicked on search button....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "admin5@gmail.com";

		// Assert.assertTrue(searchCustpg.searchCustomerByEmail(expectedEmail));

		if (searchCustpg.searchCustomerByEmail(expectedEmail)) {
			AssertJUnit.assertTrue(true);
			log.info("test passed: User should found Email in the search table....");
		} else {

			AssertJUnit.assertTrue(false);
			log.info("test passed: User should found Email in the search table....");

		}
	}

	//////////////////////////////////////////// search user by name
	//////////////////////////////////////////// /////////////////////////////////
	@AfterMethod
	@After("@DelayBetweenScenarios")
	public void delayBetweenScenarios3(Scenario scenario) throws InterruptedException {
		// Add a delay if the scenario has a specific tag
		if (scenario.getSourceTagNames().contains("@DelayBetweenScenarios")) {
			Thread.sleep(5000); // Sleep for 5 seconds (adjust as needed)
		}
	}

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustpg.enterFirstName("sam");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustpg.enterLastName("curran");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "sam curran";
		AssertJUnit.assertTrue(searchCustpg.searchCustomerByName(expectedName));
	}

//for normal report
//	@AfterMethod
//	@After("@sanity1")
//	public void teardown1(Scenario sc) {
//		System.out.println("Tear Down Method 1 Executed");
//		if (sc.isFailed() == true) {
//			String filePath = "C:\\Users\\Lenovo\\eclipse-workspace\\CucumberFramework\\screenshot\\failed_screenshot.png";
//			TakesScreenshot srcShot = ((TakesScreenshot) BaseClass.driver);
//
//			// call getScreenshots method to create image file
//			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
//			File destFile = new File(filePath);
//
//			try {
//				FileUtils.copyFile(srcFile, destFile);
//			} catch (IOException e) { // TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("screenshot is not added");
//			}
//		}
//
//		driver.quit();
//	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
	    if (scenario.isFailed()==true) {
	        final byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", scenario.getName());
	    } else {
	        System.out.println("WebDriver (driver) is null. Cannot take screenshot.");
	    }
	}

//	@After("@regression1")
//	public void teardown2() {
//		System.out.println("Tear Down Method 2 Executed");
//		driver.quit();
//	}

//	@BeforeStep
//	public void beforeStepAnnotation(){
//		System.out.println("This is before step ann...");
//	}
//	
//	@AfterStep
//	public void afterStepAnnotation(){
//		System.out.println("This is after step ann...");
//	}

}
