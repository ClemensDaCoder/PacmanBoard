package pacman.event;

import java.util.EventListener;

public interface FieldListener extends EventListener{
	
	void bonusObjectEaten(BonusObjectEatenEvent event);


	void gamehasended(GameEndsEvent event);

}

