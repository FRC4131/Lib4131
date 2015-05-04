package org.usfirst.frc.team4131.lib.commands;

public abstract class InstantCommand extends BaseCommand{
	protected boolean hasRun = false;
	@Override protected void initialize(){super.initialize(); hasRun = false;}
	@Override protected void execute(){activate(); hasRun = true;}
	protected abstract void activate();
	@Override protected boolean isFinished(){return hasRun;}
}
