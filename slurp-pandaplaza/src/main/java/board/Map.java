package board;

import java.util.ArrayList;

import characters.Panda;
import game.*;

/**
 * Játékteret reprezentáló objektum. Nyílvántartja és kezeli a pandákat és a játékosokat
 */
public class Map {

	/**
	 * A játéktér megjegyzi a bejáratot
	 */
	private Tile entry;

	/**
	 * A játéktér tárolja a mezőit
	 */
	private ArrayList<Tile> tilesList;

	/**
	 * A játéktér tárolja a pandákat
	 */
	private static ArrayList<Panda> pandaList;

	/**
	 * A játéktér tárolja a játékosokat
	 */
	private static ArrayList<Player> playerList;

	/**
	 * Konstruktor. Inícializálja anyílvántartott adatszerkezeteket.
	 */
	public Map() {
		tilesList = new ArrayList<Tile>();
		pandaList = new ArrayList<Panda>();
		playerList = new ArrayList<Player>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * Panda elhelyezésére szolgáló segédfüggvény
	 * @param panda az elhelyezendő panda
	 */
	public void placePanda(Panda panda) {
		// panda.setLocation(new Tile());
		Timer.addSteppable(panda);
	}

	/**
	 * A bejáratot visszaadó függvény
	 * @return a bejárat
	 */
	public Tile getEntry() {
		return entry;
	}

	/**
	 * A bejáratot beállító függvény
	 * @param t melyik csempe legyen a bejárat
	 */
	public void setEntry(Tile t) {
		entry=t;
	}

	/**
	 * Az összes csempét visszaadó függvény
	 * @return a csempék listája
	 */
	public ArrayList<Tile> getTilesList() {
		return tilesList;
	}

	/**
	 * Csempe hozzáadása a játéktérhez.
	 * @param t az új csempe
	 */
	public void addTile(Tile t) {
		tilesList.add(t);
	}

	/**
	 * Visszaad egy csempét egyedi azonosító szerint
	 * @param tileID egyedi azonosító a kívánt csempéhez
	 * @return a kívánt csempe objektum vagy null, ha nincs ilyen csempe
	 */
	public Tile getTile(String tileID) {
		for (int i = 0; i < tilesList.size(); i++) {
			if (tilesList.get(i).getID().equals(tileID)) {
				return tilesList.get(i);
			}
		}
		return null;
	}

	/**
	 * Visszaad egy pandát egyedi azonosító szerint
	 * @param pandaID egyedi azonosító a kívánt pandához
	 * @return a kívánt panda objektum vagy null, ha nincs ilyen panda
	 */
	public Panda getPanda(String pandaID) {
		for (int i = 0; i < pandaList.size(); i++) {
			if (pandaList.get(i).getID().equals(pandaID)) {
				return pandaList.get(i);
			}
		}
		return null;
	}

	/**
	 * Segédfüggvény, ami visszadja a játékosokat
	 * @return a játékosok listája
	 */
	public  ArrayList<Player> getPlayers(){
		return playerList;
	}

	/**
	 * Panda hozzáadását lehetővé tévő függvény
	 * @param p az új panda
	 */
	public static void addPanda(Panda p){
		pandaList.add(p);
	}

	/**
	 * Panda törlése a játéktérből
	 * @param p a törlendő panda
	 */
	public static void removePanda(Panda p){
		pandaList.remove(p);
	}

	/**
	 * Játékos hozzáadása a játéktérhez
	 * @param p az új játékos
	 */
	public static void addPlayer(Player p){
		playerList.add(p);
	}

	/**
	 * Játékos törlése a játéktérből
	 * @param p a törlendő játékos
	 */
	public static void removePlayer(Player p){
		playerList.remove(p);
	}

	/**
	 * Az összes pandát visszaadó segédfüggvény
	 * @return az összes panda listája
	 */
	public static  ArrayList<Panda> getPandaList(){
		return pandaList;
	}
	
}// end Map