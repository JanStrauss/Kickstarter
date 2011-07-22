package me.simplex.pluginkickstarter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import me.simplex.pluginkickstarter.generator.GenPlugin;
import me.simplex.pluginkickstarter.generator.GenMainClass;
import me.simplex.pluginkickstarter.util.TemplateType;

public class FileBuilder {
	PluginKickstarter main;
	
	public FileBuilder(PluginKickstarter main) {
		this.main = main;
	}
	
	public String loadTemplateFile(TemplateType type){
		ArrayList<String> content= new ArrayList<String>();
		try {
			BufferedReader bffrdRdr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getClass().getResource("templates/"+type.giveFilename()).getFile()))));
			while(true){
				String line = bffrdRdr.readLine();
				if(line==null){
					break;
				}
				content.add(line);
			}
			bffrdRdr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String file = "";
		for (String line : content) {
			file=file+line+"\n";
		}
		return file;
	}
	
	public String build_MainClass_Content(){
		GenMainClass gen = new GenMainClass(main);
		String file = loadTemplateFile(TemplateType.MainClass);

		file = file.replace("$package", 			gen.buildPackage(TemplateType.MainClass));
		file = file.replace("$imports", 			gen.buildImports());
		file = file.replace("$classname", 			gen.buildClassname());
		file = file.replace("$variables", 			gen.buildVariables());
		file = file.replace("$init", 				gen.buildInit());
		file = file.replace("$register_events", 	gen.buildRegister_Events());
		file = file.replace("$register_commands", 	gen.buildRegister_Commands());
		file = file.replace("$start_tasks", 		gen.buildStart_Tasks());
		file = file.replace("$disable", 			gen.buildDisable());
		file = file.replace("$setupPermissions", 	gen.buildSetupPermissions());
		file = file.replace("$configChecks", 		gen.buildConfigChecks());
		file = file.replace("$GetterAndSetter", 	gen.buildGetterAndSetter());
		return file;
	}
	
	public String build_Plugin_Content(){
		GenPlugin gen = new GenPlugin(main);
		String file = loadTemplateFile(TemplateType.Plugin);
		
		file = file.replace("$pluginname", 			gen.buildPluginName());
		file = file.replace("$mainclass", 			gen.buildMainClass());
		file = file.replace("$version", 			gen.buildVersion());
		file = file.replace("$author", 				gen.buildAuthor());
		file = file.replace("$website", 			gen.buildWebsite());
		file = file.replace("$description", 		gen.buildDescription());
		file = file.replace("$commands", 			gen.buildCommands());
		return file;
	}
}
