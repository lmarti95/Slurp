package game;

import board.Tile;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:31:02
 */
public class Player {

	private int life;
	private static int points;

	public Player(){
		points = 0;
	}

	public void finalize() throws Throwable {

	}
	public static void addPoints(){
		points++;
	}

	public static int getPoints(){
		return points;
	}

	/**
	 * csemp�n van �llat
	 *       catch(�llat)
	 * nincs �llat
	 *      move(tile)
	 * 
	 * @param tile
	 */
	public void click(Tile tile){

	}

	public void nextOrangutan(){

	}
}//end Player