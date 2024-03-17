package utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import junit.framework.Assert;
import testdatareader.ReadxlsFile;

public class CommonFunction {
	
	
	
	public void assertEquals(String actual,String expected)
	{
		
		try {
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void assertEquals(int actual,int expected)
	{
		
		try {
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public String readEnvFile(String key)
	{
		String value="";
		try {
			
			String path=System.getProperty("user.dir")+"\\src\\test\\java\\enviornmentfile\\TestEnviornment.properties";
			
			FileInputStream file=new FileInputStream(path);
			Properties prop=new Properties();
			prop.load(file);
			value=prop.getProperty(key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
		
		
	}
	
	
	public List<String> getExcelData(String xlsFilename,String subsheetName,int columnIndex)
	{
		List<String> title = null;
		try {
			
			ReadxlsFile xls=new ReadxlsFile();
			Map<Integer, List<Object>> map=xls.readxlsFile(xlsFilename, subsheetName);
			System.out.println("******************************");
			 title=new ArrayList<String>();
			for(Map.Entry<Integer, List<Object>> map1:map.entrySet())
			{
				
				System.out.println(map1.getKey()+" "+map1.getValue());
				title.add(map1.getValue().get(columnIndex).toString());

				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return title;
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
