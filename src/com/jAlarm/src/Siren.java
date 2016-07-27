package com.jAlarm.src;

import com.jAlarm.IO.Output;

public class Siren implements Runnable {

	public Siren() {
		
	}

	@Override
	public void run() {
		System.out.println("hello from siren thread");
		while(jAlarm.armed==true){
			try {
				this.wait(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(jAlarm.triggered==true)
				Output.writePin();
		}
	}

}
