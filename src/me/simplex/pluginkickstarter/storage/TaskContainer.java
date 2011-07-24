package me.simplex.pluginkickstarter.storage;

import me.simplex.pluginkickstarter.DataStorage;
import me.simplex.pluginkickstarter.util.TaskType;

public class TaskContainer {
	private DataStorage storage;
	private String taskname;
	private TaskType type;
	private long offset;
	private long delay;
	private boolean registerAtOnEnable;
	
	public TaskContainer(String taskname, TaskType type, long offset, long delay,boolean registerAtOnEnable, DataStorage storage) {
		this.storage = storage;
		this.taskname = taskname;
		this.type = type;
		this.offset = offset;
		this.delay = delay;
		this.registerAtOnEnable = registerAtOnEnable;
	}
	
	public DataStorage getStorage() {
		return storage;
	}


	public String getTaskname() {
		return taskname;
	}


	public TaskType getType() {
		return type;
	}


	public long getOffset() {
		return offset;
	}


	public long getDelay() {
		return delay;
	}


	public boolean isRegisterAtOnEnable() {
		return registerAtOnEnable;
	}
}
