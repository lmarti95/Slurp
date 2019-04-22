package board;

import java.util.ArrayList;

import characters.Animal;

public class Tile {

	private Animal animal;
	// Erős csempe értéke: -1
	// Gyenge csempe kezdeti értéke: 20
	// Törött csempe értéke: 0
	private int durability;

	private String ID;
	private ArrayList<Tile> neighbours;
	
	
	public Tile(String ID, int durability) {
		this.ID = ID;
		this.durability = durability;
		neighbours = new  ArrayList<Tile>();
	}

	public String getID() {
		return ID;
	}

	public void reduceDurability() {

	}
	
	public void addNeighbour(Tile t) {
		neighbours.add(t);
	}
	
	public Tile getNeighbour(String TileID) {
		for(int i=0;i<neighbours.size();i++) {
			if(neighbours.get(i).getID().equals(TileID)) {
				return neighbours.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Tile> getNeighbours(){
		return neighbours;
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