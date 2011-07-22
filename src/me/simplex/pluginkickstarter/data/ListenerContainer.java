package me.simplex.pluginkickstarter.data;

public class ListenerContainer {
	private String type;
	private String name;
	private String event;
	private String desc;
	
	public ListenerContainer(String type, String name, String event, String desc) {
		this.type = type;
		this.name = name;
		this.event = event;
		this.desc = desc;
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
	
	
}

