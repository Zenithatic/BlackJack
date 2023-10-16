import java.util.ArrayList;

//♦♣♥♠

public class Deck {
	private static ArrayList<String[]> deck; 
	
	public static void resetDeck() {
		deck = new ArrayList<String[]>();
		
		for (int i = 1; i <= 13; i++) {
			if (i == 1) {
				String[] c1 = {"A", "♦"};
				String[] c2 = {"A", "♣"};
				String[] c3 = {"A", "♥"};
				String[] c4 = {"A", "♠"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
			else if (i == 11) {
				String[] c1 = {"J", "♦"};
				String[] c2 = {"J", "♣"};
				String[] c3 = {"J", "♥"};
				String[] c4 = {"J", "♠"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
			else if (i == 12) {
				String[] c1 = {"Q", "♦"};
				String[] c2 = {"Q", "♣"};
				String[] c3 = {"Q", "♥"};
				String[] c4 = {"Q", "♠"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
			else if (i == 13) {
				String[] c1 = {"K", "♦"};
				String[] c2 = {"K", "♣"};
				String[] c3 = {"K", "♥"};
				String[] c4 = {"K", "♠"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
			else {
				String[] c1 = {String.valueOf(i), "♦"};
				String[] c2 = {String.valueOf(i), "♣"};
				String[] c3 = {String.valueOf(i), "♥"};
				String[] c4 = {String.valueOf(i), "♠"};
				
				deck.add(c1);
				deck.add(c2);
				deck.add(c3);
				deck.add(c4);
			}
		}
		
		System.out.println(deck.size());
	}
	
	public static void shuffleDeck() {
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
		for (int i = 0; i < deck.size(); i++) {
			System.out.print(deck.get(i)[0] + "" + deck.get(i)[1] + " ");
		}
		System.out.println("");
	}
	
	public static String[] getTopCard() {
		return(deck.remove(0));
	}
	
	public static int getCardCount() {
		return deck.size();
	}
}
