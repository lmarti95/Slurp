package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//interaction class felhasznalo bevitelek kezelesere
public class Interaction {
	
	static ArrayList<String[]> commands=new ArrayList<String[]>();

	public static void listen() throws IOException {
		addCommands();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = br.readLine();
			for(int i =0; i<commands.size();i++) {
				decode(line, commands.get(i));
			}
		}
	}

	private static void addCommands() {
		commands.add(new String[]{"Add", "Tile"});
		
	}

	public static boolean decode(String str, String[] command) {
		String[] words = str.split(" ");
		if(words.length >= command.length) {
			for(int i=0; i< command.length; i++) {
				if(!words[i].equals(command[i])) {
					return false;
				}
			}
		}
		System.out.println("yay");
		return true;
	}

}
