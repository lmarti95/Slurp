
package board;

import java.util.ArrayList;

import characters.Panda;
import game.*;

public class Map {

	// bejárat
	private Tile entry;

	private ArrayList<Tile> tilesList;
	private static ArrayList<Panda> pandaList;
	private static ArrayList<Player> playerList;

	public Map() {
		tilesList = new ArrayList<Tile>();
		pandaList = new ArrayList<Panda>();
		playerList = new ArrayList<Player>();
	}

	public void finalize() throws Throwable {

	}

	// Pandát helyezünk el a játéktéren
	public void placePanda(Panda panda) {
		// panda.setLocation(new Tile());
		Timer.addSteppable(panda);
	}

	public Tile getEntry() {
		return entry;
	}
	
	public void setEntry(Tile t) {
		entry=t;
	}

	public ArrayList<Tile> getTilesList() {
		return tilesList;
	}

	public void addTile(Tile t) {
		tilesList.add(t);
	}

	public Tile getTile(String tileID) {
		for (int i = 0; i < tilesList.size(); i++) {
			if (tilesList.get(i).getID().equals(tileID)) {
				return tilesList.get(i);
			}
		}
		return null;
	}
	
	public Panda getPanda(String pandaID) {
		for (int i = 0; i < pandaList.size(); i++) {
			if (pandaList.get(i).getID().equals(pandaID)) {
				return pandaList.get(i);
			}
		}
		return null;
	}
	
	public  ArrayList<Player> getPlayers(){
		return playerList;
	}

	public static void addPanda(Panda p){
		pandaList.add(p);
	}

	public static void removePanda(Panda p){
		pandaList.remove(p);
	}
	
	public static void addPlayer(Player p){
		playerList.add(p);
	}

	public static void removePlayer(Player p){
		playerList.remove(p);
	}
	
	public static  ArrayList<Panda> getPandaList(){
		return pandaList;
	}
	
}// end Map