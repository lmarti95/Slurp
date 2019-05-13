package main;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mainController {


	 @FXML
	  public  AnchorPane start;

	 @FXML
	   private Button newgame;

	 @FXML
	   private Button loadgame;

	 @FXML
	   private Button exit;

	 @FXML
	 public void loadNewGame(ActionEvent event) throws IOException {
		 AnchorPane pane = FXMLLoader.load(getClass().getResource("newgame.fxml"));
	     start.getChildren().setAll(pane);
	 }

	 @FXML
	 public void loadLoadGame(ActionEvent event) throws IOException {
		 AnchorPane pane = FXMLLoader.load(getClass().getResource("loadgame.fxml"));
		 start.getChildren().setAll(pane);
	 }

	 @FXML
	 public void exit(ActionEvent event) throws IOException {
		 Platform.exit();
		 System.exit(0);

	 }



}
