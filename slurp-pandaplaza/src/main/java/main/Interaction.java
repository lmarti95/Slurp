package main;

import java.io.*;
import java.util.ArrayList;

import board.*;
import characters.*;
import game.*;

//interaction class felhasznalo bevitelek kezelesere
public class Interaction {

	private static ArrayList<String[]> commands = new ArrayList<String[]>();
	private static Game g;

	public static void listen(Reader in, boolean writeToFile) throws IOException {
		//addCommands();
		Logger.setToFile(writeToFile);
		BufferedReader br = new BufferedReader(in);
		String line;
		while ((line = br.readLine()) != null) {
			String[] lineArray=line.split(":");
			String command = lineArray[0];
			String params = "";
			if(lineArray.length>1) {
				params = lineArray[1];
			}

				Command cmd = Command.getCommandByValue(command);
			if(cmd != null) {
				work(cmd, params);
			}else {
				Logger.log("No such command found, please try another!");
			}

		}
	}


	public static void work(Command cmd, String line) {
		String[] words = line.split(" ");
		switch (cmd) {
		// Start New Game
		case NEW_GAME:
			g = new Game();
			break;
		// Add Tile
		case ADD_TILE:
			switch (words[1]) {
			case "arcade":
				g.getMap().addTile(new Arcade(words[0], Integer.parseInt(words[2])));
				break;
			case "armchair":
				g.getMap().addTile(new Armchair(words[0], Integer.parseInt(words[2])));
				break;
			case "closet":
				g.getMap().addTile(new Closet(words[0], Integer.parseInt(words[2])));
				break;
			case "vendingMach":
				g.getMap().addTile(new VendingMachine(words[0], Integer.parseInt(words[2])));
				break;
			case "-":
				g.getMap().addTile(new Tile(words[0], Integer.parseInt(words[2])));
				break;
			case "exit":
				g.getMap().addTile(new Exit(words[0], Integer.parseInt(words[2])));
				break;
			}
			break;
		// List Tiles
		case LIST_TILES:
			if (g.getMap().getTilesList().size() == 0) {
				System.out.println("Ures");
			} else {
				ArrayList<Tile> list = g.getMap().getTilesList();
				for (int i = 0; i < list.size(); i++) {
					String neighbours;
					if (list.get(i).getNeighbours().size() == 0) {
						neighbours = "-";
					} else {
						neighbours = list.get(i).getNeighbours().get(0).getID();
						for (int j = 1; j < list.get(i).getNeighbours().size(); j++) {
							neighbours = neighbours + "," + list.get(i).getNeighbours().get(j).getID();
						}
					}
					String type = list.get(i).getClass().getSimpleName().toUpperCase();//.toString().substring(12).toUpperCase();
					if(type.equals("TILE")) {
						type="-";
					}
					if(g.getMap().getEntry()==list.get(i)) {
						type ="ENTRY";
					}
					Logger.log(list.get(i).getID() + "\t" + neighbours + "\t" + type + "\t"  + list.get(i).getDurability());
				}
			}
			break;
		//Add Player
		case ADD_PLAYER:
			g.getMap().addPlayer(new Player(words[2]));
			break;
		// Place Panda
		case PLACE_PANDA:
			switch (words[2]) {
			case "LAZY":
				PandaLazy p0 = new PandaLazy(words[0]);
				placePanda(p0, words[1]);
				break;
			case "BEEP":
				PandaBeep p1 = new PandaBeep(words[0]);
				placePanda(p1, words[1]);
				break;
			case "TINKLE":
				PandaTinkle p2 = new PandaTinkle(words[0]);
				placePanda(p2, words[1]);
				break;
			}

			break;
		// Connect Tiles
		case CONNECT_TILES:
			Tile t1 = g.getMap().getTile(words[0]);
			Tile t2 = g.getMap().getTile(words[1]);
			t1.addNeighbour(t2);
			t2.addNeighbour(t1);
			break;
		//Connect Closets
		case CONNECT_CLOSETS:
			Closet c1 = (Closet) g.getMap().getTile(words[0]);
			Closet c2 = (Closet) g.getMap().getTile(words[1]);
			c1.setOtherCloset(c2);
			c2.setOtherCloset(c1);
			break;
		//Select Entry
		case SELECT_ENTRY:
			g.getMap().setEntry(g.getMap().getTile(words[0]));
			break;
		// List Pandas
		case LIST_PANDAS:
			ArrayList<Panda> pandas = g.getMap().getPandaList();
			if(pandas == null){
				return;
			}
			for (int i = 0; i < pandas.size(); i++) {
				Panda p = pandas.get(i);
				String type = p.getClass().toString().substring(22).toUpperCase();
				String follower;
				String following;
				if (p.getFollowed() == null) {
					following = "-";
				} else {
					following = p.getFollowed().getID();
				}
				if (p.getFollower() == null) {
					follower = "-";
				} else {
					follower = p.getFollower().getID();
				}
				Logger.log(
						p.getID() + "\t" + type + "\t" + following + "\t" + follower + "\t" + p.getLocation().getID());
			}
			break;
		case MOVE_ORANGUTAN:
			ArrayList<Player> players = g.getMap().getPlayers();
			for(int i=0;i<players.size();i++) {
				if(words[0].charAt(1) == players.get(i).getID().charAt(2)) {
					 players.get(i).getOrangutan().move(g.getMap().getTile(words[1]));
				}
			}
			break;
		case MOVE_PANDA:
			g.getMap().getPanda(words[0]).move(g.getMap().getTile(words[1]));
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
