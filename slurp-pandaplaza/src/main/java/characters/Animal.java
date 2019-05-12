package main.java.characters;

import main.java.board.Tile;
import main.java.game.Game;

/**
 * Animal absztrakt ősosztály. Felelőssége az állatok közös tulajdonságainak összefogása
 */
public abstract class Animal {

	/**
	 * Minden állatot követ egy panda.
	 */
	private Panda follower;

	/**
	 * Minden állat tudja hogy melyik csempén áll az aktuális körben
	 */
	private Tile location;

	/**
	 * Minden állat tudja, hogy melyik csempén állt az előző körben
	 */
	private Tile oldLocation;

	/**
	 * Minden állatot egy String azonosító egyértelműen azonosít
	 */
	private String ID;


	/**
	 * Az Animal osztály konstruktora. Minden állatnak 'születéskor' meg kell adni az egyedi azonosítóját.
	 * @param ID az állat egyedi azonosítója
	 */
	public Animal(String ID){
		this.ID = ID;
	}

	/**
	 * Minden állat meg tud halni, pl. ha leesik agy törött csempén.
	 */
	public void die(){
		Panda behind = follower;
		while(behind != null) {
				behind.setFollowed(null);
				Panda behind2 = behind;
				behind=behind.getFollower();
				behind2.setFollower(null);
		}
	}
	
	public void catchAnimal(Panda panda){
	}
	public void catchedOrangutan(Orangutan og) {
	
	}

	public void exit(){
		follower = null;
		Game.getMap().getEntry().steppedOn(this);
	}

	/**
	 * Elhagyja az állat a csempét
	 * @param t a csempe amit elhagy az állat (előző csempe)
	 */
	public void leavePrevLocation(Tile t){
		oldLocation = location;
		location = t;
		if(oldLocation !=null) {
			oldLocation.setAnimal(null);
		}
		
	}

	/**
	 * Az állat és követői a kijelölt csempére lépnek át
	 * @param t a kijelölt csempe
	 */
	public void move(Tile t){
		t.steppedOn(this);
		if(follower != null){
			if(oldLocation!=null) {
				follower.move(oldLocation);
			}
		}
	}

	/**
	 * Az állat reagál a játékgép csilingelésére. A működést a gyermek osztályok implementálják.
	 */
	public void scaredFromBeep(){ }

	/**
	 * Az állat reagál a csokiautómata sípolására. A működést a gyermek osztályok implementálják.
	 */
	public void scaredFromTinkle(){	}

	/**
	 * Az állat reagál a fotel hívogató szavára. A működést a gyermek osztályok implementálják.
	 */
	public void sit(){ }

	/**
	 * Függvény, ami az állat helyét állítja be a megadott csempére.
	 * @param t a csempe ahol az állatnak lennie kell.
	 */
	public void setLocation(Tile t){
		location = t;
	}

	/**
	 * Segédfüggvény az állat helyének lekérdezésére.
	 * @return az állatot tartalmazó csempe
	 */
	public Tile getLocation(){
		return location;
	}

	/**
	 * Segédfüggvény a követő panda beállítására
	 * @param p a követő panda
	 */
	public void setFollower(Panda p){
		follower=p;
	}

	/**
	 * Segédfüggvény a követő panda lekérdezéséhez
	 * @return
	 */
	public Panda getFollower(){
		return follower;
	}

	/**
	 * Segédfüggvény az egyedi azonosító lekérdezéséhez
	 * @return egyedi azonosító
	 */
	public String getID() {
		return ID;
	}
}