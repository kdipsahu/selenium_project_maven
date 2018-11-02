package org.com.ExcAuomationProject.org.com.ExcAuomationProject;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class FrameworkFunction {

	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest test;
	static By locator;


	public void Exe_Report(String desc, String report_name) {
		try {
			String file_path = "./"+report_name+".html";		    	
			extent = new ExtentReports(file_path);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public void Open_Browser(String desc,String browserName) {
		try {
			if (browserName.equalsIgnoreCase("GC")) {
				System.setProperty("webdriver.chrome.driver", "C:/tmp/chromedriver.exe");
				driver = new ChromeDriver();
			} 
			
			if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "C:/tmp/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} 

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}


	public By locatorValue(String value) {
		By by;		
		by = By.xpath(value);
		return by;
	}


	public void Open_URL(String desc, String URL) throws InterruptedException {
		try {
			driver.get(URL);
			driver.manage().window().maximize();
			Thread.sleep(5000);
			Generate_Report(1, desc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void Click_Tab(String desc, String xpath_value) throws InterruptedException{

		try {
			locator = locatorValue(xpath_value);
			WebElement element = driver.findElement(locator);
			element.click();
			Generate_Report(1, desc);
			Thread.sleep(2000);

		} catch (Exception e) {
			Generate_Report(0, desc);
			e.printStackTrace();
		}
	}

	public void Enter_Text(String desc, String xpath_value, String value) throws InterruptedException{

		try {
			locator = locatorValue(xpath_value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(value);
			Generate_Report(1, desc);
			Thread.sleep(2000);

		} catch (Exception e) {
			Generate_Report(0, desc);
			e.printStackTrace();
		}
	}

	public void DropDown_Value(String desc, String xpath_value, String value) throws InterruptedException{

		try {			
			locator = locatorValue(xpath_value);
			WebElement element = driver.findElement(locator);
			element.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[text()='"+value+"']")).click();
			Thread.sleep(1000);
			Generate_Report(1, desc);
			Thread.sleep(1000);

		} catch (Exception e) {
			Generate_Report(0, desc);
			e.printStackTrace();
		}
	}


	public void Click_Button(String desc, String xpath_value) throws InterruptedException{

		try {			
			locator = locatorValue(xpath_value);
			WebElement element = driver.findElement(locator);
			element.click();
			Thread.sleep(3000);
			Generate_Report(1, desc);
			Thread.sleep(1000);

		} catch (Exception e) {
			Generate_Report(0, desc);
			e.printStackTrace();
		}

	}


	public void Validate_Data(String desc, String xpath_value1, String xpath_value2) throws InterruptedException{

		try {			
			By find_table = locatorValue(xpath_value1);
			int r;
			int i,j;
			String step_desc;
			int ro = 1;
			int co = 1;
			WebElement table = driver.findElement(find_table);
			Thread.sleep(1000);
			Generate_Report(3, desc);
			Thread.sleep(1000);
			List<WebElement> allrows = table.findElements(By.tagName("tr"));

			for (WebElement row : allrows){
				r = 1;
				List<WebElement> allcols = row.findElements(By.tagName("td"));

				for(WebElement col : allcols){
					String xpath_2 = xpath_value2 + "["+ r +"]";			
					By find_tabRow = locatorValue(xpath_2);
					WebElement tabRow = driver.findElement(find_tabRow);
					r = r + 2;
					String[] str = col.getText().split("\n");

					for(i=0;i<str.length;i++){

						String[] st = str[i].split(":");

						j =  st.length;

						if(j >1){
							if(!("null".equalsIgnoreCase(st[0]) || "null".equalsIgnoreCase(st[1]))){
								step_desc = ro + " Row -- "+ tabRow.getText()  +" columns "+co+" -- Data are displayed properly " + st[0] + "_" + st[1];
								Generate_Report(1, step_desc);
							}
							else{
								step_desc = ro + " Row -- "+ tabRow.getText()  +" columns "+co+" -- Data are not displayed properly " + st[0] + "_" + st[1];
								Generate_Report(0, step_desc);
							}
						}
						else{
							if(!("null".equalsIgnoreCase(st[0]))){
								step_desc = ro + " Row -- "+ tabRow.getText()  +" columns "+co+" -- Data are displayed properly " + st[0];
								Generate_Report(1, step_desc);
							}
							else{
								step_desc = ro + " Row -- "+ tabRow.getText()  +" columns "+co+" -- Data are not displayed properly " + st[0];
								Generate_Report(0, step_desc);
							}
						}
					} 
					co++;
				} // End allcols
				ro++;
			} // End allrows

			Thread.sleep(1000);

		} catch (Exception e) {
			Generate_Report(0, desc);
			e.printStackTrace();
		}

	}
	
	public void Enter_Val_DropDown(String desc, String xpath_value, String value) throws InterruptedException{
	
		try {			
			locator = locatorValue(xpath_value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(value);
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			Generate_Report(1, desc);
			Thread.sleep(1000);

		} catch (Exception e) {
			Generate_Report(0, desc);
			e.printStackTrace();
		}
	}

	
	public void Validate_Calc_Rate(String desc, String xpath_value1, String xpath_value2 ) throws InterruptedException{
		
		locator = locatorValue(xpath_value1);
		WebElement product = driver.findElement(locator);
		
		locator = locatorValue(xpath_value2);
		WebElement rate = driver.findElement(locator);
		
		if(product.isDisplayed() && rate.isDisplayed()){
			
			Generate_Report(1, desc);
		}
		else{
			Generate_Report(0, desc);
		}
	}
	
	
	public void Close_Browser(String desc) throws InterruptedException{
		driver.close();
		Generate_Report(1, desc);
	}
	
	public void Generate_Report(int flag,String desc) throws InterruptedException{

		test = extent.startTest(desc);
		String img = test.addScreenCapture(CaptureScreen(driver,"./Reports/"+desc));
		switch(flag){		
		case 1:
			test.log(LogStatus.PASS, img);
			break;
		case 0:
			test.log(LogStatus.FAIL, img);
			break;
		case 2:
			test.log(LogStatus.UNKNOWN, img);
			break;
		default:
			test.log(LogStatus.INFO, desc);
		}
		extent.endTest(test);
		extent.flush();
		Thread.sleep(1000);
	}

	public static String CaptureScreen(WebDriver driver, String ImagesPath)
	{
		File src_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File oDest = new File(ImagesPath+".jpg");
		try {
			FileUtils.copyFile(src_file, oDest);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return ImagesPath+".jpg";
	}
}
