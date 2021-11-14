package TestRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features",
        glue = {"Steps", "Hooks"},
        monochrome = true,
        plugin = {"pretty", "html:target/htmlReports/testResult.html",
                "json:target/jsonReports/testResult.json",
                "junit:target/xmlReports/testResults.xml"},
        tags = "@loginsmoke or @productsmoke or @basketsmoke"
)
public class TestRunner {

}