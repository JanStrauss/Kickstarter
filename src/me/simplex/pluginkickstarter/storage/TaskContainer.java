package me.simplex.pluginkickstarter.storage;

import me.simplex.pluginkickstarter.util.TaskType;

public class TaskContainer {
	private String taskname;
	private TaskType type;
	private long period;
	private long delay;
	private boolean registerAtOnEnable;
	
	public String getTaskname() {
		return taskname;
	}
	public TaskType getType() {
		return type;
	}

	public long getPeriod() {
		return period;
	}


	public long getDelay() {
		return delay;
	}

	public boolean isRegisterAtOnEnable() {
		return registerAtOnEnable;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public void setType(TaskType type) {
		this.type = type;
	}
	public void setPeriod(long offset) {
		this.period = offset;
	}
	public void setDelay(long delay) {
		this.delay = delay;
	}
	public void setRegisterAtOnEnable(boolean registerAtOnEnable) {
		this.registerAtOnEnable = registerAtOnEnable;
	}
	
	
}
