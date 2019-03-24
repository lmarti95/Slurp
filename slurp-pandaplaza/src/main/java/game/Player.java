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

	//Új játékos létrehozása
	public Player(){
		points = 0;
	}


	//Új játékos kap pontot
	public void finalize() throws Throwable {

	}

	//Játé
	public static void addPoints(){
		points++;
	}

	public static int getPoints(){
		return points;
	}


	public void click(Tile tile){

	}

	public void nextOrangutan(){

	}
}//end Player