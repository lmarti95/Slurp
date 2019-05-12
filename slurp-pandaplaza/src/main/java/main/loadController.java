package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class loadController implements Initializable {

	 @FXML
	  public  AnchorPane gridMenu;

	 @FXML
	  public  ListView<String> loadedgames;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
