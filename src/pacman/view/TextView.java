package pacman.view;

import pacman.event.BonusObjectEatenEvent;
import pacman.event.FruitPlacedEvent;
import pacman.event.GameOverEvent;
import pacman.event.HasMovedEvent;
import pacman.event.MoveNotPossibleEvent;
import pacman.event.MovingObjectPlacedEvent;
import pacman.event.NextLevelEvent;
import pacman.event.ScoreChangedEvent;


public class TextView implements PacmanView {

	@Override
	public void hasmoved(HasMovedEvent e) {
		System.out.println(e.getMov().getName() + " has moved from " + e.getOldPos().toString() + " to " + e.getNewPos().toString());
		//e.getOldPos().toString();		
	}

	@Override
	public void moveNotpossible(MoveNotPossibleEvent e) {
		System.out.println(e.getSource().getName() + " hits wall – does not move");
		
	}

	@Override
	public void bonusObjectEaten(BonusObjectEatenEvent event) {
		System.out.println("Pac-Man eats" + event.getSource().getName());
	}

	@Override
	public void scoreChanged(ScoreChangedEvent event) {
		System.out.println("New score " + event.getSource());
		
	}

	@Override
	public void gameOver(GameOverEvent event) {
		System.out.println("Ghost kills PacMan – Game Over");		
		System.exit(0);
	}

	@Override
	public void fruitwasplaced(FruitPlacedEvent event) {
		System.out.println("Field: " + event.getPos().toString() + " - Fruit ("+ event.getFruit().toString() + ")");
	}

	@Override
	public void nextLevel(NextLevelEvent event) {
		System.out.println("Level finished!");
		
	}

	@Override
	public void movingobjectwasplaced(MovingObjectPlacedEvent event) {
		System.out.println("Field: "+ event.getPos().toString() + " " + event.getMov().getName());
		
	}
}
