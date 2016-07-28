package com.jAlarm.io;

import java.io.IOException;

import com.pi4j.device.piface.PiFace;
import com.pi4j.device.piface.PiFaceRelay;
import com.pi4j.device.piface.impl.PiFaceDevice;
import com.pi4j.io.spi.SpiChannel;

public class Output {
	
		
	public static boolean writePin(){
		Interface.piface.getRelay(PiFaceRelay.K0).toggle();
		return true;
	}

}
