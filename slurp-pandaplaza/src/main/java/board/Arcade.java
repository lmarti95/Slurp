package board;

import characters.Animal;
import game.Steppable;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:47
 */
public class Arcade extends Tile implements Steppable {

	public Arcade(String ID, int durability){
		super(ID, durability);
	}

	public void step(){

	}

	/**
	 * 
	 * @param animal
	 */
	public void steppedOn(Animal animal){

	}
}//end Arcade