package com.imogen.akhibara.core;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.imogen.akhibara.ui.Console;
import com.imogen.akhibara.utils.DefaultSentences;
import com.imogen.akhibara.utils.Logger;

public class ConnectionListener {
	DefaultSentences se;
	Console c;
	
	public void start(int port) {
		se = new DefaultSentences();
		se.init();
		
		c = new Console();
		
		try{ 
			System.out.println(se.getOutput(0));
			ServerSocket ss = new ServerSocket(port); 
			
			Scanner clScanner = new Scanner(System.in);
			System.out.print("$ ");
			String input = clScanner.nextLine();
			if(input.split(" ")[0].equals("stop") && input.split(" ")[1].equals("listener")) System.out.println(se.getOutput(5));
			else System.out.println(se.getOutput(6));
			c.console();
			
			Socket s=ss.accept();  
			System.out.println(se.getOutput(1));
			DataInputStream dis=new DataInputStream(s.getInputStream());  
			String  str=(String)dis.readUTF();  
			System.out.println(se.getOutput(2));
			Logger l = new Logger();
			String dest = se.getOutput(4) + "clients.txt";
			l.write(str, dest);
			// socket fermée, donc il faut relancer le connectionListener
			ss.close();
			System.out.println(se.getOutput(3));
			} catch(Exception e){
				System.err.println(e);
		}  
	}   
}
