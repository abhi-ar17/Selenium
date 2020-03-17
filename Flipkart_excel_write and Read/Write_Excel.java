package prgrms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel {
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook workbook,wb;
	XSSFSheet sheet;
	 File src;
	
	public Write_Excel(String excelPath) throws FileNotFoundException
	{
		  src = new File(excelPath);
		 fis= new FileInputStream(src);
		  workbook = new XSSFWorkbook();

	}
	
	
	 public void writeData(Object[][] data,int rows) throws IOException
	 {
		 try {

	            workbook = (XSSFWorkbook) WorkbookFactory.create(fis);
	 
	           sheet = workbook.getSheetAt(0);
	            int rowCount =0;
	 
	            for (Object[] aBook : data) {
	                Row row = sheet.getRow(rowCount);
	 
	                int columnCount = 12;
	                 
//	                Cell cell = row.createCell(columnCount);
//	                cell.setCellValue(rowCount);
	                 
	                for (Object field : aBook) {
	                Cell  cell = row.createCell(columnCount);
	                    if (field instanceof String) {
	                    	System.out.println("Field :"+field);
	                        cell.setCellValue((String) field);
	                    }
	                    columnCount++;
	                }
	                rowCount++;
	 
	            }
	 
	      fis.close();
	 
	            FileOutputStream outputStream = new FileOutputStream(src);
	            workbook.write(outputStream);
	            workbook.close();
	            outputStream.close();
	 }
		 catch (Exception e)
		 {
	   System.out.println(",,,,,,,,,,,,,,,");
}
	 }
}
