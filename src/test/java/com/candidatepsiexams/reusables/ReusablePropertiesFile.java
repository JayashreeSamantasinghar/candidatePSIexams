package com.candidatepsiexams.reusables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReusablePropertiesFile {
	public static Properties prop;
	public static FileInputStream file1;
	
	
		public ReusablePropertiesFile(String filepath) throws IOException    {
			try {
			file1=new FileInputStream(filepath);
		prop=new Properties();
		prop.load(file1);}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		
	
	public String getPropertydata(String key) {
		String value=null;
		try {
			value=prop.getProperty(key);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
