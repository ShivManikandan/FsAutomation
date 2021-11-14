package testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] readExcel(String fileName, String sheetName) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("S:\\Testleaf\\Workspace\\FsAutomation\\data\\"+fileName+".xlsx");
		// to get into the sheet
		XSSFSheet ws = wb.getSheet(sheetName);
		// to get the rowcount excluding the first row
		int rowCount = ws.getLastRowNum();
		int cellCount = ws.getRow(0).getLastCellNum();
		// declare 2d array with rowcount and cell count
		String[][] data = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {

				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = cellValue;
				System.out.println(cellValue);

			}
		}
	
		wb.close();
		return data;

	}

}

