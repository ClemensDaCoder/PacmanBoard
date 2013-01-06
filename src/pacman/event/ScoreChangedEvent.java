package pacman.event;

import java.util.EventObject;

public class ScoreChangedEvent extends EventObject {

	private int newscore;

	private static final long serialVersionUID = 1L;

	public ScoreChangedEvent(Integer newscore) {
		super(newscore);
		this.newscore = newscore;
	}

	public int getNewscore() {
		return newscore;
	}

}
