package org.usfirst.frc.team4131.lib.commands;

import org.usfirst.frc.team4131.lib.components.Component;

public abstract class DefaultCommand extends BaseCommand{
	public DefaultCommand(Component component){super(component);}
	@Override protected boolean isFinished(){return false;}
}
