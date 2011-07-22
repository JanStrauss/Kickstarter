package me.simplex.pluginkickstarter.storage;

import java.util.ArrayList;

import me.simplex.pluginkickstarter.DataStorage;
import me.simplex.pluginkickstarter.util.TemplateType;

public class ListenerStorage {
	private DataStorage storage;
	private ArrayList<String> imports;
	private String code;
	private TemplateType templateType;
	
	public ListenerStorage(DataStorage storage) {
		this.storage = storage;
	}
	
	public ListenerStorage(DataStorage storage, ArrayList<String> imports,String code, TemplateType templateType) {
		super();
		this.storage = storage;
		this.imports = imports;
		this.code = code;
		this.templateType = templateType;
	}

	public DataStorage getStorage() {
		return storage;
	}

	public void setStorage(DataStorage storage) {
		this.storage = storage;
	}

	public ArrayList<String> getImports() {
		return imports;
	}

	public void setImports(ArrayList<String> imports) {
		this.imports = imports;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TemplateType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}
	
	
}
