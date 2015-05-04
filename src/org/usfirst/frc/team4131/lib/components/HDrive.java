package org.usfirst.frc.team4131.lib.components;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;

public class HDrive extends Component{
	protected SpeedController[] motors;
	protected RobotDrive drive;
	public HDrive(SpeedController left, SpeedController right, Command defCommand){
		super(defCommand);
		motors = new SpeedController[]{left, right};
		drive = new RobotDrive(left, right);
	}
	public HDrive(SpeedController lf, SpeedController lb, SpeedController rf, SpeedController rb, Command defCommand){
		super(defCommand);
		motors = new SpeedController[]{lf, lb, rf, rb};
		drive = new RobotDrive(lf, lb, rf, rb);
	}
	public void tank(double left, double right){drive.tankDrive(left, right);}
	public void arcade(double power, double turn){drive.arcadeDrive(power, turn);}
	public void arcade(double x, double y, double gyro){
		double power = Math.sqrt(x*x + y*y),//Polar magnitude
				target = Math.toDegrees(Math.atan2(-y, x));//Polar direction
		gyro = wrap(gyro, -180, 180);
		double angle1 = target - gyro, angle2 = gyro - target, angle;
		if(Math.abs(angle1) < Math.abs(angle2)) angle = angle1; else angle = angle2;//min() that doesn't care about sign
		drive.arcadeDrive(power, constrain(angle/90, -1, 1));//Scaling: 90 degrees off or more, and it will do a full-power turn.
	} 
	@Override public void stop(){for(SpeedController motor : motors) motor.set(0);}
	private static double wrap(double val, double min, double max){
		double range = max - min;
		while(val < min) val += range;
		while(val >= max) val -= range;
		return val;
	}
	private static double constrain(double val, double min, double max){return Math.max(Math.min(val, max), min);}
}
