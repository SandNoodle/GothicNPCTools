package npctools.npc.inventory;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> inventory;
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public void addItem(Item i) {
		if(!inventory.contains(i)){
			inventory.add(i);
		}
		
		/* else {
			// ??? TEST
			if(inventory.get(inventory.indexOf(i)).getQuantity() != i.getQuantity()){
				inventory.set(inventory.indexOf(i), i);
			}
		}
		*/
	}
	
	public void removeItem(Item i) {
		if(inventory.contains(i)){
			inventory.remove(i);
		}
	}
	
	public void removeByIndex(int index) {
		if(inventory.size() > index) {
			inventory.remove(index);
		}
	}
	
}
