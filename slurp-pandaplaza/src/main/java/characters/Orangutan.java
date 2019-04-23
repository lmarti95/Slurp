package characters;

import game.Game;
import game.Player;
import game.Timer;

import java.util.ArrayList;

/**
 * A játékos álltal irányított orángutánt reprezentáló osztály.
 * Az Animal osztályból származik származik.
 */
public class Orangutan extends Animal {

	/**
	 * Konstruktor. Meghívja az ősosztály konstruktorát.
	 * @param ID az orángután egyedi azonosítója.
	 */
	public Orangutan(String ID){
		super(ID);
	}

	/**
	 * A függvény kezeli le a panda elkapásával járó feladatokat.
	 * Az elkapott pandát kiveszi a játék által mozgatott állatok soraiból,
	 * beállítja a követőjét, beállítja az orángután követőjét és helyet cserél a két állat.
	 *
	 * megj: Az osztalydiagramhoz kepest at kellett neveznunk ezt a metodust,
	 * mert javas beepítettel utkozott. (Catch())
	 *
	 * @param panda az elkapandó panda
	 */
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

	/**
	 * A függvény kezeli az orángután halálát.
	 */
	public void die(){
		super.die();
		ArrayList<Player> players2 = Game.getMap().getPlayers();
		Player pl = null;
		for(int i=0;i<players2.size();i++) {
			if(getID().charAt(1) == players2.get(i).getID().charAt(2)) {
				 pl = players2.get(i);
			}
		}
		pl.reduceLife();
	}
	
	public void catchedOrangutan(Orangutan og) {
		setFollower(og.getFollower());
		og.getFollower().setFollowed(this);
		og.setFollower(null);
	}
}