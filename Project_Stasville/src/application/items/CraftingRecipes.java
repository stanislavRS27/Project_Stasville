package application.items;

public enum CraftingRecipes {
	
	//armors
	STEEL_ARMOR("Steel armor", ItemID.STEEL, 5, ItemID.WORKBENCH, 1),
	TITANIUM_ARMOR("Titanium armor", ItemID.TITANIUM, 5, ItemID.WORKBENCH, 1),
	//weapons
	GREATSWORD("Greatsword", ItemID.TITANIUM, 3, ItemID.ANVIL, 1),
	DAGGER("Greatsword", ItemID.STEEL, 3, ItemID.ANVIL, 1);
	
	public final String label;
	public final ItemID material;
	public final int neededMaterialCount;
	public final ItemID station;
	public int unlocked;
	
	private CraftingRecipes(String label, ItemID material, int neededMaterialCount, ItemID station, int unlocked) {
		this.label = label;
		this.material = material;
		this.neededMaterialCount = neededMaterialCount;
		this.station = station;
		this.unlocked = unlocked;
	}
	
}
