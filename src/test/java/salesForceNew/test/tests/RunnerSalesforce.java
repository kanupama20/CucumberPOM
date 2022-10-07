package salesForceNew.test.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import salesForceNew.test.steps.SalesforceTestDefination;


@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-reports/cucumber.html",
		"json:target/cucumber-reports/cucumber.json"},
		features={"src/test/resources/BasicFeature.feature"},
		glue={"salesForceNew.test.steps"},
		monochrome = true
		)

public class RunnerSalesforce extends AbstractTestNGCucumberTests{

}
