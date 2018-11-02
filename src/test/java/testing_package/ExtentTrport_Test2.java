package testing_package;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTrport_Test2 {


	@Test  
	public void test_report() {


		// new instance
		ExtentReports extent = new ExtentReports("./test_report_2.html");

		// starting test
		ExtentTest test;
		
		test = extent.startTest("Main Module One ", "Module description");
		
		//Assign Category
		test.assignCategory("Regression", "ExtentAPI");
		
		// Author
		test.assignAuthor("Kuladip");
		
		// step log
		test.log(LogStatus.PASS, "Step details", "Test 1");
		// step log
		test.log(LogStatus.FAIL, "Step details", "Test 1");
		// step log
		test.log(LogStatus.PASS, "Step details", "Test 1");
		
		extent.endTest(test);
		
		test = extent.startTest("Main Module Two ", "Module description");
		
		//Assign Category
		test.assignCategory("Regression", "ExtentAPI");
		
		// Author
		test.assignAuthor("Kuladip");
		
		// step log
		test.log(LogStatus.PASS, "Step details", "Test 1");
		// step log
		test.log(LogStatus.PASS, "Step details", "Test 1");
		// step log
		test.log(LogStatus.PASS, "Step details", test.addScreenCapture("./Reports/Open_URL.jpg"));

		// ending test
		extent.endTest(test);

		// writing everything to document
		extent.flush();

	}
}
