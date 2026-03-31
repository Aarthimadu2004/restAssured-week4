package test_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = "step_Definition",
        tags="@ninza",
        plugin = {"pretty", "html:target/ninza-report.html"},
        monochrome = true
)
public class TestRunnerNinza extends AbstractTestNGCucumberTests {
	
}

