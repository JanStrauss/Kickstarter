package me.simplex.pluginkickstarter.generator;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.storage.TaskStorage;

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
		return ""; //TODO
	}
	
	public String buildStart_Tasks(){
		String ret="";
		for (TaskStorage task : main.getData().getTasks()) {
			if (task.isRegisterAtOnEnable()) {
				ret=ret+task.buildRegisterString()+"\n";
			}
		}
		return ret;
	}
	
	public String buildImports(){
		String ret="";
		
		//Task Imports
		for (TaskStorage task : main.getData().getTasks()) {
			if (task.isRegisterAtOnEnable()) {
				ret=ret+task.buildImportString()+"\n";
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
}
