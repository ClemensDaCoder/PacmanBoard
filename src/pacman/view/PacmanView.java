package pacman.view;

import java.util.HashMap;

import pacman.event.BoardListener;
import pacman.event.FieldListener;
import pacman.model.Field;
import pacman.model.Position;
import pacman.model.move.MovingObject;

public interface PacmanView extends BoardListener, FieldListener{
	/**
	 * Prints the initial state of the gameboard
	 * @param gameArea
	 */
	public void printBoard(HashMap<Position, Field> gameArea);
	
	/**
	 * Prints the changed parts of the game
	 * @param gameArea
	 */
	public void updateBoard();
	
}
