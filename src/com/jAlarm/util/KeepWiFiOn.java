package com.jAlarm.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class KeepWiFiOn implements Runnable {

	private long timeOut;
	private Socket connection = null;
	private InetAddress ip;
	private int port;
	private String message;
	private PrintWriter out;
	
	public KeepWiFiOn(long timeOut, InetAddress ip, int port, String message) {
		this.timeOut = timeOut;
		this.message = message;
		this.ip = ip;
		this.port = port;
	}

	@Override
	public void run() {
		while (1<2){
			try {
				connection = new Socket(ip, port);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(timeOut);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out = new PrintWriter(connection.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write(message);
			out.flush();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
