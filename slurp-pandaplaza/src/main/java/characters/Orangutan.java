

/**
 * @author User
 * @version 1.0
 * @created 24-márc.-2019 11:30:57
 */
public class Orangutan extends Animal implements Animal {

	public Orangutan(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * Az orángutánt eddig közvetlen követõ panda (follower), az új pandát követi (az
	 * új panda followre lesz) az orángután followere pedig az új panda lesz.
	 * 
	 * idõközben az új panda és orángután helyetcserél
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