package pacman.event;

import pacman.model.Position;
import pacman.model.bonus.Fruit;

public class FruitPlacedEvent extends java.util.EventObject {

	Fruit fruit;
	Position pos;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FruitPlacedEvent(Fruit source, Position pos) {
		super(source);
		this.fruit = source;
		this.pos = pos;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public Position getPos() {
		return pos;
	}

}
