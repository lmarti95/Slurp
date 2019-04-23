package board;

import characters.Animal;
import characters.Panda;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:48
 */
public class Armchair extends Tile {

	public Armchair(String ID, int durability){
		super(ID, durability);
	}

	public void control(){
		Panda pandaBehind =(Panda) animal;
		while(pandaBehind != null) {
			pandaBehind.setFollowed(null);
			pandaBehind = pandaBehind.getFollower();
		}
		Panda p = (Panda) animal;
		p.getFollowed().setFollower(null);
		p.setFollowed(null);
	}
	
	/**
	 * 
	 * @param animal
	 */
	public void steppedOn(Animal animal){

	}
}//end Armchair