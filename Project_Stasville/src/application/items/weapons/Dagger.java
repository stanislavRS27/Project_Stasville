package application.items.weapons;

import application.actors.Player;

import application.items.CraftingRecipes;
import application.items.ItemID;
import application.items.SpecialEffectID;

public class Dagger extends Weapon{
	
	public Dagger(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, float damageValue,
			SpecialEffectID specialEffectID, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, damageValue, specialEffectID, itemStack);
	}
	
	public Dagger(Dagger dagger) {
		super(dagger.getItemID(), dagger.getName(), dagger.getSellCost(), dagger.getBuyCost(), dagger.getRarityLevel(), dagger.getDamageValue(), dagger.getSpecialEffectID(), dagger.getItemStack());
	}
	
	public static Dagger craft(Player player) {
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
				if((player.getInventorySlots()[i] != null) && (player.getInventorySlots()[i].getItemID().id == CraftingRecipes.DAGGER.material.id) && (player.getInventorySlots()[i].getItemStack() >= CraftingRecipes.DAGGER.neededMaterialCount)) {
					player.getInventorySlots()[i].setItemStack(player.getInventorySlots()[i].getItemStack() - CraftingRecipes.DAGGER.neededMaterialCount);
					Dagger dagger = fastCreate();
					player.setInventorySlots(-1, freeIndex, dagger);
					return dagger;
				}
			}
		}
		return null;
	}
	
	public static Dagger fastCreate() {
		return new Dagger(ItemID.DAGGER, ItemID.DAGGER.label, 0.0f, 0.0f, 0.0f, (float) ((Math.random() * (60.0f - 10.0f)) + 10.0f), SpecialEffectID.NONE, 1);
	}
	
}
