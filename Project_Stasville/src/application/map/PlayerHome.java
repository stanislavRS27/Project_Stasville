package application.map;

import application.items.Item;
import application.items.workstations.Anvil;
import application.items.workstations.Workbench;

public class PlayerHome {
	
	private Workbench workbench;
	private Anvil anvil;
	private Item[] chest;
	
	private PlayerHome() {
	}

	public static PlayerHome createHome() {
		return new PlayerHome();
	}
	
	public void setWorkbench(Workbench workbench) {
		this.workbench = workbench;
	}
	
	public void setAnvil(Anvil anvil) {
		this.anvil = anvil;
	}
	
	public Workbench getWorkbench() {
		return workbench;
	}
	
	public Anvil getAnvil() {
		return anvil;
	}
	
	public Item[] getChest() {
		return chest;
	}
	
	// TODO Auto-generated method stub
	public void setChest(int index, Item item) {
		if(chest[index] == null) {
			chest[index] = item;
		} else {
			System.out.println("Slot is not empty!");
		}
	}
	
}
