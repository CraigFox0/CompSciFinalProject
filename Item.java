import java.time.*;
public class Item {
	String name, partNum, link;
	String[] tags;
	int quantity, unit_cost;
	Inventory inventory;
	private LocalDateTime dateTimeEntered, dateTimeRetrieved, dateTimeReturned;
	
	public Item(String commonName, String id, int amount, String website, int cost){
		name = commonName;
		partNum = id;
		quantity = amount;
		link = website;
		unit_cost = cost;
	}
	
	public Item(String commonName, String id, int amount, String website, int cost, Inventory i){
		name = commonName;
		partNum = id;
		quantity = amount;
		link = website;
		unit_cost = cost;
		inventory=i;
		inventory.addItem(this);
	}
	public boolean retrieve() {
		if(inventory!=null) {
			inventory=null;
			dateTimeRetrieved=LocalDateTime.now();
			return true;
		}
		return false;
	}
	public void replace(Inventory i) {
		inventory=i;
		dateTimeReturned=LocalDateTime.now();
	}
	public String toString() {
		String s="";
		return s;
	}
}


