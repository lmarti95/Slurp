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

	/**
	 * Az or�ngut�nt eddig k�zvetlen k�vet� panda (follower), az �j pand�t k�veti (az
	 * �j panda followre lesz) az or�ngut�n followere pedig az �j panda lesz.
	 * 
	 * id�k�zben az �j panda �s or�ngut�n helyetcser�l
	 *
	 * Az osztalydiagramhoz kepest at kellett neveznunk ezt a metodust, mert javas beepítettel utkozott.
	 * 
	 * @param animal
	 */
	public void catchAnimal(Panda panda){
			Timer.removeSteppable(panda);
			if(getFollower()!=null){
				this.getFollower().setFollowed(panda);
				panda.setFollower(getFollower());
			}
			setFollower(panda);
			panda.setFollowed(this);
			setLocation(panda.getLocation());
			panda.setLocation(getLocation());
			getLocation().setAnimal(this);
			panda.getLocation().setAnimal(panda);
	}
	public void die(){

	}

}//end Orangutan