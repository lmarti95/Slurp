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
	private int points = 0;

	/**
	 * Játékos egyedi azonosítója
	 */
	private String ID;

	/**
	 * Játékos álltal irányított orángután
	 */
	private Orangutan og;
	private int nextID = 1;

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
	public void addPoints(){
		points++;
	}

	/**
	 * Pontok lekérdezésére szoilgáló segédfüggvény
	 * @return megszerzett pontok
	 */
	public int getPoints(){
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
		if(life > 0) {
            og = new Orangutan('O'+ID.substring(1));
			Game.getMap().getEntry().setAnimal(og);
		}
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

	public void reduceLife() {
		life--;
		nextID++;
		nextOrangutan();
	}


	/**
	 * Játékos azonosítóját megadó függvény
	 * @return játékos azonosítója
	 */
	public String getID() {
		return ID;
	}
}//end Player