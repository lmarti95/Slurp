package main.java.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static boolean toFile = false;

    public static  void log(String msg){

        if(toFile){

            try (FileWriter writer = new FileWriter("testResult.txt", true);
                    BufferedWriter bw = new BufferedWriter(writer)) {

                bw.write(msg);
                bw.newLine();

            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }


        } else {
            System.out.println(msg);

        }

    }

    public static void  setToFile(boolean writeToFile){
        toFile = writeToFile;
    }

}
