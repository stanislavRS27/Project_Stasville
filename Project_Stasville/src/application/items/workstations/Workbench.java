package application.items.workstations;

import application.items.ItemID;

public class Workbench extends Workstation{
	
	private Workbench(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
	}
	
	public static Workbench createWorkbench(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		return new Workbench(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
	}
	
}
