
package board;

import characters.Animal;
import characters.Panda;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:51
 */
public class Exit extends Tile {

	public Exit(){

	}

	/**
	 * 
	 * @param animal
	 */
	public void steppedOn(Animal animal){
			Panda p = animal.getFollower();
			animal.exit();
			while(p != null){
				p.exit();
				this.setAnimal(null);
				p.setLocation(null);
				p  = p.getFollower();
			}
	}
}//end Exit