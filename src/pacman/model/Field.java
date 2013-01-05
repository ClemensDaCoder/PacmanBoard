package pacman.model;

import java.util.ArrayList;
import java.util.List;

import pacman.model.bonus.Pellet;
import pacman.model.move.Ghost;
import pacman.model.move.PacMan;

public class Field {

	public List<GridObject> objects;
	
	public Field() {
		objects = new ArrayList<GridObject>();
	}
	
	public void computeState() {
		//only check field if it is not empty and does not contain a wall
		if (!objects.isEmpty() && !isWall()) {
			if (containsPacman() && containsPellet()) {
				//TODO: remove pellet from field
				//increase score
				//throw events in the air
				
			} 
			if (containsPacman() && containsGhost()) {
				//TODO: end game
				//throw event deswegen
			}
			//room for additional items like key and stuff
		}
	}

	public void addObject(GridObject object) {
		objects.add(object);
	}

	public List<GridObject> getObjectsOnField() {
		return objects;
	}

	public boolean removeObject(GridObject object) {
		return objects.remove(object);
	}

	public boolean isWall() { 
		for (GridObject object : objects) {
			if (object instanceof Wall) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsPacman() {
		for (GridObject object : objects) {
			if (object instanceof PacMan) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsPellet() {
		for (GridObject object : objects) {
			if (object instanceof Pellet) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsGhost() {
		for (GridObject object : objects) {
			if (object instanceof Ghost) {
				return true;
			}
		}
		return false;
	}
}