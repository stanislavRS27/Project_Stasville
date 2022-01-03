package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ToDoController implements Initializable{

	@FXML
	private Label toDoLabel;

	private String toDo = "- Add level-up system:\n"
			+ "\tWay to increase your stats (strength, intelligence, dextirity, health)\n"
			+ "\tWay to increase your slots\n"
			+ "- Add enemy increasing difficulty\n"
			+ "- Add ally functionality (to help in battle for example)\n"
			+ "- Add a trading system (to use you currency and item's sell and buy costs):\n"
			+ "\tMost probably trades will be performed with allies and neutral trading cities\n"
			+ "- Add new materials, armos, weapons and other\n"
			+ "- Add a player creation step befor the game\n"
			+ "- Add a save system\n"
			+ "- Add more sophisticated map creation:\n"
			+ "\tChoose how big the terrain will be\n"
			+ "\tRandome shape generation instead of rectangular map\n"
			+ "\tMake the terrains hexagons\n"
			+ "- Add a turn-based system, so that you may perform a certain number of actions per tern\n"
			+ "- Add special effects usage"
			+ "- Add Anvil and Workbench obtaining methods + other Workstations"
			+ "- Add chest functionality in your home (storage)";
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		toDoLabel.setText(toDo);
	}

}
