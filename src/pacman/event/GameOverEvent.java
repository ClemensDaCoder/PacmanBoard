package pacman.event;

import java.util.EventObject;

import pacman.model.Field;

public class GameOverEvent extends EventObject {

	/** Creates a new GameOverEvent.
	 * 
	 * @param source
	 */
	public GameOverEvent(Field source) {
		super(source);
	}
	
	public Field getSource() {
		return (Field) source;
	}

}
