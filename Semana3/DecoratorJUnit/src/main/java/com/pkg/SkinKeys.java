package com.pkg;

public class SkinKeys extends BaseSkin{

	public SkinKeys(Component c) {
		super(c);
	}

	@Override
	public String execute() {
		return "{"+this.wrapee+"}";
	}
}
