package main.java.board;

import main.java.characters.Animal;
import main.java.game.Steppable;

/**
 * A teleportáló szekrényt tartalmazó csempét modellező osztály implementációja
 */
public class Closet extends Tile {

	/**
	 * A szekrény párját nyilván tartjuk
	 */
	private Closet otherCloset;

	/**
	 * Konstruktor. Meghívja az ős konstruktorát.
	 * @param ID a csempe azonosítója
	 * @param durability a csempe erőssége vagy élettartama
	 */
	public Closet(String ID,int durability){
		super(ID, durability);
	}

	/**
	 * Segédfüggvény, ami beállítja a szekrény párját
	 * @param t
	 */
	public void setOtherCloset(Closet t) {
		otherCloset=t;
	}

	/**
	 * Segédfüggvény, ami lekérdezi a szekrény párját.
	 * @return a szekrény párja
	 */
	public Tile getOtherCloset() {
		return otherCloset;
	}

	/**
	 * Függvény ami az állat egyik szekrénybe való lépését modellezi.
	 * Ha egy állat rálép a székrenyre, akkor átrakjuk a másik szekrényre
	 * @param animal az állat ami rálép a szekrényt tartalmazó csempére
	 */
	public void steppedOn(Animal animal){
		animal.leavePrevLocation(this);
		animal.setLocation(otherCloset);
		otherCloset.setAnimal(animal);
	}
}