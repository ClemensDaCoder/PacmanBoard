package pacman.view;

import java.util.HashMap;

import pacman.model.Field;
import pacman.model.Position;
import pacman.event.HasMovedListener;
import pacman.event.HasmovedEvent;


public class TextView implements PacmanView , HasMovedListener{
	
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
		//e.getOldPos().toString();		
	}
}