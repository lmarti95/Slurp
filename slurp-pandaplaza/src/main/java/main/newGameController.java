package main;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class newGameController {

	 @FXML
	  public  AnchorPane newgame;

	 @FXML
	  public  ImageView img;

	 @FXML
	   private Button oneplayer;

	 @FXML
	   private Button twoplayer;

	 @FXML
	   private Button go;

	 @FXML
	 private void oneplayer(ActionEvent event) throws IOException {
		 Main.setNrOfPlayers(0);
		 System.out.println("oneplayer");
		 AnchorPane pane = FXMLLoader.load(getClass().getResource("game.fxml"));
		 newgame.getChildren().setAll(pane);
	 }
	 @FXML
	 private void twoplayer(ActionEvent event) throws IOException {
		 Main.setNrOfPlayers(1);
		 System.out.println("twoplayer");
		 AnchorPane pane = FXMLLoader.load(getClass().getResource("game.fxml"));
		 newgame.getChildren().setAll(pane);
	 }

	 @FXML
	 private void go(ActionEvent event) throws IOException {
		 System.out.println("tortent vmi");
	 }


	 @FXML
	 private void keyPressed(KeyEvent keyEvent) throws IOException {
		 System.out.println("okes");
		 switch(keyEvent.getCode()) {
		  case ENTER:
			  System.out.println("enter");
		    break;
		  case KP_UP: Main.setNrOfPlayers(1);
		  		System.out.println("up");
		    break;
		  case KP_DOWN: Main.setNrOfPlayers(2);
		  		System.out.println("down");
			break;
		  default:
			break;
		 }
	}
}
