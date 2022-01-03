package application.actors.sinisters;

import application.actors.Actor;
import application.actors.ActorID;
import application.actors.NPCDefaultStats;

public class Ancient extends Actor{

	public Ancient(String name, String title, String allegiance, float strengthPoints, float intelligencePoints, float dextirityPoints, float healthPoints, ActorID actorID) {
		super(name, title, allegiance, strengthPoints, intelligencePoints, dextirityPoints, healthPoints, actorID);
	}
	
	public Ancient(Ancient ancient) {
		super(ancient.getName(), ancient.getTitle(), ancient.getAllegiance(), ancient.getStrengthPoints(), ancient.getIntelligencePoints(), ancient.getDextirityPoints(), ancient.getHealthPoints(), ancient.getActorID());
	}
	
	public static Ancient createNewAncient(String name, String title) {
		return new Ancient(name, title, Actor.allegianceSinister, NPCDefaultStats.ANCIENT_DEFAULT_INITIAL_STRENGTH_POINTS.value, NPCDefaultStats.ANCIENT_DEFAULT_INITIAL_INTELLIGENCE_POINTS.value, NPCDefaultStats.ANCIENT_DEFAULT_INITIAL_DEXTIRITY_POINTS.value, NPCDefaultStats.ANCIENT_DEFAULT_INITIAL_HEALTH_POINTS.value, ActorID.ANCIENT);
	}
	
}
