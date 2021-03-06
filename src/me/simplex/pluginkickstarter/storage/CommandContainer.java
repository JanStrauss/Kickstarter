package me.simplex.pluginkickstarter.storage;

import java.util.ArrayList;

public class CommandContainer {
	private String command="";
	private ArrayList<String> aliases;
	private String description="";
	private String usage="/<command> ";
	private boolean PlayerOnly;
	
	public CommandContainer(){
		this.PlayerOnly = true;
		this.aliases = new ArrayList<String>();
	}
	
	public String buildPluginfileEntry(){
		String ret="";
		ret = ret+"  "+command+":\n";
		ret = ret+"    description: "+description+"\n";
		ret = ret+buildAliasesLine();
		ret = ret+"    usage: |\n";
		ret = ret+"           "+usage+"\n";
		return ret;
	}
	
	private String buildAliasesLine(){
		if (aliases.size() >0) {
			String alias_string="";
			for (String alias : aliases) {
				alias_string=alias_string+alias+" ";
			}
			alias_string = alias_string.trim();
			alias_string = alias_string.replace(' ', ',');
			return "    aliases: ["+alias_string+"]\n";
		}
		else {
			return "";
		}
	}
	
	public String getCommand() {
		return command;
	}
	public ArrayList<String> getAliases() {
		return aliases;
	}
	public String getDescription() {
		return description;
	}
	public String getUsage() {
		return usage;
	}
	
	public boolean isPlayerOnly() {
		return PlayerOnly;
	}

	public void setPlayerOnly(boolean playerOnly) {
		PlayerOnly = playerOnly;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setAliases(ArrayList<String> aliases) {
		this.aliases = aliases;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
}
