package pacman.model.bonus;

public abstract class Fruit extends BonusObject {
	
	public Fruit(String name, int value) {
		super(name, value);
	}

	protected static int CHERRY_VALUE = 150;
	protected static int PEACH_VALUE = 100;

	@Override
	public void executeAction() {
		//empty because fruits do nothing special		
	}

}
