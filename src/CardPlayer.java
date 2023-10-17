import java.util.ArrayList;

public abstract class CardPlayer {
	// regular variables and methods
	private String name;
	private ArrayList<Integer> hand;
	private ArrayList<Integer> aces;
	
	public CardPlayer(String name){
		// initialize object variables
		this.name = name;
		this.hand = new ArrayList<Integer>();
		this.aces = new ArrayList<Integer>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		int value = 0;
		
		// calculate normal cards
		for (int i = 0; i < hand.size(); i++) {
			value = value + Deck.getValueById(hand.get(i));
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
		// get card Id
		int cardId = Deck.getTopCard();
		
		// add card to hand if normal card, add to aces if ace
		if (cardId <= 4) {
			aces.add(cardId);
		}
		else {
			hand.add(cardId);
		}
	}
	
	public int getHandSize() {
		return hand.size() + aces.size();
	}
	
	public void tellJoke() {
		System.out.println("\n" + this.getName() + ": " + Jokes.getJoke());
	}
	
	public void printHand() {
		// output player's hand
		System.out.print(this.getName() + "'s hand: ");
		for (int i = 0; i < hand.size(); i++) {
			System.out.print(Deck.getCardStringById(hand.get(i)) + " ");
		}
		for (int i = 0; i < aces.size(); i++) {
			System.out.print(Deck.getCardStringById(aces.get(i)) + " ");
		}
		
		System.out.print(" [Value: " + this.getValue() + "]\n");
	}
	
	public void clearHand() {
		// reset hand
		hand.clear();
		aces.clear();
	}
	
	
	// abstract methods
	public abstract void greeting();	
}
