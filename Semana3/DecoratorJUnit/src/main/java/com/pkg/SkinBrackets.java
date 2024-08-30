package com.pkg;

public class SkinBrackets extends BaseSkin{

	public SkinBrackets(Component c) {
		super(c);
	}

	@Override
	public String execute() {
		return "["+this.wrapee+"]";
	}
}
