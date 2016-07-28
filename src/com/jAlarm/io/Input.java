package com.jAlarm.io;

import java.io.IOException;

import com.pi4j.device.piface.PiFace;
import com.pi4j.device.piface.PiFaceSwitch;
import com.pi4j.device.piface.impl.PiFaceDevice;
import com.pi4j.io.spi.SpiChannel;

public class Input {
	
	public static boolean readPin(){
		return Interface.piface.getSwitch(PiFaceSwitch.S1).isOn();
	}

}
