

/**
 * @author User
 * @version 1.0
 * @created 24-márc.-2019 11:31:08
 */
public class Tile extends Tile {

	/**
	 * <ul>
	 * 	<li>gyenge csempe kezdeti értéke 20</li>
	 * </ul>
	 * <ul>
	 * 	<li>erõs csempe -1</li>
	 * 	<li>törött csempe 0</li>
	 * </ul>
	 */
	private int durability;

	public Tile(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void reduceDurability(){

	}

	/**
	 * Vizsgálja a csempe durability-jét
	 * <ul>
	 * 	<li>ha > 0 csökken eggyel és elfogadja az állatot</li>
	 * 	<li>ha 0 az állat meghal</li>
	 * 	<li>ha -1 elfogadja az állatot</li>
	 * </ul>
	 * 
	 * Hogyan kapja el az orángután az ott álló pandát?
	 * 
	 * @param animal
	 */
	public void steppedOn(Animal animal){

	}
}//end Tile