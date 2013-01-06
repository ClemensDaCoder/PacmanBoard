package pacman;

import pacman.model.Board;
import pacman.model.move.RandomMovingStrategy;
import pacman.view.PacmanView;
import pacman.view.TextView;

public class SuperController {
	
	private Board board;
	private PacmanView view;
	
	SuperController() {
		//create model
		board = Board.getInstance();
		//create view
		view = new TextView();
		//register view to model
		board.addFieldListeners(view);
		board.addListener(view);
		
		
		
		//TODO: add pacman & ghosts to board
		board.addPacman(new RandomMovingStrategy());
		board.addGhost(new RandomMovingStrategy());
		board.addGhost(new RandomMovingStrategy());
		board.addGhost(new RandomMovingStrategy());
		
		//start game
		board.startLevel();
		
		while(true) {
			board.moveObjects();
		}
	}
	
	public static void main (String [] args) {
		SuperController controller = new SuperController();
	}

}
