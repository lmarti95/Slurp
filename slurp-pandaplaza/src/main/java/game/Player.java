package game;

import board.Tile;
import characters.Orangutan;

public class Player {

	private int life = 3;
	private static int points;
	private String ID;
	private Orangutan og;

	//Új játékos létrehozása
	public Player(String ID){
		points = 0;
		this.ID=ID;
		nextOrangutan();
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
		og = new Orangutan(ID.substring(1));
		
	}
	
	public int getLife(){
		return life;
	}
}//end Player