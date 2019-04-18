
package board;

import java.util.ArrayList;

import characters.Panda;
import game.Timer;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:55
 */
public class Map {

	//bejárat
	private Tile entry;

	private ArrayList<Tile> tilesList;

	public Map(){
		tilesList = new ArrayList<Tile>();
	}

	public void finalize() throws Throwable {

	}
	//Pandát helyezünk el a játéktéren
	public void placePanda(Panda panda){
		//panda.setLocation(new Tile());
		Timer.addSteppable(panda);
	}

	public Tile getEntry(){
		return entry;
	}
	
	public ArrayList<Tile> getTilesList() {
		return tilesList;
	}
	public void addTile(Tile t) {
		tilesList.add(t);
	}
}//end Map