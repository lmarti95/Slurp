
package board;

import characters.Animal;
import characters.Panda;
import game.Game;

/**
 * Kijáratot tartalmazó csempe implementációja
 */
public class Exit extends Tile {

	/**
	 * Konstruktor. Meghívja az ős konstruktorát.
	 * @param ID a csempe azonosítója
	 * @param durability a csempe erőssége vagy élettartama
	 */
	public Exit(String ID, int durability){
		super(ID, durability);
	}

	/**
	 * Az allatnak meghivodik a steppedOn metodusa ha ralep az exitre
	 */
	public void steppedOn(Animal animal){
			//Az orangutantol lekerdezzuk a pandat ha koveti ot panda
			Panda p = animal.getFollower();
			Panda p1;
			System.out.println("bye");
			//orangutan kkilep
			animal.exit();
			//A pandasor vegig lepked az exiten
			while(p != null){
				System.out.println("byepanda");
				p.exit();
				this.setAnimal(null);
				p.setLocation(null);
				p1  = p.getFollower();
				Game.getMap().removePanda(p);
				p=p1;
			}
	}
}