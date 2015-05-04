package org.usfirst.frc.team4131.lib.commands;

import org.usfirst.frc.team4131.lib.components.Component;

public class OverrideCommand extends InstantCommand{
	private Component[] components;
	public OverrideCommand(Component... components){
		super();
		this.components = components;
		for(Component component : components) requires(component);
	}
	@Override public void activate(){for(Component component : components) component.stop();}
}
