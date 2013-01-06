package pacman.model;
import java.util.EventListener;
import java.util.HashMap;

import javax.swing.event.EventListenerList;

import pacman.event.BoardListener;
import pacman.event.FieldListener;
import pacman.event.HasmovedEvent;
import pacman.event.MoveNotPossibleEvent;
import pacman.event.ScoreChangedEvent;
import pacman.model.bonus.BonusObject;
import pacman.model.move.MovingObject;


public class Board {

	private static Board instance = null;

	private HashMap<Position, Field> gameArea;
	private EventListenerList listeners  = new EventListenerList();
	private int score;

	public Board() {
		score = 0;
		//init();
	}

	/** Moves a movingObject from its current Position to the next one.
	 *  Objects are only moved from one {@link Field} to another.
	 *  Objects are not moved if {@link Field} is occupied by {@link Wall}.
	 * @param movingObject
	 * @param direction
	 */
	public void moveObject(MovingObject movingObject, Direction direction) {
		
		Position current = movingObject.getCurrentPosition();
		Position next = current.next(direction);

		
		Field currentField = gameArea.get(current);
		Field nextField = gameArea.get(next);

		if (!nextField.isWall()) {
			movingObject.setCurrentPosition(next);
			nextField.addObject(movingObject);
			currentField.removeObject(movingObject);
			notifyListener(new HasmovedEvent(current, next, movingObject));

		}
		 else {
			 
			 notifyListener(new MoveNotPossibleEvent(movingObject));
		}
	}

	/**
	 * @return the current score
	 */
	public int getScore() {
		return score;
	}

	/** Increases the current score by value.
	 * @param value
	 */
	public void increaseScore(int value) {
		score += value;
		notifyListener(new ScoreChangedEvent(score));
	}

	/**
	 * @return instance of {@link Board}
	 */
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}

	public void init() {
		gameArea = new HashMap<Position, Field>();
		
		/*for (Position position : Position.values()) {
			Field f = new Field();
			f.addObject(new Pellet());
			gameArea.put(position, f);
		}
		PacMan pac = new PacMan("Pacman", Position.F_3);
		moveObject(pac,Direction.RIGHT);*/
		
		// TODO: initialize gameArea
		
		for (Position position : Position.values()) {
			/*f = new Field();
			if(((position.getX() == 'A') || (position.getX() == 'Z')) && (position.getX() != 'M')){	
				f.addObject(new Wall());
			}else if(((position.getY() == 1)||(position.getY() == 35)) && (position.getY() != 17)){
				f.addObject(new Wall());
			}
			gameArea.put(position, f);*/
			
			putWall(position, 'A', 'Z', 1, 35);
			putWall(position, 'C', 'X', 3, 33);
			putWall(position, 'E', 'U', 3, 33);
			putWall(position, 'G', 'S', 3, 33);
			putWall(position, 'I', 'Q', 3, 33);
			putWall(position, 'K', 'O', 3, 33);
		}
		
		/*for(Position position : Position.values()){
			if((position.getX() == 17) && (position.getY() != 'A') && (position.getX() != 'Z')){
				clearField(position);
			}
			else if((position.getY() == 'M') && (position.getX() != '1') && (position.getY() != '35')){
				clearField(position);
			}
		}*/
	}
	
//	private void putSomething() {
//		//put fields in all available positions
//		for (Position position : Position.values()) {
//			Field field = new Field();
//			gameArea.put(position, field);
//			if (position.getX() == 'A' || position.getX() == 'Z') {
//				field.addObject(new Wall());
//			} else if (field.isEmpty() && (position.getX() == 'C' || position.getX() == 'X') && (position.getY() >= 3 && position.getY() <= 33)) {
//				field.addObject(new Wall());
//			} else if (field.isEmpty() && (position.getX() == 'E'|| position.getX() == 'U') && (position.getY() >= 5 && position.getY() <= 31)) {
//				field.addObject(new Wall());
//			}
//		}
//		//put walls in fields of specific positions
//		//in the a row
//	}
	
	private void putWall(Position position, char X1, char X2, int Y1, int Y2){
		Field f = new Field();
		if(((position.getX() == X1) || (position.getX() == X2)) && (position.getX() != 'M')){	
			f.addObject(new Wall());
		}else if(((position.getY() == Y1)||(position.getY() == Y2)) && (position.getY() != 17)){
			f.addObject(new Wall());
		}
		gameArea.put(position, f);
	}
	
	/*private void putRectangle(Position pos, char X1, char X2, int Y1, int Y2){
		Field f;
		if((pos.getX() == X1) || (pos.getX() == X2)){
			if ((pos.getX() != 17) || (pos.getY() != 'A')
					|| (pos.getX() != 'Z')) {
				f = new Field();
				f.addObject(new Wall());
				gameArea.put(pos, f);
			}
		}
		
		if(!gameArea.containsKey(pos)){
			if((pos.getY() == Y1) || (pos.getY() == Y2)){
				if ((pos.getY() != 'M') || (pos.getX() == 1)
						|| (pos.getX() == 35)) {
					f = new Field();
					f.addObject(new Wall());
					gameArea.put(pos, f);
				}
			}
		}
	}*/

	//??
	public class BonusObjectEventListener implements EventListener {
		public BonusObjectEventListener() {
		}
		
		public void handleEvent(BonusObject o){
			increaseScore(o.getValue());
		}
	};
	
	public void addListener(BoardListener listener){
		listeners.add(BoardListener.class, listener);
		
	}
	public void removeListener(BoardListener listener){
		listeners.remove(BoardListener.class, listener);
		
		
	}
	protected void notifyListener(HasmovedEvent event){
		System.out.println("Notify");
		for(BoardListener l : listeners.getListeners(BoardListener.class))
		{
			//System.out.println("Listerner");
			l.hasmoved(event);
		}
		
		
	}
	protected void notifyListener(MoveNotPossibleEvent event){
		//System.out.println("Notify");
		for(BoardListener l : listeners.getListeners(BoardListener.class))
		{
			//System.out.println("Listerner");
			l.moveNotpossible(event);
		}
		
		
	}
	protected void notifyListener(ScoreChangedEvent event){
		for(BoardListener l : listeners.getListeners(BoardListener.class))
		{
			//System.out.println("Listerner");
			l.scoreChanged(event);
		}
	}

	public void addFieldListeners(FieldListener listener )
	{
		for(Field f : gameArea.values())
		{
			f.addListener(listener);
		}
	}
	
	public void removeFieldListener(FieldListener listener)
	{
		for(Field f : gameArea.values())
		{
			f.removeListener(listener);
		}
	
	}

}
