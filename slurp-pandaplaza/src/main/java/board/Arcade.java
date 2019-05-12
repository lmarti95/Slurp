package main.java.board;

import main.java.characters.Animal;
import main.java.characters.Panda;
import main.java.game.Steppable;

/**
 * Játékautómatát tartalmazó csempe osztály implementációja
 */
public class Arcade extends Tile implements Steppable {

	/**
	 * Konstruktor. Meghívja az ős konstruktorát.
	 * @param ID a csempe azonosítója
	 * @param durability a csempe erőssége vagy élettartama
	 */
	public Arcade(String ID, int durability){
		super(ID, durability);
	}

	/**
	 * A körök múlását kezelő függvény
	 */
	public void step(){

	}

	/**
	 * A panda és az autómata interakcióját modellező függvény. Elengedi a követő pandákat.
	 */
	public void control(){
		Panda pandaBehind =(Panda) animal;
		while(pandaBehind != null) {
			pandaBehind.setFollowed(null);
			pandaBehind = pandaBehind.getFollower();
		}
	}

	/**
	 * A csempére lépés modellezése
	 * @param animal az csempére lépő állat
	 */
	public void steppedOn(Animal animal){

	}
}