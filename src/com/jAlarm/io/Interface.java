package com.jAlarm.io;

import java.io.IOException;

import com.pi4j.device.piface.PiFace;
import com.pi4j.device.piface.impl.PiFaceDevice;
import com.pi4j.io.spi.SpiChannel;

public class Interface {

	public static PiFace piface;
	
	public static void init(){
		try {
			piface  = new PiFaceDevice(PiFace.DEFAULT_ADDRESS, SpiChannel.CS0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
