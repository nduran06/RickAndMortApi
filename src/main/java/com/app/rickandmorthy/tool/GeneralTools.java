package com.app.rickandmorthy.tool;

import java.sql.Date;

public class GeneralTools {
	
	
	public static Date getDate() {
		
		long millis = System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis);  
        
        return date;
	}

}
