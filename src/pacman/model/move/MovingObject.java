package pacman.model.move;

import pacman.model.Direction;
import pacman.model.GridObject;
import pacman.model.Position;

public abstract class MovingObject extends GridObject {
	
	private Position currentPosition;
	private MovingStrategy movingStrategy;
	
	public MovingObject(Position position, String name, MovingStrategy movingStrategy) {
		super(name);
		this.currentPosition = position;
		this.movingStrategy = movingStrategy;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}	
	
	public Direction getMoveDirection() {
		return movingStrategy.getMoveDirection();
	}
	
}