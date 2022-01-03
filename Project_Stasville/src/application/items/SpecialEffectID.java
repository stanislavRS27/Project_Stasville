package application.items;

public enum SpecialEffectID {
	// TODO Auto-generated method stub
	
	NONE(0, "None"),
	WRATH_OF_THE_ELIN(1, "Wrath of the Elin"),
	MERCY_OF_THE_PELIN(2, "Mercy of the Pelin"),
	FORTUNE_ENGRAVED_RUNES(3, "Fortune engraved runes"),
	DAMAGE_ENHANCEMENT(4, "Damage enchantment"),
	DEFENCE_ENHANCEMENT(5, "Defence enchantment"),
	STASKATA_WANTS_YOU_TO_WIN(6, "How did you get that?");
	
	public final int id;
	public final String label;
	
	private SpecialEffectID(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
}
