package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import characters.Orangutan;
import characters.PandaLazy;
import board.Tile;
import board.Exit;
import board.Closet;
import game.Game;
import game.Player;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static BufferedReader bufferRead;

    //Teszt változók
    private static Orangutan orangutan;
    private static Player player;


    //Szkeleton teszt program létrehozása
    public static void main(String[] args) throws IOException {
    	Interaction.listen();
        bufferRead = new BufferedReader(new InputStreamReader(System.in));
        mainmenu();

    }

    //Fő menü
    private static void mainmenu() throws IOException {
        LOGGER.info("Fo menu:\n"
                + "\t1 - Uj jatek\n"
                + "\t2 - kilepes");

        String order = bufferRead.readLine();
        switch (order) {
        //Új játék
        case "1":
        	init();
            pandaQuestion();
            break;
        //Kilépés
        case "2":
            jatekVege();
            break;
        default:
            break;
        }

    }

    //Maradtak-e még pandák
    private static void pandaQuestion() throws IOException {
        LOGGER.info("Van panda a jatekteren?:\n"
                + "\t1 - igen\n"
                + "\t2 - nem");
        String order = bufferRead.readLine();
        switch (order) {
        case "1":
            csempereLepes();
            break;
        //Ha nem maradtak pandák kilépés
        case "2":
            jatekVege();
            break;
        default:
            break;
        }
    }

    //Rálépés egy csempére
    private static void csempereLepes() throws IOException {
        boolean end = false;
        while(!end){
            //Csempe kiválasztása
        LOGGER.info("Melyik csempere? (1-x):");
        String order = bufferRead.readLine();
        //Milyen erős a csempe
        LOGGER.info("Csempe tartossaga? ((-1)-20:");
        LOGGER.info("Kilepes: -2");
        order = bufferRead.readLine();
        switch (order) {
        case "-2":
        end = true;
        break;
        case "-1":
            LOGGER.info("A csempe eros");
            break;
        //A csempe eltörik az orángután leesik és meghal
        case "0":
        case "1":
            orangutan.die();
            jatekVege();
            end = true;
            break;
        //Loop, hogy lehessen lépkedni a csempéken
        default:
        csempeDolog();
            }
        }
    }

    //Mi található a csempén
    private static void csempeDolog() throws IOException {
        LOGGER.info("Mi van a csempen?\n"
                + "\t1 - Panda\n"
                + "\t2 - Szekreny\n"
                + "\t3 - Kijarat\n"
                + "\t4 - Egyeb");
       String order = bufferRead.readLine();
        switch (order) {
        //Orángután elkap egy pandát
        case "1":
        	//PandaLazy p =new PandaLazy();
        	//p.setLocation(new Tile());
       		//orangutan.catchAnimal(p);
            LOGGER.info("A panda elkapasa");
            break;
        //Orángután és követő átmennek a szekrényen egy másik szekrénybe
        case "2":
        //	orangutan.move(new Closet());
            LOGGER.info("Belepes a szekrenybe");
            break;
        //Az orángután és követői kilépnek a kijáraton, majd pontok kiírása
        case "3":
        //	orangutan.move(new Exit());
        	System.out.println("Pontok osszesen: " + Player.getPoints());
            LOGGER.info("Kilepes a kiajraton");
            break;
        //Orángután rálép egy csempére
        default:
            //orangutan.move(new Tile());
            LOGGER.info("Lepes a csempere");
            break;
        }
    }

    private static void jatekVege() {
        LOGGER.info("Jatek vege!");
    }

    //Játék incializálása
    //Új játékos, játék és orángután
    public static void init(){
    	//player = new Player();
    	Game g = new Game();
    	g.initMap();
    	//orangutan = new Orangutan();
    	orangutan.setLocation((g.getMap().getEntry()));
    	g.getMap().getEntry().setAnimal(orangutan);

    }

}
