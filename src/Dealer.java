
public class Dealer extends CardPlayer{
	
	public Dealer(String name) {
		super(name);
	}

	
	@Override
	public void greeting() {
		System.out.println("Hi. My name is " + this.getName() + " and I'm the dealer. I play casually.");
	}
}
