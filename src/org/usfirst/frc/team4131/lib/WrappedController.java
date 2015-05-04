package org.usfirst.frc.team4131.lib;

import edu.wpi.first.wpilibj.SpeedController;

public class WrappedController implements SpeedController{
	private SpeedController motor;
	private double mult;
	public WrappedController(SpeedController motor, double mult){
		this.motor = motor;
		this.mult = mult;
	}
	@Override public void pidWrite(double output){motor.pidWrite(output * mult);}
	@Override public double get(){return motor.get();}
	@Override public void set(double speed, byte syncGroup){motor.set(speed * mult, syncGroup);}
	@Override public void set(double speed){motor.set(speed * mult);}
	@Override public void disable(){motor.disable();}
}
