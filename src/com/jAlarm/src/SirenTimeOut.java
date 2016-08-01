package com.jAlarm.src;

import com.jAlarm.io.Output;

public class SirenTimeOut implements Runnable {

	private long timeOut;
	public boolean stop = false;
	
	public SirenTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (stop==false)
			Output.writePin(false);
	}

}
