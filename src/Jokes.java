import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Jokes {
	private static ArrayList<String> jokes;
	
	public static void reloadJokes() {
		// Load jokes from file
		try {
			jokes = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("Jokes.txt")));
			String line;
			while ((line = reader.readLine()) != null) {
				jokes.add(line);
			}
		}catch (Exception e) {
			e.printStackTrace();
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
