package pacman.event;

import java.util.EventObject;

import pacman.model.Board;

public class NextLevelEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	public NextLevelEvent(Board source) {
		super(source);

	}

}
