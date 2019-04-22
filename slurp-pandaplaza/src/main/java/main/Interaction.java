package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import board.*;
import characters.*;
import game.Game;
import game.Steppable;
import game.Timer;

//interaction class felhasznalo bevitelek kezelesere
public class Interaction {

	private static ArrayList<String[]> commands = new ArrayList<String[]>();
	private static Game g;

	public static void listen() throws IOException {
		addCommands();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = br.readLine();
			for (int i = 0; i < commands.size(); i++) {
				if (decode(line, commands.get(i))) {
					work(i, line);
					i = commands.size();
				}
			}
		}
	}

	private static void addCommands() {
		commands.add(new String[] { "Start", "New", "Game" }); // 0
		commands.add(new String[] { "Load", "Game", "State" }); // 1
		commands.add(new String[] { "Save", "Game", "State" }); // 2
		commands.add(new String[] { "Move", "Orangutan" }); // 3
		commands.add(new String[] { "Move", "Panda" }); // 4
		commands.add(new String[] { "Add", "Tile" }); // 5
		commands.add(new String[] { "List", "Tiles" }); // 6
		commands.add(new String[] { "List", "Players" }); // 7
		commands.add(new String[] { "Release", "Pandas" }); // 8
		commands.add(new String[] { "Add", "Player" }); // 9
		commands.add(new String[] { "Place", "Panda" }); // 10
		commands.add(new String[] { "Control", "Things" }); // 11
		commands.add(new String[] { "Connect", "Tiles" }); // 12
		commands.add(new String[] { "Connect", "Orangutan", "Panda" }); // 13
		commands.add(new String[] { "Connect", "Closets" }); // 14
		commands.add(new String[] { "Select", "Entry" }); // 15
		commands.add(new String[] { "List", "Pandas" }); // 16
	}

	public static boolean decode(String str, String[] command) {
		String[] words = str.split(" ");
		if (words.length >= command.length) {
			for (int i = 0; i < command.length; i++) {
				if (!words[i].equals(command[i])) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public static void work(int in, String line) {
		String[] words = line.split(" ");
		switch (in) {
		// Start New Game
		case 0:
			g = new Game();
			break;
		// Add Tile
		case 5:
			switch (words[3]) {
			case "arcade":
				g.getMap().addTile(new Arcade(words[2], Integer.parseInt(words[4])));
				break;
			case "armchair":
				g.getMap().addTile(new Armchair(words[2], Integer.parseInt(words[4])));
				break;
			case "closet":
				g.getMap().addTile(new Closet(words[2], Integer.parseInt(words[4])));
				break;
			case "vendingMach":
				g.getMap().addTile(new VendingMachine(words[2], Integer.parseInt(words[4])));
				break;
			case "-":
				g.getMap().addTile(new Tile(words[2], Integer.parseInt(words[4])));
				break;
			case "exit":
				g.getMap().addTile(new Exit(words[2], Integer.parseInt(words[4])));
				break;
			}
			break;
		// List Tiles
		case 6:
			if (g.getMap().getTilesList().size() == 0) {
				System.out.println("Ures");
			} else {
				ArrayList<Tile> list = g.getMap().getTilesList();
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getID() + "\t" + list.get(i).getDurability());
				}
			}
			break;
		//Place Panda
		case 10:
			switch(words[4]) {
			case "LAZY":
				PandaLazy p0 = new PandaLazy(words[2]);
				placePanda(p0, words[3]);
				break;
			case "BEEP":
				PandaBeep p1 = new PandaBeep(words[2]);
				placePanda(p1, words[3]);
				break;
			case "TINKLE":
				PandaTinkle p2 = new PandaTinkle(words[2]);
				placePanda(p2, words[3]);
				break;
			}
			
			break;
		//List Pandas
		case 16:
			ArrayList<Panda> pandas = g.getMap().getPandaList();
			for(int i=0;i<pandas.size();i++) {
				Panda p = pandas.get(i);
				String type = p.getClass().toString().substring(22).toUpperCase();
				String follower;
				String following;
				if(p.getFollowed() == null) {
					following = "-";
				} else {
					following = p.getFollowed().getID();
				}
				if(p.getFollower() == null) {
					follower = "-";
				} else {
					follower = p.getFollower().getID();
				}
				System.out.println(p.getID() + "\t" + type + "\t" + following + "\t" + follower + "\t" + p.getLocation().getID());
			}
			break;
		}
	
	}
	
	public static void placePanda(Panda p, String tileID) {
		g.getMap().getTile(tileID).setAnimal(p);
		p.setLocation(g.getMap().getTile(tileID));
		g.getMap().addPanda(p);
		Timer.addSteppable(p);
	}
}
