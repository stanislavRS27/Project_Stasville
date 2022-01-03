package application.items.materials;

import application.items.ItemID;
import application.items.materials.Titanium;

public class Titanium extends Material{
	
	public Titanium(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
	}
	
	public Titanium(Titanium titanium) {
		super(titanium.getItemID(), titanium.getName(), titanium.getSellCost(), titanium.getBuyCost(), titanium.getRarityLevel(), titanium.getItemStack());
	}

}
