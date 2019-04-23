package game;

import board.Tile;
import characters.Orangutan;

public class Player {

	private int life = 3;
	private static int points;
	private String ID;
	private Orangutan og;
	private int nextID = 1;

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
		if(life > 0) {
			og = new Orangutan(ID.substring(nextID));
			Game.getMap().getEntry().setAnimal(og);
		}
	}
	
	public Orangutan getOrangutan() {
		return og;
	}
	
	public int getLife(){
		return life;
	}

	public void reduceLife() {
		life--;
		nextID++;
		nextOrangutan();
	}
	
	public String getID() {
		return ID;
	}
}//end Player