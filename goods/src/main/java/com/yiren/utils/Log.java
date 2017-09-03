package com.yiren.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public  class Log {
	public static Logger out(){
		Logger logger = Logger.getLogger(Log. class ); 
		return logger;
	}
	public static void main(String[] args) {
	 
		 
		Log.out().error("6");
	}
	

}
