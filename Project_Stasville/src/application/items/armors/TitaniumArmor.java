package application.items.armors;

import application.actors.Player;

import application.items.CraftingRecipes;
import application.items.ItemID;
import application.items.SpecialEffectID;

public class TitaniumArmor extends Armor{

	public TitaniumArmor(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel,
			float defenseValue, SpecialEffectID specialEffectID, int itemStack) {
		super(itemID, name, sellCost, buyCost, rarityLevel, defenseValue, specialEffectID, itemStack);
	}

	public TitaniumArmor(TitaniumArmor titaniumArmor) {
		super(titaniumArmor.getItemID(), titaniumArmor.getName(), titaniumArmor.getSellCost(), titaniumArmor.getBuyCost(), titaniumArmor.getRarityLevel(), titaniumArmor.getDefenseValue(), titaniumArmor.getSpecialEffectID(), titaniumArmor.getItemStack());
	}
	
	public static TitaniumArmor craft(Player player) {
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
				if((player.getInventorySlots()[i] != null) && (player.getInventorySlots()[i].getItemID().id == CraftingRecipes.TITANIUM_ARMOR.material.id) && (player.getInventorySlots()[i].getItemStack() >= CraftingRecipes.TITANIUM_ARMOR.neededMaterialCount)) {
					player.getInventorySlots()[i].setItemStack(player.getInventorySlots()[i].getItemStack() - CraftingRecipes.TITANIUM_ARMOR.neededMaterialCount);
					TitaniumArmor titaniumArmor =  fastCreate();
					player.setInventorySlots(-1, freeIndex, titaniumArmor);
					return titaniumArmor;
				}
			}
		}
		return null;
	}
	
	public static TitaniumArmor fastCreate() {
		return new TitaniumArmor(ItemID.TITANIUM_ARMOR, ItemID.TITANIUM_ARMOR.label, 0.0f, 0.0f, 0.0f, (float) ((Math.random() * (99.9f - 20.0f)) + 20.0f), SpecialEffectID.NONE, 1);
	}
	
}
