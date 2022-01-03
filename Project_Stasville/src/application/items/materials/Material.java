package application.items.materials;

import application.items.Item;
import application.items.ItemID;

public abstract class Material extends Item{

	public Material(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
	}
	
	public Material(Material material) {
		super(material.getItemID(), material.getName(), material.getSellCost(), material.getBuyCost(), material.getRarityLevel(), material.getItemStack());
	}
	
}
