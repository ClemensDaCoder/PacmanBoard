package pacman.event;

import java.util.EventObject;



public class GameEndsEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameEndsEvent(Object source) {
		super(source);
	}



}
