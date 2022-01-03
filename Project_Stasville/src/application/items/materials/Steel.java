package application.items.materials;

import application.items.ItemID;
import application.items.materials.Steel;

public class Steel extends Material{

	public Steel(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
	}
	
	public Steel(Steel steel) {
		super(steel.getItemID(), steel.getName(), steel.getSellCost(), steel.getBuyCost(), steel.getRarityLevel(), steel.getItemStack());
	}

}
