package npctools.npc.inventory;

import com.google.gson.annotations.SerializedName;

public class Item {
	
	@SerializedName ("ITEM_NAME")
	private final String itemName;
	@SerializedName ("ITEM_QUANTITY")
	private final int itemQuantity;
	
	public Item(String itemName, int itemQuantity) {
		this.itemName = itemName;
		if (itemQuantity > 0) {
			this.itemQuantity = itemQuantity;
		} else {
			this.itemQuantity = 1;
		}
	}
	
	public String getName() {
		return itemName;
	}
	
	public int getQuantity() {
		return itemQuantity;
	}
}
