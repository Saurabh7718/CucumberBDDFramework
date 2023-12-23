package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePO {
	WebDriver ldriver;
	public LoginPagePO(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath= "//input[@id='Email']")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy (xpath="//button[normalize-space()='Log in']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logoutBtn;
	
	public void enterEmail(String emailAddress) 
	{
		email.clear();
		email.sendKeys(emailAddress);
		
	}
	
	public void enterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
		
	}
	
	public void clickOnLoginButton()
	{
		loginbtn.click();
	}
	
	public void clickOnLogOutButton() {
		
		logoutBtn.click();
	}
	
}
