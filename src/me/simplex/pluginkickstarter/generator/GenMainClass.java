package me.simplex.pluginkickstarter.generator;

import java.util.ArrayList;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.storage.CommandContainer;
import me.simplex.pluginkickstarter.storage.ConfigurationNodeContainer;
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
		// Config
		if (main.getData().isGen_configuration()) {
			ret=ret+"private Configuration configuration;";
		}
		
		// Listeners
		for (ListenerType t : types_to_handle) {
			ret=ret+"private Listener_"+StringToClassName(t.toString())+" listener"+StringToClassName(t.toString())+";\n";
		}

		return ret; //TODO
	}
	
	public String buildInit(){
		String ret ="";
		
		// Config
		if (main.getData().isGen_configuration()) {
			ret=ret+"		configuration = setupConfiguration();";
		}
		
		// Listeners
		for (ListenerType t : types_to_handle) {
			ret=ret+"		listener"+StringToClassName(t.toString())+" = new Listener_"+StringToClassName(t.toString())+"(this);\n";
		}
		return ret; //TODO
	}
	
	public String buildRegister_Events(){
		String ret = "";
		for (ListenerContainer c : main.getData().getListener()) {
			ret=ret+"		getServer().getPluginManager().registerEvent("+c.getType()+", listener"+StringToClassName(c.getFile().toString())+", Priority."+c.getPriority().toString()+", this);\n";
		}
		return ret;
	}
	
	public String buildRegister_Commands(){
		String commandRegisters = "";
		for (CommandContainer c : main.getData().getCommands()) {
			commandRegisters = commandRegisters + "		getCommand("+c.getCommand().toLowerCase()+").setExecutor(new "+"CommandExecutor_"+StringToClassName(c.getCommand())+"());\n";
		}
		return commandRegisters;
	}
	
	public String buildSchedule_Tasks(){
		String ret="";
		for (TaskContainer task : main.getData().getTasks()) {
			if (task.isRegisterAtOnEnable()) {
				switch (task.getType()) {
					case AsyncTask: 			return "		getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+task.getTaskname()+"(this))";
					case AsyncDelayedTask: 		return "		getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+task.getTaskname()+"(this),"+task.getPeriod()+")";
					case AsyncRepeatingTask: 	return "		getServer().getScheduler().scheduleAsyncRepeatingTask(this, new "+task.getTaskname()+"(this)), "+task.getPeriod()+", "+task.getPeriod()+");";
					case SyncTask:				return "		getServer().getScheduler().scheduleSyncDelayedTask(this, new "+task.getTaskname()+"(this))";
					case SyncDelayedTask:		return "		getServer().getScheduler().scheduleSyncDelayedTask(this, new "+task.getTaskname()+"(this),"+task.getPeriod()+")";
					case SyncRepeatingTask: 	return "		getServer().getScheduler().scheduleSyncRepeatingTask(this, new "+task.getTaskname()+"(this)), "+task.getPeriod()+", "+task.getPeriod()+");";
					default: return null;
				}
			}
		}
		return ret;
	}
	
	public String buildImports(){
		String ret="";
		
		//Config Imports
		if (main.getData().isGen_configuration()) {
			ret=ret+"import org.bukkit.util.config.Configuration;\n";
		}
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
	
	public String buildSetupConfig(){
		String ret="";
		if (main.getData().isGen_configuration()) {
			ret=ret+"	private Configuration setupConfig(){\n";
			ret=ret+"		Configuration cfg = getConfiguration();\n";
			ret=ret+"		\n";
			ret=ret+"		cfg.setHeader(\"#"+main.getData().getCfgfileheader()+"\");\n";
			ret=ret+"		\n";
			for (ConfigurationNodeContainer c : main.getData().getConfigNodes()) {
				ret=ret+buildCfgGetString(c);
			}
			ret=ret+"		\n";
			ret=ret+"		cfg.save();\n";
			ret=ret+"		return cfg;\n";
			ret=ret+"	}\n";
		}

		return ret; //TODO
	}
	
	private String buildCfgGetString(ConfigurationNodeContainer c){
		switch (c.getType()) {
		case BOOLEAN: return "		cfg.getBoolean(\""+c.getNode()+"\", "+c.getDefaultValue()+");";
		case BOOLEAN_LIST: return "";
		case DOUBLE: return "		cfg.getDouble(\""+c.getNode()+"\", "+c.getDefaultValue()+");";
		case DOUBLE_LIST: return "";
		case INT: return "		cfg.getInt(\""+c.getNode()+"\", "+c.getDefaultValue()+");";
		case INT_LIST: return "";
		case STRING: return "		cfg.getString(\""+c.getNode()+"\", "+c.getDefaultValue()+");";
		case STRING_LIST: return "";
		}
		return "";
	}
		
	public String buildConfigGetter(){
		String ret ="";
		if (main.getData().isGen_configuration()) {

		}
		return ret; //TODO
	}

	@Override
	public String buildClassname() {
		return StringToClassName(main.getData().getPluginname());
	}
}
