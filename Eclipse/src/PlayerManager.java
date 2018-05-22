import java.util.*;

public class PlayerManager {
	private static List<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		System.out.println("Game Manager!");
		ask();

	}

	public static void ask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t MAIN MENU" + "\n(1) Create Player \n(2) Manage Player(s)");
		System.out.println("\tPlease type your option: ");
		try {
			int option = sc.nextInt();
			if (option == 1) {
				createPlayer();
			} else if (option == 2) {
				manage();
			} else
				ask();
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Please use an integer ");
			ask();
		}
	}
	
	public static void manage(){
		Scanner mscan = new Scanner(System.in);
		System.out.println("\n\t\tPLAYER MENU");
		System.out.println("There are: " + players.size() + " players");
		System.out.println("(1) Player List \n(2) Manage Player \n(3) Delete Player");
	}

	public static void createPlayer() {
		Scanner pscan = new Scanner(System.in);
		System.out.println("\n\t\tCREATE PLAYER");
		System.out.println("(1) New Basic Player \n(2) New Advanced Player \n(3) return to main menu");
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
				System.out.println("bar");
			else if(option == 3)
				ask();
			else
				createPlayer();
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Please use an integer ");
			createPlayer();
		}

	}
}
