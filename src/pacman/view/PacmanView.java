package pacman.view;

import java.util.HashMap;

import pacman.event.HasMovedListener;
import pacman.model.Field;
import pacman.model.Position;

public interface PacmanView extends HasMovedListener{
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
