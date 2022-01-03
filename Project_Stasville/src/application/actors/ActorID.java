package application.actors;

public enum ActorID {
	
	PLAYER(0, "Player"),
	DEMON(1, "Demon"),
	NECROMANCER(2, "Necromancer"),
	ANCIENT(3, "Ancient"),
	GUARDIAN(4, "Guardian"),
	PRIEST(5, "Priest"),
	ELITE(6, "Elite");
	
	public final int id;
	public final String label;
	
	private ActorID(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
}
