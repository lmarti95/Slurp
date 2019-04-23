package game;

import board.Map;

/**
 * A játékot reprezentáló osztály. Ez végzi a játék elindítását és végének vizsgálatát.
 */
public class Game {
	
	private static Game single_instance=null;

	/**
	 * Minden játék egy játékteren játszódik, ezt nyilván kell tartani
	 */
	private static Map map;

	/**
	 * Konstruktor. Létrehoz egy játékteret
	 */
	public Game(){
		map = new Map();
		single_instance=this;
	}

	/**
	 * A játék végét viszgáló segédfüggvény
	 */
	public void endGame(){

	}

	/**
	 * Játéktér létrehozása
	 */
	public void initMap(){

	}

	/**
	 * Új játék indítása
	 */
	public void newGame(){

	}

	/**
	 * A játéktér lekérdezését segítő függvény
	 * @return a játéktér
	 */
	public static Map getMap(){
		return map;
	}

	public static Game getInstance() {
		
		return single_instance;
	}
}