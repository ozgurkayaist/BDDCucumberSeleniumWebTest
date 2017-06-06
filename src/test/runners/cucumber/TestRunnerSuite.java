package test.runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/testScenarios/",
        glue = "test.tests.cucumber" ,
        monochrome = true,
        format = {"pretty", "html:target/cucumber"})

public class TestRunnerSuite extends AbstractTestNGCucumberTests{

}
