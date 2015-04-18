package org.usfirst.frc.team4131.lib;

import java.util.Calendar;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public abstract class Robot extends IterativeRobot{
	protected Command autonomous;
	protected Robot(Command autonomous){super(); this.autonomous = autonomous;}
	public void robotInit(){}
	public void autonomousInit(){if(autonomous != null) autonomous.start();}
	public void autonomousPeriodic(){Scheduler.getInstance().run();}
	public void teleopInit(){if(autonomous != null) autonomous.cancel();}
	public void teleopPeriodic(){Scheduler.getInstance().run();}
	public void testPeriodic(){LiveWindow.run();}
	public void disabledInit(){}
	public void disabledPeriodic(){Scheduler.getInstance().run();}
	/**
	 * Log a message for the Riolog tool to see.
	 * @param logger The object logging: passing in "this" will do most of the time. Passing null will cause an exception. The object's
	 * {@link java.lang.Object#toString() toString} will be part of the log.
	 * @param message The message to log.
	 */
	public static void log(Object logger, String message){
		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int milli = now.get(Calendar.MILLISECOND);
		System.out.println(String.format("LOG (%02d:%02d:%02d.%03d) -> %s: %s", hour, minute, second, milli, logger.getClass().getSimpleName(), message));
	}

}
