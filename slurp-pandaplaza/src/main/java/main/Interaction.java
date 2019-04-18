package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import board.Tile;
import game.Game;

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
					work(i);
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
		commands.add(new String[] { "Add", "Panda" }); // 10
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

	public static void work(int in) {
		switch (in) {
		case 0:
			g = new Game();
			break;
		case 5:
			g.getMap().addTile(new Tile("a0"));
			break;
		case 6:
			if (g.getMap().getTilesList().size() == 0) {
				System.out.println("Ures");
			} else {
				ArrayList<Tile> list = g.getMap().getTilesList();
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getID());
				}
			}
			break;
		}
	}
}
