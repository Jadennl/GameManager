import java.util.*;

public class PlayerManager {
private List<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		System.out.println("Game Manager!");
		ask();

	}

	public static void ask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t MENU" + "\n(1) Create Character \n(2) Manage Character(s)");
		System.out.println("\tPlease type your option: ");
		try {
			int option = sc.nextInt();
			sc.close();
			if (option == 1)
				createPlayer();
			else if (option == 2)
				System.out.println("bar");
			else
				ask();
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Please use an integer ");
			ask();
		}
	}
	
	public Player createPlayer() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("\n\t\tPLAYER MENU");
		System.out.println("(1) New Basic Character \n(2) New Advanced Character");
		try {
			int option = sc.nextInt();
			sc.close();
			if (option == 1)
				createPlayer();
			else if (option == 2)
				System.out.println("bar");
			else
				ask();
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Please use an integer ");
			ask();
		}
	}
}
