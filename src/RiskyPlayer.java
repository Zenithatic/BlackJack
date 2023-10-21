
public class RiskyPlayer extends CardPlayer {
	
	public RiskyPlayer(String name) {
		super(name);
	}
	
	@Override
	public void greeting() {
		System.out.println("Hello. My name is " + this.getName() + " and I make more risky plays than the others.");
	}
	
	@Override
	public boolean wantToHit() {
		if (this.getValue() <= 17) {
			return true;
		}
		else {
			return false;
		}
	}
}
