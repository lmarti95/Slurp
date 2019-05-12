package main.java.board;

import java.util.ArrayList;

import main.java.characters.Animal;

/**
 * A játéktér egy mezejét reprezentáló osztály
 */
public class Tile {

	/**
	 * A csempén pontosan egy állat lehet, ezt a csempe megjegyzi
	 */
	protected Animal animal;

	/**
	 * A csempe erőssége vagy élettartama.
	 * Erős csempe értéke: -1
	 * Gyenge csempe kezdeti értéke: 20
	 * Törött csempe értéke: 0
	 */
	private int durability;

	/**
	 * A csempe egyedi azonosítója
	 */
	private String ID;

	/**
	 * A csempék szomszédait tartalmazó lista
	 */
	private ArrayList<Tile> neighbours;

	/**
	 * Csempe konstruktora. A csempe létrejöttekor megadjuk az azonosítóját és az erősségét.
	 * A csempét szomszédok nélkül hozzuk létre, ezeket később kell hozzáadni.
	 *
	 * @param ID a csempe azonosítója
	 * @param durability a csempe erőssége vagy élettartama
	 */
	public Tile(String ID, int durability) {
		this.ID = ID;
		this.durability = durability;
		neighbours = new  ArrayList<Tile>();
	}

	/**
	 * A csempe azonosítóját visszaadó függvény
	 * @return
	 */
	public String getID() {
		return ID;
	}

	/**
	 * A csempe élettartamát csökkentő függvény
	 */
	public void reduceDurability() {
		if(durability >0) {
			durability--;
		}
	}

	/**
	 * A csempén álló tárgy (a gyermek osztályokban van ilyen) működésének implementációja
	 */
	public void control() {
		
	}

	/**
	 * Csempe szomszédját adhatjuk meg
	 * @param t az új csempe szomszéd
	 */
	public void addNeighbour(Tile t) {
		neighbours.add(t);
	}

	/**
	 * Segédfüggvény, ami visszadja a csempe megadott szomszédját
	 * @param TileID a keresett szomszéd azonosítója
	 * @return
	 */
	public Tile getNeighbour(String TileID) {
		for(int i=0;i<neighbours.size();i++) {
			if(neighbours.get(i).getID().equals(TileID)) {
				return neighbours.get(i);
			}
		}
		return null;
	}

	/**
	 * Segédfüggvény a csempe összes szomszédjának lekérdezéséhez.
	 * @return az összes szomszéd listája
	 */
	public ArrayList<Tile> getNeighbours(){
		return neighbours;
	}

	/**
	 * Segédfüggvény a törékenység lekérdezéséhez
	 * @return az élettartam értéke: -1 erős, 0 törött, >0 törékeny csempe
	 */
	public int getDurability() {
		return durability;
	}

	/**
	 * Segédfüggvény ami az állat lépését kezeli le. Atmozgatja az állatot az előző helyéről, csökkenti a
	 * csempe élettartamát és befogadja az állatot.
	 * @param animal az állat, ami a csempére lép
	 */
	public void steppedOn(Animal animal) {
		animal.leavePrevLocation(this);
		reduceDurability();
		if(durability==0) {
			animal.die();
		} else {
			setAnimal(animal);
		}
		
	}

	/**
	 * A csempén álló állatot beállító segédfüggvény
	 * @param a az állat ami a csempére kerül
	 */
	public void setAnimal(Animal a) {
		animal = a;
	}
}