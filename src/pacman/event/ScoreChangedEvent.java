package pacman.event;

import java.util.EventObject;

public class ScoreChangedEvent extends EventObject {

	private int newScore;

	public ScoreChangedEvent(int newScore) {
		super(newScore);
		this.newScore = newScore;
	}

	public int getNewScore() {
		return newScore;
	}

}
