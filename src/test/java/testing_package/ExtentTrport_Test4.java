package testing_package;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTrport_Test4 {


	@Test  
	public void test_report() {


		// new instance
		ExtentReports extent = new ExtentReports("./test_report_4.html");
		
		ExtentTest rules = extent.startTest("Rules");
			
		ExtentTest rate_matrix_find = extent.startTest("Rate Matrix Calc Find");
		rate_matrix_find.log(LogStatus.PASS, "Step 1", "Screen Shot");
		rate_matrix_find.log(LogStatus.PASS, "Step 2", "Screen Shot");
		rate_matrix_find.log(LogStatus.FAIL, "Step 3", "Screen Shot");

		extent.endTest(rate_matrix_find);
		
		ExtentTest rate_matrix_create = extent.startTest("Rate Matrix Calc Create");
		rate_matrix_create.log(LogStatus.PASS, "Step 1", "Screen Shot");
		rate_matrix_create.log(LogStatus.PASS, "Step 2", "Screen Shot");
		rate_matrix_create.log(LogStatus.PASS, "Step 3", "Screen Shot");

		extent.endTest(rate_matrix_create);
		
		ExtentTest charge_rule_find = extent.startTest("Charge Rule Find");
		charge_rule_find.log(LogStatus.PASS, "Step 1", "Screen Shot");
		charge_rule_find.log(LogStatus.PASS, "Step 2", "Screen Shot");
		charge_rule_find.log(LogStatus.PASS, "Step 3", "Screen Shot");

		extent.endTest(charge_rule_find);
		
		rules
				.appendChild(rate_matrix_find)
				.appendChild(rate_matrix_create)
				.appendChild(charge_rule_find);
		
		
		extent.endTest(rules);
		
		ExtentTest invoice = extent.startTest("Invoice");
		
		
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
		
		invoice
				.appendChild(inv_cap_find)
				.appendChild(inv_cap_create);
		

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

		invoice
				.appendChild(inv_recon_find)
				.appendChild(inv_recon_create);

		
		extent.endTest(invoice);
				
		extent.flush();
		

	}
}
