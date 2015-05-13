package org.usfirst.frc.team4131.lib.oi;

import org.usfirst.frc.team4131.lib.Robot;
import org.usfirst.frc.team4131.lib.commands.BaseCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 * A template for everything on the driver station. Game controllers, joysticks, Launchpad boards, you name it, it extends this. 
 */
public abstract class BaseController extends Joystick{
	public final int port;
	private final int buttons, axes;
	/**
	 * @param port The port shown in Driver Station that the controller is on, 0-5. It is recommended that subclasses allow this to be passed in. 
	 * @param buttons Number of buttons supported by the controller. Can be found in Driver Station.
	 * @param axes Number of axes supported by the controller. Can be found in Driver Station.
	 */
	public BaseController(int port, int buttons, int axes){super(port); this.port = port; this.buttons = buttons; this.axes = axes;}
	public boolean getButton(int button){return isConnected() && getRawButton(button);}
	public double getAxis(int axis){return isConnected() ? getRawAxis(axis) : 0;}
	public boolean isConnected(){return DriverStation.getInstance().getStickAxisCount(port) == axes &&
			DriverStation.getInstance().getStickButtonCount(port) == buttons;}
	//Utility button methods
	public ControllerButton button(int button){return new ControllerButton(button);}
	public AxisButton axis(int axis, double threshold, int condition){return new AxisButton(axis, threshold, condition);}
	//Base class for button subclasses
	public abstract class BaseButton extends Button{
		/**
		 * Register the given command to run when the condition is first passed.
		 * {@link BaseCommand#start() start()} is called when the condition is passed, and the command is left to run.
		 * @param command The command to start when passed
		 * @return this, for chaining
		 */
		public BaseButton onPress(Command command){whenPressed(command); return this;}
		/**
		 * Register the given command to run while the condition is being passed.
		 * {@link BaseCommand#execute() execute()} is called when repeatedly while the condition is passed.
		 * @param command The command to run while passing
		 * @return this, for chaining
		 */
		public BaseButton whilePressed(Command command){whileActive(command); return this;}
		/**
		 * Register the given command to run when the condition is first failed.
		 * {@link BaseCommand#start() start()} is called when the condition is failed, and the command is left to run.
		 * @param command The command to start when failed
		 * @return this, for chaining
		 */
		public BaseButton onRelease(Command command){whenReleased(command); return this;}
	}
	//Button subclasses for various controller components
	/**A button representing a button being pressed.*/
	public class ControllerButton extends BaseButton{
		private int button;
		private ControllerButton(int button){super(); this.button = button;}
		@Override public boolean get(){return BaseController.this.getButton(button);}
	}
	/**A button representing an axis passing a condition (ie equal to, less than, etc.) relative to a given value.*/ 
	public class AxisButton extends BaseButton{
		/**Condition: {@link #get() get()} returns {@code true} if axis value is equal to given threshold.*/
		private static final int EQUAL = 0;
		/**Condition: {@link #get() get()} returns {@code true} if axis value is greater than the given threshold.*/
		public static final int GREATER = 1;
		/**Condition: {@link #get() get()} returns {@code true} if axis value is less than given threshold.*/
		public static final int LESS = 2;
		/**Condition: {@link #get() get()} returns {@code true} if axis value is greater than or equal to the given threshold.*/
		public static final int GREATER_OR_EQUAL = 3;
		/**Condition: {@link #get() get()} returns {@code true} if axis value is less than or equal to the given threshold.*/
		public static final int LESS_OR_EQUAL = 4;
		/**Condition: {@link #get() get()} returns {@code true} if axis value is not equal to the given threshold.*/
		public static final int UNEQUAL = 5;
		private int axis, condition;
		private double threshold;
		private AxisButton(int axis, double threshold, int condition){
			super(); this.axis = axis; this.condition = condition; this.threshold = threshold;
			if(condition != EQUAL && condition != GREATER && condition != LESS && condition != GREATER_OR_EQUAL &&
					condition != LESS_OR_EQUAL && condition != LESS_OR_EQUAL)
				Robot.log(this, "Button created with invalid condition that will never be triggered: " + condition);
		}
		public boolean get(){
			double value = BaseController.this.getAxis(axis);
			switch(condition){
				case(EQUAL): return value == threshold;
				case(GREATER): return value > threshold;
				case(LESS): return value < threshold;
				case(GREATER_OR_EQUAL): return value >= threshold;
				case(LESS_OR_EQUAL): return value <= threshold;
				case(UNEQUAL): return value != threshold;
				default: return false;
			}
		}
	}
}
