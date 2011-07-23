package me.simplex.pluginkickstarter.storage;

import me.simplex.pluginkickstarter.util.PriorityType;

public class ListenerContainer {
	private String type;
	private String name;
	private String event;
	private String desc;
	private boolean selected;
	private PriorityType priority;
	
	public ListenerContainer(String type, String name, String event, String desc) {
		this.type = type;
		this.name = name;
		this.event = event;
		this.desc = desc;
		this.selected = false;
		this.priority = PriorityType.Normal;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getEvent() {
		return event;
	}

	public String getDesc() {
		return desc;
	}
	
	public void setSelected(boolean selected) {
		//System.out.println(name+" set to: "+selected);
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}
	
	public PriorityType getPriority() {
		return priority;
	}

	public void setPriority(PriorityType priority) {
		//System.out.println("priority set to: "+priority);
		this.priority = priority;
	}
	
	
}

