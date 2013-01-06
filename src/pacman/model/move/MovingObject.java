package pacman.model.move;

import pacman.model.GridObject;
import pacman.model.Position;

public abstract class MovingObject extends GridObject {
	
	private Position currentPosition;
	
	public MovingObject(Position position, String name) {
		super(name);
		this.currentPosition = position;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}	
	
}