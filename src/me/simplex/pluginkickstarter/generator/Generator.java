package me.simplex.pluginkickstarter.generator;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.util.TemplateType;

public class Generator {
	PluginKickstarter main;
	
	public Generator(PluginKickstarter main) {
		this.main = main;
	}
	
	public String buildPackage(TemplateType template){
		if (template.equals(TemplateType.Command)) {
			return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+".commands;";
		}
		else {
			return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+";";
		}
	}
		
	public String buildClassname(){
		return main.getData().getPluginname();
	}
}
