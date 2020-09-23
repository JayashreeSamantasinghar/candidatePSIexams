package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReusables {


	//public class ExcelReusables {
		public static FileInputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
		public ExcelReusables(String filepath) throws FileNotFoundException {
			file=new FileInputStream(System.getProperty("user.dir")+ filepath);	
		 	 
		}
		public XSSFSheet sheetdata(String sheetname) throws IOException {
			wb=new XSSFWorkbook(file);
			sh=wb.getSheet(sheetname);
			return sh;
		}
			
				public ArrayList<String>  read(int colindex) {
				int noOfRows=sh.getLastRowNum();
				ArrayList<String> list= new ArrayList<String>();
				for(int i=1;i<=noOfRows;i++) {
				
				list.add(sh.getRow(i).getCell(colindex).getStringCellValue());
				}
				return list;
				 
				}		
			
				
			public String readData(int rowno,int colno) {
			String text= sh.getRow(rowno).getCell(colno).getStringCellValue();
			return text;
			}
			
			public int getrow_count(String sheetname) throws IOException {
				wb=new XSSFWorkbook(file);
				sh=wb.getSheet(sheetname);
				int count=sh.getLastRowNum();
				return count;

			}
			
			public int getcol_count(String sheetname,int rowindex) throws IOException {
				wb=new XSSFWorkbook(file);
				sh=wb.getSheet(sheetname);
				int count=sh.getRow(rowindex).getLastCellNum();
				return count;
			}
			
			
			public static FileOutputStream fo;
			public  ExcelReusables(String filepath,String filename) throws FileNotFoundException {
				
				//String str = filename+"\\"+filepath;
				
				fo=new FileOutputStream(filepath +"\\"+ filename);
				
					
			}
			
			public static 	XSSFWorkbook workbook;
			public static XSSFSheet newsheet;
			public XSSFSheet CreateSheet(String sheet)
			{
				
				workbook =new XSSFWorkbook();//no file is there, we will create

				 newsheet=workbook.createSheet(sheet);
				return newsheet;
			}
			
			public void createdata(int rowIndex,int colIndex,String cellvalue) throws IOException {
				newsheet.createRow(rowIndex).createCell(colIndex).setCellValue(cellvalue);
				workbook.write(fo);

			}
			public static Properties prop;
			public void propertyfile(String filepath) throws IOException {
			file=new FileInputStream(filepath);
			//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"config.proprties");
			prop=new Properties();
			prop.load(file);
		//System.out.println(prop.getProperty(browsername));
		//System.out.println(prop.getProperty(url));
		//file.close();
			}

}
