

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:57
 */
public class Orangutan extends Animal implements Animal {

	public Orangutan(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * Az or�ngut�nt eddig k�zvetlen k�vet� panda (follower), az �j pand�t k�veti (az
	 * �j panda followre lesz) az or�ngut�n followere pedig az �j panda lesz.
	 * 
	 * id�k�zben az �j panda �s or�ngut�n helyetcser�l
	 * 
	 * @param animal
	 */
	public void catch(Animal animal){

	}

	public void die(){

	}

	/**
	 * 
	 * @param signal
	 */
	public void react(Signal signal){

	}
}//end Orangutan