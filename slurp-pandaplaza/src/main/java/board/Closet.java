
package board;

import characters.Animal;
import game.Steppable;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:49
 */
public class Closet extends Tile {

	//másik szekrény
	private Tile otherCloset;

	public Closet(String ID){
		super(ID);
		//otherCloset = new Tile();
	}

	//ha egy állat rálép a székrenyre, akkor átrakjuk a másik szekrényre
	public void steppedOn(Animal animal){
		animal.leavePrevLocation(this);
		animal.setLocation(otherCloset);
		otherCloset.setAnimal(animal);
	}
}//end Closet