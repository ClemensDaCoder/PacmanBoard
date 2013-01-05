package pacman.model.move;

import pacman.model.GridObject;
import pacman.model.Position;

public abstract class MovingObject extends GridObject {
	
	private Position currentPosition;
	private String description;
	
	public MovingObject(String description, Position position) {
		this.currentPosition = position;
		this.description = description;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}