package pacman.event;

import pacman.model.Field;

public class PelletEatenEvent extends java.util.EventObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PelletEatenEvent(Field source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}