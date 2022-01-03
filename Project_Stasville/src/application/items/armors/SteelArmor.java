package application.items.armors;

import application.actors.Player;

import application.items.CraftingRecipes;
import application.items.ItemID;
import application.items.SpecialEffectID;

public class SteelArmor extends Armor{
	
	public SteelArmor(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, float defenseValue, SpecialEffectID specialEffectID, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, defenseValue, specialEffectID, itemStack);
	}

	public SteelArmor(SteelArmor steelArmor) {
		super(steelArmor.getItemID(), steelArmor.getName(), steelArmor.getSellCost(), steelArmor.getBuyCost(), steelArmor.getRarityLevel(), steelArmor.getDefenseValue(), steelArmor.getSpecialEffectID(), steelArmor.getItemStack());
	}
	
	public static SteelArmor craft(Player player) {
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
				if((player.getInventorySlots()[i] != null) && (player.getInventorySlots()[i].getItemID().id == CraftingRecipes.STEEL_ARMOR.material.id) && (player.getInventorySlots()[i].getItemStack() >= CraftingRecipes.STEEL_ARMOR.neededMaterialCount)) {
					player.getInventorySlots()[i].setItemStack(player.getInventorySlots()[i].getItemStack() - CraftingRecipes.STEEL_ARMOR.neededMaterialCount);
					SteelArmor steelArmor = fastCreate();
					player.setInventorySlots(-1, freeIndex, steelArmor);
					return steelArmor;
				}
			}
		}
		return null;
	}
	
	public static SteelArmor fastCreate() {
		return new SteelArmor(ItemID.STEEL_ARMOR, ItemID.STEEL_ARMOR.label, 0.0f, 0.0f, 0.0f, (float) ((Math.random() * (70.0f - 5.0f)) + 5.0f), SpecialEffectID.NONE, 1);
	}
	
}
