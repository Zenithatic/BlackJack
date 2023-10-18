import java.util.Scanner;

public class Main {
	
	public static Scanner input;
	
	public static void main(String[] args) {
		// Initialize variables and setup game
		Deck.resetDeck();
		Jokes.reloadJokes();
		input = new Scanner(System.in);
		
		// Welcome user to blackjack
		System.out.println("Welcome to blackjack. What is your name?");
		String name = input.nextLine();
		UserPlayer player = new UserPlayer(name);

		System.out.println("\nWe have 3 players ready to play with you, they will now greet you:\n");
		
		FunnyPlayer joe = new FunnyPlayer("Joe");
		RiskyPlayer max = new RiskyPlayer("Max");
		Dealer dealer = new Dealer("John");
		
		CardPlayer[] players = {(CardPlayer) joe, (CardPlayer) max, (CardPlayer) dealer};
		
		for (int i = 0; i < players.length; i++) {
			players[i].greeting();
		}
		
		System.out.println("");
		System.out.println("Which one would you like to play against? Enter 1 for Joe, 2 for Max, and 3 for John.");
		
		CardPlayer bot;
		while (true) {
			int choice = Integer.parseInt(input.nextLine());
			
			if (choice == 1) {
				System.out.println("You have chosen to play Joe, the funny player.");
				bot = (CardPlayer) joe;
				break;
			}
			else if (choice == 2) {
				System.out.println("You have chosen to play Max, the risky player.");
				bot = (CardPlayer) max;
				break;
			}
			else if (choice == 3) {
				System.out.println("You have chosen to play John, the dealer.");
				bot = (CardPlayer) dealer;
				break;
			}
			else {
				System.out.println("Not a valid choice. Try again.");
			}
		}
		
		// Step 11 of assignment

		Deck.printDeck();
		Deck.shuffleDeck();
		
		// game loop
		gameloop: while (player.getMoney() > 0) {
			// Step 18 of assignment		
			if (Deck.getCardCount() <= 10) {
				System.out.println("--------------------------------------------");
				Deck.resetDeck();
				Deck.shuffleDeck();
				Deck.printDeck();
				System.out.println("--------------------------------------------\n");
			}
			else {
				System.out.println("--------------------------------------------");
				Deck.printDeck();
				System.out.println("--------------------------------------------\n");
			}
			
			// place bets
			int wager;
			while (true) {
				System.out.println(player.getName() + ", how much would you like to wager? " + " You have $" + player.getMoney());
				wager = Integer.parseInt(input.nextLine());
				
				if (wager < 0 || wager > player.getMoney()) {
					System.out.println("Invalid amount. Try again.");
				}
				else {
					break;
				}
			}
			
			// deal starting hand and print hands
			bot.clearHand();
			player.clearHand();
			bot.hit();
			bot.hit();
			player.hit();
			player.hit();
			player.printHand();
			System.out.println(bot.getName() + "'s hand: ???");
			
			// check for blackjack hand
			if (player.getValue() == 21) {
				System.out.println("Blackjack! " + name + " has 21!");
			}
			
			// User gameplay
			while (true) {
				System.out.println("\n" + name + ", would you like to hit [1] or stand [2]?");
				int pick = Integer.parseInt(input.nextLine());
				if (pick == 1) {
					player.hit();
					
					if (player.getValue() > 21) {
						player.printHand();
						System.out.println(name + " busted! " + bot.getName() + " wins.");
						bot.tellJoke();
						
						player.changeMoney(-wager);
						
						if (continuePlaying(player)) {
							continue gameloop;
						}
						else {
							break gameloop;
						}
					}else {
						player.printHand();
						System.out.println(name + " hit!");
						
						if (player.getHandSize() >= 5) {
							System.out.println(name + " reached 5 cards without busting. They win!");
							
							player.changeMoney(wager);
							if (continuePlaying(player)) {
								continue gameloop;
							}
							else {
								break gameloop;
							}
						}
					}
				}
				else if (pick == 2) {
					System.out.println(name + " stands. Other player is now hitting/standing\n");
					break;
				}
				else {
					System.out.println("\nNot a valid option. Try again.");
				}
			}
			
			// bot gameplay
			while (true) {
				if (bot.getName().equals("Joe")) {
					if (bot.getValue() <= 16) {
						bot.hit();
						bot.tellJoke();
						System.out.println(bot.getName() + " hit!");
						bot.printHand();
						
						if (bot.getValue() > 21) {
							System.out.println(bot.getName() + " busted! " + name + " wins.");
							player.changeMoney(wager);
							player.tellJoke();
							
							if (continuePlaying(player)) {
								continue gameloop;
							}
							else {
								break gameloop;
							}
						}
					}
					else {
						System.out.println(bot.getName() + " stands.");
						break;
					}
				}
				else if (bot.getName().equals("Max")) {
					if (bot.getValue() <= 17) {
						bot.hit();
						System.out.println(bot.getName() + " hit!");
						bot.printHand();
						
						if (bot.getValue() > 21) {
							System.out.println(bot.getName() + " busted! " + name + " wins.");
							player.changeMoney(wager);
							player.tellJoke();
							
							if (continuePlaying(player)) {
								continue gameloop;
							}
							else {
								break gameloop;
							}
						}
					}
					else {
						System.out.println(bot.getName() + " stands.");
						break;
					}
				}
				else {
					if (bot.getValue() <= 16) {
						bot.hit();
						System.out.println(bot.getName() + " hit!");
						bot.printHand();
						
						if (bot.getValue() > 21) {
							System.out.println(bot.getName() + " busted! " + name + " wins.");
							player.changeMoney(wager);
							player.tellJoke();
							
							if (continuePlaying(player)) {
								continue gameloop;
							}
							else {
								break gameloop;
							}
						}
					}
					else {
						System.out.println(bot.getName() + " stands.");
						break;
					}
				}
			}
			
			// Determine who wins if both stand
			
			System.out.println("--------------------------------------------\n");
			player.printHand();
			bot.printHand();
			
			if (player.getValue() == bot.getValue()) {
				System.out.println("Tie. Nobody wins.");
				
				if (continuePlaying(player)) {
					continue gameloop;
				}
				else {
					break gameloop;
				}
			}
			else if (player.getValue() > bot.getValue()) {
				System.out.println(name + " wins!");
				player.tellJoke();
				player.changeMoney(wager);
				
				if (continuePlaying(player)) {
					continue gameloop;
				}
				else {
					break gameloop;
				}
			}
			else if (player.getValue() < bot.getValue()) {
				System.out.println(bot.getName() + " wins!");
				bot.tellJoke();
				player.changeMoney(-wager);
				
				if (continuePlaying(player)) {
					continue gameloop;
				}
				else {
					break gameloop;
				}
			}
		}
		
		if (player.getMoney() == 0) {
			System.out.println("\nYou ran out of cash! Better luck next time.");
		}
		else {
			System.out.println("Come back next time!");
		}
		input.close();
	}
	
	public static boolean continuePlaying(UserPlayer player) {
		System.out.println("\nPress anything to continue playing, press N to stop playing:");
		String choice = input.nextLine().toUpperCase();
		
		if (choice.equals("N")) {
			System.out.println("Your resulting cash: " + player.getMoney());
			return false;
		}
		else {
			return true;
		}
	}
}
