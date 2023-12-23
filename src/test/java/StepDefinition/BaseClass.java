package StepDefinition;

//import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import PageObject.LoginPagePO;
import PageObject.NewCustomerAddPO;
import PageObject.searchUserPO;
import utilities.ReadConfig;

import java.util.*
;//parent class


public class BaseClass {
	public static WebDriver driver;
	public LoginPagePO loginpg;
	public NewCustomerAddPO newcustomer;
	public searchUserPO searchCustpg;
	
	public static Logger log ;
	
	//public static Logger log;
	
	public ReadConfig readConfig;
	
	public WebDriverWait wait;
	
	//generate unique alphabets
	
	public String generateEmailId()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}
	
}
