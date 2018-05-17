import java.util.Scanner;
public class test {
	public static void main (String[] args) {
		System.out.println("Welcome to the Team 5181 shop inventory");
		Inventory storage = new Inventory();
		int moreItems = 1;
		Scanner scan = new Scanner(System.in);
		while (moreItems == 1) {
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
			Item test = new Item (name, id, amount, link, cost, storage);
			
			System.out.println("Would you like to input more items? (1 for yes, anything else for no");
			moreItems = scan.nextInt();
		}
	}
}
