package game;

import board.Tile;
import characters.Orangutan;

/**
 * Játékost reprezentáló osztály
 */
public class Player {

	/**
	 * Életek száma
	 */
	private int life = 3;

	/**
	 * Kapont pontok száma
	 */
	private static int points;

	/**
	 * Játékos egyedi azonosítója
	 */
	private String ID;

	/**
	 * Játékos álltal irányított orángután
	 */
	private Orangutan og;

	/**
	 * Új játékos létrehozása
	 * @param ID egyedi azonosítója
	 */
	public Player(String ID){
		points = 0;
		this.ID=ID;
		nextOrangutan();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * Játéékos pontot kap.
	 */
	public static void addPoints(){
		points++;
	}

	/**
	 * Pontok lekérdezésére szoilgáló segédfüggvény
	 * @return megszerzett pontok
	 */
	public static int getPoints(){
		return points;
	}


	/**
	 * Játékos mező kiválasztását lekezelő segédfüggvény
	 * @param tile a kiválasztott mező
	 */
	public void click(Tile tile){

	}

	/**
	 * Új orángután felhelyezése a pályára
	 */
	public void nextOrangutan(){
		og = new Orangutan(ID.substring(1));
		Game.getMap().getEntry().setAnimal(og);
	}

	/**
	 * Orángutánt visszaadó segédfüggvény
	 * @return
	 */
	public Orangutan getOrangutan() {
		return og;
	}

	/**
	 * Hátralévő életeket megadó függvény
	 * @return
	 */
	public int getLife(){
		return life;
	}


	/**
	 * Játékos azonosítóját megadó függvény
	 * @return játékos azonosítója
	 */
	public String getID() {
		return ID;
	}
}//end Player