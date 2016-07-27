package com.jAlarm.src;

import com.jAlarm.IO.*;

public class SensorPoll implements Runnable {

	public SensorPoll() {
		
	}

	@Override
	public void run() {
		System.out.println("hello from sensor thread");
		while(jAlarm.armed==true){
			try {
				this.wait(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Input.readPin()==true)
				jAlarm.triggered = true;
		}
	}
}
