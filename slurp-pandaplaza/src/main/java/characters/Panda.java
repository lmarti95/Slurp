package characters;

import characters.Animal;
import game.Steppable;
import game.Player;

/**
 * Az osztály a játékos álltal elkapható pandákat reprezentálja.
 */
public abstract class Panda extends Animal implements Steppable {

	/**
	 * A panda egy másik állat követője, amit számon tart
	 */
	private Animal followed;

	/**
	 * Konstruktor. Meghívja az ősosztály konstruktorát.
	 * @param ID a panda egyedi azonosítója
	 */
	public Panda(String ID){
		super(ID);
	}

	/**
	 * Panda kimegy a kijáraton és a játékos kap pontot
	 */
	public void exit(){
		Player.addPoints();
	}

	/**
	 * A panda lépését végző segédfüggvény
	 */
	public void step(){	}

	/**
	 * Függvény, ami visszaadja hogy, a panda kit követ
	 * @return az állat akit a panda követ
	 */
	public Animal getFollowed(){
		return followed;
	}

	/**
	 * Függvény, ami beállítja, hogy a panda kit követ
	 */
	public void setFollowed(Animal a){
		followed = a;
	}

}