package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.actors.Actor;
import application.items.Item;
import application.items.armors.Armor;
import application.items.weapons.Weapon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LootSceneController implements Initializable{
	
	@FXML
	private ListView<Item> lootListView;
	
	@FXML
	private Button buttonDone;
	
	private MainSceneController msc = Main.mainFXMLLoader.getController();
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		createLootCellFactory();
	}

	public void setLootListView(Actor actor) {
		for(int i = 0; i < actor.getInventoryLength(); ++i) {
			if(actor.getInventorySlots()[i] != null) {
				lootListView.getItems().add(actor.getInventorySlots()[i]);
			}
		}
		for(int i = 0; i < actor.getWeaponSlotsLength(); ++i) {
			if(actor.getWeaponSlots()[i] != null) {
				lootListView.getItems().add(actor.getWeaponSlots()[i]);
			}
		}
		for(int i = 0; i < actor.getArmorSlotsLength(); ++i) {
			if(actor.getArmorSlots()[i] != null) {
				lootListView.getItems().add(actor.getArmorSlots()[i]);
			}
		}
	}
	
	public void setUpDoneButton(ActionEvent e) {
		Button button = (Button) e.getSource();
		Stage stage = (Stage) button.getScene().getWindow();
		stage.close();
	}
	
	private void createLootCellFactory() {
		lootListView.setCellFactory(cell -> new ListCell<Item>() {
			
			{
				setOnMouseEntered(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						updateItem(getItem(), false);
					}
					
				});
				
				setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						if(e.getButton() == MouseButton.PRIMARY) {
							if(lootListView.getSelectionModel().getSelectedItem() != null) {
								if(msc.getInventoryListView().getItems().size() < msc.me.getInventoryLength()) {
									
									boolean flag = true;
									
									if(lootListView.getSelectionModel().getSelectedItem().getItemID().id > 4 && lootListView.getSelectionModel().getSelectedItem().getItemID().id < 7) {
										for(int i = 0; i < msc.me.getInventoryLength(); ++i) {
											if(msc.me.getInventorySlots()[i] != null && (lootListView.getSelectionModel().getSelectedItem().getItemID().id == msc.me.getInventorySlots()[i].getItemID().id)) {
												msc.me.getInventorySlots()[i].setItemStack(msc.me.getInventorySlots()[i].getItemStack() + lootListView.getSelectionModel().getSelectedItem().getItemStack());
												lootListView.getItems().remove(lootListView.getSelectionModel().getSelectedIndex());
												flag = false;
												break;
											}
										}
									}
									
									if(flag) {
										msc.getInventoryListView().getItems().add(getItem());
										lootListView.getItems().remove(lootListView.getSelectionModel().getSelectedIndex());
										
										Item[] items = new Item[msc.getInventoryListView().getItems().size()];
										items = msc.getInventoryListView().getItems().toArray(items);
										if(items.length != 0) {
											for(int i = 0, j = 0; i < msc.me.getInventoryLength(); ++i) {
												if(j < items.length) {
													msc.me.setInventorySlots(-1, i, items[j++]);
												} else {
													msc.me.setInventorySlots(-1, i, null);
												}
											}
										} else {
											for(int i = 0; i <msc.me.getInventoryLength(); ++i) {
												msc.me.setInventorySlots(-1, i, null);
											}
										}
									}
								} else if(lootListView.getSelectionModel().getSelectedItem().getItemID().id > 4 && lootListView.getSelectionModel().getSelectedItem().getItemID().id < 7) {
									if(lootListView.getSelectionModel().getSelectedItem().getItemID().id > 4 && lootListView.getSelectionModel().getSelectedItem().getItemID().id < 7) {
										for(int i = 0; i < msc.me.getInventoryLength(); ++i) {
											if(msc.me.getInventorySlots()[i] != null && (lootListView.getSelectionModel().getSelectedItem().getItemID().id == msc.me.getInventorySlots()[i].getItemID().id)) {
												msc.me.getInventorySlots()[i].setItemStack(msc.me.getInventorySlots()[i].getItemStack() + lootListView.getSelectionModel().getSelectedItem().getItemStack());
												lootListView.getItems().remove(lootListView.getSelectionModel().getSelectedIndex());
												break;
											}
										}
									}
								}
							}
						}
					}
				});
			}
			
			@Override
			protected void updateItem(Item item, boolean empty) {
				super.updateItem(item, empty);
				Tooltip inventoryListViewTooltip = new Tooltip();
				inventoryListViewTooltip.setShowDelay(Duration.seconds(0.2));
				inventoryListViewTooltip.setShowDuration(Duration.INDEFINITE);

				if (item == null || empty) {
					setText(null);
					setTooltip(null);
				} else {
					setText(item.getName());

					inventoryListViewTooltip.setText(item.displayItemInformation() + (item instanceof Armor ? "Defense: " + Float.toString(((Armor) item).getDefenseValue()) + "\n" + "Special effect: " + ((Armor) item).getSpecialEffectID().label : item instanceof Weapon ? "Damage: " + Float.toString(((Weapon) item).getDamageValue()) + "\n" + "Special effect: " + ((Weapon) item).getSpecialEffectID().label : ""));
					setTooltip(inventoryListViewTooltip);
				}
			}
			
		});
	}
}
