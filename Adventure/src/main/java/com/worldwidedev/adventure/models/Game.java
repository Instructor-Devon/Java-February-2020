package com.worldwidedev.adventure.models;

public class Game {
	public static Level[] initializeGame() {
		// construct level 1
				// construct options
		Option dream = new Option(1, "Go back to sleep.");
		Option pizza = new Option(2, "To walk toward the smell of Pizza");
		Option talkCow = new Option(3, "You talk to the Cow.");
		Option petCow = new Option(4, "You pet the cow.");
		Option pinch = new Option(0, "You pinch yourself.");
		Option investigate = new Option(5, "You investigate the sewer walls.");
		
		Level level0 = new Level("The Sewer", 
				"You find yourself awakened in a Sewer.  A faint smell of pizza it present.  So is a tingling sense of danger.",
				new Option[] {dream, pizza, investigate});
		
		Level level1 = new Level("The Dream", 
				"You find yourself amidst a green meadow.  There is a cow, that appears intelligent.",
				new Option[] {talkCow, petCow, pinch});
		
		return new Level[] {level0, level1};
	}
}
