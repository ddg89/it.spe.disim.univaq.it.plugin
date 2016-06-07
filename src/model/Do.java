package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Do {
	private List<String> functions;
	
	private Fix parent; 
	
	public Do() {
		super();
	}
	public Fix getParent() {
		return parent;
	}
	@XmlElement
	public void setParent(Fix parent) {
		this.parent = parent;
	}
	public Do(Fix parent){
		this.parent=parent;
		functions = new ArrayList<String>();
		
	}
	
	public List<String> getFunctions() {
		return functions;
	}
	@XmlElementWrapper(name = "Functions")
	@XmlElement(name = "Function")
	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}
	public void addFunction(String f){
		this.functions.add(f);
	}
	public String toString(){
		String res ="";
		for(String s : this.getFunctions()){
			res+=s+"\n";
		}
		return res;
	}

}
