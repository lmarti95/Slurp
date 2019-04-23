
package board;

import characters.Animal;
import characters.Panda;
import game.Steppable;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:31:11
 */
public class VendingMachine extends Tile implements Steppable {

	public VendingMachine(String id, int durability){
		super(id, durability);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void step(){

	}
	
	public void control(){
		reduceDurability();
	}

	/**
	 * 
	 * @param animal
	 */
	public void steppedOn(Animal animal){

	}
}//end VendingMachine