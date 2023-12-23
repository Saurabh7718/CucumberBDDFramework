package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.python.antlr.PythonParser.return_stmt_return;

public class NewCustomerAddPO {
    WebDriver ldriver;

    public NewCustomerAddPO(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    WebElement lnkCustomersMenu;

    @FindBy(xpath = "//a[@href=\"/Admin/Customer/List\"]")
    WebElement customers;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement addNew;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    WebElement genderMale;

    @FindBy(xpath = "//input[@id='Gender_Female']")
    WebElement genderFemale;
    
    @FindBy (xpath="//input[@id='Company']")
    WebElement companyName;
    
    @FindBy(xpath="//input[@aria-expanded='true']")
    WebElement customerRoles;
    
    @FindBy(xpath="//button[@name='save']")
    WebElement save;
    
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
    WebElement successAlert;
    
    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement logoutbtn;
    
    @FindBy(xpath="//h1[normalize-space()='Dashboard']")
    WebElement dashboardtitle1;
    
    @FindBy(xpath="//h1[@class='float-left']")
    WebElement Add_a_new_customer_view;
    
    @FindBy(xpath="//input[@id='DateOfBirth']")
    WebElement Add_new_dob;
    // Methods to interact with the elements
    
    public String dashboard() {
    	 
    	return ldriver.getTitle();
    }
    public void clickCustomersMenu() {
        lnkCustomersMenu.click();
    }

    public void clickCustomers() {
        customers.click();
    }

    public void clickAddNew() {
        addNew.click();
    }
    
    public String add_new_customer_view() {
    	return ldriver.getTitle();
    }
    public void enterEmail(String userEmail) {
        email.sendKeys(userEmail);
    }

    public void enterPassword(String userPassword) {
        password.sendKeys(userPassword);
    }

    public void enterFirstName(String userFirstName) {
        firstName.sendKeys(userFirstName);
    }

    public void enterLastName(String userLastName) {
        lastName.sendKeys(userLastName);
    }

    public void selectGenderMale() {
        genderMale.click();
    }

    public void selectGenderFemale() {
        genderFemale.click();
    }
    
    public void enterComapnyName(String company) {
    	companyName.sendKeys(company);
    }
    
    public void selectCustomerRoles(String role) {
    	Select drp=new Select(customerRoles);
    	drp.selectByVisibleText("Guests");
    }
    public void enterDob(String dob) {
    	Add_new_dob.sendKeys(dob);
    }
    
    public void clickOnSaveButton() {
    	save.click();
    }
    public String viewAlertSuccess() {
    	
    	return successAlert.getText();
    	 
    }
    public void logout() {
    	logoutbtn.click();
    }
}
  