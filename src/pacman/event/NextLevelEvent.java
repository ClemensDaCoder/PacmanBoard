package pacman.event;

import java.util.EventObject;

import pacman.model.Board;

public class NextLevelEvent extends EventObject {

	/** Creatse a new NextLevelEvent.
	 * 
	 * @param source
	 */
	public NextLevelEvent(Board source) {
		super(source);

	}

}