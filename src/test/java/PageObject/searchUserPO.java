package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchUserPO {
	WebDriver ldriver;

    public searchUserPO(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    
    @FindBy(xpath = "//input[@id='SearchEmail']")
    WebElement emailAdd;
    
    @FindBy(xpath="//button[@id='search-customers']")
    WebElement searchBtn;
    
    @FindBy(xpath="//div[@class='dataTables_scrollHeadInner']//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
    WebElement searchResults;
    
    @FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;
    
    @FindBy(xpath="//table[@id='customers-grid']//tbody/tr[2]/td")
    List<WebElement> tableColumns;
    
    
    @FindBy(xpath=" //input[@id='SearchFirstName']")
    WebElement FirstName;
    
    @FindBy(xpath=" //input[@id='SearchLastName']")
    WebElement LastName;
    
    
    public void enterEmailAdd(String email) {
    	emailAdd.sendKeys(email);    
    }
    
    public void clickOnSearchBtn() {
    	searchBtn.click();
    }
    
    public boolean searchCustomerByEmail(String email) {
    	boolean found=false;
    	
    	//total no.of rows in a grid
    	int ttRows=tableRows.size();
    	
    	//total no of columns
    	int ttColumns=tableColumns.size();
    	
    	
    	for (int i=1;i<=ttRows;i++) {
    		WebElement webElementEmail=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr['+ i  +']/td[2]"));
    		String actualemailAdd=webElementEmail.getText();
    		
    		if(actualemailAdd.equals(email)) {
    			found =true;
    			break;  
    		}
    		else {
    			found=false;
    		}
    		
    	}
    	return found;
    	
    }
    
    
    
    public void enterFirstName(String FName) {
    	FirstName.sendKeys(FName);
    	
    }
    public void enterLastName(String LName) {
    	LastName.sendKeys(LName);
    	
    }
    public boolean searchCustomerByName(String Name) {
    	boolean found=false;
    	
    	//total no.of rows in a grid
    	int ttRows=tableRows.size();
    	
    	//total no of columns
    	int ttColumns=tableColumns.size();
    	
    	
    	for (int i=1;i<=ttRows;i++) {
    		WebElement webElementName=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr['+ i  +']/td[3]"));
    		String actualName=webElementName.getText();
    		
    		if(actualName.equals(Name)) {
    			found =true;
    		}
    		else {
    			found=false;
    		}
    		
    	}
    	return found;
    	
    }
    
    
    

}
