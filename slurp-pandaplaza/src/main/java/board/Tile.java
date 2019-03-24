package board;

import characters.Animal;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:31:08
 */
public class Tile  {

	/**
	 * <ul>
	 * 	<li>gyenge csempe kezdeti �rt�ke 20</li>
	 * </ul>
	 * <ul>
	 * 	<li>er�s csempe -1</li>
	 * 	<li>t�r�tt csempe 0</li>
	 * </ul>
	 */
	private int durability;

	public Tile(){

	}

	public void reduceDurability(){

	}

	/**
	 * Vizsg�lja a csempe durability-j�t
	 * <ul>
	 * 	<li>ha > 0 cs�kken eggyel �s elfogadja az �llatot</li>
	 * 	<li>ha 0 az �llat meghal</li>
	 * 	<li>ha -1 elfogadja az �llatot</li>
	 * </ul>
	 * 
	 * Hogyan kapja el az or�ngut�n az ott �ll� pand�t?
	 * 
	 * @param animal
	 */
	public void steppedOn(Animal animal){
		animal.leavePrevLocation();
		reduceDurability();
	}
}//end Tile