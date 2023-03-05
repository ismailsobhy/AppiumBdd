package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import com.cucumber.listener.Reporter;
@CucumberOptions(
        features = "src/main/java/Features/testcases.feature",
        glue = {"stepdefinitions"},
        plugin = { "pretty","html:target/cucumber-reports.html" })
       
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	
   
}