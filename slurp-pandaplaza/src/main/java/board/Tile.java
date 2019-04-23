package board;

import java.util.ArrayList;

import characters.Animal;

public class Tile {

	protected Animal animal;
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
		if(durability >0) {
			durability--;
		}
	}
	
	//implementalva van az orokolt osztalyokban
	public void control() {
		
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
		if(durability==0) {
			animal.die();
		} else {
			setAnimal(animal);
		}
		
	}

	public void setAnimal(Animal a) {
		animal = a;
	}
	

}// end Tile