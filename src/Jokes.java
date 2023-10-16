import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Jokes {
	private static ArrayList<String> jokes;
	
	public static void reloadJokes() {
		// Load jokes from file
		try {
			jokes = new ArrayList<String>();
			Scanner scanner = new Scanner(new File("Jokes.txt"));
			while (scanner.hasNext()) {
				jokes.add(scanner.nextLine());
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	};
	
	public static String getJoke() {
		if (jokes.size() >= 1) {
			// Return random joke and remove it from arraylist
			return jokes.remove((int) (Math.random() * jokes.size()));
		}
		else {
			// Reload jokes and return random joke
			reloadJokes();
			return jokes.remove((int) (Math.random() * jokes.size()));
		}

	}
}
