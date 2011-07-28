package me.simplex.pluginkickstarter.generator;

import java.util.ArrayList;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.storage.CommandContainer;
import me.simplex.pluginkickstarter.storage.ConfigurationNodeContainer;
import me.simplex.pluginkickstarter.storage.ListenerContainer;
import me.simplex.pluginkickstarter.storage.TaskContainer;
import me.simplex.pluginkickstarter.util.ConfigNodeDataType;
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
				if (con.getFile().equals(type)) {
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
		//General
		ret=ret+"	private Logger log;\n";
		ret=ret+"	private PluginDescriptionFile description;\n";
		
		// Config
		if (main.getData().isGen_configuration()) {
			ret=ret+"	private Configuration configuration;";
			for (ConfigurationNodeContainer c : main.getData().getConfigNodes()) {
				switch (c.getType()) {
					case BOOLEAN: 		ret=ret+"	private boolean "+buildConfigVarName(c)+";\n"; break;
					case BOOLEAN_LIST: 	ret=ret+"	private ArrayList<Boolean> "+buildConfigVarName(c)+";\n"; break;
					case DOUBLE: 		ret=ret+"	private double "+buildConfigVarName(c)+";\n"; break;
					case DOUBLE_LIST: 	ret=ret+"	private ArrayList<Double> "+buildConfigVarName(c)+";\n"; break;
					case INT: 			ret=ret+"	private int "+buildConfigVarName(c)+";\n"; break;
					case INT_LIST: 		ret=ret+"	private ArrayList<Integer> "+buildConfigVarName(c)+";\n"; break;
					case STRING:		ret=ret+"	private String "+buildConfigVarName(c)+";\n"; break;
					case STRING_LIST:	ret=ret+"	private ArrayList<String> "+buildConfigVarName(c)+";\n"; break;
				}
			}
		}
		
		// Listeners
		for (ListenerType t : types_to_handle) {
			ret=ret+"	private Listener_"+StringToClassName(t.toString())+" listener"+StringToClassName(t.toString())+";\n";
		}

		return ret;
	}
	
	public String buildInit(){
		String ret ="";
		
		//general
		ret=ret+"		log = Logger.getLogger(\"Minecraft\");\n";
		ret=ret+"		description = getDescription();\n";	
		
		ret=ret+"		log.info(\"loading \"+description.getFullName());\n";
		// Config
		if (main.getData().isGen_configuration() && main.getData().getConfigNodes().size() > 0) {
			ret=ret+"		configuration = setupConfiguration();\n";
		}
		
		// Listeners
		for (ListenerType t : types_to_handle) {
			ret=ret+"		listener"+StringToClassName(t.toString())+" = new Listener_"+StringToClassName(t.toString())+"(this);\n";
		}
		return ret; 
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
					case AsyncTask: 			ret=ret+  "		getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+task.getTaskname()+"(this));\n";break;
					case AsyncDelayedTask: 		ret=ret+  "		getServer().getScheduler().scheduleAsyncDelayedTask(this, new "+task.getTaskname()+"(this),"+task.getPeriod()+");\n";break;
					case AsyncRepeatingTask: 	ret=ret+  "		getServer().getScheduler().scheduleAsyncRepeatingTask(this, new "+task.getTaskname()+"(this)), "+task.getPeriod()+", "+task.getPeriod()+");\n";break;
					case SyncTask:				ret=ret+  "		getServer().getScheduler().scheduleSyncDelayedTask(this, new "+task.getTaskname()+"(this));\n";break;
					case SyncDelayedTask:		ret=ret+  "		getServer().getScheduler().scheduleSyncDelayedTask(this, new "+task.getTaskname()+"(this),"+task.getPeriod()+");\n";break;
					case SyncRepeatingTask: 	ret=ret+  "		getServer().getScheduler().scheduleSyncRepeatingTask(this, new "+task.getTaskname()+"(this)), "+task.getPeriod()+", "+task.getPeriod()+");\n";break;
					default: break;
				}
			}
		}
		return ret;
	}
	
	public String buildImports(){
		String ret="";
		//general imports
		ret=ret+"import java.util.logging.Logger;\n";
		ret=ret+"import org.bukkit.plugin.PluginDescriptionFile;\n";
		
		//Config Imports
		if (main.getData().isGen_configuration()) {
			for (ConfigurationNodeContainer c : main.getData().getConfigNodes()) {
				ConfigNodeDataType t=c.getType();
				if (t.equals(ConfigNodeDataType.BOOLEAN_LIST) || t.equals(ConfigNodeDataType.DOUBLE_LIST)|| t.equals(ConfigNodeDataType.INT_LIST)|| t.equals(ConfigNodeDataType.STRING_LIST)) {
					ret=ret+"import java.util.ArrayList;\n";
					break;
				}
			}
			ret=ret+"import org.bukkit.util.config.Configuration;\n";
		}
		//Command Imports
		for (CommandContainer c : main.getData().getCommands()) {
			ret=ret+"import me."+ main.getData().getAuthor().toLowerCase()+"."+ main.getData().getPluginname().toLowerCase()+".commands.CommandExecutor_"+StringToClassName(c.getCommand())+";\n";
		}
		
		//Task Imports
		for (TaskContainer task : main.getData().getTasks()) {
			if (task.isRegisterAtOnEnable()) {
				ret=ret+"import me."+ main.getData().getAuthor().toLowerCase()+"."+ main.getData().getPluginname().toLowerCase()+".tasks.Task_"+StringToClassName(task.getTaskname())+";\n";
			}
		}
		
		//Listener Imports
		if (types_to_handle.size() > 0) {
			ret=ret+"import org.bukkit.event.Event.Priority;\n";
			ret=ret+"import org.bukkit.event.Event.Type;\n";		
			for (ListenerType t : types_to_handle) {
				ret=ret+"import "+buildPackage(TemplateType.Listener, false).toLowerCase()+"."+StringToClassName(t.toString())+";\n";
			}
		}
		
		return ret; 
	}
	
	public String buildDisable(){
		return 	"		log.info(\"disabled \"+description.getFullName());\n";
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

		return ret;
	}
	
	private String buildCfgGetString(ConfigurationNodeContainer c){
		switch (c.getType()) {
		case BOOLEAN: return "		"+buildConfigVarName(c)+"cfg.getBoolean(\""+c.getNode()+"\", "+c.getDefaultValue()+");\n";
		case BOOLEAN_LIST: return buildListInit(c);
		case DOUBLE: return "		"+buildConfigVarName(c)+"cfg.getDouble(\""+c.getNode()+"\", "+c.getDefaultValue()+");\n";
		case DOUBLE_LIST: return buildListInit(c);
		case INT: return "		"+buildConfigVarName(c)+"cfg.getInt(\""+c.getNode()+"\", "+c.getDefaultValue()+");\n";
		case INT_LIST: return buildListInit(c);
		case STRING: return "		"+buildConfigVarName(c)+"cfg.getString(\""+c.getNode()+"\", "+c.getDefaultValue()+");\n";
		case STRING_LIST: return buildListInit(c);
		}
		return "";
	}
	
	private String buildConfigVarName(ConfigurationNodeContainer c){
		return "config_"+c.getNode().replace(".", "_").toLowerCase()+";\n"; 
	}
	
	private String buildListInit(ConfigurationNodeContainer c){
		String ret ="";
		switch (c.getType()) {
		case BOOLEAN_LIST:
			ret=ret+ "		ArrayList<Boolean> init_"+c.getDefaultValue().replace(".", "_")+" = new ArrayList<Boolean>();\n";
			for (String listinit : c.getDefaultValue().split(",")) {
				ret=ret+"		init_"+c.getDefaultValue().replace(".", "_")+".add("+listinit.trim()+");\n";
			}
			ret=ret+"		"+buildConfigVarName(c)+"cfg.getBooleanList(\""+c.getNode()+"\", init_"+c.getDefaultValue().replace(".", "_")+");\n";
			break;
		case DOUBLE_LIST: 	
			ret=ret+ "		ArrayList<Double> init_"+c.getDefaultValue().replace(".", "_")+" =new ArrayList<Double>(\""+c.getDefaultValue()+"\".split(\",\"));\n";
			for (String listinit : c.getDefaultValue().split(",")) {
				ret=ret+"		init_"+c.getDefaultValue().replace(".", "_")+".add("+listinit.trim()+");\n";
			}
			ret=ret+"		"+buildConfigVarName(c)+"cfg.getDoubleList(\""+c.getNode()+"\", init_"+c.getDefaultValue().replace(".", "_")+");\n";
			break;
		case INT_LIST:		
			ret=ret+ "		ArrayList<Integer> init_"+c.getDefaultValue().replace(".", "_")+" = new ArrayList<Integer>(\""+c.getDefaultValue()+"\".split(\",\"));\n";
			for (String listinit : c.getDefaultValue().split(",")) {
				ret=ret+"		init_"+c.getDefaultValue().replace(".", "_")+".add("+listinit.trim()+");\n";
			}
			ret=ret+"		"+buildConfigVarName(c)+"cfg.getIntList(\""+c.getNode()+"\", init_"+c.getDefaultValue().replace(".", "_")+");\n";
			break;
		case STRING_LIST:	
			ret=ret+ "		ArrayList<String> init_"+c.getDefaultValue().replace(".", "_")+" =new ArrayList<String>(\""+c.getDefaultValue()+"\".split(\",\"));\n";
			for (String listinit : c.getDefaultValue().split(",")) {
				ret=ret+"		init_"+c.getDefaultValue().replace(".", "_")+".add(\""+listinit.trim()+"\");\n";
			}
			ret=ret+"		"+buildConfigVarName(c)+"cfg.getStringList(\""+c.getNode()+"\", init_"+c.getDefaultValue().replace(".", "_")+");\n";
			break;
		}
		return ret;
	}
		
	public String buildConfigGetter(){
		String ret ="";
		if (main.getData().isGen_configuration()) {
			for (ConfigurationNodeContainer c : main.getData().getConfigNodes()) {
				switch (c.getType()) {
				case BOOLEAN: 		
					ret=ret+"	public boolean get"+StringToClassName(buildConfigVarName(c))+"(){\n";
					ret=ret+"		return "+buildConfigVarName(c)+";\n";
					ret=ret+"	}\n\n";
					break;
				case BOOLEAN_LIST: 
					ret=ret+"	public ArrayList<Boolean> get"+StringToClassName(buildConfigVarName(c))+"(){\n";
					ret=ret+"		return "+buildConfigVarName(c)+";\n";
					ret=ret+"	}\n\n";
					break;
				case DOUBLE:
					ret=ret+"	public double get"+StringToClassName(buildConfigVarName(c))+"(){\n";
					ret=ret+"		return "+buildConfigVarName(c)+";\n";
					ret=ret+"	}\n\n";
					break;
				case DOUBLE_LIST:
					ret=ret+"	public ArrayList<Double> get"+StringToClassName(buildConfigVarName(c))+"(){\n";
					ret=ret+"		return "+buildConfigVarName(c)+";\n";
					ret=ret+"	}\n\n";
					break;
				case INT: 	
					ret=ret+"	public int get"+StringToClassName(buildConfigVarName(c))+"(){\n";
					ret=ret+"		return "+buildConfigVarName(c)+";\n";
					ret=ret+"	}\n\n";
					break;
				case INT_LIST:
					ret=ret+"	public ArrayList<Integer> get"+StringToClassName(buildConfigVarName(c))+"(){\n";
					ret=ret+"		return "+buildConfigVarName(c)+";\n";
					ret=ret+"	}\n\n";
					break;
				case STRING:
					ret=ret+"	public String get"+StringToClassName(buildConfigVarName(c))+"(){\n";
					ret=ret+"		return "+buildConfigVarName(c)+";\n";
					ret=ret+"	}\n\n";
					break;
				case STRING_LIST:
					ret=ret+"	public ArrayList<String> get"+StringToClassName(buildConfigVarName(c))+"(){\n";
					ret=ret+"		return "+buildConfigVarName(c)+";\n";
					ret=ret+"	}\n\n";
					break;
				}
			}	
		}
		return ret;
	}

	@Override
	public String buildClassname() {
		return StringToClassName(main.getData().getPluginname());
	}
}
