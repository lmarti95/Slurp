package main;

import characters.Orangutan;
import game.Game;
import game.Player;

import java.io.*;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static BufferedReader bufferRead;

    //Teszt változók
    private static Orangutan orangutan;
    private static Player player;


    //Szkeleton teszt program létrehozása
    public static void main(String[] args) throws IOException {
/*
        BufferedReader r = new BufferedReader(new FileReader("samplefile1.txt"));
        System.out.println(r.readLine());*/

    	//Interaction.listen(new FileReader("initInput"), true);
        Interaction.listen(new InputStreamReader(System.in), false);
        bufferRead = new BufferedReader(new InputStreamReader(System.in));


    }

}
