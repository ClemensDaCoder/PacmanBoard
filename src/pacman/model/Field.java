package pacman.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.EventListenerList;

import pacman.event.BonusObjectEatenEvent;
import pacman.event.FieldListener;
import pacman.model.bonus.BonusObject;
import pacman.model.bonus.Pellet;
import pacman.model.move.Ghost;
import pacman.model.move.PacMan;
public class Field {

	public List<GridObject> objects;
	
	public Field() {
		objects = new ArrayList<GridObject>();
	}
	private EventListenerList listeners  = new EventListenerList();

	public void computeState() {
		//only check field if it is not empty and does not contain a wall
		if (!objects.isEmpty() && !isWall()) {
			if (containsPacman() && containsBonusObject()) {
				BonusObject bonusObject = getBonusObject();
				notifyListener(new BonusObjectEatenEvent(bonusObject));
				//increase score
				Board.getInstance().increaseScore(bonusObject.getValue());
				//execute special action of bonus object
				bonusObject.executeAction();
				//remove pellet from field
				objects.remove(bonusObject);
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
	
	public boolean containsBonusObject() {
		for (GridObject object : objects) {
			if (object instanceof BonusObject) {
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
	
	private BonusObject getBonusObject() {
		for (GridObject object : objects) {
			if (object instanceof BonusObject) {
				return (BonusObject) object;
			}
		}
		return null;
	}
	
	private Pellet getPellet() {
		for (GridObject object : objects) {
			if (object instanceof Pellet) {
				return (Pellet) object;
			}
		}
		return null;
	}
	
	public void addListener(FieldListener listener){
		listeners.add(FieldListener.class, listener);
		
	}
	
	public void removeListener(FieldListener listener){
		listeners.remove(FieldListener.class, listener);
		
		
	}
	
	public void notifyListener(BonusObjectEatenEvent event){
		for(FieldListener l : listeners.getListeners(FieldListener.class))
		{
			//System.out.println("Listerner");
			l.pelletEaten(event);
		}
	}
	

}