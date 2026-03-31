package test_Runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/feature",
                  glue="step_Definition",
                  tags="@petstore",
                  plugin = {"pretty", "html:target/report.html"},
                  monochrome = true)

public class TestRunnerPet extends AbstractTestNGCucumberTests {

}
