package test_Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = "step_Definition",
        tags="@ninzaout",
        plugin = {"pretty", "html:target/report2.html"},
        monochrome = true
)
public class TestRunnerOutline extends AbstractTestNGCucumberTests {
	
}
