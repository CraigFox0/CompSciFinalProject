import java.util.*;
public class Inventory {
	int totalValue;
	final int MAX_ITEMS;
	int numItems;
	String id;
	ArrayList<Item> items;
	public Inventory(String name){
		id = name;
		totalValue=0;
		items=new ArrayList<Item>();
		MAX_ITEMS=500;
		numItems=0;
	}
	public Inventory(String name, ArrayList<Item> i){
		id = name;
		totalValue=0;
		numItems=0;
		for(int j=0;j<i.size();j++){
			totalValue+=i.get(j).unit_cost*i.get(j).quantity;
			numItems+=i.get(j).quantity;
		}
		items=i;
		MAX_ITEMS=500;
	}
	public Inventory(String name, Inventory i){
		id = name;
		totalValue=i.totalValue;
		items=i.items;
		MAX_ITEMS=i.MAX_ITEMS;
		numItems=i.numItems;
	}
	public void sort(String cmprBy){
		items.sort(new CompareItems(cmprBy));
	}
	public void sort(String cmprBy, String ascdesc){
		items.sort(new CompareItems(cmprBy,ascdesc));
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
			System.out.println(items.get(i).name+"\t"+items.get(i).quantity+"\t"+items.get(i).partNum+"\t"+items.get(i).unit_cost+"\t"+items.get(i).link);
		}
		System.out.println("--End of Inventory--");
	}
	//searches the inventory and returns an array list of items that meet the search criteria sorted by relevance
	public ArrayList<Item> search(String searchCriteria){
		ArrayList<Item> results=new ArrayList<Item>();
		int relevance=0;
		for(int i=0;i<items.size();i++){
			if(items.get(i).name.contains(searchCriteria)) relevance+=3;
			if(items.get(i).name.equals(searchCriteria)) relevance+=5;
			if(items.get(i).partNum.contains(searchCriteria)) relevance+=3;
			if(items.get(i).partNum.equals(searchCriteria)) relevance+=5;
			if(items.get(i).link.contains(searchCriteria)) relevance+=3;
			if(items.get(i).link.equals(searchCriteria)) relevance+=5;
			if(Math.abs(items.get(i).quantity-Integer.parseInt(searchCriteria))<2) relevance+=2;
			if(items.get(i).unit_cost==Integer.parseInt(searchCriteria)) relevance+=5;
			if(Math.abs(items.get(i).unit_cost-Integer.parseInt(searchCriteria))<2) relevance+=2;
			if(items.get(i).quantity==Integer.parseInt(searchCriteria)) relevance+=5;
			for(int j=0;j<items.get(i).tags.length;j++){
				if(items.get(i).tags[j].equals(searchCriteria)) relevance++;
			}
		}
	}
	//searches the inventory and returns a priority queue of items that meet the search criteria sorted by a given metric
	public PriorityQueue<Item> search(String searchCriteria, String sortBy){
		PriorityQueue<Item> results=new PriorityQueue<Item>(10, new CompareItems(sortBy));
		for(int i=0;i<items.size();i++){
			if(items.get(i).name.equals(searchCriteria)) results.add(items.get(i));
			if(items.get(i).partNum.equals(searchCriteria)) results.add(items.get(i));
			if(items.get(i).link.equals(searchCriteria)) results.add(items.get(i));
			if(items.get(i).unit_cost==Integer.parseInt(searchCriteria)) results.add(items.get(i));
			if(items.get(i).quantity==Integer.parseInt(searchCriteria)) results.add(items.get(i));
			for(int j=0;j<items.get(i).tags.length;j++){
				if(items.get(i).tags[j].equals(searchCriteria)) results.add(items.get(i));
			}
		}
		return results;
	}
	public PriorityQueue<Item> search(String searchCriteria, String sortBy, int numResults){
		PriorityQueue<Item> results=new PriorityQueue<Item>(numResults, new CompareItems(sortBy));
		//iterates through items and adds items that meet the search criteria to results
		for(int i=0;i<items.size();i++){
			if(items.get(i).name.equals(searchCriteria)) results.add(items.get(i));
			if(items.get(i).partNum.equals(searchCriteria)) results.add(items.get(i));
			if(items.get(i).link.equals(searchCriteria)) results.add(items.get(i));
			if(items.get(i).unit_cost==Integer.parseInt(searchCriteria)) results.add(items.get(i));
			if(items.get(i).quantity==Integer.parseInt(searchCriteria)) results.add(items.get(i));
			for(int j=0;j<items.get(i).tags.length;j++){
				if(items.get(i).tags[j].equals(searchCriteria)) results.add(items.get(i));
			}
		}
		return results;
	}
	public class CompareItems implements Comparator<Item>{
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
			if(compareBy.equals("quantity")) {
				if(order.equals("ascending")) {
					return x.quantity-y.quantity;
			}
				return y.quantity-x.quantity;
		}
			if(compareBy.equals("unit_cost")) {
				if(order.equals("ascending")) {
					return x.unit_cost-y.unit_cost;
				}
				return y.unit_cost-x.unit_cost;
			}
			if(compareBy.equals("dateTimeEntered")) {
				if(order.equals("ascending")) {
					return x.dateTimeEntered.compareTo(y.dateTimeEntered);
				}
				return y.dateTimeEntered.compareTo(x.dateTimeEntered);
			}
			if(compareBy.equals("dateTimeRetrieved")) {
				if(order.equals("ascending")) {
					return x.dateTimeRetrieved.compareTo(y.dateTimeRetrieved);
			}
				return y.dateTimeRetrieved.compareTo(x.dateTimeRetrieved);
		}
			if(compareBy.equals("dateTimeReturned")) {
				if(order.equals("ascending")) {
					return x.dateTimeReturned.compareTo(y.dateTimeReturned);
				}
				return y.dateTimeReturned.compareTo(x.dateTimeReturned);
			}
			if(compareBy.equals("name")) {
				if(order.equals("ascending")) {
					return x.name.compareTo(y.name);
				}
				return y.name.compareTo(x.name);
			}
			if(compareBy.equals("partNum")) {
				if(order.equals("ascending")) {
					return x.partNum.compareTo(y.partNum);
				}
				return y.partNum.compareTo(x.partNum);
			}
			if(compareBy.equals("link")) {
				if(order.equals("ascending")) {
					return x.link.compareTo(y.link);
				}
				return y.link.compareTo(x.link);
			}
			return 0;
		}
	}
}
