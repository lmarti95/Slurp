
package board;

import java.util.ArrayList;

import characters.Panda;
import game.Steppable;
import game.Timer;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:55
 */
public class Map {

	// bejárat
	private Tile entry;

	private ArrayList<Tile> tilesList;
	private static ArrayList<Panda> pandaList;

	public Map() {
		tilesList = new ArrayList<Tile>();
		pandaList = new ArrayList<Panda>();
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

	public static void addPanda(Panda p){
		pandaList.add(p);
	}

	public static void removePanda(Panda p){
		pandaList.remove(p);
	}
	
	public static  ArrayList<Panda> getPandaList(){
		return pandaList;
	}
	
}// end Map