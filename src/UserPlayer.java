
public class UserPlayer extends CardPlayer{
	
	private int money;

	public UserPlayer(String name) {
		super(name);
		this.money = 10000;
	}
	
	public void changeMoney(int change) {
		money += change;
	}
	
	public int getMoney() {
		return money;
	}

	@Override
	public void greeting() {
		System.out.println("My name is " + this.getName() + ".");
	}

	@Override
	public boolean wantToHit() {
		return false;
	}
}
