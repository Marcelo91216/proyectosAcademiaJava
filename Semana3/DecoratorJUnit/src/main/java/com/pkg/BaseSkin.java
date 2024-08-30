package com.pkg;

public abstract class BaseSkin implements Component {
	protected Component wrapee;

	public BaseSkin(Component c) {
		this.wrapee = c;
	}

	@Override
	public String toString() {
		return this.execute();
	}
}
