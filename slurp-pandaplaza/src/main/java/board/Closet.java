
package board;

import characters.Animal;
import game.Steppable;


public class Closet extends Tile {

	//másik szekrény
	private Closet otherCloset;

	public Closet(String ID,int durability){
		super(ID, durability);
	}
	
	public void setOtherCloset(Closet t) {
		otherCloset=t;
	}

	public Tile getOtherCloset() {
		return otherCloset;
	}
	
	//ha egy állat rálép a székrenyre, akkor átrakjuk a másik szekrényre
	public void steppedOn(Animal animal){
		animal.leavePrevLocation(this);
		animal.setLocation(otherCloset);
		otherCloset.setAnimal(animal);
	}
}//end Closet