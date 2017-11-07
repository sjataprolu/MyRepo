package Setup;

/**
 * Created by srinivas on 29/09/2017.
 * This is the runner class
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",glue = {"StepDefinition"},tags = {"@Runthistest"},
        format = {"html:target/cucumber-pretty"})
public class RunTest {
}
