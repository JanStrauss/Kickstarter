package me.simplex.pluginkickstarter.storage;

import me.simplex.pluginkickstarter.DataStorage;
import me.simplex.pluginkickstarter.util.TaskType;

public class TaskStorage {
	private DataStorage storage;
	private String taskname;
	private TaskType type;
	private long offset;
	private long delay;
	private boolean registerAtOnEnable;
	
	public TaskStorage(String taskname, TaskType type, long offset, long delay,boolean registerAtOnEnable, DataStorage storage) {
		this.storage = storage;
		this.taskname = taskname;
		this.type = type;
		this.offset = offset;
		this.delay = delay;
		this.registerAtOnEnable = registerAtOnEnable;
	}
	
	public String buildRegisterString(){
		String ret="";
		switch (type) {
			case AsyncTask: 			ret = "this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+taskname+"(this))";break;
			case AsyncDelayedTask: 		ret = "this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+taskname+"(this),"+offset+")";break;
			case AsyncRepeatingTask: 	ret = "this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new "+taskname+"(this)), "+offset+", "+delay+");";break;
			case SyncTask:				ret = "this.getServer().getScheduler().scheduleSyncDelayedTask(this, new "+taskname+"(this))";break;
			case SyncDeplayedTask:		ret = "this.getServer().getScheduler().scheduleSyncDelayedTask(this, new "+taskname+"(this),"+offset+")";break;
			case SyncRepeatingTask: 	ret = "this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new "+taskname+"(this)), "+offset+", "+delay+");";break;
		}
		return ret;
	}
	
	public String buildImportString(){
		return "import me."+storage.getAuthor()+"."+storage.getPluginname().toLowerCase()+".tasks."+taskname;
	}
	
	public boolean isRegisterAtOnEnable() {
		return registerAtOnEnable;
	}
}
