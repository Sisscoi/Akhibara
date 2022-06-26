package com.imogen.akhibara.utils;

import java.util.ArrayList;

public class DefaultSentences {
	public ArrayList<String> defaultOutputs = new ArrayList<String>();
	public void init() {
		defaultOutputs.add("[+] ConnectionListener Module has succefully started");
		defaultOutputs.add("[+] Server Connected");
		defaultOutputs.add("Succefully received data, type \\\"servers\\\" to check available servers list");
		defaultOutputs.add("[+] connection dropped with the proxy server, please restart connection listener module");
		defaultOutputs.add("C:/Akhibara/");
		defaultOutputs.add("[+] stopping the current module");
		defaultOutputs.add("please leave the current module before typing another command, actually you can only stop the current module");
	}
	public String getOutput(int n) {
		return defaultOutputs.get(n);
	}
	// y a pas de setter, c'est inutile
}
