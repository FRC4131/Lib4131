package org.usfirst.frc.team4131.lib.oi;

import org.usfirst.frc.team4131.lib.Robot;

public class LogitechExtreme3 extends BaseController{
	public static final int NUM_BUTTONS = 12, NUM_AXES = 4;
	/**Axis number*/public static final int X = 0, Y = 1, Z = 2, DIAL = 3;
	/**Button number*/public static final int TRIGGER = 1, THUMB = 2, BOTTOM_LEFT = 3, BOTTOM_RIGHT = 4, TOP_LEFT = 5, TOP_RIGHT = 6, BASE_TL = 7, BASE_TR = 8, BASE_L = 9, BASE_R = 10, BASE_BL = 11, BASE_BR = 12;
	public LogitechExtreme3(int port){super(port, NUM_BUTTONS, NUM_AXES);}
	public int getThumbstick(){return isConnected() ? getPOV() : -1;}
	public ThumbstickButton thumbstick(int direction){return new ThumbstickButton(direction);}
	/**A button representing the D-Pad being pushed to a certain direction (or not pushed at all).*/
	public class ThumbstickButton extends BaseButton{
		public static final int ANY_VALUE = -2, NO_VALUE = -1, NORTH = 0, NORTHWEST = 45, WEST = 90, SOUTHWEST = 135, SOUTH = 180,
				SOUTHEAST = 225, EAST = 270, NORTHEAST = 315;
		private final int dir;
		public ThumbstickButton(int dir){
			super(); this.dir = dir;
			if(dir != ANY_VALUE && dir != NO_VALUE && dir != NORTH && dir != NORTHWEST && dir != WEST && dir != SOUTHWEST
					&& dir != SOUTH && dir != SOUTHEAST && dir != EAST && dir != NORTHEAST)
				Robot.log(this, "Button created with invalid direction that will never be triggered: " + dir);
		}
		public boolean get(){
			int value = LogitechExtreme3.this.getPOV();
			if(dir == ANY_VALUE && value != NO_VALUE) return true;
			else return dir == value;
		}
	}
}
