package com.jAlarm.src;

import com.jAlarm.io.Output;

public class Siren implements Runnable {
	
	public boolean stop = false;

	public Siren() {
		
	}

	@Override
	public void run() {
		Thread.currentThread().setName("Siren Thread");
		System.out.println("hello from siren thread");
		while(jAlarm.armed==true){
			if (stop == true){
				Output.writePin();
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(jAlarm.triggered==true)
				Output.writePin();
		}
	}
}
