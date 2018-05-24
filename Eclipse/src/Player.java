import java.util.*;

public class Player {
	private PlayerClass pClass;
	private String name;
	private int  armor, mana, speed;
	private double health;
	private double maxHealth;

	public Player(String name) {
		pClass = new Adventurer();
		armor = pClass.getStats()[0];
		mana = pClass.getStats()[1];
		speed = pClass.getStats()[2];
		maxHealth = pClass.getMax();
		health = maxHealth;
		this.setName(name);
	}
	
	public Player(String name, PlayerClass pClass) {
		this.pClass = pClass;
		armor = pClass.getStats()[0];
		mana = pClass.getStats()[1];
		speed = pClass.getStats()[2];
		maxHealth = pClass.getMax();
		health = maxHealth;
		this.setName(name);
	}
	
	public void hurt(int amount) {
		double dmgMult = 100 / (100 + armor);
		health -= (amount * dmgMult);
		System.out.println(name + " took " + amount * dmgMult + "damage" );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name + " [" + pClass +  "]: " + health + "/" + maxHealth + " HP";
	}
	
}
