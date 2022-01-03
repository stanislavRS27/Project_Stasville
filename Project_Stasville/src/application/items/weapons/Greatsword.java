package application.items.weapons;

import application.actors.Player;

import application.items.CraftingRecipes;
import application.items.ItemID;
import application.items.SpecialEffectID;

public class Greatsword extends Weapon{

	public Greatsword(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel,
			float damageValue, SpecialEffectID specialEffectID, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, damageValue, specialEffectID, itemStack);
	}
	
	public Greatsword(Greatsword greatsword) {
		super(greatsword.getItemID(), greatsword.getName(), greatsword.getSellCost(), greatsword.getBuyCost(), greatsword.getRarityLevel(), greatsword.getDamageValue(), greatsword.getSpecialEffectID(), greatsword.getItemStack());
	}
	
	public static Greatsword craft(Player player) {
		if(player.getPlayerHome().getWorkbench() != null) {
			int freeIndex = -1;
			for(int i = 0; i < player.getInventoryLength(); ++i) {
				if(player.getInventorySlots()[i] == null) {
					freeIndex = i;
					break;
				}
			}
			
			if(freeIndex == -1) {
				return null;
			}
			
			for(int i = 0; i < player.getInventoryLength(); ++i) {
				if((player.getInventorySlots()[i] != null) && (player.getInventorySlots()[i].getItemID().id == CraftingRecipes.GREATSWORD.material.id) && (player.getInventorySlots()[i].getItemStack() >= CraftingRecipes.GREATSWORD.neededMaterialCount)) {
					player.getInventorySlots()[i].setItemStack(player.getInventorySlots()[i].getItemStack() - CraftingRecipes.GREATSWORD.neededMaterialCount);
					Greatsword greatsword = fastCreate();
					player.setInventorySlots(-1, freeIndex, greatsword);
					return greatsword;
				}
			}
		}
		return null;
	}
	
	public static Greatsword fastCreate() {
		return new Greatsword(ItemID.GREATSWORD, ItemID.GREATSWORD.label, 0.0f, 0.0f, 0.0f, (float) ((Math.random() * (80.0f - 20.0f)) + 20.0f), SpecialEffectID.NONE, 1);
	}
	
}
