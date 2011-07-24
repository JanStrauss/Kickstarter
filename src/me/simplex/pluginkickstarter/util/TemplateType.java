package me.simplex.pluginkickstarter.util;

public enum TemplateType {
	Plugin,
	MainClass,
	Listener,
	Command,
	Task,
	Configuration;
	
	public String giveFilename(){
		return this.toString()+".template";
	}
}