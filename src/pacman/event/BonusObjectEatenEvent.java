package pacman.event;

import java.util.EventObject;

import pacman.model.bonus.BonusObject;

public class BonusObjectEatenEvent extends EventObject {

	BonusObject bonusObject;

	public BonusObjectEatenEvent(BonusObject source) {
		super(source);
		this.bonusObject = source;
	}

	public BonusObject getBonusObject() {
		return bonusObject;
	}

}