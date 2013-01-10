package pacman.event;

import java.util.EventObject;

import pacman.model.bonus.BonusObject;

public class BonusObjectEatenEvent extends EventObject {

	/** Creates a BonusObjectEatenEvent.
	 * 
	 * @param source
	 */
	public BonusObjectEatenEvent(BonusObject source) {
		super(source);
	}
	
	public BonusObject getSource() {
		return (BonusObject) source;
	}

}