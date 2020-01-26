package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( glue="cukes",
	features="src/test/java/features", tags={"@test"})
public class RunCukesTest {
	

}
