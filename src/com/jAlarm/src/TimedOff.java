package com.jAlarm.src;

import java.time.LocalTime;

public class TimedOff implements Runnable {
	
	public boolean stop = false;
	private LocalTime offTime;

	public TimedOff(LocalTime offTime){
		this.offTime = offTime;
	}
	
	@Override
	public void run() {
		
	}

}
