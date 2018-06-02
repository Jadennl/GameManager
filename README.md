# GameManager
**Final project for AP Computer Science**

## Purpose
*To inventory and manage characters.*

## Topics implemented:
- [ ] Looping Through Strings
- [x] Lists Interface
- [x] 2D Arrays + Nested Loops
- [X] Interfaces + Abstract Methods
- [ ] Polymorphism
- [ ] Searching + Sorting
- [x] Recursion

### Lists Interface
Lists are used to store custom classes & current players.
#### Example
```Java
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
### 2D Array
A 2d Array is used to import and export data.
### Example
```Java
private static String[][] condense() {
        String[][] data = new String[players.size()][7];
        int x = 0;
        for(Player p: players){
            data[x][0] = p.getName() + " ";
            data[x][1] = p.getpClass().toString() + " ";
            for(int i = 0; i < 3; i++){
                data[x][i+2] = p.getpClass().getStats()[i] + " ";
            }
            data[x][5] = p.getHealth() + " ";
            data[x][6] = p.getpClass().getMax() + " ";
            x++;
        }
        return data;
    }
```
### Abstract Class
Abstract class PlayerClass is used to separate the default Adventurer from custom classes.
#### Example
```Java
public abstract class PlayerClass {
	private String className;
	private int armor;
	private int mana;
	private int speed;
	private double maxHealth;

	public PlayerClass(String pclass, int armor, int mana, int speed, double maxHealth) {
		className = pclass;
		this.armor = armor;
		this.mana = mana;
		this.speed = speed;
		this.maxHealth = maxHealth;
	}

	public int[] getStats() {
		int[] stats = new int[3];
		stats[0] = armor;
		stats[1] = mana;
		stats[2] = speed;
		return stats;
	}

	public double getMax() {
		return maxHealth;
	}

	public String toString() {
		return className;
	}

	abstract double calcHeal();

}

//Adventurer
public class Adventurer extends PlayerClass {

	public Adventurer() {
		super("Adventurer", 75, 20, 10, 100.0);

	}

	public double calcHeal(){
		return 1.0;
	}

}

//Customs abstract method
public double calcHeal(){
		if(getStats()[1] > 100) {
			return getMax() * .25;
		}
		else if(getStats()[1] == 0){
			return 1.0;
		}
		else return getMax() * getStats()[1]/100;
	}
```

### Recursion
Recursive methods are used throughout the entire code to repeat menus. The base case is the method doing its purpose.
#### Example
```Java
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



