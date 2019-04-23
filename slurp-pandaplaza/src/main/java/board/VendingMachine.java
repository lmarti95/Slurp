
package board;

import characters.Animal;
import characters.Panda;
import game.Steppable;

/**
 * Csokiautómatát tartalmazó csempét modellező osztály reprezentációja
 */
public class VendingMachine extends Tile implements Steppable {

	/**
	 * Konstruktor. Meghívja az ős konstruktorát.
	 * @param ID a csempe azonosítója
	 * @param durability a csempe erőssége vagy élettartama
	 */
	public VendingMachine(String id, int durability){
		super(id, durability);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * A körök múlását kezelő függvény
	 */
	public void step(){

	}

	/**
	 * A csempe és panda interrakcióját modellező függvény. Csökkenti a csempe élettartamát.
	 */
	public void control(){
		reduceDurability();
	}

	/**
	 * A csempére lépés modellezése
	 * @param animal az csempére lépő állat
	 */
	public void steppedOn(Animal animal){

	}
}