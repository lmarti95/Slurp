package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static BufferedReader bufferRead;

    public static void main(String[] args) throws IOException {
        bufferRead = new BufferedReader(new InputStreamReader(System.in));
        mainmenu();

    }

    private static void mainmenu() throws IOException {
        LOGGER.info("Fo menu:\n"
                + "\t1 - Uj jatek\n"
                + "\t2 - kilepes");

        String order = bufferRead.readLine();
        switch (order){
        case "1":
            break;
        case "2":
            break;
        default:
            break;
        }

    }

}
