package com.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

public class Log {
	public BufferedWriter writer  ; 
	private SimpleDateFormat formatter ; 
	private String pathString ; 
	public Log(String pathString) {
		this.pathString = pathString ; 
		formatter = new SimpleDateFormat("dd:MM:yyyy-HH:mm:ss") ; 
		try {
		    File pathFile = new File(this.pathString);
		    if ( !pathFile.exists()) { pathFile.createNewFile();};
			this.writer =new BufferedWriter( new FileWriter(pathFile , true)) ;	
			this.writer.append("\n........NEW SESSION STARTS ........" + formatter.format(new Date()) + "\n\n" );
			this.writer.flush(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void d(String message) {
		try {
			this.writer.append( formatter.format(new Date())+": MESSAGE :" + message + "\n");
			this.writer.flush(); 
			
		} catch (IOException e) {	
			System.out.println("file MESSAGE error");
		}
	}
	public void e(String errorMessage) {
		try {
			this.writer.append( formatter.format(new Date())+": ERROR :" + errorMessage + "\n");
			this.writer.flush(); 
			
		} catch (IOException e) {
			System.out.println("file ERRORMESSAGE error");
		}
	}
}
