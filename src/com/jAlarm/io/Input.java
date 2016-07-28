package com.jAlarm.io;

import com.pi4j.device.piface.PiFaceSwitch;

public class Input {
	
	public static boolean readPin(){
		return Interface.piface.getSwitch(PiFaceSwitch.S1).isOn();
	}

}
