package me.simplex.pluginkickstarter.generator;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.storage.TaskContainer;

public class GenTask extends Generator {
	private TaskContainer container;
	
	public GenTask(PluginKickstarter main, TaskContainer container) {
		super(main);
		this.container = container;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String buildClassname() {
		return "Task_"+StringToClassName(container.getTaskname());
	}

}
