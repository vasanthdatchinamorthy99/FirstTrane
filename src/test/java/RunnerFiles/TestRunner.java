package RunnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features = "src/test/resources/Features", 
                     glue = { "com.tavant.base", "com.project.base","com.project.CommonModules", "com.project.CustomModules" },
                   plugin = { "pretty","html:target/HtmlReports/report.html", "com.tavant.listeners.CustomListener:" },
                  publish = false,
                  monochrome = true,
                     tags = "@TS_CMSetup_021"
                 )
public class TestRunner {

}