package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.actors.Actor;
import application.actors.Player;
import application.actors.nobels.Elite;
import application.actors.nobels.Guardian;
import application.actors.nobels.Priest;
import application.actors.sinisters.Ancient;
import application.actors.sinisters.Demon;
import application.actors.sinisters.Necromancer;
import application.items.armors.Armor;
import application.items.armors.SteelArmor;
import application.items.armors.TitaniumArmor;
import application.items.materials.Steel;
import application.items.materials.Titanium;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import application.map.PlayerHome;
import application.map.Terrain;
import application.items.CraftingRecipes;
import application.items.Item;
import application.items.ItemID;
import application.items.SpecialEffectID;
import application.items.weapons.Dagger;
import application.items.weapons.Greatsword;
import application.items.weapons.Weapon;
import application.items.workstations.Anvil;
import application.items.workstations.Workbench;

public class MainSceneController implements Initializable {
	
	@FXML
	private SplitPane splitPane;
	
	@FXML
	private Button howToPlayButton;
	@FXML
	private Button restartButton;
	@FXML
	private Button toDoButton;

	@FXML
	private Label labelStrength;
	@FXML
	private Label labelIntelligence;
	@FXML
	private Label labelDextirity;
	@FXML
	private Label labelHealth;
	@FXML
	private Label labelAttackPower;
	@FXML
	private Label labelDefense;
	@FXML
	private Label labelMap1;
	@FXML
	private Label labelMap2;
	@FXML
	private Label labelMap3;
	@FXML
	private Label labelMap4;
	@FXML
	private Label labelMap5;
	@FXML
	private Label labelMap6;
	@FXML
	private Label labelMap7;
	@FXML
	private Label labelMap8;
	@FXML
	private Label labelMap9;
	@FXML
	private Label labelMap10;
	@FXML
	private Label labelMap11;
	@FXML
	private Label labelMap12;
	@FXML
	private Label labelMap13;
	@FXML
	private Label labelMap14;
	@FXML
	private Label labelMap15;
	
	@FXML
	private ListView<Armor> armorSlotsListView;
	@FXML
	private ListView<Weapon> weaponSlotsListView;
	@FXML
	private ListView<Item> inventorySlotsListView;
	
	@FXML
	private AnchorPane sinistersAnchorPane;
	@FXML
	private AnchorPane nobelsAnchorPane;
	
	@FXML
	private Label craftSteelArmorLabel;
	@FXML
	private Label craftTitaniumArmorLabel;
	@FXML
	private Label craftDaggerLabel;
	@FXML
	private Label craftGreatswordLabel;
	
	@FXML
	private Button craftSteelArmorButton;
	@FXML
	private Button craftTitaniumArmorButton;
	@FXML
	private Button craftDaggerButton;
	@FXML
	private Button craftGreatswordButton;
	
	@FXML
	private Label labelCurrency;
	
	Label[] mapLabels = new Label[15];

	private String[] terrainNames = { "Velingrad", "Pernik", "Plovdiv", "Sofia", "Blagoevgrad", "Silistra", "Sliven",
			"Teteven", "Shumen", "Varna", "Svoge", "Koprivshtitza", "Stara Zagora", "Ruse", "Montana" };
	
	public Player me;
	public Terrain[] map;
	
	private final Tooltip homeTerrainTooltip = new Tooltip("This is your home!");
	private final Tooltip currentTerrainTooltip = new Tooltip("You are currently here!");

	private List<String> sinistersNamesList = new ArrayList<String>();
	private List<String> nobelsNamesList = new ArrayList<String>();
	private List<String> sinistersTitlesList = new ArrayList<String>();
	private List<String> nobelsTitlesList = new ArrayList<String>();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		splitPane.setDisable(false);
		
		homeTerrainTooltip.setShowDelay(Duration.seconds(0.2));
		homeTerrainTooltip.setShowDuration(Duration.INDEFINITE);
		currentTerrainTooltip.setShowDelay(Duration.seconds(0.2));
		currentTerrainTooltip.setShowDuration(Duration.INDEFINITE);
		
		mapLabels[0] = labelMap1;
		mapLabels[1] = labelMap2;
		mapLabels[2] = labelMap3;
		mapLabels[3] = labelMap4;
		mapLabels[4] = labelMap5;
		mapLabels[5] = labelMap6;
		mapLabels[6] = labelMap7;
		mapLabels[7] = labelMap8;
		mapLabels[8] = labelMap9;
		mapLabels[9] = labelMap10;
		mapLabels[10] = labelMap11;
		mapLabels[11] = labelMap12;
		mapLabels[12] = labelMap13;
		mapLabels[13] = labelMap14;
		mapLabels[14] = labelMap15;

		map = Terrain.createMap(terrainNames, 3);
		
		me = Player.createNewPlayer("Staskata", Actor.allegianceNobel, map[((int) (Math.random() * map.length))], PlayerHome.createHome());
		Dagger myDagger = new Dagger(ItemID.DAGGER, "Staskata's Dagger", 0.0f, 0.0f, 0.0f, 27.3f, SpecialEffectID.NONE, 1);
		SteelArmor mySteelArmor = new SteelArmor(ItemID.STEEL_ARMOR, "Staskata's Steel Armor", 0.0f, 0.0f, 0.0f, 7.3f, SpecialEffectID.NONE, 1);
		me.setWeaponSlots(-1, 0, myDagger);
		me.setArmorSlots(-1, 0, mySteelArmor);
		weaponSlotsListView.getItems().add(myDagger);
		armorSlotsListView.getItems().add(mySteelArmor);
		
		me.getPlayerHome().setWorkbench(Workbench.createWorkbench(ItemID.WORKBENCH, "Workbench", 0.0f, 0.0f, 0.0f, 1));
		me.getPlayerHome().setAnvil(Anvil.createAnvil(ItemID.ANVIL, "Anvil", 0.0f, 0.0f, 0.0f, 1));

		for(int i = 0; i < map.length; ++i) {
			
			Tooltip tooltip1 = new Tooltip("If you click you can move to " + map[i].getName() + "!");
			tooltip1.setShowDelay(Duration.seconds(0.2));
			tooltip1.setShowDuration(Duration.INDEFINITE);
			
			Tooltip tooltip2 = new Tooltip(homeTerrainTooltip.getText() + "\n" + currentTerrainTooltip.getText());
			tooltip2.setShowDelay(Duration.seconds(0.2));
			tooltip2.setShowDuration(Duration.INDEFINITE);
			
			mapLabels[i].setText(map[i].getName());
			mapLabels[i].setTooltip(tooltip1);
			mapLabels[i].setDisable(true);
			
			if(map[i].equals(me.getInitialTerrain())) {
				mapLabels[i].setTooltip(homeTerrainTooltip);
				mapLabels[i].setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 12));
				mapLabels[i].setTextFill(Color.YELLOW);
			}
			
			if(map[i].equals(me.getCurrentTerrain())) {
				mapLabels[i].setDisable(false);
				
				mapLabels[i].setTooltip(tooltip2);
				mapLabels[i].setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 12));
				mapLabels[i].setTextFill(Color.CRIMSON);
			}
			if(map[i].equals(me.getCurrentTerrain().getAdjacentTerrain()[0]) || map[i].equals(me.getCurrentTerrain().getAdjacentTerrain()[1]) || map[i].equals(me.getCurrentTerrain().getAdjacentTerrain()[2]) || map[i].equals(me.getCurrentTerrain().getAdjacentTerrain()[3])) {
				mapLabels[i].setDisable(false);
			}
		}

		generateActorNamesAndTitles();
		generateSinisters();
		generateNobels();
		
		craftingSteelArmorUtilities();
		craftingTitaniumArmorUtilities();
		craftingDaggerUtilities();
		craftingGreatswordUtilities();

		updateLabelStength();
		updateLabelIntelligence();
		updateLabelDextirity();
		updateLabelHealth();
		updateLabelCurrency();

		updateAttackPowerLabel();

		updateDefenseLabel();
		
		createInventoryCellFactory();
		createArmorCellFactory();
		createWeaponCellFactory();
		
		updateSinistersList();
		updateNobelsList();
	}
	
	public void moveTo(MouseEvent e) {
		Label newLocationLabel = (Label) e.getSource();
		String newLocationString = newLocationLabel.getText();
		
		if(!me.getCurrentTerrain().getName().equals(newLocationString)) {
			for(int i = 0; i < map.length; ++i) {
				if(newLocationString.equals(map[i].getName())) {
					for(int j = 0; j < mapLabels.length; ++j) {
						if(mapLabels[j].getText().equals(me.getInitialTerrain().getName())) {
							mapLabels[j].setTooltip(homeTerrainTooltip);
							mapLabels[j].setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 12));
							mapLabels[j].setTextFill(Color.YELLOW);
						} else {
							mapLabels[j].setTooltip(new Tooltip("If you click you can move to " + map[j].getName() + "!"));
							mapLabels[j].setFont(Font.font("System", FontWeight.NORMAL, FontPosture.REGULAR, 12));
							mapLabels[j].setTextFill(Color.BLACK);
						}
						mapLabels[j].setDisable(true);
					}
					me.move(map[i]);
						
					for(int j = 0; j < mapLabels.length; ++j) {
						if(mapLabels[j].getText().equals(me.getCurrentTerrain().getName())) {
							mapLabels[j].setDisable(false);
							
							if(mapLabels[j].getText().equals(me.getInitialTerrain().getName())) {
								Tooltip newTooltip = new Tooltip(homeTerrainTooltip.getText() + "\n" + currentTerrainTooltip.getText());
								newTooltip.setShowDelay(Duration.seconds(0.2));
								newTooltip.setShowDuration(Duration.INDEFINITE);
								mapLabels[j].setTooltip(newTooltip);
							} else {
								mapLabels[j].setTooltip(currentTerrainTooltip);
							}
							
							mapLabels[j].setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 12));
							mapLabels[j].setTextFill(Color.CRIMSON);
						}
						if(map[j].equals(me.getCurrentTerrain().getAdjacentTerrain()[0]) || map[j].equals(me.getCurrentTerrain().getAdjacentTerrain()[1]) || map[j].equals(me.getCurrentTerrain().getAdjacentTerrain()[2]) || map[j].equals(me.getCurrentTerrain().getAdjacentTerrain()[3])) {
							mapLabels[j].setDisable(false);
							
							if(mapLabels[j].getText().equals(me.getInitialTerrain().getName())) {
								Tooltip newTooltip = new Tooltip(homeTerrainTooltip.getText() + "\n" + "If you click you can move to " + map[j].getName() + "!");
								newTooltip.setShowDelay(Duration.seconds(1));
								newTooltip.setShowDuration(Duration.INDEFINITE);
								mapLabels[j].setTooltip(newTooltip);
							}
						}
					}
					break;
				}
			}
			
			boolean canCraft = !(me.getCurrentTerrain() == me.getInitialTerrain());
			craftSteelArmorButton.setDisable(canCraft);
			craftTitaniumArmorButton.setDisable(canCraft);
			craftDaggerButton.setDisable(canCraft);
			craftGreatswordButton.setDisable(canCraft);
		}
		
		updateSinistersList();
		updateNobelsList();
	}
	
	private void updateDefenseLabel() {
		if(me.getArmorSlots()[0] != null) {
			labelDefense.setText(Float.toString(me.getArmorSlots()[0].getDefenseValue() * me.getDextirityPoints()));
		} else {
			labelDefense.setText("0.0");
		}
	}
	
	private void updateAttackPowerLabel() {
		if(me.getWeaponSlots()[0] != null) {
			labelAttackPower.setText(Float.toString(me.getWeaponSlots()[0].getDamageValue() * (me.getStrengthPoints() + me.getIntelligencePoints())));
		} else {
			labelAttackPower.setText("0.0");
		}
	}
	
	private void updateSinistersList() {
		sinistersAnchorPane.getChildren().clear();
		if(me.getCurrentTerrain().getTerrainPopulationSinisters() != null) {
			int sinisters = 0;
			for(@SuppressWarnings("unused") Actor actor : me.getCurrentTerrain().getTerrainPopulationSinisters()) {
				sinisters++;
			}
			Label[] sinistersLabels = new Label[sinisters];
			Button[] sinistersAttackButton = new Button[sinisters];
			
			double initSinistersLabelX = 30.0;
			double initSinistersLabelY = 30.0;
			
			for(int i = 0; i < sinisters; ++i) {
				Tooltip sinistersLabelTooltip = new Tooltip();
				sinistersLabelTooltip.setShowDelay(Duration.seconds(0.2));
				sinistersLabelTooltip.setShowDuration(Duration.INDEFINITE);
				
				sinistersLabels[i] = new Label(me.getCurrentTerrain().getTerrainPopulationSinisters()[i].getName());
				sinistersLabelTooltip.setText(me.getCurrentTerrain().getTerrainPopulationSinisters()[i].displayActorInformation());
				sinistersLabels[i].setTooltip(sinistersLabelTooltip);
				
				sinistersLabels[i].setLayoutX(initSinistersLabelX);
				sinistersLabels[i].setLayoutY(initSinistersLabelY);
				
				if(!me.getAllegiance().equals(Actor.allegianceSinister)) {
					sinistersAttackButton[i] = new Button("Attack");
					
					final int avoidError = i;
					sinistersAttackButton[i].setOnAction(e -> {
						me.attack(me.getCurrentTerrain().getTerrainPopulationSinisters()[avoidError]);
						updateLabelCurrency();
						updateSinistersList();
						updateLabelHealth();
					});
					
					sinistersAttackButton[i].setLayoutX(initSinistersLabelX + 100);
					sinistersAttackButton[i].setLayoutY(initSinistersLabelY - 5);
				}
				
				initSinistersLabelY += 50;
				if(sinistersAnchorPane.getHeight() < initSinistersLabelY) {
					sinistersAnchorPane.setLayoutY(sinistersAnchorPane.getHeight() + 100);
				}
				if(!me.getAllegiance().equals(Actor.allegianceSinister)) {
					sinistersAnchorPane.getChildren().addAll(sinistersLabels[i], sinistersAttackButton[i]);
				} else {
					sinistersAnchorPane.getChildren().add(sinistersLabels[i]);
				}
			}
		} else {
			//add label for "all defeated/dead"
		}
	}
	
	private void updateNobelsList() {
		nobelsAnchorPane.getChildren().clear();
		if(me.getCurrentTerrain().getTerrainPopulationNobels() != null) {
			int nobels = 0;
			for(@SuppressWarnings("unused") Actor actor : me.getCurrentTerrain().getTerrainPopulationNobels()) {
				nobels++;
			}
			Label[] nobelsLabels = new Label[nobels];
			Button[] nobelsAttackButton = new Button[nobels];
			
			double initNobelsLabelX = 30.0;
			double initNobelsLabelY = 30.0;
			for(int i = 0; i < nobels; ++i) {
				Tooltip nobelsLabelTooltip = new Tooltip();
				nobelsLabelTooltip.setShowDelay(Duration.seconds(0.2));
				nobelsLabelTooltip.setShowDuration(Duration.INDEFINITE);

				nobelsLabels[i] = new Label(me.getCurrentTerrain().getTerrainPopulationNobels()[i].getName());
				nobelsLabelTooltip.setText(me.getCurrentTerrain().getTerrainPopulationNobels()[i].displayActorInformation());
				nobelsLabels[i].setTooltip(nobelsLabelTooltip);
				
				nobelsLabels[i].setLayoutX(initNobelsLabelX);
				nobelsLabels[i].setLayoutY(initNobelsLabelY);
				
				if(!me.getAllegiance().equals(Actor.allegianceNobel)) {
					nobelsAttackButton[i] = new Button("Attack");
					
					final int avoidError = i;
					nobelsAttackButton[i].setOnAction(e -> {
						me.attack(me.getCurrentTerrain().getTerrainPopulationNobels()[avoidError]);
						updateLabelCurrency();
						updateNobelsList();
						updateLabelHealth();
					});
					
					nobelsAttackButton[i].setLayoutX(initNobelsLabelX + 100);
					nobelsAttackButton[i].setLayoutY(initNobelsLabelY - 5);
				}
				
				initNobelsLabelY += 50;
				if(nobelsAnchorPane.getHeight() < initNobelsLabelY) {
					nobelsAnchorPane.setLayoutY(nobelsAnchorPane.getHeight() + 100);
				}
				if(!me.getAllegiance().equals(Actor.allegianceNobel)){
					nobelsAnchorPane.getChildren().addAll(nobelsLabels[i], nobelsAttackButton[i]);
				} else {
					nobelsAnchorPane.getChildren().add(nobelsLabels[i]);
				}
			}
		} else {
			//add label for "all defeated/dead"
		}
	}
	
	private void createInventoryCellFactory() {
		inventorySlotsListView.setCellFactory(cell -> new ListCell<Item>() {

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
						if (e.getButton() == MouseButton.PRIMARY) {
							if (inventorySlotsListView.getSelectionModel().getSelectedItem() instanceof Armor) {
								if (armorSlotsListView.getItems().size() < me.getArmorSlotsLength()) {
									armorSlotsListView.getItems().add((Armor) getItem());
									inventorySlotsListView.getItems().remove(inventorySlotsListView.getSelectionModel().getSelectedIndex());
									
									Armor[] armors = new Armor[armorSlotsListView.getItems().size()];
									armors = armorSlotsListView.getItems().toArray(armors);
									if (armors.length != 0) {
										for (int i = 0, j = 0; i < me.getArmorSlotsLength(); ++i) {
											if(j < armors.length) {
												me.setArmorSlots(-1, i, armors[j++]);
											} else {
												me.setArmorSlots(-1, i, null);
											}
										}
									} else {
										for (int i = 0; i < me.getArmorSlotsLength(); ++i) {
											me.setArmorSlots(-1, i, null);
										}
									}
									
									updateDefenseLabel();
								}
							} else if (inventorySlotsListView.getSelectionModel().getSelectedItem() instanceof Weapon) {
								if (weaponSlotsListView.getItems().size() < me.getWeaponSlotsLength()) {
									weaponSlotsListView.getItems().add((Weapon) getItem());
									inventorySlotsListView.getItems().remove(inventorySlotsListView.getSelectionModel().getSelectedIndex());
									
									Weapon[] weapons = new Weapon[weaponSlotsListView.getItems().size()];
									weapons = weaponSlotsListView.getItems().toArray(weapons);
									if (weapons.length != 0) {
										for (int i = 0, j = 0; i < me.getWeaponSlotsLength(); ++i) {
											if(j < weapons.length) {
												me.setWeaponSlots(-1, i, weapons[j++]);
											} else {
												me.setWeaponSlots(-1, i, null);
											}
										}
									} else {
										for (int i = 0; i < me.getWeaponSlotsLength(); ++i) {
											me.setWeaponSlots(-1, i, null);
										}
									}
									
									updateAttackPowerLabel();
								}
							}

							Item[] items = new Item[inventorySlotsListView.getItems().size()];
							items = inventorySlotsListView.getItems().toArray(items);
							if (items.length != 0) {
								for (int i = 0, j = 0; i < me.getInventoryLength(); ++i) {
									if(j < items.length) {
										me.setInventorySlots(-1, i, items[j++]);
									} else {
										me.setInventorySlots(-1, i, null);
									}
								}
							} else {
								for (int i = 0; i < me.getInventoryLength(); ++i) {
									me.setInventorySlots(-1, i, null);
								}
							}
							
						}
						if (e.getButton() == MouseButton.SECONDARY) {
							try {
								inventorySlotsListView.getItems().remove(inventorySlotsListView.getSelectionModel().getSelectedIndex());
	
								Item[] items = new Item[inventorySlotsListView.getItems().size()];
								items = inventorySlotsListView.getItems().toArray(items);
								if (items.length != 0) {
									for (int i = 0, j = 0; i < me.getInventoryLength(); ++i) {
										if(j < items.length) {
											me.setInventorySlots(-1, i, items[j++]);
										} else {
											me.setInventorySlots(-1, i, null);
										}
									}
								} else {
									for (int i = 0; i < me.getInventoryLength(); ++i) {
										me.setInventorySlots(-1, i, null);
									}
								}
							} catch(IndexOutOfBoundsException iobe){
								//nothing happens, life goes on
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
	
	private void createArmorCellFactory() {
		armorSlotsListView.setCellFactory(cell -> new ListCell<Armor>() {
			
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
							if (inventorySlotsListView.getItems().size() < me.getInventoryLength()) {
								if(armorSlotsListView.getSelectionModel().getSelectedItem() != null) {
									inventorySlotsListView.getItems().add(getItem());
									armorSlotsListView.getItems().remove(armorSlotsListView.getSelectionModel().getSelectedIndex());
									
									Armor[] armors = new Armor[armorSlotsListView.getItems().size()];
									armors = armorSlotsListView.getItems().toArray(armors);
									if(armors.length != 0) {
										for(int i = 0, j = 0; i < me.getArmorSlotsLength(); ++i) {
											if(j < armors.length) {
												me.setArmorSlots(-1, i, armors[j++]);
											} else {
												me.setArmorSlots(-1, i, null);
											}
										}
									} else {
										for(int i = 0; i < me.getArmorSlotsLength(); ++i) {
											me.setArmorSlots(-1, i, null);
										}
									}
									
									Item[] items = new Item[inventorySlotsListView.getItems().size()];
									items = inventorySlotsListView.getItems().toArray(items);
									if(items.length != 0) {
										for(int i = 0, j = 0; i < me.getInventoryLength(); ++i) {
											if(j < items.length) {
												me.setInventorySlots(-1, i, items[j++]);
											} else {
												me.setInventorySlots(-1, i, null);
											}
										}
									} else {
										for(int i = 0; i < me.getInventoryLength(); ++i) {
											me.setInventorySlots(-1, i, null);
										}
									}
								}
							}
						}
						
						updateDefenseLabel();
					}
				});
			}
			
			@Override
			protected void updateItem(Armor armor, boolean empty) {
				super.updateItem(armor, empty);
				Tooltip inventoryListViewTooltip = new Tooltip();
				inventoryListViewTooltip.setShowDelay(Duration.seconds(0.2));
				inventoryListViewTooltip.setShowDuration(Duration.INDEFINITE);

				if (armor == null || empty) {
					setText(null);
					setTooltip(null);
				} else {
					setText(armor.getName());
					
					inventoryListViewTooltip.setText(armor.displayItemInformation() + "Defense: " + Float.toString(armor.getDefenseValue()) + "\n" + "Special effect: " + armor.getSpecialEffectID().label);
					setTooltip(inventoryListViewTooltip);
				}
			}
		});
	}
	
	private void createWeaponCellFactory() {
		weaponSlotsListView.setCellFactory(cell -> new ListCell<Weapon>() {
			
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
							if (inventorySlotsListView.getItems().size() < me.getInventoryLength()) {
								if(weaponSlotsListView.getSelectionModel().getSelectedItem() != null) {
									inventorySlotsListView.getItems().add(getItem());
									weaponSlotsListView.getItems().remove(weaponSlotsListView.getSelectionModel().getSelectedIndex());
									
									Weapon[] weapons = new Weapon[weaponSlotsListView.getItems().size()];
									weapons = weaponSlotsListView.getItems().toArray(weapons);
									if(weapons.length != 0) {
										for(int i = 0, j = 0; i < me.getWeaponSlotsLength(); ++i) {
											if(j < weapons.length) {
												me.setWeaponSlots(-1, i, weapons[j++]);
											} else {
												me.setWeaponSlots(-1, i, null);
											}
										}
									} else {
										for(int i = 0; i < me.getWeaponSlotsLength(); ++i) {
											me.setWeaponSlots(-1, i, null);
										}
									}
									
									Item[] items = new Item[inventorySlotsListView.getItems().size()];
									items = inventorySlotsListView.getItems().toArray(items);
									if(items.length != 0) {
										for(int i = 0, j = 0; i < me.getInventoryLength(); ++i) {
											if(j < items.length) {
												me.setInventorySlots(-1, i, items[j++]);
											} else {
												me.setInventorySlots(-1, i, null);
											}
										}
									} else {
										for(int i = 0; i < me.getInventoryLength(); ++i) {
											me.setInventorySlots(-1, i, null);
										}
									}
								}
							}
						}
						
						updateAttackPowerLabel();
					}
				});
			}
			
			@Override
			protected void updateItem(Weapon weapon, boolean empty) {
				super.updateItem(weapon, empty);
				Tooltip inventoryListViewTooltip = new Tooltip();
				inventoryListViewTooltip.setShowDelay(Duration.seconds(0.2));
				inventoryListViewTooltip.setShowDuration(Duration.INDEFINITE);

				if (weapon == null || empty) {
					setText(null);
					setTooltip(null);
				} else {
					setText(weapon.getName());
					
					inventoryListViewTooltip.setText(weapon.displayItemInformation() + "Damage: " +  Float.toString(weapon.getDamageValue()) + "\n" + "Special effect: " +  weapon.getSpecialEffectID().label);
					setTooltip(inventoryListViewTooltip);
				}
			}
		});
	}
	
	private void generateNobels() {
		for(int i = 0; i < map.length; ++i) {
			Guardian[] guardians = new Guardian[((int)(Math.ceil(Math.random() * (me.getAllegiance().equals(Actor.allegianceNobel) ? 5 : 20))))];
			Priest[] priests = new Priest[((int)(Math.ceil(Math.random() * (me.getAllegiance().equals(Actor.allegianceNobel) ? 3 : 13))))];
			Elite[] elites = new Elite[((int)(Math.ceil(Math.random() * (me.getAllegiance().equals(Actor.allegianceNobel) ? 2 : 5))))];
			Actor[] nobels = new Actor[guardians.length + priests.length + elites.length];
			int nobelsIndex = 0;
			for(int j = 0; j < guardians.length; ++j) {
				String name = nobelsNamesList.get((int)(Math.random() *  nobelsNamesList.size()));
				String title = nobelsTitlesList.get((int)(Math.random() *  nobelsTitlesList.size()));
				guardians[j] = Guardian.createNewGuardian(name, title);
				int whichWeapon = (int)(Math.random() * 2);
				int whichArmor = (int)(Math.random() * 2);
				guardians[j].setWeaponSlots(-1, 0, (whichWeapon >= 1 ? new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, getRandomNumber(4.0f, 7.0f), SpecialEffectID.NONE, 1) : new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, getRandomNumber(10.7f, 13.5f), SpecialEffectID.NONE, 1)));
				guardians[j].setArmorSlots(-1, 0, (whichArmor >= 1 ? new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, getRandomNumber(9.0f, 15.0f), SpecialEffectID.NONE, 1) : new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, getRandomNumber(14.8f, 23.0f), SpecialEffectID.NONE, 1)));
				int numberOfItems = getRandomNumber(2.0f, 10.0f);
				for(int k = 0; k < numberOfItems; ++k) {
					int whichItem = (int)(Math.random() * 10) + 1;
					if(whichItem >= 7) {
						int quantity = (int)(Math.random() * 6 + 1);
						Titanium titanium = new Titanium(ItemID.TITANIUM, "Titanium", 5.0f, 7.0f, 2.0f, quantity);
						guardians[j].setInventorySlots(-1, k, titanium);
					} else if(whichItem >= 4) {
						int quantity = (int)(Math.random() * 9 + 1);
						Steel steel = new Steel(ItemID.STEEL, "Steel", 3.0f, 5.0f, 1.0f, quantity);
						guardians[j].setInventorySlots(-1, k, steel);
					} else if(whichItem >= 3) {
						int defense = getRandomNumber(9.0f, 15.0f);
						SteelArmor steelArmor = new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, defense, SpecialEffectID.NONE, 1);
						guardians[j].setInventorySlots(-1, k, steelArmor);
					} else if(whichItem >= 2) {
						int defense = getRandomNumber(14.8f, 23.0f);
						TitaniumArmor titaniumArmor = new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, defense, SpecialEffectID.NONE, 1);
						guardians[j].setInventorySlots(-1, k, titaniumArmor);
					} else if(whichItem >= 1) {
						int damage = getRandomNumber(4.0f, 7.0f);
						Dagger dagger = new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, damage, SpecialEffectID.NONE, 1);
						guardians[j].setInventorySlots(-1, k, dagger);
					} else {
						int damage = getRandomNumber(10.7f, 13.5f);
						Greatsword greatsword = new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, damage, SpecialEffectID.NONE, 1);
						guardians[j].setInventorySlots(-1, k, greatsword);
					}
				}
				guardians[j].setCurrency(getRandomNumber(2.0f, 10.0f));
				nobels[nobelsIndex++] = guardians[j];
			}
			for(int j = 0; j < priests.length; ++j) {
				String name = nobelsNamesList.get((int)(Math.random() *  nobelsNamesList.size()));
				String title = nobelsTitlesList.get((int)(Math.random() *  nobelsTitlesList.size()));
				priests[j] = Priest.createNewPriest(name, title);
				int whichWeapon = (int)(Math.random() * 2);
				int whichArmor = (int)(Math.random() * 2);
				priests[j].setWeaponSlots(-1, 0, (whichWeapon >= 1 ? new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, getRandomNumber(4.0f, 7.0f), SpecialEffectID.NONE, 1) : new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, getRandomNumber(10.7f, 13.5f), SpecialEffectID.NONE, 1)));
				priests[j].setArmorSlots(-1, 0, (whichArmor >= 1 ? new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, getRandomNumber(9.0f, 15.0f), SpecialEffectID.NONE, 1) : new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, getRandomNumber(14.8f, 23.0f), SpecialEffectID.NONE, 1)));
				int numberOfItems = getRandomNumber(2.0f, 10.0f);
				for(int k = 0; k < numberOfItems; ++k) {
					int whichItem = (int)(Math.random() * 10) + 1;
					if(whichItem >= 7) {
						int quantity = (int)(Math.random() * 6 + 1);
						Titanium titanium = new Titanium(ItemID.TITANIUM, "Titanium", 5.0f, 7.0f, 2.0f, quantity);
						priests[j].setInventorySlots(-1, k, titanium);
					} else if(whichItem >= 4) {
						int quantity = (int)(Math.random() * 9 + 1);
						Steel steel = new Steel(ItemID.STEEL, "Steel", 3.0f, 5.0f, 1.0f, quantity);
						priests[j].setInventorySlots(-1, k, steel);
					} else if(whichItem >= 3) {
						int defense = getRandomNumber(9.0f, 15.0f);
						SteelArmor steelArmor = new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, defense, SpecialEffectID.NONE, 1);
						priests[j].setInventorySlots(-1, k, steelArmor);
					} else if(whichItem >= 2) {
						int defense = getRandomNumber(14.8f, 23.0f);
						TitaniumArmor titaniumArmor = new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, defense, SpecialEffectID.NONE, 1);
						priests[j].setInventorySlots(-1, k, titaniumArmor);
					} else if(whichItem >= 1) {
						int damage = getRandomNumber(4.0f, 7.0f);
						Dagger dagger = new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, damage, SpecialEffectID.NONE, 1);
						priests[j].setInventorySlots(-1, k, dagger);
					} else {
						int damage = getRandomNumber(10.7f, 13.5f);
						Greatsword greatsword = new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, damage, SpecialEffectID.NONE, 1);
						priests[j].setInventorySlots(-1, k, greatsword);
					}
				}
				priests[j].setCurrency(getRandomNumber(4.0f, 20.0f));
				nobels[nobelsIndex++] = priests[j];
			}
			for(int j = 0; j < elites.length; ++j) {
				String name = nobelsNamesList.get((int)(Math.random() *  nobelsNamesList.size()));
				String title = nobelsTitlesList.get((int)(Math.random() *  nobelsTitlesList.size()));
				elites[j] = Elite.createNewElite(name, title);
				int whichWeapon = (int)(Math.random() * 2);
				int whichArmor = (int)(Math.random() * 2);
				elites[j].setWeaponSlots(-1, 0, (whichWeapon >= 1 ? new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, getRandomNumber(4.0f, 7.0f), SpecialEffectID.NONE, 1) : new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, getRandomNumber(10.7f, 13.5f), SpecialEffectID.NONE, 1)));
				elites[j].setArmorSlots(-1, 0, (whichArmor >= 1 ? new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, getRandomNumber(9.0f, 15.0f), SpecialEffectID.NONE, 1) : new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, getRandomNumber(14.8f, 23.0f), SpecialEffectID.NONE, 1)));
				int numberOfItems = getRandomNumber(2.0f, 10.0f);
				for(int k = 0; k < numberOfItems; ++k) {
					int whichItem = (int)(Math.random() * 10) + 1;
					if(whichItem >= 7) {
						int quantity = (int)(Math.random() * 6 + 1);
						Titanium titanium = new Titanium(ItemID.TITANIUM, "Titanium", 5.0f, 7.0f, 2.0f, quantity);
						elites[j].setInventorySlots(-1, k, titanium);
					} else if(whichItem >= 4) {
						int quantity = (int)(Math.random() * 9 + 1);
						Steel steel = new Steel(ItemID.STEEL, "Steel", 3.0f, 5.0f, 1.0f, quantity);
						elites[j].setInventorySlots(-1, k, steel);
					} else if(whichItem >= 3) {
						int defense = getRandomNumber(9.0f, 15.0f);
						SteelArmor steelArmor = new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, defense, SpecialEffectID.NONE, 1);
						elites[j].setInventorySlots(-1, k, steelArmor);
					} else if(whichItem >= 2) {
						int defense = getRandomNumber(14.8f, 23.0f);
						TitaniumArmor titaniumArmor = new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, defense, SpecialEffectID.NONE, 1);
						elites[j].setInventorySlots(-1, k, titaniumArmor);
					} else if(whichItem >= 1) {
						int damage = getRandomNumber(4.0f, 7.0f);
						Dagger dagger = new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, damage, SpecialEffectID.NONE, 1);
						elites[j].setInventorySlots(-1, k, dagger);
					} else {
						int damage = getRandomNumber(10.7f, 13.5f);
						Greatsword greatsword = new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, damage, SpecialEffectID.NONE, 1);
						elites[j].setInventorySlots(-1, k, greatsword);
					}
				}
				elites[j].setCurrency(getRandomNumber(8.0f, 40.0f));
				nobels[nobelsIndex++] = elites[j];
			}
			map[i].setTerrainPopulationNobels(nobels);
		}
	}
	
	private void generateSinisters() {
		for(int i = 0; i < map.length; ++i) {
			Demon[] demons = new Demon[((int)(Math.ceil(Math.random() * (me.getAllegiance().equals(Actor.allegianceSinister) ? 5 : 20))))];
			Necromancer[] necromancers = new Necromancer[((int)(Math.ceil(Math.random() * (me.getAllegiance().equals(Actor.allegianceSinister) ? 3 : 13))))];
			Ancient[] ancients = new Ancient[((int)(Math.ceil(Math.random() * (me.getAllegiance().equals(Actor.allegianceSinister) ? 2 : 5))))];
			Actor[] sinisters = new Actor[demons.length + necromancers.length + ancients.length];
			int sinistersIndex = 0;
			for(int j = 0; j < demons.length; ++j) {
				demons[j] = Demon.createNewDemon(sinistersNamesList.get((int)(Math.random() *  sinistersNamesList.size())), sinistersTitlesList.get((int)(Math.random() *  sinistersTitlesList.size())));
				demons[j].setWeaponSlots(-1, 0, (((int)(Math.random() * 2)) >= 1 ? new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, getRandomNumber(4.0f, 7.0f), SpecialEffectID.NONE, 1) : new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, getRandomNumber(10.7f, 13.5f), SpecialEffectID.NONE, 1)));
				demons[j].setArmorSlots(-1, 0, (((int)(Math.random() * 2)) >= 1 ? new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, getRandomNumber(9.0f, 15.0f), SpecialEffectID.NONE, 1) : new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, getRandomNumber(14.8f, 23.0f), SpecialEffectID.NONE, 1)));
				int numberOfItems = getRandomNumber(2.0f, 10.0f);
				for(int k = 0; k < numberOfItems; ++k) {
					int whichItem = (int)(Math.random() * 10) + 1;
					if(whichItem >= 7) {
						int quantity = (int)(Math.random() * 6 + 1);
						Titanium titanium = new Titanium(ItemID.TITANIUM, "Titanium", 5.0f, 7.0f, 2.0f, quantity);
						demons[j].setInventorySlots(-1, k, titanium);
					} else if(whichItem >= 4) {
						int quantity = (int)(Math.random() * 9 + 1);
						Steel steel = new Steel(ItemID.STEEL, "Steel", 3.0f, 5.0f, 1.0f, quantity);
						demons[j].setInventorySlots(-1, k, steel);
					} else if(whichItem >= 3) {
						int defense = getRandomNumber(9.0f, 15.0f);
						SteelArmor steelArmor = new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, defense, SpecialEffectID.NONE, 1);
						demons[j].setInventorySlots(-1, k, steelArmor);
					} else if(whichItem >= 2) {
						int defense = getRandomNumber(14.8f, 23.0f);
						TitaniumArmor titaniumArmor = new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, defense, SpecialEffectID.NONE, 1);
						demons[j].setInventorySlots(-1, k, titaniumArmor);
					} else if(whichItem >= 1) {
						int damage = getRandomNumber(4.0f, 7.0f);
						Dagger dagger = new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, damage, SpecialEffectID.NONE, 1);
						demons[j].setInventorySlots(-1, k, dagger);
					} else {
						int damage = getRandomNumber(10.7f, 13.5f);
						Greatsword greatsword = new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, damage, SpecialEffectID.NONE, 1);
						demons[j].setInventorySlots(-1, k, greatsword);
					}
				}
				demons[j].setCurrency(getRandomNumber(2.0f, 10.0f));
				sinisters[sinistersIndex++] = demons[j];
			}
			for(int j = 0; j < necromancers.length; ++j) {
				necromancers[j] = Necromancer.createNewNecromancer(sinistersNamesList.get((int)(Math.random() *  sinistersNamesList.size())), sinistersTitlesList.get((int)(Math.random() *  sinistersTitlesList.size())));
				necromancers[j].setWeaponSlots(-1, 0, (((int)(Math.random() * 2)) >= 1 ? new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, getRandomNumber(4.0f, 7.0f), SpecialEffectID.NONE, 1) : new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, getRandomNumber(10.7f, 13.5f), SpecialEffectID.NONE, 1)));
				necromancers[j].setArmorSlots(-1, 0, (((int)(Math.random() * 2)) >= 1 ? new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, getRandomNumber(9.0f, 15.0f), SpecialEffectID.NONE, 1) : new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, getRandomNumber(14.8f, 23.0f), SpecialEffectID.NONE, 1)));
				int numberOfItems = getRandomNumber(2.0f, 10.0f);
				for(int k = 0; k < numberOfItems; ++k) {
					int whichItem = (int)(Math.random() * 10) + 1;
					if(whichItem >= 7) {
						int quantity = (int)(Math.random() * 6 + 1);
						Titanium titanium = new Titanium(ItemID.TITANIUM, "Titanium", 5.0f, 7.0f, 2.0f, quantity);
						necromancers[j].setInventorySlots(-1, k, titanium);
					} else if(whichItem >= 4) {
						int quantity = (int)(Math.random() * 9 + 1);
						Steel steel = new Steel(ItemID.STEEL, "Steel", 3.0f, 5.0f, 1.0f, quantity);
						necromancers[j].setInventorySlots(-1, k, steel);
					} else if(whichItem >= 3) {
						int defense = getRandomNumber(9.0f, 15.0f);
						SteelArmor steelArmor = new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, defense, SpecialEffectID.NONE, 1);
						necromancers[j].setInventorySlots(-1, k, steelArmor);
					} else if(whichItem >= 2) {
						int defense = getRandomNumber(14.8f, 23.0f);
						TitaniumArmor titaniumArmor = new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, defense, SpecialEffectID.NONE, 1);
						necromancers[j].setInventorySlots(-1, k, titaniumArmor);
					} else if(whichItem >= 1) {
						int damage = getRandomNumber(4.0f, 7.0f);
						Dagger dagger = new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, damage, SpecialEffectID.NONE, 1);
						necromancers[j].setInventorySlots(-1, k, dagger);
					} else {
						int damage = getRandomNumber(10.7f, 13.5f);
						Greatsword greatsword = new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, damage, SpecialEffectID.NONE, 1);
						necromancers[j].setInventorySlots(-1, k, greatsword);
					}
				}
				necromancers[j].setCurrency(getRandomNumber(4.0f, 20.0f));
				sinisters[sinistersIndex++] = necromancers[j];
			}
			for(int j = 0; j < ancients.length; ++j) {
				ancients[j] = Ancient.createNewAncient(sinistersNamesList.get((int)(Math.random() *  sinistersNamesList.size())), sinistersTitlesList.get((int)(Math.random() *  sinistersTitlesList.size())));
				ancients[j].setWeaponSlots(-1, 0, (((int)(Math.random())) >= 1 ? new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, getRandomNumber(4.0f, 7.0f), SpecialEffectID.NONE, 1) : new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, getRandomNumber(10.7f, 13.5f), SpecialEffectID.NONE, 1)));
				ancients[j].setArmorSlots(-1, 0, (((int)(Math.random())) >= 1 ? new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, getRandomNumber(9.0f, 15.0f), SpecialEffectID.NONE, 1) : new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, getRandomNumber(14.8f, 23.0f), SpecialEffectID.NONE, 1)));
				int numberOfItems = getRandomNumber(2.0f, 10.0f);
				for(int k = 0; k < numberOfItems; ++k) {
					int whichItem = (int)(Math.random() * 10) + 1;
					if(whichItem >= 7) {
						int quantity = (int)(Math.random() * 6 + 1);
						Titanium titanium = new Titanium(ItemID.TITANIUM, "Titanium", 5.0f, 7.0f, 2.0f, quantity);
						ancients[j].setInventorySlots(-1, k, titanium);
					} else if(whichItem >= 4) {
						int quantity = (int)(Math.random() * 9 + 1);
						Steel steel = new Steel(ItemID.STEEL, "Steel", 3.0f, 5.0f, 1.0f, quantity);
						ancients[j].setInventorySlots(-1, k, steel);
					} else if(whichItem >= 3) {
						int defense = getRandomNumber(9.0f, 15.0f);
						SteelArmor steelArmor = new SteelArmor(ItemID.STEEL_ARMOR, "Steel Armor", 9.5f, 14.0f, 3.5f, defense, SpecialEffectID.NONE, 1);
						ancients[j].setInventorySlots(-1, k, steelArmor);
					} else if(whichItem >= 2) {
						int defense = getRandomNumber(14.8f, 23.0f);
						TitaniumArmor titaniumArmor = new TitaniumArmor(ItemID.TITANIUM_ARMOR, "Titanium Armor", 27.3f, 33.9f, 5.7f, defense, SpecialEffectID.NONE, 1);
						ancients[j].setInventorySlots(-1, k, titaniumArmor);
					} else if(whichItem >= 1) {
						int damage = getRandomNumber(4.0f, 7.0f);
						Dagger dagger = new Dagger(ItemID.DAGGER, "Dagger", 6.7f, 17.0f, 3.5f, damage, SpecialEffectID.NONE, 1);
						ancients[j].setInventorySlots(-1, k, dagger);
					} else {
						int damage = getRandomNumber(10.7f, 13.5f);
						Greatsword greatsword = new Greatsword(ItemID.GREATSWORD, "Greatsword", 21.5f, 47.9f, 5.7f, damage, SpecialEffectID.NONE, 1);
						ancients[j].setInventorySlots(-1, k, greatsword);
					}
				}
				ancients[j].setCurrency(getRandomNumber(8.0f, 40.0f));
				sinisters[sinistersIndex++] = ancients[j];
			}
			map[i].setTerrainPopulationSinisters(sinisters);
		}
	}
	
	private void generateActorNamesAndTitles() {
		try {
			BufferedReader bufferedReader;
			
			File sinistersNames = new File("src//Resources//NamesSinisters.txt");
			File nobelsNames = new File("src//Resources//NamesNobels.txt");
			File sinistersTitles = new File("src//Resources//TitlesSinisters.txt");
			File nobelsTitles = new File("src//Resources//TitlesNobels.txt");
			
			String line;
			
			bufferedReader = new BufferedReader(new FileReader(sinistersNames));
			while((line = bufferedReader.readLine()) != null) {
				sinistersNamesList.add(line);
			}
			bufferedReader.close();
			bufferedReader = new BufferedReader(new FileReader(nobelsNames));
			while((line = bufferedReader.readLine()) != null) {
				nobelsNamesList.add(line);
			}
			bufferedReader.close();
			bufferedReader = new BufferedReader(new FileReader(sinistersTitles));
			while((line = bufferedReader.readLine()) != null) {
				sinistersTitlesList.add(line);
			}
			bufferedReader.close();
			bufferedReader = new BufferedReader(new FileReader(nobelsTitles));
			while((line = bufferedReader.readLine()) != null) {
				nobelsTitlesList.add(line);
			}
			bufferedReader.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void craftingSteelArmorUtilities() {
		Tooltip tooltipCraftSteelArmor = new Tooltip("Ingredients needed:\n\t" + CraftingRecipes.STEEL_ARMOR.material.label + " x" + CraftingRecipes.STEEL_ARMOR.neededMaterialCount);
		tooltipCraftSteelArmor.setShowDelay(Duration.seconds(0.2));
		tooltipCraftSteelArmor.setShowDuration(Duration.INDEFINITE);
		craftSteelArmorLabel.setTooltip(tooltipCraftSteelArmor);
		craftSteelArmorButton.setOnAction(e -> {
			if(me.getCurrentTerrain() == me.getInitialTerrain()) {
				SteelArmor steelArmor = SteelArmor.craft(me);
				if(steelArmor != null) {
					inventorySlotsListView.getItems().add(steelArmor);
				}
			}
		});
	}
	
	private void craftingTitaniumArmorUtilities() {
		Tooltip tooltipCraftTitaniumArmor = new Tooltip("Ingredients needed:\n\t" + CraftingRecipes.TITANIUM_ARMOR.material.label + " x" + CraftingRecipes.TITANIUM_ARMOR.neededMaterialCount);
		tooltipCraftTitaniumArmor.setShowDelay(Duration.seconds(0.2));
		tooltipCraftTitaniumArmor.setShowDuration(Duration.INDEFINITE);
		craftTitaniumArmorLabel.setTooltip(tooltipCraftTitaniumArmor);
		craftTitaniumArmorButton.setOnAction(e -> {
			if(me.getCurrentTerrain() == me.getInitialTerrain()) {
				TitaniumArmor titaniumArmor = TitaniumArmor.craft(me);
				if(titaniumArmor != null) {
					inventorySlotsListView.getItems().add(titaniumArmor);
				}
			}
		});
	}
	
	private void craftingDaggerUtilities() {
		Tooltip tooltipCraftDagger = new Tooltip("Ingredients needed:\n\t" + CraftingRecipes.DAGGER.material.label + " x" + CraftingRecipes.DAGGER.neededMaterialCount);
		tooltipCraftDagger.setShowDelay(Duration.seconds(0.2));
		tooltipCraftDagger.setShowDuration(Duration.INDEFINITE);
		craftDaggerLabel.setTooltip(tooltipCraftDagger);
		craftDaggerButton.setOnAction(e -> {
			if(me.getCurrentTerrain() == me.getInitialTerrain()) {
				Dagger dagger = Dagger.craft(me);
				if(dagger != null) {
					inventorySlotsListView.getItems().add(dagger);
				}
			}
		});
	}
	
	private void craftingGreatswordUtilities() {
		Tooltip tooltipCraftGreatsword = new Tooltip("Ingredients needed:\n\t" + CraftingRecipes.GREATSWORD.material.label + " x" + CraftingRecipes.GREATSWORD.neededMaterialCount);
		tooltipCraftGreatsword.setShowDelay(Duration.seconds(0.2));
		tooltipCraftGreatsword.setShowDuration(Duration.INDEFINITE);
		craftGreatswordLabel.setTooltip(tooltipCraftGreatsword);
		craftGreatswordButton.setOnAction(e -> {
			if(me.getCurrentTerrain() == me.getInitialTerrain()) {
				Greatsword greatsword = Greatsword.craft(me);
				if(greatsword != null) {
					inventorySlotsListView.getItems().add(greatsword);
				}
			}
		});
	}
	
	private void updateLabelStength() {
		labelStrength.setText(Float.toString(me.getStrengthPoints()));
	}
	
	private void updateLabelIntelligence() {
		labelIntelligence.setText(Float.toString(me.getIntelligencePoints()));
	}
	
	private void updateLabelDextirity() {
		labelDextirity.setText(Float.toString(me.getDextirityPoints()));
	}
	
	private void updateLabelHealth() {
		labelHealth.setText(Float.toString(me.getHealthPoints()));
	}
	
	private void updateLabelCurrency() {
		labelCurrency.setText(Float.toString(me.getCurrency()));
	}
	
	public int getRandomNumber(float min, float max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	public ListView<Item> getInventoryListView() {
		return inventorySlotsListView;
	}
	
	public void restartGame(ActionEvent e) {
		try {
		Stage confirmRestartStage = new Stage();
		FXMLLoader confirmRestartFXMLLoader = new FXMLLoader(getClass().getResource("ConfirmRestartFXML.fxml"));
		Parent rootConfirmRestart = confirmRestartFXMLLoader.load();
		Scene sceneConfirmRestart = new Scene(rootConfirmRestart);
		confirmRestartStage.setScene(sceneConfirmRestart);
		confirmRestartStage.initModality(Modality.APPLICATION_MODAL);
		confirmRestartStage.setResizable(false);
		
		confirmRestartStage.setTitle(Main.title);
		confirmRestartStage.getIcons().add(Main.icon);
		
		confirmRestartStage.show();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void howToPlay(ActionEvent e) {
		try {
			Stage stageHowToPlay = new Stage();
			Parent rootHowToPlay = FXMLLoader.load(getClass().getResource("HowToPlayFXML.fxml"));
			Scene sceneHowToPlay = new Scene(rootHowToPlay);
			stageHowToPlay.setScene(sceneHowToPlay);
			stageHowToPlay.setResizable(false);
			
			stageHowToPlay.setTitle(Main.title);
			stageHowToPlay.getIcons().add(Main.icon);
			
			stageHowToPlay.show();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void toDo(ActionEvent e) {
		try {
			Stage stageToDo = new Stage();
			Parent rootToDo = FXMLLoader.load(getClass().getResource("ToDoFXML.fxml"));
			Scene sceneToDo = new Scene(rootToDo);
			stageToDo.setScene(sceneToDo);
			stageToDo.setResizable(false);
			
			stageToDo.setTitle(Main.title);
			stageToDo.getIcons().add(Main.icon);
			
			stageToDo.show();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void endGame() {
		splitPane.setDisable(true);
	}
	
}
