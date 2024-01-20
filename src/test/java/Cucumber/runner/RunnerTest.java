package Cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        plugin={"html:target/cucumber/cucumber.html"},
        tags = "@SecondScenario or @cart",
        glue = {"Cucumber.stepdef", "Cucumber.hooks", "Cucumber.customtype"},
        features = "src/test/resources/Cucumber"

)
public class RunnerTest extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
