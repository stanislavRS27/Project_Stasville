package application.items.weapons;

import application.items.Item;
import application.items.ItemID;
import application.items.SpecialEffectID;

public abstract class Weapon extends Item{
	
	private float damageValue;
	private SpecialEffectID specialEffectID;
	
	public Weapon(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, float damageValue, SpecialEffectID specialEffectID, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
		this.damageValue = damageValue;
		this.specialEffectID = specialEffectID;
	}
	
	public Weapon(Weapon weapon) {
		super(weapon.getItemID(), weapon.getName(), weapon.getSellCost(), weapon.getBuyCost(), weapon.getRarityLevel(), weapon.getItemStack());
		this.damageValue = weapon.damageValue;
		this.specialEffectID = weapon.specialEffectID;
	}
	
	public float getDamageValue() {
		return damageValue;
	}
	
	public void setDamageValue(float newDamageValue) {
		damageValue = newDamageValue;
	}
	
	public SpecialEffectID getSpecialEffectID() {
		return specialEffectID;
	}
	
	public void setSpecialEffectID(SpecialEffectID newSpecialEffect) {
		specialEffectID = newSpecialEffect;
	}
	
}
