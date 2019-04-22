package board;

import characters.Animal;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:31:08
 */
public class Tile {

	private Animal animal;
	// Erős csempe értéke: -1
	// Gyenge csempe kezdeti értéke: 20
	// Törött csempe értéke: 0
	private int durability;

	private String ID;

	public Tile(String ID, int durability) {
		this.ID = ID;
		this.durability = durability;
	}

	public String getID() {
		return ID;
	}

	public void reduceDurability() {

	}
	
	public int getDurability() {
		return durability;
	}

	// Ha rálép egy állat a csempére akkor megnézni, hogy nem törött-e
	public void steppedOn(Animal animal) {
		animal.leavePrevLocation(this);
		reduceDurability();
		setAnimal(animal);
	}

	public void setAnimal(Animal a) {
		animal = a;
	}
	

}// end Tile