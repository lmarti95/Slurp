package game;

import java.util.ArrayList;

/**
 * @author User
 * @version 1.0
 * @created 24-m�rc.-2019 11:31:10
 */
public class Timer {

	private static  ArrayList<Steppable> steppablesList = new ArrayList<Steppable>();
	private static Timer single_instance=null;

	//Singleton Timer osztály létrehozása
	public Timer(){
		single_instance = this;
	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param steppable
	 */
	public static void addSteppable(Steppable steppable){
		steppablesList.add(steppable);
	}

	public static void removeSteppable(Steppable steppable){
		steppablesList.remove(steppable);
	}

	public void tick(){

	}
	
}//end Timer