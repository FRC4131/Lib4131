package org.usfirst.frc.team4131.lib;

import edu.wpi.first.wpilibj.SpeedController;

public class PseudoMotor implements SpeedController{
	private boolean inverted = false;
	private double value = 0;
	public PseudoMotor(){this(false);}
	public PseudoMotor(boolean inverted){setInverted(inverted);}
	@Override public void pidWrite(double output){value = output;}
	@Override public double get(){return value;}
	@Override public void set(double speed, byte syncGroup){value = speed;}
	@Override public void set(double speed){value = speed;}
	@Override public void disable(){value = 0;}
	@Override public void setInverted(boolean isInverted){inverted = isInverted;}
	@Override public boolean getInverted(){return inverted;}
	@Override public void stopMotor(){value = 0;}
}
