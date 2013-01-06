package pacman.event;

import java.util.EventObject;

import pacman.model.bonus.BonusObject;

public class BonusObjectEatenEvent extends EventObject {



	public BonusObjectEatenEvent(BonusObject source) {
		super(source);
	}
	
	public BonusObject getSource() {
		return (BonusObject) source;
	}

}