package pacman.view;

import java.util.HashMap;

import pacman.model.Field;
import pacman.model.Position;
import pacman.model.move.MovingObject;
import pacman.event.BoardListener;
import pacman.event.HasmovedEvent;
import pacman.event.MoveNotPossibleEvent;
import pacman.event.BonusObjectEatenEvent;
import pacman.event.ScoreChangedEvent;


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
		System.out.println(e.getMov().toString() + " has moved from" + e.getOldPos().toString() + " to " + e.getNewPos().toString());
		//e.getOldPos().toString();		
	}

	@Override
	public void moveNotpossible(MoveNotPossibleEvent e) {
		System.out.println(e.getMov().toString() + " trifft auf Begrenzung – Kein Ereignis");
		
	}

	@Override
	public void pelletEaten(BonusObjectEatenEvent event) {
		System.out.println("Pac-Man frisst Punkt ");
	}

	@Override
	public void scoreChanged(ScoreChangedEvent event) {
		System.out.print(" – neue Punktezahl " + event.getNewscore());
		
	}
}
