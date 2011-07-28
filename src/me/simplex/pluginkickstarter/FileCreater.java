package me.simplex.pluginkickstarter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.simplex.pluginkickstarter.storage.FileContainer;

public class FileCreater {
	private PluginKickstarter main;
	
	public FileCreater(PluginKickstarter main) {
	this.main = main;
	}
	
	public void createProject(String dir){
		for (FileContainer c : main.getData().getBuildFiles()) {
			System.out.print("create file: "+c.getFilename()+".. ");
			createFile(c, dir);
			System.out.println("done");
		}
	}
	
	public void createFile(FileContainer container, String dir){

		String path=dir;
		path = path+File.separator+container.getPath();
		path = path+File.separator+container.getFilename();
		path=path.replace(File.separator+File.separator, File.separator);
		
		
		File output_path = new File(dir+File.separator+container.getPath());
		File output = new File(path);
		String content = container.getContent();
		content = content.replace("\n", System.getProperty("line.separator"));
		
		try {
			if (!output_path.exists()) {
				output_path.mkdirs();
			}
			BufferedWriter out = new BufferedWriter(new FileWriter(output));
			out.write(content);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
