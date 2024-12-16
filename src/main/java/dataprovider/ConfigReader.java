package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
	public static  String getValue(String key) throws IOException
	{
		Properties pro=new Properties();
		File f=new File("/Users/rahulkadam/eclipse-workspace/Framework1/config.properties");
		FileInputStream fis=new FileInputStream(f);
		System.out.println(key);
		pro.load(fis);	
		String value=pro.getProperty(key);
		System.out.println(value);
		return value;
	}
}
