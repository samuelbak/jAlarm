package com.jAlarm.src;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Network implements Runnable {
	
	final int port;
	ServerSocket server;
	Socket connection;
	InputStream in;
	PrintWriter out;

	public Network(int portNumber) {
		port = portNumber;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("Network Thread");
		try {
			server = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while(1<2){
			try {
				connection = server.accept();
				in = connection.getInputStream();
				out = new PrintWriter(connection.getOutputStream());
				jAlarm.check = true;
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}

	}

}
