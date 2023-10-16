import java.util.ArrayList;

public abstract class CardPlayer {
	// regular variables and methods
	private String name;
	private ArrayList<String[]> hand;
	private ArrayList<String[]> aces;
	
	public CardPlayer(String name){
		this.name = name;
		this.hand = new ArrayList<String[]>();
		this.aces = new ArrayList<String[]>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		int value = 0;
		
		// calculate normal cards
		for (int i = 0; i < hand.size(); i++) {
			if(hand.get(i)[0].equals("J")) {
				value += 10;
			}
			else if(hand.get(i)[0].equals("Q")) {
				value += 10;
			}
			else if(hand.get(i)[0].equals("K")) {
				value += 10;
			}
			else {
				value = value + Integer.parseInt(hand.get(i)[0]);
			}
		}
		
		// calculate aces
		for (int i = 0; i <= aces.size(); i++) {
			int elevens = aces.size() - i;
			int ones = i;
			
			if (value + elevens * 11 + ones * 1 <= 21 || i == aces.size()) {
				value += elevens * 11;
				value += ones * 1;
				break;
			}
		}
		
		
		return value;
	}
	
	public void hit() {
		String[] card = Deck.getTopCard();
		
		if (card[0].equals("A")) {
			aces.add(card);
		}
		else {
			hand.add(card);
		}
	}
	
	public int getHandSize() {
		return hand.size() + aces.size();
	}
	
	public void tellJoke() {
		System.out.println("\n" + this.getName() + ": " + Jokes.getJoke());
	}
	
	public void printHand() {
		System.out.print(this.getName() + "'s hand: ");
		for (int i = 0; i < hand.size(); i++) {
			System.out.print(hand.get(i)[0] + "" + hand.get(i)[1] + " ");
		}
		for (int i = 0; i < aces.size(); i++) {
			System.out.print(aces.get(i)[0] + "" + aces.get(i)[1] + " ");
		}
		
		System.out.print(" [Value: " + this.getValue() + "]\n");
	}
	
	public void clearHand() {
		hand.clear();
		aces.clear();
	}
	
	
	// abstract methods
	public abstract void greeting();	
}
