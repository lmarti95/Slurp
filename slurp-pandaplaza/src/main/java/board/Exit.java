
package board;

import characters.Animal;
import characters.Panda;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:51
 */
public class Exit extends Tile {

	public Exit(String ID, int durability){
		super(ID, durability);
	}

	//Az allatnak meghivodik a steppedOn metodusa ha ralep az exitre
	public void steppedOn(Animal animal){
			//Az orangutantol lekerdezzuk a pandat ha koveti ot panda
			Panda p = animal.getFollower();
			//orangutan kkilep
			animal.exit();
			//A pandasor vegig lepked az exiten
			while(p != null){
				p.exit();
				this.setAnimal(null);
				p.setLocation(null);
				p  = p.getFollower();
			}
	}
}//end Exit