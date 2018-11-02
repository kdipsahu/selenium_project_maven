package org.com.ExcAuomationProject.org.com.ExcAuomationProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	Workbook wbWorkbook;
	Sheet st;
	FileInputStream fs;


	public void openSheet(String filePath, String tc_name) {
		try {
			fs = new FileInputStream(filePath);
			Workbook w_book = new XSSFWorkbook(fs);
			st = w_book.getSheet(tc_name);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValueFromCell(int iRowNumber, int iColNumber) {
		return st.getRow(iRowNumber).getCell(iColNumber).getStringCellValue();
	}

	public int getRowCount() {
		return st.getLastRowNum()- st.getFirstRowNum();
	}

	public int getColumnCount(int row) {
		return st.getRow(row).getLastCellNum();
	}

	public void closeSheet(){
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
