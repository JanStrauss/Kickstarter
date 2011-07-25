package me.simplex.pluginkickstarter.generator;

import java.util.ArrayList;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.storage.CommandContainer;
import me.simplex.pluginkickstarter.storage.ListenerContainer;
import me.simplex.pluginkickstarter.storage.TaskContainer;
import me.simplex.pluginkickstarter.util.ListenerType;
import me.simplex.pluginkickstarter.util.TemplateType;

public class GenMainClass extends Generator {
	ArrayList<ListenerType> types_to_handle;
	
	public GenMainClass(PluginKickstarter main) {
		super(main);
		types_to_handle = new ArrayList<ListenerType>();
		int count = 0;
		for (ListenerType type : ListenerType.values()) {
			for (ListenerContainer con : main.getData().getListener()) {
				if (con.getType().equals(type)) {
					count++;
				}
			}
			if (count >0) {
				types_to_handle.add(type);
			}
			count = 0;
		}
	}
	
	public String buildVariables(){
		String ret ="";
		
		// BEGIN Listeners
		for (ListenerType t : types_to_handle) {
			ret=ret+"private Listener_"+StringToClassName(t.toString())+" listener"+StringToClassName(t.toString())+";\n";
		}

		return ret; //TODO
	}
	
	public String buildInit(){
		String ret ="";
		
		// BEGIN Listeners
		for (ListenerType t : types_to_handle) {
			ret=ret+"listener"+StringToClassName(t.toString())+" = new Listener_"+StringToClassName(t.toString())+"(this);\n";
		}
		return ret; //TODO
	}
	
	public String buildRegister_Events(){
		String ret = "";
		for (ListenerContainer c : main.getData().getListener()) {
			ret=ret+"getServer().getPluginManager().registerEvent("+c.getType()+", listener"+StringToClassName(c.getFile().toString())+", Priority."+c.getPriority().toString()+", this);\n";
		}
		return ret;
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
					case AsyncDelayedTask: 		return "this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+task.getTaskname()+"(this),"+task.getPeriod()+")";
					case AsyncRepeatingTask: 	return "this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new "+task.getTaskname()+"(this)), "+task.getPeriod()+", "+task.getPeriod()+");";
					case SyncTask:				return "this.getServer().getScheduler().scheduleSyncDelayedTask(this, new "+task.getTaskname()+"(this))";
					case SyncDeplayedTask:		return "this.getServer().getScheduler().scheduleSyncDelayedTask(this, new "+task.getTaskname()+"(this),"+task.getPeriod()+")";
					case SyncRepeatingTask: 	return "this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new "+task.getTaskname()+"(this)), "+task.getPeriod()+", "+task.getPeriod()+");";
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
		
		//Listener Imports
		if (types_to_handle.size() > 0) {
			ret=ret+"import org.bukkit.event.Event.Priority;\n";
			ret=ret+"import org.bukkit.event.Event.Type;\n";		
			for (ListenerType t : types_to_handle) {
				ret=ret+"import "+buildPackage(TemplateType.Listener)+"."+StringToClassName(t.toString())+";\n";
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
