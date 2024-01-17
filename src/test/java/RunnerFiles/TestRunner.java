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
                     tags = "@Guaranteed_Maintenance_Plan"
                 )
public class TestRunner {

}
