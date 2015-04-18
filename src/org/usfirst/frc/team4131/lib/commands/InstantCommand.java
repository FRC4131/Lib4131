package org.usfirst.frc.team4131.lib.commands;

public abstract class InstantCommand extends BaseCommand{
	protected boolean hasRun = false;
	@Override protected void initialize(){super.initialize(); hasRun = false;}
	@Override protected void execute(){hasRun = true;}
	@Override protected boolean isFinished(){return hasRun;}
}
