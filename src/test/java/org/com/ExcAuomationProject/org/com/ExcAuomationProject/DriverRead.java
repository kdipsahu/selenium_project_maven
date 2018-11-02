package org.com.ExcAuomationProject.org.com.ExcAuomationProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DriverRead {

	public static String tc_name = null;
	public static String tc_exe_ind = null;

	static Workbook  w_book;
	static Sheet st;
	static FileInputStream fs;

	static int row_count, col_count, i, j;

	static Row row;

	@Test
	public void driver_read(){

		CallingValue ob = new CallingValue();
		
		try{
			fs = new FileInputStream("D:/ksahu/Selenium_2018/org.com.ExcAuomationProject/Driver.xlsx");
			w_book = new XSSFWorkbook(fs);
			st = w_book.getSheet("TC01");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		row_count = st.getLastRowNum() - st.getFirstRowNum();
		System.out.println();

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
