package characters;

import game.Timer;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:57
 */

import characters.Panda;

public class Orangutan extends Animal {

	public Orangutan(){

	}

	
	 //Az osztalydiagramhoz kepest at kellett neveznunk ezt a metodust,
	 //mert javas beepítettel utkozott. (Catch())
	//Panda elkapása
	public void catchAnimal(Panda panda){
			Timer.removeSteppable(panda);
			//Panda követőinek átállítása
			if(getFollower()!=null){
				this.getFollower().setFollowed(panda);
				panda.setFollower(getFollower());
			}
			setFollower(panda);
			panda.setFollowed(this);
			//A panda és az orángután helyet cserél
			setLocation(panda.getLocation());
			panda.setLocation(getLocation());
			getLocation().setAnimal(this);
			panda.getLocation().setAnimal(panda);
	}
	public void die(){

	}

}//end Orangutan