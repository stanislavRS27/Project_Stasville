package application.items.workstations;

import application.items.ItemID;

public class Anvil extends Workstation{
	
	private Anvil(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
	}
	
	public static Anvil createAnvil(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		return new Anvil(itemID, name, sellCost, buyCost, rarityLevel, itemStack);
	}
	
}
