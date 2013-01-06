package pacman.event;

import pacman.model.bonus.BonusObject;

public class BonusObjectEatenEvent extends java.util.EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BonusObject bonusobject;

	public BonusObjectEatenEvent(BonusObject source) {
		super(source);
		this.bonusobject = source;
	}

	public BonusObject getBonusObject() {
		return bonusobject;
	}

}