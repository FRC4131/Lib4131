package org.usfirst.frc.team4131.lib.commands;

import edu.wpi.first.wpilibj.Timer;

public class WaitCommand extends BaseCommand{
	private Timer timer = new Timer();
	private double delay;
	public WaitCommand(double delay){
		super();
		this.delay = delay;
	}
	@Override
	protected void initialize(){
		super.initialize();
		timer.reset();
		timer.start();
	}
	@Override protected void execute(){}
	@Override protected boolean isFinished(){return timer.get() >= delay;}
	@Override protected void stop(){timer.stop();}
}
