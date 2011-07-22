package me.simplex.pluginkickstarter.storage;

import java.util.ArrayList;

public class CommandStorage {
	private String command;
	private ArrayList<String> aliases;
	private String description;
	private String usage;
	
	public CommandStorage(String command, ArrayList<String> aliases,String description, String usage) {
		this.command = command;
		this.aliases = aliases;
		this.description = description;
		this.usage = usage;
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
	
	public String buildPluginfileEntry(){
		String ret="";
		ret = ret+"  "+command+":\n";
		ret = ret+"    description: "+description+"\n";
		ret = ret+buildAliasesLine();
		ret = ret+"    usage: |\n";
		ret = ret+"           /<command> "+usage+"\n";
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
}
