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
	private String ID;

	public Animal(String ID){
		this.ID = ID;
	}

	public void die(){

	}

	//Az orángután kilép, a Panda exit metódusa felül van definiálva
	public void exit(){
		follower = null;
		Game.getMap().getEntry().steppedOn(this);
	}

	//Elhagyja az állat a csempét
	public void leavePrevLocation(Tile t){
		oldLocation = location;
		location = t;
		oldLocation.setAnimal(null);
	}

	//Allat es a kovetoi masik csempere mennek at
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

	public String getID() {
		return ID;
	}
}//end Animal