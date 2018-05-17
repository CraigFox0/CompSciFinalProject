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
	public void Display() {
		
	}
	}
