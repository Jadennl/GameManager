import java.util.*;

public class Player {
	private PlayerClass pClass;
	private String name;
	private int  armor, mana, speed;
	private double health;
	private double maxHealth;
	Backpack items = new Backpack(10);

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

	public Backpack getInv(){
		return items;
	}
	
	public void hurt(double amount) {
		double dmgMult = (-44.14599735755 + 20.609302638349 * Math.log(armor))/100;
		double damage = amount * dmgMult;
		damage = (double)Math.round(damage * 100d) / 100d;
		health -= damage;
		System.out.println(name + " took " + damage + " damage" );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		if( health > 0) {
			return name + " [" + pClass + "]: " + health + "/" + maxHealth + " HP";
		}
		else return name + " [" + pClass + "]: **DEAD**";
	}
	
}
