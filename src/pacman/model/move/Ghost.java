package pacman.model.move;

import pacman.model.Position;

public class Ghost extends MovingObject {
	
	public Ghost(Position position, String name, MovingStrategy movingStrategy) {
		super(position, name, movingStrategy);
	}
	
//	public Ghost(Position position) {
//		super(position, "Ghost", new RandomMovingStrategy());
//	}
	
}