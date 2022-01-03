package application.actors.nobels;

import application.actors.Actor;
import application.actors.ActorID;
import application.actors.NPCDefaultStats;

public class Priest extends Actor{

	public Priest(String name, String title, String allegiance, float strengthPoints, float intelligencePoints, float dextirityPoints, float healthPoints, ActorID actorID) {
		super(name, title, allegiance, strengthPoints, intelligencePoints, dextirityPoints, healthPoints, actorID);
	}
	
	public Priest(Priest priest) {
		super(priest.getName(), priest.getTitle(), priest.getAllegiance(), priest.getStrengthPoints(), priest.getIntelligencePoints(), priest.getDextirityPoints(), priest.getHealthPoints(), priest.getActorID());
	}
	
	public static Priest createNewPriest(String name, String title) {
		return new Priest(name, title, Actor.allegianceNobel, NPCDefaultStats.PRIEST_DEFAULT_INITIAL_STRENGTH_POINTS.value, NPCDefaultStats.PRIEST_DEFAULT_INITIAL_INTELLIGENCE_POINTS.value, NPCDefaultStats.PRIEST_DEFAULT_INITIAL_DEXTIRITY_POINTS.value, NPCDefaultStats.PRIEST_DEFAULT_INITIAL_HEALTH_POINTS.value, ActorID.PRIEST);
	}
	
}
