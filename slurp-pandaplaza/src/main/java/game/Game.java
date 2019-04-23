package game;

import board.Map;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:30:52
 */
public class Game {

	private static Map map;

	private static Game instanec;


	//új játék indítása
	private Game(){
		map = new Map();
	}

	public static Game getInstance(){
		if(instanec==null){
			instanec = new Game();
		}
		return instanec;
	}

	public void endGame(){

	}

	public void initMap(){

	}

	public void newGame(){

	}

	public static Map getMap(){
		return map;
	}
}//end Game