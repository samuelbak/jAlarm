package com.jAlarm.io;

public class Input {
	
	public static boolean readPin(){
		return Interface.piface.getInputPin(4).isHigh();                           
	}

}
