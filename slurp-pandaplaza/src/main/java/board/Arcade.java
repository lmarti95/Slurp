package board;

import characters.Animal;
import characters.Panda;
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
	
	public void control(){
		Panda pandaBehind =(Panda) animal;
		while(pandaBehind != null) {
			pandaBehind.setFollowed(null);
			pandaBehind = pandaBehind.getFollower();
		}
	}

	/**
	 * 
	 * @param animal
	 */
	public void steppedOn(Animal animal){

	}
}//end Arcade