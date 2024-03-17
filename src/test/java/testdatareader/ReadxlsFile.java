package testdatareader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadxlsFile {
	
	
	
	public Map<Integer, List<Object>> readxlsFile(String xlsFileName,String sheetName)
	{
		
		Map<Integer, List<Object>> map=new LinkedHashMap<Integer, List<Object>>();
		
		try {
			
			String path=System.getProperty("user.dir")+"\\testdata\\"+xlsFileName;
			FileInputStream file=new FileInputStream(path);
			
			Workbook book=WorkbookFactory.create(file);
			
			Sheet sheet=book.getSheet(sheetName);
			int rowNumber=0;
			Iterator<Row> rowitr=sheet.rowIterator();
			while(rowitr.hasNext())
			{
				
				List<Object> rowlist=new ArrayList<Object>();
				Row rowdata=rowitr.next();
				
				Iterator<Cell> cellitr=rowdata.cellIterator();
				
				while(cellitr.hasNext())
					
				{
					
					Cell celldata=cellitr.next();
					
					switch (celldata.getCellTypeEnum()) {
					
					case STRING:
						
							rowlist.add(celldata.getRichStringCellValue().getString());
						
						break;
						
                   case BOOLEAN:
						rowlist.add(celldata.getBooleanCellValue());
						break;
                   case NUMERIC:
                	   celldata.setCellType(CellType.STRING);
						rowlist.add(celldata.getNumericCellValue());
						break;
                   case FORMULA:
						rowlist.add(celldata.getCellFormula());
						break;
                   case BLANK:
						rowlist.add("Blank");
						break;

					default:
						break;
					}
					
					
					
					
					
				}
				map.put(rowNumber, rowlist);
				rowNumber++;
				
				
			}
			
			
			map.remove(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
