package application.actors.sinisters;

import application.actors.Actor;
import application.actors.ActorID;
import application.actors.NPCDefaultStats;

public class Necromancer extends Actor{

	public Necromancer(String name, String title, String allegiance, float strengthPoints, float intelligencePoints, float dextirityPoints, float healthPoints, ActorID actorID) {
		super(name, title, allegiance, strengthPoints, intelligencePoints, dextirityPoints, healthPoints, actorID);
	}
	
	public Necromancer(Necromancer necromancer) {
		super(necromancer.getName(), necromancer.getTitle(), necromancer.getAllegiance(), necromancer.getStrengthPoints(), necromancer.getIntelligencePoints(), necromancer.getDextirityPoints(), necromancer.getHealthPoints(), necromancer.getActorID());
	}
	
	public static Necromancer createNewNecromancer(String name, String title) {
		return new Necromancer(name, title, Actor.allegianceSinister, NPCDefaultStats.NECROMANCER_DEFAULT_INITIAL_STRENGTH_POINTS.value, NPCDefaultStats.NECROMANCER_DEFAULT_INITIAL_INTELLIGENCE_POINTS.value, NPCDefaultStats.NECROMANCER_DEFAULT_INITIAL_DEXTIRITY_POINTS.value, NPCDefaultStats.NECROMANCER_DEFAULT_INITIAL_HEALTH_POINTS.value, ActorID.NECROMANCER);
	}
	
}
