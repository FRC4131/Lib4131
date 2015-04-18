package org.usfirst.frc.team4131.lib.commands;

import org.usfirst.frc.team4131.lib.Robot;
import org.usfirst.frc.team4131.lib.subsystems.Component;

import edu.wpi.first.wpilibj.command.Command;

public abstract class BaseCommand extends Command{
	private Component[] components;
	public BaseCommand(Component... components){
		super();
		this.components = components;
		for(Component component : components) requires(component);
	}
	@Override protected void initialize(){Robot.log(this, "Starting");}
	@Override
	protected void end(){
		stop();
		for(Component component : components) component.stop();
		Robot.log(this, "Ending");
	}
	@Override
	protected void interrupted(){
		stop();
		for(Component component : components) component.stop();
		Robot.log(this, "Interrupted");
	}
	protected void stop(){}
}
