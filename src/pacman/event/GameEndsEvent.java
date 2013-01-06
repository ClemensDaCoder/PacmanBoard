package pacman.event;

import java.util.EventObject;

import pacman.model.Field;

public class GameEndsEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	public GameEndsEvent(Field source) {
		super(source);
	}

}
