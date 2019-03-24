package characters;

import board.Tile;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:33
 */
public abstract class Animal {

	private Animal follower;
	private Tile location;

	public Animal(){

	}

	public void die(){

	}

	public void exit(){

	}

	/**
	 * Jelenlegi csempe removeAnimel() met�dus�t h�vja
	 */
	public void leavePrevLocation(){

	}

	/**
	 * 
	 * @param toTile
	 */
	public void move(Tile t){
		t.steppedOn(this);
	}

	public void scaredFromBeep(){

	}

	public void scaredFromTinkle(){

	}

	public void sit(){

	}
}//end Animal