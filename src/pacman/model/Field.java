package pacman.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.EventListenerList;

import pacman.event.BonusObjectEatenEvent;
import pacman.event.FieldListener;
import pacman.event.GameOverEvent;
import pacman.model.bonus.BonusObject;
import pacman.model.move.Ghost;
import pacman.model.move.PacMan;

public class Field {

	public List<GridObject> objects;
	private EventListenerList listeners;

	
	/** Creates a new field, which can be occupied by various {@link GridObject}s.
	 *  
	 */
	public Field() {
		objects = new ArrayList<GridObject>();
		listeners = new EventListenerList();
	}
	
	/** Computes the current state of the field.<p>
	 * Considers all {@link GridObjects} currently on the field.<br>
	 * E.g.: lets {@link PacMan} eat {@link BonusObject} or {@link Ghost} kill {@link PacMan}.
	 * 
	 */
	public void computeState() {
		//only check field if it is not empty and does not contain a wall
		if (!objects.isEmpty() && !isWall()) {
			if (containsPacman() && containsBonusObject()) {
				//make sure pacman eats all bonus objects available on field
				while (containsBonusObject()) {
					BonusObject bonusObject = getBonusObject();
					notifyListener(new BonusObjectEatenEvent(bonusObject));
					//increase score
					Board.getInstance().increaseScore(bonusObject.getValue());
					//execute special action of bonus object
					bonusObject.executeAction();
					//remove bonus object from field
					objects.remove(bonusObject);
				}
			} 
			if (containsPacman() && containsGhost()) {
				notifyListener(new GameOverEvent(this));
				//TODO: end game
				//throw event deswegen
//				System.exit(0);
			}
			//room for additional items like key and stuff
		}
	}

	/** Adds an {@link GridObject} to the field
	 * @param object
	 */
	public void addObject(GridObject object) {
		objects.add(object);
	}
	
	/**
	 * @return true if this field is empty.
	 */
	public boolean isEmpty() {
		return objects.isEmpty();
	}

	/**
	 * @return all {@link GridObect}s on the field
	 */
	public List<GridObject> getObjectsOnField() {
		return objects;
	}

	/** Removes a {@link GridObject} from the field
	 * @param object
	 * @return true if removal was successful
	 */
	public boolean removeObject(GridObject object) {
		return objects.remove(object);
	}

	/**
	 * @return true if this field is occupied by a {@link Wall}
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
	 * @return true if this field contains a {@link PacMan}
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
	 * @return true if this field contains a {@link BonusObject}
	 */
	public boolean containsBonusObject() {
		for (GridObject object : objects) {
			if (object instanceof BonusObject) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return true if this field contains a {@link Ghost}
	 */
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
	
	private Ghost getGhost() {
		for (GridObject object : objects) {
			if (object instanceof Ghost) {
				return (Ghost) object;
			}
		}
		return null;
	}

	
	/** Adds a {@link FieldListner} from this field.
	 * @param listener
	 */
	public void addListener(FieldListener listener){
		listeners.add(FieldListener.class, listener);		
	}
	
	/** Removes a {@link FieldListener} from this field.
	 * @param listener
	 */
	public void removeListener(FieldListener listener){
		listeners.remove(FieldListener.class, listener);		
	}
	
	/** Notifies all listeners in case of {@link BonusObjectEatenEvent}.
	 * @param event
	 */
	public void notifyListener(BonusObjectEatenEvent event){
		for(FieldListener l : listeners.getListeners(FieldListener.class))
		{
			l.bonusObjectEaten(event);
		}
	}
	
	/** Notifies all listeners in case of {@link GameOverEvent}.
	 * @param event
	 */
	public void notifyListener(GameOverEvent event){
		for(FieldListener l : listeners.getListeners(FieldListener.class))
		{
			l.gameOver(event);
		}
	}
}
