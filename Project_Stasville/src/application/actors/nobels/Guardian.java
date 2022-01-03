package application.actors.nobels;

import application.actors.Actor;
import application.actors.ActorID;
import application.actors.NPCDefaultStats;

public class Guardian extends Actor{

	public Guardian(String name, String title, String allegiance, float strengthPoints, float intelligencePoints, float dextirityPoints, float healthPoints, ActorID actorID) {
		super(name, title, allegiance, strengthPoints, intelligencePoints, dextirityPoints, healthPoints, actorID);
	}
	
	public Guardian(Guardian guardian) {
		super(guardian.getName(), guardian.getTitle(), guardian.getAllegiance(), guardian.getStrengthPoints(), guardian.getIntelligencePoints(), guardian.getDextirityPoints(), guardian.getHealthPoints(), guardian.getActorID());
	}
	
	public static Guardian createNewGuardian(String name, String title) {
		return new Guardian(name, title, Actor.allegianceNobel, NPCDefaultStats.GUARDIAN_DEFAULT_INITIAL_STRENGTH_POINTS.value, NPCDefaultStats.GUARDIAN_DEFAULT_INITIAL_INTELLIGENCE_POINTS.value, NPCDefaultStats.GUARDIAN_DEFAULT_INITIAL_DEXTIRITY_POINTS.value, NPCDefaultStats.GUARDIAN_DEFAULT_INITIAL_HEALTH_POINTS.value, ActorID.GUARDIAN);
	}
	
}
