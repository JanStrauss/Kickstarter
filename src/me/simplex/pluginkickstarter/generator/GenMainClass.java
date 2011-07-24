package me.simplex.pluginkickstarter.generator;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.storage.CommandContainer;
import me.simplex.pluginkickstarter.storage.TaskContainer;

public class GenMainClass extends Generator {

	public GenMainClass(PluginKickstarter main) {
		super(main);
	}
	
	public String buildVariables(){
		return ""; //TODO
	}
	
	public String buildInit(){
		return ""; //TODO
	}
	
	public String buildRegister_Events(){
		return ""; //TODO
	}
	
	public String buildRegister_Commands(){
		String commandRegisters = "";
		for (CommandContainer c : main.getData().getCommands()) {
			commandRegisters = commandRegisters + "getCommand("+c.getCommand().toLowerCase()+").setExecutor(new "+"CommandExecutor_"+StringToClassName(c.getCommand())+"());\n";
		}
		return commandRegisters;
	}
	
	public String buildSchedule_Tasks(){
		String ret="";
		for (TaskContainer task : main.getData().getTasks()) {
			if (task.isRegisterAtOnEnable()) {
				switch (task.getType()) {
				case AsyncTask: 			return "this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+task.getTaskname()+"(this))";
				case AsyncDelayedTask: 		return "this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+task.getTaskname()+"(this),"+task.getOffset()+")";
				case AsyncRepeatingTask: 	return "this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new "+task.getTaskname()+"(this)), "+task.getOffset()+", "+task.getOffset()+");";
				case SyncTask:				return "this.getServer().getScheduler().scheduleSyncDelayedTask(this, new "+task.getTaskname()+"(this))";
				case SyncDeplayedTask:		return "this.getServer().getScheduler().scheduleSyncDelayedTask(this, new "+task.getTaskname()+"(this),"+task.getOffset()+")";
				case SyncRepeatingTask: 	return "this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new "+task.getTaskname()+"(this)), "+task.getOffset()+", "+task.getOffset()+");";
				default: return null;
			}
			}
		}
		return ret;
	}
	
	public String buildImports(){
		String ret="";
		
		//Command Imports
		for (CommandContainer c : main.getData().getCommands()) {
			ret=ret+"import me."+ main.getData().getAuthor()+"."+ main.getData().getPluginname().toLowerCase()+".commands."+StringToClassName(c.getCommand())+"";
		}
		
		//Task Imports
		for (TaskContainer task : main.getData().getTasks()) {
			if (task.isRegisterAtOnEnable()) {
				ret=ret+"import me."+ main.getData().getAuthor()+"."+ main.getData().getPluginname().toLowerCase()+".tasks."+StringToClassName(task.getTaskname())+"";
			}
		}
		return ret; //TODO
	}
	
	public String buildDisable(){
		return ""; //TODO
	}
	
	public String buildSetupPermissions(){
		return ""; //TODO
	}
	
	public String buildConfigChecks(){
		return ""; //TODO
	}
	
	public String buildGetterAndSetter(){
		return ""; //TODO
	}

	@Override
	public String buildClassname() {
		return StringToClassName(main.getData().getPluginname());
	}
}
