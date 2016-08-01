package com.jAlarm.util;

import com.jAlarm.io.Output;
import com.jAlarm.src.SensorPoll;
import com.jAlarm.src.Siren;
import com.jAlarm.src.jAlarm;

public class Manage {
	
	static Thread sensor;
	static Thread siren;
	static Siren sirenObj;
	static SensorPoll sensorObj;

	public static void startAlarm(){
		sensorObj = new SensorPoll();
		sirenObj = new Siren();

		sensor = new Thread(sensorObj);
		siren = new Thread(sirenObj);

		sensor.start();
		siren.start();
	}
	
	public static void stopAlarm(){
		sirenObj.stop = true;
		sensorObj.stop = true;
		do{}while(siren.isAlive());
		System.out.println("sensor stopped");
		do{}while(sensor.isAlive());
		System.out.println("siren stopped");
		Output.writePin(false);
	}
	
	public static void restartAlarm(){
		stopAlarm();
		startAlarm();
	}

}
