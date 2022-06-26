package com.imogen.akhibara.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.imogen.akhibara.utils.DefaultSentences;
import com.imogen.akhibara.utils.Logger;

public class Builder extends JFrame {
	private JTextField ipTextField;
	private JTextField portTextField;
	
	final int WIDTH = 500;
	final int HEIGHT = 500;
	
	Console c;
	Logger l;
	DefaultSentences se;
	
	public Builder() {
		c = new Console();
		l = new Logger();
		se = new DefaultSentences();
		se.init();
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JLabel ipLabel = new JLabel("IP adress");
		panel.add(ipLabel);
		
		ipTextField = new JTextField();
		panel.add(ipTextField);
		ipTextField.setColumns(10);
		
		final JLabel portLabel = new JLabel("Port");
		panel.add(portLabel);
		
		portTextField = new JTextField();
		panel.add(portTextField);
		portTextField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JButton buildButton = new JButton("Build");
		panel_3.add(buildButton);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		final JRadioButton httpRadioButton = new JRadioButton("HTTP");
		panel_1.add(httpRadioButton);
		
		final JRadioButton socksRadioButton = new JRadioButton("SOCKS");
		panel_1.add(socksRadioButton);
		ButtonGroup bg = new ButtonGroup();
		bg.add(httpRadioButton);
		bg.add(socksRadioButton);
		
		buildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String ip = ipTextField.getText();
            	String port = portTextField.getText();
            	if(httpRadioButton.isSelected()) {
            		String line = ip + ":" + port + ":" + "HTTP";
            		String dest = se.getOutput(4) + "payload/config.txt";
            		l.writeConfig(line, dest);;
            	}
            	else if(socksRadioButton.isSelected()) {
            		String line = ip + ":" + port + ":" + "SOCKS";
            		String dest = se.getOutput(4) + "payload/config.txt";
            		l.writeConfig(line, dest);;
            	}
            }
        });
	}
	public void builder() {
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Akhibara proxy Manager");
		
		this.setVisible(true);
		
	}

}
