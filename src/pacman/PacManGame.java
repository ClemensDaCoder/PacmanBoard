package pacman;

import pacman.model.Board;
import pacman.model.move.Ghost;
import pacman.model.move.RandomMovingStrategy;
import pacman.view.PacmanView;
import pacman.view.TextView;

/** PacManGame is used to control the configuration of the game.
 * Enemies are added, etc.
 * 
 * @author mwe
 *
 */
public class PacManGame {
	
	private Board board;
	private PacmanView view;
	
	/** Creates a new PacManGame.
	 *  Pacman is up against 4 enemies ({@link Ghost} that are trying to catch him using a {@link RandomMovingStrategy}. 
	 */
	PacManGame() {
		//create model
		board = Board.getInstance();
		//create view
		view = new TextView();
		//register view to model
		board.addFieldListeners(view);
		board.addListener(view);
		
		//add Pacman and some enemies
		board.addPacman(new RandomMovingStrategy());
		board.addGhost(new RandomMovingStrategy());
		board.addGhost(new RandomMovingStrategy());
		board.addGhost(new RandomMovingStrategy());
		
		//start game
		board.initLevel();
		
		while(!board.isGameOver()) {
			board.nextRound();
		}
	}
	
	public static void main (String [] args) {
		PacManGame pacmanGame = new PacManGame();
	}

}
