package org.usfirst.frc.team4131.lib.commands;

import org.usfirst.frc.team4131.lib.Robot;

public class LogCommand extends InstantCommand{
	private Object logger;
	private String message;
	public LogCommand(Object logger, String message){
		super();
		this.logger = logger;
		this.message = message;
	}
	@Override public void activate(){Robot.log(logger, message);}
}
