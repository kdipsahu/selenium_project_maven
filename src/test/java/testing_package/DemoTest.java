package testing_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.com.ExcAuomationProject.org.com.ExcAuomationProject.CallingValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest {

	WebDriver driver;
	public static String tc_name = null;
	public static String tc_exe_ind = null;

	static Workbook  w_book;
	static Sheet st;
	static FileInputStream fs;

	static int row_count, col_count, i, j;

	static Row row;
	
	/*@Test
	public void f() {

		System.setProperty("webdriver.chrome.driver", "C:/tmp/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://192.168.109.102:18217/examinWeb/DummyLogin.jsp");
		driver.manage().window().maximize();	
		
	}*/
	
	@Test
	@Parameters("tc")
	public void driver_read(String tc_name){
		
		CallingValue ob = new CallingValue();
		
		System.out.println(tc_name);
		
		try{
			fs = new FileInputStream("D:/ksahu/Selenium_2018/org.com.ExcAuomationProject/Driver.xlsx");
			//w_book = new XSSFWorkbook(fs);
			w_book = WorkbookFactory.create(fs);
			st = w_book.getSheet(tc_name);
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

		row_count = st.getLastRowNum() - st.getFirstRowNum();
		System.out.println(row_count);
		
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(i= 1 ; i<= row_count ; i++){

			row = st.getRow(i);

			tc_name = row.getCell(0).getStringCellValue();
			tc_exe_ind = row.getCell(2).getStringCellValue();

			System.out.println(tc_name +" --- "+ tc_exe_ind );

			ob.tc_exe_function(tc_name, tc_exe_ind);
		}
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
