package com.jAlarm.src;

import com.jAlarm.io.Interface;
import com.jAlarm.util.EventLog;
import com.jAlarm.util.Manage;

public class jAlarm {
	
	public static final boolean SIMULATION = false;
	static boolean armed = false;
	static boolean triggered = false;
	static boolean check = false;
	static Network network;
	static Thread net;

	public static void main(String[] args) {
		network = new Network(12345);
		net = new Thread(network);
		/*
		Thread wifiOn = null;
		try {
			wifiOn = new Thread(new KeepWiFiOn(60000,InetAddress.getByName("192.168.0.1"), 80, "hello"));
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		wifiOn.start();
		*/
		Interface.init();
		@SuppressWarnings("unused")
		EventLog log = new EventLog();
		EventLog.log("jAlarm started");
		net.start();
		while(1<2){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (check==true){
				if(armed==false){
					triggered = false;
					check=false;
					Manage.stopAlarm();
					EventLog.log("Allarme disattivato");
				}
				else{
					triggered = false;
					check = false;
					Manage.startAlarm();
					EventLog.log("Allarme attivato");
				}
			}
		}
	}

}
