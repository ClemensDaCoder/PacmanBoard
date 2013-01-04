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
	
	/** Checks if multiple objects are on this field.
	 * If so, decides what to do. In case of Pacman and pellet, pellet is removed from field and score is increased.
	 * In case of Pacman and ghost, game is lost.
	 * In case of ghost and pellet - nothing happens.
	 * Can be extended for additional items.
	 * 
	 */
	public void computeState() {
		//only check field if it is not empty and does not contain a wall
		if (!objects.isEmpty() && !isWall()) {
			if (containsPacman() && containsPellet()) {
				Pellet pellet = this.getPellet();
				if (pellet != null) {
					Board.getInstance().increaseScore(pellet.getValue());
					objects.remove(pellet);
					//TODO: throw events in the air
				}
				// you should never be here fucker
				//throw crazy exception
			} 
			if (containsPacman() && containsGhost()) {
				//TODO: end game
				//throw event deswegen
			}
			//room for additional items like key and stuff
		}
	}

	/** Adds an object to this field.
	 * @param object
	 */
	public void addObject(GridObject object) {
		objects.add(object);
	}

	/**
	 * @return all objects on this field.
	 */
	public List<GridObject> getObjectsOnField() {
		return objects;
	}

	/** Removes an object from this field.
	 * @param object to be removed
	 * @return true if removal was successful
	 */
	public boolean removeObject(GridObject object) {
		return objects.remove(object);
	}

	/**
	 * @return true if this field contains a wall
	 */
	public boolean isWall() { 
		for (GridObject object : objects) {
			if (object instanceof Wall) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return true if this field contains Pacman
	 */
	public boolean containsPacman() {
		for (GridObject object : objects) {
			if (object instanceof PacMan) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return true if this field contains a pellet
	 */
	public boolean containsPellet() {
		for (GridObject object : objects) {
			if (object instanceof Pellet) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return true if this field contains a ghost
	 */
	public boolean containsGhost() {
		for (GridObject object : objects) {
			if (object instanceof Ghost) {
				return true;
			}
		}
		return false;
	}
	
	/** Returns the first found Pellet from this Field, otherwise null.
	 * @return Pellet or null
	 */
	private Pellet getPellet() {
		for (GridObject object : objects) {
			if (object instanceof Pellet) {
				return (Pellet)object;
			}
		}
		return null;
	}
}