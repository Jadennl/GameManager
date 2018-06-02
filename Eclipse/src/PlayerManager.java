import java.util.*;
import java.io.*;

public class PlayerManager {
    private static List<Player> players = new ArrayList<>();
    private static List<PlayerClass> classes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Game Manager! \n Use the numbers on the screen to navigate through the menus.");
        ask();

    }

    public static void ask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t MAIN MENU" + "\n(1) Create Player \n(2) Manage Player(s)\n(3) Export");
        try {
            int option = sc.nextInt();
            if (option == 1) {
                createPlayer();
            } else if (option == 2) {
                manage();
            } else if (option == 3) {
                io();
            } else {
                ask();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please use a number on the screen.");
            ask();
        }
    }

    private static void io() {

        if (players.isEmpty()) {
            System.out.println("There are no players, please create one.");
            ask();
        } else {
            try {
                String[][] stuff = condense();
                String ok, data;
                File file = new File("data.txt");
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for (String[] s : stuff) {
                    for (String s2 : s) {
                        bw.write(s2);
                    }
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static String[][] condense() {
        String[][] data = new String[players.size()][7];
        int x = 0;
        for (Player p : players) {
            data[x][0] = p.getName() + " ";
            data[x][1] = p.getpClass().toString() + " ";
            for (int i = 0; i < 3; i++) {
                data[x][i + 2] = p.getpClass().getStats()[i] + " ";
            }
            data[x][5] = p.getHealth() + " ";
            data[x][6] = p.getpClass().getMax() + " ";
            x++;
        }
        return data;
    }

    public static void manage() {
        Scanner mscan = new Scanner(System.in);
        if (players.isEmpty()) {
            System.out.println("There are no players, please create one.");
            ask();
        } else {
            System.out.println("\n\t\tPLAYER MENU");
            if (players.size() > 1) System.out.println("There are " + players.size() + " players.");
            else System.out.println("There is 1 player.");
            System.out.println("(1) Player List \n(2) Manage Player \n(3) Delete Player \n(4) Return to main menu");
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
            System.out.println("\t(" + x + ") Go back");
            int choice = mscan2.nextInt() - 1;
            if (choice == x - 1) {
                manage();
            } else {
                managePlayer(players.get(choice));
            }
        } catch (InputMismatchException e) {
            System.out.println("Please select a number on the screen.");
            manage2();
        }

    }

    public static void managePlayer(Player p) {
        try {
            Scanner mscan3 = new Scanner(System.in);
            System.out.println("\t\t--" + p.getName() + "'s MENU--");
            System.out.println("(1) Take Damage\n(2) Heal\n(3) Go back");
            int choice = mscan3.nextInt();
            if (choice == 1) {
                Scanner hurtscan = new Scanner(System.in);
                System.out.println("How much damage did " + p.getName() + " take?");
                double d = hurtscan.nextDouble();
                p.hurt(d);
                managePlayer(p);

            } else if (choice == 2) {
                p.heal();
                managePlayer(p);
            } else if (choice == 3) {
                manage2();
            } else {
                managePlayer(p);
            }
        } catch (InputMismatchException e) {
            System.out.print("Please select a number on the screen.");
            managePlayer(p);
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
                "(1) New Default Player\n(2) New Class \n(3) New Player \n(4) New Player and Class \n(5) Return to main menu");
        try {
            int option = pscan.nextInt();
            if (option == 1) {
                System.out.println("What is the player's name?");
                String name = pscan.next();
                Player p = new Player(name);
                System.out.println(p.getName() + " was created.");
                players.add(p);
                ask();
            } else if (option == 2) {
                createClass();
                ask();
            } else if (option == 3) {
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
                        PlayerClass c = createClass();
                        Player p = new Player(pName, c);
                        System.out.println(p.getName() + " was created.");
                        players.add(p);
                        classes.add(c);
                        ask();
                    } else ask();

                }
            } else if (option == 4) {
                PlayerClass c = createClass();
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

    public static PlayerClass createClass() {
        try {
            Scanner pscan = new Scanner(System.in);
            System.out.println("This will create a custom class, please enter all values CAREFULLY. There is no undo.");
            System.out.println("What is the class name?");
            String cName = pscan.next();
            System.out.println("What is the base armor amount?");
            int armor = pscan.nextInt();
            System.out.println("What is the base mana?");
            int mana = pscan.nextInt();
            System.out.println("What is the base speed? (100 is max value)");
            int speed = pscan.nextInt();
            if (speed > 100) speed = 100;
            System.out.println("What is the base Health?");
            double maxHealth = pscan.nextDouble();
            PlayerClass c = new Custom(cName, armor, mana, speed, maxHealth);
            classes.add(c);
            System.out.println(c + " class was created.");
            return c;
        } catch (InputMismatchException e) {
            System.out.println("Invalid value used.");
            return createClass();
        }
    }
}
