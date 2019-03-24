
package board;

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

	private Tile tileslist;

	public Map(){
		entry = new Tile();
	}

	public void finalize() throws Throwable {

	}
	//Pandát helyezünk el a játéktéren
	public void placePanda(Panda panda){
		panda.setLocation(new Tile());
		Timer.addSteppable(panda);
	}

	public Tile getEntry(){
		return entry;
	}
}//end Map