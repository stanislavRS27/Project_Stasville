package application.items.workstations;

import application.items.Item;
import application.items.ItemID;

public abstract class Workstation extends Item{

	public Workstation(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
	}
	
	public Workstation(Workstation workstation) {
		super(workstation.getItemID(), workstation.getName(), workstation.getSellCost(), workstation.getBuyCost(), workstation.getRarityLevel(), workstation.getItemStack());
	}
	
}
