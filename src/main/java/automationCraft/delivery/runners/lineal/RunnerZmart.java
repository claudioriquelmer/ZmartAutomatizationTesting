package automationCraft.delivery.runners.lineal;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/main/java/automationCraft/testcreation/features"},
        glue = {"automationCraft.testcreation.steps","automationCraft.engine.bdd"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
            "timeline:test-output-thread"},
        tags = "@demo"
)

public class RunnerZmart extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
