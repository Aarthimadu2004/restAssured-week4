package test_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = "step_Definition",
        tags="@github",
        plugin = {"pretty", "html:target/fake-report.html"},
        monochrome = true
)
public class TestRunnerGit extends AbstractTestNGCucumberTests {
	
}

