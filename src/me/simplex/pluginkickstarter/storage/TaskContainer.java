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
	
	public String buildRegisterString(){
		switch (type) {
			case AsyncTask: 			return "this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+taskname+"(this))";
			case AsyncDelayedTask: 		return "this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+taskname+"(this),"+offset+")";
			case AsyncRepeatingTask: 	return "this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new "+taskname+"(this)), "+offset+", "+delay+");";
			case SyncTask:				return "this.getServer().getScheduler().scheduleSyncDelayedTask(this, new "+taskname+"(this))";
			case SyncDeplayedTask:		return "this.getServer().getScheduler().scheduleSyncDelayedTask(this, new "+taskname+"(this),"+offset+")";
			case SyncRepeatingTask: 	return "this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new "+taskname+"(this)), "+offset+", "+delay+");";
			default: return null;
		}
	}
	
	public String buildImportString(){
		return "import me."+storage.getAuthor()+"."+storage.getPluginname().toLowerCase()+".tasks."+taskname;
	}
	
	public boolean isRegisterAtOnEnable() {
		return registerAtOnEnable;
	}
}
