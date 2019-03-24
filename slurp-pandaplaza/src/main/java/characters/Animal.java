package characters;

import board.Tile;
import board.Map;
import game.Game;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:33
 */
public abstract class Animal {

	private Panda follower;
	private Tile location;
	private Tile oldLocation;

	public Animal(){

	}

	public void die(){

	}

	public void exit(){
		follower = null;
		Game.getMap().getEntry().steppedOn(this);
	}

	/**
	 * Jelenlegi csempe removeAnimel() met�dus�t h�vja
	 */
	public void leavePrevLocation(Tile t){
		oldLocation = location;
		location = t;
		oldLocation.setAnimal(null);
	}

	/**
	 * 
	 * @param toTile
	 */
	public void move(Tile t){
		
		t.steppedOn(this);
		if(follower != null){
			follower.move(oldLocation);
		}
	}

	public void scaredFromBeep(){

	}

	public void scaredFromTinkle(){

	}

	public void sit(){

	}
	public void setLocation(Tile t){
		location = t;
	}

	public Tile getLocation(){
		return location;
	}

	public void setFollower(Panda p){
		follower=p;
	}
	public Panda getFollower(){
		return follower;
	}
}//end Animal