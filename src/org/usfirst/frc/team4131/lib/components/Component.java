package org.usfirst.frc.team4131.lib.components;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class Component extends Subsystem{
	private Command defCommand;
	public Component(Command defCommand){super(); this.defCommand = defCommand;}
	protected void initDefaultCommand(){if(defCommand != null) setDefaultCommand(defCommand);}
	/**
	 * Stop the component in its tracks.
	 * This should be a call to each part of this component, setting it to the off or disabled state, etc stopping motors, retracting
	 * cylinders, etc. This is called when a command is ended or interrupted.
	 */
	public abstract void stop();
}
