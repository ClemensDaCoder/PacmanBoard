package pacman.view;

import pacman.model.Board;

public class Pacman {

	
	/** The user interface. */
	private PacmanView userInterface;

	/** The play field. */
	private Board board;
	/**
	 * @param args
	 */

	public Board getBoard() {
		return board;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Das spiel startet");
		new Pacman().startgame();
		
		
		
		//TODO Ausgabe des aktuellen STatus
		//Todo Ausgabe der Movings
		// TODO Auto-generated method stub
			
	}
	public void startgame(){
		board = new Board();
		userInterface = new TextView();
		board.addListener(userInterface);
		
	}

}
