package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import characters.Panda;
import game.Game;
import game.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

public class gameController {

	public static int currentPlayer = 1;
	public boolean firstturnplayer2 = false;

	HashMap<String, Button> buttonList = new HashMap<String, Button>();

	@FXML
	private AnchorPane start;
	@FXML
	private Button T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21,
			T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T41, T40, points,
			turn;
	/*
	 * @FXML private Button b1;
	 * 
	 * @FXML private Button b2;
	 * 
	 * @FXML private Button b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14,
	 * b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28,
	 * b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42;
	 */

	
	//init palya, playerek, elso orangutan beleptetese
	@FXML
	public void initialize() {
		initBtns();
		T0.setText("ORANGUTAN");
		try {
			Interaction.listen(
					new InputStreamReader(new FileInputStream(
							"init.txt")),
					false);
			String line = "pl1";
			Command ad = Command.getCommandByValue("Add player");
			Interaction.work(ad, line);

			if (Main.getNrOfPlayers() > 1) {
				String line3 = "pl2";
				Command ad3 = Command.getCommandByValue("Add player");
				Interaction.work(ad3, line3);
				firstturnplayer2 = true;
			}
			T0.setText("1ORANGUTAN");
			String line4 = "O11 T0";
			Command ad4 = Command.getCommandByValue("Move orangutan");
			Interaction.work(ad4, line4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	}

	//csempek kiirasa
	public void listTiles() {
		String line = "";
		Command ad = Command.getCommandByValue("List tiles");
		Interaction.work(ad, line);
	}

	
	//jatekosok kiirasa
	public void listPlayers() {
		String line = "";
		Command ad = Command.getCommandByValue("List players");
		Interaction.work(ad, line);
	}

	//gombokra a nevek kiirasa
	public void refreshNames() {
		for (int i = 0; i < buttonList.size(); i++) {
			Button t = buttonList.get("T" + i);
			t.setText("");
		}
		T0.setText("ENTRY");
		T20.setText("BROKENTILE");
		T27.setText("CLOSET");
		T24.setText("ARCADE");
		T30.setText("VENDINGMACHINE");
		T26.setText("EXIT");
		T41.setText("CLOSET");
		T40.setText("ARMCHAIR");
		T35.setText("BROKENTILE");
		ArrayList<Panda> pandaList = Game.getMap().getPandaList();
		for (int i = 0; i < pandaList.size(); i++) {
			String location = pandaList.get(i).getLocation().getID();
			Button t = buttonList.get(location);
			t.setText("PANDA");
		}
		ArrayList<Player> players = Game.getMap().getPlayers();
		for (int i = 0; i < players.size(); i++) {
			String location = players.get(i).getOrangutan().getLocation().getID();
			Button t = buttonList.get(location);
			t.setText(i + 1 + "ORANGUTAN");
		}
		turn.setText("Next Player: " + currentPlayer);
	}

	//van-e panda a csempen
	public boolean containsPanda(String id) {
		ArrayList<Panda> pandaList = Game.getMap().getPandaList();
		for (int i = 0; i < pandaList.size(); i++) {
			if (pandaList.get(i).getLocation().getID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsPandaCatched(String id) {
		ArrayList<Panda> pandaList = Game.getMap().getPandaList();
		for (int i = 0; i < pandaList.size(); i++) {
			if (pandaList.get(i).getLocation().getID().equals(id)) {
				if(pandaList.get(i).getFollowed() != null){
					return true;
				}
			}
		}
		return false;
	}

	//kattintas lekezelese - mozgatas
	public void onClick(ActionEvent event) throws IOException {
		boolean moved = false;
		Button btn = (Button) event.getSource();
		String id = btn.getId();
		System.out.println(id);
		Player p = null;
		ArrayList<Player> players = Game.getMap().getPlayers();
		for (int i = 0; i < players.size(); i++) {
			if (String.valueOf(currentPlayer).charAt(0) == players.get(i).getID().charAt(2)) {
				p = players.get(i);
			}
		}

		//orangutan leptetese
		for (int i = 0; i < p.getOrangutan().getLocation().getNeighbours().size(); i++) {
			if (id.equals(p.getOrangutan().getLocation().getNeighbours().get(i).getID()) && !containsPandaCatched(id)) {
				if (containsPanda(id)) {
					p.getOrangutan()
							.catchAnimal((Panda) (p.getOrangutan().getLocation().getNeighbours().get(i).getAnimal()));
				}
				String line = "O1" + currentPlayer + " " + id;
				Command ad = Command.getCommandByValue("Move orangutan");
				Interaction.work(ad, line);
				moved = true;
			}
			
			
		}
		//kovetkezo jatekos beallitasa es pontok frissitese
		if (players.size() > 1 && moved) {
			if (currentPlayer == 1) {
				currentPlayer = 2;
			} else {
				currentPlayer = 1;
			}
			moved = false;
			points.setText("Points: " + players.get(0).getPoints() + ", " + players.get(1).getPoints());
		} else {
			points.setText("Points: " + players.get(0).getPoints() + ", -");
		}
		//masodik orangutan bevezetese a bejaraton
		if (firstturnplayer2 && currentPlayer == 2) {
			String line4 = "O12 T0";
			Command ad4 = Command.getCommandByValue("Move orangutan");
			Interaction.work(ad4, line4);
			for (int i = 0; i < players.size(); i++) {
				if (String.valueOf(currentPlayer).charAt(0) == players.get(i).getID().charAt(2)) {
					p = players.get(i);
				}
			}
			System.out.println(p.getOrangutan().getLocation().getID());
			firstturnplayer2 = false;
		}
		refreshNames();
	}

	//gombokhoz egy string hozzarendelese
	private void initBtns() {

		buttonList.put("T0", T0);
		buttonList.put("T1", T1);
		buttonList.put("T2", T2);
		buttonList.put("T3", T3);
		buttonList.put("T4", T4);
		buttonList.put("T5", T5);
		buttonList.put("T6", T6);
		buttonList.put("T7", T7);
		buttonList.put("T8", T8);
		buttonList.put("T9", T9);
		buttonList.put("T10", T10);
		buttonList.put("T11", T11);
		buttonList.put("T12", T12);
		buttonList.put("T13", T13);
		buttonList.put("T14", T14);
		buttonList.put("T15", T15);
		buttonList.put("T16", T16);
		buttonList.put("T17", T17);
		buttonList.put("T18", T18);
		buttonList.put("T19", T19);
		buttonList.put("T20", T20);
		buttonList.put("T21", T21);
		buttonList.put("T22", T22);
		buttonList.put("T23", T23);
		buttonList.put("T24", T24);
		buttonList.put("T25", T25);
		buttonList.put("T26", T26);
		buttonList.put("T27", T27);
		buttonList.put("T28", T28);
		buttonList.put("T29", T29);
		buttonList.put("T30", T30);
		buttonList.put("T31", T31);
		buttonList.put("T32", T32);
		buttonList.put("T33", T33);
		buttonList.put("T34", T34);
		buttonList.put("T35", T35);
		buttonList.put("T36", T36);
		buttonList.put("T37", T37);
		buttonList.put("T38", T38);
		buttonList.put("T39", T39);
		buttonList.put("T40", T40);
		buttonList.put("T41", T41);

	}

}
