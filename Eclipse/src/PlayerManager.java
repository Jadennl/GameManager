import java.util.*;

public class PlayerManager {
    private static List<Player> players = new ArrayList<>();
    private static List<PlayerClass> classes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Game Manager! \n Use the numbers on the screen to navigate through the menus.");
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
            System.out.println("Please use a number on the screen.");
            ask();
        }
    }

    public static void manage() {
        Scanner mscan = new Scanner(System.in);
        if (players.isEmpty()) {
            System.out.println("There are no players, please create one.");
            ask();
        }
        System.out.println("\n\t\tPLAYER MENU");
        System.out.println("There are: " + players.size() + " players");
        System.out.println("(1) Player List \n(2) Manage Player \n(3) Delete Player \n(4) Return to main menu.");
        try {
            int option = mscan.nextInt();
            if (option == 1) {
                printNames();
                manage();
            } else if (option == 2) {
                manage2();
            } else if (option == 3) {
                System.out.println("Which player would you like to delete?\nWARNING: This cannot be undone.");
                int x = 1;
                try {
                    for (Player p : players) {
                        System.out.println("\t(" + (x) + ") " + p.getName());
                        x++;
                    }
                    int woah = mscan.nextInt() - 1;
                    double rand = Math.random();
                    if (rand > .4) {
                        System.out.println(players.remove(woah).getName() + " has been removed.");
                        ask();
                    } else {
                        System.out.println("GOOODBYEEE" + players.remove(woah).getName() + "!");
                        ask();
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Please select a number on the screen.");
                    manage();
                }

            } else if (option == 4) {
                ask();
            } else {
                manage();
            }

        } catch (InputMismatchException e) {
            System.out.println("Please select a number on the screen.");
            manage();
        }
    }

    public static void manage2() {
        Scanner mscan2 = new Scanner(System.in);
        try {
            System.out.println("\t\t--PLAYER MENU--\nChoose a player to manage:");
            int x = 1;
            for (Player p : players) {
                System.out.println("\t" + "(" + x + ") " + p);
                x++;
            }
            int choice = mscan2.nextInt() - 1;
            System.out.println("\t\t--" + players.get(choice).getName() + " MENU--");
        } catch (InputMismatchException e) {
            System.out.println("Please select a number on the screen");
            manage2();
        }

    }

    public static void printNames() {
        System.out.println("\n\t\t--PLAYER LIST--");
        for (Player p : players)
            System.out.println(p);
    }

    public static void createPlayer() {
        Scanner pscan = new Scanner(System.in);
        System.out.println("\n\t\tCREATE PLAYER");
        System.out.println(
                "(1) New Default Player\n(2) New Class \n(3) New Player \n(4) New Player and Custom Class \n(5) Return to main menu");
        try {
            int option = pscan.nextInt();
            if (option == 1) {
                System.out.println("What is the player's name?");
                String name = pscan.next();
                Player p = new Player(name);
                System.out.println(p.getName() + " was created.");
                players.add(p);
                ask();
            } else if (option == 2) advPlayer();
            else if (option == 3) {
                System.out.println("What is the player's name?");
                String pName = pscan.next();
                if (classes.isEmpty() == false) {
                    System.out.println("The current custom classes will now print. Please choose one.");
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
                } else {
                    System.out.println("No custom classes exist. Would you like to create one?\n(1) Yes \nEnter any other number for no.");
                    if (pscan.nextInt() == 1) {
                        PlayerClass c = advPlayer();
                        Player p = new Player(pName, c);
                        System.out.println(p.getName() + " was created.");
                        players.add(p);
                        classes.add(c);
                        ask();
                    } else ask();

                }
            } else if (option == 4) {
                PlayerClass c = advPlayer();
                classes.add(c);
                System.out.println(c + " class was created.");
                System.out.println("What is the player's name?");
                String name = pscan.next();
                Player p = new Player(name, c);
                System.out.println(p.getName() + " was created.");
                players.add(p);
                ask();
            } else if (option == 5)
                ask();
            else
                createPlayer();
        } catch (InputMismatchException e) {
            System.out.println("Please select a number on the screen.");
            createPlayer();
        }

    }

    public static PlayerClass advPlayer() {
        try {
            Scanner pscan = new Scanner(System.in);
            System.out.println("This will create a custom class, please enter all values CAREFULLY. There is no undo.");
            System.out.println("What is the class name?");
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
