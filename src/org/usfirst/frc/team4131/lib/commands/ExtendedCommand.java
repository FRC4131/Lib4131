package org.usfirst.frc.team4131.lib.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExtendedCommand extends CommandGroup{
	public ExtendedCommand(double length, Command... commands){
		super();
		for(Command command : commands) addParallel(command);
		addSequential(new WaitCommand(length));
	}
}
