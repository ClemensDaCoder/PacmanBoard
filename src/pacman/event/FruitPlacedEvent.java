package pacman.event;

import java.util.EventObject;

import pacman.model.Position;
import pacman.model.bonus.Fruit;

public class FruitPlacedEvent extends EventObject {

	Fruit fruit;
	Position position;

	/** Creates a new FruitPlacedEvent. 
	 * 
	 * @param source
	 * @param pos
	 */
	public FruitPlacedEvent(Fruit source, Position pos) {
		super(source);
		this.fruit = source;
		this.position = pos;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public Position getPos() {
		return position;
	}

}
