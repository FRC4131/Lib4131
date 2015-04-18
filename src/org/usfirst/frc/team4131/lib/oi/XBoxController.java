package org.usfirst.frc.team4131.lib.oi;

import org.usfirst.frc.team4131.lib.Robot;

public class XBoxController extends BaseController{
	/**Button numbers. Use in OI while calling {@link #getButton(int)} and {@link #button(int)}*/
	public static final int A=1, B=2, X=3, Y=4, LEFT_BUMPER=5, RIGHT_BUMPER=6, SCREEN_SELECT=7, MENU=8, LEFT_STICK=9, RIGHT_STICK=10;
	/**Axis numbers. Use in OI while calling {@link #getAxis(int)} and {@link #axis(int, double, int)} (first argument)*/
	public static final int LEFT_X=0, LEFT_Y=1, LEFT_TRIGGER=2, RIGHT_TRIGGER=3, RIGHT_X=4, RIGHT_Y=5;
	public static final int NUM_BUTTONS = 10, NUM_AXES = 6;
	public XBoxController(int port){super(port, NUM_BUTTONS, NUM_AXES);}
	//D-Pad stuff
	public int getDPad(){return isConnected() ? getPOV() : -1;}
	public DPadButton dPad(int direction){return new DPadButton(direction);}
	/**A button representing the D-Pad being pushed to a certain direction (or not pushed at all).*/
	public class DPadButton extends BaseButton{
		public static final int ANY_VALUE = -2, NO_VALUE = -1, NORTH = 0, NORTHWEST = 45, WEST = 90, SOUTHWEST = 135, SOUTH = 180,
				SOUTHEAST = 225, EAST = 270, NORTHEAST = 315;
		private final int dir;
		public DPadButton(int dir){
			super(); this.dir = dir;
			if(dir != ANY_VALUE && dir != NO_VALUE && dir != NORTH && dir != NORTHWEST && dir != WEST && dir != SOUTHWEST
					&& dir != SOUTH && dir != SOUTHEAST && dir != EAST && dir != NORTHEAST)
				Robot.log(this, "Button created with invalid direction that will never be triggered: " + dir);
		}
		public boolean get(){
			int value = XBoxController.this.getPOV();
			if(dir == ANY_VALUE && value != NO_VALUE) return true;
			else return dir == value;
		}
	}
}
