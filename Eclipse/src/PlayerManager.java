import java.util.*;

public class PlayerManager {
    private static List<Player> players = new ArrayList<>();
    private static List<PlayerClass> classes = new ArrayList<>();

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

    public static void manage() {
        Scanner mscan = new Scanner(System.in);
        if(players.isEmpty()){
            System.out.println("There are no players, create one.");
            ask();
        }
        System.out.println("\n\t\tPLAYER MENU");
        System.out.println("There are: " + players.size() + " players");
        System.out.println("(1) Player List \n(2) Manage Player \n(3) Delete Player \n(4) Return to main menu." );
        try {
            int option = mscan.nextInt();
            if (option == 1) {
                printNames();
                manage();
            } else
                manage();
        } catch (InputMismatchException e) {
            System.out.println("Please select an option.");
            manage();
        }
    }

    public static void printNames() {
        System.out.println("\n\t\t--LIST--");
        for (Player p : players)
            System.out.println(p);
    }

    public static void createPlayer() {
        Scanner pscan = new Scanner(System.in);
        System.out.println("\n\t\tCREATE PLAYER");
        System.out.println(
                "(1) New Adventurer \n(2) New Advanced Player \n(3) New Player with Custom Class\n(4) Return to main menu");
        try {
            int option = pscan.nextInt();
            if (option == 1) {
                System.out.println("What is the players name?");
                String name = pscan.next();
                Player p = new Player(name);
                System.out.println(p.getName() + " was created.");
                players.add(p);
                ask();
            } else if (option == 2) {
                System.out.println("What is the player's name?");
                String pName = pscan.next();
                if(classes.isEmpty() == false) {
                    System.out.println("The current classes will now print. Please choose one.");
                    int x = 1;
                    for (PlayerClass p : classes) {
                        System.out.println("\t" + "(" + x + ") " + p);
                        x++;
                    }
                    int choice = pscan.nextInt();
                    Player p = new Player(pName, classes.get(choice - 1));
                    System.out.println(p.getName() + " was created.");
                    players.add(p);
                    ask();
                }
                else{
                    System.out.println("No Custom Classes are present. Would you like to create one?");
                }
            } else if (option == 3) {
                PlayerClass c = advPlayer();
                System.out.println(c + " class was created.");
                System.out.println("What is the players name?");
                String name = pscan.next();
                Player p = new Player(name, c);
                System.out.println(p.getName() + " was created.");
                players.add(p);
                classes.add(c);
                ask();
            } else if (option == 4)
                ask();
            else
                createPlayer();
        } catch (InputMismatchException e) {
            System.out.println("Please select an option.");
            createPlayer();
        }

    }

    public static PlayerClass advPlayer() {
        try {
            Scanner pscan = new Scanner(System.in);
            System.out.println(
                    "This will create a custom class, please enter all values CAREFULLY. There is no undo.");
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
            return new Custom(cName, armor, mana, speed, maxHealth);
        } catch (InputMismatchException e) {
            System.out.println("Invalid value used.");
            return advPlayer();
        }
    }
}
