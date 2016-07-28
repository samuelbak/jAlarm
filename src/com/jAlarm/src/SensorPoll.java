package com.jAlarm.src;



import com.jAlarm.io.*;

public class SensorPoll implements Runnable {

	public boolean stop = false;
	
	public SensorPoll() {
		
	}

	@Override
	public void run() {
		System.out.println("hello from sensor thread");
		Thread.currentThread().setName("Sensor Thread");
		
		while(jAlarm.armed==true){
			if (stop == true)
				break;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Input.readPin()==true)
				jAlarm.triggered = true;
		}
	}
}
