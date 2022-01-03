package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Main extends Application {
	
	public static Scanner scanner = new Scanner(System.in);
	public static Stage primaryStage;
	public static Stage lootStage;
	public static Stage helpMenuStage;
	public static FXMLLoader mainFXMLLoader;
	
	public static Image icon;
	public static String title = "Stasville";
	
	static {
		try {
			icon = new Image(new FileInputStream("src//Resources//Stasville_4K.png"));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Main.primaryStage = primaryStage;
			Main.mainFXMLLoader = new FXMLLoader(getClass().getResource("MainFXML.fxml"));
			Parent rootPrimary = Main.mainFXMLLoader.load();
			Scene scenePrimary = new Scene(rootPrimary);
			Main.primaryStage.setScene(scenePrimary);
			Main.primaryStage.setResizable(false);
			
			Main.primaryStage.setFullScreenExitHint("");
			
			Main.primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent e) {
					if (KeyCode.F11.equals(e.getCode())) {
		                primaryStage.setFullScreen(!primaryStage.isFullScreen());
		            }
				}
				
			});
			
			Main.primaryStage.setTitle(title);
			Main.primaryStage.getIcons().add(icon); 
			
			Main.primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void endGame() {
		MainSceneController msc = mainFXMLLoader.getController();
		msc.endGame();
	}
	
	public void restartGame(){
		try {
			mainFXMLLoader = new FXMLLoader(getClass().getResource("MainFXML.fxml"));
			Parent rootPrimary = Main.mainFXMLLoader.load();
			Scene scenePrimary = new Scene(rootPrimary);
			Main.primaryStage.setScene(scenePrimary);
			Main.primaryStage.setResizable(false);
			
			Main.primaryStage.setFullScreenExitHint("");
			
			Main.primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
	
				@Override
				public void handle(KeyEvent e) {
					if (KeyCode.F11.equals(e.getCode())) {
		                primaryStage.setFullScreen(!primaryStage.isFullScreen());
		            }
				}
				
			});
			
			Main.primaryStage.setTitle(title);
			Main.primaryStage.getIcons().add(icon);
			
			Main.primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
