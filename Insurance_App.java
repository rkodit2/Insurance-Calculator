import java.util.ArrayList;
import java.util.Scanner;

public class Insurance_App {
	
	public static void printStars(int howMany) {
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars); 
	}
	
	public static void showMenu() {
		System.out.println("Here are your choices:  ");
		System.out.println("1. List members");
		System.out.println("2. Add a new member");
		System.out.println("3. Save members");
		System.out.println("4. Load members");
		System.out.println("5. Asses members");
		System.out.println("6. Save assessments as JSON");
		System.out.println("7. Exit");
		System.out.println("Please enter the number of your choice: ");
	}
	
	public static void printWelcome() {
		printStars(40);
		System.out.println("         INSURANCE SCORE CARD\r\n" +
				"  This app scores a potential customer\r\n" + 
				"  on various health attributes: blood\r\n" + 
				"  pressure, age, height, weight, and\r\n" + 
				"  family history of disease. It writes\r\n" + 
				"  each member's insurance grade to a\r\n" + 
				"  JSON file so that they can be easily\r\n" + 
				"  shared on a web-based data exchange.\r\n");
		printStars(40);
	}
	
	public static void printExit() {
		printStars(50);
		System.out.println("INSURANCE SCORE CARD");
		System.out.println("THANK YOU");
	}

	public static void main(String[] args) {
		printWelcome();
		
		Scanner sc = new Scanner(System.in);
		int choice;
	
		System.out.println("Enter the name of member file: ");
		String fname;
		fname = sc.nextLine();
		ArrayList<Member> membs = new ArrayList<Member>();
		do {
			showMenu();
			choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				
			} else if (choice == 2) {
				
			} else if (choice == 3) {
				
			} else if (choice == 4) {
				
			} else if (choice == 5) {
			
			} else if (choice == 6) {
				
			}
			
		} while (choice != 7);
		printExit();

	}

}
