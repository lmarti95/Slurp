package main;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;﻿
import javafx.stage.Stage;
import characters.Orangutan;
import game.Game;
import game.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javafx.scene.Parent;

public class Main extends Application {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static BufferedReader bufferRead;

    //Teszt vĂˇltozĂłk
    private static Orangutan orangutan;
    private static Player player;

    private static int nrOfPlayers = 1;

    // az elmentett jatekmenetek filenevenek listaja
    static List<String> savedgames = new ArrayList<String>();
    static ListView<String> listView = new ListView<String>();

    //Szkeleton teszt program lĂ©trehozĂˇsa
    public static void main(String[] args) throws IOException {
/*
        BufferedReader r = new BufferedReader(new FileReader("samplefile1.txt"));
        System.out.println(r.readLine());*/

    	//Interaction.listen(new FileReader("initInput"), true);

    	launch(args);
        Interaction.listen(new InputStreamReader(System.in), false);
        bufferRead = new BufferedReader(new InputStreamReader(System.in));

    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainnenu.fxml"));
        Scene scene = new Scene(root);
        

        stage.setTitle("slurp__.exe");
        stage.setScene(scene);
        stage.show();
   }



    public static void setSavedGames() {

    	File[] files = new File(".").listFiles();  //  hova mentjuk az elmentett jatekmenetet ???

	    for (File file : files) {
	        if (file.isFile()) {
	            savedgames.add(file.getName());
	        }
	    }

	    listView.getItems().addAll(savedgames);
    }

    public static void setNrOfPlayers(int nr){
    	nrOfPlayers = nr;
    }

}
