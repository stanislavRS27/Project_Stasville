package application.items;

import application.items.Item;

public abstract class Item {
	
	private ItemID itemID;
	private String name;
	private float sellCost;
	private float buyCost;
	private float rarityLevel;
	private int itemStack;
	
	public Item(ItemID itemID, String name, float sellCost, float buyCost, float rarityLevel, int itemStack) {
		this.itemID = itemID;
		this.name = name;
		this.sellCost = sellCost;
		this.buyCost = buyCost;
		this.rarityLevel = rarityLevel;
		this.itemStack = itemStack;
	}
	
	public ItemID getItemID() {
		return itemID;
	}
	
	public void setItemID(ItemID itemID) {
		this.itemID = itemID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getSellCost() {
		return sellCost;
	}
	
	public void setSellCost(float sellCost) {
		this.sellCost = sellCost;
	}
	
	public float getBuyCost() {
		return buyCost;
	}
	
	public void setBuyCost(float buyCost) {
		this.buyCost = buyCost;
	}
	
	public float getRarityLevel() {
		return rarityLevel;
	}
	
	public void setRarityLevel(float rarityLevel) {
		this.rarityLevel = rarityLevel;
	}
	
	public int getItemStack() {
		return itemStack;
	}
	
	public void setItemStack(int itemStack) {
		this.itemStack = itemStack;
	}
	
	public String displayItemInformation() {
		String information = "";
		information += "Item type: " + itemID.label + "\n";
		information += "Name: " + name + "\n";
		information += "Sell price: " + sellCost + "\n";
		information += "Buy price: " + buyCost + "\n";
		information += "Rarity level: " + rarityLevel + "\n";
		information += "Stack size: " + itemStack + "\n";
		return information;
	}
	
	// TODO Auto-generated method stub
	public static float calculateSellPrice(Item item) {
		return 0.0f;
	}
	
	// TODO Auto-generated method stub
	public static float calculateBuyPrice(Item item) {
		return 0.0f;
	}
	
	// TODO Auto-generated method stub
	public static float calculateRarityLevel(Item item) {
		return 0.0f;
	}
	
}
