package pacman.event;

import java.util.EventListener;

public interface FieldListener extends EventListener {

	public void bonusObjectEaten(BonusObjectEatenEvent event);

	public void gameOver(GameOverEvent event);

}
