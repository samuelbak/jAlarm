package com.jAlarm.src;

public class jAlarm {
	
	static boolean armed = false;
	static boolean triggered = false;

	public static void main(String[] args) {
		Thread sensor = new Thread(new SensorPoll());
		Thread siren = new Thread(new Siren());
		sensor.run();
		siren.run();
		System.out.println("started");
	}

}
