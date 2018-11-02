package testing_package;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTrport_Test {


	@Test  
	public void test_report() {


		// new instance
		ExtentReports extent = new ExtentReports("./test_report.html");

		// starting test
		ExtentTest test = extent.startTest("Test Name", "Sample description");

		// step log
		test.log(LogStatus.PASS, "Step details", "Test 1");
		// step log
		test.log(LogStatus.FAIL, "Step details", "Test 1");
		// step log
		test.log(LogStatus.PASS, "Step details", "Test 1");

		// ending test
		extent.endTest(test);

		// writing everything to document
		extent.flush();

	}
}
