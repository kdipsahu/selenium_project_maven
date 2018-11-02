package org.com.ExcAuomationProject.org.com.ExcAuomationProject;


import java.util.ArrayList;
import java.util.List;



//import org.testng.annotations.Test;



public class CallingValue {

	
	public void tc_exe_function(String tc_name , String tc_exe_ind) {
		
		FrameworkExecution exeKey = new FrameworkExecution();
		ReadExcel excelSheet = new ReadExcel();

		if(tc_exe_ind.equals("Y")){
			excelSheet.openSheet("D:/ksahu/Selenium_2018/org.com.ExcAuomationProject/Workflow.xlsx", tc_name);

			for (int row = 1; row <= excelSheet.getRowCount(); row++) {
				List<Object> myParamList = new ArrayList<Object>();
				String methodName = excelSheet.getValueFromCell(row, 0);
				for (int col = 1; col < excelSheet.getColumnCount(row); col++) {
					if (!excelSheet.getValueFromCell(row, col).isEmpty()
							& !excelSheet.getValueFromCell(row, col).equals("null")) {
						myParamList.add(excelSheet.getValueFromCell(row, col));
					}
				}
				Object[] paramListObject = new String[myParamList.size()];
				paramListObject = myParamList.toArray(paramListObject);

				exeKey.runReflectionMethod("org.com.ExcAuomationProject.org.com.ExcAuomationProject.FrameworkFunction",methodName, paramListObject);

			}

			excelSheet.closeSheet();
		}

	}
}
