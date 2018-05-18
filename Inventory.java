import java.util.*;
public class Inventory {
	int totalValue;
	private final int MAX_ITEMS;
	int numItems;
	ArrayList<Item> items;
	public Inventory(){
		totalValue=0;
		items=new ArrayList<Item>();
		MAX_ITEMS=500;
	}
	public boolean addItem(Item i) {
		if(numItems==MAX_ITEMS)
			return false;
		items.add(i);
		numItems+=i.quantity;
		totalValue+=i.unit_cost*i.quantity;
		return true;
	}
	public boolean addItem(Item i, int q) {
		if(numItems==MAX_ITEMS)
			return false;
		items.add(new Item(i.name,i.partNum,q,i.link,i.unit_cost,this));
		i.quantity-=q;
		numItems+=q;
		totalValue+=i.unit_cost*q;
		return true;
	}
	public Item retrieve(int i) {
		items.get(i).retrieve();
		return items.remove(i);
	}
	public List<String> analyze() {
		ArrayList<String> report=new ArrayList<String>();
		for(int i=0;i<items.size();i++) {
			report.add(items.get(i).toString());
		}
		return report;
	}
	public void display() {
		System.out.println("\n--------------------\n     Inventory:     \nPart Name\t|Quantity\t|Part Number\t|Unit Cost\t|Link");
		for(int i=0;i<items.size();i++){
			System.out.println(items.get(i)
		}
	}
	//searches the inventory and returns an unsorted array list of items that meet the search criteria
	public ArrayList<Item> search(String searchCriteria){
		for(int i=0;i<items.size();i++){
			
		}
	}
	//searches the inventory and returns a priority queue of items that meet the search criteria sorted by a given metric
	public PriorityQueue<Item> search(String searchCriteria, String sortBy){
		PriorityQueue<Item> results=new PriorityQueue<Item>(10, new compareItems(sortBy));
		return results;
	}
	public PriorityQueue<Item> search(String searchCriteria, String sortBy, int numResults){
		PriorityQueue<Item> results=new PriorityQueue<Item>(numResults, new compareItems(sortBy));
		//iterates through items and adds items that meet the search criteria to results
		for(int i=0;i<items.size();i++){
			//if(/*some expression */)
				//results.add(items.get(i));
		}
		return results;
	}
	public class compareItems implements Comparator<Item>{
		String compareBy, order;
		public compareItems(String compBy){
			compareBy=compBy;
			order="ascending";
		}
		public compareItems(String compBy, String ascDesc){
			compareBy=compBy;
			order=ascDesc;
		}
		public int compare(Item x, Item y){
			if(compareBy.equals("quantity))
				if(order.equals("ascending") return x.quantity-y.quantity;
				return y.quantity-x.quantity;
			if(compareBy.equals("unit_cost"))
				if(order.equals("ascending") return x.unit_cost-y.unit_cost;
				return y.unit_cost-x.unit_cost;
			if(compareBy.equals("dateTimeEntered"))
				if(order.equals("ascending") return x.dateTimeEntered.compareTo(y.dateTimeEntered);
				return y.dateTimeEntered.compareTo(x.dateTimeEntered);
			return 0;
		}
	}
}
