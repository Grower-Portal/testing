package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DPExcelUtil {

public static Iterator<Object[]> getTestData(String strWorkbookPath, String strworksheetName) { 
	List<Object[]> data = new ArrayList<Object[]>();
	
	int rowCount = 0;
	String pathExtension = null;
	try {
		
		File filePath = new File(strWorkbookPath);
		pathExtension = getFileExtension(filePath);
		FileInputStream file = new FileInputStream(filePath); 
		Iterator<Row> rowIterator = null;
		if (pathExtension.equalsIgnoreCase("xls")) {
			// Get the workbook instance for XLS file 
			HSSFWorkbook workbook = new HSSFWorkbook (file);
		
		// Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheet(strworksheetName); 
		// Get iterator to all the rows in current sheet rowIterator = sheet.rowIterator();
	} else {

		// Get the workbook instance for XLSX file
		XSSFWorkbook workbook = new XSSFWorkbook (file);
	
		XSSFSheet sheet = workbook.getSheet (strworksheetName); 
		// Get iterator to all the rows in current sheet 
		rowIterator = sheet.rowIterator();
		
	}
		Row firstRow = rowIterator.next(); 
		//System.out.println(firstRow);
		
		Map<String, String> columnNamesMap = getColumnNames (firstRow);
		//System.out.println(columnNamesMap); 
		while (rowIterator.hasNext()) {
			Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
			Map<String, String> rowMap = new LinkedHashMap<String, String>();
			
			for (Entry<?, ?> entry : columnNamesMap.entrySet()) {
				System.out.println();
				String strColumnName = entry.getKey().toString();
				String strValue = cellIterator.next().toString(); 
				if (!strValue.isEmpty() && strValue != null) {
					rowMap.put(strColumnName, strValue); 
					//System.out.println(rowMap);
				}
			}
			if(rowMap!=null&&!rowMap.isEmpty()){
				data.add(new Object[]{rowMap});
				}
		}
		file.close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return data.iterator();
	}

public static Iterator<Object[]> getTestDataByScenario(String strWorkbookPath, String strWorksheetName,
		String strScenario) {
	List<Object[]> data = new ArrayList<Object[]>();

	int inRowCounter = 0;
	String pathExtension = null;
	try {
		File filePath = new File(strWorkbookPath); 
		pathExtension = getFileExtension(filePath);
		// pathExtension = "xlsx";
		FileInputStream file = new FileInputStream(filePath); 
		Iterator<Row> rowIterator = null;
		if (pathExtension.equalsIgnoreCase("xls")) {
			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet (strWorksheetName); 
			// Get iterator to all the rows in current sheet 
			rowIterator = sheet.rowIterator();
		} else {
			// Get the workbook instance for XLSX file 
			XSSFWorkbook workbook = new XSSFWorkbook (file);
		
			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(strWorksheetName); 
			// Get iterator to all the rows in current sheet 
			rowIterator = sheet.rowIterator();
		}
			Row firstRow = rowIterator.next();
			Map<String, String> columnNamesMap = getColumnNames(firstRow);
			Object[] keys = columnNamesMap.keySet().toArray(); 
			String strValue = "";
			while (rowIterator.hasNext()) {
				// Iterator<org.apache.poi.ss.usermodel.Cell> 
				// cellIterator=rowIterator.next().cellIterator(); 
				Map<String, String> rowMap = new LinkedHashMap<String, String>();
				Row row = rowIterator.next();
				
				if ((row.getCell(0).getStringCellValue().equalsIgnoreCase(strScenario))) { 
					for (int j = 0; j < row.getLastCellNum(); j++){
						
						String strColumnName = columnNamesMap.get(keys[j].toString());
						if (row.getCell(j) != null) {
							strValue = row.getCell(j).toString();
						} else {
							strValue = "";
						}
						if (!strValue.isEmpty() && strValue != null) {
							rowMap.put(strColumnName, strValue);
						}
					}
				}
					
					if (rowMap != null && !rowMap.isEmpty()) {
						data.add(new Object[] { rowMap });
					}
				}
				
				file.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
			return data.iterator();
	}

	private static Map<String, String> getColumnNames(Row row) {
		Map<String, String> columnNamesMap = new LinkedHashMap();
		
		Iterator<Cell> cells = row.cellIterator();
		
		while (cells.hasNext()) {
			String strColumnName = cells.next().toString();
			columnNamesMap.put(strColumnName,strColumnName);
		}
		
			return columnNamesMap;
	}

	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) 
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
		}
}
