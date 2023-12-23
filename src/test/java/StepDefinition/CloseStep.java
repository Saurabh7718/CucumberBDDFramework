package StepDefinition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;

import PageObject.LoginPagePO;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CloseStep extends BaseClass {
//	@When("User click on Log out link")
//	public void user_click_on_log_out_link() throws InterruptedException {
//		System.out.println("closeStep - logoutlink");
//		 // Initialize loginpg before using it
//        loginpg = new LoginPagePO(driver);
//        Thread.sleep(1000);
//		loginpg.clickOnLogOutButton();
//	//	log.info("user clicked on logout link....");
//	}
	@Then("close browser")
	public void close_browser() {
		//log = LogManager.getLogger("CloseStep");
		System.out.println("CloseStep - close browser");
		BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		BaseClass.driver.close();
		BaseClass.driver.quit();
		//log.info("browser closed....");
	}

}
