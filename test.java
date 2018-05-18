import java.util.Scanner;
public class test {
	private static Scanner scan;
	private static Inventory storage;
	public static void main (String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Welcome to the Team 5181 shop inventory");
		storage = new Inventory();
		printMenu();
		dispatch(scan.nextInt());
	}
	public Item createItem(){
		System.out.println("Input name:");
			String name = scan.next();
			System.out.println("Input Part ID:");
			String id = scan.next();
			System.out.println("Input amount:");
			int amount = scan.nextInt();
			System.out.println("Input link:");
			String link = scan.next();
			System.out.println("Input cost:");
			int cost = scan.nextInt();
			return new Item (name, id, amount, link, cost, storage);	
	}
	public static void dispatch(int choice){
		int loc, size;
		switch(choice)
		{
			case 0: 
				System.out.println("Bye!");
				break;
			case 1:
				storage=new Inventory();
				break;
			case 2:
				String s;
				System.out.println("Input a criteria for sorting");
				s=scan.next();
				storage.sort(s);
				break;
			case 3:
				System.out.print("Input your search request");
				List<Item> r=storage.search(scan.next);
				for(int i=0;i<r.size();i++){
					System.out.println(r.get(i));
				}
				break;
			case 4:
				storage.display();
				break;
			case 5:
				String s;
				System.out.println("Input a criteria for sorting");
				s=scan.next();
				storage.sort(s,"descending");
				break;
			case 6:
				System.out.print("Enter the value to look for: ");
				int oldVal=scan.nextInt();
				System.out.println("Enter the value to replace it with");
				int newVal=scan.nextInt();
				list.replaceFirst(oldVal,newVal);
				break;
			case 7:
				System.out.print("Enter the value to look for: ");
				oldVal=scan.nextInt();
				System.out.println("Enter the value to replace it with");
				newVal=scan.nextInt();
				list.replaceAll(oldVal,newVal);
				break;
			case 8:
				int moreItems = 1;
				while (moreItems == 1) {
					storage.add(createItem());
					System.out.println("Would you like to input more items? (1 for yes, anything else for no");
					moreItems = scan.nextInt();
				}
				break;
			case 9:
				System.out.println("Enter an integer to remove from the list.");
				oldVal=scan.nextInt();
				list.removeFirst(oldVal);
				break;
			case 10:
				System.out.println("Enter an integer to remove from the list.");
				oldVal=scan.nextInt();
				list.removeAll(oldVal);
				break;
			case 11:
				System.out.println("Enter an integer to add to the list.");
				newVal=scan.nextInt();
				list.addInOrder(newVal);
				break;
			default:
				System.out.println("Sorry, invalid choice");
		}
    }

   /**
    * Print the user's choices
    */
     
    public static void printMenu()
    {
		System.out.println("\n   Menu   ");
		System.out.println("   ====");
		System.out.println("0: Quit");
		System.out.println("1: Create a new inventory (** do this first!! **)");
		System.out.println("2: Sort the inventory ");
		System.out.println("3: Search the inventory");
		System.out.println("4: Display the inventory");
		System.out.println("5: Sort the inventory in descending order");
		System.out.println("6: Find an item in the inventory and replace the first instance of it with a new item");
		System.out.println("7: Find an item in the inventory and replace all instances of it with a new item");
		System.out.println("8: Add new items to the inventory.");
		System.out.println("9: Remove the first instance of a given item from the inventory.");
		System.out.println("10: Remove all instances of a given item from the inventory.");
		System.out.println("11: Add new items to the inventory in order.");
		System.out.print("\nEnter your choice: ");
    }
}
