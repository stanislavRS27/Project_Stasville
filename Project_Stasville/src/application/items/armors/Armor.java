package application.items.armors;

import application.items.Item;
import application.items.ItemID;
import application.items.SpecialEffectID;

public abstract class Armor extends Item{
	
	private float defenseValue;
	private SpecialEffectID specialEffectID;
	
	public Armor(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, float defenseValue, SpecialEffectID specialEffectID, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
		this.defenseValue = defenseValue;
		this.specialEffectID = specialEffectID;
	}
	
	public Armor(Armor armor) {
		super(armor.getItemID(), armor.getName(), armor.getSellCost(), armor.getBuyCost(), armor.getRarityLevel(), armor.getItemStack());
		this.defenseValue = armor.defenseValue;
		this.specialEffectID = armor.specialEffectID;
	}
	
	public float getDefenseValue() {
		return defenseValue;
	}
	
	public void setDefenseValue(float newDefenseValue) {
		defenseValue = newDefenseValue;
	}
	
	public SpecialEffectID getSpecialEffectID() {
		return specialEffectID;
	}
	
	public void setSpecialEffectID(SpecialEffectID newSpecialEffectID) {
		specialEffectID = newSpecialEffectID;
	}
	
}
