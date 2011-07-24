package me.simplex.pluginkickstarter.generator;

import java.io.File;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.util.TemplateType;

public abstract class Generator {
	PluginKickstarter main;
	
	public Generator(PluginKickstarter main) {
		this.main = main;
	}
	
	public String buildFileName() {
		return buildClassname()+".java";
	}
	
	public String buildAuthor(){
		return main.getData().getAuthor();
	}
	
	public String buildWebsite(){
		return main.getData().getWebsite();
	}
	
	public String buildPluginName(){
		return main.getData().getPluginname();
	}
	
	public String buildPackage(TemplateType template){
		if (template.equals(TemplateType.Command)) {
			return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+".commands;";
		}
		else if(template.equals(TemplateType.Task)) {
			return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+".tasks;";
		}
		else if(template.equals(TemplateType.Listener)){
			return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+".listeners;";
		}
		else {
			return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+";";
		}
	}
	
	public String buildFilepath(TemplateType template){
		return "src"+File.separator+buildPackage(template).replace(".", File.separator);
	}
		
	public abstract String buildClassname();
	
	public String buildMainClassImport(){
		return "import "+buildPackage(TemplateType.MainClass)+"."+buildMainClassType();
	}
	
	public String buildMainClassType(){
		return StringToClassName(main.getData().getPluginname());
	}
	
	protected static String StringToClassName(String g){return g.toLowerCase().substring(0, 1).toUpperCase()+g.substring(1);}
}