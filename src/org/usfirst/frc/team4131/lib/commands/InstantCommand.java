package org.usfirst.frc.team4131.lib.commands;

import org.usfirst.frc.team4131.lib.components.Component;

public abstract class InstantCommand extends BaseCommand{
	protected boolean hasRun = false;
	public InstantCommand(Component... components){super(components);}
	@Override protected void initialize(){super.initialize(); hasRun = false;}
	@Override protected void execute(){activate(); hasRun = true;}
	protected abstract void activate();
	@Override protected boolean isFinished(){return hasRun;}
}
