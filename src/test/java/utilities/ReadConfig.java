package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public static FileInputStream file;
	public static Properties prop;
		public  ReadConfig(String filepath)   {
			try {
		//file=new FileInputStream(filepath);
		 file=new FileInputStream(filepath);
		prop=new Properties();
		prop.load(file);}catch(IOException e) {}
			
	//System.out.println(p.getProperty(browsername));
	//System.out.println(p.getProperty(url));
	//file.close();
		}

}
