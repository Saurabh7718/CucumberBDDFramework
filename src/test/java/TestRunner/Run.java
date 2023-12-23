package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
 
    features = {"C:\\Users\\Lenovo\\eclipse-workspace\\CucumberFramework\\Features\\LoginFeature.feature" ,
    		"C:\\Users\\Lenovo\\eclipse-workspace\\CucumberFramework\\Features\\Customer.feature"
    		}, // Update with the correct path to your feature files
    glue = "StepDefinition", // Update with the correct package name for your step definitions
    dryRun = false,
    monochrome = true,
    tags = "@sanity12",
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

    //plugin = {"pretty", "html:target/cucumber-reports/reports_html.html"}
)
//plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
//		plugin = {"pretty","json:target/cucumber-reports/report_json.json"}

public class Run extends AbstractTestNGCucumberTests {
	/*This class will be empty*/
}