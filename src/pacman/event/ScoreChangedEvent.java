package pacman.event;

import java.util.EventObject;

public class ScoreChangedEvent extends EventObject {

	private int newScore;

	private static final long serialVersionUID = 1L;

	public ScoreChangedEvent(Integer newScore) {
		super(newScore);
		this.newScore = newScore;
	}

	public int getNewscore() {
		return newScore;
	}

}
