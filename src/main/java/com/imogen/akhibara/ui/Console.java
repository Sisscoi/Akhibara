package com.imogen.akhibara.ui;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import com.imogen.akhibara.core.ConnectionListener;

public class Console {
	public void console() throws IOException {
		 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print("$ ");
			String cmd = input.readLine();
			
			if(cmd.equals("")) continue;
			
			if(cmd.equals("start listener")) {
				ConnectionListener cl = new ConnectionListener();
				Scanner input_port = new Scanner(System.in);
				System.out.print("port~ ");
				int port = input_port.nextInt();
				cl.start(port);		
			}
			
			if(cmd.equals("builder")) {
				Builder b = new Builder();
				b.builder();
			}
			
			if(cmd.equals("help")) {
				System.out.println("\t\t COMMANDS : ");
				System.out.println("builder : open the proxy server builder (a tiny GUI)");
				System.out.println("start : start a module (for more infos type help start)");
				System.out.println("stop : stop the specified service (for more infos type help stop)");
				System.out.println("github : to check my GitHub");
			}
			
			if(cmd.equals("github")) {
				try {
			        Desktop.getDesktop().browse(new URL("https://github.com/Sisscoi").toURI());
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			}
			
			else if(cmd.split(" ")[0].equals("help") && cmd.split(" ")[1].equals("start")) {
				System.out.println("\t\t the start command : ");
				System.out.println("start is used the start one akhibara modules/service");
				System.out.println("start listener : start a TCP listener who is listening for a message from one of the proxy servers");
				
			}
			
			else if(cmd.split(" ")[0].equals("help") && cmd.split(" ")[1].equals("stop")) {
				System.out.println("\t\t the stop command : ");
				System.out.println("start is used the stop one akhibara modules/service");
				System.out.println("start listener : stop the TCP listener");
				
			}
			
			else {
				System.out.println("type \"help\" to get the list of the commands");	
			}
		}
		
	}
	
}
