package pacman.event;

import java.util.EventObject;

import pacman.model.Board;

public class NextLevelEvent extends EventObject {

	public NextLevelEvent(Board source) {
		super(source);

	}

}