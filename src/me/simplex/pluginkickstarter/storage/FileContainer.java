package me.simplex.pluginkickstarter.storage;

public class FileContainer {
	private String filename;
	private String path;
	private String content;
	
	public FileContainer(String filename, String path, String content) {
		this.filename = filename;
		this.path = path;
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public String getPath() {
		return path;
	}

	public String getContent() {
		return content;
	}
	
	
}
