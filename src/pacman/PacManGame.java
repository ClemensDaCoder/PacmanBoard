package pacman;

import pacman.model.Board;
import pacman.model.move.RandomMovingStrategy;
import pacman.view.PacmanView;
import pacman.view.TextView;

public class PacManGame {
	
	private Board board;
	private PacmanView view;
	
	PacManGame() {
		//create model
		board = Board.getInstance();
		//create view
		view = new TextView();
		//register view to model
		board.addFieldListeners(view);
		board.addListener(view);
		
		
		
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
