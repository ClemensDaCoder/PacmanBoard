package pacman.view;

import pacman.event.BonusObjectEatenEvent;
import pacman.event.FruitPlacedEvent;
import pacman.event.GameOverEvent;
import pacman.event.HasMovedEvent;
import pacman.event.MoveNotPossibleEvent;
import pacman.event.NextLevelEvent;
import pacman.event.ScoreChangedEvent;


public class TextView implements PacmanView{

	@Override
	public void hasmoved(HasMovedEvent e) {
		System.out.println(e.getMov().getName() + " has moved from " + e.getOldPos().toString() + " to " + e.getNewPos().toString());
		//e.getOldPos().toString();		
	}

	@Override
	public void moveNotpossible(MoveNotPossibleEvent e) {
		System.out.println(e.getSource().getName() + " trifft auf Begrenzung – Kein Ereignis");
		
	}

	@Override
	public void bonusObjectEaten(BonusObjectEatenEvent event) {
		System.out.println("Pac-Man frisst" + event.getSource().getName());
	}

	@Override
	public void scoreChanged(ScoreChangedEvent event) {
		System.out.println("Neue Punktezahl " + event.getSource());
		
	}

	@Override
	public void gameOver(GameOverEvent event) {
		System.out.println("Geist trifft auf Pac-Man – Spielende");		
		System.err.println("STOP STOP STOP STOP STOP STOP STOP");
		System.exit(0);
	}

	@Override
	public void fruitwasplaced(FruitPlacedEvent event) {
		System.out.println("Feld " + event.getPos().toString() + " - Frucht ("+ event.getFruit().toString() + ")");
	}

	@Override
	public void nextLevel(NextLevelEvent event) {
		// TODO KATHI _ WRITE SOMETHING
		
	}
}
