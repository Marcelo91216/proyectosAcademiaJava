package com.pkg;

public class Character implements Component{

	@Override
	public String execute() {
		return "(°-°)";
	}
	
	@Override
	public String toString() {
		return this.execute();
	}
}
