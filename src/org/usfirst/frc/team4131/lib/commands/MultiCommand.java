package org.usfirst.frc.team4131.lib.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MultiCommand extends CommandGroup{
	public static final Command ADD_SEQUENTIAL = null;
	public MultiCommand(Command... commands){
		super();
		for(int i=0;i<commands.length;i++)
			if(i >= commands.length-1 || commands[i+1] == ADD_SEQUENTIAL){
				addSequential(commands[i]);
				i++;//Skip the null command
			}else
				addParallel(commands[i]);
	}
}
