package application.items;

public enum ItemID {
	
	STEEL_ARMOR(1, "Steel armor"),
	TITANIUM_ARMOR(2, "Titanium armor"),
	
	DAGGER(3, "Dagger"),
	GREATSWORD(4, "Greatsword"),
	
	STEEL(5, "Steel"),
	TITANIUM(6, "Titanium"),
	
	WORKBENCH(7, "Workbench"),
	ANVIL(8, "Anvil");
	
	public final int id;
	public final String label;
	
	private ItemID(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
}
