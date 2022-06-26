package com.imogen.akhibara.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	BufferedWriter writer;
	public void write(String data, String destination){
		try {
			writer = new BufferedWriter(new FileWriter(destination, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String command = data;		
		try {
			writer.write(command + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// cette fonction sert à écrire le fichier de config du payload
	public void writeConfig(String data, String destination){
		try {
			writer = new BufferedWriter(new FileWriter(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String command = data;		
		try {
			writer.write(command + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
