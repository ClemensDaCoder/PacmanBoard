package pacman.event;

import java.util.EventObject;

public class ScoreChangedEvent extends EventObject {

	private int newScore;

	/** Creates a new ScoreChangedEvent.
	 * 
	 * @param newScore
	 */
	public ScoreChangedEvent(int newScore) {
		super(newScore);
		this.newScore = newScore;
	}

	/**
	 * @return the new score.
	 */
	public int getNewScore() {
		return newScore; 
	}

}
