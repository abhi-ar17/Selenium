package prgrms;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	 File src;
	
	public WriteExcel(String excelPath) throws EncryptedDocumentException, IOException
	{
		  src = new File(excelPath);
		 fis= new FileInputStream(src);
		  workbook = (XSSFWorkbook) WorkbookFactory.create(fis);
		 	sheet=workbook.getSheetAt(0);
	}
	
	
	 public void writeData(Object[][] data,int rows) throws IOException
	 {
//		 File src = new File(excelPath);
		 System.out.println("iughw;eoi"+data);
	
	 	for(int i=0;i<rows;i++)
	 	{
	 		String dat=(String) data[i][0];
	 		System.out.println("sbazsdxf"+dat);
//	 	 	sheet.getRow(i).getCell(12).setAsActiveCell();
	 	 	sheet.getRow(i).createCell(12).setCellValue(dat);
	 	 	
	 	}

	 	fis.close();
		  
		  fos=new FileOutputStream(src);

	 	workbook.write(fos);
	 	workbook.close();
	 	fos.close();
	 	

	 }
}
