package com.jAlarm.src;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.jAlarm.util.EventLog;

public class Network implements Runnable {
	
	
	private  String htmlEn = 	"<!DOCTYPE html\r\n"+
								"<html>\r\n"+
								"<body>\r\n"+
								"<font size="+"25"+"><h1>Allarme casa</h1>\r\n"+	
								"<font size="+"25"+"><p>L'allarme è attivo.<BR><BR></p>\r\n"+
								"<font size="+"25"+"><a href="+"on"+">Attiva</a><BR><BR><BR>\r\n"+
								"<a href="+"off"+">Disattiva</a><BR>\r\n"+
								"</body>\r\n"+
								"</html>\r\n\r\n";

	private  String htmlDis= 	"<!DOCTYPE html\r\n"+
								"<html>\r\n"+
								"<body>\r\n"+
								"<font size="+"25"+"><h1>Allarme casa</h1>\r\n"+	
								"<font size="+"25"+"><p>L'allarme non è attivo.<BR><BR></p>\r\n"+
								"<font size="+"25"+"><a href="+"on"+">Attiva</a><BR><BR><BR>\r\n"+
								"<a href="+"off"+">Disattiva</a><BR>\r\n"+
								"</body>\r\n"+
								"</html>\r\n\r\n";

	private  String response = 	"HTTP/1.1 200 OK\r\n"+
								"Date: Fri, 29 Jul 2016 14:00:00 GMT\r\n"+
								"Server: Apache\r\n"+
								"Last-Modified: Fri, 29 Jul 2016 14:00:00 GMT\r\n"+
								"Content-Type: text/html\r\n"+
								"Connection: close\r\n\r\n";

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
				EventLog.log("Connessione da: "+connection.getInetAddress());
				in = connection.getInputStream();
				out = new PrintWriter(connection.getOutputStream());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(in.available());
				
				String res ="";
				while(in.available()>0){
					res = res.concat(String.valueOf(Character.toChars(in.read())));
				}
				System.out.println(res);
				if(res.contains("GET / HTTP") && jAlarm.armed==false){
					out.write(response);
					out.flush();
					out.write(htmlDis);
					out.flush();
				}
				else if(res.contains("GET / HTTP") && jAlarm.armed==true){
					out.write(response);
					out.flush();
					out.write(htmlEn);
					out.flush();
				}
				else if(res.contains("GET /on HTTP")){
					if(jAlarm.armed==false){
						jAlarm.armed = true;
						jAlarm.check = true;
					}
					out.write(response);
					out.flush();
					out.write(htmlEn);
					out.flush();
				}
				else if(res.contains("GET /off HTTP")){
					if(jAlarm.armed==true){
						jAlarm.armed = false;
						jAlarm.check = true;
					}
					out.write(response);
					out.flush();
					out.write(htmlDis);
					out.flush();
				}
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}

	}

}
