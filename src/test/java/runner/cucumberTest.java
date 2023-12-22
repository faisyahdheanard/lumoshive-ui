package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",
        glue = {"steps"}
)

public class cucumberTest{
}