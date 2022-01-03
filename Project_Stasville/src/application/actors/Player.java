package application.actors;

import application.LootSceneController;
import application.Main;
import application.map.PlayerHome;
import application.map.Terrain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Player extends Actor{
	
	private final PlayerHome playerHome;
	private final Terrain initialTerrain;

	private Player(String name, String title, String allegiance, float strengthPoints, float intelligencePoints, float dextirityPoints, float healthPoints, ActorID actorType, Terrain initialTerrain, PlayerHome playerHome) {
		super(name, title, allegiance, strengthPoints, intelligencePoints, dextirityPoints, healthPoints, actorType);
		this.initialTerrain = initialTerrain;
		setCurrentTerrain(initialTerrain);
		this.playerHome = playerHome;
	}
	
	public static Player createNewPlayer(String name, String allegiance, Terrain initialRerrain, PlayerHome playerHome) {
		return new Player(name, "Player", allegiance, 1.0f, 1.0f, 1.0f, 10.0f, ActorID.PLAYER, initialRerrain, playerHome);
	}

	public Terrain getInitialTerrain() {
		return initialTerrain;
	}
	
	public PlayerHome getPlayerHome() {
		return playerHome;
	}
	
	public void move(Terrain terrain) {
		this.setCurrentTerrain(terrain);
	}
	
	public void loot (Actor actor) {
		try {
			Stage lootStage = new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/LootFXML.fxml"));
			Parent rootLoot = loader.load();
			
			LootSceneController lsc = loader.getController();
			lsc.setLootListView(actor);
			
			Scene sceneLoot = new Scene(rootLoot);
			lootStage.setScene(sceneLoot);
			lootStage.setResizable(false);
			lootStage.setAlwaysOnTop(true);
			
			//lootStage.setTitle(Main.title);
			lootStage.getIcons().add(Main.icon);
			
			lootStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		setCurrency(getCurrency() + actor.getCurrency());
	}
	
}
