package me.simplex.pluginkickstarter.generator;

import java.io.File;

import me.simplex.pluginkickstarter.PluginKickstarter;
import me.simplex.pluginkickstarter.util.TemplateType;

public class Generator {
	PluginKickstarter main;
	
	public Generator(PluginKickstarter main) {
		this.main = main;
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
		else if(template.equals(TemplateType.PlayerListener) 	||
				template.equals(TemplateType.BlockListener)		||
				template.equals(TemplateType.InventoryListener)	||
				template.equals(TemplateType.VehicleListener)	||
				template.equals(TemplateType.ServerListener)	||
				template.equals(TemplateType.WeatherListener)	||
				template.equals(TemplateType.WorldListener)		||
				template.equals(TemplateType.EntityListener)) {
			
			return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+".listeners;";
		}
		else {
			return "me."+main.getData().getAuthor().toLowerCase()+"."+main.getData().getPluginname().toLowerCase()+";";
		}
	}
	
	public String buildFilepath(TemplateType template){
		return "src"+File.separator+buildPackage(template).replace(".", File.separator);
	}
		
	public String buildClassname(){
		return main.getData().getPluginname();
	}
	
	public String buildMainClassImport(){
		return "import "+buildPackage(TemplateType.MainClass)+"."+buildMainClassType();
	}
	
	public String buildMainClassType(){
		return StringToClassName(main.getData().getPluginname());
	}
	
	protected static String StringToClassName(String g){return g.toLowerCase().substring(0, 1).toUpperCase()+g.substring(1);}
}