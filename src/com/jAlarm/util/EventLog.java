package com.jAlarm.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EventLog {

	private static Logger logger;
	private static FileHandler fh;
	
	public EventLog() {
		logger = Logger.getLogger("Event logger");  

	    try {  
	        fh = new FileHandler("/home/pi/allarme/EventLog.log", true);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);   

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}
	public static void log(String text){
		logger.info(text);
	}

}
