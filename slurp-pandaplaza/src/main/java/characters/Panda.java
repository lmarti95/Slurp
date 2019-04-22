package characters;

import characters.Animal;
import game.Steppable;
import game.Player;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:58
 */
public abstract class Panda extends Animal implements Steppable {

	private Animal followed;
	

	public Panda(String ID){
		super(ID);
	}

	//Panda kimegy a kijáraton és kap pontot
	public void exit(){
		Player.addPoints();
	}

	public void step(){

	}
	public Animal getFollowed(){
		return followed;
	}
	public void setFollowed(Animal a){
		followed = a;
	}

}//end Panda