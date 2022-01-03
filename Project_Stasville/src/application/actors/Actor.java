package application.actors;

import application.items.Item;

import application.items.SpecialEffectID;
import application.items.armors.Armor;
import application.items.weapons.Weapon;

import application.Main;
import application.map.Terrain;

public abstract class Actor implements CombatMechanics{
	
	private String name;
	private String title;
	private String allegiance;
	//---------------------------------------------------------
	public final static String allegianceSinister = "Sinister";
	public final static String allegianceNobel = "Nobel";
	//---------------------------------------------------------
	private float strengthPoints;
	private float intelligencePoints;
	private float dextirityPoints;
	private float healthPoints;
	private ActorID actorID;
	
	private float currency = 0;
	
	private Terrain currentTerrain;
	
	private final int INITIAL_PLAYER_INVENTORY_SLOTS = 5;
	private final int INITIAL_PLAYER_WEAPON_SLOTS = 1;
	private final int INITIAL_PLAYER_ARMOR_SLOTS = 1;
	
	private final int INITIAL_NPC_INVENTORY_SLOTS = 10;
	private final int INITIAL_NPC_WEAPON_SLOTS = 1;
	private final int INITIAL_NPC_ARMOR_SLOTS = 1;
	
	private Item[] inventorySlots;
	private Weapon[] weaponSlots;
	private Armor[] armorSlots;
	
	public Actor(String name, String title, String allegiance, float strengthPoints, float intelligencePoints, float dextirityPoints, float healthPoints, ActorID actorID) {
		this.name = name;
		this.title = title;
		this.allegiance = allegiance;
		this.strengthPoints = strengthPoints;
		this.intelligencePoints = intelligencePoints;
		this.dextirityPoints = dextirityPoints;
		this.healthPoints = healthPoints;
		this.actorID = actorID;
		if(actorID == ActorID.PLAYER) {
			inventorySlots = new Item[INITIAL_PLAYER_INVENTORY_SLOTS];
			weaponSlots = new Weapon[INITIAL_PLAYER_WEAPON_SLOTS];
			armorSlots = new Armor[INITIAL_PLAYER_ARMOR_SLOTS];
		} else {
			inventorySlots = new Item[INITIAL_NPC_INVENTORY_SLOTS];
			weaponSlots = new Weapon[INITIAL_NPC_WEAPON_SLOTS];
			armorSlots = new Armor[INITIAL_NPC_ARMOR_SLOTS];
		}
	}
	
	public Actor(Actor actor) {
		this.name = actor.name;
		this.title = actor.title;
		this.allegiance = actor.allegiance;
		this.strengthPoints = actor.strengthPoints;
		this.intelligencePoints = actor.intelligencePoints;
		this.dextirityPoints = actor.dextirityPoints;
		this.healthPoints = actor.healthPoints;
		this.actorID = actor.actorID;
		if(actorID == ActorID.PLAYER) {
			inventorySlots = new Item[INITIAL_PLAYER_INVENTORY_SLOTS];
			weaponSlots = new Weapon[INITIAL_PLAYER_WEAPON_SLOTS];
			armorSlots = new Armor[INITIAL_PLAYER_ARMOR_SLOTS];
		} else {
			inventorySlots = new Item[INITIAL_NPC_INVENTORY_SLOTS];
			weaponSlots = new Weapon[INITIAL_NPC_WEAPON_SLOTS];
			armorSlots = new Armor[INITIAL_NPC_ARMOR_SLOTS];
		}
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAllegiance(String newAllegiance) {
		allegiance = newAllegiance;
	}
	
	public String getAllegiance() {
		return allegiance;
	}
	
	public void setStrengthPoints(float newStrengthPoints) {
		strengthPoints = newStrengthPoints;
	}
	
	public float getStrengthPoints() {
		return strengthPoints;
	}
	
	public void setIntelligencePoints(float newIntelligencePoints) {
		intelligencePoints = newIntelligencePoints;
	}
	
	public float getIntelligencePoints() {
		return intelligencePoints;
	}
	
	public void setDextirityPoints(float newDextirityPoints) {
		dextirityPoints = newDextirityPoints;
	}
	
	public float getDextirityPoints() {
		return dextirityPoints;
	}
	
	public void setHealthPoints(float newHealthPoints) {
		healthPoints = newHealthPoints;
	}
	
	public float getHealthPoints() {
		return healthPoints;
	}
	
	public ActorID getActorID() {
		return actorID;
	}
	
	public int getInventoryLength() {
		return inventorySlots.length;
	}
	
	public Item[] getInventorySlots() {
		return inventorySlots;
	}
	
	public void setInventorySlots(int inventorySlotsSize, int indexOfChangedSlot, Item newItem) {
		try {
			if(indexOfChangedSlot == -1) {
				if(inventorySlotsSize == -1) {
					return;
				}
				Item[] temp = new Item[inventorySlotsSize];
				for(int i = 0; i < inventorySlotsSize; ++i) {
					if(i < inventorySlots.length) {
						temp[i] = inventorySlots[i];
					}
				}
				inventorySlots = temp;
			} else if(inventorySlotsSize == -1) {
				inventorySlots[indexOfChangedSlot] = newItem;
			} else {
				Item[] temp = new Item[inventorySlotsSize];
				for(int i = 0; i < inventorySlotsSize; ++i) {
					if(i >= inventorySlots.length) {
						temp[i] = null;
						continue;
					}
					temp[i] = inventorySlots[i];
				}
				inventorySlots = temp;
				inventorySlots[indexOfChangedSlot] = newItem;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nope, Inventory");
		}
	}
	
	public int getArmorSlotsLength() {
		return armorSlots.length;
	}
	
	public int getWeaponSlotsLength() {
		return weaponSlots.length;
	}
	
	public Armor[] getArmorSlots() {
		return armorSlots;
	}
	
	public Weapon[] getWeaponSlots() {
		return weaponSlots;
	}
	
	public void setArmorSlots(int slotsSize, int indexOfChangedSlot, Armor newArmor) {
		try {
			if (indexOfChangedSlot == -1) {
				Armor[] temp = new Armor[slotsSize];
				for (int i = 0; i < slotsSize; ++i) {
					if (i >= armorSlots.length) {
						temp[i] = null;
						continue;
					}
					temp[i] = armorSlots[i];
				}
				armorSlots = temp;
				temp = null;
			} else if (slotsSize == -1) {
				armorSlots[indexOfChangedSlot] = newArmor;
			} else {
				Armor[] temp = new Armor[slotsSize];
				for (int i = 0; i < slotsSize; ++i) {
					if (i >= armorSlots.length) {
						temp[i] = null;
						continue;
					}
					temp[i] = armorSlots[i];
				}
				armorSlots = temp;
				temp = null;
				armorSlots[indexOfChangedSlot] = newArmor;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nope, Armor");
		}
	}
	
	public void setWeaponSlots(int slotsSize, int indexOfChangedSlot, Weapon newWeapon) {
		try {
			if(indexOfChangedSlot == -1) {
				Weapon[] temp = new Weapon[slotsSize];
				for(int i = 0; i < slotsSize; ++i) {
					if(i >= weaponSlots.length) {
						temp[i] = null;
						continue;
					}
					temp[i] = weaponSlots[i];
				}
				weaponSlots = temp;
				temp = null;
			} else if(slotsSize == -1) {
				weaponSlots[indexOfChangedSlot] = newWeapon;
			} else {
				Weapon[] temp = new Weapon[slotsSize];
				for(int i = 0; i < slotsSize; ++i) {
					if(i >= weaponSlots.length) {
						temp[i] = null;
						continue;
					}
					temp[i] = weaponSlots[i];
				}
				weaponSlots = temp;
				temp = null;
				weaponSlots[indexOfChangedSlot] = newWeapon;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nope, Weapon");
		}
	}
	
	public float getCurrency() {
		return currency;
	}
	
	public void setCurrency(float newCurrency) {
		currency = newCurrency;
	}
	
	public String displayActorInformation() {
		String actorInformation = "";
		actorInformation += "Type: " + actorID.label + "\n";
		actorInformation += "Name: " + name + "\n";
		actorInformation += "Title: " + title + "\n";
		actorInformation += "Allegiance: " + allegiance + "\n";
		actorInformation += "Strength points: " + strengthPoints + "\n";
		actorInformation += "Intelligence points: " + intelligencePoints + "\n";
		actorInformation += "Dextirity points: " + dextirityPoints + "\n";
		actorInformation += "Health points: " + healthPoints + "\n";
		actorInformation += "Armor: ";
		for(int i = 0; i < armorSlots.length; ++i) {
			actorInformation += (armorSlots[i] != null ? armorSlots[i].getName() : "empty") + " | ";
		}
		actorInformation += "\nWeapon: ";
		for(int i = 0; i < weaponSlots.length; ++i) {
			actorInformation += (weaponSlots[i] != null ? weaponSlots[i].getName() : "empty") + " | ";
		}
		actorInformation += "\nInventory: ";
		for(int i = 0; i < inventorySlots.length; ++i) {
			actorInformation += (inventorySlots[i] != null ? inventorySlots[i].getName() : "empty") + " | ";
		}
		actorInformation += "\nCurrency: " + currency;
		return actorInformation;
	}
	
	// TODO Auto-generated method stub
	public void attack(Actor defender) {
		if(getAllegiance() != defender.getAllegiance()) {
			float finalDamage;
			
			//some basic formula for damage calculation
			float damageFromWeapon = getWeaponSlots()[0] != null ? getWeaponSlots()[0].getDamageValue() : 0.0f;
			float strengthFactorAttacker = getStrengthPoints();
			//float dextirityFactorAttacker = getDextirityPoints();
			float intelligenceFactorAttacker = getIntelligencePoints();
			float damageFromArmor = getArmorSlots()[0] != null ? (getArmorSlots()[0].getSpecialEffectID() == SpecialEffectID.WRATH_OF_THE_ELIN ? 50.0f : 0.0f) : 0.0f;
			
			float defenseFromArmor = defender.getArmorSlots()[0] != null ? (defender.getArmorSlots()[0]).getDefenseValue() : 0.0f;
			//float strengthFactorDefender = defender.getStrengthPoints();
			float dextirityFactorDefender = defender.getDextirityPoints();
			float intelligenceFactorDefender = defender.getIntelligencePoints();
			
			float attackerDamage = damageFromWeapon * (strengthFactorAttacker + intelligenceFactorAttacker) + damageFromArmor;
			float defenderDefense = defenseFromArmor * (dextirityFactorDefender + intelligenceFactorDefender);
			
			finalDamage = attackerDamage > defenderDefense ? attackerDamage - defenderDefense : 0;

			defender.setHealthPoints(defender.getHealthPoints() - finalDamage);
			
			if(Float.compare(defender.getHealthPoints(), 0.0f) <= 0) {
				if(defender.actorID == ActorID.PLAYER) {
					Main.endGame();
				} else {
					((Player)this).loot(defender);
					
					if(defender.getAllegiance().equals(Actor.allegianceSinister)) {
						Actor[] newTerrainPopulationSinisters = new Actor[currentTerrain.getTerrainPopulationSinisters().length - 1];
						for(int i = 0, j = 0; i < currentTerrain.getTerrainPopulationSinisters().length; ++i) {
							if(currentTerrain.getTerrainPopulationSinisters()[i] == defender) {
								continue;
							}
							newTerrainPopulationSinisters[j++] = currentTerrain.getTerrainPopulationSinisters()[i];
						}
						currentTerrain.setTerrainPopulationSinisters(newTerrainPopulationSinisters);
					} else {
						Actor[] newTerrainPopulationNobels = new Actor[currentTerrain.getTerrainPopulationNobels().length - 1];
						for(int i = 0, j = 0; i < currentTerrain.getTerrainPopulationNobels().length; ++i) {
							if(currentTerrain.getTerrainPopulationNobels()[i] == defender) {
								continue;
							}
							newTerrainPopulationNobels[j++] = currentTerrain.getTerrainPopulationNobels()[i];
						}
						currentTerrain.setTerrainPopulationNobels(newTerrainPopulationNobels);
					}
				}
			} else {
				if(defender.getActorID() != ActorID.PLAYER) {
					defender.attack((Player) this);
				}
			}
		}
	}
	
	public Terrain getCurrentTerrain() {
		return currentTerrain;
	}
	
	public void setCurrentTerrain(Terrain terrain) {
		currentTerrain = terrain;
	}
	
}
