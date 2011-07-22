package me.simplex.pluginkickstarter.data;

public class ListenerContainer {
	private String type;
	private String name;
	private String event;
	private String desc;
	private boolean selected;
	
	public ListenerContainer(String type, String name, String event, String desc) {
		this.type = type;
		this.name = name;
		this.event = event;
		this.desc = desc;
		this.selected = false;
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
		System.out.println(name+" set to: "+selected);
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}
	
	
}

