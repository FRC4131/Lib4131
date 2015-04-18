package org.usfirst.frc.team4131.lib.oi;

public class Launchpad extends BaseController{
	public static final int NUM_BUTTONS = 18, NUM_AXES = 6;
	public Launchpad(int port){super(port, NUM_BUTTONS, NUM_AXES);}
	public void setDigitalOut(int pin, boolean state){super.setOutput(pin, state);}
}
