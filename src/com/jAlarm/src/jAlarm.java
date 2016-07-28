package com.jAlarm.src;

import com.jAlarm.io.Interface;
import com.jAlarm.util.EventLog;
import com.jAlarm.util.Manage;

public class jAlarm {
	
	static boolean armed = false;
	static boolean triggered = false;
	static boolean check = false;
	static Network network;
	static Thread net;

	public static void main(String[] args) {
		network = new Network(12345);
		net = new Thread(network);
		net.start();
		Interface.init();
		@SuppressWarnings("unused")
		EventLog log = new EventLog();
		EventLog.log("jAlarm starterd");
		while(1<2){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (check==true){
				if(armed==true){
					triggered = false;
					armed = false;
					check=false;
					Manage.stopAlarm();
					EventLog.log("Allarme disattivato");
				}
				else{
					triggered = false;
					armed = true;
					check = false;
					Manage.startAlarm();
					EventLog.log("Allarme attivato");
				}
			}
		}
	}

}
