package org.usfirst.frc.team4131.lib.components;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class MecanumDrive extends HDrive{
	public MecanumDrive(SpeedController lf, SpeedController lb, SpeedController rf, SpeedController rb, Command defCommand){
		super(lf, lb, rf, rb, defCommand);
	}
	public void mecanumCartesian(double x, double y, double rotation){drive.mecanumDrive_Cartesian(x, y, rotation, 0);}
	public void mecanumCartesian(double x, double y, double turn, double rotation){drive.mecanumDrive_Cartesian(x, y, turn, rotation);}
	public void mecanumPolar(double power, double direction, double rotation){drive.mecanumDrive_Polar(power, direction, rotation);}
	public void mecanumPolar(double power, double direction, double rotation, double gyro){
		drive.mecanumDrive_Polar(power, (direction - gyro) / 90, rotation);
	}
	@Override public void stop(){for(SpeedController motor : motors) motor.set(0);}
}
