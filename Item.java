import java.time.*;
public class Item {
	String name, partNum, link;
	String[] tags;
	int quantity, unit_cost;
	Inventory inventory;
	public LocalDateTime dateTimeEntered, dateTimeRetrieved, dateTimeReturned;
	
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
		if(inventory==null) return "Name: " + name + "\tPart Number: " + partNum + "\tWebsite: " + link + "\tQuantity: " + quantity + "\tUnit cost: " + unit_cost + "\tTotal cost: " + (unit_cost*quantity) +  "\tDate and Time Entered: " + dateTimeEntered + "\tDate and Time Retrieved: " + dateTimeRetrieved + "\tDate and Time Returned: " + dateTimeReturned;
		return "Name: " + name + "\tPart Number: " + partNum + "\tWebsite: " + link + "\tQuantity: " + quantity + "\tUnit cost: " + unit_cost + "\tTotal cost: " + (unit_cost*quantity) + "\tInventory: " + inventory.name + "\tDate and Time Entered: " + dateTimeEntered + "\tDate and Time Retrieved: " + dateTimeRetrieved + "\tDate and Time Returned: " + dateTimeReturned;
	}
}


