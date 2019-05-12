package main.java.game;

import java.util.ArrayList;

/**
 * Köröket felügyelő osztály.Összefogja és kezeli a léptetendő elemeket.
 */
public class Timer {

	/**
	 * Az elemek listája amit léptetni kell
	 */
	private static  ArrayList<Steppable> steppablesList = new ArrayList<Steppable>();

	/**
	 * Singleton példány
	 */
	private static Timer single_instance=null;

	/**
	 * Singleton Timer osztály létrehozása
	 */
	public Timer(){
		//todo: singleton
		single_instance = this;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * Léptetendő elem hozzáadására szolgáló függvény.
	 * @param steppable
	 */
	public static void addSteppable(Steppable steppable){
		steppablesList.add(steppable);
	}

	/**
	 * Léptetendő elem eltávolítására szolgáló függvény.
	 * @param steppable
	 */
	public static void removeSteppable(Steppable steppable){
		steppablesList.remove(steppable);
	}


	/**
	 * Lépés kiváltása.
	 */
	public void tick(){

	}
	
}