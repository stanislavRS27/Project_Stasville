package application.actors.sinisters;

import application.actors.Actor;
import application.actors.ActorID;
import application.actors.NPCDefaultStats;

public class Demon extends Actor{

	public Demon(String name, String title, String allegiance, float strengthPoints, float intelligencePoints, float dextirityPoints, float healthPoints, ActorID actorID) {
		super(name, title, allegiance, strengthPoints, intelligencePoints, dextirityPoints, healthPoints, actorID);
	}
	
	public Demon(Demon demon) {
		super(demon.getName(), demon.getTitle(), demon.getAllegiance(), demon.getStrengthPoints(), demon.getIntelligencePoints(), demon.getDextirityPoints(), demon.getHealthPoints(), demon.getActorID());
	}
	
	public static Demon createNewDemon(String name, String title) {
		return new Demon(name, title, Actor.allegianceSinister, NPCDefaultStats.DEMON_DEFAULT_INITIAL_STRENGTH_POINTS.value, NPCDefaultStats.DEMON_DEFAULT_INITIAL_INTELLIGENCE_POINTS.value, NPCDefaultStats.DEMON_DEFAULT_INITIAL_DEXTIRITY_POINTS.value, NPCDefaultStats.DEMON_DEFAULT_INITIAL_HEALTH_POINTS.value, ActorID.DEMON);
	}
	
}
