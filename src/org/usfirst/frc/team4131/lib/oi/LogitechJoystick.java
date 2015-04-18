package org.usfirst.frc.team4131.lib.oi;

/**
 * Logitech Attack 3 joystick.
 * These are the most plentiful joysticks in our arsenal.
 */
public class LogitechJoystick extends BaseController{
	public static final int X = 0, Y = 1, KNOB = 2;
	//No need to define button constants: they're numbered on the joystick
	public static final int NUM_BUTTONS = 11, NUM_AXES = 3;
	public LogitechJoystick(int port){super(port, NUM_BUTTONS, NUM_AXES);}
}
