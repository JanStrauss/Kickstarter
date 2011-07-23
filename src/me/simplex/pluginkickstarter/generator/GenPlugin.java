package me.simplex.pluginkickstarter.generator;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.storage.CommandContainer;

public class GenPlugin extends Generator {

	public GenPlugin(PluginKickstarter main) {
		super(main);
	}
	
	public String buildPluginName(){
		return main.getData().getPluginname();
	}
	
	public String buildMainClass(){
		return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+"."+main.getData().getPluginname();
	}
	
	public String buildVersion(){
		return main.getData().getVersion();
	}
	
	public String buildAuthor(){
		return main.getData().getAuthor();
	}
	
	public String buildWebsite(){
		return main.getData().getWebsite();
	}
	
	public String buildDescription(){
		return main.getData().getDescription();
	}
	
	public String buildCommands(){
		if (main.getData().getCommands().size() > 0) {
			String ret="commands:\n";
			for (CommandContainer cmd : main.getData().getCommands()) {
				ret=ret+cmd.buildPluginfileEntry();
			}
			return ret; //TODO
		}
		else {
			return"";
		}
	}
}