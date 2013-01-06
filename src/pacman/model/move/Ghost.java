package pacman.model.move;

import pacman.model.Position;

public class Ghost extends MovingObject {
	
	public Ghost(Position position, String name) {
		super(position, name);
	}
	
	public Ghost(Position position) {
		super(position, "Ghost");
	}
	
}