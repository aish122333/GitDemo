package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "Aishwarya.stepDefinitions", tags = "@PurchaseOrder", monochrome = true, plugin = {"html:target/cucumberReport.html"})
public class cucumberTestngRunner extends AbstractTestNGCucumberTests {

}
