package me.simplex.pluginkickstarter;

import java.util.ArrayList;

import me.simplex.pluginkickstarter.storage.CommandStorage;
import me.simplex.pluginkickstarter.storage.TaskStorage;

public class DataStorage {
	private String pluginname;
	private String author;
	private String description;
	private String website;
	private String version;
	
	private boolean usePermissions;
	private boolean singleCommandExecuter;
	
	private ArrayList<TaskStorage> tasks;
	private ArrayList<CommandStorage> commands;
	
	public DataStorage() {
		this.tasks = new ArrayList<TaskStorage>();
		this.commands = new ArrayList<CommandStorage>();
	}
	
	public String getPluginname() {
		return pluginname;
	}
	
	public void setPluginname(String pluginname) {
		this.pluginname = pluginname;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public boolean isUsePermissions() {
		return usePermissions;
	}
	
	public void setUsePermissions(boolean usePermissions) {
		this.usePermissions = usePermissions;
	}

	/**
	 * @param singleCommandExecuter the singleCommandExecuter to set
	 */
	public void setSingleCommandExecuter(boolean singleCommandExecuter) {
		this.singleCommandExecuter = singleCommandExecuter;
	}

	/**
	 * @return the singleCommandExecuter
	 */
	public boolean isSingleCommandExecuter() {
		return singleCommandExecuter;
	}

	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(ArrayList<TaskStorage> tasks) {
		this.tasks = tasks;
	}

	/**
	 * @return the tasks
	 */
	public ArrayList<TaskStorage> getTasks() {
		return tasks;
	}

	/**
	 * @param commands the commands to set
	 */
	public void setCommands(ArrayList<CommandStorage> commands) {
		this.commands = commands;
	}

	/**
	 * @return the commands
	 */
	public ArrayList<CommandStorage> getCommands() {
		return commands;
	}
}
