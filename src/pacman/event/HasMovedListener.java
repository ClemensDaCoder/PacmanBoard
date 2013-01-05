package pacman.event;

import java.util.EventListener;

import pacman.event.HasmovedEvent;


public interface HasMovedListener extends EventListener{
	
	void hasmoved(HasmovedEvent e);
	
}
