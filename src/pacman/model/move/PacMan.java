package pacman.model.move;

import pacman.model.Position;


public class PacMan extends MovingObject {
	
	public PacMan(Position position, String name) {
		super(position, name);
	}
	
	public PacMan(Position position) {
		super(position, "PacMan");
	}

}