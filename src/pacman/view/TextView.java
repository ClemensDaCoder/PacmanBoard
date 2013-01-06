package pacman.view;

import java.util.HashMap;

import pacman.event.BonusObjectEatenEvent;
import pacman.event.GameEndsEvent;
import pacman.event.HasmovedEvent;
import pacman.event.MoveNotPossibleEvent;
import pacman.event.ScoreChangedEvent;
import pacman.model.Field;
import pacman.model.Position;


public class TextView implements PacmanView{
	
	@Override
	public void printBoard(HashMap<Position, Field> gameArea){
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
		//pacman hits wall
		
		//ghost hits wall
		
		//pacman moves
		
		//ghost moves
		
		//ghost eats pacman: game over
		
		//pacman eats pellet
		
		//pacman eats fruit
		
		//score increased
		
		//level completed: next level
		
	}

	@Override
	public void hasmoved(HasmovedEvent e) {
		System.out.println(e.getMov().getName() + " has moved from" + e.getOldPos().toString() + " to " + e.getNewPos().toString());
		//e.getOldPos().toString();		
	}

	@Override
	public void moveNotpossible(MoveNotPossibleEvent e) {
		System.out.println(e.getMov().getName() + " trifft auf Begrenzung – Kein Ereignis");
		
	}

	@Override
	public void bonusObjectEaten(BonusObjectEatenEvent event) {
		System.out.println("Pac-Man frisst" + event.getBonusObject().getName());
	}

	@Override
	public void scoreChanged(ScoreChangedEvent event) {
		System.out.print(" – neue Punktezahl " + event.getNewscore());
		
	}

	@Override
	public void gamehasended(GameEndsEvent event) {
		System.out.print("Geist trifft auf Pac-Man – Spielende");		
	}
}
