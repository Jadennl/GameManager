# GameManager
**Final project for AP Computer Science**

## Purpose
To inventory and manage characters.

## Topics implemented:
-[] Looping Through Strings
-[x] Lists Interface
-[] 2D Arrays + Nested Loops
-[] Interfaces + Abstract Methods
-[] Polymorphism
-[] Searching + Sorting
-[x] Recursion

### Lists Interface
Lists are used to store custom classes & current players.
#### example
```java
private static List<Player> players = new ArrayList<>();
private static List<PlayerClass> classes = new ArrayList<>();

public static void printNames() {
        System.out.println("\n\t\t--PLAYER LIST--");
        for (Player p : players)
            System.out.println(p);
            }

//here is an excerpt from createPlayer()
System.out.println("The current custom classes will now print. Please choose one.");
                    int x = 1;
                    for (PlayerClass p : classes) {
                        System.out.println("\t" + "(" + x + ") " + p);
                        x++;
                    }
                    int choice = pscan.nextInt();
```


### Recursion
Recursive methods are used throughout the entire code to repeat menus. The base case is the method doing its purpose.
#### example
```java
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
   ```



