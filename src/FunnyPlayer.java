
public class FunnyPlayer extends CardPlayer{
	
	public FunnyPlayer(String name) {
		super(name);
	}

	@Override
	public void greeting() {
		System.out.println("Hello! My name is " + this.getName() + " and I'll try to make your blackjack experience as fun as possible." + " Heres a joke: " + Jokes.getJoke());
	}
	
	@Override
	public boolean wantToHit() {
		if (this.getValue() <= 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void hit() {
		super.hit();
		this.tellJoke();
	}
}
