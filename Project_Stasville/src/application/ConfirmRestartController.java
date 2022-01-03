package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConfirmRestartController {
	
	@FXML
	private Button confirmRestartButton;
	@FXML
	private Button cancelRestartButton;
	
	public void confirmRestart(ActionEvent e) {
		try {
			Main.mainFXMLLoader = new FXMLLoader(getClass().getResource("MainFXML.fxml"));
			Parent rootRestart = Main.mainFXMLLoader.load();
			Scene sceneRestart = new Scene(rootRestart);
			Main.primaryStage.setScene(sceneRestart);
			
			Main.primaryStage.setTitle(Main.title);
			Main.primaryStage.getIcons().add(Main.icon);
			
			Main.primaryStage.show();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		stage.close();
	}
	
	public void cancelRestart(ActionEvent e) {
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		stage.close();
	}
	
}
