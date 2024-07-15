package Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/features/login.feature"}, 
		glue= {"StepDefinitions"},
		plugin = { "pretty", "html:target/test.html" },
		monochrome = true
		)
public class Runner {
 
}

