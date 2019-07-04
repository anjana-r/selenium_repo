package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	Properties pro = null;
	
	public ConfigFileReader(String filePath){
		File file = new File(filePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			 pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getData(String elementName){
		String data = pro.getProperty(elementName);
		if (data != null){
			return data;
		}
		else throw new RuntimeException("Unable to find " + data + "in the properties file.");	
	}
	
	
}
