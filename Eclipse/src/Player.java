import java.util.*;

public class Player {
	private PlayerClass pClass;
	private String name;
	private int  armor, mana, magicR, speed;
	private double health;

	public Player(String name) {
		health = 100;
		mana = 100;
		armor = 10;
		magicR = 5;
		speed = 20;
		this.name = name;
	}
	
	public void hurt(int amount) {
		double dmgMult = 100 / (100 + armor);
		health -= (amount * dmgMult);
	}
}
