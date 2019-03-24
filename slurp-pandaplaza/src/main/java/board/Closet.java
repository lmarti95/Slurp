
package board;

import characters.Animal;
import game.Steppable;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:49
 */
public class Closet extends Tile {

	private Tile otherCloset;

	public Closet(){
		otherCloset = new Tile();
	}

	/**
	 * 
	 * @param animal
	 */
	public void steppedOn(Animal animal){
		animal.leavePrevLocation(this);
		animal.setLocation(otherCloset);
		otherCloset.setAnimal(animal);
	}
}//end Closet