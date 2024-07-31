package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		 //features= {".//Features/"},
		// Alternatively, specify individual features

		 //features = { ".//Features/OpencartLogin.feature" },
		//features = { ".//Features/Registration.feature" },

		// features = ".//Features/LoginDDTExcel.feature",
		 features = {".//Features/OpencartLogin.feature", ".//Features/Registration.feature"},
		// features = {"@target/rerun.txt"},

		glue = { "stepdefinitions", "hooks" },
		plugin = { 
				"pretty", "html:reports/myreports.html",
				"rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },

		dryRun = false, // checks mapping btw scenario steps and stepdifiniton methods
		monochrome = true, // to avoid junk character in output
		publish = true // to publish report in cucumber server
		// tags="@sanity" //this will execute scenarios tagged with @sanity
		// tags = "@regression"
		// tags = "@sanity and @regression" // Scenarios tagged with both @sanity and
		// @regression
		// tags = "@sanity and not @regression" // Scenarios tagged with @sanity but not
		// tagged with @regression
		// tags = "@sanity or @regression" // Scenarios tagged with either @sanity or
		// @regression

)
public class TestRunner {

}
