package pacman.model.move;

import pacman.model.Position;


public class PacMan extends MovingObject {
	
	public PacMan(Position position, String name, MovingStrategy movingStrategy) {
		super(position, name, movingStrategy);
	}
	
//	public PacMan(Position position) {
//		super(position, "PacMan", new RandomMovingStrategy());
//	}

}