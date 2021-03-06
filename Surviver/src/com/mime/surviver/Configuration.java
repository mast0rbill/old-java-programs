package com.mime.surviver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Configuration {
	
	Properties properties = new Properties();

	public void saveConfig(String key, int value){
		String path = "res/settings/config.xml";
		try{
			File file = new File(path);
			boolean exist = file.exists();
			if(!exist){
				file.createNewFile();
			}
			OutputStream write = new FileOutputStream(path);
			properties.setProperty(key, Integer.toString(value));
			properties.storeToXML(write, "Settings");
		}catch(Exception e){
		}
	}
	
	public void loadConfig(String path){
		try{
			InputStream read = new FileInputStream(path);
			properties.loadFromXML(read);
			String width = properties.getProperty("width");
			String height = properties.getProperty("height");
			setRes(Integer.parseInt(width), Integer.parseInt(height));
			read.close();
		}catch(FileNotFoundException e){
			saveConfig("width", 640);
			saveConfig("height", 480);
			loadConfig(path);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void setRes(int width, int height){
		if(width == 640 && height == 480){
			Display.selection = 0;
		}
		if(width == 800 && height == 600){
			Display.selection = 1;
		}
		if(width == 1024 && height == 768){
			Display.selection = 2;
		}
	}
	
}
