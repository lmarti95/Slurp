package main.java.game;

import main.java.board.Map;

/**
 * A j�t�kot reprezent�l� oszt�ly. Ez v�gzi a j�t�k elind�t�s�t �s v�g�nek vizsg�lat�t.
 */
public class Game {
	
	private static Game single_instance=null;

	/**
	 * Minden j�t�k egy j�t�kteren j�tsz�dik, ezt nyilv�n kell tartani
	 */
	private static Map map;

	/**
	 * Konstruktor. L�trehoz egy j�t�kteret
	 */
	public Game(){
		map = new Map();
		single_instance=this;
	}

	/**
	 * A j�t�k v�g�t viszg�l� seg�df�ggv�ny
	 */
	public void endGame(){

	}

	/**
	 * J�t�kt�r l�trehoz�sa
	 */
	public void initMap(){

	}

	/**
	 * �j j�t�k ind�t�sa
	 */
	public void newGame(){

	}

	/**
	 * A j�t�kt�r lek�rdez�s�t seg�t� f�ggv�ny
	 * @return a j�t�kt�r
	 */
	public static Map getMap(){
		return map;
	}

	public static Game getInstance() {
		new Game();
		return single_instance;
	}
}