package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import characters.Orangutan;
import board.Tile;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static BufferedReader bufferRead;

    private static Orangutan orangutan = new Orangutan();

    public static void main(String[] args) throws IOException {
        bufferRead = new BufferedReader(new InputStreamReader(System.in));
        mainmenu();

    }

    private static void mainmenu() throws IOException {
        LOGGER.info("Fo menu:\n"
                + "\t1 - Uj jatek\n"
                + "\t2 - kilepes");

        String order = bufferRead.readLine();
        switch (order) {
        case "1":
            orangutanMove();
            break;
        case "2":
            jatekVege();
            break;
        default:
            break;
        }

    }

    private static void orangutanMove() throws IOException {
        LOGGER.info("Van panda a jatekteren?:\n"
                + "\t1 -igen\n"
                + "\t2 - nem");
        String order = bufferRead.readLine();
        switch (order) {
        case "1":
            csempereLepes();
            break;
        case "2":
            jatekVege();
            break;
        default:
            break;
        }
    }

    private static void csempereLepes() throws IOException {
        LOGGER.info("Melyik csempere? (1-x):");
        String order = bufferRead.readLine();
        LOGGER.info("Csempe tartossaga? ((-1)-20:");
        order = bufferRead.readLine();
        switch (order) {
        case "-1":
            LOGGER.info("A csempe eros");
            break;
        case "0":
        case "1":
            die();
            break;
        default: csempeDolog();
            break;
        }

    }

    private static void csempeDolog() throws IOException {
        LOGGER.info("Mi van a csempen?\n"
                + "\t1 - Panda\n"
                + "\t2 - Szekreny\n"
                + "\t3 - Kijarat\n"
                + "\t4 - Egyeb");
       String order = bufferRead.readLine();
        switch (order) {
        case "1":
            LOGGER.info("A panda elkapasa");
            break;
        case "2":
            LOGGER.info("Belepes a szekrenybe");
            break;
        case "3":
            LOGGER.info("Kilepes a kiajraton");
            break;
        default:
            LOGGER.info("Lepes a csempere");
            orangutan.move(new Tile());
            break;
        }
    }

    private static void die() {
        LOGGER.info("Az allat halott");
    }

    private static void jatekVege() {
        LOGGER.info("Jatek vege!");
    }

}
