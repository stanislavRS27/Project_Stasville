package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HowToPlayController implements Initializable{

	@FXML
	private Label howToPlayLabel;
	
	private String howToPlay = "Welcome to Stasville!\n"
			+ "By hovering with the mouse on most objects\n"
			+ "(like items in your inventory, NPCs or cities, crafting reciepes, etc.) you will\n"
			+ "recieve a brief information about the given objet.\n"
			+ "The blue tiles with text in them are the cities of Stasville! You can navigate around the map\n"
			+ "by clicking on the text of the city you want to go to,\n"
			+ "but notice, you may only move one tile at a time!\n"
			+ "The Red-colored city is the one, you are currently in, the yellow-colored city is your Home,\n"
			+ "the black-colored cities are possible ne locations, to which you may move\n"
			+ "and the greyed out cities are inaccessible at the moment!\n"
			+ "Your home is an important city, because only there you may craft new gear!\n"
			+ "On the right-hand side of the map are the player statistics and their inventory.\n"
			+ "The \"Attack Power\" determines how hard you strike your foes,\n"
			+ "while the defense determines how much damage you can negate from incomming attacks!\n"
			+ "You can equip and unequip armors and weapons by simply pressing them.\n"
			+ "You can also remove items from your inventory slots (but not armor and weapon slots)\n"
			+ "by Right-Clicking on them! Be wary not to delet your stuff unintentionally!\n"
			+ "Note that your inventory slots are limited, as well as your armor and weapon slots!\n"
			+ "For now, there are two fractions: Sinisters and Nobels. The Nobels are your allies,\n"
			+ "while the Sinisters are your enemies, and as such you fight with eachother!\n"
			+ "Next to every enemy, there is an attack button, which functionality is hopefully is selfexplanatory!\n"
			+ "Note that if you don't kill an enemy in one blow, they will attack you back!\n"
			+ "If you die, the screen will be grayed out, and the only option will be to restart or quit.\n"
			+ "Once you have killed an enemy, you may loot them! You simply click on the items you want.\n"
			+ "If you are in your Home, you may craft some gear!\n"
			+ "The crafting reciepe can be seen by hovering over the item you would like to craft!\n"
			+ "If you don't have enough free slots or materials needed, nothing will happen.\n";

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		howToPlayLabel.setText(howToPlay);
	}
	
}
