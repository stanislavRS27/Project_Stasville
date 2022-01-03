package application.actors.nobels;

import application.actors.Actor;
import application.actors.ActorID;
import application.actors.NPCDefaultStats;

public class Elite extends Actor{

	public Elite(String name, String title, String allegiance, float strengthPoints, float intelligencePoints, float dextirityPoints, float healthPoints, ActorID actorID) {
		super(name, title, allegiance, strengthPoints, intelligencePoints, dextirityPoints, healthPoints, actorID);
	}
	
	public Elite(Elite elite) {
		super(elite.getName(), elite.getTitle(), elite.getAllegiance(), elite.getStrengthPoints(), elite.getIntelligencePoints(), elite.getDextirityPoints(), elite.getHealthPoints(), elite.getActorID());
	}
	
	public static Elite createNewElite(String name, String title) {
		return new Elite(name, title, Actor.allegianceNobel, NPCDefaultStats.ELITE_DEFAULT_INITIAL_STRENGTH_POINTS.value, NPCDefaultStats.ELITE_DEFAULT_INITIAL_INTELLIGENCE_POINTS.value, NPCDefaultStats.ELITE_DEFAULT_INITIAL_DEXTIRITY_POINTS.value, NPCDefaultStats.ELITE_DEFAULT_INITIAL_HEALTH_POINTS.value, ActorID.ELITE);
	}
	
}
