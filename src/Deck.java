import java.util.ArrayList;

//♦♣♥♠

public class Deck {
	private static ArrayList<String[]> deck; 
	private static ArrayList<String[]> reference;
	
	public static void resetDeck() {
		// reset deck to fresh deck
		deck = new ArrayList<String[]>();
		
		for (int i = 1; i <= 13; i++) {
			if (i == 1) {
				String[] c1 = {"A", "♦", "1", "-1"};
				String[] c2 = {"A", "♣", "2", "-1"};
				String[] c3 = {"A", "♥", "3", "-1"};
				String[] c4 = {"A", "♠", "4", "-1"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
			else if (i == 11) {
				String[] c1 = {"J", "♦", "41", "10"};
				String[] c2 = {"J", "♣", "42", "10"};
				String[] c3 = {"J", "♥", "43", "10"};
				String[] c4 = {"J", "♠", "44", "10"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
			else if (i == 12) {
				String[] c1 = {"Q", "♦", "45", "10"};
				String[] c2 = {"Q", "♣", "46", "10"};
				String[] c3 = {"Q", "♥", "47", "10"};
				String[] c4 = {"Q", "♠", "48", "10"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
			else if (i == 13) {
				String[] c1 = {"K", "♦", "49", "10"};
				String[] c2 = {"K", "♣", "50", "10"};
				String[] c3 = {"K", "♥", "51", "10"};
				String[] c4 = {"K", "♠", "52", "10"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
			else {
				String[] c1 = {String.valueOf(i), "♦", String.valueOf((4 * (i - 1)) + 1), String.valueOf(i)};
				String[] c2 = {String.valueOf(i), "♣", String.valueOf((4 * (i - 1)) + 2), String.valueOf(i)};
				String[] c3 = {String.valueOf(i), "♥", String.valueOf((4 * (i - 1)) + 3), String.valueOf(i)};
				String[] c4 = {String.valueOf(i), "♠", String.valueOf((4 * (i - 1)) + 4), String.valueOf(i)};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
		}
		
		// create reference deck for future use
		reference = new ArrayList<String[]>();
		reference = (ArrayList<String[]>) deck.clone();
	}
	
	public static void shuffleDeck() {
		// move cards in a deck to random indexes twice to shuffle
		for (int i = 0; i < deck.size(); i++) {
			int swapTo = (int) (Math.random() * deck.size());
			
			String[] temp = deck.get(swapTo);
			deck.set(swapTo, deck.get(i));
			deck.set(i, temp);
		}
		for (int i = 0; i < deck.size(); i++) {
			int swapTo = (int) (Math.random() * deck.size());
			
			String[] temp = deck.get(swapTo);
			deck.set(swapTo, deck.get(i));
			deck.set(i, temp);
		}
	}
	
	public static void printDeck() {
		// output deck to console
		for (int i = 0; i < deck.size(); i++) {
			System.out.print(deck.get(i)[0] + "" + deck.get(i)[1] + " ");
		}
		System.out.println("");
	}
	
	public static int getTopCard() {
		// return card id
		return(Integer.parseInt(deck.remove(0)[2]));
	}
	
	public static int getCardCount() {
		return deck.size();
	}
	
	public static int getValueById(int id) {
		// return value of a card given its Id
		return Integer.parseInt(reference.get(id - 1)[3]);
	}
	
	public static String getCardStringById(int id) {
		// return string representation of card given its Id
		return reference.get(id - 1)[0] + reference.get(id - 1)[1];
	}
}
