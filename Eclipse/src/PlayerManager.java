import java.util.*;

public class PlayerManager {
	private static List<Player> players = new ArrayList<Player>();
	private static List<PlayerClass> classes = new ArrayList<PlayerClass>();

	public static void main(String[] args) {
		System.out.println("Game Manager! \n Use integer values to navigate the menu.");
		ask();

	}

	public static void ask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t MAIN MENU" + "\n(1) Create Player \n(2) Manage Player(s)");
		try {
			int option = sc.nextInt();
			if (option == 1) {
				createPlayer();
			} else if (option == 2) {
				manage();
			} else
				ask();
		} catch (InputMismatchException e) {
			System.out.println("Please select an option.");
			ask();
		}
	}
	
	public static void manage(){
		Scanner mscan = new Scanner(System.in);
		System.out.println("\n\t\tPLAYER MENU");
		System.out.println("There are: " + players.size() + " players");
		System.out.println("(1) Player List \n(2) Manage Player \n(3) Delete Player");
		try {
		int option = mscan.nextInt();
		if(option == 1)printNames();
		else manage();
		}
		catch(InputMismatchException e) {
			System.out.println("Please select an option.");
			manage();
		}
	}
	
	public static void printNames() {
		System.out.println("\n\t\t--LIST--");
		for(Player p: players)
			System.out.println(p);
	}

	public static void createPlayer() {
		Scanner pscan = new Scanner(System.in);
		System.out.println("\n\t\tCREATE PLAYER");
		System.out.println("(1) New Adventurer \n(2) New Advanced Player \n(3) Return to main menu");
		try {
			int option = pscan.nextInt();
			if (option == 1) {
				System.out.println("What is the players name?");
				String name = pscan.next();
				Player p = new Player(name);
				System.out.println(p.getName() + " was created.");
				players.add(p);
				ask();
			} else if (option == 2)
				System.out.println("This will create a custom class, please enter all values CAREFULLY. There is no undo.");
				System.out.println("What is the classes name?");
				String cName = pscan.next();
				System.out.println("What is the base armor amount?");
				int armor = pscan.nextInt();
				System.out.println("What is the base mana?");
				int mana = pscan.nextInt();
				System.out.println("What is the base speed?");
				int speed = pscan.nextInt();
				System.out.println("What is the base Health?");
				double maxHealth = pscan.nextDouble();
				PlayerClass c = new Custom(cName, armor, mana, speed, maxHealth);
				System.out.println(c + " class was created.");
				System.out.println("What is the players name?");
				String name = pscan.next();
				Player p = new Player(name, c);
				System.out.println(p.getName() + " was created.");
				players.add(p);
				ask();
			else if(option == 3)
				ask();
			else
				createPlayer();
		} catch (InputMismatchException e) {
			System.out.println("Please select an option.");
			createPlayer();
		}

	}
}
