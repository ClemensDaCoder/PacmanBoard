package pacman.event;

public class ScoreChangedEvent extends java.util.EventObject{

	private int newscore;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScoreChangedEvent(Integer newscore) {
		super(newscore);
		this.newscore = newscore;
		
		// TODO Auto-generated constructor stub
	}

	public int getNewscore() {
		return newscore;
	}

}
