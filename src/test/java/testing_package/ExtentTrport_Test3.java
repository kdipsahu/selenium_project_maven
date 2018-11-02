package testing_package;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTrport_Test3 {


	@Test  
	public void test_report() {


		// new instance
		ExtentReports extent = new ExtentReports("./test_report_3.html");

		/*ExtentTest parent = extent.startTest("Parent");

		ExtentTest child1 = extent.startTest("Child 1");
		child1.log(LogStatus.PASS, "Step 1");

		ExtentTest child2 = extent.startTest("Child 2");
		child2.log(LogStatus.PASS, "Step 2");
		
		ExtentTest child3 = extent.startTest("Child 3");
		child3.log(LogStatus.FAIL, "Step 2.1", child3.addScreenCapture("./Reports/Open_URL.jpg"));

		child2.appendChild(child3);
		
		parent
		    .appendChild(child1)
		    .appendChild(child2);
		    
		extent.endTest(parent);

		// writing everything to document
		extent.flush();*/
		
		ExtentTest rules = extent.startTest("Rules");
		
		ExtentTest rate_matrix = extent.startTest("Rate Matrix");
		rate_matrix.log(LogStatus.INFO, " Rate Matrix Tabs");
		
		ExtentTest rate_matrix_find = extent.startTest("Find");
		rate_matrix_find.log(LogStatus.PASS, "Step 1", "Screen Shot");
		rate_matrix_find.log(LogStatus.PASS, "Step 2", "Screen Shot");
		rate_matrix_find.log(LogStatus.FAIL, "Step 3", "Screen Shot");

		extent.endTest(rate_matrix_find);
		
		ExtentTest rate_matrix_create = extent.startTest("Create");
		rate_matrix_create.log(LogStatus.PASS, "Step 1", "Screen Shot");
		rate_matrix_create.log(LogStatus.PASS, "Step 2", "Screen Shot");
		rate_matrix_create.log(LogStatus.PASS, "Step 3", "Screen Shot");

		extent.endTest(rate_matrix_create);
		
		rate_matrix
				.appendChild(rate_matrix_find)
				.appendChild(rate_matrix_create);
		
		extent.endTest(rate_matrix);

		rules.appendChild(rate_matrix);
		
		extent.endTest(rules);
		
		ExtentTest invoice = extent.startTest("Invoice");
		
		ExtentTest inv_cap = extent.startTest("Invoice Capture");
		inv_cap.log(LogStatus.INFO, " Invoice Caprure Tabs");
		
		ExtentTest inv_cap_find = extent.startTest("Invoice Find");
		inv_cap_find.log(LogStatus.PASS, "Step 1", "Screen Shot");
		inv_cap_find.log(LogStatus.PASS, "Step 2", "Screen Shot");
		inv_cap_find.log(LogStatus.PASS, "Step 3", "Screen Shot");

		extent.endTest(inv_cap_find);
		
		ExtentTest inv_cap_create = extent.startTest("Invoice Create");
		inv_cap_create.log(LogStatus.PASS, "Step 1", "Screen Shot");
		inv_cap_create.log(LogStatus.PASS, "Step 2", "Screen Shot");
		inv_cap_create.log(LogStatus.PASS, "Step 3", "Screen Shot");

		extent.endTest(inv_cap_create);
		
		inv_cap
				.appendChild(inv_cap_find)
				.appendChild(inv_cap_create);
		
		extent.endTest(inv_cap);

		invoice.appendChild(inv_cap);
		
		ExtentTest inv_recon = extent.startTest("Invoice Recon");
		inv_recon.log(LogStatus.INFO, " Invoice Recon Tabs");

		ExtentTest inv_recon_find = extent.startTest("Invoice Recon Summary");
		inv_recon_find.log(LogStatus.PASS, "Step 1", "Screen Shot");
		inv_recon_find.log(LogStatus.PASS, "Step 2", "Screen Shot");
		inv_recon_find.log(LogStatus.PASS, "Step 3", "Screen Shot");

		extent.endTest(inv_recon_find);

		ExtentTest inv_recon_create = extent.startTest("Invoice Recon Tarde");
		inv_recon_create.log(LogStatus.PASS, "Step 1", "Screen Shot");
		inv_recon_create.log(LogStatus.PASS, "Step 2", "Screen Shot");
		inv_recon_create.log(LogStatus.PASS, "Step 3", "Screen Shot");

		extent.endTest(inv_recon_create);

		inv_recon
				.appendChild(inv_recon_find)
				.appendChild(inv_recon_create);

		extent.endTest(inv_recon);

		invoice.appendChild(inv_recon);
		
		extent.endTest(invoice);
				
		extent.flush();
		

	}
}
