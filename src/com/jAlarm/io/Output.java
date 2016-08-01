package com.jAlarm.io;

import com.pi4j.device.piface.PiFaceRelay;

public class Output {
	
	public static boolean writePin(boolean state){
		if (state==true)
			Interface.piface.getRelay(PiFaceRelay.K0).close();
		else
			Interface.piface.getRelay(PiFaceRelay.K0).open();
		return true;
	}

}
