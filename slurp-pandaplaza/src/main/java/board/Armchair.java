package board;

import characters.Animal;
import characters.Panda;

/**
 * Fotelt tartalmazó csempe osztály
 */
public class Armchair extends Tile {

	/**
	 * Konstruktor. Meghívja az ős konstruktorát.
	 * @param ID a csempe azonosítója
	 * @param durability a csempe erőssége vagy élettartama
	 */
	public Armchair(String ID, int durability){
		super(ID, durability);
	}

	/**
	 * A panda és a fotel interrakcióját modellező függvény. A panda leül a fotelbe (vár) és elengedi a követői kezét,
	 * akik ugyanígy tesznek.
	 */
	public void control(){
		// lekérdezzük a követő állatot
		Panda pandaBehind =(Panda) animal;
		// ameddig az nem null
		while(pandaBehind != null) {
			//elengedjük a kezét
			pandaBehind.setFollowed(null);
			//megnézzük ki követi őt
			pandaBehind = pandaBehind.getFollower();
		}
		Panda p = (Panda) animal;
		// a panda annak a kezét is elengedi, akit ő követett
		p.getFollowed().setFollower(null);
		p.setFollowed(null);
	}
	
	/**
	 * A csempére lépés modellezése
	 * @param animal az csempére lépő állat
	 */
}